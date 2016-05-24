/**
 * 代码声明
 */
package com.common.alipay.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.BaseManager;

@Service("aliPayManager")
@Transactional
public interface AliPayManager extends BaseManager{

	public String getAlipaySignStr(String id) throws BusException;

	public String getAlipayParamStr(String userorderCode) throws BusException;

	public String getAlipayapiHtml(String userorderCode) throws BusException;
	
}
