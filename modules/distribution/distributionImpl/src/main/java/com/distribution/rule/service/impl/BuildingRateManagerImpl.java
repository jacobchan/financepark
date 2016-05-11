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
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.distribution.rule.entity.BuildingRate;
import com.distribution.rule.dao.BuildingRateDao;
import com.distribution.rule.service.BuildingRateManager;

@Service("buildingRateManager")
@Transactional
public class BuildingRateManagerImpl extends BaseManagerImpl implements BuildingRateManager{
	@Autowired
	private BuildingRateDao buildingRateDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<BuildingRate> getBuildingRates() throws BusException{
    	return buildingRateDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<BuildingRate> getBuildingRates(
    	@ConditionCollection(domainClazz=BuildingRate.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return buildingRateDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public BuildingRate getBuildingRate(@ServiceParam(name="recId") String id)  throws BusException{
    	return buildingRateDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerBuildingRates(Pager pager,//分页条件
			@ConditionCollection(domainClazz=BuildingRate.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = buildingRateDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public BuildingRate saveBuildingRate(BuildingRate o,@ServiceParam(name="buildingId") String buildingId) throws BusException{
    	String buildingRateId = o.getRecId();
    	boolean isUpdate = StringUtils.isNotEmpty(buildingRateId);
    	if(isUpdate){//修改
    		
    	}else{//新增
    		//buildingId不为空，选择楼宇信息
    		if(StringUtils.isNotEmpty(buildingId)){
    			o.setItemId(buildingId);
    			o.setItemType("1");
    		}else{
    			o.setItemType("0");
    		}
    		//判断佣金分成是否为0
    		if(!StringUtils.isNotEmpty(o.getDicRate())){
    			o.setDicRate("0");
    		}
    	}
    	return buildingRateDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeBuildingRate(@ServiceParam(name="recId") String id) throws BusException{
    	buildingRateDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeBuildingRates(@ServiceParam(name="recId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeBuildingRate(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitBuildingRate(@ServiceParam(name="recId") String id)  throws BusException{
		return buildingRateDao.exists(id);
	}
    
    public boolean exsitBuildingRate(String propertyName,Object value) throws BusException{
		return buildingRateDao.exists(propertyName,value);
	}

}
