package com.xxx.rh.rhf.sdk.ccb;

import com.xxx.rh.rhf.sdk.ccb.domain.wap.*;
import org.junit.Test;

/**
 *
 * @author lihy
 * @version 1.0  2018/8/6
 */
public class CCBWapPayRequestClientTest {

    private String publicKey = "";
    private String transUrl = "";
    private String scanPayUrl = "";

    @Test
    public void testQrCodePay() throws Exception {
        String merchantId = "";
        String posId = "";
        String branchId = "";

        String amount = "0.01";
        String orderId = String.valueOf(System.currentTimeMillis());
        CCBWapQRCodePayReq model = new CCBWapQRCodePayReq(merchantId, posId, branchId, orderId, amount);
        model.setReturntype("3");
        model.setRemark1("");
        model.setRemark2("");

        CCBWapQRCodePayResp resp = new CCBWapPayRequestClient().qrCodePay(model, transUrl, publicKey);
        System.out.println(resp);
    }

    @Test
    public void testQrCodePayQuery() throws Exception {
        String merchantId = "";
        String posId = "";
        String branchId = "";

        String opertaor = "002";
        String qupwd = "";
        String orderId = "";

        CCBWapQRCodePayQueryReq model = new CCBWapQRCodePayQueryReq(merchantId, posId, branchId,
                opertaor, qupwd, orderId);
        CCBWapQRCodePayQueryResp resp = new CCBWapPayRequestClient().qrCodePayQuery(model, transUrl, publicKey);
        System.out.println("二维码支付查询结果：" + resp);
    }

    @Test
    public void testScanPay() throws Exception {
        String merchantId = "";
        String posId = "";
        String branchId = "";

        String amount = "0.01";
        String orderId = String.valueOf(System.currentTimeMillis());

        String qrCode = "288538754113422258";
        CCBWapScanPayReq model = new CCBWapScanPayReq(merchantId, posId, branchId, orderId, qrCode, amount);
        CCBWapScanPayResp resp = new CCBWapPayRequestClient().scanPay(model, scanPayUrl, publicKey);
        System.out.println("扫码支付结果：" + resp);
    }

    @Test
    public void testScanPayQuery() throws Exception {
        String merchantId = "";
        String posId = "";
        String branchId = "";

        String orderId = "";
        String qrCodeType = "2";

        CCBWapScanPayQueryReq model = new CCBWapScanPayQueryReq(merchantId, posId, branchId, orderId, qrCodeType);
        CCBWapScanPayQueryResp resp = new CCBWapPayRequestClient().scanPayQuery(model, scanPayUrl, publicKey);
        System.out.println("扫码支付查询结果：" + resp);
    }
}
