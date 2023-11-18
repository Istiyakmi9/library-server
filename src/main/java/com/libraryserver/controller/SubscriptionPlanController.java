package com.libraryserver.controller;

import com.libraryserver.entity.SubscriptionPlan;
import com.libraryserver.model.ApiResponse;
import com.libraryserver.serviceImpl.SubscriptionPlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/subscriptionPlan")
public class SubscriptionPlanController {

    @Autowired
    SubscriptionPlanServiceImpl subscriptionPlanServiceImpl;

    @PostMapping("/addSubscriptionPlan")
    public ResponseEntity<ApiResponse> addSubscriptionPlan(@RequestBody SubscriptionPlan subscriptionPlan) throws Exception {
        var result = this.subscriptionPlanServiceImpl.addSubscriptionPlanService(subscriptionPlan);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @PutMapping("/updateSubscriptionPlan/{subscriptionId}")
    public ResponseEntity<ApiResponse> updateSubscriptionPlan(@RequestBody SubscriptionPlan subscriptionPlan, @PathVariable("subscriptionId") int subscriptionId) throws Exception {
        var result = this.subscriptionPlanServiceImpl.updateSubscriptionPlanService(subscriptionPlan, subscriptionId);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @GetMapping("/getAllSubscriptionPlan")
    public ResponseEntity<ApiResponse> getAllSubscriptionPlan(){
        var result = this.subscriptionPlanServiceImpl.getAllSubscriptionPlanService();
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @GetMapping("/getSubscriptionPlanBySubscriptionId/{subscriptionId}")
    public ResponseEntity<ApiResponse> getSubscriptionPlanBySubscriptionId( @PathVariable("subscriptionId") int subscriptionId){
        Optional<SubscriptionPlan> result = this.subscriptionPlanServiceImpl.getSubscriptionPlanBySubscriptionIdService(subscriptionId);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }






}
