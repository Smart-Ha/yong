/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wangy.entity;

import com.wangy.core.shiro.OnlineSession;

import java.util.Date;

/**
 * 当前在线会话
 * <p>User: Zhang Kaitao
 * <p>Date: 13-3-20 下午3:10
 * <p>Version: 1.0
 */

public class UserOnline {

    /**
     * 用户会话id ===> uid
     */

    private String id;

    //当前登录的用户Id
    private Long userId = 0L;


    private String username;

    /**
     * 用户主机地址
     */
    private String host;

    /**
     * 用户登录时系统IP
     */
    private String systemHost;

    /**
     * 用户浏览器类型
     */
    private String userAgent;

    /**
     * 在线状态
     */
    private OnlineSession.OnlineStatus status = OnlineSession.OnlineStatus.on_line;

    /**
     * session创建时间
     */

    private Date startTimestamp;
    /**
     * session最后访问时间
     */

    private Date lastAccessTime;

    /**
     * 超时时间
     */
    private Long timeout;


    /**
     * 备份的当前用户会话
     */
    private OnlineSession session;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }


    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public OnlineSession.OnlineStatus getStatus() {
        return status;
    }

    public void setStatus(OnlineSession.OnlineStatus status) {
        this.status = status;
    }

    public OnlineSession getSession() {
        return session;
    }

    public void setSession(OnlineSession session) {
        this.session = session;
    }

    public String getSystemHost() {
        return systemHost;
    }

    public void setSystemHost(String systemHost) {
        this.systemHost = systemHost;
    }


    public static final UserOnline fromOnlineSession(OnlineSession session) {
        UserOnline online = new UserOnline();
        online.setId(String.valueOf(session.getId()));
        online.setUserId(session.getUserId());
        online.setUsername(session.getUsername());
        online.setStartTimestamp(session.getStartTimestamp());
        online.setLastAccessTime(session.getLastAccessTime());
        online.setTimeout(session.getTimeout());
        online.setHost(session.getHost());
        online.setUserAgent(session.getUserAgent());
        online.setSystemHost(session.getSystemHost());
        online.setSession(session);

        return online;
    }


}
