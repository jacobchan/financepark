/**
 * 代码声明
 */
package com.common.alipay.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.ServiceParam;

@Service("aliPayManager")
@Transactional
public interface AliPayManager extends BaseManager{

	public String getAlipaySignStr(String id) throws BusException;
	
}
