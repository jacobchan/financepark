package com.manage.PropertyServiceManager.service.impl;
import java.util.List;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.common.MemberManager.dao.MemberInformationDao;
import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.utils.BizCodeUtil;
import com.gsoft.utils.HttpSenderMsg;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerCos;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerCosDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerCosManager;
@Service("propertyservicemanagerCosManager")
@Transactional
public class PropertyservicemanagerCosManagerImpl extends BaseManagerImpl implements PropertyservicemanagerCosManager{
	@Autowired
	private PropertyservicemanagerCosDao propertyservicemanagerCosDao;
	@Autowired
	private MemberInformationDao memberInformationDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerCos> getPropertyservicemanagerCoss() throws BusException{
    	return propertyservicemanagerCosDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerCos> getPropertyservicemanagerCoss(
    	@ConditionCollection(domainClazz=PropertyservicemanagerCos.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerCosDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerCos getPropertyservicemanagerCos(@ServiceParam(name="cosId") String id)  throws BusException{
    	return propertyservicemanagerCosDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerCoss(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerCos.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerCosDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PropertyservicemanagerCos savePropertyservicemanagerCos(PropertyservicemanagerCos o) throws BusException{
    	if(!"".equals(o.getUpdateUser()) && null!=o.getUpdateUser()){
    		MemberInformation memberInformation = memberInformationDao.get(o.getUpdateUser());
        	o.setMemberInformation(memberInformation);
    	}
    	o.setCosCode(BizCodeUtil.getInstance().getBizCodeDate("WYTS"));
    	o.setCosStatus("0");
    	if("".equals(o.getCosTime()) || null==o.getCosTime()){
    		o.setCosTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
    	}
    	try {
			HttpSenderMsg.sendMsg(o.getCosTelephone(), "您提交的投诉："+o.getCosCode()+"待物业管理员受理中，请及时关注受理状态！");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return propertyservicemanagerCosDao.save(o);
    }
    
    /**
     * 修改对象
     */
    @EsbServiceMapping
    public PropertyservicemanagerCos updatePropertyservicemanagerCos(PropertyservicemanagerCos o) throws BusException{
    	PropertyservicemanagerCos cos = propertyservicemanagerCosDao.get(o.getCosId());
    	cos.setBackrecord(o.getBackrecord());
    	cos.setBackcode(BizCodeUtil.getInstance().getBizCodeDate("WYHF"));
    	cos.setBacktime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
    	try {
			HttpSenderMsg.sendMsg(cos.getCosTelephone(), "您的投诉："+cos.getCosCode()+"回访信息为："+o.getBackrecord()+"！");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return propertyservicemanagerCosDao.save(cos);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerCos(@ServiceParam(name="cosId") String id) throws BusException{
    	propertyservicemanagerCosDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerCoss(@ServiceParam(name="cosId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerCos(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerCos(@ServiceParam(name="cosId") String id)  throws BusException{
		return propertyservicemanagerCosDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerCos(String propertyName,Object value) throws BusException{
		return propertyservicemanagerCosDao.exists(propertyName,value);
	}

    @EsbServiceMapping
	public void upCosbyId(@ServiceParam(name="id") String id,
			@ServiceParam(name="code") String code) throws BusException {
    	PropertyservicemanagerCos cos = propertyservicemanagerCosDao.get(id);
    	cos.setCosStatus(code);
    	propertyservicemanagerCosDao.save(cos);
	}
    /**
     * 获取当前登录用户id
     * @return
     * @throws BusException
     */
    @EsbServiceMapping
	public List<PropertyservicemanagerCos> getCosListByLoginUser(PropertyservicemanagerCos p) throws BusException {
    	String id = p.getCreateUser();	    	
    	List<PropertyservicemanagerCos> list =propertyservicemanagerCosDao.getList("memberInformation.memberId", id);
    	return list; 
	}
   /**
    * 前台修改订单
    * @param cosId
    * @return
    * @throws BusException
    */
 @SuppressWarnings("unused")
@EsbServiceMapping
   public PropertyservicemanagerCos updateCosforpage(@ServiceParam(name="cosId") String cosId) throws BusException{
	   PropertyservicemanagerCos psm = propertyservicemanagerCosDao.get(cosId);
	   String cosStatus = psm.getCosStatus();
	   if(psm!=null){
		   //取消投诉 
		   if(cosStatus.equals("0")||cosStatus.equals("1")||cosStatus.equals("2")){
			   psm.setCosStatus("3");
			   psm.setUpdateTime("yyyy-MM-dd HH:mm:ss");
		   }
			return propertyservicemanagerCosDao.save(psm);
	   }else{
		   throw new BusException("未查询到投诉记录，如有疑问请与客服人员联系");
	   } 
   }
}