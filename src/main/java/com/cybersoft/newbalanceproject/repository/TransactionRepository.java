package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.entity.TransactionEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Integer> {
    List<TransactionEntity> findByIsDeleteFalse();
    @Transactional
    @Modifying
    @Query(value ="update transactions set is_delete=true where transaction_id=:id",nativeQuery = true)
    int deleteTransaction(@Param("id") int id);
}
