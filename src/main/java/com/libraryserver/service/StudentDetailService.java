package com.libraryserver.service;

import com.libraryserver.entity.StudentDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Optional;


public interface StudentDetailService {

    public String addStudentDetailService(StudentDetail studentDetail, MultipartFile file) throws Exception;
    public ArrayList<StudentDetail> getAllStudentDetail();
    public Optional<StudentDetail> getStudentDetailByUserIdService(long userId);
}
