/**
 * 代码声明
 */
package com.distribution.rule.service.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.distribution.rule.dao.DisRateConfigDao;
import com.distribution.rule.entity.DisRateConfig;
import com.distribution.rule.service.DisRateConfigManager;
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
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.util.StringUtils;

@Service("disRateConfigManager")
@Transactional
public class DisRateConfigManagerImpl extends BaseManagerImpl implements DisRateConfigManager{
	@Autowired
	private DisRateConfigDao disRateConfigDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<DisRateConfig> getDisRateConfigs() throws BusException{
    	return disRateConfigDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<DisRateConfig> getDisRateConfigs(
    	@ConditionCollection(domainClazz=DisRateConfig.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return disRateConfigDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public DisRateConfig getDisRateConfig(@ServiceParam(name="recId") String id)  throws BusException{
    	return disRateConfigDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerDisRateConfigs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=DisRateConfig.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = disRateConfigDao.findByPager(pager, conditions, orders);
		@SuppressWarnings("unchecked")
		List<DisRateConfig> disRateConfigList=pagerRecords.getRecords();
		for(DisRateConfig disRateConfig:disRateConfigList){
			String disRate=disRateConfig.getDisRate();
			BigDecimal dicRates = new BigDecimal(disRate);
			if(disRate.indexOf(".")>0){
				//分佣比率四舍五入取两位两数
				BigDecimal dic = dicRates.setScale(2, BigDecimal.ROUND_HALF_UP);
				disRateConfig.setDisRateShow(String.valueOf(dic)+"%");
			}else{
				disRateConfig.setDisRateShow(String.valueOf(dicRates)+"%");
			}
			
			
		}
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public void saveDisRateConfig(DisRateConfig o,
    		@ServiceParam(name="v1") String v1,
    		@ServiceParam(name="v2") String v2,
    		@ServiceParam(name="v3") String v3) throws BusException{
    	String disRateConfigId = o.getRecId();
    	boolean isUpdate = StringUtils.isNotEmpty(disRateConfigId);
    	
    	if(isUpdate){//修改
    		disRateConfigDao.save(o);
    	}else{//新增
    		for(int i=0;i<=2;i++){
    			if(i==0){
    				o.setMemLevel("1");
    				o.setDisRate(v1);
    			}else if(i==1){
    				o.setMemLevel("2");
    				o.setDisRate(v2);
    			}else if(i==2){
    				o.setMemLevel("3");
    				o.setDisRate(v3);
    			}
    			disRateConfigDao.save(o);
    		}
    	}
    
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeDisRateConfig(@ServiceParam(name="recId") String id) throws BusException{
    	disRateConfigDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeDisRateConfigs(@ServiceParam(name="recId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeDisRateConfig(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitDisRateConfig(@ServiceParam(name="recId") String id)  throws BusException{
		return disRateConfigDao.exists(id);
	}
    	
    public boolean exsitDisRateConfig(String propertyName,Object value) throws BusException{
		return disRateConfigDao.exists(propertyName,value);
	}
	
  
    @EsbServiceMapping
	public String getLevel(@ServiceParam(name="level") String level) throws BusException {
    	String msg = "";
    	List<DisRateConfig> list = disRateConfigDao.getList("disLevel", level);
    	if(list.size()>0){
    		msg="false";
    	}else{
    		msg="true";
    	}
		return msg;
	}

}
