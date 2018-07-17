package com.wangy.service.impl;

import com.wangy.entity.User;
import com.wangy.mapper.UserMapper;
import com.wangy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }
}
