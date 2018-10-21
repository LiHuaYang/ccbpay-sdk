package com.xxx.rh.rhf.sdk.ccb.domain.ebs;

import com.xxx.rh.rhf.sdk.ccb.CCBObject;

/**
 * @author lihy
 * @version 1.0  2018/8/7
 */
public class CCBEbsRefundResp extends CCBObject {
    private static final long serialVersionUID = 6911485934635641684L;

    private String requestSn;
    private String custId;
    private String txCode;
    private String returnCode;
    private String returnMsg;
    private String language;

    private String orderNum;
    private String payAmount;
    private String amount;

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

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CCBEbsRefundResp{" +
                "requestSn='" + requestSn + '\'' +
                ", custId='" + custId + '\'' +
                ", txCode='" + txCode + '\'' +
                ", returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", language='" + language + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", payAmount='" + payAmount + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
