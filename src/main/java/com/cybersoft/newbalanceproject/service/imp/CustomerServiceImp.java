package com.cybersoft.newbalanceproject.service.imp;

import com.cybersoft.newbalanceproject.dto.request.SignUpRequest;
import com.cybersoft.newbalanceproject.entity.CustomerEntity;
import com.cybersoft.newbalanceproject.repository.CustomerRepository;
import com.cybersoft.newbalanceproject.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements ICustomerService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerRepository repository;
    @Override
    public boolean addCustomer(SignUpRequest request) {
        boolean isSuccess = false;
        try {
            CustomerEntity customer = new CustomerEntity();
            customer.setUsername(request.getUsername());
            customer.setFullname(request.getFullname());
            customer.setPassword(passwordEncoder.encode(request.getPassword()));
            // Kiểm tra trùng
            int countUsername = repository.countByUsername(request.getUsername());
            if(countUsername>0){
                return isSuccess;
            }
            // Thêm admin
            repository.save(customer);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
}
