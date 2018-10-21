package com.xxx.rh.rhf.sdk.ccb;

import com.xxx.rh.rhf.sdk.ccb.domain.ebs.*;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lihy
 * @version 1.0  2018/8/7
 */
public class CCBEbsPayRequestClientTest {

    @Test
    public void queryTrans() throws Exception {
        String merchantId = "";
        String userId = "";
        String password = "";

        String ip = "10.60.45.119";
        String port = "12345";

        CCBEbsPayQueryReq model = new CCBEbsPayQueryReq(merchantId, userId, password, "5W1002", "1533610631529");
        CCBEbsQueryResp resp = new CCBEbsPayRequestClient().queryTrans(model, ip, port);
        System.out.println("外联平台查询返回为：" + resp);
    }

    @Test
    public void queryRefund() throws Exception {
        String merchantId = "";
        String userId = "";
        String password = "";

        String ip = "10.60.45.119";
        String port = "12345";

        CCBEbsPayQueryReq model = new CCBEbsPayQueryReq(merchantId, userId, password, "5W1003", "153361063152g");
        CCBEbsQueryResp resp = new CCBEbsPayRequestClient().queryRefund(model, ip, port);
        System.out.println("外联平台查询返回为：" + resp);
    }

    @Test
    public void refund() throws Exception {
        String merchantId = "";
        String userId = "";
        String password = "";

        String ip = "10.60.45.119";
        String port = "12345";

        CCBEbsRefundReq model = new CCBEbsRefundReq(merchantId, userId, password, "0.01", "1533610631529");
        CCBEbsRefundResp resp = new CCBEbsPayRequestClient().refund(model, ip, port);
        System.out.println("外联平台退款返回为：" + resp);
    }

    @Test
    public void queryTransFileName() throws Exception {
        String merchantId = "";
        String userId = "";
        String password = "";

        String ip = "10.60.45.119";
        String port = "12345";

        String date = "20180807";
        String type = "1"; // 0：支付流水；1：退款流水

        CCBEbsPayQueryFileReq model = new CCBEbsPayQueryFileReq(merchantId, userId, password, date, type);
        CCBEbsPayQueryFileResp resp = new CCBEbsPayRequestClient().queryTransFileName(model, ip, port);
        System.out.println("外联平台查询返回为：" + resp);
    }

    @Test
    public void downloadFile() throws Exception {
        String merchantId = "";
        String userId = "";
        String password = "";

        String ip = "10.60.45.119";
        String port = "12345";

        String source = "SHOP.105331000004201.20180807.20180807.20180808161500342.MvXZ.zip";
        String filePath = "merchant/shls";
        String localRemote = "0";

        CCBEbsPayDownloadFileReq model = new CCBEbsPayDownloadFileReq(merchantId, userId, password, source, filePath, localRemote);
        CCBEbsPayQueryFileResp resp = new CCBEbsPayRequestClient().downloadFile(model, ip, port);
        System.out.println("外联平台查询返回为：" + resp);
    }

    @Test
    public void downLoadReconciliationFile() throws Exception {
        String merchantId = "";
        String userId = "";
        String password = "";

        String ip = "10.60.45.119";
        String port = "12345";

        String date = "20180807";
        String type = "1"; // 0：支付流水；1：退款流水

        String filePath = "C:\\Users\\pc\\Desktop\\aaa.zip";

        CCBEbsPayQueryFileReq model = new CCBEbsPayQueryFileReq(merchantId, userId, password, date, type);
        Map<String, String> ftpConfig = new HashMap<>();
        ftpConfig.put("ftp.ip", "10.60.45.119");
        ftpConfig.put("ftp.port", "21");
        ftpConfig.put("ftp.userName", "pc");
        ftpConfig.put("ftp.passWord", "qaz");

        File resp = new CCBEbsPayRequestClient().downLoadReconciliationFile(model, ip, port, ftpConfig, filePath);
        System.out.println("外联平台查询返回为：" + resp.getAbsolutePath());
    }
}