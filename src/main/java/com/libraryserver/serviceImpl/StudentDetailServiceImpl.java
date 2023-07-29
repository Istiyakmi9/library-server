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

@Service
public class StudentDetailServiceImpl implements StudentDetailService {

    @Autowired
    StudentDetailRepository studentDetailRepository;

    public String addStudentDetailService(StudentDetail studentDetail) {
        Date utilDate = new Date();
        var date = new Timestamp(utilDate.getTime());
        studentDetail.setCreatedOn(date);
        this.studentDetailRepository.save(studentDetail);
        return " New Student detail has been added";
    }

    public ArrayList<StudentDetail> getAllStudentDetail() {
        List<StudentDetail> result = this.studentDetailRepository.findAll();
        return (ArrayList<StudentDetail>) result;
    }
}
