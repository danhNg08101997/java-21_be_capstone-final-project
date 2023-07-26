package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.dto.request.CategoryRequest;
import com.cybersoft.newbalanceproject.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    int countAllByCategoryName(String name);
    @Query(value = "select * from category where is_delete=false",nativeQuery = true)
    List<CategoryEntity> findAllBydelete();
    @Transactional
    @Modifying
    @Query("update category set is_delete = true WHERE id = :id")
    int deleteById(@Param("id") int id);
    @Transactional
    @Modifying
    @Query(value = "update category set categoryName=:categoryName where id=:id", nativeQuery = true)
    int update(@Param("id") int id,@Param("categoryName") String categoryName);
}
