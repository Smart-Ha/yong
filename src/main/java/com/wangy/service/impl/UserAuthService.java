package com.wangy.service.impl;

import com.wangy.entity.User;
import com.wangy.service.IUserAuthService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserAuthService implements IUserAuthService {
    @Override
    public Set<String> findStringRoles(User user) {
        return null;
    }

    @Override
    public Set<String> findStringPermissions(User user) {
        return null;
    }
}
