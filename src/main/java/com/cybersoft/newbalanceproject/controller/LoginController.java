package com.cybersoft.newbalanceproject.controller;

import com.cybersoft.newbalanceproject.dto.request.SignUpRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.service.imp.UserServiceImp;
import com.cybersoft.newbalanceproject.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserServiceImp userServiceImp;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?>signIn(
            @RequestParam String username,
            @RequestParam String password
    ){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        authenticationManager.authenticate(token);

        String jwt = jwtHelper.generateToken(username);

        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Đăng nhập thành công");
        response.setData(jwt);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> signup(@Valid SignUpRequest signupRequest){

        boolean isSuccess = userServiceImp.insertUser(signupRequest);

        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Đăng ký thành công");
        response.setData(isSuccess);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
