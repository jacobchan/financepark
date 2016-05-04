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

import com.member.FavoritsManage.entity.FavoritsFavoritActivity;
import com.member.FavoritsManage.dao.FavoritsFavoritActivityDao;
import com.member.FavoritsManage.service.FavoritsFavoritActivityManager;

@Service("favoritsFavoritActivityManager")
@Transactional
public class FavoritsFavoritActivityManagerImpl extends BaseManagerImpl implements FavoritsFavoritActivityManager{
	@Autowired
	private FavoritsFavoritActivityDao favoritsFavoritActivityDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<FavoritsFavoritActivity> getFavoritsFavoritActivitys() throws BusException{
    	return favoritsFavoritActivityDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<FavoritsFavoritActivity> getFavoritsFavoritActivitys(
    	@ConditionCollection(domainClazz=FavoritsFavoritActivity.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return favoritsFavoritActivityDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public FavoritsFavoritActivity getFavoritsFavoritActivity(@ServiceParam(name="favoritActivityId") String id)  throws BusException{
    	return favoritsFavoritActivityDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerFavoritsFavoritActivitys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=FavoritsFavoritActivity.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = favoritsFavoritActivityDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public FavoritsFavoritActivity saveFavoritsFavoritActivity(FavoritsFavoritActivity o) throws BusException{
//    	String favoritsFavoritActivityId = o.getFavoritsFavoritActivityId();
//    	boolean isUpdate = StringUtils.isNotEmpty(favoritsFavoritActivityId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return favoritsFavoritActivityDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeFavoritsFavoritActivity(@ServiceParam(name="favoritActivityId") String id) throws BusException{
    	favoritsFavoritActivityDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeFavoritsFavoritActivitys(@ServiceParam(name="favoritActivityId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeFavoritsFavoritActivity(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitFavoritsFavoritActivity(@ServiceParam(name="favoritActivityId") String id)  throws BusException{
		return favoritsFavoritActivityDao.exists(id);
	}
    
    public boolean exsitFavoritsFavoritActivity(String propertyName,Object value) throws BusException{
		return favoritsFavoritActivityDao.exists(propertyName,value);
	}

}
