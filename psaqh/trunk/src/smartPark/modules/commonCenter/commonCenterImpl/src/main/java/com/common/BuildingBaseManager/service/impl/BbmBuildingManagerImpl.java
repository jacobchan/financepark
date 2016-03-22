/**
 * 代码声明
 */
package com.common.BuildingBaseManager.service.impl;

import java.util.ArrayList;
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
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.common.BuildingBaseManager.entity.BbmBuilding;
import com.common.BuildingBaseManager.entity.BbmPark;
import com.common.BuildingBaseManager.dao.BbmBuildingDao;
import com.common.BuildingBaseManager.service.BbmBuildingManager;
import com.common.BuildingBaseManager.service.BbmParkManager;

@Service("bbmBuildingManager")
@Transactional
public class BbmBuildingManagerImpl extends BaseManagerImpl implements BbmBuildingManager{
	@Autowired
	private BbmBuildingDao bbmBuildingDao;
	@Autowired
	private BbmParkManager bbmParkManager ;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<BbmBuilding> getBbmBuildings() throws BusException{
    	return bbmBuildingDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<BbmBuilding> getBbmBuildings(
    	@ConditionCollection(domainClazz=BbmBuilding.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return bbmBuildingDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public BbmBuilding getBbmBuilding(@ServiceParam(name="buildingId") String id)  throws BusException{
 //   	return bbmBuildingDao.get(id);
    	return bbmBuildingDao.getInitializeObject(id, new String[]{"bbmPark"});
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerBbmBuildings(Pager pager,//分页条件
			@ConditionCollection(domainClazz=BbmBuilding.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = bbmBuildingDao.findByPager(pager, conditions, orders);
//		List<BbmBuilding> buildings = pagerRecords.getRecords();
//		for(BbmBuilding building:buildings){
//			BbmPark park = building.getBbmPark();
//			//building.setParkName(park.getParkName());
//		}
		
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public BbmBuilding saveBbmBuilding(BbmBuilding o) throws BusException{
    	String bbmBuildingId = o.getBuildingId();
    	boolean isUpdate = StringUtils.isNotEmpty(bbmBuildingId);
    	if(isUpdate){//修改
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return bbmBuildingDao.save(o);
    	}else{//新增
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return bbmBuildingDao.save(o);
    	}
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeBbmBuilding(@ServiceParam(name="buildingId") String id) throws BusException{
    	bbmBuildingDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeBbmBuildings(@ServiceParam(name="buildingId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeBbmBuilding(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitBbmBuilding(@ServiceParam(name="buildingId") String id)  throws BusException{
		return bbmBuildingDao.exists(id);
	}
    
    public boolean exsitBbmBuilding(String propertyName,Object value) throws BusException{
		return bbmBuildingDao.exists(propertyName,value);
	}
    
    /**
	 * 通过园区名称获取该园区所有的楼栋
	 * @param parkName 园区名称
	 * @return
	 */
	@Override
	@EsbServiceMapping
	public List<BbmBuilding> getAllBuildingByParkName(@ServiceParam(name="parkName") String parkName)
			throws BusException {
		List<BbmBuilding> list = null ;
		if(StringUtils.isNotEmpty(parkName)){
			BbmPark park = bbmParkManager.getBbmParkByParkName(parkName) ;
			if(park != null){
				String parkId = park.getParkId() ;//得到园区ID
				Collection<Condition> condition =  new ArrayList<Condition>();
	    		condition.add(ConditionUtils.getCondition("bbmPark.parkId", Condition.EQUALS,parkId));//创建查询条件
				list = bbmBuildingDao.commonQuery(condition, null) ;
			}
		}
		return list;
	}
}
