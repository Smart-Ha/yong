package com.wangy.service.impl;

import com.wangy.constant.Constants;
import com.wangy.constant.UserConstant;
import com.wangy.entity.User;
import com.wangy.exception.UserException;
import com.wangy.mapper.UserMapper;
import com.wangy.service.IUserService;
import com.wangy.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    @Override
    public User findByUsername(String username) {
        return userMapper.selectByUserName(username);
    }

    @Override
    public User login(String username, String password) {
        User user = findByUsername(username);
        if(user == null){
            throw new UserException(UserConstant.INVALID_USERNAME.toString());
        }
        String newPass = Md5Utils.hash(password + user.getSalt());
        if(!user.getPassword().equals(newPass)){
            throw new UserException(UserConstant.INVALID_PASSWORD.toString());
        }

        if(user.getLocked() == Constants.USER_UNLOCK){
            throw new UserException(UserConstant.ACCOUNT_LOCKED.toString());
        }
        return user;
    }

    @Override
    public User signUp(User user) {
        user.setSalt(Md5Utils.getSalt());
        user.setLocked(Constants.USER_UNLOCK);
        String rawPass = user.getPassword();
        String pass = Md5Utils.hashWithSalt(rawPass,user.getSalt());
        userMapper.insert(user);
        User user1 = findByUsername(user.getEmail());
        return user1;
    }

    @Override
    public boolean resetPassword(User param) {
        User user = findById(param.getUserId());
        String pass = Md5Utils.hashWithSalt(param.getPassword(),user.getSalt());
        if(!user.getPassword().equals(pass)){
            throw new UserException(UserConstant.INVALID_PASSWORD.toString());
        }

        String newPass = Md5Utils.hashWithSalt(param.getNewPass(),user.getSalt());
        int count = userMapper.updatePassword(user.getUserId(), newPass);
        return count>1;
    }
}
