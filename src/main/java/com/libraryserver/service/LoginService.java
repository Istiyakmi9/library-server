package com.libraryserver.service;

import com.libraryserver.entity.Login;
import java.util.ArrayList;

public interface LoginService {

    public ArrayList<Login> getAllLoginService();
    public Login authenticateLoginService(Login login) throws Exception;



}
