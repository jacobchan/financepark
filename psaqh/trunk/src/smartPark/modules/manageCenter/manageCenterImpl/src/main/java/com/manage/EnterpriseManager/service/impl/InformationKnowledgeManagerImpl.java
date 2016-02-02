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

import com.manage.EnterpriseManager.entity.InformationKnowledge;
import com.manage.EnterpriseManager.dao.InformationKnowledgeDao;
import com.manage.EnterpriseManager.service.InformationKnowledgeManager;

@Service("informationKnowledgeManager")
@Transactional
public class InformationKnowledgeManagerImpl extends BaseManagerImpl implements InformationKnowledgeManager{
	@Autowired
	private InformationKnowledgeDao informationKnowledgeDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<InformationKnowledge> getInformationKnowledges() throws BusException{
    	return informationKnowledgeDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<InformationKnowledge> getInformationKnowledges(
    	@ConditionCollection(domainClazz=InformationKnowledge.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return informationKnowledgeDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public InformationKnowledge getInformationKnowledge(@ServiceParam(name="knowledgeId") String id)  throws BusException{
    	return informationKnowledgeDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerInformationKnowledges(Pager pager,//分页条件
			@ConditionCollection(domainClazz=InformationKnowledge.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = informationKnowledgeDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public InformationKnowledge saveInformationKnowledge(InformationKnowledge o) throws BusException{
//    	String informationKnowledgeId = o.getInformationKnowledgeId();
//    	boolean isUpdate = StringUtils.isNotEmpty(informationKnowledgeId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return informationKnowledgeDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeInformationKnowledge(@ServiceParam(name="knowledgeId") String id) throws BusException{
    	informationKnowledgeDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeInformationKnowledges(@ServiceParam(name="knowledgeId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeInformationKnowledge(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitInformationKnowledge(@ServiceParam(name="knowledgeId") String id)  throws BusException{
		return informationKnowledgeDao.exists(id);
	}
    
    public boolean exsitInformationKnowledge(String propertyName,Object value) throws BusException{
		return informationKnowledgeDao.exists(propertyName,value);
	}

}
