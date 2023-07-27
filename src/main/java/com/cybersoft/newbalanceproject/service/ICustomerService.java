package com.cybersoft.newbalanceproject.service;

import com.cybersoft.newbalanceproject.dto.request.CategoryRequest;
import com.cybersoft.newbalanceproject.dto.request.CustomerRequest;
import com.cybersoft.newbalanceproject.dto.request.SignUpRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.dto.response.CustomerRespone;
import com.cybersoft.newbalanceproject.dto.response.CustomerDTO;
import com.cybersoft.newbalanceproject.entity.CategoryEntity;
import com.cybersoft.newbalanceproject.entity.CustomerEntity;

import java.util.List;

public interface ICustomerService {
    boolean addCustomer(SignUpRequest request);
    List<CustomerEntity> getAllCustomers();
    BaseResponse deleteCustomer(CustomerRequest request);
    BaseResponse editCustomer(CustomerRequest request);
}
