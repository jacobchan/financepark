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

import org.dom4j.Element;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.wxpay.common.Configure;
import com.common.wxpay.common.HttpsRequest;
import com.common.wxpay.common.Util;
import com.common.wxpay.protocol.UnifiedOrderReqData;
import com.common.wxpay.service.WxPayManager;
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
	public String requestUnifiedOrderService(UnifiedOrderReqData unifiedOrderReqData) throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException, IOException{
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
}
