package com.libraryserver.service;

import com.libraryserver.entity.StudentDetail;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Optional;


public interface StudentDetailService {

    public String addStudentDetailService(StudentDetail studentDetail, MultipartFile file) throws Exception;
    public StudentDetail updateStudentDetailService(StudentDetail studentDetail, MultipartFile file, long studentId) throws Exception;
    public ArrayList<StudentDetail> getAllStudentDetail();
    public Optional<StudentDetail> getStudentDetailByStudentIdService(long studentId);
}
