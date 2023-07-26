package com.cybersoft.newbalanceproject.controller;

import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
<<<<<<< HEAD
=======
import com.cybersoft.newbalanceproject.dto.response.CustomerDTO;
>>>>>>> 6d096f8dcc5d6b04760ac6f8be0c6f417578fd4c
import com.cybersoft.newbalanceproject.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
>>>>>>> 6d096f8dcc5d6b04760ac6f8be0c6f417578fd4c

@RestController
@RequestMapping("/customer")
public class CustomerController {
<<<<<<< HEAD
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
=======

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/show")
    public ResponseEntity<?> GetAllCustomer() {
        List<CustomerDTO> customerDTOList = customerService.GetAllCustomer();
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Lấy danh sách Customer thành công");
        response.setData(customerDTOList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
>>>>>>> 6d096f8dcc5d6b04760ac6f8be0c6f417578fd4c
}
