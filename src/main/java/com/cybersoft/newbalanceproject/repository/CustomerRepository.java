package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.entity.CustomerEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Modifying;
=======
>>>>>>> 6d096f8dcc5d6b04760ac6f8be0c6f417578fd4c
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    int countByUsername(String username);
<<<<<<< HEAD
    @Query(value ="SELECT * FROM customer c WHERE c.customer_name = :username AND c.is_delete = false" ,nativeQuery = true)
    CustomerEntity findByUsernameAndIsNotDelete(@Param("username") String username);
    @Query(value = "select * from customer where is_delete = false",nativeQuery = true)
    List<CustomerEntity> findAllByIsNotDelete();
    @Transactional
    @Query("update customer set is_delete = true where customer_id=:id")
    void setIsdeleteCustomer(@Param("id") int id);
=======
    @Query("from customer as u where u.isDelete = false")
   public List<CustomerEntity> GetAllCustomer();
>>>>>>> 6d096f8dcc5d6b04760ac6f8be0c6f417578fd4c
}
