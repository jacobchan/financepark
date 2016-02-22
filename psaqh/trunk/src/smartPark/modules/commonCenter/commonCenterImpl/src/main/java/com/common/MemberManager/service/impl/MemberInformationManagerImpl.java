/**
 * 代码声明
 */
package com.common.MemberManager.service.impl;

import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.security.agt.service.UserManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.PasswordUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.dao.MemberInformationDao;
import com.common.MemberManager.service.MemberInformationManager;

@Service("memberInformationManager")
@Transactional
public class MemberInformationManagerImpl extends BaseManagerImpl implements MemberInformationManager{
	@Autowired
	private MemberInformationDao memberInformationDao;
	@Autowired
	private UserManager userManager;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<MemberInformation> getMemberInformations() throws BusException{
    	return memberInformationDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<MemberInformation> getMemberInformations(
    	@ConditionCollection(domainClazz=MemberInformation.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return memberInformationDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public MemberInformation getMemberInformation(@ServiceParam(name="memberId") String id)  throws BusException{
    	return memberInformationDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerMemberInformations(Pager pager,//分页条件
			@ConditionCollection(domainClazz=MemberInformation.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = memberInformationDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public MemberInformation saveMemberInformation(MemberInformation o) throws BusException{
//    	String memberInformationId = o.getMemberInformationId();
//    	boolean isUpdate = StringUtils.isNotEmpty(memberInformationId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return memberInformationDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeMemberInformation(@ServiceParam(name="memberId") String id) throws BusException{
    	memberInformationDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeMemberInformations(@ServiceParam(name="memberId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeMemberInformation(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitMemberInformation(@ServiceParam(name="memberId") String id)  throws BusException{
		return memberInformationDao.exists(id);
	}
    
    public boolean exsitMemberInformation(String propertyName,Object value) throws BusException{
		return memberInformationDao.exists(propertyName,value);
	}
    @EsbServiceMapping
	public void saveReister(@ServiceParam(name="userName") String userName,
			@ServiceParam(name="passwd") String passwd,
			@ServiceParam(name="repasswd") String repasswd,
			@ServiceParam(name="mobile") String mobile)
			throws BusException {
		MemberInformation memberInformationed = memberInformationDao.getObjectByUniqueProperty("memberName", userName);
		if(memberInformationed==null){
			
			MemberInformation memberInformation = new MemberInformation();
			memberInformation.setMemberName(userName);
			memberInformation.setMemberPassword(PasswordUtils.md5Password(repasswd));
			memberInformation.setMemberPhoneNumber(mobile);
			/*User user = new User();
			user.setLoginName(userName);
			user.setPassword(PasswordUtils.md5Password(repasswd));
			user.setGroup("001");
			userManager.saveUser(user);*/
			memberInformationDao.save(memberInformation);
	}else{
		throw new BusException("该用户已存在!");
		}
	}

}
