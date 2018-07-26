package com.wangy.constant;

public class Constants {

    /**
     * 用户模块
     */
    public static final String MODULE_USER = "user-module";
    public static final byte USER_LOCKED = 1;
    public static final byte USER_UNLOCK = 0;

    public static final String ERROR = "error";
    public static final String MESSAGE = "message";

    /**
     * 上个页面地址
     */
    public static final String BACK_URL = "BackURL";

    public static final String IGNORE_BACK_URL = "ignoreBackURL";

    /**
     * 当前请求的地址 带参数
     */
    public static final String CURRENT_URL = "currentURL";

    ///////////////////////用户相关 shiro //////////////////////
    /**
     *当前用户名
     */
    public static final String CURRENT_USERNAME = "CURRENT_USERNAME";
    /**
     *
     */
    public static final String ONLY_CLEAR_CACHE = "ONLY_CLEAR_CACHE";
}
