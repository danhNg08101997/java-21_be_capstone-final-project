package com.cybersoft.newbalanceproject.controller;

import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @PostMapping("")
    public ResponseEntity<BaseResponse> getAllCustomer() {
        BaseResponse response = new BaseResponse();
        response.setMessage("Thành Công");
        response.setStatusCode(200);
        response.setData(customerService.findAllByIsNotDelete());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/delete")
    public ResponseEntity<BaseResponse> deleteCustomer(@RequestParam int id){
        return new ResponseEntity<>(customerService.deleteCustomer(id),HttpStatus.OK);
    }
}
