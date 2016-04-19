package com.gsoft.utils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Arrays;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.util.StringUtils;
public class HttpSenderMsg {
	/**
	 * 
	 * @param url
	 *            应用地址，类似于http://ip:port/msg/
	 * @param account
	 *            账号
	 * @param pswd
	 *            密码
	 * @param mobile
	 *            手机号码，多个号码使用","分割
	 * @param msg
	 *            短信内容
	 * @param needstatus
	 *            是否需要状态报告，需要true，不需要false
	 * @return 返回值定义参见HTTP协议文档
	 * @throws Exception
	 */
	public static String send(String url, String account, String pswd,
			String mobile, String msg, boolean needstatus, String product,
			String extno) throws Exception {
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod();
		try {
			URI base = new URI(url, false);
			method.setURI(new URI(base, "HttpSendSM", false));
			method.setQueryString(new NameValuePair[] {
					new NameValuePair("account", account),
					new NameValuePair("pswd", pswd),
					new NameValuePair("mobile", mobile),
					new NameValuePair("needstatus", String.valueOf(needstatus)),
					new NameValuePair("msg", msg),
					new NameValuePair("product", product),
					new NameValuePair("extno", extno), });
			int result = client.executeMethod(method);
			if (result == HttpStatus.SC_OK) {
				InputStream in = method.getResponseBodyAsStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = in.read(buffer)) != -1) {
					baos.write(buffer, 0, len);
				}
				return URLDecoder.decode(baos.toString(), "UTF-8");
			} else {
				throw new Exception("HTTP ERROR Status: "
						+ method.getStatusCode() + ":" + method.getStatusText());
			}
		} finally {
			method.releaseConnection();
		}
	}

	/**
	 * 
	 * @param url
	 *            应用地址，类似于http://ip:port/msg/
	 * @param account
	 *            账号
	 * @param pswd
	 *            密码
	 * @param mobile
	 *            手机号码，多个号码使用","分割
	 * @param msg
	 *            短信内容
	 * @param needstatus
	 *            是否需要状态报告，需要true，不需要false
	 * @return 返回值定义参见HTTP协议文档
	 * @throws Exception
	 */
	public static String batchSend(String url, String account, String pswd,
			String mobile, String msg, boolean needstatus, String product,
			String extno) throws Exception {
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod();
		try {
			URI base = new URI(url, false);
			method.setURI(new URI(base, "HttpBatchSendSM", false));
			method.setQueryString(new NameValuePair[] {
					new NameValuePair("account", account),
					new NameValuePair("pswd", pswd),
					new NameValuePair("mobile", mobile),
					new NameValuePair("needstatus", String.valueOf(needstatus)),
					new NameValuePair("msg", msg),
					new NameValuePair("product", product),
					new NameValuePair("extno", extno), });
			int result = client.executeMethod(method);
			if (result == HttpStatus.SC_OK) {
				InputStream in = method.getResponseBodyAsStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = in.read(buffer)) != -1) {
					baos.write(buffer, 0, len);
				}
				return URLDecoder.decode(baos.toString(), "UTF-8");
			} else {
				throw new Exception("HTTP ERROR Status: "
						+ method.getStatusCode() + ":" + method.getStatusText());
			}
		} finally {
			method.releaseConnection();
		}
	}
	
	public static String sendMsg(String mobile, String msg) throws Exception{
		String url = "http://222.73.117.158/msg/";// 应用地址
		String account = "viphzfc";// 账号
		String pswd = "Tch123456";// 密码
		boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
		String product = null;// 产品ID
		String extno = null;// 扩展码
		
		return HttpSenderMsg.batchSend(url, account, pswd, mobile, msg, needstatus, product, extno);
	}
	
	public static void main(String[] args) throws Exception {
//		String mobile = "18062693970,13554467006";// 手机号码，多个号码使用","分割
//		String msg = "亲爱的用户，您的验证码是123456，5分钟内有效。";// 短信内容
//		try {
//			System.out.println("result:"+HttpSenderMsg.sendMsg(mobile, msg));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		HttpSenderMsg.sendMsg("18062693970", "hello!!!!");
		
//		String code = sendwithCode("您好！！！！",new String[]{"18062693970"});
//		System.out.println("---------"+code);
	}
	
	public static String sendwithCode(String content,String[] phones){
		String result = "";
		String reCode = "";
		try {
			result = HttpSenderMsg.sendMsg(StringUtils.collectionToDelimitedString(Arrays.asList(phones), ","), content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!StringUtils.isEmpty(result)){
		//	int _n = result.indexOf(System.getProperty("line.separator"));//
			int _n = result.indexOf("\n");
			String responseStr = result;
			if(_n != -1){
				responseStr = result.substring(0, _n);
			}
			String[] resutlStrs = responseStr.split(",");
			
			if(resutlStrs!=null&&resutlStrs.length>1){
				reCode = resutlStrs[1];
			}
			
		}else{
			
		}
		return reCode;
	}
}