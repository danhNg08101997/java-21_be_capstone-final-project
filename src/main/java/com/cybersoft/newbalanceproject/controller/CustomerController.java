package com.cybersoft.newbalanceproject.controller;

import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.dto.response.CustomerDTO;
import com.cybersoft.newbalanceproject.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

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
}
