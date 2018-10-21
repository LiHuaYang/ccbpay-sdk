package com.xxx.rh.rhf.sdk.ccb.internal.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author lihy  v1.0   2018/9/9
 */
public final class TcpUtils {

	private TcpUtils(){}
	
	/**
	 * 发送TCP请求
	 * 本方法默认的连接超时和读取超时均为30秒
	 * 编码与解码请求响应字节时,均采用双方约定的字符集,即本方法的第四个参数reqCharset
	 * @param IP         远程主机地址
	 * @param port       远程主机端口
	 * @param reqData    待发送报文的中文字符串形式
	 * @param reqCharset 该方法与远程主机间通信报文的编码字符集(编码为byte[]发送到Server)
	 * @return localPort--本地绑定的端口,reqData--请求报文,respData--响应报文,respDataHex--远程主机响应的原始字节的十六进制表示
	 */
	public static byte[] send(String IP, String port, String reqData, String reqCharset) throws Exception{
		return send(IP, port, reqData, reqCharset, 30000, 30000);
	}

	public static byte[] send(String IP, String port, String reqData, String reqCharset, int connectTimeOut,int readTimeOut) throws Exception{
		byte[] bytes = null;
		OutputStream out = null;      //写
		InputStream in = null;        //读
		Socket socket = new Socket();
		try {
			socket.setTcpNoDelay(true);
			socket.setReuseAddress(true);
			socket.setSoTimeout(readTimeOut);
			socket.setSoLinger(true, 5);
			socket.setSendBufferSize(1024);
			socket.setReceiveBufferSize(1024);
			socket.setKeepAlive(true);
			socket.connect(new InetSocketAddress(IP, Integer.parseInt(port)), connectTimeOut);
			out = socket.getOutputStream();
			out.write(reqData.getBytes(reqCharset));
			in = socket.getInputStream();
			ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
			byte[] buffer = new byte[512];
			int len = -1;
			while((len=in.read(buffer)) != -1){
				bytesOut.write(buffer, 0, len);
			}
			bytes = bytesOut.toByteArray();
		} catch (Exception e) {
			throw e;
		} finally {
			if (null!=socket && socket.isConnected() && !socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {
					throw e;
				}
			}
		}
		return bytes;
	}
}
