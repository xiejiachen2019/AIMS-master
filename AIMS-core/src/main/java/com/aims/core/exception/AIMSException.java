package com.aims.core.exception;

/**
 * @Description
 * @Author Jerry
 * @Date 2019/8/29 17:51
 **/
public class AIMSException extends RuntimeException {
    private String code;
    private String message;

    public AIMSException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public AIMSException(CommonErrorCode commonErrorCode) {
        this.code = commonErrorCode.getCode();
        this.message = commonErrorCode.getMsg();
    }

    public AIMSException(CommonErrorCode commonErrorCode, String message) {
        this.code = commonErrorCode.getCode();
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
