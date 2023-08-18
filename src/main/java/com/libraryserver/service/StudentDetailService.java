package com.libraryserver.service;

import com.libraryserver.entity.StudentDetail;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;


public interface StudentDetailService {

    public String addStudentDetailService(StudentDetail studentDetail, MultipartFile file) throws Exception;
    public ArrayList<StudentDetail> getAllStudentDetail();
}
