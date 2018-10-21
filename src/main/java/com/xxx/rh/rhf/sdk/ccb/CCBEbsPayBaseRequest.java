package com.xxx.rh.rhf.sdk.ccb;


import com.xxx.rh.rhf.sdk.ccb.internal.utils.FTPUtils;
import com.xxx.rh.rhf.sdk.ccb.internal.utils.StringUtils;
import com.xxx.rh.rhf.sdk.ccb.internal.utils.TcpUtils;
import com.xxx.rh.rhf.sdk.ccb.internal.utils.XmlUtils;
import com.xxx.rh.rhf.sdk.ccb.domain.ebs.*;
import org.apache.commons.net.ftp.FTPClient;
import org.w3c.dom.Element;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.*;

/**
 * 建行 Ebs 支付
 * replaced by CCBEbsPayRequestClient
 * @see CCBEbsPayRequestClient
 * @author lihy
 * @version 1.0  2018/8/7
 */
@Deprecated
public class CCBEbsPayBaseRequest extends CCBPayBaseRequestClient {

    /**
     * 外联平台支付流水查询（5w1002）
     * @author lihy  v1.0   2018/8/7
     */
    public CCBEbsQueryResp queryTrans(CCBEbsPayQueryReq model, String ip, String port) throws CCBPayApiException {
        try {
            String reqXml = model.toReqXML();
            logger.info("建行(ebs)交易流水查询，请求报文为：" + reqXml);

            byte[] respBytes = TcpUtils.send(ip, port, reqXml, CCBPayConstants.CHARSET_GBK);
            if (null == respBytes) {
                throw new CCBPayApiException("建行(ebs)交易流水查询异常，外联平台返回为空");
            }
            String respXml = new String(respBytes, CCBPayConstants.CHARSET_GBK).replaceAll("\r\n", "");
            logger.info("建行(ebs)交易流水查询，建行端响应报文：" + respXml);

            //解析返回报文
            Element tx = XmlUtils.getRootElementFromStream(new ByteArrayInputStream(respXml.getBytes(CCBPayConstants.CHARSET_GBK)));

            CCBEbsQueryResp resp = new CCBEbsQueryResp();
            resp.setReturnCode(XmlUtils.getElementValue(tx, "RETURN_CODE"));
            resp.setReturnMsg(XmlUtils.getElementValue(tx, "RETURN_MSG"));
            resp.setRequestSn(XmlUtils.getElementValue(tx, "REQUEST_SN"));
            resp.setCustId(XmlUtils.getElementValue(tx, "CUST_ID"));
            resp.setTxCode(XmlUtils.getElementValue(tx, "TX_CODE"));
            resp.setLanguage(XmlUtils.getElementValue(tx, "LANGUAGE"));

            // 如果节点不为空，继续组装实体类
            Element txInfo = XmlUtils.getChildElement(tx, "TX_INFO");
            if (txInfo == null) {
                return resp;
            }
            resp.setCurPage(XmlUtils.getElementValue(txInfo, "CUR_PAGE"));
            resp.setPageCount(XmlUtils.getElementValue(txInfo, "PAGE_COUNT"));
            resp.setNotice(XmlUtils.getElementValue(txInfo, "NOTICE"));

            List<Element> orderEles = XmlUtils.getChildElements(txInfo, "LIST");
            if (orderEles == null || orderEles.isEmpty()) {
                return resp;
            }
            List<Map<String, String>> details = new ArrayList<>();
            for (Element orderEle : orderEles) {
                Map<String, String> map = new HashMap<>();
                map.put("TRAN_DATE", XmlUtils.getElementValue(orderEle, "TRAN_DATE"));
                map.put("ACC_DATE", XmlUtils.getElementValue(orderEle, "ACC_DATE"));
                map.put("ORDER", XmlUtils.getElementValue(orderEle, "ORDER"));
                map.put("ACCOUNT", XmlUtils.getElementValue(orderEle, "ACCOUNT"));
                map.put("ACC_NAME", XmlUtils.getElementValue(orderEle, "ACC_NAME"));
                map.put("PAYMENT_MONEY", XmlUtils.getElementValue(orderEle, "PAYMENT_MONEY"));
                map.put("REFUND_MONEY", XmlUtils.getElementValue(orderEle, "REFUND_MONEY"));
                map.put("POS_ID", XmlUtils.getElementValue(orderEle, "POS_ID"));
                map.put("REM1", XmlUtils.getElementValue(orderEle, "REM1"));
                map.put("REM2", XmlUtils.getElementValue(orderEle, "REM2"));
                map.put("ORDER_STATUS", XmlUtils.getElementValue(orderEle, "ORDER_STATUS"));
                details.add(map);
            }
            resp.setDetails(details);
            return resp;
        } catch (Exception ex) {
            logger.error("建行(ebs)交易流水查询异常", ex);
            throw new CCBPayApiException(ex);
        }
    }

