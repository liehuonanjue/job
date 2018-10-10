package com.dao;

import com.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsersDao {
    //登录的方法
    public Users doLogin(@Param("username") String username, @Param("password") String password);

}
