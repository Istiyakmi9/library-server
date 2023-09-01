package com.libraryserver.controller;

import com.libraryserver.entity.ShiftDetail;
import com.libraryserver.model.ApiResponse;
import com.libraryserver.serviceImpl.ShiftDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ShiftDetailController {

    @Autowired
    ShiftDetailServiceImpl shiftServiceImpl;

    @PostMapping("/addShiftService")
    public ResponseEntity<ApiResponse> addShiftDetail(@RequestBody ShiftDetail shiftDetail){
    this.shiftServiceImpl.addShiftDetailService(shiftDetail);
    return ResponseEntity.ok(ApiResponse.Ok(null));
    }


}
