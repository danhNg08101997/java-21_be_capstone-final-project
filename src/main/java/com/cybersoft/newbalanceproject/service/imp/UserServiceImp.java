package com.cybersoft.newbalanceproject.service.imp;

import com.cybersoft.newbalanceproject.dto.request.SignUpRequest;

public interface UserServiceImp {
    boolean insertUser(SignUpRequest signUpRequest);
}
