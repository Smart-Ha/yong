package com.wangy.exception;


import com.wangy.constant.Constants;

public class UserException extends BaseException {

    public UserException(String code) {
        super(Constants.MODULE_USER, code, null);
    }

    public UserException(String code, Object[] args) {
        super(Constants.MODULE_USER, code, args);
    }

}
