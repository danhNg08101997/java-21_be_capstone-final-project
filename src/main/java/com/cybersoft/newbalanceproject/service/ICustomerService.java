package com.cybersoft.newbalanceproject.service;

import com.cybersoft.newbalanceproject.dto.request.SignUpRequest;
<<<<<<< HEAD
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.dto.response.CustomerRespone;
import com.cybersoft.newbalanceproject.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
=======
import com.cybersoft.newbalanceproject.dto.response.CustomerDTO;
>>>>>>> 6d096f8dcc5d6b04760ac6f8be0c6f417578fd4c

import java.util.List;

public interface ICustomerService {
    boolean addCustomer(SignUpRequest request);
<<<<<<< HEAD
    List<CustomerRespone> findAllByIsNotDelete();
    BaseResponse deleteCustomer(int id);
=======
    List<CustomerDTO> GetAllCustomer();
>>>>>>> 6d096f8dcc5d6b04760ac6f8be0c6f417578fd4c
}
