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
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.EnterpriseManager.entity.InformationMedia;
import com.manage.EnterpriseManager.dao.InformationMediaDao;
import com.manage.EnterpriseManager.service.InformationMediaManager;
@Service("informationMediaManager")
@Transactional
public class InformationMediaManagerImpl extends BaseManagerImpl implements InformationMediaManager{
	@Autowired
	private InformationMediaDao informationMediaDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<InformationMedia> getInformationMedias() throws BusException{
    	return informationMediaDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<InformationMedia> getInformationMedias(
    	@ConditionCollection(domainClazz=InformationMedia.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return informationMediaDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public InformationMedia getInformationMedia(@ServiceParam(name="mediaId") String id)  throws BusException{
    	return informationMediaDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerInformationMedias(Pager pager,//分页条件
			@ConditionCollection(domainClazz=InformationMedia.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = informationMediaDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public InformationMedia saveInformationMedia(InformationMedia o) throws BusException{
//    	String informationMediaId = o.getInformationMediaId();
//    	boolean isUpdate = StringUtils.isNotEmpty(informationMediaId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return informationMediaDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeInformationMedia(@ServiceParam(name="mediaId") String id) throws BusException{
    	informationMediaDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeInformationMedias(@ServiceParam(name="mediaId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeInformationMedia(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitInformationMedia(@ServiceParam(name="mediaId") String id)  throws BusException{
		return informationMediaDao.exists(id);
	}
    
    public boolean exsitInformationMedia(String propertyName,Object value) throws BusException{
		return informationMediaDao.exists(propertyName,value);
	}
    
    /**
	 * 根据企业id查询媒体信息
	 * @param mediaRe 入驻企业id
	 * @return 符合条件的媒体对象集合
	 * @throws BusException
	 * @author ZhuYL
	 * @time 2016-03-18
	 */
	@EsbServiceMapping
	public List<InformationMedia> findInformationMedia(
			@ServiceParam(name = "mediaRe") String mediaRe)
			throws BusException {
		Collection<Condition> condition = new ArrayList<Condition>();
		Collection<Order> order = new ArrayList<Order>();
		condition.add(ConditionUtils.getCondition("mediaRe",
				Condition.EQUALS, mediaRe));
		List<InformationMedia> list = informationMediaDao
				.commonQuery(condition, order);
		return list;
	}
}