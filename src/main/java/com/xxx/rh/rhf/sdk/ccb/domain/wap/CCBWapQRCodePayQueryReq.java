package com.xxx.rh.rhf.sdk.ccb.domain.wap;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lihy
 * @version 1.0  2018/8/7
 */
public class CCBWapQRCodePayQueryReq extends CCBWapBaseReq {

    private static final long serialVersionUID = -6213429763679287950L;

    /** 操作员 */
    private String operator;
    /** 查询密码：主管或操作员的登录密码 */
    private String quPwd;
    /** 查询定单的日期，格式为YYYYMMDD，共8位。例如:20050607(表示2005年6月7日) （ORDERDATE与ORDERID必须有一个输入）*/
    private String orderDate;
    /**
     * 订单开始时间：查询定单的开始时间，格式为hh，共8位，如00:00:00。
     * - 合法的时间格式：00   00:00   03:34:23   23:59:59   如果只有2位数字，最大为24，否则为23 。2位数字可解释为分钟和秒的值都为0，如12相当于12:00:00，。分钟和秒的最大值为59。
     * - 非法的时间格式：25   24:00   23:60   23,59,59   23:59:61   0:12:2
     * （已结算流水查询只支持按日期查询，时间只参与MAC运算。未结算流水查询支持按时间段查询。不输入时默认为00:00:00）
     */
    private String begorderTime;
    /** 同上 */
    private String endorderTime;
    /** 订单号：输入订单号则只按订单号查询，时间段与日期即使输入也不起作用。不输入订单号，则按日期与时间段查询 */
    private String orderId;
    /** 流水类型：0支付流水 1退款流水*/
    private String type;
    /** 流水状态：0 未结算流水 1 已结算流水*/
    private String kind;
    /** 交易状态：0失败 1成功 2不确定 3全部（已结算流水查询不支持全部） */
    private String status;
    /** 查询方式：1页面形式 2文件返回形式 (提供TXT和XML格式文件的下载) 3 XML页面形式 */
    private String selType;
    /** 页码*/
    private String page;
    /** 预留字段 */
    private String channel;

    public CCBWapQRCodePayQueryReq(String merchantId, String posId, String branchId,
                                   String operator, String quPwd, String orderId) {
        super(merchantId, posId, branchId, "410408");

        this.operator = operator;
        this.quPwd = quPwd;
        this.orderId = orderId;

        this.orderDate = "";
        this.begorderTime = "";
        this.endorderTime = "";
        this.type = "0";
        this.kind = "0";
        this.status = "3";
        this.selType = "3";
        this.page = "1";
        this.channel = "";
    }

    public Map<String, String> toReqMap() {
        Map<String, String> reqParams = new HashMap<>();
        reqParams.put("MERCHANTID", this.getMerchantId()==null ? "" : this.getMerchantId());
        reqParams.put("POSID", this.getPosId()==null ? "" : this.getPosId());
        reqParams.put("BRANCHID", this.getBranchId()==null ? "" : this.getBranchId());
        reqParams.put("OPERATOR", this.getOperator()==null ? "" : this.getOperator());
        reqParams.put("QUPWD", this.getQuPwd()==null ? "" : this.getQuPwd());

        reqParams.put("ORDERDATE", this.getOrderDate()==null ? "" : this.getOrderDate());
        reqParams.put("BEGORDERTIME", this.getBegorderTime()==null ? "" : this.getBegorderTime());
        reqParams.put("ENDORDERTIME", this.getEndorderTime()==null ? "" : this.getEndorderTime());
        reqParams.put("ORDERID", this.getOrderId()==null ? "" : this.getOrderId());
        reqParams.put("TXCODE", this.getTxCode()==null ? "" : this.getTxCode());
        reqParams.put("TYPE", this.getType()==null ? "" : this.getType());
        reqParams.put("KIND", this.getKind()==null ? "" : this.getKind());
        reqParams.put("STATUS", this.getStatus()==null ? "" : this.getStatus());
        reqParams.put("SEL_TYPE", this.getSelType()==null ? "" : this.getSelType());
        reqParams.put("PAGE", this.getPage()==null ? "" : this.getPage());
        reqParams.put("CHANNEL", this.getChannel()==null ? "" : this.getChannel());

        return reqParams;
    }

    /**
     * 拼接签名字符串
     * @author lihy  v1.0   2018/8/21
     */
    public String buildSignStr() {
        StringBuilder sb = new StringBuilder();
        sb.append("MERCHANTID=").append(this.getMerchantId()== null ? "" : this.getMerchantId());
        sb.append("&BRANCHID=").append(this.getBranchId()== null ? "" : this.getBranchId());
        sb.append("&POSID=").append(this.getPosId()== null ? "" : this.getPosId());
        sb.append("&ORDERDATE=").append(this.getOrderDate()== null ? "" : this.getOrderDate());
        sb.append("&BEGORDERTIME=").append(this.getBegorderTime()== null ? "" : this.getBegorderTime());
        sb.append("&ENDORDERTIME=").append(this.getEndorderTime()== null ? "" : this.getEndorderTime());
        sb.append("&ORDERID=").append(this.getOrderId()== null ? "" : this.getOrderId());
        sb.append("&QUPWD=").append("");
        sb.append("&TXCODE=").append(this.getTxCode()== null ? "" : this.getTxCode());
        sb.append("&TYPE=").append(this.getType()== null ? "" : this.getType());
        sb.append("&KIND=").append(this.getKind()== null ? "" : this.getKind());
        sb.append("&STATUS=").append(this.getStatus()== null ? "" : this.getStatus());
        sb.append("&SEL_TYPE=").append(this.getSelType()== null ? "" : this.getSelType());
        sb.append("&PAGE=").append(this.getPage()== null ? "" : this.getPage());
        sb.append("&OPERATOR=").append(this.getOperator()== null ? "" : this.getOperator());
        sb.append("&CHANNEL=").append(this.getChannel()== null ? "" : this.getChannel());
        return sb.toString();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getQuPwd() {
        return quPwd;
    }

    public void setQuPwd(String quPwd) {
        this.quPwd = quPwd;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getBegorderTime() {
        return begorderTime;
    }

    public void setBegorderTime(String begorderTime) {
        this.begorderTime = begorderTime;
    }

    public String getEndorderTime() {
        return endorderTime;
    }

    public void setEndorderTime(String endorderTime) {
        this.endorderTime = endorderTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSelType() {
        return selType;
    }

    public void setSelType(String selType) {
        this.selType = selType;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
