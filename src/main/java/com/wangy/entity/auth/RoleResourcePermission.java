package com.wangy.entity.auth;

import com.google.common.collect.Sets;
import com.wangy.entity.BaseObject;
import lombok.Data;

import java.util.Set;

/**
 * 此处没有使用关联 是为了提高性能（后续会挨着查询资源和权限列表，因为有缓存，数据量也不是很大 所以性能不会差）
 * <p>User: Zhang Kaitao
 * <p>Date: 13-4-5 下午2:04
 * <p>Version: 1.0
 */

@Data
public class RoleResourcePermission extends BaseObject {

    /**
     * 角色id
     */
    /**
     * 角色id
     */
    private Role role;

    /**
     * 资源id
     */
    private Long resourceId;

    /**
     * 权限id列表
     * 数据库通过字符串存储 逗号分隔
     */
    private Set<Long> permissionIds;

    public RoleResourcePermission() {
    }

    public RoleResourcePermission(Long id) {
        setId(id);
    }

    public RoleResourcePermission(Long resourceId, Set<Long> permissionIds) {
        this.resourceId = resourceId;
        this.permissionIds = permissionIds;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Set<Long> getPermissionIds() {
        if (permissionIds == null) {
            permissionIds = Sets.newHashSet();
        }
        return permissionIds;
    }

    public void setPermissionIds(Set<Long> permissionIds) {
        this.permissionIds = permissionIds;
    }

    @Override
    public String toString() {
        return "RoleResourcePermission{id=" + this.getId() +
                ",roleId=" + (role != null ? role.getId() : "null") +
                ", resourceId=" + resourceId +
                ", permissionIds=" + permissionIds +
                '}';
    }
}
