package com.cybersoft.newbalanceproject.controller;

import com.cybersoft.newbalanceproject.dto.request.CustomerRequest;
import com.cybersoft.newbalanceproject.dto.request.SignUpRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.service.ICustomerService;
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
    private ICustomerService customerService;

    @RequestMapping(value = "/api/signin", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<BaseResponse>signIn(
            @RequestBody SignUpRequest request
    ){
        System.out.print(request.getUsername());
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        UsernamePasswordAuthenticationToken newtoken = (UsernamePasswordAuthenticationToken) authenticationManager.authenticate(token);
        String jwt = jwtHelper.generateToken(String.valueOf(newtoken.getAuthorities().stream().findFirst().orElse(null)));
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Đăng nhập thành công");
        response.setData(jwt);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/api/signup", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin(origins = "https://localhost:4200")
    public ResponseEntity<BaseResponse> signup(@Valid @RequestBody CustomerRequest request){
        boolean isSuccess = customerService.addCustomer(request);
        BaseResponse response = new BaseResponse();
        if(isSuccess) {
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Đăng ký thành công");
            response.setData(isSuccess);
        }else {
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setMessage("Đăng ký thất bại - vì đã tồn tại username: " + request.getUsername() + " trong hệ thống");
            response.setData(isSuccess);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
