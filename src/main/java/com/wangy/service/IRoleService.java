package com.wangy.service;

import com.wangy.entity.auth.Role;
import com.wangy.entity.auth.RoleResourcePermission;

import java.util.List;
import java.util.Set;

public interface IRoleService {
    Role update(Role role);

    public Set<Role> findShowRoles(Set<Long> roleIds) ;

    List<Role> findAllRoles();

    Role addRole(Role role);

    boolean deleteRole(String role);
}
