package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    List<CustomerEntity> findByIsDeleteFalse();
    CustomerEntity findByUsername(String username);
    int countByUsername(String username);
    @Transactional
    @Modifying
    @Query("update customer c set c.isDelete = true WHERE c.customerId =:id")
    int deleteCustomer(@Param("id") int id);
}
