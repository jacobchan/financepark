/**
 * 代码声明
 */
package com.common.MessageCenter.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MessageCenter.dao.McMsgtypeDao;
import com.common.MessageCenter.entity.McMsgtype;
import com.common.MessageCenter.service.McMsgtypeManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.ConditionFactory;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.util.StringUtils;

@Service("mcMsgtypeManager")
@Transactional
public class McMsgtypeManagerImpl extends BaseManagerImpl implements McMsgtypeManager{
	@Autowired
	private McMsgtypeDao mcMsgtypeDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<McMsgtype> getMcMsgtypes() throws BusException{
    	return mcMsgtypeDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<McMsgtype> getMcMsgtypes(
    	@ConditionCollection(domainClazz=McMsgtype.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return mcMsgtypeDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public McMsgtype getMcMsgtype(@ServiceParam(name="msgTypeId") String id)  throws BusException{
    	return mcMsgtypeDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerMcMsgtypes(Pager pager,//分页条件
			@ConditionCollection(domainClazz=McMsgtype.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = mcMsgtypeDao.findByPager(pager, conditions, orders);
		List<McMsgtype> msgTypes = pagerRecords.getRecords();
		for(McMsgtype msgType:msgTypes){
			if(StringUtils.isNotEmpty(msgType.getMsgTypeParent())){
				McMsgtype msgType_ = mcMsgtypeDao.get(msgType.getMsgTypeParent());
				msgType.setParentTypeCaption(msgType_.getMsgTypeCaption());
			}
		}
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public McMsgtype saveMcMsgtype(McMsgtype o) throws BusException{
//    	String mcMsgtypeId = o.getMcMsgtypeId();
//    	boolean isUpdate = StringUtils.isNotEmpty(mcMsgtypeId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return mcMsgtypeDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeMcMsgtype(@ServiceParam(name="msgTypeId") String id) throws BusException{
    	mcMsgtypeDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeMcMsgtypes(@ServiceParam(name="msgTypeId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeMcMsgtype(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitMcMsgtype(@ServiceParam(name="msgTypeId") String id)  throws BusException{
		return mcMsgtypeDao.exists(id);
	}
    
    public boolean exsitMcMsgtype(String propertyName,Object value) throws BusException{
		return mcMsgtypeDao.exists(propertyName,value);
	}
    
	@EsbServiceMapping
	public List<McMsgtype> getChildren(@ServiceParam(name="msgTypeId") String parentId) throws BusException {
	    List<McMsgtype> children ;
	    if (StringUtils.isEmpty(parentId)) {
	      Collection<Condition> conditions = new ArrayList<Condition>();
	      conditions.add(ConditionFactory.getInstance().getCondition("msgTypeParent", "IS_NULL", null));
	      children = this.mcMsgtypeDao.commonQuery(conditions, null);
	    } else {
	      children = this.mcMsgtypeDao.getList("msgTypeParent", parentId);
	    }
		return children;
	}

}
