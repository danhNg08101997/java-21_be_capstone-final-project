package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.dto.request.CategoryRequest;
import com.cybersoft.newbalanceproject.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    List<CategoryEntity> findByIsDeleteFalse();
    int countAllByCategoryName(String name);
    @Transactional
    @Modifying
    @Query("update category c set c.isDelete = true WHERE c.id = :id")
    int deleteCategory(@Param("id") int id);

}
