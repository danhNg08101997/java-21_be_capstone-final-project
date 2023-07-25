package com.cybersoft.newbalanceproject.controller;

import com.cybersoft.newbalanceproject.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private JwtFilter jwtFilter;
}
