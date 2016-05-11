/**
 * 代码声明
 */
package com.common.purchasingManager.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
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
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.dao.PurchasingmanagerGenreDao;
import com.common.purchasingManager.service.PurchasingmanagerCommodityManager;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;

@Service("purchasingmanagerGenreManager")
@Transactional
public class PurchasingmanagerGenreManagerImpl extends BaseManagerImpl implements PurchasingmanagerGenreManager{
	@Autowired
	private PurchasingmanagerGenreDao purchasingmanagerGenreDao;
	@Autowired
	private PurchasingmanagerCommodityManager purchasingmanagerCommodityManager;
	
    /**
     * 查询列表
     */
    @EsbServiceMapping
    public List<PurchasingmanagerGenre> getPurchasingmanagerGenres() throws BusException{
    	return purchasingmanagerGenreDao.getAll();
    }
    /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PurchasingmanagerGenre> getPurchasingmanagerGenres(
    		@ConditionCollection(domainClazz=PurchasingmanagerGenre.class) Collection<Condition> conditions,
    		@OrderCollection Collection<Order> orders) throws BusException{
    	return purchasingmanagerGenreDao.commonQuery(conditions, orders);
    }


    /**
     * 根据商品类别（enreCode）查询商品
     */
    @EsbServiceMapping
    public List<PurchasingmanagerGenre> getPurchasingmanagerGenresByGenreCode(
    		@ConditionCollection(domainClazz=PurchasingmanagerGenre.class) Collection<Condition> conditions,
    		@OrderCollection Collection<Order> orders) throws BusException{
    	Collection<Condition> condition = new ArrayList<Condition>();
    	Collection<Order> order = new ArrayList<Order>();
    	condition.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS, "03"));// 查询属于公共资源的商品：genreCode=03
    	List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreDao.commonQuery(condition, order);
    	if(purchasingmanagerGenreList.size()>0){
    		conditions.add(ConditionUtils.getCondition("pagrenId",Condition.EQUALS, purchasingmanagerGenreList.get(0).getGenreId()));// 查询公共资源下包含的商品
    	}
    	return purchasingmanagerGenreDao.commonQuery(conditions, orders);
    }
   
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PurchasingmanagerGenre getPurchasingmanagerGenre(@ServiceParam(name="genreId") String id)  throws BusException{
    	PurchasingmanagerGenre pg = purchasingmanagerGenreDao.get(id);
    	if(pg.getPagrenId() != null){
    		PurchasingmanagerGenre parentGenre =  purchasingmanagerGenreDao.get(pg.getPagrenId());
    		pg.setParentGenre(parentGenre);
    	}
    	return pg;
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPurchasingmanagerGenres(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerGenre.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = purchasingmanagerGenreDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PurchasingmanagerGenre savePurchasingmanagerGenre(PurchasingmanagerGenre o) throws BusException{
    	String genreId = o.getGenreId();
    	boolean isUpdate = StringUtils.isNotEmpty(genreId);
    	if(isUpdate){//修改
    		PurchasingmanagerGenre pg = purchasingmanagerGenreDao.get(genreId);
    		pg.setGenreName(o.getGenreName());
    		pg.setUpdateUser(o.getUpdateUser());
    		pg.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerGenreDao.save(pg);
    	
    	}else{//新增
    		if(o.getPagrenId() != null){
    			o.setPagrenId(o.getPagrenId());
    		}
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
        	return purchasingmanagerGenreDao.save(o);
    	}
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePurchasingmanagerGenre(@ServiceParam(name="genreId") String id) throws BusException{
    	PurchasingmanagerGenre pg = purchasingmanagerGenreDao.get(id);
    	if(pg.getGenreCode() != null){
    		throw new BusException("不能删除预定义类别！");
    	}else{
    		purchasingmanagerGenreDao.remove(id);
    	}
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePurchasingmanagerGenres(@ServiceParam(name="genreId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePurchasingmanagerGenre(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPurchasingmanagerGenre(@ServiceParam(name="genreId") String id)  throws BusException{
		return purchasingmanagerGenreDao.exists(id);
	}
    
    public boolean exsitPurchasingmanagerGenre(String propertyName,Object value) throws BusException{
		return purchasingmanagerGenreDao.exists(propertyName,value);
	}
    /**
   	 * 获取所有的企业服务类别列表
   	 */
   	@Override
   	public List<PurchasingmanagerGenre> getCompSerGenres() throws BusException {
   		PurchasingmanagerGenre pg = purchasingmanagerGenreDao.getObjectByUniqueProperty("genreCode", "05");
   		List<PurchasingmanagerGenre> returnList = new ArrayList<PurchasingmanagerGenre>();
   		List<PurchasingmanagerGenre> list = purchasingmanagerGenreDao.getAll();
   		for(Iterator<PurchasingmanagerGenre> iterator = list.iterator(); iterator.hasNext();) {
   			PurchasingmanagerGenre node = (PurchasingmanagerGenre) iterator.next();
               // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
               if (pg.getGenreId().equals(node.getGenreId())) {
                   recursionFn(list, node,returnList);
               }
           }
   		return returnList;
   	}
    /**
	 * 获取所有的采购类别列表
	 */
	@Override
	public List<PurchasingmanagerGenre> getPurGenres() throws BusException {
		PurchasingmanagerGenre pg = purchasingmanagerGenreDao.getObjectByUniqueProperty("genreCode", "01");
		List<PurchasingmanagerGenre> returnList = new ArrayList<PurchasingmanagerGenre>();
		List<PurchasingmanagerGenre> list = purchasingmanagerGenreDao.getAll();
		for(Iterator<PurchasingmanagerGenre> iterator = list.iterator(); iterator.hasNext();) {
			PurchasingmanagerGenre node = (PurchasingmanagerGenre) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (pg.getGenreId().equals(node.getGenreId())) {
                recursionFn(list, node,returnList);
            }
        }
		return returnList;
	}
	private void recursionFn(List<PurchasingmanagerGenre> list, PurchasingmanagerGenre node,List<PurchasingmanagerGenre> returnList) {
        List<PurchasingmanagerGenre> childList = getChildList(list, node);// 得到子节点列表
        if (hasChild(list, node)) {// 判断是否有子节点
            returnList.add(node);
            Iterator<PurchasingmanagerGenre> it = childList.iterator();
            while (it.hasNext()) {
            	PurchasingmanagerGenre n = (PurchasingmanagerGenre) it.next();
                recursionFn(list, n,returnList);
            }
        } else {
            returnList.add(node);
        }
    }
     
    // 得到子节点列表
    private List<PurchasingmanagerGenre> getChildList(List<PurchasingmanagerGenre> list, PurchasingmanagerGenre node) {
        List<PurchasingmanagerGenre> nodeList = new ArrayList<PurchasingmanagerGenre>();
        Iterator<PurchasingmanagerGenre> it = list.iterator();
        while (it.hasNext()) {
        	PurchasingmanagerGenre n = (PurchasingmanagerGenre) it.next();
        	if (node.getGenreId().equals(n.getPagrenId())) {
                nodeList.add(n);
            }
        }
        return nodeList;
    }
 
    // 判断是否有子节点
    private boolean hasChild(List<PurchasingmanagerGenre> list, PurchasingmanagerGenre node) {
        return getChildList(list, node).size() > 0 ? true : false;
    }
	/**
	 * 获取所有的采购、餐饮、IT服务类别列表
	 */
	@Override
	public List<PurchasingmanagerGenre> getPurFoodGenres() throws BusException {
		List<PurchasingmanagerGenre> list = new ArrayList<PurchasingmanagerGenre>();
		list = purchasingmanagerGenreDao.getPurFoodGenresList();
		return list;
	}
	/**
	 * 获取所有的订单类型列表
	 */
	@Override
	public List<PurchasingmanagerGenre> getOrderTypes() throws BusException {
		List<PurchasingmanagerGenre> list = new ArrayList<PurchasingmanagerGenre>();
		list = purchasingmanagerGenreDao.getOrderTypesList();
		return list;
	}
	
	/**
	 * 获取商户类别列表
	 * @return
	 * @throws BusException
	 */
	@Override
	@EsbServiceMapping
	public List<PurchasingmanagerGenre> getMerchantGenres() throws BusException {
		List<PurchasingmanagerGenre> list = new ArrayList<PurchasingmanagerGenre>();
		List<PurchasingmanagerGenre> pgList = getPurchasingmanagerGenres();
		for(PurchasingmanagerGenre pg:pgList){
			if(pg.getGenreId() == null){
				list.add(pg);
			}
		}
		return list;
	}
	/**
	 * 根据类别唯一属性获取对象
	 */
	@Override
	public PurchasingmanagerGenre getGenreByUniqueProperty(String paramString,Object paramObject)
			throws BusException {
		return purchasingmanagerGenreDao.getObjectByUniqueProperty(paramString, paramObject);
	}
	/**
	 * 获取所有商品类别列表
	 */
	@Override
	public List<PurchasingmanagerGenre> getCommodityGenreList() throws BusException {
		List<PurchasingmanagerGenre> list = new ArrayList<PurchasingmanagerGenre>();
		list = purchasingmanagerGenreDao.getCommodityGenreList();
		return list;
	}
	/**
	 * 获取IT服务的所有类别列表
	 */
	@Override
	@EsbServiceMapping
	public List<PurchasingmanagerGenre> getITSubGenreList(@ServiceParam(name="userId",pubProperty="userId") String userId)
			throws BusException {
		PurchasingmanagerGenre pg = purchasingmanagerGenreDao.getObjectByUniqueProperty("genreCode", "0508");
		List<PurchasingmanagerGenre> list = purchasingmanagerGenreDao.getList("pagrenId", pg.getGenreId());
		for(PurchasingmanagerGenre purgenre:list){
			List<PurchasingmanagerCommodity> purCommodityList =  purchasingmanagerCommodityManager.getCommodityRecordsByGenreId(purgenre.getGenreId());
			if(purCommodityList != null){
				purgenre.setFristpurCommodity(purCommodityList.get(0));
			}
		}
		return list;
	}
	/**
	 * 获取公共资源的所有类别列表
	 */
	@Override
	@EsbServiceMapping
	public List<PurchasingmanagerGenre> getPublicResoOrderTypes(@ServiceParam(name="userId",pubProperty="userId") String userId)
			throws BusException {
		PurchasingmanagerGenre pg = purchasingmanagerGenreDao.getObjectByUniqueProperty("genreCode", "03");
		List<PurchasingmanagerGenre> list = purchasingmanagerGenreDao.getList("pagrenId", pg.getGenreId());
		return list;
	}
	/**
	 * 获取企业服务的所有类别列表
	 */
	@Override
	@EsbServiceMapping
	public List<PurchasingmanagerGenre> getCompSerOrderTypes(@ServiceParam(name="userId",pubProperty="userId") String userId)
			throws BusException {
		PurchasingmanagerGenre pg = purchasingmanagerGenreDao.getObjectByUniqueProperty("genreCode", "05");
		List<PurchasingmanagerGenre> list = purchasingmanagerGenreDao.getList("pagrenId", pg.getGenreId());
		return list;
	}
	/**
	 * 获取企业服务的所有类别列表(包括IT服务子类别)
	 */
	@Override
	@EsbServiceMapping
	public List<PurchasingmanagerGenre> getCompOrderTypes()
			throws BusException {
		PurchasingmanagerGenre pg = purchasingmanagerGenreDao.getObjectByUniqueProperty("genreCode", "05");
		List<PurchasingmanagerGenre> list = purchasingmanagerGenreDao.getList("pagrenId", pg.getGenreId());
		PurchasingmanagerGenre ITpg = purchasingmanagerGenreDao.getObjectByUniqueProperty("genreCode", "0508");
		List<PurchasingmanagerGenre> ITList = purchasingmanagerGenreDao.getList("pagrenId", ITpg.getGenreId());
		for(PurchasingmanagerGenre pgenre:ITList){
			list.add(pgenre);
		}
		return list;
	}
	//获取订单项
	@Override
	@EsbServiceMapping
	public List<PurchasingmanagerGenre> getGenreProject(@ServiceParam(name="userId",pubProperty="userId") String userId){
		PurchasingmanagerGenre pg1 = purchasingmanagerGenreDao.getObjectByUniqueProperty("genreCode", "03");
		PurchasingmanagerGenre pg2 = purchasingmanagerGenreDao.getObjectByUniqueProperty("genreCode", "04");
		PurchasingmanagerGenre pg3 = purchasingmanagerGenreDao.getObjectByUniqueProperty("genreCode", "05");
		PurchasingmanagerGenre pg4 = purchasingmanagerGenreDao.getObjectByUniqueProperty("genreCode", "06");
		String[] buff = new String[]{pg1.getGenreId(),pg2.getGenreId(),pg3.getGenreId(),pg4.getGenreId()};
		Collection<Condition> conditions = new ArrayList<Condition>();
		conditions.add(ConditionUtils.getCondition("pagrenId", Condition.IN, buff));
		List<PurchasingmanagerGenre> list = purchasingmanagerGenreDao.commonQuery(conditions, null);
		PurchasingmanagerGenre pg5 = purchasingmanagerGenreDao.getObjectByUniqueProperty("genreCode", "02");
		list.add(pg5);
		return list;
	}
}
