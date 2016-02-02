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

import com.manage.EnterpriseManager.entity.InformationNotice;
import com.manage.EnterpriseManager.dao.InformationNoticeDao;
import com.manage.EnterpriseManager.service.InformationNoticeManager;

@Service("informationNoticeManager")
@Transactional
public class InformationNoticeManagerImpl extends BaseManagerImpl implements InformationNoticeManager{
	@Autowired
	private InformationNoticeDao informationNoticeDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<InformationNotice> getInformationNotices() throws BusException{
    	return informationNoticeDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<InformationNotice> getInformationNotices(
    	@ConditionCollection(domainClazz=InformationNotice.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return informationNoticeDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public InformationNotice getInformationNotice(@ServiceParam(name="noticeId") String id)  throws BusException{
    	return informationNoticeDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerInformationNotices(Pager pager,//分页条件
			@ConditionCollection(domainClazz=InformationNotice.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = informationNoticeDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public InformationNotice saveInformationNotice(InformationNotice o) throws BusException{
//    	String informationNoticeId = o.getInformationNoticeId();
//    	boolean isUpdate = StringUtils.isNotEmpty(informationNoticeId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return informationNoticeDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeInformationNotice(@ServiceParam(name="noticeId") String id) throws BusException{
    	informationNoticeDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeInformationNotices(@ServiceParam(name="noticeId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeInformationNotice(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitInformationNotice(@ServiceParam(name="noticeId") String id)  throws BusException{
		return informationNoticeDao.exists(id);
	}
    
    public boolean exsitInformationNotice(String propertyName,Object value) throws BusException{
		return informationNoticeDao.exists(propertyName,value);
	}

}
