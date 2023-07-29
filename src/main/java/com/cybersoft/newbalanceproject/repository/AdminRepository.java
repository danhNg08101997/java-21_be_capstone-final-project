package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity,Integer> {
    AdminEntity findByUsername(String username);
}
