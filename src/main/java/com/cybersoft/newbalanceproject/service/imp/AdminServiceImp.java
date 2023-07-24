package com.cybersoft.newbalanceproject.service.imp;

import com.cybersoft.newbalanceproject.dto.request.SignUpRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.entity.AdminEntity;
import com.cybersoft.newbalanceproject.repository.AdminRepository;
import com.cybersoft.newbalanceproject.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp implements IAdminService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public boolean addAdmin(SignUpRequest signUpRequest) {
        boolean isSuccess = false;
        try {
            AdminEntity admin = new AdminEntity();
            admin.setUsername(signUpRequest.getUsername());
            admin.setFullname(signUpRequest.getFullname());
            admin.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
            // Kiểm tra trùng
            int countUsername = adminRepository.countByUsername(signUpRequest.getUsername());
            if(countUsername>0){
                 return isSuccess;
            }
            // Thêm admin
            adminRepository.save(admin);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

}