    /**
     * 外联平台退款流水查询（5w1003）
     * @author lihy  v1.0   2018/8/7
     */
    public CCBEbsQueryResp queryRefund(CCBEbsPayQueryReq model, String ip, String port) throws CCBPayApiException {
        try {
            String reqXml = model.toReqXML();
            logger.info("建行(ebs)退款流水查询，请求报文为：" + reqXml);

            byte[] respBytes = TcpUtils.send(ip, port, reqXml, CCBPayConstants.CHARSET_GBK);
            String respXml = new String(respBytes, CCBPayConstants.CHARSET_GBK).replaceAll("\r\n", "");
            logger.info("建行(ebs)退款流水查询，建行端响应报文为：" + respXml);

            //解析返回报文
            Element tx = XmlUtils.getRootElementFromStream(new ByteArrayInputStream(respXml.getBytes(CCBPayConstants.CHARSET_GBK)));

            CCBEbsQueryResp resp = new CCBEbsQueryResp();
            resp.setReturnCode(XmlUtils.getElementValue(tx, "RETURN_CODE"));
            resp.setReturnMsg(XmlUtils.getElementValue(tx, "RETURN_MSG"));
            resp.setRequestSn(XmlUtils.getElementValue(tx, "REQUEST_SN"));
            resp.setCustId(XmlUtils.getElementValue(tx, "CUST_ID"));
            resp.setTxCode(XmlUtils.getElementValue(tx, "TX_CODE"));
            resp.setLanguage(XmlUtils.getElementValue(tx, "LANGUAGE"));

            // 如果节点不为空，继续组装实体类
            Element txInfo = XmlUtils.getChildElement(tx, "TX_INFO");
            if (txInfo == null) {
                return resp;
            }
            resp.setCurPage(XmlUtils.getElementValue(txInfo, "CUR_PAGE"));
            resp.setPageCount(XmlUtils.getElementValue(txInfo, "TPAGE"));
            resp.setNotice(XmlUtils.getElementValue(txInfo, "NOTICE"));

            List<Element> orderEles = XmlUtils.getChildElements(txInfo, "LIST");
            if (orderEles == null || orderEles.isEmpty()) {
                return resp;
            }
            List<Map<String, String>> details = new ArrayList<>();
            for (Element orderEle : orderEles) {
                Map<String, String> map = new HashMap<>();
                map.put("TRAN_DATE", XmlUtils.getElementValue(orderEle, "TRAN_DATE"));
                map.put("REFUND_DATE", XmlUtils.getElementValue(orderEle, "REFUND_DATE"));
                map.put("ORDER_NUMBER", XmlUtils.getElementValue(orderEle, "ORDER_NUMBER"));
                map.put("REFUND_ACCOUNT", XmlUtils.getElementValue(orderEle, "REFUND_ACCOUNT"));
                map.put("PAY_AMOUNT", XmlUtils.getElementValue(orderEle, "PAY_AMOUNT"));
                map.put("REFUNDEMENT_AMOUNT", XmlUtils.getElementValue(orderEle, "REFUNDEMENT_AMOUNT"));
                map.put("REFUND_MONEY", XmlUtils.getElementValue(orderEle, "REFUND_MONEY"));
                map.put("POS_CODE", XmlUtils.getElementValue(orderEle, "POS_CODE"));
                map.put("USERID", XmlUtils.getElementValue(orderEle, "USERID"));
                map.put("STATUS", XmlUtils.getElementValue(orderEle, "STATUS"));
                details.add(map);
            }
            return resp;
        } catch (Exception e) {
            logger.error("建行(ebs)退款流水查询异常", e);
            throw new CCBPayApiException(e);
        }
    }

