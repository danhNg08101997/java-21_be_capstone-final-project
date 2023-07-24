package com.cybersoft.newbalanceproject.service;

import com.cybersoft.newbalanceproject.dto.request.SignUpRequest;

public interface ICustomerService {
    boolean addCustomer(SignUpRequest request);
}
