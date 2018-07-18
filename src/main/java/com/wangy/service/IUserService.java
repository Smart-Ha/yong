package com.wangy.service;

import com.wangy.entity.User;

public interface IUserService extends IBaseService<User>{
    User findByUsername(String username);

    User login(String username, String password);
}
