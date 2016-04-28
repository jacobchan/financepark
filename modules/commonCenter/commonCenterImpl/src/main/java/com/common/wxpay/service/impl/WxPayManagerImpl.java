/**
 * @author Aaron Tan
 * 微信支付所需接口
 */
package com.common.wxpay.service.impl;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.HashMap;
import java.util.Map;


import org.dom4j.Element;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.wxpay.common.Configure;
import com.common.wxpay.common.HttpsRequest;
import com.common.wxpay.common.RandomStringGenerator;
import com.common.wxpay.common.Signature;
import com.common.wxpay.common.Util;
import com.common.wxpay.protocol.UnifiedOrderReqData;
import com.common.wxpay.service.WxPayManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;

@Service("wxPayManager")
@Transactional
public class WxPayManagerImpl extends BaseManagerImpl implements WxPayManager{
	
	private HttpsRequest httpRequest;
	
	/**
	 * 调用统一下单接口
	 * @param unifiedOrder
	 * @return
	 * @throws UnrecoverableKeyException
	 * @throws KeyManagementException
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public String requestUnifiedOrderService(UnifiedOrderReqData unifiedOrderReqData) throws 
		UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException, IOException{
		httpRequest = new HttpsRequest();
//		Configure.setNotifyUrl("http://www.baidu.com");
		String responseStr = httpRequest.sendPost(Configure.UNIFIED_ORDER_API, unifiedOrderReqData.toXml());
		Element element = Util.getObjectFromXML(responseStr);
		String codeUrl = "";
		if(element!=null){
			codeUrl = element.element("code_url").getText();
		}
		return codeUrl;
	}
	/**
	 * APP微信支付调用统一下单接口获取预支付订单号
	 * @param unifiedOrder
	 * @return
	 * @throws UnrecoverableKeyException
	 * @throws KeyManagementException
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	@Override
	public Map<String, Object> appRequestOrderService(UnifiedOrderReqData unifiedOrderReqData) throws 
		UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException, IOException{
		httpRequest = new HttpsRequest();
		String responseStr = httpRequest.sendPost(Configure.UNIFIED_ORDER_API, unifiedOrderReqData.toXml());
		System.out.println("responseStr=================="+responseStr);
		
		Element element = Util.getObjectFromXML(responseStr);
		
		String resultCode = element.element("result_code").getText();
		String returnCode = element.element("return_code").getText();
		if("SUCCESS".endsWith(resultCode)&&"SUCCESS".endsWith(returnCode)){
			String prepayId = element.element("prepay_id").getText();//预支付订单号
			Map<String, Object> finalpackage = new HashMap<String, Object>();
			finalpackage.put("appId", Configure.getAppid());
			finalpackage.put("partnerId", Configure.getMchid());
			finalpackage.put("prepayId", prepayId);
			finalpackage.put("nonce_str", RandomStringGenerator.getRandomStringByLength(32));
			finalpackage.put("timeStamp", System.currentTimeMillis());
			finalpackage.put("package", "Sign=WXPay");
	        //根据API给的签名规则进行签名
	        String sign = Signature.getSign(finalpackage);
	        finalpackage.put("sign", sign);
			return finalpackage;
		}else{
			throw new BusException("获取预支付订单号失败！");
		}
	}
}
