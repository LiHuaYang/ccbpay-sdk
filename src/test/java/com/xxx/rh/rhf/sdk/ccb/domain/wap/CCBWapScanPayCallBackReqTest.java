package com.xxx.rh.rhf.sdk.ccb.domain.wap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihy
 * @version 1.0  2018/8/11
 */
public class CCBWapScanPayCallBackReqTest {

    @Test
    public void consc() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("POSID", "");
        map.put("BRANCHID", "");
        map.put("ORDERID", "AC11000118081108333795546");
        map.put("PAYMENT", "1250.00");
        map.put("CURCODE", "01");
        map.put("REMARK1", "AC110001");
        map.put("REMARK2", "23");
        map.put("ACC_TYPE", "12");
        map.put("SUCCESS", "Y");
        map.put("TYPE", "1");
        map.put("REFERER", "");
        map.put("CLIENTIP", "110.75.248.3");
//        map.get("ACCDATE");
//        map.get("USRMSG");
//        map.get("USRINFO");
//        map.get("PAYTYPE");
        map.put("SIGN", "");
        CCBWapScanPayCallBackReq call = new CCBWapScanPayCallBackReq(map);
        System.out.println(call);
    }


    @Test
    public void buildSignStr() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("POSID", "");
        map.put("BRANCHID", "");
        map.put("ORDERID", "");
        map.put("PAYMENT", "1250.00");
        map.put("CURCODE", "01");
        map.put("REMARK1", "AC110001");
        map.put("REMARK2", "23");
        map.put("ACC_TYPE", "12");
        map.put("SUCCESS", "Y");
        map.put("TYPE", "1");
        map.put("REFERER", "");
        map.put("CLIENTIP", "110.75.248.3");
        map.put("ACCDATE", "");
//        map.get("USRMSG");
//        map.get("USRINFO");
//        map.get("PAYTYPE");
//        map.get("SIGN");
        CCBWapScanPayCallBackReq call = new CCBWapScanPayCallBackReq(map);
        System.out.println(call.buildSignStr());
    }

}