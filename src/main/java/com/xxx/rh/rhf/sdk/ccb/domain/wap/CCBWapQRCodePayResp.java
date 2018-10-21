package com.xxx.rh.rhf.sdk.ccb.domain.wap;

import com.xxx.rh.rhf.sdk.ccb.CCBObject;

/**
 * @author lihy
 * @version 1.0  2018/8/6
 */
public class CCBWapQRCodePayResp extends CCBObject {
    private static final long serialVersionUID = -6207568405277728200L;
    /** 成功标志：true 或 false */
    private String success;
    /** 链接地址 */
    private String qrurl;

    public CCBWapQRCodePayResp(String success, String qrurl) {
        this.success = success;
        this.qrurl = qrurl;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getQrurl() {
        return qrurl;
    }

    public void setQrurl(String qrurl) {
        this.qrurl = qrurl;
    }

    @Override
    public String toString() {
        return "CCBQRCodePayRespModel{" +
                "success='" + success + '\'' +
                ", qrurl='" + qrurl + '\'' +
                '}';
    }
}