    /**
     * 外联平台单笔退款交易（5W1004）
     * @author lihy  v1.0   2018/8/7
     */
    public CCBEbsRefundResp refund(CCBEbsRefundReq model, String ip, String port) throws CCBPayApiException {
        try {
            String reqXml = model.toReqXML();
            logger.info("建行(ebs)单笔退款，请求报文为：" + reqXml);
            byte[] respBytes = TcpUtils.send(ip, port, reqXml, CCBPayConstants.CHARSET_GBK);
            if (respBytes == null) {
                throw new CCBPayApiException("建行(ebs)单笔退款异常，外联平台返回为空");
            }
            String respXml = new String(respBytes, CCBPayConstants.CHARSET_GBK).replaceAll("\r\n", "");
            logger.info("建行(ebs)单笔退款，建行端响应报文为：" + respXml);
            // 解析返回报文
            Element tx = XmlUtils.getRootElementFromStream(new ByteArrayInputStream(respXml.getBytes(CCBPayConstants.CHARSET_GBK)));

            CCBEbsRefundResp resp = new CCBEbsRefundResp();
            resp.setReturnCode(XmlUtils.getElementValue(tx, "RETURN_CODE"));
            resp.setReturnMsg(XmlUtils.getElementValue(tx, "RETURN_MSG"));
            resp.setRequestSn(XmlUtils.getElementValue(tx, "REQUEST_SN"));
            resp.setCustId(XmlUtils.getElementValue(tx, "CUST_ID"));
            resp.setTxCode(XmlUtils.getElementValue(tx, "TX_CODE"));
            resp.setLanguage(XmlUtils.getElementValue(tx, "LANGUAGE"));

            Element txInfo = XmlUtils.getChildElement(tx, "TX_INFO");
            if (txInfo == null) {
                return resp;
            }
            resp.setOrderNum(XmlUtils.getElementValue(txInfo, "ORDER_NUM"));
            resp.setPayAmount(XmlUtils.getElementValue(txInfo, "PAY_AMOUNT"));
            resp.setAmount(XmlUtils.getElementValue(txInfo, "AMOUNT"));
            return resp;
        } catch (Exception e) {
            logger.error("建行(ebs)单笔退款异常", e);
            throw new CCBPayApiException(e);
        }
    }

    /**
     * 外联平台商户流水文件下载（5W1005）
     * @author lihy  v1.0   2018/8/8
     */
    public CCBEbsPayQueryFileResp queryTransFileName(CCBEbsPayQueryFileReq model, String ip, String port) throws CCBPayApiException {
        try {
            String reqXml = model.toReqXML();
            logger.info("建行(ebs)商户流水文件下载，请求报文为：" + reqXml);
            byte[] respBytes = TcpUtils.send(ip, port, reqXml, CCBPayConstants.CHARSET_GBK);
            if (respBytes == null) {
                throw new CCBPayApiException("建行(ebs)商户流水文件下载，外联平台返回为空");
            }
            String respXml = new String(respBytes, CCBPayConstants.CHARSET_GBK).replaceAll("\r\n", "");
            logger.info("建行(ebs)商户流水文件下载，建行端响应报文为：" + respXml);
            // 解析返回报文
            Element tx = XmlUtils.getRootElementFromStream(new ByteArrayInputStream(respXml.getBytes(CCBPayConstants.CHARSET_GBK)));

            CCBEbsPayQueryFileResp resp = new CCBEbsPayQueryFileResp();
            resp.setReturnCode(XmlUtils.getElementValue(tx, "RETURN_CODE"));
            resp.setReturnMsg(XmlUtils.getElementValue(tx, "RETURN_MSG"));
            resp.setRequestSn(XmlUtils.getElementValue(tx, "REQUEST_SN"));
            resp.setCustId(XmlUtils.getElementValue(tx, "CUST_ID"));
            resp.setTxCode(XmlUtils.getElementValue(tx, "TX_CODE"));
            resp.setLanguage(XmlUtils.getElementValue(tx, "LANGUAGE"));

            Element txInfo = XmlUtils.getChildElement(tx, "TX_INFO");
            if (txInfo == null) {
                return resp;
            }
            resp.setFileName(XmlUtils.getElementValue(txInfo, "FILE_NAME"));
            resp.setNotice(XmlUtils.getElementValue(txInfo, "NOTICE"));
            return resp;
        } catch (Exception e) {
            logger.error("建行(ebs)商户流水文件下载异常", e);
            throw new CCBPayApiException(e);
        }
    }

