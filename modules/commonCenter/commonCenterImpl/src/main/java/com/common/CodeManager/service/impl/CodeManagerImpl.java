
/**
 * 通过代码集查数据
 * @author 刘嘉毅
 *
 */
package com.common.CodeManager.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.CodeManager.service.CodeManager;
import com.gsoft.framework.codemap.entity.Codeitem;
import com.gsoft.framework.codemap.service.CodeitemManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.util.ConditionUtils;

@Service("codeManager")
@Transactional
public class CodeManagerImpl extends BaseManagerImpl implements CodeManager{
	@Autowired 
	private CodeitemManager codeitemManager;
	/**
	 * 根据代码集编码查询出相关的代码描述和代码值
	 * @param codeType 代码集编码
	 * @param code 代码值
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping
	public Codeitem getCodeitem(@ServiceParam(name="codeType") String codeType,@ServiceParam(name="code") String code) throws BusException{
		Collection<Condition> condition =  new ArrayList<Condition>();
		condition.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS,codeType));
		List<Codeitem> list = codeitemManager.getCodeitems(condition, null);
		for(int i=0;i<list.size();i++){
				Codeitem co=list.get(i);
				if(co.getItemValue().equals(code)){
					return co;
				}
			}	
		return null;
	}
}