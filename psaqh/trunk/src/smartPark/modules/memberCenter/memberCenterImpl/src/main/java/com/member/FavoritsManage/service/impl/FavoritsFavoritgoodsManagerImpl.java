/**
 * 代码声明
 */
package com.member.FavoritsManage.service.impl;

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

import com.gsoft.framework.core.service.impl.BaseManagerImpl;

import com.member.FavoritsManage.entity.FavoritsFavoritgoods;
import com.member.FavoritsManage.dao.FavoritsFavoritgoodsDao;
import com.member.FavoritsManage.service.FavoritsFavoritgoodsManager;

@Service("favoritsFavoritgoodsManager")
@Transactional
public class FavoritsFavoritgoodsManagerImpl extends BaseManagerImpl implements FavoritsFavoritgoodsManager{
	@Autowired
	private FavoritsFavoritgoodsDao favoritsFavoritgoodsDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<FavoritsFavoritgoods> getFavoritsFavoritgoodss() throws BusException{
    	return favoritsFavoritgoodsDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<FavoritsFavoritgoods> getFavoritsFavoritgoodss(
    	@ConditionCollection(domainClazz=FavoritsFavoritgoods.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return favoritsFavoritgoodsDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public FavoritsFavoritgoods getFavoritsFavoritgoods(@ServiceParam(name="favoritGoodsId") String id)  throws BusException{
    	return favoritsFavoritgoodsDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerFavoritsFavoritgoodss(Pager pager,//分页条件
			@ConditionCollection(domainClazz=FavoritsFavoritgoods.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = favoritsFavoritgoodsDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public FavoritsFavoritgoods saveFavoritsFavoritgoods(FavoritsFavoritgoods o) throws BusException{
//    	String favoritsFavoritgoodsId = o.getFavoritsFavoritgoodsId();
//    	boolean isUpdate = StringUtils.isNotEmpty(favoritsFavoritgoodsId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return favoritsFavoritgoodsDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeFavoritsFavoritgoods(@ServiceParam(name="favoritGoodsId") String id) throws BusException{
    	favoritsFavoritgoodsDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeFavoritsFavoritgoodss(@ServiceParam(name="favoritGoodsId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeFavoritsFavoritgoods(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitFavoritsFavoritgoods(@ServiceParam(name="favoritGoodsId") String id)  throws BusException{
		return favoritsFavoritgoodsDao.exists(id);
	}
    
    public boolean exsitFavoritsFavoritgoods(String propertyName,Object value) throws BusException{
		return favoritsFavoritgoodsDao.exists(propertyName,value);
	}

}
