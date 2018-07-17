package com.wangy.mapper;

import com.wangy.upms.domain.UpmsRolePermission;
import com.wangy.upms.domain.UpmsRolePermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UpmsRolePermissionMapper {
    long countByExample(UpmsRolePermissionExample example);

    int deleteByExample(UpmsRolePermissionExample example);

    int deleteByPrimaryKey(Integer rolePermissionId);

    int insert(UpmsRolePermission record);

    int insertSelective(UpmsRolePermission record);

    List<UpmsRolePermission> selectByExample(UpmsRolePermissionExample example);

    UpmsRolePermission selectByPrimaryKey(Integer rolePermissionId);

    int updateByExampleSelective(@Param("record") UpmsRolePermission record, @Param("example") UpmsRolePermissionExample example);

    int updateByExample(@Param("record") UpmsRolePermission record, @Param("example") UpmsRolePermissionExample example);

    int updateByPrimaryKeySelective(UpmsRolePermission record);

    int updateByPrimaryKey(UpmsRolePermission record);
}