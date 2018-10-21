package com.xxx.rh.rhf.sdk.ccb.domain.ebs;

import com.xxx.rh.rhf.sdk.ccb.CCBPayApiException;
import com.xxx.rh.rhf.sdk.ccb.internal.utils.XmlUtils;
import org.w3c.dom.Element;

/**
 * @author lihy
 * @version 1.0  2018/8/7
 */
public class CCBEbsPayQueryFileReq extends CCBEbsBaseReq {

    private static final long serialVersionUID = 6514630983421284058L;
    /** 日期：yyyyMMdd */
    private String date;
    /** 流水状态：1：已结流水（默认），0：未结流水 */
    private String kind;
    /** 文件类型：1：txt（默认），2：excel（一点接商户不支持excel文件格式下载） */
    private String fileType;
    /** 流水类型：0：支付流水；1：退款流水 */
    private String type;
    /** 排序：1：交易日期；2：订单号(已经取消) */
    private String norderBy;
    /** 柜台号：不输入为全部 */
    private String posCode;
    /** 订单号 */
    private String order;
    /** 订单状态：0：交易失败,1：交易成功,2：待银行确认(未结流水);3：全部(未结流水) */
    private String status;

    public CCBEbsPayQueryFileReq(String custId, String userId, String passWord, String date, String type) {
        super(custId, userId, passWord, "5W1005");
        this.date = date;
        this.kind = "1";
        this.fileType = "1";
        this.type = type;
        this.norderBy = "1";
        this.posCode = "";
        this.order = "";
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
        XmlUtils.appendElement(txInfo, "DATE"). setTextContent(this.date == null ? "" : this.date);
        XmlUtils.appendElement(txInfo, "KIND"). setTextContent(this.kind == null ? "" : this.kind);
        XmlUtils.appendElement(txInfo, "FILETYPE"). setTextContent(this.fileType == null ? "" : this.fileType);
        XmlUtils.appendElement(txInfo, "TYPE"). setTextContent(this.type == null ? "" : this.type);
        XmlUtils.appendElement(txInfo, "NORDERBY"). setTextContent(this.norderBy == null ? "" : this.norderBy);
        XmlUtils.appendElement(txInfo, "POS_CODE"). setTextContent(this.posCode == null ? "" : this.posCode);
        XmlUtils.appendElement(txInfo, "ORDER"). setTextContent(this.order == null ? "" : this.order);
        XmlUtils.appendElement(txInfo, "STATUS"). setTextContent(this.status == null ? "" : this.status);
        return XmlUtils.nodeToString(tx);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getNorderBy() {
        return norderBy;
    }

    public void setNorderBy(String norderBy) {
        this.norderBy = norderBy;
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
