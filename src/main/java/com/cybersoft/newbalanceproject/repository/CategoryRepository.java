package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.dto.request.CategoryRequest;
import com.cybersoft.newbalanceproject.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    int countAllByCategoryName(String name);
    @Modifying
    @Query("DELETE FROM category WHERE id = :id")
    int deleteById(@Param("id") int id);
    @Modifying
    @Query(value = "update category set categoryName=:categoryName where id=:id", nativeQuery = true)
    int update(@Param("id") int id);
}
