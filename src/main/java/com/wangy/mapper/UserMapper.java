package com.wangy.mapper;

import com.wangy.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper  extends BaseMapper<User,Long>{

    User selectByUserName(@Param("loginname")String loginname);
}
