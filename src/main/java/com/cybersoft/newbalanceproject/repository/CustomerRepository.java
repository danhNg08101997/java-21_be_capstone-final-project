package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    CustomerEntity findByUsername(String username);
    int countByUsername(String username);
    @Query("from customer as u where u.isDelete = false")
   public List<CustomerEntity> GetAllCustomer();
}
