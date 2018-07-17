package com.wangy.service;

import com.zheng.common.base.BaseService;
import com.zheng.upms.dao.model.UpmsUser;
import com.zheng.upms.dao.model.UpmsUserExample;

/**
* UpmsUserService接口
* Created by shuzheng on 2017/3/20.
*/
public interface UpmsUserService extends BaseService<UpmsUser, UpmsUserExample> {

    UpmsUser createUser(UpmsUser upmsUser);

}