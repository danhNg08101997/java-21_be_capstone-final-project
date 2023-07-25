package com.cybersoft.newbalanceproject.controller;

import com.cybersoft.newbalanceproject.dto.request.SignUpRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.service.imp.CustomerServiceImp;
import com.cybersoft.newbalanceproject.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private CustomerServiceImp customerService;


    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<BaseResponse>signIn(
            @RequestParam String username,
            @RequestParam String password
    ){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        UsernamePasswordAuthenticationToken newtoken = (UsernamePasswordAuthenticationToken) authenticationManager.authenticate(token);
        String jwt = jwtHelper.generateToken(String.valueOf(newtoken.getAuthorities().stream().findFirst().orElse(null)));
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Đăng nhập thành công");
        response.setData(jwt);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<BaseResponse> signup(@Valid @RequestBody SignUpRequest signupRequest){
        boolean isSuccess = customerService.addCustomer(signupRequest);
        BaseResponse response = new BaseResponse();
        if(isSuccess) {
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Đăng ký thành công");
            response.setData(isSuccess);
        }else {
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setMessage("Đăng ký thất bại - vì đã tồn tại username: " + signupRequest.getUsername() + " trong hệ thống");
            response.setData(isSuccess);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
