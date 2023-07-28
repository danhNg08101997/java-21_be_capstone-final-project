package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Integer> {

}
