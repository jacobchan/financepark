/**
 * 代码声明
 */
package com.common.MessageCenter.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MessageCenter.dao.McMsgdatasDao;
import com.common.MessageCenter.entity.McMsgdatas;
import com.common.MessageCenter.entity.McMsgtempalate;
import com.common.MessageCenter.service.McMsgdatasManager;
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
import com.gsoft.framework.security.agt.entity.User;

@Service("mcMsgdatasManager")
@Transactional
public class McMsgdatasManagerImpl extends BaseManagerImpl implements McMsgdatasManager{
	@Autowired
	private McMsgdatasDao mcMsgdatasDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<McMsgdatas> getMcMsgdatass() throws BusException{
    	return mcMsgdatasDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<McMsgdatas> getMcMsgdatass(
    	@ConditionCollection(domainClazz=McMsgdatas.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return mcMsgdatasDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public McMsgdatas getMcMsgdatas(@ServiceParam(name="msgId") String id)  throws BusException{
    	return mcMsgdatasDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerMcMsgdatass(Pager pager,//分页条件
			@ConditionCollection(domainClazz=McMsgdatas.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = mcMsgdatasDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public McMsgdatas saveMcMsgdatas(McMsgdatas o) throws BusException{
//    	String mcMsgdatasId = o.getMcMsgdatasId();
//    	boolean isUpdate = StringUtils.isNotEmpty(mcMsgdatasId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return mcMsgdatasDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeMcMsgdatas(@ServiceParam(name="msgId") String id) throws BusException{
    	mcMsgdatasDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeMcMsgdatass(@ServiceParam(name="msgId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeMcMsgdatas(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitMcMsgdatas(@ServiceParam(name="msgId") String id)  throws BusException{
		return mcMsgdatasDao.exists(id);
	}
    
    public boolean exsitMcMsgdatas(String propertyName,Object value) throws BusException{
		return mcMsgdatasDao.exists(propertyName,value);
	}
    
	@Override
	public String buildMessageContent(McMsgdatas mcMsgdatas) throws BusException {
		McMsgtempalate msgTempalate = mcMsgdatas.getMcMsgtempalate();//消息引用的模板
		String[] params = null;
		//模板内容转换成小心内容
		return com.gsoft.common.util.StringUtils.replaceChar(msgTempalate.getMsgTempalateContent(), '#', params);
	}
	
	@Override
	public void sendMessage(McMsgdatas mcMsgdatas) throws BusException {
		// TODO 发送消息
		McMsgtempalate tempalate = mcMsgdatas.getMcMsgtempalate();
		String receive = tempalate.getMsgReceiver();//接收对象 ROLE_ID
		//根据role获取用户信息
		
		//获取电话号码
		
		//生成消息内容
		
		//调用发送消息的外部接口
		
	}

}
