package com.gsoft.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

import com.gsoft.framework.core.exception.BusException;

public class HttpGetAndPostUtil {
	public static final String DEF_CHATSET = "UTF-8";
	public static final int DEF_CONN_TIMEOUT = 30000;
	public static final int DEF_READ_TIMEOUT = 30000;
	public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
	public static String url1 = "http://open.zhuna.cn/api/gateway.php";
	public static String url2 = "http://w.api.zhuna.cn/utf-8/postBook.php";
	public static String url3 = "http://www.api.zhuna.cn/e/json.php";
	public static final String agent_id = "609551";
	public static final String agent_md = "9028a20b2cd9d120";

	// 将map型转为请求参数型
	public static String urlencode(Map<String, ?> data) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, ?> i : data.entrySet()) {
			try {
				sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	// 将map转为json格式类型
	public static String jsonEncode(Map<String, ?> data) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (Map.Entry<String, ?> i : data.entrySet()) {
			try {
				if (!"".equals(i.getValue())) {
					sb.append("\"" + i.getKey() + "\"").append(":").append("\"" + i.getValue() + "\",");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("}");
		return sb.toString();
	}

	/**
	 *
	 * @param strUrl
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @param method
	 *            请求方法
	 * @return 网络请求字符串
	 * @throws Exception
	 */
	public static String net(String strUrl, Map<String, Object> params, String method) throws Exception {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		String rs = null;
		try {
			StringBuffer sb = new StringBuffer();
			if (method == null || method.equals("GET")) {
				strUrl = strUrl + "?" + urlencode(params);
			}
			URL url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection();
			if (method == null || method.equals("GET")) {
				conn.setRequestMethod("GET");
			} else {
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
			}
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("User-agent", userAgent);
			conn.setUseCaches(false);
			conn.setConnectTimeout(DEF_CONN_TIMEOUT);
			conn.setReadTimeout(DEF_READ_TIMEOUT);
			conn.setInstanceFollowRedirects(false);
			conn.connect();
			if (params != null && method.equals("POST")) {
				try {
					DataOutputStream out = new DataOutputStream(conn.getOutputStream());
					out.writeBytes(jsonEncode(params));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			InputStream is = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sb.append(strRead);
			}
			rs = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return rs;
	}
	//POST http请求
	public static String HotelSendPost(String strUrl, Map<String, Object> params) throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(strUrl);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("Charset", "UTF-8");
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(urlencode(params));
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			return result;
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常：" + e);
			e.printStackTrace();
		}
		return null;
	}
	
	//POST http请求
	public static String TicketSendPost(String strUrl, Map<String, Object> params) throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(strUrl);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("Charset", "UTF-8");
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");		
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(urlencode(params));
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			//in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			return result;
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常：" + e);
			e.printStackTrace();
		}
		return null;
	}
	
	public static String postHttpClient(PostMethod method){
		HttpClient http = new HttpClient();
        HttpConnectionManagerParams managerParams = http.getHttpConnectionManager().getParams();
        managerParams.setConnectionTimeout(DEF_CONN_TIMEOUT);
        managerParams.setSoTimeout(60000);

//        // 响应地址
//        PostMethod method = new PostMethod(
//                "http://wstest.51book.com:55779/ltips/services/createOrderByPassengerServiceRestful1.0/createOrderByPassenger");
        method.getParams().setHttpElementCharset("utf-8");
        method.getParams().setContentCharset("utf-8");
        method.getParams().setCredentialCharset("utf-8");
        
        String result = "";
        try {
            http.executeMethod(method);
            result = method.getResponseBodyAsString();
        } catch (IOException e) {
        	throw new BusException("请求异常:"+e.getLocalizedMessage());
        }
        System.out.println(result);
		return result;
	}
	
}
