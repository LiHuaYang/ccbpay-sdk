建行渠道 SDK
===

## 介绍

建行渠道分为 wap 平台和 ebs 平台。wap 平台的通信协议为 http，ebs 平台的通信协议是 tcp。目前建行 ebs 的提供的接口比 wap 接口丰富。如下载对账单请求只能通过 ebs 平台下载。

## 安装

maven 引入

要使用建行 sdk 的功能，需要在 pom.xml 中添加如下依赖：

```xml
<dependency>
    <groupId>com.fingard.rh.rhf.sdk</groupId>
    <artifactId>fg-ccb-sdk</artifactId>
    <version>1.1</version>
</dependency>
```

集成该 sdk 需要引入的第三方 jar 有：

```xml
<dependency>
    <groupId>commons-logging</groupId>
    <artifactId>commons-logging</artifactId>
</dependency>
        
<!-- 用于 ftp 下载 -->
<dependency>
    <groupId>commons-net</groupId>
    <artifactId>commons-net</artifactId>
</dependency>

<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
</dependency>

<dependency>
    <groupId>org.bouncycastle</groupId>
    <artifactId>bcprov-jdk15on</artifactId>
</dependency>

<!-- 建行依赖包 -->
<dependency>
    <groupId>CCB.netpay</groupId>
    <artifactId>CCB.netpay</artifactId>
</dependency>
```

## WAP 接口示例

- **地址参数**

```java
private String publicKey = "";
private String transUrl = "";
private String scanPayUrl = "";
```
- **获取二维码**

```java
String merchantId = "";
String posId = "";
String branchId = "";

String amount = "0.01";
String orderId = String.valueOf(System.currentTimeMillis());
CCBWapQRCodePayReq model = new CCBWapQRCodePayReq(merchantId, posId, branchId, orderId, amount);
model.setReturntype("3");
model.setRemark1("QT330001");
model.setRemark2("");

CCBWapQRCodePayResp resp = new CCBWapPayRequestClient().qrCodePay(model, transUrl, publicKey);
System.out.println(resp);
```

- **被扫流水查询**

```java
String merchantId = "";
String posId = "";
String branchId = "";

String opertaor = "";
String qupwd = "";
String orderId = "";

CCBWapQRCodePayQueryReq model = new CCBWapQRCodePayQueryReq(merchantId, posId, branchId,
        opertaor, qupwd, orderId);
CCBWapQRCodePayQueryResp resp = new CCBWapPayRequestClient().qrCodePayQuery(model, transUrl, publicKey);
System.out.println("二维码支付查询结果：" + resp);
```

- **主扫下单**

```java
String merchantId = "";
String posId = "";
String branchId = "";

String amount = "0.01";
String orderId = String.valueOf(System.currentTimeMillis());

String qrCode = "288538754113422258";
CCBWapScanPayReq model = new CCBWapScanPayReq(merchantId, posId, branchId, orderId, qrCode, amount);
CCBWapScanPayResp resp = new CCBWapPayRequestClient().scanPay(model, scanPayUrl, publicKey);
System.out.println("扫码支付结果：" + resp);
```

- **主扫流水查询**

```java
String merchantId = "";
String posId = "";
String branchId = "";

String orderId = "1533610631529";
String qrCodeType = "2";

CCBWapScanPayQueryReq model = new CCBWapScanPayQueryReq(merchantId, posId, branchId, orderId, qrCodeType);
CCBWapScanPayQueryResp resp = new CCBWapPayRequestClient().scanPayQuery(model, scanPayUrl, publicKey);
System.out.println("扫码支付查询结果：" + resp);
```

## EBS 接口示例

需要先启动外联平台，和 ftp 服务

- **外联平台支付流水查询（5w1002）**

```java
String merchantId = "";
String userId = "";
String password = "";

String ip = "10.60.45.119";
String port = "12345";

CCBEbsPayQueryReq model = new CCBEbsPayQueryReq(merchantId, userId, password, "5W1002", "1533610631529");
CCBEbsQueryResp resp = new CCBEbsPayRequestClient().queryTrans(model, ip, port);
System.out.println("外联平台查询返回为：" + resp);
```

- **外联平台退款流水查询（5w1003）**

```java
String merchantId = "";
String userId = "001";
String password = "";

String ip = "10.60.45.119";
String port = "12345";

CCBEbsPayQueryReq model = new CCBEbsPayQueryReq(merchantId, userId, password, "5W1003", "153361063152g");
CCBEbsQueryResp resp = new CCBEbsPayRequestClient().queryRefund(model, ip, port);
System.out.println("外联平台查询返回为：" + resp);
```


- **外联平台单笔退款交易（5W1004）**

```java
String merchantId = "";
String userId = "001";
String password = "";

String ip = "10.60.45.119";
String port = "12345";

CCBEbsRefundReq model = new CCBEbsRefundReq(merchantId, userId, password, "0.01", "1533610631529");
CCBEbsRefundResp resp = new CCBEbsPayRequestClient().refund(model, ip, port);
System.out.println("外联平台退款返回为：" + resp);
```

- **外联平台商户流水文件下载（5W1005）**

```java
String merchantId = "";
String userId = "001";
String password = "";

String ip = "10.60.45.119";
String port = "12345";

String date = "20180807";
String type = "1"; // 0：支付流水；1：退款流水

CCBEbsPayQueryFileReq model = new CCBEbsPayQueryFileReq(merchantId, userId, password, date, type);
CCBEbsPayQueryFileResp resp = new CCBEbsPayRequestClient().queryTransFileName(model, ip, port);
System.out.println("外联平台查询返回为：" + resp);
```

- **大文件下载（6W0111）**

```java
String merchantId = "";
String userId = "001";
String password = "";

String ip = "10.60.45.119";
String port = "12345";

String source = "";
String filePath = "merchant/shls";
String localRemote = "0";

CCBEbsPayDownloadFileReq model = new CCBEbsPayDownloadFileReq(merchantId, userId, password, source, filePath, localRemote);
CCBEbsPayQueryFileResp resp = new CCBEbsPayRequestClient().downloadFile(model, ip, port);
System.out.println("外联平台查询返回为：" + resp);
```

- **统一 W1005 + 6W0111 接口，若需要下载对账文件到本地，则调用此方法**

```java
String merchantId = "";
String userId = "001";
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
```