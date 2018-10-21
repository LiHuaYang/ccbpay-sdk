package com.xxx.rh.rhf.sdk.ccb.domain.ebs;


import com.xxx.rh.rhf.sdk.ccb.CCBObject;

import java.util.List;
import java.util.Map;

/**
 *
 * @author lihy
 * @version 1.0  2018/8/7
 */
public class CCBEbsQueryResp extends CCBObject {

    private static final long serialVersionUID = 7022588642224716426L;

    private String requestSn;
    private String custId;
    private String txCode;
    private String language;
    private String returnCode;
    private String returnMsg;
    /** 当前页次 */
    private String curPage;
    /** 总页数 */
    private String pageCount;
    /** 提示 */
    private String notice;
    /**
     key=TRAN_DATE：交易日期
     key=ACC_DATE：记账日期
     key=ORDER：订单号
     key=ACCOUNT：付款方账号
     key=PAYMENT_MONEY：支付金额
     key=REFUND_MONEY：退款金额
     key=POS_ID：柜台号
     key=REM1：备注1
     key=REM2：备注2
     key=ORDER_STATUS：订单状态
     */
    private List<Map<String, String>> details;

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

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public List<Map<String, String>> getDetails() {
        return details;
    }

    public void setDetails(List<Map<String, String>> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "CCBEbsQueryResp{" +
                "requestSn='" + requestSn + '\'' +
                ", custId='" + custId + '\'' +
                ", txCode='" + txCode + '\'' +
                ", returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", language='" + language + '\'' +
                ", curPage='" + curPage + '\'' +
                ", pageCount='" + pageCount + '\'' +
                ", notice='" + notice + '\'' +
                ", details=" + details +
                '}';
    }
}
