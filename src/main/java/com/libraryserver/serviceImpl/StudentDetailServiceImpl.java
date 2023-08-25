package com.libraryserver.serviceImpl;

import com.libraryserver.entity.FileDetail;
import com.libraryserver.entity.StudentDetail;
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

@Service
public class StudentDetailServiceImpl implements StudentDetailService {

    @Autowired
    StudentDetailRepository studentDetailRepository;

    @Autowired
    FileDetailRepository fileDetailRepository;
    @Autowired
    FileStorageProperties fileStorageProperties;

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
        if (!file.isEmpty()){
            String oldFilePath = "";
            FileDetail fileDetail = uploadFile(file, studentDetail.getUserId(), "student_" + studentDetail.getUserId(), oldFilePath);
            if (fileDetail != null){
                FileDetail lastFileDetail = fileDetailRepository.getLastFileDetail();
                if (lastFileDetail == null)
                    fileDetail.setFileId(1L);
                else
                    fileDetail.setFileId(lastFileDetail.getFileId() + 1);

                studentDetail.setFileId(fileDetail.getFileId());
                fileDetail.setFileOwnerId(studentDetail.getUserId());
                fileDetail.setCreatedBy(studentDetail.getUserId());
                fileDetail.setCreatedOn(studentDetail.getCreatedOn());
                fileDetailRepository.save(fileDetail);
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

    public ArrayList<StudentDetail> getAllStudentDetail() {
        List<StudentDetail> result = this.studentDetailRepository.findAll();
        List<FileDetail> fileDetails = fileDetailRepository.findAll();
        result.forEach(x -> {
            var file = fileDetails.stream().filter(i -> i.getFileId() == x.getFileId()).findFirst();
            if (file.isPresent()) {
                var fileDetail = file.get();
                x.setFilePath(Paths.get(fileDetail.getFilePath(), fileDetail.getFileName() + "." + fileDetail.getFileExtension()).toString());
            }
        });
        return (ArrayList<StudentDetail>) result;
    }

    public StudentDetail updateStudentDetailService(StudentDetail studentDetail, long userId) throws Exception {
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

        this.studentDetailRepository.save(existingstudentDetail);
        return existingstudentDetail;
    }
}
