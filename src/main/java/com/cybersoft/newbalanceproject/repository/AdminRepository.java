package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
    AdminEntity findByUsernameAndPassword(String username, String password);
}
