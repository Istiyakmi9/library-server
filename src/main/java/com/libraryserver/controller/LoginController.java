package com.libraryserver.controller;

import com.libraryserver.entity.Login;
import com.libraryserver.model.ApiResponse;
import com.libraryserver.serviceImpl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginServiceImpl loginServiceImpl;

    @GetMapping("/getAllLogin")
    public ResponseEntity<ApiResponse> getAllLogin(){
        var result = this.loginServiceImpl.getAllLoginService();
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @PostMapping("/authenticateLogin")
    public ResponseEntity<ApiResponse> authenticateLogin(@RequestBody Login login) throws Exception {
        Login loginResult = this.loginServiceImpl.authenticateLoginService(login);
        return ResponseEntity.ok(ApiResponse.Ok(loginResult));
    }


}
