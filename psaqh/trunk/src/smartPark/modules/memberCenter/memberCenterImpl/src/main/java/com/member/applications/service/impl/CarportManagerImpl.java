/**
 * 代码声明
 */
package com.member.applications.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.service.OrdermanagerUserorderManager;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.PubCondition;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.utils.BizCodeUtil;
import com.member.applications.dao.CarportDao;
import com.member.applications.entity.Carport;
import com.member.applications.service.CarportManager;

@Service("carportManager")
@Transactional
public class CarportManagerImpl extends BaseManagerImpl implements CarportManager{
	@Autowired
	private CarportDao carportDao;
	
	@Autowired
	private OrdermanagerUserorderManager ordermanagerUserorderManager;
	
	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<Carport> getCarports() throws BusException{
    	return carportDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<Carport> getCarports(
    	@ConditionCollection(domainClazz=Carport.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return carportDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public Carport getCarport(@ServiceParam(name="id") String id)  throws BusException{
    	return carportDao.get(id);
    }
	
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "memberId", pubProperty = "userId")})
	public PagerRecords getPagerCarports(Pager pager,//分页条件
			@ConditionCollection(domainClazz=Carport.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,
			@ServiceParam(name="indexPage") String indexPage)  throws BusException{
		
		pager.setPageIndex(Integer.valueOf(indexPage));
		pager.setPageSize(10);
		PagerRecords pagerRecords = carportDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "memberId", pubProperty = "userId")})
    public Carport saveCarport(Carport o,@ServiceParam(name="userorderAmount") String userorderAmount) throws BusException{
    	String carportId = o.getId();
    	boolean isUpdate = StringUtils.isNotEmpty(carportId);
    	if(isUpdate){//修改
    		Carport car = new Carport();
    		car=carportDao.get(carportId);
    		car.setApplayStatus("0");
    		return carportDao.save(car);
    	}else{//新增
    		//申请编号
    		String applayNo = BizCodeUtil.getInstance().getBizCodeDate("ITFW");
    		//生成订单
    		OrdermanagerUserorder order = new OrdermanagerUserorder();
    		order.setUserorderAmount(new BigDecimal(userorderAmount));
    		String memberId= o.getMemberId();
    		o.setUpdateUser(memberId);
    		order.setMemberId(memberId);
    		order.setUserorderCode(applayNo);
    		
    		Collection<Condition> conditionP = new ArrayList<Condition>();
    		conditionP.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS,"0304"));
    		List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(conditionP, null);
    		if(purchasingmanagerGenreList.size()>0){
    			//genreId = purchasingmanagerGenreList.get(0).getGenreId();
    			order.setGenreId(purchasingmanagerGenreList.get(0));
    			order.setUserorderProject(purchasingmanagerGenreList.get(0).getGenreName());
    		}
    	
    		
    		order.setUserorderBuyUser(o.getCpEnName());
    		order.setUserorderStatus("01");
    		order = ordermanagerUserorderManager.saveOrdermanagerUserorder(order);
    		
    		System.out.println(order.getUserorderId());
    		//保存订单编号
    		o.setApplayNo(order.getUserorderId());
    		
    		o.setApplayStatus("1");
        	
    	}
    	return carportDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeCarport(@ServiceParam(name="id") String id) throws BusException{
    	carportDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeCarports(@ServiceParam(name="id") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeCarport(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitCarport(@ServiceParam(name="id") String id)  throws BusException{
		return carportDao.exists(id);
	}
    
    public boolean exsitCarport(String propertyName,Object value) throws BusException{
		return carportDao.exists(propertyName,value);
	}
    
 

}
