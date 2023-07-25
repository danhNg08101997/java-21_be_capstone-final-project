package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.entity.GDVEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GDVRepository extends JpaRepository<GDVEntity, Integer> {
    GDVEntity findByUsernameAndPassword(String username, String password);
}
