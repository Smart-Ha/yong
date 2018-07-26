package com.wangy.constant;

/**
 * upms系统接口结果常量枚举类
 */
public enum UserConstant {

    /**
     * 失败
     */
    FAILED(1, "failed"),

    /**
     * 成功
     */
    SUCCESS(0, "success"),

    UNLOCKED(0, "unlock"),
    LOCKED(1, "locked"),

    /**
     * 无效长度
     */
    INVALID_LENGTH(10001, "Invalid length"),

    EMPTY_PARAM(10002,"必填项参数不能为空"),

    /**
     * 验证码
     */
    INVALID_VCODE(10003, "verifyCode cannot be empty"),
    EMPTY_VCODE(10004, "Invalid verifyCode"),

    /**
     * 用户名不能为空
     */
    EMPTY_USERNAME(10101, "Username cannot be empty"),

    /**
     * 密码不能为空
     */
    EMPTY_PASSWORD(10102, "Password cannot be empty"),

    /**
     * 帐号不存在
     */
    INVALID_USERNAME(10103, "Account does not exist"),

    /**
     * 密码错误
     */
    INVALID_PASSWORD(10104, "Password error"),

    /**
     * 无效帐号
     */
    INVALID_ACCOUNT(10105, "Invalid account"),


    /**
     * 无效帐号
     */
    ACCOUNT_LOCKED(10106, "Account locked");

    public int code;

    public String message;

    UserConstant(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        System.out.println(UserConstant.INVALID_USERNAME);
    }
}
