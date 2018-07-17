package com.wangy.mapper;

import com.wangy.upms.domain.UpmsUserRole;
import com.wangy.upms.domain.UpmsUserRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UpmsUserRoleMapper {
    long countByExample(UpmsUserRoleExample example);

    int deleteByExample(UpmsUserRoleExample example);

    int deleteByPrimaryKey(Integer userRoleId);

    int insert(UpmsUserRole record);

    int insertSelective(UpmsUserRole record);

    List<UpmsUserRole> selectByExample(UpmsUserRoleExample example);

    UpmsUserRole selectByPrimaryKey(Integer userRoleId);

    int updateByExampleSelective(@Param("record") UpmsUserRole record, @Param("example") UpmsUserRoleExample example);

    int updateByExample(@Param("record") UpmsUserRole record, @Param("example") UpmsUserRoleExample example);

    int updateByPrimaryKeySelective(UpmsUserRole record);

    int updateByPrimaryKey(UpmsUserRole record);
}