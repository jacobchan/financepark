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
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.utils.BizCodeUtil;
import com.member.shoppingCarManager.entity.ShoppingcarCompanyserver;
import com.member.shoppingCarManager.dao.ShoppingcarCompanyserverDao;
import com.member.shoppingCarManager.service.ShoppingcarCompanyserverManager;

@Service("shoppingcarCompanyserverManager")
@Transactional
public class ShoppingcarCompanyserverManagerImpl extends BaseManagerImpl implements ShoppingcarCompanyserverManager{
	@Autowired
	private ShoppingcarCompanyserverDao shoppingcarCompanyserverDao;
	@Autowired
	private OrdermanagerUserorderManager ordermanagerUserorderManager;
	@Autowired
	private OrdermanagerCommoditydetailManager ordermanagerCommoditydetailManager;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<ShoppingcarCompanyserver> getShoppingcarCompanyservers() throws BusException{
    	return shoppingcarCompanyserverDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<ShoppingcarCompanyserver> getShoppingcarCompanyservers(
    	@ConditionCollection(domainClazz=ShoppingcarCompanyserver.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return shoppingcarCompanyserverDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public ShoppingcarCompanyserver getShoppingcarCompanyserver(@ServiceParam(name="companyServerId") String id)  throws BusException{
    	return shoppingcarCompanyserverDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerShoppingcarCompanyservers(Pager pager,//分页条件
			@ConditionCollection(domainClazz=ShoppingcarCompanyserver.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = shoppingcarCompanyserverDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public ShoppingcarCompanyserver saveShoppingcarCompanyserver(ShoppingcarCompanyserver o) throws BusException{
//    	String shoppingcarCompanyserverId = o.getShoppingcarCompanyserverId();
//    	boolean isUpdate = StringUtils.isNotEmpty(shoppingcarCompanyserverId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return shoppingcarCompanyserverDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeShoppingcarCompanyserver(@ServiceParam(name="companyServerId") String id) throws BusException{
    	shoppingcarCompanyserverDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeShoppingcarCompanyservers(@ServiceParam(name="companyServerId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeShoppingcarCompanyserver(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitShoppingcarCompanyserver(@ServiceParam(name="companyServerId") String id)  throws BusException{
		return shoppingcarCompanyserverDao.exists(id);
	}
    
    public boolean exsitShoppingcarCompanyserver(String propertyName,Object value) throws BusException{
		return shoppingcarCompanyserverDao.exists(propertyName,value);
	}
    
    /**
	 * 新增企业服务订单
	 */
    @Override
    @EsbServiceMapping
	public OrdermanagerUserorder saveCompSerOrder(OrdermanagerUserorder o,
			List<ShoppingcarCompanyserver> shopCarList) throws BusException {
		if(shopCarList.size() == 0){
			throw new BusException("购物车不能为空！");
		}
		PurchasingmanagerGenre pg = shopCarList.get(0).getCommodityId().getPurchasingmanagerGenre();
		while(pg.getPurchasingmanagerGenre() != null){//获取最顶级商品类别
			pg = pg.getPurchasingmanagerGenre();
		}
		o.setGenreId(pg);
		o.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("QYFW"));
		o.setUserorderStatus("01");//01-未支付
		o = ordermanagerUserorderManager.saveOrdermanagerUserorder(o);
		for(ShoppingcarCompanyserver shopCar:shopCarList){//保存订单明细
			OrdermanagerCommoditydetail orderDetail = new OrdermanagerCommoditydetail();
			orderDetail.setOrdermanagerUserorder(o);
			orderDetail.setCommodityId(shopCar.getCommodityId().getCommodityId());
			orderDetail.setCommoditydetailNum(shopCar.getCompanyCateringNum());
			ordermanagerCommoditydetailManager.saveOrdermanagerCommoditydetail(orderDetail);
		}
		return o;
	}

}
