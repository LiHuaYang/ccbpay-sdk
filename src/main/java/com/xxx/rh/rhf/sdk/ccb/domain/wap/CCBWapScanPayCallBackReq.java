package com.xxx.rh.rhf.sdk.ccb.domain.wap;

import java.util.Map;

/**
 * @author lihy
 * @version 1.0  2018/8/11
 */
public class CCBWapScanPayCallBackReq {

    private String posId;
    private String branchId;
    private String orderId;
    private String payment;
    private String curCode;
    private String remark1;
    private String remark2;
    private String accType;
    private String success;
    private String type;
    private String referer;
    private String clientIp;
    private String accDate;
    private String usrMsg;
    private String usrInfo;
    private String payType;
    private String sign;

    public CCBWapScanPayCallBackReq(){}

    public CCBWapScanPayCallBackReq(Map<String, String> map) {
        this.setPosId(map.containsKey("POSID") ? map.get("POSID") : null);
        this.setBranchId(map.containsKey("BRANCHID") ? map.get("BRANCHID") : null);
        this.setOrderId(map.containsKey("ORDERID") ? map.get("ORDERID") : null);
        this.setPayment(map.containsKey("PAYMENT") ? map.get("PAYMENT") : null);
        this.setCurCode(map.containsKey("CURCODE") ? map.get("CURCODE") : null);
        this.setRemark1(map.containsKey("REMARK1") ? map.get("REMARK1") : null);
        this.setRemark2(map.containsKey("REMARK2") ? map.get("REMARK2") : null);
        this.setAccType(map.containsKey("ACC_TYPE") ? map.get("ACC_TYPE") : null);
        this.setSuccess(map.containsKey("SUCCESS") ? map.get("SUCCESS") : null);
        this.setType(map.containsKey("TYPE") ? map.get("TYPE") : null);
        this.setReferer(map.containsKey("REFERER") ? map.get("REFERER") : null);
        this.setClientIp(map.containsKey("CLIENTIP") ? map.get("CLIENTIP") : null);
        this.setAccDate(map.containsKey("ACCDATE") ? map.get("ACCDATE") : null);
        this.setUsrMsg(map.containsKey("USRMSG") ? map.get("USRMSG") : null);
        this.setUsrInfo(map.containsKey("USRINFO") ? map.get("USRINFO") : null);
        this.setPayType(map.containsKey("PAYTYPE") ? map.get("PAYTYPE") : null);
        this.setSign(map.containsKey("SIGN") ? map.get("SIGN") : null);
    }

    /**
     * 组装回调验签原始字符串，约定如下：
     *  1. 必须参与验签的字段，当值为 null 时，拼空字符串 ""
     *  2. 回调报文里有 key 时才参与验签的字段，
     *  值为 null 时，视为回调报文中没有此字段返回，不参与验签
     *  值不为 null 时，视为回调报文中没此字段返回，参与验签
     * @author lihy  v1.0   2018/8/11
     */
    public String buildSignStr() {
        StringBuilder signDataBuilder = new StringBuilder();
        signDataBuilder.append("POSID=").append(this.getPosId() == null ? "" : this.getPosId())
                .append("&BRANCHID=").append(this.getBranchId() == null ? "" : this.getBranchId())
                .append("&ORDERID=").append(this.getOrderId() == null ? "" : this.getOrderId())
                .append("&PAYMENT=").append(this.getPayment() == null ? "" : this.getPayment())
                .append("&CURCODE=").append(this.getCurCode() == null ? "" : this.getCurCode())
                .append("&REMARK1=").append(this.getRemark1() == null ? "" : this.getRemark1())
                .append("&REMARK2=").append(this.getRemark2() == null ? "" : this.getRemark2())
                .append("&ACC_TYPE=").append(this.getAccType() == null ? "" : this.getAccType())
                .append("&SUCCESS=").append(this.getSuccess() == null ? "" : this.getSuccess());
        if (this.getType() != null) {
            signDataBuilder.append("&TYPE=").append(this.getType());
        }
        if (this.getReferer() != null) {
            signDataBuilder.append("&REFERER=").append(this.getReferer());
        }
        if (this.getClientIp() != null) {
            signDataBuilder.append("&CLIENTIP=").append(this.getClientIp());
        }
        if (this.getAccDate() != null) {
            signDataBuilder.append("&ACCDATE=").append(this.getAccDate());
        }
        if (this.getUsrInfo() != null) {
            signDataBuilder.append("&USRINFO=").append(this.getUsrInfo());
        }
        if (this.getPayType() != null) {
            signDataBuilder.append("&PAYTYPE=").append(this.getPayType());
        }
        return signDataBuilder.toString();
    }

    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getCurCode() {
        return curCode;
    }

    public void setCurCode(String curCode) {
        this.curCode = curCode;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getAccDate() {
        return accDate;
    }

    public void setAccDate(String accDate) {
        this.accDate = accDate;
    }

    public String getUsrMsg() {
        return usrMsg;
    }

    public void setUsrMsg(String usrMsg) {
        this.usrMsg = usrMsg;
    }

    public String getUsrInfo() {
        return usrInfo;
    }

    public void setUsrInfo(String usrInfo) {
        this.usrInfo = usrInfo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "CCBWapScanPayCallBackReq{" +
                "posId='" + posId + '\'' +
                ", branchId='" + branchId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", payment='" + payment + '\'' +
                ", curCode='" + curCode + '\'' +
                ", remark1='" + remark1 + '\'' +
                ", remark2='" + remark2 + '\'' +
                ", accType='" + accType + '\'' +
                ", success='" + success + '\'' +
                ", type='" + type + '\'' +
                ", referer='" + referer + '\'' +
                ", clientIp='" + clientIp + '\'' +
                ", accDate='" + accDate + '\'' +
                ", usrMsg='" + usrMsg + '\'' +
                ", usrInfo='" + usrInfo + '\'' +
                ", payType='" + payType + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
