package com.cybersoft.newbalanceproject.service.imp;

import com.cybersoft.newbalanceproject.repository.AdminRepository;
import com.cybersoft.newbalanceproject.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp implements IAdminService {
    @Autowired
    private AdminRepository repository;
}