    /**
     * 大文件下载（6W0111）
     * @author lihy  v1.0   2018/8/8
     */
    public CCBEbsPayQueryFileResp downloadFile(CCBEbsPayDownloadFileReq model, String ip, String port) throws CCBPayApiException {
        try {
            String reqXml = model.toReqXML();
            logger.info("建行(ebs)商户流水文件下载，请求报文为：" + reqXml);
            byte[] respBytes = TcpUtils.send(ip, port, reqXml, CCBPayConstants.CHARSET_GBK);
            if (respBytes == null) {
                throw new CCBPayApiException("建行(ebs)商户流水文件下载，外联平台返回为空");
            }
            String respXml = new String(respBytes, CCBPayConstants.CHARSET_GBK).replaceAll("\r\n", "");
            logger.info("建行(ebs)商户流水文件下载，建行端响应报文为：" + respXml);
            // 解析返回报文
            Element tx = XmlUtils.getRootElementFromStream(new ByteArrayInputStream(respXml.getBytes(CCBPayConstants.CHARSET_GBK)));

            CCBEbsPayQueryFileResp resp = new CCBEbsPayQueryFileResp();
            resp.setReturnCode(XmlUtils.getElementValue(tx, "RETURN_CODE"));
            resp.setReturnMsg(XmlUtils.getElementValue(tx, "RETURN_MSG"));
            resp.setRequestSn(XmlUtils.getElementValue(tx, "REQUEST_SN"));
            resp.setCustId(XmlUtils.getElementValue(tx, "CUST_ID"));
            resp.setTxCode(XmlUtils.getElementValue(tx, "TX_CODE"));
            resp.setLanguage(XmlUtils.getElementValue(tx, "LANGUAGE"));

            return resp;
        } catch (Exception e) {
            logger.error("建行(ebs)商户流水文件下载异常", e);
            throw new CCBPayApiException(e);
        }
    }


    /**
     * 统一 W1005 + 6W0111 接口，若需要下载对账文件到本地，则调用此方法
     * ftoConfig
     *      key：ftp.ip 外联平台 ftp 地址
     *      key：ftp.port 外联平台 ftp 端口号
     *      key：ftp.userName 外联平台 ftp 用户名
     *      key：ftp.passWord 外联平台 ftp 密码
     * @author lihy  v1.0   2018/8/14
     */
    public File downLoadReconciliationFile(CCBEbsPayQueryFileReq model, String ip, String port, Map<String, String> ftpConfig, String filePath) throws CCBPayApiException {
        // 5W1005
        logger.info("调用 5W1005 接口生成所需要的回单文件");
        CCBEbsPayQueryFileResp resp1 = this.queryTransFileName(model, ip, port);
        String fileName = queryTransFileName(model, ip, port).getFileName();
        if (StringUtils.isBlank(fileName)) {
            return null;
        }
        logger.info("调用 5W1005 接口生成所需要的回单文件，文件名为：" + fileName);

        // 6W0111
        logger.info("调用 6W0111 接口下载回单文件到外联平台");
        CCBEbsPayDownloadFileReq model1 = new CCBEbsPayDownloadFileReq(model.getCustId(), model.getUserId(),
                model.getPassWord(), fileName, "merchant/shls", "0");
        downloadFile(model1, ip, port);
        logger.info("调用 6W0111 接口下载回单文件到外联平台，成功");

        // FTP 下载
        logger.info("从外联平台下载回单文件");
        try {
            FTPClient ftpClient = new FTPClient();
            String ftpIp = ftpConfig.get("ftp.ip");
            String ftpPort = ftpConfig.get("ftp.port");
            String ftpUserName = ftpConfig.get("ftp.userName");
            String ftpPassWord = ftpConfig.get("ftp.passWord");
            if (!FTPUtils.connect(ftpClient, ftpIp, Integer.valueOf(ftpPort), ftpUserName, ftpPassWord)) {
                return null;
            }
            if (!FTPUtils.download(ftpClient, "/", fileName, filePath)) {
                return null;
            }
        } catch (Exception e) {
            throw new CCBPayApiException(e);
        }
        return new File(filePath);
    }
}
