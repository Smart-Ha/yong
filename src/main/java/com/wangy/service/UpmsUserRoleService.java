package com.wangy.service;


import com.wangy.base.BaseService;
import com.wangy.upms.domain.UpmsUserRole;
import com.wangy.upms.domain.UpmsUserRoleExample;

/**
* UpmsUserRoleService接口
* Created by shuzheng on 2017/3/20.
*/
public interface UpmsUserRoleService extends BaseService<UpmsUserRole, UpmsUserRoleExample> {

    /**
     * 用户角色
     * @param roleIds 角色ids
     * @param id 用户id
     * @return
     */
    int role(String[] roleIds, int id);

}