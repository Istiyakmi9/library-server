package com.libraryserver.serviceImpl;

import com.libraryserver.entity.StudentDetail;
import com.libraryserver.repository.StudentDetailRepository;
import com.libraryserver.service.StudentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentDetailServiceImpl implements StudentDetailService {

    @Autowired
    StudentDetailRepository studentDetailRepository;



    public String addStudentDetailService(StudentDetail studentDetail) throws Exception {
        Date utilDate = new Date();
        var date = new Timestamp(utilDate.getTime());
        Optional<StudentDetail> lastUserId = Optional.ofNullable(this.studentDetailRepository.getLastUserId());
        if (lastUserId.isEmpty())
            studentDetail.setUserId(1L);
        else
            studentDetail.setUserId(lastUserId.get().getUserId()+1);
        studentDetail.setCreatedOn(date);
        this.studentDetailRepository.save(studentDetail);
        return " New Student detail has been added";
    }

    public ArrayList<StudentDetail> getAllStudentDetail() {
        List<StudentDetail> result = this.studentDetailRepository.findAll();
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
        existingstudentDetail.setImageProfile(studentDetail.getImageProfile());
        existingstudentDetail.setUpdatedBy(userId);
        existingstudentDetail.setUpdatedOn(date);

        this.studentDetailRepository.save(existingstudentDetail);
        return existingstudentDetail;
    }
}
