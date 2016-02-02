/**
 * 代码声明
 */
package com.manage.EnterpriseMessageManager.service.impl;

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

import com.manage.EnterpriseMessageManager.entity.LettermanagerComment;
import com.manage.EnterpriseMessageManager.dao.LettermanagerCommentDao;
import com.manage.EnterpriseMessageManager.service.LettermanagerCommentManager;

@Service("lettermanagerCommentManager")
@Transactional
public class LettermanagerCommentManagerImpl extends BaseManagerImpl implements LettermanagerCommentManager{
	@Autowired
	private LettermanagerCommentDao lettermanagerCommentDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<LettermanagerComment> getLettermanagerComments() throws BusException{
    	return lettermanagerCommentDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<LettermanagerComment> getLettermanagerComments(
    	@ConditionCollection(domainClazz=LettermanagerComment.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return lettermanagerCommentDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public LettermanagerComment getLettermanagerComment(@ServiceParam(name="commentId") String id)  throws BusException{
    	return lettermanagerCommentDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerLettermanagerComments(Pager pager,//分页条件
			@ConditionCollection(domainClazz=LettermanagerComment.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = lettermanagerCommentDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public LettermanagerComment saveLettermanagerComment(LettermanagerComment o) throws BusException{
//    	String lettermanagerCommentId = o.getLettermanagerCommentId();
//    	boolean isUpdate = StringUtils.isNotEmpty(lettermanagerCommentId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return lettermanagerCommentDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeLettermanagerComment(@ServiceParam(name="commentId") String id) throws BusException{
    	lettermanagerCommentDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeLettermanagerComments(@ServiceParam(name="commentId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeLettermanagerComment(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitLettermanagerComment(@ServiceParam(name="commentId") String id)  throws BusException{
		return lettermanagerCommentDao.exists(id);
	}
    
    public boolean exsitLettermanagerComment(String propertyName,Object value) throws BusException{
		return lettermanagerCommentDao.exists(propertyName,value);
	}

}
