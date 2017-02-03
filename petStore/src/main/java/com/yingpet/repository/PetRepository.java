package com.yingpet.repository;


import com.yingpet.model.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yingyuchang on 2017-01-17.
 */

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Integer> {

    List<PetEntity> findAll();

    PetEntity findById(Integer id);
    Integer deleteById(Integer id);
}
