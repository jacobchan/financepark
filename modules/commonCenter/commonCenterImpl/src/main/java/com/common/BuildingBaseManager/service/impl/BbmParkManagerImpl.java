/**
 * 代码声明
 */
package com.common.BuildingBaseManager.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.common.BuildingBaseManager.entity.BbmBuilding;
import com.common.BuildingBaseManager.entity.BbmFloor;
import com.common.BuildingBaseManager.entity.BbmPark;
import com.common.BuildingBaseManager.dao.BbmParkDao;
import com.common.BuildingBaseManager.service.BbmBuildingManager;
import com.common.BuildingBaseManager.service.BbmFloorManager;
import com.common.BuildingBaseManager.service.BbmParkManager;

@Service("bbmParkManager")
@Transactional
public class BbmParkManagerImpl extends BaseManagerImpl implements BbmParkManager{
	@Autowired
	private BbmParkDao bbmParkDao;
	@Autowired
	private BbmBuildingManager bbmBuildingManager ;
	@Autowired
	private BbmFloorManager bbmFloorManager ;
	
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
	@EsbServiceMapping//(pubConditions={@PubCondition(property="address",pubProperty="userId")})
    public BbmPark saveBbmPark(BbmPark o) throws BusException{
    	String bbmParkId = o.getParkId();
    	boolean isUpdate = StringUtils.isNotEmpty(bbmParkId);
    	if(isUpdate){//修改
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return bbmParkDao.save(o);
    	}else{//新增
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return bbmParkDao.save(o);
    	}
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
    
    @Override
    @EsbServiceMapping
    public BbmPark getBbmParkByParkName(String parkName) {
    	return bbmParkDao.getObjectByUniqueProperty("parkName", parkName);
    }
    
    @Override
    @EsbServiceMapping
    public JSONArray getBuildingAndFloorByParkName(@ServiceParam(name="parkName") String parkName) {
    	List<BbmBuilding> buildingList = null ;
    	Map<String,List<BbmFloor>> map = new HashMap<String, List<BbmFloor>>() ;
    	buildingList = bbmBuildingManager.getAllBuildingByParkName(parkName) ;
    	for(int i=0;i<buildingList.size();i++){
    		BbmBuilding building = buildingList.get(i) ;
    		String buildingInfor = building.getBuildingId()+building.getBuildingNo() ;//得到楼栋ID+楼栋编号
    		List<BbmFloor> floorList = bbmFloorManager.getBbmFloorByBuildingId(building.getBuildingId()) ;//得到楼层list
    		map.put(buildingInfor, floorList) ;//将楼栋及对应的楼层put到map中
    	}
//    	System.out.println(map);
//    	Set<BbmBuilding> keys = map.keySet() ;
//    	java.util.Iterator<BbmBuilding> i = keys.iterator() ;
//    	while(i.hasNext()){
//    		BbmBuilding b = i.next() ;
//    		System.out.print(b.getBuildingCaption()+":   ");
//    		List<BbmFloor> values = map.get(b) ;
//    		for(int n=0;n<values.size();n++){
//    			System.out.print(values.get(n).getFloorCaption()+", ");
//    		}
//    		System.out.println();
//    	}
    	JSONArray json = JSONArray.fromObject(map);
    	return json;
    }
}
