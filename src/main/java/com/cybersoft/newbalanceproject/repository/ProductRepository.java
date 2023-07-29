package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.entity.CustomerEntity;
import com.cybersoft.newbalanceproject.entity.ProductEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    int countByProductName(String name);
    List<ProductEntity> findByIsDeleteFalse();
    @Transactional
    @Modifying
    @Query(value="update product set is_delete = true where product_id = :id",nativeQuery = true)
    int deleteProduct(@Param("id") int id);
}
