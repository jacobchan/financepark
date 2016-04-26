/**
 * 代码声明
 */
package com.member.shoppingCarManager.service.impl;

import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.OrderManager.entity.OrdermanagerCommoditydetail;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.service.OrdermanagerCommoditydetailManager;
import com.common.OrderManager.service.OrdermanagerUserorderManager;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.service.PurchasingmanagerCommodityManager;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.utils.BizCodeUtil;
import com.member.shoppingCarManager.entity.ShoppingcarGroup;
import com.member.shoppingCarManager.dao.ShoppingcarGroupDao;
import com.member.shoppingCarManager.service.ShoppingcarGroupManager;

@Service("shoppingcarGroupManager")
@Transactional
public class ShoppingcarGroupManagerImpl extends BaseManagerImpl implements ShoppingcarGroupManager{
	@Autowired
	private ShoppingcarGroupDao shoppingcarGroupDao;
	@Autowired
	private OrdermanagerUserorderManager ordermanagerUserorderManager;
	@Autowired
	private OrdermanagerCommoditydetailManager ordermanagerCommoditydetailManager;
	@Autowired
	private PurchasingmanagerCommodityManager purchasingmanagerCommodityManager;
	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<ShoppingcarGroup> getShoppingcarGroups() throws BusException{
    	return shoppingcarGroupDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<ShoppingcarGroup> getShoppingcarGroups(
    	@ConditionCollection(domainClazz=ShoppingcarGroup.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return shoppingcarGroupDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public ShoppingcarGroup getShoppingcarGroup(@ServiceParam(name="companyGroupId") String id)  throws BusException{
    	return shoppingcarGroupDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerShoppingcarGroups(Pager pager,//分页条件
			@ConditionCollection(domainClazz=ShoppingcarGroup.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = shoppingcarGroupDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public ShoppingcarGroup saveShoppingcarGroup(ShoppingcarGroup o) throws BusException{
//    	String shoppingcarGroupId = o.getShoppingcarGroupId();
//    	boolean isUpdate = StringUtils.isNotEmpty(shoppingcarGroupId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return shoppingcarGroupDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeShoppingcarGroup(@ServiceParam(name="companyGroupId") String id) throws BusException{
    	shoppingcarGroupDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeShoppingcarGroups(@ServiceParam(name="companyGroupId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeShoppingcarGroup(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitShoppingcarGroup(@ServiceParam(name="companyGroupId") String id)  throws BusException{
		return shoppingcarGroupDao.exists(id);
	}
    
    public boolean exsitShoppingcarGroup(String propertyName,Object value) throws BusException{
		return shoppingcarGroupDao.exists(propertyName,value);
	}
    
    /**
	 * 新增采购订单
	 */
    @Override
    @EsbServiceMapping
	public OrdermanagerUserorder savePurOrder(OrdermanagerUserorder o,
			@DomainCollection(domainClazz=ShoppingcarGroup.class)List<ShoppingcarGroup> shopCarList) throws BusException {
		if(shopCarList.size() == 0){
			throw new BusException("购物车不能为空！");
		}
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getPurchasingmanagerGenre(shopCarList.get(0).getCommodityId().getGenreId());
		while(pg.getGenreId() != null){//获取最顶级商品类别
			pg = purchasingmanagerGenreManager.getPurchasingmanagerGenre(pg.getGenreId());
		}
		o.setGenreId(pg);
		o.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("CG"));
		o.setUserorderStatus("01");//01-未支付
		o = ordermanagerUserorderManager.saveOrdermanagerUserorder(o);
		for(ShoppingcarGroup shopCar:shopCarList){//保存订单明细
			OrdermanagerCommoditydetail orderDetail = new OrdermanagerCommoditydetail();
//			orderDetail.setOrdermanagerUserorder(order);
			orderDetail.setOrderId(o.getUserorderId());
			orderDetail.setCommodityId(shopCar.getCommodityId());
			orderDetail.setCommoditydetailNum(shopCar.getCompanyCateringNum());
			ordermanagerCommoditydetailManager.saveOrdermanagerCommoditydetail(orderDetail);
		}
		return o;
	}
}
