/**
 * 代码声明
 */
package com.common.MemberManager.service.impl;

import java.util.List;
import java.util.ArrayList;
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

import com.common.MemberManager.entity.MemberRole;
import com.common.MemberManager.dao.MemberRoleDao;
import com.common.MemberManager.service.MemberRoleManager;

@Service("memberRoleManager")
@Transactional
public class MemberRoleManagerImpl extends BaseManagerImpl implements MemberRoleManager{
	@Autowired
	private MemberRoleDao memberRoleDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<MemberRole> getMemberRoles() throws BusException{
    	return memberRoleDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<MemberRole> getMemberRoles(
    	@ConditionCollection(domainClazz=MemberRole.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return memberRoleDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public MemberRole getMemberRole(@ServiceParam(name="roleId") String id)  throws BusException{
    	return memberRoleDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerMemberRoles(Pager pager,//分页条件
			@ConditionCollection(domainClazz=MemberRole.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = memberRoleDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public MemberRole saveMemberRole(MemberRole o) throws BusException{
//    	String memberRoleId = o.getMemberRoleId();
//    	boolean isUpdate = StringUtils.isNotEmpty(memberRoleId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return memberRoleDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeMemberRole(@ServiceParam(name="roleId") String id) throws BusException{
    	memberRoleDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeMemberRoles(@ServiceParam(name="roleId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeMemberRole(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitMemberRole(@ServiceParam(name="roleId") String id)  throws BusException{
		return memberRoleDao.exists(id);
	}
    
    public boolean exsitMemberRole(String propertyName,Object value) throws BusException{
		return memberRoleDao.exists(propertyName,value);
	}
    
    /**
     * 获取用户所有角色ID
     * @param memberId 会员用户ID
     * @return 角色ID数组
     */
    public List<String> getRolesByMemberId(String memberId) throws BusException{
    	List<String> roles = new ArrayList<String>();
    	List<MemberRole> resultList = this.memberRoleDao.getList("memberId", memberId);
    	for(MemberRole memberRole : resultList){
    		roles.add(memberRole.getRoleId());
    	}
    	return roles;
    }

}
