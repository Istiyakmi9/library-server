package com.libraryserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.libraryserver.entity.StudentDetail;
import com.libraryserver.model.ApiResponse;
import com.libraryserver.serviceImpl.StudentDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/studentDetail")
public class StudentDetailController {

    @Autowired
    StudentDetailServiceImpl studentDetailServiceImpl;
    @Autowired
    ObjectMapper objectMapper;


    @PostMapping("/addStudentDetail")
    public ResponseEntity<ApiResponse> addStudentDetail(@RequestParam("studentDetail") String student,
                                                        @RequestParam(value = "profile", required = false) MultipartFile file) throws Exception {
        StudentDetail studentDetail = objectMapper.readValue(student, StudentDetail.class);
        var result = this.studentDetailServiceImpl.addStudentDetailService(studentDetail, file);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @PutMapping("/updateStudentDetail/{userId}")
    public ResponseEntity<ApiResponse> updateStudentDetail(@RequestParam ("studentDetail") String student,
                                                           @RequestParam(value = "profile", required = false) MultipartFile file,
                                                           @PathVariable("userId") long userId ) throws Exception {
        StudentDetail studentDetail = objectMapper.readValue(student, StudentDetail.class);
        var result = this.studentDetailServiceImpl.updateStudentDetailService(studentDetail, file, userId);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @GetMapping("/getAllStudentDetail")
    public ResponseEntity<ApiResponse> getAllStudentDetail(){
        ArrayList<StudentDetail> result = this.studentDetailServiceImpl.getAllStudentDetail();
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }
}
