/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service.impl;

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
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerSfpro;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerTs;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerTsManager;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerBxDao;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerTsDao;

@Service("propertyservicemanagerTsManager")
@Transactional
public class PropertyservicemanagerTsManagerImpl extends BaseManagerImpl implements PropertyservicemanagerTsManager{
	@Autowired
	private PropertyservicemanagerTsDao propertyservicemanagerTsDao;
	@Autowired
	private PropertyservicemanagerBxDao propertyservicemanagerBxDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerTs> getPropertyservicemanagerTss() throws BusException{
    	return propertyservicemanagerTsDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerTs> getPropertyservicemanagerTss(
    	@ConditionCollection(domainClazz=PropertyservicemanagerTs.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerTsDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerTs getPropertyservicemanagerTs(@ServiceParam(name="tsId") String id)  throws BusException{
    	return propertyservicemanagerTsDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerTss(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerTs.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerTsDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	
	/**
	 * 根据报修记录id分页查询派工记录
	 * @param pager
	 * @param bx 报修记录
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerTssByBx(Pager pager,//分页条件
			PropertyservicemanagerBx bx,
			@OrderCollection Collection<Order> orders)  throws BusException{
	     Assert.notNull(bx, "物业报修条件不能为空！");
	     Assert.notNull(bx.getBxId(), "物业报修中bxId不能为空！");
	     Collection conditions = new ArrayList();
	     conditions.add(ConditionUtils.getCondition("propertyservicemanagerBx.bxId", "EQUALS", bx.getBxId()));
		return propertyservicemanagerTsDao.findByPager(pager, conditions, orders);
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PropertyservicemanagerTs savePropertyservicemanagerTs(PropertyservicemanagerTs o) throws BusException{
    	String bxid = o.getPropertyservicemanagerBx().getBxId();
    	PropertyservicemanagerBx bx = propertyservicemanagerBxDao.get(bxid);
    	if(bx==null){
    		throw new BusException("没有报修记录存在!");
    	}else{
    			if(o.getTsId()==null){
	    			Collection<Condition> conditionts =  new ArrayList<Condition>();
	    			String[] aa = {"00","01"};
	    			conditionts.add(ConditionUtils.getCondition("tsStatus", Condition.IN,aa));//查询已发出派工记录或者派工已受理
	    			conditionts.add(ConditionUtils.getCondition("propertyservicemanagerBx.bxId", Condition.EQUALS,bxid));
	    			List<PropertyservicemanagerTs> listTs = propertyservicemanagerTsDao.commonQuery(conditionts, null);
	    			if(listTs.size()>0){
	    				throw new BusException("该报修已派工!");
	    			}else{
			    		bx.setBxStatus("02");//设置派工记录为待接单
			    		propertyservicemanagerBxDao.save(bx);
			    	   	return propertyservicemanagerTsDao.save(o);
	    			}
    			}else{
    				return propertyservicemanagerTsDao.save(o);
    			}
    	}
 
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerTs(@ServiceParam(name="tsId") String id) throws BusException{
    	propertyservicemanagerTsDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerTss(@ServiceParam(name="tsId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerTs(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerTs(@ServiceParam(name="tsId") String id)  throws BusException{
		return propertyservicemanagerTsDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerTs(String propertyName,Object value) throws BusException{
		return propertyservicemanagerTsDao.exists(propertyName,value);
	}

    /**
	 * 根据派工id修改保修状态
	 * @param id 派工id
	 * @param code 判断回绝与接单标识
	 * @throws BusException
	 */
    @EsbServiceMapping
	public void upTsbyId(@ServiceParam(name="id") String id,
			@ServiceParam(name="code") String code) throws BusException {
    	PropertyservicemanagerTs  ts = propertyservicemanagerTsDao.get(id);
    	PropertyservicemanagerBx bx = ts.getPropertyservicemanagerBx();
		if(code.equals("00")){//维修人员接单，改状态为已接单，已派工
			ts.setTsStatus("01");
			ts.setTsTime(DateUtils.getToday("yyyy-MM-dd"));
			bx.setBxStatus("03");
			propertyservicemanagerTsDao.save(ts);
			propertyservicemanagerBxDao.save(bx);
		}else{//维修人员拒单，改状态
			ts.setTsStatus("02");
			bx.setBxStatus("01");
			propertyservicemanagerTsDao.save(ts);
			propertyservicemanagerBxDao.save(bx);
		}
	}

    @EsbServiceMapping
   	public List<PropertyservicemanagerTs> getMemberInformationByLoginUser() throws BusException {
       	//,先在数据库插入tsId=1
       	String m="1"; 
       	return propertyservicemanagerTsDao.getList("tsId", m); 
   	}
       /**
        * 修改状态
        * @return
        * @throws BusException
        */
      @EsbServiceMapping
       public PropertyservicemanagerTs updatepassword(
       		@ServiceParam(name="memberId") String memberId,
       		@ServiceParam(name="memberPassword") String memberPassword
       		) throws BusException{   	
   	   PropertyservicemanagerTs psm = propertyservicemanagerTsDao.get(memberId);  
       		
       		psm.setTsStatus(memberPassword);
   	    	return propertyservicemanagerTsDao.save(psm);
       		
       }

    /**
	 * 根据报修id查找接单状态下的派工记录
	 * @param bxId
	 * @return
	 * @throws BusException
	 */
    @EsbServiceMapping
	public PropertyservicemanagerTs getTsBybxId(@ServiceParam(name="bxId") String bxId)
			throws BusException {
    	PropertyservicemanagerTs ts = null;
    	Collection<Condition> conditionts =  new ArrayList<Condition>();
		conditionts.add(ConditionUtils.getCondition("tsStatus", Condition.EQUALS,"01"));//查询已已受理
		conditionts.add(ConditionUtils.getCondition("propertyservicemanagerBx.bxId", Condition.EQUALS,bxId));
		List<PropertyservicemanagerTs> listTs = propertyservicemanagerTsDao.commonQuery(conditionts, null);
		if(listTs.size()>0){
			ts = listTs.get(0);	 
		}
		return ts;		
	}


    
}
