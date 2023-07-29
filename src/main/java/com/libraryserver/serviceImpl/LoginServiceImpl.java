package com.libraryserver.serviceImpl;

import com.libraryserver.entity.Login;
import com.libraryserver.repository.LoginRepository;
import com.libraryserver.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;


    public ArrayList<Login> getAllLoginService() {
        var result = this.loginRepository.findAll();
        return (ArrayList<Login>) result;
        }


    public Login authenticateLoginService(Login login) throws Exception {
        var loginValue = loginRepository.getLoginByEmailOrMobile(login.getMobile(), login.getEmail());
        if(loginValue == null)
            throw new Exception("Mobile or Email detail are mismatched..!");

        if (!loginValue.getPassword().equals(login.getPassword()))
            throw new Exception("Password is not matched");
        return loginValue;

    }
}
