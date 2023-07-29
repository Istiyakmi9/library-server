package com.libraryserver.controller;

import com.libraryserver.entity.StudentDetail;
import com.libraryserver.model.ApiResponse;
import com.libraryserver.serviceImpl.StudentDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/studentDetail")
public class StudentDetailController {

    @Autowired
    StudentDetailServiceImpl studentDetailServiceImpl;

    @PostMapping("/addStudentDetail")
    public ResponseEntity<ApiResponse> addStudentDetail( @RequestBody StudentDetail studentDetail ){
        var result = this.studentDetailServiceImpl.addStudentDetailService(studentDetail);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @GetMapping("/getAllStudentDetail")
    public ResponseEntity<ApiResponse> getAllStudentDetail(){
        ArrayList<StudentDetail> result = this.studentDetailServiceImpl.getAllStudentDetail();
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }


}
