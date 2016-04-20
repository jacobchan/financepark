package com.gsoft.utils;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;
/*
 * 首页企业商城加密 
 */
public class EncryptUtil {
		// Base64加密
		public static String encrypt(String str) {
			if (str == null || str.trim().equals("")) {
				return "";
			}
			byte[] b = str.getBytes();
			b = Base64.encodeBase64(b);
			String s = new String(b);
			return s;
		}

		// Base64解密
		public static String decrypt(String str) {
			if (str == null || str.trim().equals("")) {
				return "";
			}
			byte[] b = str.getBytes();
			b = Base64.decodeBase64(b);
			String s = new String(b);
			return s;
		}
		
		//MD5加密
		public static String getMD5Str(String str) {
			if (str == null || str.trim().equals("")) {
				return "";
			}
			MessageDigest messageDigest = null;
			try {
				messageDigest = MessageDigest.getInstance("MD5");
				messageDigest.reset();
				messageDigest.update(str.getBytes("UTF-8"));
				byte[] byteArray = messageDigest.digest();
				StringBuffer md5StrBuff = new StringBuffer();
				for (int i = 0; i < byteArray.length; i++) {
					if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
						md5StrBuff.append("0").append(
								Integer.toHexString(0xFF & byteArray[i]));
					else
						md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
				}
				return md5StrBuff.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "";
		}
}
