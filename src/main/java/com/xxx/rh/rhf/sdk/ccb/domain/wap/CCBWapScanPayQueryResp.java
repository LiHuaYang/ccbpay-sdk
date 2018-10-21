package com.xxx.rh.rhf.sdk.ccb.domain.wap;

import com.xxx.rh.rhf.sdk.ccb.CCBObject;

/**
 * @author lihy
 * @version 1.0  2018/8/7
 */
public class CCBWapScanPayQueryResp extends CCBObject {

    private static final long serialVersionUID = 4209955099049558120L;

    /** 结果：Y-成功 N-失败 U-不确定 Q-待查询 */
    private String result;
    /** 订单号 */
    private String orderId;
    /** 金额，单位元，带两位小数 */
    private String amount;
    /** 等待时间：RESULT 为 Q-待查询时返回，单位:秒 */
    private String waitTime;
    /** 错误码：报错时返回 */
    private String errCode;
    /** 错误信息：报错时返回 */
    private String errMsg;
    /** 签名 */
    private String sign;

    public CCBWapScanPayQueryResp(){}

    public CCBWapScanPayQueryResp(String result, String waitTime, String errCode, String errMsg) {
        this.result = result;
        this.waitTime = waitTime;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public String getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(String waitTime) {
        this.waitTime = waitTime;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "CCBScanPayQueryRespModel{" +
                "result='" + result + '\'' +
                ", orderId='" + orderId + '\'' +
                ", amount='" + amount + '\'' +
                ", waitTime='" + waitTime + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
