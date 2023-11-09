package com.libraryserver.controller;

import com.libraryserver.entity.PaymentTransaction;
import com.libraryserver.model.ApiResponse;
import com.libraryserver.serviceImpl.PaymentTransactionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/paymentTransaction")
public class PaymentTransactionController {

    @Autowired
    PaymentTransactionImpl paymentTransactionImpl;

    @PostMapping("/addPaymentTransaction")
    public ResponseEntity<ApiResponse> addPaymentTransaction (@RequestBody PaymentTransaction paymentTransaction){
        var result = this.paymentTransactionImpl.addPaymentTransactionService(paymentTransaction);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @PutMapping("/updatePaymentTransaction/{transactionId}")
    public ResponseEntity<ApiResponse> updatePaymentTransaction(@RequestBody PaymentTransaction paymentTransaction, @PathVariable("transactionId") long transactionId) throws Exception {
        var result = this.paymentTransactionImpl.updatePaymentTransactionService(paymentTransaction, transactionId);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @GetMapping("/getAllPaymentTransaction")
    public ResponseEntity<ApiResponse> getAllPaymentTransaction(){
        var result = this.paymentTransactionImpl.getAllPaymentTransactionService();
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @GetMapping("/getPaymentTransactionByTransactionId/{transactionId}")
    public ResponseEntity<ApiResponse> getPaymentTransactionByTransactionId(@PathVariable("transactionId") long transactionId){
        var result = this.paymentTransactionImpl.getPaymentTransactionByTransactionIdService(transactionId);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

}
