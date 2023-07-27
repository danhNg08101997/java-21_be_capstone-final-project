package com.cybersoft.newbalanceproject.controller;

import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.filter.JwtFilter;
import com.cybersoft.newbalanceproject.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService ;
//    @PostMapping("")
//    public ResponseEntity<BaseResponse> getAllAdmin(){
//
//    }
}
