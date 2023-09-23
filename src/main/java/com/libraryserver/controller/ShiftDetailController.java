package com.libraryserver.controller;

import com.libraryserver.entity.ShiftDetail;
import com.libraryserver.model.ApiResponse;
import com.libraryserver.serviceImpl.ShiftDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/shiftDetail")
public class ShiftDetailController {

    @Autowired
    ShiftDetailServiceImpl shiftServiceImpl;

    @PostMapping("/addShiftDetail")
    public ResponseEntity<ApiResponse> addShiftDetail(@RequestBody ShiftDetail shiftDetail){
        var result = this.shiftServiceImpl.addShiftDetailService(shiftDetail);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @PutMapping("/updateShiftDetail/{shiftId}")
    public ResponseEntity<ApiResponse> updateShiftDetail(@RequestBody ShiftDetail shiftDetail, @PathVariable("shiftId") long shiftId ) throws Exception {
        ShiftDetail result = this.shiftServiceImpl.updateShiftDetailService(shiftDetail, shiftId);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @GetMapping("/getAllShiftDetail")
    public ResponseEntity<ApiResponse> getAllShiftDetail(){
        ArrayList<ShiftDetail> result = this.shiftServiceImpl.getAllShiftDetailService();
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @GetMapping("/getShiftDetailByShiftId/{shiftId}")
    public ResponseEntity<ApiResponse> getShiftDetailByShiftId( @PathVariable("shiftId") long shiftId ){
        var result = this.shiftServiceImpl.getShiftDetailByShiftIdService(shiftId);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }


}
