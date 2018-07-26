package com.wangy.entity.auth;

import com.wangy.entity.BaseObject;

/**
 * 权限表
 */

public class Permission extends BaseObject {

    /*
     * 前端显示名称
     */
    private String name;
    /**
     * 系统中验证时使用的权限标识
     */
    private String permission;

    /**
     * 详细描述
     */
    private String description;

    /**
     * 是否显示 也表示是否可用 为了统一 都使用这个
     */
    private Boolean show = Boolean.FALSE;
}
