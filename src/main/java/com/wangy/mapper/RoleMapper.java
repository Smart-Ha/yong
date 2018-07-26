package com.wangy.mapper;

import com.wangy.entity.auth.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role, Long> {


    List<Role> selectAll();
}
