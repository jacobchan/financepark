package com.common.alipay.common;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.4
 *修改日期：2016-03-08
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
	public static String partner = "2088221352269831";
	
	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	public static String seller_id = partner;

	//商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	public static String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMZnnF5Dj5ab00G2"
									+"mE/JlDQHPlsWW6D/J5pT/34OCGIsH9f5amdKbwJik1AJNJIOLZxjLW0geBEqbX+b"
									+"2eNKzxPHbsgLu5WorJ+UUhdIDBnFIeVAyufwd/Wfb4+5ekOaqvoL/hAKYxBM58eJ"
									+"tOoxhzyhLgNCpwapvHx44qwdvevJAgMBAAECgYEArS5BYlKMokTv+NseRf7JO0Tb"
									+"W/y/DF/LvLz3NZugG7kyLn3KL9Db5vQOa/0tAxQXIfu76hY+V5V2ML3kSa7B4pFx"
									+"gePtbMKvsi+TtLyMeIuBYZxy6X5DXTq6C+6p4+MVes/rJ+wSev1bqfAxWlaKQBPl"
									+"I4+lez1kvpN8Q4gmL4ECQQD5O8tTnKKUsdDEWG9zbJkUp1ygylWtHISh8xBIlYIm"
									+"6CksV04NXoUIbYXOUkP3qjJeuLmZLbshCzdqVMma0Md5AkEAy8qMrGGXEsKsH9oz"
									+"9G1Ja+ymKWHLOxQufmecAvQqYp6d9VDPHzFKZGebiP1UdhrkgbjegYK7zoEuG3qo"
									+"2PUi0QJAOgWCk0d+zfELcfpIj+1zQcyoksIn6fIeqnkkjFFKCHa5xxnYEOK1Q74D"
									+"jYG3UvvrWAPXKWLtEodC8l0kxgbeuQJAJPKiMpa29zXIUzYSeVxfFWwgbBxI5nsw"
									+"Osa6KGbwUFUFunZeNv+Ox0lpj5qud4NErqg/3yc+uZ/+JglFF6DKIQJACuKqAf5l"
									+"W91Gyu4KF5k+x6q7kieOdgfSY4orQCMHScR4hHpkGqztxpp128mZG2nKP/U2OMSi"
									+"GY3lUb6ScvMGBw==";
									
	// 支付宝的公钥,查看地址：https://b.alipay.com/order/pidAndKey.htm
	public static String alipay_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	
	//app应用rsa公钥
	public static String alipay_app_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
	
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问(修改支付状态)
	public static String notify_url = "http://120.25.101.206:8088/wxpay/aliReturn.json";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问(订单成功后跳转)
	public static String return_url = "http://www.daotmd.com/alipay/create_direct_pay_by_user-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "C:\\";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
		
	// 支付类型 ，无需修改
	public static String payment_type = "1";
		
	// 调用的接口名，无需修改
	public static String service = "create_direct_pay_by_user";
	// APP调用的接口名，无需修改
	public static String app_service = "mobile.securitypay.pay";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	
//↓↓↓↓↓↓↓↓↓↓ 请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	
	// 防钓鱼时间戳  若要使用请调用类文件submit中的query_timestamp函数
	public static String anti_phishing_key = "";
	
	// 客户端的IP地址 非局域网的外网IP地址，如：221.0.0.1
	public static String exter_invoke_ip = "";
		
//↑↑↑↑↑↑↑↑↑↑请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	
}

