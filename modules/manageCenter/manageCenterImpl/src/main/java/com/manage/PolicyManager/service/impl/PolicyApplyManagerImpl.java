/**
 * 代码声明
 */
package com.manage.PolicyManager.service.impl;

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

import com.manage.PolicyManager.entity.PolicyApply;
import com.manage.PolicyManager.dao.PolicyApplyDao;
import com.manage.PolicyManager.service.PolicyApplyManager;

@Service("policyApplyManager")
@Transactional
public class PolicyApplyManagerImpl extends BaseManagerImpl implements PolicyApplyManager{
	@Autowired
	private PolicyApplyDao policyApplyDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PolicyApply> getPolicyApplys() throws BusException{
    	return policyApplyDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PolicyApply> getPolicyApplys(
    	@ConditionCollection(domainClazz=PolicyApply.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return policyApplyDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PolicyApply getPolicyApply(@ServiceParam(name="policyApplyId") String id)  throws BusException{
    	return policyApplyDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPolicyApplys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PolicyApply.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = policyApplyDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PolicyApply savePolicyApply(PolicyApply o) throws BusException{
//    	String policyApplyId = o.getPolicyApplyId();
//    	boolean isUpdate = StringUtils.isNotEmpty(policyApplyId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return policyApplyDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePolicyApply(@ServiceParam(name="policyApplyId") String id) throws BusException{
    	policyApplyDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePolicyApplys(@ServiceParam(name="policyApplyId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePolicyApply(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPolicyApply(@ServiceParam(name="policyApplyId") String id)  throws BusException{
		return policyApplyDao.exists(id);
	}
    
    public boolean exsitPolicyApply(String propertyName,Object value) throws BusException{
		return policyApplyDao.exists(propertyName,value);
	}

}
