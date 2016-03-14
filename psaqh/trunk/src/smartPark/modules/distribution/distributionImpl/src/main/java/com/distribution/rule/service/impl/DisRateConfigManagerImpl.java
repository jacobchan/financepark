/**
 * 代码声明
 */
package com.distribution.rule.service.impl;

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

import com.gsoft.framework.core.service.impl.BaseManagerImpl;

import com.distribution.rule.entity.DisRateConfig;
import com.distribution.rule.dao.DisRateConfigDao;
import com.distribution.rule.service.DisRateConfigManager;

@Service("disRateConfigManager")
@Transactional
public class DisRateConfigManagerImpl extends BaseManagerImpl implements DisRateConfigManager{
	@Autowired
	private DisRateConfigDao disRateConfigDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<DisRateConfig> getDisRateConfigs() throws BusException{
    	return disRateConfigDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<DisRateConfig> getDisRateConfigs(
    	@ConditionCollection(domainClazz=DisRateConfig.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return disRateConfigDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public DisRateConfig getDisRateConfig(@ServiceParam(name="recId") String id)  throws BusException{
    	return disRateConfigDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerDisRateConfigs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=DisRateConfig.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = disRateConfigDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public DisRateConfig saveDisRateConfig(DisRateConfig o) throws BusException{
//    	String disRateConfigId = o.getDisRateConfigId();
//    	boolean isUpdate = StringUtils.isNotEmpty(disRateConfigId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return disRateConfigDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeDisRateConfig(@ServiceParam(name="recId") String id) throws BusException{
    	disRateConfigDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeDisRateConfigs(@ServiceParam(name="recId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeDisRateConfig(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitDisRateConfig(@ServiceParam(name="recId") String id)  throws BusException{
		return disRateConfigDao.exists(id);
	}
    
    public boolean exsitDisRateConfig(String propertyName,Object value) throws BusException{
		return disRateConfigDao.exists(propertyName,value);
	}

}
