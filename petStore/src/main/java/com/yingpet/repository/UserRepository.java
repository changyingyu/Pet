package com.yingpet.repository;

import com.yingpet.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {


    UserEntity findByUsername(String username);

}
