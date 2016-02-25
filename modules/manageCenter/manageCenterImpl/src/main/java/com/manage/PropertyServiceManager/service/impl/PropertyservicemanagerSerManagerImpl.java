/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service.impl;

import java.math.BigDecimal;
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
import com.gsoft.framework.util.Assert;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerSer;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerTs;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerBxDao;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerSerDao;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerTsDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerSerManager;

@Service("propertyservicemanagerSerManager")
@Transactional
public class PropertyservicemanagerSerManagerImpl extends BaseManagerImpl implements PropertyservicemanagerSerManager{
	@Autowired
	private PropertyservicemanagerSerDao propertyservicemanagerSerDao;
	@Autowired
	private PropertyservicemanagerTsDao propertyservicemanagerTsDao;
	@Autowired
	private PropertyservicemanagerBxDao propertyservicemanagerBxDao;
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerSer> getPropertyservicemanagerSers() throws BusException{
    	return propertyservicemanagerSerDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerSer> getPropertyservicemanagerSers(
    	@ConditionCollection(domainClazz=PropertyservicemanagerSer.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerSerDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerSer getPropertyservicemanagerSer(@ServiceParam(name="serId") String id)  throws BusException{
    	return propertyservicemanagerSerDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerSers(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerSer.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerSerDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PropertyservicemanagerSer savePropertyservicemanagerSer(PropertyservicemanagerSer o) throws BusException{
    	String tsid = o.getPropertyservicemanagerTs().getTsId();
    	PropertyservicemanagerTs  propertyservicemanagerTsed = propertyservicemanagerTsDao.get(tsid);
    	if(propertyservicemanagerTsed==null){
    		throw new BusException("没有派工记录!");
    	}else{
    		if(propertyservicemanagerTsed.getTsStatus().equals("01")){//派工状态已接单
    			PropertyservicemanagerBx bx = propertyservicemanagerTsed.getPropertyservicemanagerBx();
    			if(!bx.getBxStatus().equals("05")){//管理员已定价不能新增或修改维修单
    				BigDecimal amount =null;
	    			if(bx.getBxAmount()==null){//自动累计计算总金额
	    				amount = o.getSerPrice();
	    				bx.setBxAmount(amount);
	    			}else{
	    				amount = bx.getBxAmount().add(o.getSerPrice());
	    				bx.setBxAmount(amount);
	    			}
	    			if(bx.getBxStatus().equals("03")){//变更状态为已完工
	    				bx.setBxStatus("04");
	    			}
		    		propertyservicemanagerBxDao.save(bx);
	    			return propertyservicemanagerSerDao.save(o);
    			}else{
    				throw new BusException("管理员已定价!");
    			}
    		}else{
    			throw new BusException("派工记录有误!");
    		}
    	}
    }

    /**
	 * 根据派工id查询维修费用清单
	 * @param pager
	 * @param ts 派工对象
	 * @param orders
	 * @return
	 * @throws BusException
	 */
  	@SuppressWarnings({ "rawtypes", "unchecked" })
  	@EsbServiceMapping
  	public PagerRecords getPagerPropertyservicemanagerSersByTs(Pager pager,//分页条件
			PropertyservicemanagerTs ts,
  			@OrderCollection Collection<Order> orders)  throws BusException{
  	     Assert.notNull(ts, "派工条件不能为空！");
  	     Assert.notNull(ts.getTsId(), "派工记录中tsId不能为空！");
  	     Collection conditions = new ArrayList();
  	     conditions.add(ConditionUtils.getCondition("propertyservicemanagerTs.tsId", "EQUALS", ts.getTsId()));
  		return propertyservicemanagerSerDao.findByPager(pager, conditions, orders);
  	}
    
    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerSer(@ServiceParam(name="serId") String id) throws BusException{
    	propertyservicemanagerSerDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerSers(@ServiceParam(name="serId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerSer(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerSer(@ServiceParam(name="serId") String id)  throws BusException{
		return propertyservicemanagerSerDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerSer(String propertyName,Object value) throws BusException{
		return propertyservicemanagerSerDao.exists(propertyName,value);
	}

    /**
	 * 批量新增维修费用清单
	 * @param tsId 派工ID
	 * @param listSer 费用清单列表
	 */
    @EsbServiceMapping
	public void saveListSer(@ServiceParam(name="tsId") String tsId,
			@DomainCollection(domainClazz=PropertyservicemanagerSer.class) List<PropertyservicemanagerSer> listSer) {
    	PropertyservicemanagerTs  propertyservicemanagerTsed = propertyservicemanagerTsDao.get(tsId);
    	if(propertyservicemanagerTsed==null){
    		throw new BusException("没有派工记录!");
    	}else{
    		if(propertyservicemanagerTsed.getTsStatus().equals("01")){//派工状态已接单
    			PropertyservicemanagerBx bx = propertyservicemanagerTsed.getPropertyservicemanagerBx();
    			if(!bx.getBxStatus().equals("05")||!bx.getBxStatus().equals("06")||!bx.getBxStatus().equals("07")){//管理员已定价不能新增或修改维修单
    				BigDecimal amount = BigDecimal.valueOf(0);
    					for(PropertyservicemanagerSer ser : listSer){//自动计算总价
    						amount = amount.add(ser.getSerPrice());
    					}
	    				bx.setBxAmount(amount);
	    			if(bx.getBxStatus().equals("03")){//变更状态为已完工
	    				bx.setBxStatus("04");
	    			}
		    		propertyservicemanagerBxDao.save(bx);
		    		//保存维修单
		    		for(PropertyservicemanagerSer allser : listSer){
						allser.setPropertyservicemanagerTs(propertyservicemanagerTsed);
						propertyservicemanagerSerDao.save(allser);
					}
    			}else{
    				throw new BusException("管理员已定价!");
    			}
    		}else{
    			throw new BusException("派工记录有误!");
    		}
    	}
		
	}
    
    

}
