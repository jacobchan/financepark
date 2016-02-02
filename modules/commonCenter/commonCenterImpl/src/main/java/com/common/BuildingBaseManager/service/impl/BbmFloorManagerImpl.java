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

import com.common.BuildingBaseManager.entity.BbmFloor;
import com.common.BuildingBaseManager.dao.BbmFloorDao;
import com.common.BuildingBaseManager.service.BbmFloorManager;

@Service("bbmFloorManager")
@Transactional
public class BbmFloorManagerImpl extends BaseManagerImpl implements BbmFloorManager{
	@Autowired
	private BbmFloorDao bbmFloorDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<BbmFloor> getBbmFloors() throws BusException{
    	return bbmFloorDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<BbmFloor> getBbmFloors(
    	@ConditionCollection(domainClazz=BbmFloor.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return bbmFloorDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public BbmFloor getBbmFloor(@ServiceParam(name="floorId") String id)  throws BusException{
    	return bbmFloorDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerBbmFloors(Pager pager,//分页条件
			@ConditionCollection(domainClazz=BbmFloor.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = bbmFloorDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public BbmFloor saveBbmFloor(BbmFloor o) throws BusException{
//    	String bbmFloorId = o.getBbmFloorId();
//    	boolean isUpdate = StringUtils.isNotEmpty(bbmFloorId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return bbmFloorDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeBbmFloor(@ServiceParam(name="floorId") String id) throws BusException{
    	bbmFloorDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeBbmFloors(@ServiceParam(name="floorId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeBbmFloor(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitBbmFloor(@ServiceParam(name="floorId") String id)  throws BusException{
		return bbmFloorDao.exists(id);
	}
    
    public boolean exsitBbmFloor(String propertyName,Object value) throws BusException{
		return bbmFloorDao.exists(propertyName,value);
	}

}
