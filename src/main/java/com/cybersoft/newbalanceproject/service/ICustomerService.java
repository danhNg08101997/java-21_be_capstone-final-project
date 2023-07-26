package com.cybersoft.newbalanceproject.service;

import com.cybersoft.newbalanceproject.dto.request.SignUpRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.dto.response.CustomerRespone;
import com.cybersoft.newbalanceproject.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerService {
    boolean addCustomer(SignUpRequest request);
    List<CustomerRespone> findAllByIsNotDelete();
    BaseResponse deleteCustomer(int id);
}
