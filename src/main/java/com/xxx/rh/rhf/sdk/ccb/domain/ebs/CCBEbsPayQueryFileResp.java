package com.xxx.rh.rhf.sdk.ccb.domain.ebs;

import com.xxx.rh.rhf.sdk.ccb.CCBObject;

/**
 * @author lihy
 * @version 1.0  2018/8/8
 */
public class CCBEbsPayQueryFileResp extends CCBObject {

    private static final long serialVersionUID = 7190215466848389253L;

    private String requestSn;
    private String custId;
    private String txCode;
    private String returnCode;
    private String returnMsg;
    private String language;

    /** 文件名 */
    private String fileName;
    /** 附加 */
    private String notice;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRequestSn() {
        return requestSn;
    }

    public void setRequestSn(String requestSn) {
        this.requestSn = requestSn;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getTxCode() {
        return txCode;
    }

    public void setTxCode(String txCode) {
        this.txCode = txCode;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

}
