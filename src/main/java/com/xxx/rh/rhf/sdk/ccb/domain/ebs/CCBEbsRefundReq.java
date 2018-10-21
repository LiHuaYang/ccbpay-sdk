package com.xxx.rh.rhf.sdk.ccb.domain.ebs;

import com.xxx.rh.rhf.sdk.ccb.CCBPayApiException;
import com.xxx.rh.rhf.sdk.ccb.internal.utils.XmlUtils;
import org.w3c.dom.Element;

/**
 *
 * @author lihy
 * @version 1.0  2018/8/7
 */
public class CCBEbsRefundReq extends CCBEbsBaseReq {

    private static final long serialVersionUID = -8751589463580380679L;

    private String money;
    private String order;
    private String signInfo;
    private String signCert;

    public CCBEbsRefundReq(String custId, String userId, String passWord, String money, String order) {
        super(custId, userId, passWord, "5W1004");

        this.money = money;
        this.order = order;
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
        XmlUtils.appendElement(txInfo, "MONEY"). setTextContent(this.money == null ? "" : this.money);
        XmlUtils.appendElement(txInfo, "ORDER"). setTextContent(this.order == null ? "" : this.order);
        XmlUtils.appendElement(txInfo, "SIGN_INFO"). setTextContent(this.signInfo == null ? "" : this.signInfo);
        XmlUtils.appendElement(txInfo, "SIGNCERT"). setTextContent(this.signCert == null ? "" : this.signCert);
        return XmlUtils.nodeToString(tx);
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSignInfo() {
        return signInfo;
    }

    public void setSignInfo(String signInfo) {
        this.signInfo = signInfo;
    }

    public String getSignCert() {
        return signCert;
    }

    public void setSignCert(String signCert) {
        this.signCert = signCert;
    }
}
