/**
 * 代码声明
 */
package com.common.MessageCenter.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MessageCenter.dao.McMsgtempalateDao;
import com.common.MessageCenter.entity.McMsgtempalate;
import com.common.MessageCenter.service.McMsgtempalateManager;
import com.gsoft.common.util.MessageUtils;
import com.gsoft.common.util.StringUtils;
import com.gsoft.entity.MessageTempCode;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.ServiceParam;

@Service("mcMsgtempalateManager")
@Transactional
public class McMsgtempalateManagerImpl extends BaseManagerImpl implements McMsgtempalateManager{
	@Autowired
	private McMsgtempalateDao mcMsgtempalateDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<McMsgtempalate> getMcMsgtempalates() throws BusException{
    	return mcMsgtempalateDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<McMsgtempalate> getMcMsgtempalates(
    	@ConditionCollection(domainClazz=McMsgtempalate.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return mcMsgtempalateDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public McMsgtempalate getMcMsgtempalate(@ServiceParam(name="msgTempalateId") String id)  throws BusException{
    	return mcMsgtempalateDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerMcMsgtempalates(Pager pager,//分页条件
			@ConditionCollection(domainClazz=McMsgtempalate.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = mcMsgtempalateDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public McMsgtempalate saveMcMsgtempalate(McMsgtempalate o) throws BusException{
    	String mcMsgtempalateId = o.getMsgTempalateId();
    	boolean isUpdate = com.gsoft.framework.util.StringUtils.isNotEmpty(mcMsgtempalateId);
    	if(isUpdate){//修改
    		McMsgtempalate msgTempalate = getMsgTempalate(o.getUniqueCode());
    		if(msgTempalate!=null&&!mcMsgtempalateId.equals(msgTempalate.getUniqueCode())){
    			throw new BusException("唯一码已经存在");
    		}
    	
    	}else{//新增
    		if(mcMsgtempalateDao.exists("uniqueCode", o.getUniqueCode())){
    			throw new BusException("唯一码已经存在");
    		}
    	}
		if(!MessageTempCode.contant(o.getUniqueCode())){
			throw new BusException("唯一码不存在存在");
		}
    	return mcMsgtempalateDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeMcMsgtempalate(@ServiceParam(name="msgTempalateId") String id) throws BusException{
    	mcMsgtempalateDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeMcMsgtempalates(@ServiceParam(name="msgTempalateId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeMcMsgtempalate(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitMcMsgtempalate(@ServiceParam(name="msgTempalateId") String id)  throws BusException{
		return mcMsgtempalateDao.exists(id);
	}
    
    public boolean exsitMcMsgtempalate(String propertyName,Object value) throws BusException{
		return mcMsgtempalateDao.exists(propertyName,value);
	}
	@Override
	public String genMsgContent(McMsgtempalate msgtempalate,Map<String,String> replaceMap) throws BusException {
		return com.gsoft.common.util.StringUtils.replaceAllString(msgtempalate.getMsgTempalateContent(), MessageUtils.placeholders, replaceMap);
	}
	
	@EsbServiceMapping
	public String getParamCount(@ServiceParam(name="content") String content) throws BusException {
		return StringUtils.contantCount(content, MessageUtils.placeholders)+"";
	}
	@Override
	public McMsgtempalate getMsgTempalate(String uniqueCode)
			throws BusException {
		return mcMsgtempalateDao.getObjectByUniqueProperty("uniqueCode", uniqueCode);
	}

}
