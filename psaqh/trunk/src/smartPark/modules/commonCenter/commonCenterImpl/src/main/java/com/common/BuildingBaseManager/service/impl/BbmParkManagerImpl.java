/**
 * 代码声明
 */
package com.common.BuildingBaseManager.service.impl;

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

import com.common.BuildingBaseManager.entity.BbmPark;
import com.common.BuildingBaseManager.dao.BbmParkDao;
import com.common.BuildingBaseManager.service.BbmParkManager;

@Service("bbmParkManager")
@Transactional
public class BbmParkManagerImpl extends BaseManagerImpl implements BbmParkManager{
	@Autowired
	private BbmParkDao bbmParkDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<BbmPark> getBbmParks() throws BusException{
    	return bbmParkDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<BbmPark> getBbmParks(
    	@ConditionCollection(domainClazz=BbmPark.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return bbmParkDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public BbmPark getBbmPark(@ServiceParam(name="parkId") String id)  throws BusException{
    	return bbmParkDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerBbmParks(Pager pager,//分页条件
			@ConditionCollection(domainClazz=BbmPark.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = bbmParkDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
	@EsbServiceMapping(pubConditions={@PubCondition(property="address",pubProperty="userId")})
    public BbmPark saveBbmPark(BbmPark o) throws BusException{
//    	String bbmParkId = o.getBbmParkId();
//    	boolean isUpdate = StringUtils.isNotEmpty(bbmParkId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return bbmParkDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeBbmPark(@ServiceParam(name="parkId") String id) throws BusException{
    	bbmParkDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeBbmParks(@ServiceParam(name="parkId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeBbmPark(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitBbmPark(@ServiceParam(name="parkId") String id)  throws BusException{
		return bbmParkDao.exists(id);
	}
    
    public boolean exsitBbmPark(String propertyName,Object value) throws BusException{
		return bbmParkDao.exists(propertyName,value);
	}
    
    @EsbServiceMapping
	public void saveBbmParkList(@DomainCollection(domainClazz=BbmPark.class)List<BbmPark> list) throws BusException {
		// TODO Auto-generated method stub
		if(list.size()!=0){
			
		}
	}

}
