package com.wangy.entity.auth;

import com.google.common.collect.Lists;
import com.wangy.entity.BaseObject;
import lombok.Data;

import java.util.List;

/**
 * 角色表
 */
@Data
public class Role extends BaseObject {

    /**
     * 前端显示名称
     */
    private String name;
    /**
     * 系统中验证时使用的角色标识
     */
    private String role;

    /**
     * 详细描述
     */
    private String description;


    /**
     * 用户 组织机构 工作职务关联表
     */
    private List<RoleResourcePermission> resourcePermissions;

    /**
     * 是否显示 也表示是否可用 为了统一 都使用这个
     */
    private Boolean show = Boolean.FALSE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RoleResourcePermission> getResourcePermissions() {
        if (resourcePermissions == null) {
            resourcePermissions = Lists.newArrayList();
        }
        return resourcePermissions;
    }

    public void setResourcePermissions(List<RoleResourcePermission> resourcePermissions) {
        this.resourcePermissions = resourcePermissions;
    }

    public void addResourcePermission(RoleResourcePermission roleResourcePermission) {
        roleResourcePermission.setRole(this);
        getResourcePermissions().add(roleResourcePermission);
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }
}
