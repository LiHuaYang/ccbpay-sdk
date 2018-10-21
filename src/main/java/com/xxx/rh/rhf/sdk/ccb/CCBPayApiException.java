package com.xxx.rh.rhf.sdk.ccb;

public class CCBPayApiException extends Exception {

    private static final long serialVersionUID = -238091758285157331L;

    private String errCode;
    private String errMsg;

    public CCBPayApiException() {
        super();
    }

    public CCBPayApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public CCBPayApiException(String message) {
        super(message);
    }

    public CCBPayApiException(Throwable cause) {
        super(cause);
    }

    public CCBPayApiException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

}