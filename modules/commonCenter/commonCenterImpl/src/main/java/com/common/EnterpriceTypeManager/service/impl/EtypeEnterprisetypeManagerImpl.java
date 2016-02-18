/**
 * 代码声明
 */
package com.common.EnterpriceTypeManager.service.impl;

import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.common.EnterpriceTypeManager.entity.EtypeEnterprisetype;
import com.common.EnterpriceTypeManager.dao.EtypeEnterprisetypeDao;
import com.common.EnterpriceTypeManager.service.EtypeEnterprisetypeManager;

@Service("etypeEnterprisetypeManager")
@Transactional
public class EtypeEnterprisetypeManagerImpl extends BaseManagerImpl implements EtypeEnterprisetypeManager{
	@Autowired
	private EtypeEnterprisetypeDao etypeEnterprisetypeDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<EtypeEnterprisetype> getEtypeEnterprisetypes() throws BusException{
    	return etypeEnterprisetypeDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<EtypeEnterprisetype> getEtypeEnterprisetypes(
    	@ConditionCollection(domainClazz=EtypeEnterprisetype.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return etypeEnterprisetypeDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public EtypeEnterprisetype getEtypeEnterprisetype(@ServiceParam(name="enTypeId") String id)  throws BusException{
    	return etypeEnterprisetypeDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerEtypeEnterprisetypes(Pager pager,//分页条件
			@ConditionCollection(domainClazz=EtypeEnterprisetype.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = etypeEnterprisetypeDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public EtypeEnterprisetype saveEtypeEnterprisetype(EtypeEnterprisetype o) throws BusException{
    	String etypeEnterprisetypeId = o.getEnTypeId();
    	boolean isUpdate = StringUtils.isNotEmpty(etypeEnterprisetypeId);
    	if(isUpdate){//修改
    		etypeEnterprisetypeDao.update(etypeEnterprisetypeId, o);
    	}else{//新增
    		etypeEnterprisetypeDao.save(o);
    	}
    	return o;
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeEtypeEnterprisetype(@ServiceParam(name="enTypeId") String id) throws BusException{
    	etypeEnterprisetypeDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeEtypeEnterprisetypes(@ServiceParam(name="enTypeId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeEtypeEnterprisetype(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitEtypeEnterprisetype(@ServiceParam(name="enTypeId") String id)  throws BusException{
		return etypeEnterprisetypeDao.exists(id);
	}
    
    public boolean exsitEtypeEnterprisetype(String propertyName,Object value) throws BusException{
		return etypeEnterprisetypeDao.exists(propertyName,value);
	}

}
