package com.wangy.entity;


/**
 * 资源表
 */

public class Resource extends BaseObject{

    /**
     * 标题
     */
    private String name;

    /**
     * 资源标识符 用于权限匹配的 如sys:resource
     */
    private String identity;

    /**
     * 点击后前往的地址
     * 菜单才有
     */
    private String url;

    /**
     * 父路径
     */
    private Long parentId;

    private String parentIds;

    private Integer weight;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否有叶子节点
     */
    private boolean hasChildren;

    /**
     * 是否显示
     */
    private Boolean show = Boolean.FALSE;


}
