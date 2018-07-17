package com.wangy.service.impl;


import com.wangy.base.BaseServiceImpl;
import com.wangy.mapper.UpmsRoleMapper;
import com.wangy.service.UpmsRoleService;
import com.wangy.upms.domain.UpmsRole;
import com.wangy.upms.domain.UpmsRoleExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsRoleService实现
* Created by shuzheng on 2017/3/20.
*/
@Service
@Transactional
public class UpmsRoleServiceImpl extends BaseServiceImpl<UpmsRoleMapper, UpmsRole, UpmsRoleExample> implements UpmsRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsRoleServiceImpl.class);

//    @Autowired
//    UpmsRoleMapper upmsRoleMapper;

}