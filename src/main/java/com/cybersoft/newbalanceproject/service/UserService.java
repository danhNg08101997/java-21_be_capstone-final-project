package com.cybersoft.newbalanceproject.service;

import com.cybersoft.newbalanceproject.dto.request.SignUpRequest;

public interface UserService {
    boolean insertUser(SignUpRequest signUpRequest);
}
