package com.wangy.service;

import com.wangy.entity.User;

import java.util.Set;

public interface IUserAuthService {
    Set<String> findStringRoles(User user);

    Set<String> findStringPermissions(User user);
}
