/**
 * 代码声明
 */
package com.common.wxpay.service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.wxpay.protocol.UnifiedOrderReqData;
import com.gsoft.framework.core.service.BaseManager;

@Service("wxPayManager")
@Transactional
public interface WxPayManager extends BaseManager{
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
	public String requestUnifiedOrderService(UnifiedOrderReqData unifiedOrderReqData) throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException, IOException;
}
