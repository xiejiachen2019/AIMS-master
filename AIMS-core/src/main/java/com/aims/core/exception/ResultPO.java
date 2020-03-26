package com.aims.core.exception;

public class ResultPO {

    private String code;

    private String message;

    private Object data;

    private ResultPO() {
    }

    public ResultPO(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public ResultPO(ErrorCode errorCode, String msg) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg() + ": " + msg;
    }

    public ResultPO(String code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public ResultPO(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultPO success() {
        ResultPO resultPO = new ResultPO();
        resultPO.setCode(CommonErrorCode.E0.getCode());
        resultPO.setMessage(CommonErrorCode.E0.getMsg());
        return resultPO;
    }

    public static ResultPO success(Object data) {
        ResultPO resultPO = new ResultPO();
        resultPO.setCode(CommonErrorCode.E0.getCode());
        resultPO.setMessage(CommonErrorCode.E0.getMsg());
        resultPO.setData(data);
        return resultPO;
    }
    public static ResultPO failure(Object data) {
        ResultPO resultPO = new ResultPO();
        resultPO.setCode(CommonErrorCode.E100001.getCode());
        resultPO.setMessage(CommonErrorCode.E100001.getMsg());
        resultPO.setData(data);
        return resultPO;
    }

    public void setErrorMsg(ErrorCode errorCode) {
        setErrorMsg(errorCode.getCode(), errorCode.getMsg());
    }

    /**
     * 将定义的错误信息追加到错误码中的错误信息
     *
     * @param errorCode
     * @param appendMsg
     */
    public void setErrorMsgAppend(ErrorCode errorCode, String appendMsg) {
        String msg = errorCode.getMsg() + "：" + appendMsg;
        setErrorMsg(errorCode.getCode(), msg);
    }

    public void setErrorMsg(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public boolean issuccess() {
        if ("0".equals(this.getCode())) {
            return true;
        }
        return false;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
