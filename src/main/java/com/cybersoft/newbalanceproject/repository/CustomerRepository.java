package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    CustomerEntity findByUsername(String username);
    int countByUsername(String username);
    public List<CustomerEntity> findAll();
}
