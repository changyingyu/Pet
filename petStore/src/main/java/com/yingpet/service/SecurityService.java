package com.yingpet.service;

/**
 * Created by yingyuchang on 2017-01-18.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}