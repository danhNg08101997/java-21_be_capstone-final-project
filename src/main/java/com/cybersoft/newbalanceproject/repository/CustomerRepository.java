package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    CustomerEntity findByUsernameAndPassword(String username, String password);
    int countByUsername(String username);
}
