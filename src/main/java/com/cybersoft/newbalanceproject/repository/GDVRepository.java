package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.entity.GDVEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GDVRepository extends JpaRepository<GDVEntity, Integer> {
    @Query(value ="select gdv.gdv_id,gdv.gdv_name,gdv.gdv_password,gdv.is_available,gdv.is_delete,gdv.fullname from gdv join support on support.gdv_id = gdv.gdv_id and gdv.is_available =true and gdv.is_delete = false and support.product_id =:id limit 1",nativeQuery = true)
    GDVEntity findByIdProduct(@Param("id") int id);
    @Transactional
    @Modifying
    @Query(value = "update gdv set is_available=false where gdv.gdv_id = :id",nativeQuery = true)
    int updateIsAvailable(@Param("id") int id);
    List<GDVEntity> findByIsDeleteFalse();
    GDVEntity findByUsername(String username);
    int countByUsername(String username);
    @Transactional
    @Modifying
    @Query("update gdv g set g.isDelete = true where g.gdvId = :id")
    int deleteByGdvId(@Param("id") int id);
}
