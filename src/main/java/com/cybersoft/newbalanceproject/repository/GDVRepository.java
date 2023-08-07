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
    List<GDVEntity> findByIsDeleteFalse();
    GDVEntity findByUsername(String username);
    List<GDVEntity>findAllByUsernameIs(String username);
    int countByUsername(String username);
    @Transactional
    @Modifying
    @Query("update gdv g set g.isDelete = true where g.gdvId = :id")
    int deleteByGdvId(@Param("id") int id);
}
