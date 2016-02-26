/**
 * 代码声明
 */
package com.manage.PublicUtilitiesManager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.BuildingBaseManager.service.BbmRoomManager;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerCommodityExtendValue;
import com.common.purchasingManager.service.PurchasingmanagerCommodityExtendValueManager;
import com.common.purchasingManager.service.PurchasingmanagerCommodityManager;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.PublicUtilitiesManager.entity.PublicutilitiesmanagerReso;
import com.manage.PublicUtilitiesManager.dao.PublicutilitiesmanagerResoDao;
import com.manage.PublicUtilitiesManager.service.PublicutilitiesmanagerResoManager;

@Service("publicutilitiesmanagerResoManager")
@Transactional
public class PublicutilitiesmanagerResoManagerImpl extends BaseManagerImpl implements PublicutilitiesmanagerResoManager{
	@Autowired
	private PublicutilitiesmanagerResoDao publicutilitiesmanagerResoDao;
	
	@Autowired
	private PurchasingmanagerCommodityManager purchasingmanagerCommodityManager;
	
	@Autowired
	private PurchasingmanagerCommodityExtendValueManager purchasingmanagerCommodityExtendValueManager;
	
	
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PublicutilitiesmanagerReso> getPublicutilitiesmanagerResos() throws BusException{
    	return publicutilitiesmanagerResoDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PublicutilitiesmanagerReso> getPublicutilitiesmanagerResos(
    	@ConditionCollection(domainClazz=PublicutilitiesmanagerReso.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return publicutilitiesmanagerResoDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PublicutilitiesmanagerReso getPublicutilitiesmanagerReso(@ServiceParam(name="resoId") String id)  throws BusException{
    	return publicutilitiesmanagerResoDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPublicutilitiesmanagerResos(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PublicutilitiesmanagerReso.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = publicutilitiesmanagerResoDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PublicutilitiesmanagerReso savePublicutilitiesmanagerReso(PublicutilitiesmanagerReso o) throws BusException{
//    	String publicutilitiesmanagerResoId = o.getPublicutilitiesmanagerResoId();
//    	boolean isUpdate = StringUtils.isNotEmpty(publicutilitiesmanagerResoId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	o.setResoStatus("01");//01:可用
    	return publicutilitiesmanagerResoDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePublicutilitiesmanagerReso(@ServiceParam(name="resoId") String id) throws BusException{
    	publicutilitiesmanagerResoDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePublicutilitiesmanagerResos(@ServiceParam(name="resoId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePublicutilitiesmanagerReso(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPublicutilitiesmanagerReso(@ServiceParam(name="resoId") String id)  throws BusException{
		return publicutilitiesmanagerResoDao.exists(id);
	}
    
    public boolean exsitPublicutilitiesmanagerReso(String propertyName,Object value) throws BusException{
		return publicutilitiesmanagerResoDao.exists(propertyName,value);
	}
    
    /**
	 * 查询园区商品类型为公用资源的商品
	 */
    @EsbServiceMapping
    public List<PurchasingmanagerCommodityExtendValue> getCommoditysByPublicStatus() throws BusException{
    	List<PurchasingmanagerCommodityExtendValue> extendValueList=new ArrayList<PurchasingmanagerCommodityExtendValue>();
    	//查询属于公共资源的商品
    	Collection<Condition> condition = new ArrayList<Condition>();
    	Collection<Order> order = new ArrayList<Order>();
    	condition.add(ConditionUtils.getCondition("parkBusinessTupe", Condition.EQUALS,"03"));//03:公共资源
    	List<PurchasingmanagerCommodity> commodityList=purchasingmanagerCommodityManager.getPurchasingmanagerCommoditys(condition, order);
    	
    	for(PurchasingmanagerCommodity p:commodityList){
    		//根据商品信息实体查询商品扩展属性值表
    		Collection<Condition> conditions = new ArrayList<Condition>();
    		Collection<Order> orders = new ArrayList<Order>();
    		conditions.add(ConditionUtils.getCondition("purchasingmanagerCommodity", Condition.EQUALS,
    				p));
    		List<PurchasingmanagerCommodityExtendValue> commodityExtendValueList=purchasingmanagerCommodityExtendValueManager.getPurchasingmanagerCommodityExtendValues(conditions, orders);
    		for(PurchasingmanagerCommodityExtendValue value:commodityExtendValueList){
    			extendValueList.add(value);
    		}
    	}
    	return extendValueList;
    }

}
