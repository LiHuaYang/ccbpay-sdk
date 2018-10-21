package com.xxx.rh.rhf.sdk.ccb.domain.wap;

import com.xxx.rh.rhf.sdk.ccb.CCBObject;

import java.util.List;
import java.util.Map;

/**
 * @author lihy
 * @version 1.0  2018/8/6
 */
public class CCBWapQRCodePayQueryResp extends CCBObject {

    private static final long serialVersionUID = -4520049815267872475L;

    /** 交易返回码，成功时总为000000 */
    private String returnCode;
    /** 交易返回提示信息，成功时为空 */
    private String returnMsg;
    /** 当前页 */
    private String curPage;
    /** 总页数 */
    private String pageCount;
    /** 总笔数 */
    private String total;
    /** 支付总金额 */
    private String payAmount;
    /** 退款总金额 */
    private String refundAmount;
    /**
     <MERCHANTID>商户代码</MERCHANTID>
     <BRANCHID>商户所在分行</BRANCHID>
     <POSID>商户的POS号</POSID>
     <ORDERID>订单号</ORDERID>
     <ORDERDATE>支付/退款交易时间</ORDERDATE>
     <ACCDATE>记账日期</ACCDATE>
     <AMOUNT>支付金额</AMOUNT>
     <STATUSCODE>支付/退款状态码</STATUSCODE>
     <STATUS>支付/退款状态</STATUS>
     <REFUND>退款金额</REFUND>
     <SIGN>签名串</SIGN>
     * */
    private List<Map<String, String>> details;
/*
支付流水状态：
    STATUSCODE：0   ->   STATUS:失败
    STATUSCODE：1   ->   STATUS:成功
    STATUSCODE：2   ->   STATUS:待银行确认
    STATUSCODE：3   ->   STATUS:已部分退款
    STATUSCODE：4   ->   STATUS:已全额退款
    STATUSCODE：5   ->   STATUS:待银行确认
退款流水状态：
    STATUSCODE：0   ->   STATUS:失败
    STATUSCODE：1   ->   STATUS:成功
    STATUSCODE：2   ->   STATUS:待银行确认
    STATUSCODE：5   ->   STATUS:待银行确认

*/

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

    public String getCurPage() {
        return curPage;
    }

    public void setCurPage(String curPage) {
        this.curPage = curPage;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public List<Map<String, String>> getDetails() {
        return details;
    }

    public void setDetails(List<Map<String, String>> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "CCBQRCodePayQueryRespModel{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", curPage='" + curPage + '\'' +
                ", pageCount='" + pageCount + '\'' +
                ", total='" + total + '\'' +
                ", payAmount='" + payAmount + '\'' +
                ", refundAmount='" + refundAmount + '\'' +
                ", details=" + details +
                '}';
    }
}
