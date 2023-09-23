package com.libraryserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.libraryserver.entity.StudentDetail;
import com.libraryserver.helper.HelperCheckExcelFormat;
import com.libraryserver.model.ApiResponse;
import com.libraryserver.serviceImpl.StudentDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/studentDetail")
public class StudentDetailController {

    @Autowired
    StudentDetailServiceImpl studentDetailServiceImpl;
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    HelperCheckExcelFormat helperCheckExcelFormat;

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

    @GetMapping("/getStudentDetailByUserId/{userId}")
    public ResponseEntity getStudentDetailByUserId(@PathVariable("userId") long userId){
        var result = this.studentDetailServiceImpl.getStudentDetailByUserIdService(userId);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @PostMapping("/uploadStudentDetailExcelFile")
    public ResponseEntity uploadStudentDetailExcelFile(@RequestParam("file")MultipartFile file){
        if (this.helperCheckExcelFormat.checkExcelFormat(file)){
            this.studentDetailServiceImpl.saveStudentDetailExcelFile(file);
            return ResponseEntity.ok(ApiResponse.Ok( "File is uploaded and data is saved to db"));
        }
        return ResponseEntity.ok(ApiResponse.Ok("please upload excel file"));
    }
}
