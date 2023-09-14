package com.libraryserver.serviceImpl;

import com.libraryserver.entity.FileDetail;
import com.libraryserver.entity.StudentDetail;
import com.libraryserver.helper.HelperStudentDetailExcelUpload;
import com.libraryserver.model.FileStorageProperties;
import com.libraryserver.repository.FileDetailRepository;
import com.libraryserver.repository.StudentDetailRepository;
import com.libraryserver.service.StudentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StudentDetailServiceImpl implements StudentDetailService {

    @Autowired
    StudentDetailRepository studentDetailRepository;

    @Autowired
    FileDetailRepository fileDetailRepository;
    @Autowired
    FileStorageProperties fileStorageProperties;

    @Autowired
    HelperStudentDetailExcelUpload helperStudentDetailExcelUpload;
    Logger logger = LoggerFactory.getLogger(StudentDetailServiceImpl.class);

    @Transactional(rollbackFor = Exception.class)
    public String addStudentDetailService(StudentDetail studentDetail, MultipartFile file) throws Exception {
        Date utilDate = new Date();
        var date = new Timestamp(utilDate.getTime());
        Optional<StudentDetail> lastUserId = Optional.ofNullable(this.studentDetailRepository.getLastUserId());
        if (lastUserId.isEmpty())
            studentDetail.setUserId(1L);
        else
            studentDetail.setUserId(lastUserId.get().getUserId()+1);

        studentDetail.setCreatedOn(date);
        studentDetail.setFileId(0L);
        uploadStudentImage(studentDetail, file);
        this.studentDetailRepository.save(studentDetail);
        return " New Student detail has been added";
    }
    private void  uploadStudentImage(StudentDetail studentDetail, MultipartFile file) throws Exception {
        if (file != null && !file.isEmpty()){
            String oldFilePath = "";
            FileDetail existFileDetail = null;
            if (studentDetail.getFileId() > 0) {
                existFileDetail = fileDetailRepository.getById(studentDetail.getFileId());
                if(existFileDetail != null )
                    oldFilePath = existFileDetail.getFileName()+"."+existFileDetail.getFileExtension();
            }

            FileDetail fileDetail = uploadFile(file, studentDetail.getUserId(), "student_" + studentDetail.getUserId(), oldFilePath);
            if (fileDetail != null){
                if (existFileDetail == null){
                    FileDetail lastFileDetail = fileDetailRepository.getLastFileDetail();
                    if (lastFileDetail == null)
                        fileDetail.setFileId(1L);
                    else
                        fileDetail.setFileId(lastFileDetail.getFileId() + 1);

                    studentDetail.setFileId(fileDetail.getFileId());
                    fileDetail.setFileOwnerId(studentDetail.getUserId());
                    existFileDetail = fileDetail;
                }else {
                    existFileDetail.setFileName(fileDetail.getFileName());
                    existFileDetail.setFilePath(fileDetail.getFilePath());
                    existFileDetail.setFileExtension(fileDetail.getFileExtension());
                }

                existFileDetail.setCreatedBy(studentDetail.getUserId());
                existFileDetail.setCreatedOn(studentDetail.getCreatedOn());
                fileDetailRepository.save(existFileDetail);
            }
        }
    }

    private FileDetail uploadFile(MultipartFile file, long userId, String fileName, String existingFilePath) throws Exception {
        FileDetail fileDetail = null;
        String name = file.getOriginalFilename();
        if (file != null && name != null && !name.isEmpty()){
            fileDetail = new FileDetail();
            String ext = name.substring(name.lastIndexOf(".") + 1);
            String nameOnly = name.substring(0, name.lastIndexOf("."));
            String relativePath = "student";

            if(name.contains(".."))
                throw new Exception("File name contain invalid character.");

            var basePath = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize().toString();
            Path targetDirectory = Paths.get(basePath, relativePath)
                    .toAbsolutePath()
                    .normalize();
            if(Files.notExists(targetDirectory))
                Files.createDirectories(targetDirectory);

            String newFileName = null;
            if (fileName.isEmpty()) {
                fileDetail.setFileName(nameOnly);
                newFileName = nameOnly;
            } else {
                fileDetail.setFileName(fileName);
                newFileName = fileName + "." + ext;
            }

            Path targetPath = targetDirectory.resolve(newFileName);

            if (!existingFilePath.isEmpty()) {
                var existingFile = targetDirectory.resolve(existingFilePath);
                if(Files.exists(existingFile))
                    Files.delete(existingFile);
            }

            Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

            fileDetail.setFilePath(relativePath);
            fileDetail.setFileExtension(ext);
        }
        return fileDetail;
    }

    @Transactional(rollbackFor = Exception.class)
    public StudentDetail updateStudentDetailService(StudentDetail studentDetail, MultipartFile file, long userId) throws Exception {
        java.util.Date utilDate = new Date();
        var date = new Timestamp(utilDate.getTime());
        Optional<StudentDetail> result = this.studentDetailRepository.findById(userId);
        if (result.isEmpty())
            throw new Exception();
        StudentDetail existingstudentDetail = result.get();
        existingstudentDetail.setStudentName(studentDetail.getStudentName());
        existingstudentDetail.setMobile(studentDetail.getMobile());
        existingstudentDetail.setEmail(studentDetail.getEmail());
        existingstudentDetail.setSeatNo(studentDetail.getSeatNo());
        existingstudentDetail.setAmount(studentDetail.getAmount());
        existingstudentDetail.setDateOfJoining(studentDetail.getDateOfJoining());
        existingstudentDetail.setDateOfFeesPayment(studentDetail.getDateOfFeesPayment());
        existingstudentDetail.setLockerFesility(studentDetail.getLockerFesility());
        existingstudentDetail.setLockerNo(studentDetail.getLockerNo());
        existingstudentDetail.setLockerFees(studentDetail.getLockerFees());
        existingstudentDetail.setRefIdCardIssued(studentDetail.getRefIdCardIssued());
        existingstudentDetail.setRefIdCardIssueDate(studentDetail.getRefIdCardIssueDate());
        existingstudentDetail.setCardDeposit(studentDetail.getCardDeposit());
        existingstudentDetail.setRemarks(studentDetail.getRemarks());
        existingstudentDetail.setUpdatedBy(userId);
        existingstudentDetail.setUpdatedOn(date);

        uploadStudentImage(existingstudentDetail, file);
        this.studentDetailRepository.save(existingstudentDetail);
        return existingstudentDetail;
    }

    public ArrayList<StudentDetail> getAllStudentDetail() {
        logger.info("getall studentdetail Method start here");
        List<StudentDetail> result = this.studentDetailRepository.findAll();
        logger.info("Method end here");
        return (ArrayList<StudentDetail>) result;
    }
    public Optional<StudentDetail> getStudentDetailByUserIdService(long userId) {
        Optional<StudentDetail> result = this.studentDetailRepository.findById(userId);
        Optional<FileDetail> fileDetail = fileDetailRepository.findById(result.get().getFileId());
        fileDetail.ifPresent(detail -> result.get().setFilePath(Paths.get(detail.getFilePath(), detail.getFileName() + "." + detail.getFileExtension()).toString()));
        return result;
    }

    public void saveStudentDetailExcelFile (MultipartFile file){
        try {
            List<StudentDetail> studentDetails = helperStudentDetailExcelUpload.convertStudentDetailExcelToList(file.getInputStream());
            this.studentDetailRepository.saveAll(studentDetails);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
