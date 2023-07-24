package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
    AdminEntity findByUsername(String username);
    int countByUsername(String username);
}
