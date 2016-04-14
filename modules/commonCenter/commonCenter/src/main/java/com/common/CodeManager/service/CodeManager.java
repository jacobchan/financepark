
/**
 * 通过代码集查数据
 * @author 刘嘉毅
 *
 */
package com.common.CodeManager.service;


import com.gsoft.framework.codemap.entity.Codeitem;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.BaseManager;


public interface CodeManager extends BaseManager{
	/**
	 * 根据代码集编码查询出相关的代码描述和代码值
	 * @param codeType 代码集编码
	 * @param code 代码值
	 * @return
	 */
	public Codeitem getCodeitem(String codeType,String code) throws BusException;
	
}