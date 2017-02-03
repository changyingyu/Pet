package com.yingpet.service;

import com.yingpet.model.UserEntity;

/**
 * Created by yingyuchang on 2017-01-18.
 */

public interface UserService {
    void save(UserEntity user);

    UserEntity findByUsername(String username);
}