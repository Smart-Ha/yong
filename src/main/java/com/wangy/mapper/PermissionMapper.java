package com.wangy.mapper;

import com.wangy.entity.auth.Permission;
import com.wangy.entity.auth.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission, Long> {

    List<Role> selectAll();
}
