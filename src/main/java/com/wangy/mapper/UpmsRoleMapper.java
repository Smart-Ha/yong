package com.wangy.mapper;

import com.wangy.upms.domain.UpmsRole;
import com.wangy.upms.domain.UpmsRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UpmsRoleMapper {
    long countByExample(UpmsRoleExample example);

    int deleteByExample(UpmsRoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(UpmsRole record);

    int insertSelective(UpmsRole record);

    List<UpmsRole> selectByExample(UpmsRoleExample example);

    UpmsRole selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") UpmsRole record, @Param("example") UpmsRoleExample example);

    int updateByExample(@Param("record") UpmsRole record, @Param("example") UpmsRoleExample example);

    int updateByPrimaryKeySelective(UpmsRole record);

    int updateByPrimaryKey(UpmsRole record);
}