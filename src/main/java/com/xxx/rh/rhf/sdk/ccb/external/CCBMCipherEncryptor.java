package com.xxx.rh.rhf.sdk.ccb.external;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.*;

public final class CCBMCipherEncryptor {
	private String encryptKey = "9R@e8Y3#";

	static {
		if (Security.getProvider("BC") == null) {
			Security.addProvider(new BouncyCastleProvider());
		}
	}

	public CCBMCipherEncryptor(String key) {
		this.encryptKey = key.substring(0, 8);
	}

	public String getEncryptKey() {
		return this.encryptKey;
	}

	public void setEncryptKey(String encryptKey) {
		this.encryptKey = encryptKey.substring(0, 8);
	}

	private static byte[] wrapBytes(byte[] srcBytes, byte[] wrapKey) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, ShortBufferException, IllegalBlockSizeException,
			BadPaddingException, NoSuchProviderException, InvalidAlgorithmParameterException {
		SecretKeySpec key = new SecretKeySpec(wrapKey, "DES");

		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding", "BC");

		cipher.init(1, key);

		byte[] cipherText = cipher.doFinal(srcBytes);

		return cipherText;
	}

	public static String EncodeBase64String(byte[] srcBytes) {
		try {
			String base64Result = new String(new Base64().encode(srcBytes), "utf-8");
			return base64Result;
		} catch (Exception e) {
			// ....
			return "";
		}
	}

	public String getEncodeString(String srcString) throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, ShortBufferException, IllegalBlockSizeException, BadPaddingException,
			NoSuchProviderException, InvalidAlgorithmParameterException, UnsupportedEncodingException {
		byte[] cipherBytes = wrapBytes(srcString.getBytes("ISO-8859-1"), this.encryptKey.getBytes("ISO-8859-1"));
		String basedString = EncodeBase64String(cipherBytes);
		String resultString = basedString.replaceAll("\\+", ",");
		return URLEncoder.encode(resultString, "ISO-8859-1");
	}

	public String doEncrypt(String srcString) throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, ShortBufferException, IllegalBlockSizeException, BadPaddingException,
			NoSuchProviderException, InvalidAlgorithmParameterException, UnsupportedEncodingException {
		byte[] cipherBytes = wrapBytes(srcString.getBytes("utf-16"), this.encryptKey.getBytes("ISO-8859-1"));

		String basedString = EncodeBase64String(cipherBytes);
		String resultString = basedString.replaceAll("\\+", ",");

		return URLEncoder.encode(resultString, "iso-8859-1");
	}

	public static void main(String[] args) {
		String strSrcParas = "MERFLAG=1&MERCHANTID=105000000000000&POSID=000000000&TERMNO1=&TERMNO2=&BRANCHID=110000000&ORDERID=105000000000000123456&QRCODE=CCB9991234567&AMOUNT=0.01&TXCODE=PAY100";

		String strKey = "Er@9f7DE&e%3Ou^%";
		CCBMCipherEncryptor ccbEncryptor = new CCBMCipherEncryptor(strKey);
		try {
			String ccbParam = ccbEncryptor.doEncrypt(strSrcParas);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}