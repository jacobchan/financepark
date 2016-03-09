/**
 * 代码声明
 */
package com.common.MemberManager.service.impl;

import java.util.List;
import java.util.Collection;

//import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.dataobj.tree.TreeNode;
//import com.gsoft.framework.security.DefaultLoginFormToken;
//import com.gsoft.framework.security.IAgency;
//import com.gsoft.framework.security.IRealmUserInfo;
//import com.gsoft.framework.security.IRealmUserToken;
//import com.gsoft.framework.security.IUser;
//import com.gsoft.framework.security.IUserAdapter;
//import com.gsoft.framework.security.agt.entity.User;
//import com.gsoft.framework.security.agt.service.UserLoginService;
//import com.gsoft.framework.security.agt.service.UserManager;
//import com.gsoft.framework.core.dataobj.tree.TreeNode;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.security.DefaultLoginFormToken;
import com.gsoft.framework.security.IAgency;
import com.gsoft.framework.security.IRealmUserInfo;
import com.gsoft.framework.security.IRealmUserToken;
import com.gsoft.framework.security.IUser;
import com.gsoft.framework.security.IUserAdapter;
import com.gsoft.framework.security.agt.service.UserLoginService;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.PasswordUtils;
import com.gsoft.framework.util.SecurityUtils;
import com.gsoft.framework.util.StringUtils;

import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.core.web.menu.IMenu;
//import com.gsoft.framework.core.web.menu.IMenu;
//import com.sun.star.setup.OSType;
import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.entity.MemberUserInfo;
import com.common.MemberManager.dao.MemberInformationDao;
import com.common.MemberManager.service.MemberInformationManager;

@Service("memberInformationManager")
@Transactional
public class MemberInformationManagerImpl extends BaseManagerImpl implements MemberInformationManager
,UserLoginService<MemberInformation>,IUserAdapter<MemberInformation,DefaultLoginFormToken>,Ordered{
	@Autowired
	private MemberInformationDao memberInformationDao;
//	@Autowired
//	private UserManager userManager;
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
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public MemberInformation saveMemberInformation(MemberInformation o) throws BusException{
    	String memberInformationId = o.getMemberId();
    	boolean isUpdate = StringUtils.isNotEmpty(memberInformationId);
    	String userName=SecurityUtils.getAccount().getLoginName();
    	if(isUpdate){//修改
    		MemberInformation mi= memberInformationDao.get(memberInformationId);
    		mi.setMemberPhoneNumber(o.getMemberPhoneNumber());
    		mi.setMemberName(o.getMemberName());
    		mi.setMemberNickname(o.getMemberNickname());
    		mi.setMemberBirthdate(o.getMemberBirthdate());
    		mi.setMemberDescribe2(o.getMemberDescribe2());
    		mi.setCompanyId(o.getCompanyId());
    		mi.setUpdateUser(userName);
    		mi.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return memberInformationDao.save(mi);
    	}else{//新增
    		o.setCreateUser(userName);
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateUser(userName);
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
        	return memberInformationDao.save(o);
    	}
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
    /**
	 * 用户注册
	 * @param userName 用户名
	 * @param passwd 密码
	 * @param repasswd 重复密码
	 * @param mobile 手机号
	 * @throws BusException
	 */
    @EsbServiceMapping
	public void saveReister(@ServiceParam(name="userName") String userName,
			@ServiceParam(name="passwd") String passwd,
			@ServiceParam(name="repasswd") String repasswd,
			@ServiceParam(name="mobile") String mobile)
			throws BusException {
    	//判断该用户是否存在
		MemberInformation memberInformationed = memberInformationDao.getObjectByUniqueProperty("memberName", userName);
		if(memberInformationed==null){
			//新增用户
			//判断用户密码是否准确
			if (!passwd.equals(repasswd))
				throw new BusException("两次输入的密码不一致");
//				User user = new User();
//				user.setLoginName(userName);
//				user.setUserCaption(userName);
//				user.setUserActive("1");
//				user.setPassword(PasswordUtils.md5Password(repasswd));
//				user.setGroup("003");
//				User saveuser = userManager.saveUser(user);
			//保存用户同时insert youi_user
//			if(saveuser!=null){
				MemberInformation memberInformation = new MemberInformation();
//				memberInformation.setMemberId(saveuser.getUserId());
				memberInformation.setMemberName(userName);
				memberInformation.setMemberPassword(PasswordUtils.md5Password(repasswd));
				memberInformation.setMemberPhoneNumber(mobile);
				memberInformationDao.save(memberInformation);
//			}
	}else{
		throw new BusException("该用户已存在!");
		}
	}
    
    /**
	 * 获取用户基本信息
	 * @param user 登陆用户名
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping(pubConditions={@PubCondition(property="updateUser",pubProperty="userId")})
	public MemberInformation getMemberInformationByLoginUser(MemberInformation o)
			throws BusException {
		// TODO Auto-generated method stub	
		
		return memberInformationDao.get(o.getUpdateUser());
	}
	@Override
	public List<String> getAccountMenus(MemberInformation member) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<IAgency> getAgencyByParent(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TreeNode getAgencyTree() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<IMenu> getProviderMenus() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IRealmUserInfo getRealmUserInfo(DefaultLoginFormToken token) {
		// TODO Auto-generated method stub
		//疑问，token里面存值，是在什么地方存储的？，多种方式登录如何处理，如用邮箱登录，手机登录，用户名登录。
		//因为2，登录类型是从哪里获取的？
		String memberName = token.getUsername();
		MemberInformation member = this.memberInformationDao.getObjectByUniqueProperty("memberName", memberName);
		member.getPrincipalConfig().put("userId", member.getMemberId());
		member.getPrincipalConfig().put("loginType", token.getLoginType());
		return new MemberUserInfo(member);
	}
	@Override
	public IRealmUserInfo getRealmUserInfo(MemberInformation member) {
		// TODO Auto-generated method stub
		return new MemberUserInfo(member);
	}
	@Override
	public boolean supports(IRealmUserToken token) {
		if(token instanceof DefaultLoginFormToken){
			//只支持带登录类型的登录
			return  StringUtils.isNotEmpty(((DefaultLoginFormToken) token).getLoginType());
		}
		return false;
	}
	@Override
	public boolean supports(IUser member) {
		// TODO Auto-generated method stub
		return MemberInformation.class.isAssignableFrom(member.getClass());
	}
	@Override
	public MemberInformation getLoginUser(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return -1;
	}
	

}
