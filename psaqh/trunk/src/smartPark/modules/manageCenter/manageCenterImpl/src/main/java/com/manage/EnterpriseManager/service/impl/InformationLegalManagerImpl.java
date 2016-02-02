/**
 * 代码声明
 */
package com.manage.EnterpriseManager.service.impl;

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

import com.manage.EnterpriseManager.entity.InformationLegal;
import com.manage.EnterpriseManager.dao.InformationLegalDao;
import com.manage.EnterpriseManager.service.InformationLegalManager;

@Service("informationLegalManager")
@Transactional
public class InformationLegalManagerImpl extends BaseManagerImpl implements InformationLegalManager{
	@Autowired
	private InformationLegalDao informationLegalDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<InformationLegal> getInformationLegals() throws BusException{
    	return informationLegalDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<InformationLegal> getInformationLegals(
    	@ConditionCollection(domainClazz=InformationLegal.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return informationLegalDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public InformationLegal getInformationLegal(@ServiceParam(name="legalId") String id)  throws BusException{
    	return informationLegalDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerInformationLegals(Pager pager,//分页条件
			@ConditionCollection(domainClazz=InformationLegal.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = informationLegalDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public InformationLegal saveInformationLegal(InformationLegal o) throws BusException{
//    	String informationLegalId = o.getInformationLegalId();
//    	boolean isUpdate = StringUtils.isNotEmpty(informationLegalId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return informationLegalDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeInformationLegal(@ServiceParam(name="legalId") String id) throws BusException{
    	informationLegalDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeInformationLegals(@ServiceParam(name="legalId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeInformationLegal(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitInformationLegal(@ServiceParam(name="legalId") String id)  throws BusException{
		return informationLegalDao.exists(id);
	}
    
    public boolean exsitInformationLegal(String propertyName,Object value) throws BusException{
		return informationLegalDao.exists(propertyName,value);
	}

}
