package com.xxx.rh.rhf.sdk.ccb.domain.ebs;

import com.xxx.rh.rhf.sdk.ccb.CCBPayApiException;
import com.xxx.rh.rhf.sdk.ccb.internal.utils.XmlUtils;
import org.w3c.dom.Element;

/**
 * @author lihy
 * @version 1.0  2018/8/7
 */
public class CCBEbsPayQueryReq extends CCBEbsBaseReq {

    private static final long serialVersionUID = -3164148818956457153L;

    private String start;
    private String startHour;
    private String startMin;
    private String end;
    private String endHour;
    private String endMin;
    /** 流水状态：1：已结流水（默认），0：未结流水 */
    private String kind;
    /** 订单号 */
    private String order;
    private String account;
    /** 文件类型：默认为“1”，1:不压缩,2.压缩成zip文件*/
    private String dexcel;
    /** 金额，单位元，带两位小数 */
    private String money;
    /** 排序：1:交易日期,2:订单号 */
    private String norderBy;
    /** 当前页面 */
    private String page;
    /** 柜台号：不输入为全部 */
    private String posCode;
    /** 订单状态：0：交易失败,1：交易成功,2：待银行确认(未结流水);3：全部(未结流水) */
    private String status;

    /**
     * 退款查询 txCode：5W1003
     * 交易查询 txCode：5W1002
     * @author lihy  v1.0   2018/9/3
     */
    public CCBEbsPayQueryReq(String custId, String userId, String passWord, String txCode, String order) {
        super(custId, userId, passWord, txCode);

        this.order = order;
        this.start = "";
        this.startHour = "";
        this.startMin = "";
        this.end = "";
        this.endHour = "";
        this.endMin = "";
        this.kind = "1";
        this.account = "";
        this.dexcel = "1";
        this.money  = "";
        this.norderBy = "2";
        this.page = "1";
        this.posCode = "";
        this.status = "3";
    }

    public String toReqXML() throws CCBPayApiException {
        Element tx = XmlUtils.createRootElement("TX");
        XmlUtils.appendElement(tx, "REQUEST_SN"). setTextContent(this.getRequestSn() == null ? "" : this.getRequestSn());
        XmlUtils.appendElement(tx, "CUST_ID"). setTextContent(this.getCustId() == null ? "" : this.getCustId());
        XmlUtils.appendElement(tx, "USER_ID"). setTextContent(this.getUserId() == null ? "" : this.getUserId());
        XmlUtils.appendElement(tx, "PASSWORD"). setTextContent(this.getPassWord()== null ? "" : this.getPassWord());
        XmlUtils.appendElement(tx, "TX_CODE"). setTextContent(this.getTxCode() == null ? "" : this.getTxCode());
        XmlUtils.appendElement(tx, "LANGUAGE"). setTextContent(this.getLanguage() == null ? "" : getLanguage());
        Element txInfo = XmlUtils.appendElement(tx, "TX_INFO");
        XmlUtils.appendElement(txInfo, "START"). setTextContent(this.start == null ? "" : this.start);
        XmlUtils.appendElement(txInfo, "STARTHOUR"). setTextContent(this.startHour == null ? "" : this.startHour);
        XmlUtils.appendElement(txInfo, "STARTMIN"). setTextContent(this.startMin == null ? "" : this.startMin);
        XmlUtils.appendElement(txInfo, "END"). setTextContent(this.end == null ? "" : this.end);
        XmlUtils.appendElement(txInfo, "ENDHOUR"). setTextContent(this.endHour == null ? "" : this.endHour);
        XmlUtils.appendElement(txInfo, "ENDMIN"). setTextContent(this.endMin == null ? "" : this.endMin);
        XmlUtils.appendElement(txInfo, "KIND"). setTextContent(this.kind == null ? "" : this.kind);
        XmlUtils.appendElement(txInfo, "ORDER"). setTextContent(this.order == null ? "" : this.order);
        XmlUtils.appendElement(txInfo, "ACCOUNT"). setTextContent(this.account == null ? "" : this.account);
        XmlUtils.appendElement(txInfo, "DEXCEL"). setTextContent(this.dexcel == null ? "" : this.dexcel);
        XmlUtils.appendElement(txInfo, "MONEY"). setTextContent(this.money == null ? "" : this.money);
        XmlUtils.appendElement(txInfo, "NORDERBY"). setTextContent(this.norderBy == null ? "" : this.norderBy);
        XmlUtils.appendElement(txInfo, "PAGE"). setTextContent(this.page == null ? "" : this.page);
        XmlUtils.appendElement(txInfo, "POS_CODE"). setTextContent(this.posCode == null ? "" : this.posCode);
        XmlUtils.appendElement(txInfo, "STATUS"). setTextContent(this.status == null ? "" : this.status);
        return XmlUtils.nodeToString(tx);
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getStartMin() {
        return startMin;
    }

    public void setStartMin(String startMin) {
        this.startMin = startMin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getEndMin() {
        return endMin;
    }

    public void setEndMin(String endMin) {
        this.endMin = endMin;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDexcel() {
        return dexcel;
    }

    public void setDexcel(String dexcel) {
        this.dexcel = dexcel;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getNorderBy() {
        return norderBy;
    }

    public void setNorderBy(String norderBy) {
        this.norderBy = norderBy;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPosCode() {
        return posCode;
    }

    public void setPosCode(String posCode) {
        this.posCode = posCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
