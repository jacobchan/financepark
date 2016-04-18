package com.manage.EnterpriseManager.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.manage.EnterpriseManager.entity.InformationLegal;
import com.manage.EnterpriseManager.dao.InformationLegalDao;
import com.manage.EnterpriseManager.service.InformationLegalManager;
@Service("informationLegalManager")
@Transactional
public class InformationLegalManagerImpl extends BaseManagerImpl implements InformationLegalManager{
	@Autowired
	private InformationLegalDao informationLegalDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<InformationLegal> getInformationLegals() throws BusException{
    	return informationLegalDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<InformationLegal> getInformationLegals(
    	@ConditionCollection(domainClazz=InformationLegal.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return informationLegalDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public InformationLegal getInformationLegal(@ServiceParam(name="legalId") String id)  throws BusException{
    	return informationLegalDao.get(id);
    }
    
    /**
     * 根据唯一属性查询对象
     */
    @Override
    @EsbServiceMapping
    public InformationLegal getObjectByUniqueProperty(String paramString,String paramObject)  throws BusException{
    	return informationLegalDao.getObjectByUniqueProperty(paramString, paramObject);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerInformationLegals(Pager pager,//分页条件
			@ConditionCollection(domainClazz=InformationLegal.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = informationLegalDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping(pubConditions={@PubCondition(property="updateUse",pubProperty="userId")})
    public InformationLegal saveInformationLegal(InformationLegal o) throws BusException{
    	String informationLegalId = o.getLegalId();
    	boolean isUpdate = StringUtils.isNotEmpty(informationLegalId);
    	if(isUpdate){//修改
    		InformationLegal legal = informationLegalDao.get(informationLegalId);
    		legal.setLegalRe(o.getLegalRe());
    		legal.setLegalName(o.getLegalName());
    		legal.setLegalBirthday(o.getLegalBirthday());
    		legal.setLegalTelephone(o.getLegalTelephone());
    		legal.setLegalBusiness(o.getLegalBusiness());
    		legal.setLegalRemark(o.getLegalRemark());
    		if(StringUtils.isNotEmpty(o.getLegalImage())){
    			legal.setLegalImage(o.getLegalImage());
    		}
    		legal.setUpdateUser(o.getUpdateUser());
    		legal.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return informationLegalDao.save(legal);
    	}else{//新增
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
        	o.setCreateUser(o.getUpdateUser());
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return informationLegalDao.save(o);
    	}
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeInformationLegal(@ServiceParam(name="legalId") String id) throws BusException{
    	informationLegalDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeInformationLegals(@ServiceParam(name="legalId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeInformationLegal(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitInformationLegal(@ServiceParam(name="legalId") String id)  throws BusException{
		return informationLegalDao.exists(id);
	}
    
    public boolean exsitInformationLegal(String propertyName,Object value) throws BusException{
		return informationLegalDao.exists(propertyName,value);
	}

    /**
	 * 根据企业id查询法人信息
	 * @param legalRe 入驻企业id
	 * @return 符合条件的法人对象集合
	 * @throws BusException
	 * @author ZhuYL
	 * @time 2016-03-18
	 */
	@EsbServiceMapping
	public List<InformationLegal> findInformationLegal(
			@ServiceParam(name = "legalRe") String legalRe)
			throws BusException {
		Collection<Condition> condition = new ArrayList<Condition>();
		Collection<Order> order = new ArrayList<Order>();
		condition.add(ConditionUtils.getCondition("legalRe",
				Condition.EQUALS, legalRe));
		order.add(ConditionUtils.getOrder("createTime", true));
		List<InformationLegal> list = informationLegalDao
				.commonQuery(condition, order);
		return list;
	}
}