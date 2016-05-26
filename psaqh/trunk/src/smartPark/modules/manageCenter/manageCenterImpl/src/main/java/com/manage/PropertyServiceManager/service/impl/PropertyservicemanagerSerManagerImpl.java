/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.security.agt.dao.UserDao;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.util.Assert;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerSer;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerTs;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerBxDao;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerSerDao;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerTsDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerBxManager;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerSerManager;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerTsManager;

@Service("propertyservicemanagerSerManager")
@Transactional
public class PropertyservicemanagerSerManagerImpl extends BaseManagerImpl implements PropertyservicemanagerSerManager{
	@Autowired
	private PropertyservicemanagerSerDao propertyservicemanagerSerDao;
	@Autowired
	private PropertyservicemanagerTsDao propertyservicemanagerTsDao;
	@Autowired
	private PropertyservicemanagerBxDao propertyservicemanagerBxDao;
	@Autowired
	private PropertyservicemanagerBxManager propertyservicemanagerBxManager;
	@Autowired
	private PropertyservicemanagerTsManager propertyservicemanagerTsManager;
	@Autowired
	private UserDao userDao;
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
	 * 根据报修编号查询最近一次的维修费用清单
	 */
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerPsSers(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerSer.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,
			@ServiceParam(name="bxCode") String bxCode)  throws BusException{
		PropertyservicemanagerBx psbx = propertyservicemanagerBxDao.getObjectByUniqueProperty("bxCode", bxCode);
		PropertyservicemanagerTs psts = propertyservicemanagerTsManager.getPropertyservicemanagerTssBybxId(psbx.getBxId());
		conditions.add(ConditionUtils.getCondition("propertyservicemanagerTs.tsId", Condition.EQUALS, psts.getTsId()));
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
//    		if(propertyservicemanagerTsed.getTsStatus().equals("01")){//派工状态已接单
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
//    		}else{
//    			throw new BusException("派工记录有误!");
//    		}
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
	 * 根据报修id查询维修费用清单
	 * @param pager
	 * @param ts 报修对象
	 * @param orders
	 * @return
	 * @throws BusException
	 */
  	@SuppressWarnings({ "rawtypes", "unchecked" })
  	@EsbServiceMapping
  	public PagerRecords getPagerPropertyservicemanagerSersByBx(Pager pager,//分页条件
  			@ServiceParam(name="id") String id,
  			@OrderCollection Collection<Order> orders)  throws BusException{
  	     Assert.notNull(id, "派工记录中tsId不能为空！");
  	     Collection conditions = new ArrayList();
  	     conditions.add(ConditionUtils.getCondition("propertyservicemanagerTs.propertyservicemanagerBx.bxId", "EQUALS", id));
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
	 * @param bxCode 报修编号
	 * @param listSer 费用清单列表
	 */
    @EsbServiceMapping
	public void saveListSer(@ServiceParam(name="bxCode") String bxCode,
			@DomainCollection(domainClazz=PropertyservicemanagerSer.class) List<PropertyservicemanagerSer> listSer) {
    	PropertyservicemanagerBx bx = propertyservicemanagerBxDao.getObjectByUniqueProperty("bxCode", bxCode);
		PropertyservicemanagerTs psts = propertyservicemanagerTsManager.getPropertyservicemanagerTssBybxId(bx.getBxId());
    	if(psts==null){
    		throw new BusException("没有派工记录!");
    	}else{
    		if(psts.getTsStatus().equals("01")){//派工状态已接单
    			if(bx.getBxStatus().equals("03")){//待填报维修记录
    				BigDecimal amount = BigDecimal.valueOf(0);
    				BigDecimal bxAmount = bx.getBxAmount();
    					for(PropertyservicemanagerSer ser : listSer){//自动计算总价
    						amount = amount.add(ser.getSerPrice());
    					}
    					if(bxAmount!=null){//是否已计价
    						bx.setBxAmount(amount.add(bxAmount));
    					}else{
    						bx.setBxAmount(amount);
    					}
	    				//变更状态为已完工
	    				bx.setBxStatus("04");
	    				psts.setTsStatus("03");//已填报费用清单
		    		propertyservicemanagerBxDao.save(bx);
		    		propertyservicemanagerTsManager.savePts(psts);
		    		//保存维修单
		    		for(PropertyservicemanagerSer allser : listSer){
						allser.setPropertyservicemanagerTs(psts);
						allser.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
						propertyservicemanagerSerDao.save(allser);
					}
    			}else if(bx.getBxStatus().equals("05")){
    				throw new BusException("管理员已定价!");
    			}else if(bx.getBxStatus().equals("06")){
    				throw new BusException("已付款!");
    			}else if(bx.getBxStatus().equals("07")){
    				throw new BusException("报修流程已结束!");
    			}
    		}else{
    			throw new BusException("派工记录有误!");
    		}
    	}
		
	}
    
    /**
	 *	APP--查询费用维修清单
	 * @param 报修单id
	 * @return
	 * @throws BusException
	 */
    @EsbServiceMapping
    public List<Map<String, Object>> getGroupSer (@ServiceParam(name="bxId") String id) throws BusException{
    	List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
    	Collection<Condition> condition = new ArrayList<Condition>();
    	condition.add(ConditionUtils.getCondition("propertyservicemanagerBx.bxId", Condition.EQUALS, id));
    	List<PropertyservicemanagerTs> tslist =  propertyservicemanagerTsManager.getPropertyservicemanagerTss(condition, null);
    	if(tslist.size()>0){
    		for(PropertyservicemanagerTs ts : tslist){
    			Map<String, Object> urlVariables = new HashMap<String, Object>();
    			List<Record> re = new ArrayList<Record>();
    			Record rd = new Record(); 
    			re = propertyservicemanagerSerDao.querySerList(ts.getTsId());
    			rd.put("TsName", ts.getTsName());
    			rd.put("TsTelephone", ts.getTsTelephone());
    			urlVariables.put("serviceMan", rd);
    			urlVariables.put("material", re);
    			retList.add(urlVariables);
    		}
    		return retList;
    	}else{
    		return null;
    	}
    }
    /**
     * 后台个人维修记录
     * @param userId
	 * @return
	 * @throws BusException
     */
    @EsbServiceMapping
    public PagerRecords getPropertySer(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerSer.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,
			@ServiceParam(name="userId",pubProperty="userId") String userId) throws BusException{
    	User u=userDao.get(userId);
    	String name=u.getLoginName();
    	conditions.add(ConditionUtils.getCondition("propertyservicemanagerTs.tsName",Condition.EQUALS, name));
		PagerRecords pagerRecords = propertyservicemanagerSerDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
}
