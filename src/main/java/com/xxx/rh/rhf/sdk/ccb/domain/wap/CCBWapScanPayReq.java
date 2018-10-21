package com.xxx.rh.rhf.sdk.ccb.domain.wap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihy
 * @version 1.0  2018/8/6
 */
public class CCBWapScanPayReq extends CCBWapBaseReq {

    private static final long serialVersionUID = 7380835364941001432L;

    /** 订单号，小于 30 位 */
    private String orderId;
    /** 条码信息，（一维码、二维码）*/
    private String qrCode;
    /** 金额，单位元，带两位小数*/
    private String amount;
    /** 商品名称 */
    private String proInfo;
    /** */
    private String remark1;
    /** */
    private String remark2;


    public CCBWapScanPayReq(String merchantId, String posId, String branchId,
                            String orderid, String qrCode, String amount) {
        super(merchantId, posId, branchId, "PAY100");

        this.orderId = orderid;
        this.qrCode = qrCode;
        this.amount = amount;
    }

    public Map<String, String> toReqMap() {
        Map<String, String> reqParams = new HashMap<>();
        reqParams.put("MERCHANTID", this.getMerchantId()==null ? "" : this.getMerchantId());
        reqParams.put("POSID", this.getPosId()==null ? "" : this.getPosId());
        reqParams.put("BRANCHID", this.getBranchId()==null ? "" : this.getBranchId());
        reqParams.put("ORDERID", this.getOrderId()==null ? "" : this.getOrderId());
        reqParams.put("TXCODE", this.getTxCode()==null ? "" : this.getTxCode());
        reqParams.put("QRCODE", this.getQrCode() == null ? "" : this.getQrCode());
        reqParams.put("AMOUNT", this.getAmount()==null ? "" : this.getAmount());
        reqParams.put("REMARK1", this.getRemark1()==null ? "" : this.getRemark1());
        reqParams.put("REMARK2", this.getRemark2()==null ? "" : this.getRemark2());
        reqParams.put("PROINFO", this.getProInfo()==null ? "" : this.getProInfo());
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
        sb.append("&QRCODE=").append(this.getQrCode()== null ? "" : this.getQrCode());
        sb.append("&AMOUNT=").append(this.getAmount()== null ? "" : this.getAmount());
        sb.append("&TXCODE=").append(this.getTxCode()== null ? "" : this.getTxCode());
        return sb.toString();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getProInfo() {
        return proInfo;
    }

    public void setProInfo(String proInfo) {
        this.proInfo = proInfo;
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
}
