package com.xxx.rh.rhf.sdk.ccb.domain.wap;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lihy
 * @version 1.0  2018/7/27
 */
public class CCBWapQRCodePayReq extends CCBWapBaseReq {
    private static final long serialVersionUID = 8878458944077203536L;

    /** 定单号：由商户提供，最长30位。 */
    private String orderid;
    /** 付款金额：由商户提供，按实际金额给出。单位为元，保留两位小数 */
    private String payment;
    /** 币种：由商户提供，按实际金额给出 */
    private String curcode;
    /** 备注1 */
    private String remark1;
    /** 备注2 */
    private String remark2;
    /**
     * 返回类型：
     *      0或空：返回页面二维码
     *      1：返回JSON格式【二维码信息串】
     *      2：返回聚合扫码页面二维码
     *      3：返回聚合扫码JSON格式【二维码信息串】
     *      聚合扫码只能上送2或3 */
    private String returntype;
    /** 订单超时时间：格式 YYYYMMDDHHMMSS 如：20120214143005 银行系统时间 > TIMEOUT 时拒绝交易，若送空值则不判断超时。 */
    private String timeout;

    public CCBWapQRCodePayReq(String merchantId, String posId, String branchId,
                              String orderid, String payment) {
        super(merchantId, posId, branchId, "530550");
        this.orderid = orderid;
        this.payment = payment;
        this.curcode = "01";
        this.remark1 = "";
        this.remark2 = "";
        this.returntype = "3";
        this.timeout = "";
    }

    public Map<String, String> toReqMap() {
        Map<String, String> reqParams = new HashMap<>();
        reqParams.put("MERCHANTID", this.getMerchantId()==null ? "" : this.getMerchantId());
        reqParams.put("POSID", this.getPosId()==null ? "" : this.getPosId());
        reqParams.put("BRANCHID", this.getBranchId()==null ? "" : this.getBranchId());
        reqParams.put("ORDERID", this.getOrderid()==null ? "" : this.getOrderid());
        reqParams.put("PAYMENT", this.getPayment()==null ? "" : this.getPayment());
        reqParams.put("CURCODE", this.getCurcode() == null ? "" : this.getCurcode());
        reqParams.put("REMARK1", this.getRemark1()==null ? "" : this.getRemark1());
        reqParams.put("REMARK2", this.getRemark2()==null ? "" : this.getRemark2());
        reqParams.put("TXCODE", this.getTxCode()==null ? "" : this.getTxCode());
        reqParams.put("RETURNTYPE", this.getReturntype()==null ? "" : this.getReturntype());
        reqParams.put("TIMEOUT", this.getTimeout()==null ? "" : this.getTimeout());
        return reqParams;
    }

    /**
     * 拼接签名字符串
     * @author lihy  v1.0   2018/8/21
     */
    public String buildSignStr() {
        StringBuilder sb = new StringBuilder();
        sb.append("MERCHANTID=").append(this.getMerchantId()== null ? "" : this.getMerchantId());
        sb.append("&BRANCHID=").append(this.getBranchId()== null ? "" : this.getBranchId());
        sb.append("&POSID=").append(this.getPosId()== null ? "" : this.getPosId());
        return sb.toString();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getCurcode() {
        return curcode;
    }

    public void setCurcode(String curcode) {
        this.curcode = curcode;
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

    public String getReturntype() {
        return returntype;
    }

    public void setReturntype(String returntype) {
        this.returntype = returntype;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }
}
