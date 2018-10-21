package com.xxx.rh.rhf.sdk.ccb.domain.ebs;

import com.xxx.rh.rhf.sdk.ccb.CCBPayApiException;
import com.xxx.rh.rhf.sdk.ccb.internal.utils.XmlUtils;
import org.w3c.dom.Element;

/**
 * @author lihy
 * @version 1.0  2018/8/8
 */
public class CCBEbsPayDownloadFileReq extends CCBEbsBaseReq {
    private static final long serialVersionUID = -2742662202825772407L;

    /** 要下载的文件名称：要下载的文件名，如：CBB1172476199728 */
    private String source;
    /** 文件路径：要下载文件的路径:merchant/shls,必须填该值 */
    private String filePath;
    /** 下载路径标志：一般为 0 */
    private String localRemote;

    public CCBEbsPayDownloadFileReq(String custId, String userId, String passWord,
                                    String source, String filePath, String localRemote) {
        super(custId, userId, passWord, "6W0111");
        this.source = source;
        this.filePath = filePath;
        this.localRemote = localRemote;
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
        XmlUtils.appendElement(txInfo, "SOURCE"). setTextContent(this.source == null ? "" : this.source);
        XmlUtils.appendElement(txInfo, "FILEPATH"). setTextContent(this.filePath == null ? "" : this.filePath);
        XmlUtils.appendElement(txInfo, "LOCAL_REMOTE"). setTextContent(this.localRemote == null ? "" : this.localRemote);
        return XmlUtils.nodeToString(tx);
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getLocalRemote() {
        return localRemote;
    }

    public void setLocalRemote(String localRemote) {
        this.localRemote = localRemote;
    }
}
