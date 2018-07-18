/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wangy.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 在线用户最后一次在线信息()
 * 此表对于分析活跃用户有用
 * <p>User: Zhang Kaitao
 * <p>Date: 13-3-11 下午3:25
 * <p>Version: 1.0
 */

public class UserLastOnline  {

    /**
     * 在线的用户
     */

    private Long userId;


    private String username;

    /**
     * 最后退出时的uid
     */
    private String uid;

    /**
     * 用户主机地址
     */

    private String host;


    /**
     * 用户浏览器类型
     */
    private String userAgent;

    /**
     * 用户登录时系统IP
     */
    private String systemHost;

    /**
     * 最后登录时间
     */
    private Date lastLoginTimestamp;

    /**
     * 最后退出时间
     */
    private Date lastStopTimestamp;

    /**
     * 登录次数
     */
    private Integer loginCount = 0;

    /**
     * 总的在线时长（秒为单位）
     */
    private Long totalOnlineTime = 0L;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Long getTotalOnlineTime() {
        return totalOnlineTime;
    }

    public void setTotalOnlineTime(Long totalOnlineTime) {
        this.totalOnlineTime = totalOnlineTime;
    }

    public String getSystemHost() {
        return systemHost;
    }

    public void setSystemHost(String systemHost) {
        this.systemHost = systemHost;
    }

    public Date getLastLoginTimestamp() {
        return lastLoginTimestamp;
    }

    public void setLastLoginTimestamp(Date lastLoginTimestamp) {
        this.lastLoginTimestamp = lastLoginTimestamp;
    }

    public Date getLastStopTimestamp() {
        return lastStopTimestamp;
    }

    public void setLastStopTimestamp(Date lastStopTimestamp) {
        this.lastStopTimestamp = lastStopTimestamp;
    }

    public void incLoginCount() {
        setLoginCount(getLoginCount() + 1);
    }

    public void incTotalOnlineTime() {
        long onlineTime = getLastStopTimestamp().getTime() - getLastLoginTimestamp().getTime();
        setTotalOnlineTime(getTotalOnlineTime() + onlineTime / 1000);
    }


    public static final UserLastOnline fromUserOnline(UserOnline online) {
        UserLastOnline lastOnline = new UserLastOnline();
        lastOnline.setHost(online.getHost());
        lastOnline.setUserId(online.getUserId());
        lastOnline.setUsername(online.getUsername());
        lastOnline.setUserAgent(online.getUserAgent());
        lastOnline.setSystemHost(online.getSystemHost());
        lastOnline.setUid(String.valueOf(online.getId()));
        lastOnline.setLastLoginTimestamp(online.getStartTimestamp());
        lastOnline.setLastStopTimestamp(online.getLastAccessTime());
        return lastOnline;
    }

    public static final void merge(UserLastOnline from, UserLastOnline to) {
        to.setHost(from.getHost());
        to.setUserId(from.getUserId());
        to.setUsername(from.getUsername());
        to.setUserAgent(from.getUserAgent());
        to.setSystemHost(from.getSystemHost());
        to.setUid(String.valueOf(from.getUid()));
        to.setLastLoginTimestamp(from.getLastLoginTimestamp());
        to.setLastStopTimestamp(from.getLastStopTimestamp());
    }

}
