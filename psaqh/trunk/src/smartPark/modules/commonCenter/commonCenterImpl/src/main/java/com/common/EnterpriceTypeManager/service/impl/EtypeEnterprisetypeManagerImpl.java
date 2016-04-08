package com.common.EnterpriceTypeManager.service.impl;
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
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.common.EnterpriceTypeManager.entity.EtypeEnterprisetype;
import com.common.EnterpriceTypeManager.dao.EtypeEnterprisetypeDao;
import com.common.EnterpriceTypeManager.service.EtypeEnterprisetypeManager;
@Service("etypeEnterprisetypeManager")
@Transactional
public class EtypeEnterprisetypeManagerImpl extends BaseManagerImpl implements EtypeEnterprisetypeManager{
	@Autowired
	private EtypeEnterprisetypeDao etypeEnterprisetypeDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<EtypeEnterprisetype> getEtypeEnterprisetypes() throws BusException{
    	return etypeEnterprisetypeDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<EtypeEnterprisetype> getEtypeEnterprisetypes(
    	@ConditionCollection(domainClazz=EtypeEnterprisetype.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return etypeEnterprisetypeDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public EtypeEnterprisetype getEtypeEnterprisetype(@ServiceParam(name="enTypeId") String id)  throws BusException{
    	return etypeEnterprisetypeDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerEtypeEnterprisetypes(Pager pager,//分页条件
			@ConditionCollection(domainClazz=EtypeEnterprisetype.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = etypeEnterprisetypeDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public EtypeEnterprisetype saveEtypeEnterprisetype(EtypeEnterprisetype o) throws BusException{
    	return etypeEnterprisetypeDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeEtypeEnterprisetype(@ServiceParam(name="enTypeId") String id) throws BusException{
    	etypeEnterprisetypeDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeEtypeEnterprisetypes(@ServiceParam(name="enTypeId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeEtypeEnterprisetype(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitEtypeEnterprisetype(@ServiceParam(name="enTypeId") String id)  throws BusException{
		return etypeEnterprisetypeDao.exists(id);
	}
    
    public boolean exsitEtypeEnterprisetype(String propertyName,Object value) throws BusException{
		return etypeEnterprisetypeDao.exists(propertyName,value);
	}
    
    @SuppressWarnings("unused")
	public List<EtypeEnterprisetype> getChildren(
			@ServiceParam(name="enTypeId") String parentId) throws BusException {
		Collection<Condition> conditions = new ArrayList<Condition>();
		Collection<Order> orders = new ArrayList<Order>();
		orders.add(ConditionUtils.getOrder("code", true));
		if(StringUtils.isEmpty(parentId)){
			List<EtypeEnterprisetype> ees = new ArrayList<EtypeEnterprisetype>();
		}else{
			conditions.add(ConditionUtils.getCondition("etypeEnterprisetype.enTypeId", Condition.EQUALS, parentId));
		}
	
		return etypeEnterprisetypeDao.commonQuery(conditions, orders);
	}
    
    /**
	 * 获取父级企业类型
	 * @return
	 * @throws BusException
	 */
    @EsbServiceMapping
	public List<EtypeEnterprisetype> getParentEnterpriseType() throws BusException{
		return etypeEnterprisetypeDao.getEtypeEnterprisetypeList();
	}
    
    /**
	 * 获取企业类型JSon
	 * @return
	 * @throws BusException
	 */
    @EsbServiceMapping
	public String findEnterpriseTypeTree(@ServiceParam(name="pId") String pId) throws BusException{
		StringBuffer resultJson = new StringBuffer();
		String json = "";
		Collection<Condition> conditions = new ArrayList<Condition>();
		Collection<Order> orders = new ArrayList<Order>();
		conditions.add(ConditionUtils.getCondition("etypeEnterprisetype.enTypeId", Condition.EQUALS, pId));
		orders.add(ConditionUtils.getOrder("enTypeId", true));
		List<EtypeEnterprisetype> sc = etypeEnterprisetypeDao.commonQuery(conditions, orders);
		if (sc.size() > 0) {
			for (int i = 0; i < sc.size(); i++) {
				if(!"".equals(sc.get(i).getEtypeEnterprisetype()) && null!=sc.get(i).getEtypeEnterprisetype()){
					resultJson.append("{id:'" + sc.get(i).getEnTypeId() + "', pId:'" + sc.get(i).getEtypeEnterprisetype().getEnTypeId() + "', name:'" + sc.get(i).getEnTypeName() + "'},");
				}else{
					resultJson.append("{id:'" + sc.get(i).getEnTypeId() + "', pId:'', name:'" + sc.get(i).getEnTypeName() + "', open:true, nocheck:true},");
				}
			}
			json = resultJson.substring(0, resultJson.length() - 1);
		}
		return json;
	}
}
