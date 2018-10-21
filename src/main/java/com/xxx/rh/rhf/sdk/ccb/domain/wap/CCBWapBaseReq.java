package com.xxx.rh.rhf.sdk.ccb.domain.wap;

import com.xxx.rh.rhf.sdk.ccb.CCBObject;

/**
 * wap 平台请求 model 基类
 * @author lihy
 * @version 1.0  2018/8/7
 */
public class CCBWapBaseReq extends CCBObject {

    private static final long serialVersionUID = -2565192951743932663L;

    /** 商户代码      CHAR(15) */
    private String merchantId;
    /** 商户柜台代码  CHAR(9) */
    private String posId;
    /** 分行代码      CHAR(9) */
    private String branchId;
    /** 交易码       CHAR(6)*/
    private String txCode;

    public CCBWapBaseReq(String merchantId, String posId, String branchId, String txCode) {
        this.merchantId = merchantId;
        this.posId = posId;
        this.branchId = branchId;
        this.txCode = txCode;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getTxCode() {
        return txCode;
    }

    public void setTxCode(String txCode) {
        this.txCode = txCode;
    }
}
