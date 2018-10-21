package com.xxx.rh.rhf.sdk.ccb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author lihy
 * @version 1.0  2018/8/7
 */
public class CCBPayBaseRequestClient extends CCBObject {

    protected Log logger = LogFactory.getLog(this.getClass());

    /** 连接超时 */
    private int connectTimeOut = 30000;
    /** 读超时*/
    private int readTimeOut = 30000;

    public int getConnectTimeOut() {
        return connectTimeOut;
    }

    public void setConnectTimeOut(int connectTimeOut) {
        this.connectTimeOut = connectTimeOut;
    }

    public int getReadTimeOut() {
        return readTimeOut;
    }

    public void setReadTimeOut(int readTimeOut) {
        this.readTimeOut = readTimeOut;
    }
}
