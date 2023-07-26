package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.entity.CustomerEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    int countByUsername(String username);
    @Query(value ="SELECT * FROM customer c WHERE c.customer_name = :username AND c.is_delete = false" ,nativeQuery = true)
    CustomerEntity findByUsernameAndIsNotDelete(@Param("username") String username);
    @Query(value = "select * from customer where is_delete = false",nativeQuery = true)
    List<CustomerEntity> findAllByIsNotDelete();
    @Transactional
    @Query("update customer set is_delete = true where customer_id=:id")
    void setIsdeleteCustomer(@Param("id") int id);
}
