package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository <UserEntity,Integer> {

    UserEntity findByUsername(String username);

}
