package com.wangy.entity.auth;

/**
 * 授权类型
 * <p>User: Zhang Kaitao
 * <p>Date: 13-4-19 上午8:57
 * <p>Version: 1.0
 */
public enum AuthType {

    user("用户"), user_group("用户组"), organization_job("组织机构和工作职务"), organization_group("组织机构组");

    private final String info;

    private AuthType(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
