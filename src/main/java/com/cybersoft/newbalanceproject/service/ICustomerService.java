package com.cybersoft.newbalanceproject.service;

import com.cybersoft.newbalanceproject.dto.request.SignUpRequest;
import com.cybersoft.newbalanceproject.dto.response.CustomerDTO;

import java.util.List;

public interface ICustomerService {
    boolean addCustomer(SignUpRequest request);
    List<CustomerDTO> GetAllCustomer();
}
