/**
 * 代码声明
 */
package com.member.MemberCommentManager.service.impl;

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

import com.member.MemberCommentManager.entity.MemberComment;
import com.member.MemberCommentManager.dao.MemberCommentDao;
import com.member.MemberCommentManager.service.MemberCommentManager;

@Service("memberCommentManager")
@Transactional
public class MemberCommentManagerImpl extends BaseManagerImpl implements MemberCommentManager{
	@Autowired
	private MemberCommentDao memberCommentDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<MemberComment> getMemberComments() throws BusException{
    	return memberCommentDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<MemberComment> getMemberComments(
    	@ConditionCollection(domainClazz=MemberComment.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return memberCommentDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public MemberComment getMemberComment(@ServiceParam(name="goodsCommentId") String id)  throws BusException{
    	return memberCommentDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerMemberComments(Pager pager,//分页条件
			@ConditionCollection(domainClazz=MemberComment.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = memberCommentDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public MemberComment saveMemberComment(MemberComment o) throws BusException{
//    	String memberCommentId = o.getMemberCommentId();
//    	boolean isUpdate = StringUtils.isNotEmpty(memberCommentId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return memberCommentDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeMemberComment(@ServiceParam(name="goodsCommentId") String id) throws BusException{
    	memberCommentDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeMemberComments(@ServiceParam(name="goodsCommentId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeMemberComment(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitMemberComment(@ServiceParam(name="goodsCommentId") String id)  throws BusException{
		return memberCommentDao.exists(id);
	}
    
    public boolean exsitMemberComment(String propertyName,Object value) throws BusException{
		return memberCommentDao.exists(propertyName,value);
	}

}
