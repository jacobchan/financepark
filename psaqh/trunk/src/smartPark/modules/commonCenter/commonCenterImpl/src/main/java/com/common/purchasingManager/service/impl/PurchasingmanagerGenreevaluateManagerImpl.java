/**
 * 代码声明
 */
package com.common.purchasingManager.service.impl;

import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.purchasingManager.dao.PurchasingmanagerGenreevaluateDao;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.entity.PurchasingmanagerGenreevaluate;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;
import com.common.purchasingManager.service.PurchasingmanagerGenreevaluateManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;


@Service("purchasingmanagerGenreevaluateManager")
@Transactional
public class PurchasingmanagerGenreevaluateManagerImpl extends BaseManagerImpl implements PurchasingmanagerGenreevaluateManager{
	@Autowired
	private PurchasingmanagerGenreevaluateDao purchasingmanagerGenreevaluateDao;
	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	@Autowired
	private MemberInformationManager memberInformationManager;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PurchasingmanagerGenreevaluate> getPurchasingmanagerGenreevaluates() throws BusException{
    	return purchasingmanagerGenreevaluateDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PurchasingmanagerGenreevaluate> getPurchasingmanagerGenreevaluates(
    	@ConditionCollection(domainClazz=PurchasingmanagerGenreevaluate.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return purchasingmanagerGenreevaluateDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PurchasingmanagerGenreevaluate getPurchasingmanagerGenreevaluate(@ServiceParam(name="genreevaluateId") String id)  throws BusException{
    	return purchasingmanagerGenreevaluateDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPurchasingmanagerGenreevaluates(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerGenreevaluate.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = purchasingmanagerGenreevaluateDao.findByPager(pager, conditions, orders);
		@SuppressWarnings("unchecked")
		List<PurchasingmanagerGenreevaluate> purGenreEvaluateList = pagerRecords.getRecords();
		for(PurchasingmanagerGenreevaluate pgv:purGenreEvaluateList){
			MemberInformation mem = memberInformationManager.getMemberInformation(pgv.getMember());
			pgv.setMemberInformation(mem);
		}
		return pagerRecords;
	}
    /**
     * 保存对象
     */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PurchasingmanagerGenreevaluate savePurchasingmanagerGenreevaluate(PurchasingmanagerGenreevaluate o) throws BusException{
    	String genreevaluateId = o.getGenreevaluateId();
    	boolean isUpdate = StringUtils.isNotEmpty(genreevaluateId);
    	if(isUpdate){//修改
    		PurchasingmanagerGenreevaluate pgv = purchasingmanagerGenreevaluateDao.get(genreevaluateId);
    		pgv.setUpdateUser(o.getUpdateUser());
    		pgv.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		pgv.setContent(o.getContent());
    		pgv.setCostPerformance(o.getCostPerformance());
    		pgv.setOverallSatisfaction(o.getOverallSatisfaction());
    		pgv.setReactionRate(o.getReactionRate());
    		pgv.setServiceAttitude(o.getServiceAttitude());
    		return purchasingmanagerGenreevaluateDao.save(pgv);
    	}else{//新增
    		o.setMember(o.getUpdateUser());
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerGenreevaluateDao.save(o);
    	}
    }
	//提交评论
	@Override
	@EsbServiceMapping
    public PurchasingmanagerGenreevaluate savePurGenreEvaluate(@ServiceParam(name="userId",pubProperty="userId") String userId,
    		@ServiceParam(name="overallSatisfaction") String overallSatisfaction,@ServiceParam(name="reactionRate") String reactionRate,
    		@ServiceParam(name="serviceAttitude") String serviceAttitude,@ServiceParam(name="costPerformance") String costPerformance,
    		@ServiceParam(name="genreCode") String genreCode,@ServiceParam(name="evaluateContent") String evaluateContent) throws BusException{
		PurchasingmanagerGenreevaluate pgv = new PurchasingmanagerGenreevaluate();
		pgv.setContent(evaluateContent);
		pgv.setOverallSatisfaction(overallSatisfaction);
		pgv.setReactionRate(reactionRate);
		pgv.setServiceAttitude(serviceAttitude);
		pgv.setCostPerformance(costPerformance);
		pgv.setType("01");//01-评论
		PurchasingmanagerGenre purGenre = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode", genreCode);
		pgv.setPurGenre(purGenre);
		pgv.setCreateUser(userId);
		pgv.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		pgv.setMember(userId);
		pgv.setUpdateUser(userId);
		pgv.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		return purchasingmanagerGenreevaluateDao.save(pgv);
	}
	//提交咨询
	@Override
	@EsbServiceMapping
    public PurchasingmanagerGenreevaluate savePurGenreConsult(@ServiceParam(name="userId",pubProperty="userId") String userId,
    		@ServiceParam(name="genreCode") String genreCode,@ServiceParam(name="content") String content) throws BusException{
		PurchasingmanagerGenreevaluate pgv = new PurchasingmanagerGenreevaluate();
		pgv.setContent(content);
		pgv.setType("02");//02-咨询
		PurchasingmanagerGenre purGenre = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode", genreCode);
		pgv.setPurGenre(purGenre);
		pgv.setCreateUser(userId);
		pgv.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		pgv.setMember(userId);
		pgv.setUpdateUser(userId);
		pgv.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		return purchasingmanagerGenreevaluateDao.save(pgv);
	}
	//根据商品类别编码获取评论列表
	@SuppressWarnings("unchecked")
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerPurGenreEvaluatesByCode(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerGenreevaluate.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,@ServiceParam(name="genreCode") String genreCode)  throws BusException{
		conditions.add(ConditionUtils.getCondition("purGenre.genreCode", Condition.EQUALS, genreCode));
		conditions.add(ConditionUtils.getCondition("type", Condition.EQUALS, "01"));
		pager.setStartIndex(0);
		pager.setPageSize(3);
		orders.add(ConditionUtils.getOrder("createTime", false));
		PagerRecords pagerRecords = purchasingmanagerGenreevaluateDao.findByPager(pager, conditions, orders);
		List<PurchasingmanagerGenreevaluate> purGenreEvaluateList = pagerRecords.getRecords();
		for(PurchasingmanagerGenreevaluate pgv:purGenreEvaluateList){
			MemberInformation mem = memberInformationManager.getMemberInformation(pgv.getMember());
			pgv.setMemberInformation(mem);
		}
		return pagerRecords;
	}

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePurchasingmanagerGenreevaluate(@ServiceParam(name="genreevaluateId") String id) throws BusException{
    	purchasingmanagerGenreevaluateDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePurchasingmanagerGenreevaluates(@ServiceParam(name="genreevaluateId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePurchasingmanagerGenreevaluate(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPurchasingmanagerGenreevaluate(@ServiceParam(name="genreevaluateId") String id)  throws BusException{
		return purchasingmanagerGenreevaluateDao.exists(id);
	}
    
    public boolean exsitPurchasingmanagerGenreevaluate(String propertyName,Object value) throws BusException{
		return purchasingmanagerGenreevaluateDao.exists(propertyName,value);
	}

}
