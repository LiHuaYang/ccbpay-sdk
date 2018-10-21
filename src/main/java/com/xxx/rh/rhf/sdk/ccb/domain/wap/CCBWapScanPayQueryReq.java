package com.xxx.rh.rhf.sdk.ccb.domain.wap;


import java.util.HashMap;
import java.util.Map;

/**
 * @author lihy
 * @version 1.0  2018/8/7
 */
public class CCBWapScanPayQueryReq extends CCBWapBaseReq {

    private static final long serialVersionUID = -241129401760717792L;
    /** 订单号 */
    private String orderId;
    /** 1-龙支付 2-微信 3-支付宝 4-银联（暂不支持） */
    private String qrcodeType;
    /** 查询次数：上送查询的次数，从1开始*/
    private String qryTime;
    /** 商户类型：1-线上商户 2-线下商户 */
    private String merFlag;
    /** 终端编号1：商户类型为2时上送 */
    private String termno1;
    /** 终端编号2：商户类型为2时上送 */
    private String termno2;

    public CCBWapScanPayQueryReq(String merchantId, String posId, String branchId,
                                 String orderId, String qrcodeType) {
        super(merchantId, posId, branchId, "PAY101");

        this.orderId = orderId;
        this.qrcodeType = qrcodeType;
        this.qryTime = "1";
        this.merFlag = "1";
        this.termno1 = "";
        this.termno2 = "";
    }

    public Map<String, String> toReqMap() {
        Map<String, String> reqParams = new HashMap<>();
        reqParams.put("MERCHANTID", this.getMerchantId()==null ? "" : this.getMerchantId());
        reqParams.put("BRANCHID", this.getBranchId()==null ? "" : this.getBranchId());
        reqParams.put("ORDERID", this.getOrderId()==null ? "" : this.getOrderId());
        reqParams.put("POSID", this.getPosId()==null ? "" : this.getPosId());
        reqParams.put("TXCODE", this.getTxCode()==null ? "" : this.getTxCode());

        reqParams.put("MERFLAG", this.getMerFlag()==null ? "" : this.getMerFlag());
        reqParams.put("QRYTIME", this.getQryTime()==null ? "" : this.getQryTime());
        reqParams.put("QRCODETYPE", this.getQrcodeType()==null ? "" : this.getQrcodeType());
        reqParams.put("TERMNO1", this.getTermno1()==null ? "" : this.getTermno1());
        reqParams.put("TERMNO2", this.getTermno2()==null ? "" : this.getTermno2());
        return reqParams;
    }

    public String buildSignStr() {
        StringBuilder sb = new StringBuilder();
        sb.append("MERFLAG=").append("1");
        sb.append("&MERCHANTID=").append(this.getMerchantId()== null ? "" : this.getMerchantId());
        sb.append("&POSID=").append(this.getPosId()== null ? "" : this.getPosId());
        sb.append("&TERMNO1=").append("");
        sb.append("&TERMNO2=").append("");
        sb.append("&BRANCHID=").append(this.getBranchId()== null ? "" : this.getBranchId());
        sb.append("&ORDERID=").append(this.getOrderId()== null ? "" : this.getOrderId());
        sb.append("&ORDERID=").append(this.getOrderId()== null ? "" : this.getOrderId());
        sb.append("&TXCODE=").append(this.getTxCode()== null ? "" : this.getTxCode());
        return sb.toString();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getQrcodeType() {
        return qrcodeType;
    }

    public void setQrcodeType(String qrcodeType) {
        this.qrcodeType = qrcodeType;
    }

    public String getQryTime() {
        return qryTime;
    }

    public void setQryTime(String qryTime) {
        this.qryTime = qryTime;
    }

    public String getMerFlag() {
        return merFlag;
    }

    public void setMerFlag(String merFlag) {
        this.merFlag = merFlag;
    }

    public String getTermno1() {
        return termno1;
    }

    public void setTermno1(String termno1) {
        this.termno1 = termno1;
    }

    public String getTermno2() {
        return termno2;
    }

    public void setTermno2(String termno2) {
        this.termno2 = termno2;
    }
}
