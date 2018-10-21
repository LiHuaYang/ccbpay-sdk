package com.xxx.rh.rhf.sdk.ccb.domain.ebs;

import com.xxx.rh.rhf.sdk.ccb.CCBObject;
import com.xxx.rh.rhf.sdk.ccb.CCBPayConstants;

import java.util.Date;

/**
 *
 * @author lihy
 * @version 1.0  2018/8/8
 */
public class CCBEbsBaseReq extends CCBObject {
    private static final long serialVersionUID = -5479059987300379884L;

    /** 请求序列号	varChar(16)	只可以使用数字 */
    private String requestSn;
    /** 商户号	    varChar(21) 网银商户号 */
    private String custId;
    /** 操作员号	    varChar(6)  20051210 后必须使用 */
    private String userId;
    /** 密码	        varChar(32) 操作员密码 */
    private String passWord;
    /** 交易码	    varChar(6)  交易请求码 */
    private String txCode;
    /** 语言	         varChar(2) CN */
    private String language;

    public CCBEbsBaseReq(String custId, String userId, String passWord, String txCode) {
        this.requestSn = CCBPayConstants.yyMMddHHmmssSSS.format(new Date());
        this.custId = custId;
        this.userId = userId;
        this.passWord = passWord;
        this.txCode = txCode;
        this.language = "CN";
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getTxCode() {
        return txCode;
    }

    public void setTxCode(String txCode) {
        this.txCode = txCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
