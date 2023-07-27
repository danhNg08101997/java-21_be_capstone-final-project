package com.cybersoft.newbalanceproject.controller;

import com.cybersoft.newbalanceproject.dto.request.CustomerRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @PostMapping("")
    public ResponseEntity<BaseResponse> getAllCustomer() {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(HttpStatus.OK.value());
        response.setData(customerService.getAllCustomers());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<BaseResponse> deleteCustomer(@RequestBody CustomerRequest request ){
        return new ResponseEntity<>(customerService.deleteCustomer(request),HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<BaseResponse>edit(@RequestBody CustomerRequest request){
        return new ResponseEntity<>(customerService.editCustomer(request), HttpStatus.OK);
    }
}
