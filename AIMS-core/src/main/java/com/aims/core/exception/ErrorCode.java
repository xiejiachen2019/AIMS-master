package com.aims.core.exception;

/**
 * 错误码接口
 */
public interface ErrorCode {

    String getCode();

    String getMsg();

    void setCode(String code);

    void setMsg(String msg);

}
