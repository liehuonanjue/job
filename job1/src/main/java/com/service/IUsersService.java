package com.service;

import com.entity.Users;

/**
 * Created by FLC on 2018/8/24.
 */

public interface IUsersService {
    //登录的方法
    public Users doLogin(String username, String password);

}
