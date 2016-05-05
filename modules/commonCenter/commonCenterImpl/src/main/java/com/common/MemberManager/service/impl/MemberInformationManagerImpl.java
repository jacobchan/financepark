/**
 * 代码声明
 */
package com.common.MemberManager.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.MemberManager.dao.MemberInformationDao;
import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.entity.MemberRole;
import com.common.MemberManager.entity.MemberUserInfo;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.MemberManager.service.MemberRoleManager;
import com.common.MessageCenter.service.McMsgdatasManager;
import com.gsoft.entity.TempDemo;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.dataobj.tree.TreeNode;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.core.web.menu.IMenu;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.PubCondition;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.security.DefaultLoginFormToken;
import com.gsoft.framework.security.IAgency;
import com.gsoft.framework.security.IRealmUserInfo;
import com.gsoft.framework.security.IRealmUserToken;
import com.gsoft.framework.security.IUser;
import com.gsoft.framework.security.IUserAdapter;
import com.gsoft.framework.security.agt.service.UserLoginService;
import com.gsoft.framework.util.Assert;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.PasswordUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.utils.EncryptUtil;


@Service("memberInformationManager")
@Transactional
public class MemberInformationManagerImpl extends BaseManagerImpl implements MemberInformationManager,
		UserLoginService<MemberInformation>, IUserAdapter<MemberInformation, DefaultLoginFormToken>, Ordered {
	@Autowired
	private MemberInformationDao memberInformationDao;
	@Autowired
	private MemberRoleManager memberRoleManager;
	@Autowired
	private McMsgdatasManager mcMsgdatasManager;
	@Value("${ininin.sso_url}")
	private String inininSsoUrl;
	@Value("${ininin.compname}")
	private String companyName;

	/**
	 * 查询列表
	 */
	// @EsbServiceMapping
	public List<MemberInformation> getMemberInformations() throws BusException {
		return memberInformationDao.getAll();
	}

	/**
	 * 条件查询列表
	 */
	@EsbServiceMapping
	public List<MemberInformation> getMemberInformations(
			@ConditionCollection(domainClazz = MemberInformation.class) Collection<Condition> conditions,
			@OrderCollection Collection<Order> orders) throws BusException {
		return memberInformationDao.commonQuery(conditions, orders);
	}

	/**
	 * 根据主键查询
	 */
	@EsbServiceMapping
	public MemberInformation getMemberInformation(@ServiceParam(name = "memberId") String id) throws BusException {
		MemberInformation member = memberInformationDao.get(id);
		List<String> memberRoles = memberRoleManager.getRolesByMemberId(id);
		member.setRoleIds(memberRoles);
		return member;
	}

	@EsbServiceMapping
	public PagerRecords getPagerMemberInformations(Pager pager, // 分页条件
			@ConditionCollection(domainClazz = MemberInformation.class) Collection<Condition> conditions, // 查询条件
			@OrderCollection Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = memberInformationDao.findByPager(pager, conditions, orders);
		pagerRecords.getTotalCount();
		// Pager pager1=pagerRecords.getPager();
		return pagerRecords;
	}

	/**
	 * 保存对象
	 */
	@EsbServiceMapping(pubConditions = { @PubCondition(property = "updateUser", pubProperty = "userId") })
	public MemberInformation saveMemberInformation(MemberInformation o) throws BusException {
		String memberInformationId = o.getMemberId();
		boolean isUpdate = StringUtils.isNotEmpty(memberInformationId);
		if (isUpdate) {// 修改
			MemberInformation mi = memberInformationDao.get(memberInformationId);

			mi.setMemberPhoneNumber(o.getMemberPhoneNumber());
			mi.setMemberName(o.getMemberName());
			mi.setMemberNickname(o.getMemberNickname());
			mi.setMemberBirthdate(o.getMemberBirthdate());
			mi.setMemberDescribe2(o.getMemberDescribe2());
			mi.setCompanyId(o.getCompanyId());
			mi.setUpdateUser(o.getUpdateUser());
			mi.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
			mi.setMemberPassword(o.getMemberPassword());
			return memberInformationDao.save(mi);
		} else {// 新增
			o.setCreateUser(o.getUpdateUser());
			o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
			o.setUpdateUser(o.getUpdateUser());
			o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));

			MemberInformation member = memberInformationDao.save(o);
			// 添加默认角色
			this.setDefaultRole(member);
			return member;
		}
	}
	
	//APP端重新设置密码
	@Override
	@RequestMapping
	public MemberInformation findPwdReset(
			@RequestParam("phone") String phone,
			@RequestParam("passwd") String passwd,
			@RequestParam("repasswd") String repasswd,
			@RequestParam("phoneCode") String phoneCode) {

		if(com.gsoft.framework.util.StringUtils.isEmpty(passwd)){
			throw new BusException("密码不能为空！");
		}
		if (!passwd.equals(repasswd)) {
			throw new BusException("两次输入的密码不一致");
		}
		MemberInformation mb = getUserByPhone(phone);
		if(mb == null){
			throw new BusException("用户不存在！");
		}else{
			TempDemo temp = mcMsgdatasManager.checkPhoneCode(phone, phoneCode);
			if(!temp.isFlag()){
				throw new BusException(temp.getBuff());
			}
			mb.setMemberPassword(PasswordUtils.md5Password(passwd));
			mb.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
			saveMemberInformation(mb);
		}
		return mb;
	}

	/**
	 * 删除对象
	 */
	@EsbServiceMapping
	public void removeMemberInformation(@ServiceParam(name = "memberId") String id) throws BusException {
		memberInformationDao.remove(id);
	}

	/**
	 * 根据主键集合删除对象
	 * 
	 * @param ids
	 */
	public void removeMemberInformations(@ServiceParam(name = "memberId") String[] ids) throws BusException {
		for (String id : ids) {
			removeMemberInformation(id);
		}
	}

	@EsbServiceMapping
	public boolean exsitMemberInformation(@ServiceParam(name = "memberId") String id) throws BusException {
		return memberInformationDao.exists(id);
	}

	public boolean exsitMemberInformation(String propertyName, Object value) throws BusException {
		return memberInformationDao.exists(propertyName, value);
	}

	/**
	 * 用户注册
	 * 
	 * @param passwd
	 *            密码
	 * @param passwd
	 *            重复密码
	 * @param mobile
	 *            手机号
	 * @throws BusException
	 */
	@EsbServiceMapping
	public TempDemo saveReister(@ServiceParam(name = "memberPassword") String passwd,
			@ServiceParam(name = "repasswd") String repasswd, @ServiceParam(name = "memberPhoneNumber") String phone,
			@ServiceParam(name = "captcha") String captcha)
					throws BusException {
		TempDemo td = this.exsitMobile(phone);
		if (td.isFlag()) {// 为true表明手机号已经注册
			throw new BusException("此手机号已经注册了！");
		}
		if ("".equals(passwd)) {
			throw new BusException("密码不能为空！");
		}
		if ("".equals(repasswd)) {
			throw new BusException("确认密码不能为空！");
		}
		if (passwd.length() < 6) {
			throw new BusException("密码长度不能小于6！");
		}
		if (passwd.length() > 16) {
			throw new BusException("密码长度不能大于16！");
		}
		if (!passwd.equals(repasswd)) {
			throw new BusException("两次密码输入不一致！");
		}
		TempDemo temp  = mcMsgdatasManager.checkPhoneCode(phone, captcha);
		if(temp.isFlag()){
			MemberInformation memberInformation = new MemberInformation();
			memberInformation.setMemberName(phone);
			memberInformation.setMemberPassword(PasswordUtils.md5Password(passwd));
			memberInformation.setMemberPhoneNumber(phone);
			MemberInformation member = memberInformationDao.save(memberInformation);
			// 添加默认角色
			this.setDefaultRole(member);
			
			//构建替换模板参数对应的map
			Map<String, Object> replaceMap = new HashMap<String, Object>();
			replaceMap.put("#user", phone);
			//发送消息,给会员
			mcMsgdatasManager.smsSend("1012", replaceMap, null, phone);
		}
		return temp;
	}

	/**
	 * 添加会员的默认角色 默认会员角色 ROLE_MEMBER
	 * 
	 * @param memberId
	 *            会员用户ID
	 */
	private void setDefaultRole(MemberInformation member) {
		MemberRole memberRole = new MemberRole();
		memberRole.setMemberId(member.getMemberId());
		memberRole.setRoleId("ROLE_MEMBER");
		member.roleIds().add("ROLE_MEMBER");
		this.memberRoleManager.saveMemberRole(memberRole);
	}

	/**
	 * 判断手机号是否已经注册
	 * 
	 * @param mobile
	 *            注册手机号
	 * @return
	 */
	@Override
	@EsbServiceMapping
	public TempDemo exsitMobile(@ServiceParam(name = "memberPhoneNumber") String mobile) {
		// 判断该用户是否存在
		TempDemo td = new TempDemo();// new 一个自定义对象
		MemberInformation memberInformationed = memberInformationDao.getObjectByUniqueProperty("memberPhoneNumber",
				mobile);
		if (memberInformationed != null) {// 存在，则将td中的flag设为true
			td.setFlag(true);
		} else {
			td.setFlag(false);
		}
		return td;
	}

	/**
	 * 获取用户基本信息
	 * 
	 * @param user
	 *            登陆用户名
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping
	public MemberInformation getMemberInformationByLoginUser(
			@ServiceParam(name = "userId", pubProperty = "userId") String userId) throws BusException {
		// TODO Auto-generated method stub

		return memberInformationDao.get(userId);
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
		// 疑问，token里面存值，是在什么地方存储的？，多种方式登录如何处理，如用邮箱登录，手机登录，用户名登录。
		// 因为2，登录类型是从哪里获取的？
		String phoneNumber = token.getUsername();
		MemberInformation member = this.memberInformationDao.getObjectByUniqueProperty("memberPhoneNumber",
				phoneNumber);
		// Collection<Condition> conditions = new Collection<Condition>();
		// conditions.add(Condition.)
		List<String> roles = memberRoleManager.getRolesByMemberId(member.getMemberId());
		member.setRoleIds(roles);
		member.getPrincipalConfig().put("userId", member.getMemberId());
		member.getPrincipalConfig().put("loginType", token.getLoginType());
		member.getPrincipalConfig().put("redirect", token.getRedirect());
		return new MemberUserInfo(member);
	}

	@Override
	public IRealmUserInfo getRealmUserInfo(MemberInformation member) {
		// TODO Auto-generated method stub
		return new MemberUserInfo(member);
	}

	@Override
	public boolean supports(IRealmUserToken token) {
		if (token instanceof DefaultLoginFormToken) {
			// 只支持带登录类型的登录
			return StringUtils.isNotEmpty(((DefaultLoginFormToken) token).getLoginType());
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

	/**
	 * 修改密码
	 * 
	 * @param password
	 * @param confirmPassword
	 * @param oldPassword
	 * @return 
	 * @return 
	 * @throws BusException
	 */
	@EsbServiceMapping
	public Record doModifyPassword(@ServiceParam(name = "password") String password,
			@ServiceParam(name = "confirmPassword") String confirmPassword,
			@ServiceParam(name = "oldPassword") String oldPassword,
			@ServiceParam(name = "userId", pubProperty = "userId") String userId) throws BusException {
		// TODO Auto-generated method stub
		Record record = new Record();
		String msg="";
		if (StringUtils.isEmpty(oldPassword)) {
			//throw new BusException("旧密码不能为空！");
			msg="旧密码不能为空";
		}
		if (StringUtils.isEmpty(password)) {
			//throw new BusException("新密码不能为空！");
			msg="新密码不能为空";
		}
		if (StringUtils.isEmpty(confirmPassword)) {
			//throw new BusException("确认密码不能为空！");
			msg="确认密码不能为空";
		}

		
		if (!password.equals(confirmPassword)) {
			//throw new BusException("两次输入的密码不一致！");
			msg="两次输入的密码不一致";
		}

		MemberInformation member = null;
		try {
			member = (MemberInformation) this.memberInformationDao.get(userId);
		} catch (Exception e) {
			//throw new BusException("查找用户ID[" + userId + "]出错！");
			msg="查找用户ID[" + userId + "]出错！";
		}
		Assert.notNull(member, "未找到用户！");
		if (!password.equals(confirmPassword)) {
			//throw new BusException("两次输入的密码不一致！");
			msg="两次输入的密码不一致！";
		}
		if (!PasswordUtils.md5Password(oldPassword).equals(member.getMemberPassword())) {
			//throw new BusException("请输入正确的旧密码！");
			msg="请输入正确的旧密码！";
		}else{
			if (password.equals(oldPassword)) {
				msg="新旧密码不能一样";
			}else{
				member.setMemberPassword(PasswordUtils.md5Password(password));
				memberInformationDao.save(member);
				if(PasswordUtils.md5Password(password).equals(member.getMemberPassword())){
					msg="修改成功";
				}
			}
		}

		

		record.put("msg", msg);
		return record;
	}

	/**
	 * 修改手机号码
	 * 
	 * @param memberPhoneNumber
	 * @throws BusException
	 */
	@EsbServiceMapping(pubConditions = { @PubCondition(property = "updateUser", pubProperty = "userId") })
	public void updatePhoneNumber(MemberInformation o) throws BusException {
		// TODO Auto-generated method stub
		MemberInformation member = null;
		try {
			member = (MemberInformation) this.memberInformationDao.get(o.getUpdateUser());
		} catch (Exception e) {
			throw new BusException("查找用户ID[" + o.getUpdateUser() + "]出错！");
		}
		Assert.notNull(member, "未找到用户！");

		if (!o.getMemberPhoneNumber().equals(member.getMemberPhoneNumber())) {
			if (memberInformationDao.exists("memberPhoneNumber", o.getMemberPhoneNumber())) {
				throw new BusException("手机号码已被使用，请更换手机号码");
			}
		}
		member.setMemberPhoneNumber(o.getMemberPhoneNumber());
		memberInformationDao.save(member);
	}

	/**
	 * 用户登录
	 * 
	 * @param memberInformation
	 *            用户信息
	 * @throws BusException
	 */
	@EsbServiceMapping
	public MemberInformation userLogin(MemberInformation memberInformation) throws BusException {

		MemberInformation member = this.memberInformationDao.getObjectByUniqueProperty("memberPhoneNumber",
				memberInformation.getMemberPhoneNumber());
		if (member == null) {
			throw new BusException("999999", "改用户不存在！");
		}
		if (!member.getPassword().equals(PasswordUtils.md5Password(memberInformation.getPassword()))) {
			throw new BusException("999999", "密码错误");
		}

		List<String> roles = memberRoleManager.getRolesByMemberId(member.getMemberId());
		member.setRoleIds(roles);
		member.getPrincipalConfig().put("userId", member.getMemberId());
		return member;

	}

	/**
	 * //获取当前用户公司员工的通讯录
	 * 
	 * @param userId
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping
	public List<MemberInformation> getPhoneNumberlist(
			@ServiceParam(name = "userId", pubProperty = "userId") String userId) throws BusException {
		MemberInformation m = memberInformationDao.getObjectByUniqueProperty("memberId", userId);
		String companyId = m.getCompanyId();
		Collection<Condition> condition = new ArrayList<Condition>();
		condition.add(ConditionUtils.getCondition("companyId", Condition.EQUALS, companyId));
		List<MemberInformation> list = memberInformationDao.commonQuery(condition, null);
		return list;
	}

	/**
	 * //通过名字获取当前用户公司员工的通讯录
	 * 
	 * @param userId
	 * @param memberName
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping
	public List<MemberInformation> getPhoneNumberlistByName(
			@ServiceParam(name = "userId", pubProperty = "userId") String userId,
			@ServiceParam(name = "memberName") String memberName) throws BusException {
		MemberInformation m = memberInformationDao.getObjectByUniqueProperty("memberId", userId);
		String companyId = m.getCompanyId();
		Collection<Condition> condition = new ArrayList<Condition>();
		condition.add(ConditionUtils.getCondition("companyId", Condition.EQUALS, companyId));
		condition.add(ConditionUtils.getCondition("memberName", Condition.LIKE, memberName));
		List<MemberInformation> list = memberInformationDao.commonQuery(condition, null);
		return list;
	}

	/**
	 * 前台 根据当前用户分页企业通讯录查询
	 * 
	 * @return 分页对象
	 */
	// @SuppressWarnings("unchecked")
	@EsbServiceMapping
	public PagerRecords getPager(Pager pager, // 分页条件
			@ConditionCollection(domainClazz = MemberInformation.class) Collection<Condition> conditions, // 查询条件
			@OrderCollection Collection<Order> orders,
			@ServiceParam(name = "userId", pubProperty = "userId") String userId) throws BusException {
		// 根据用户id获取当前用户
		MemberInformation m = memberInformationDao.getObjectByUniqueProperty("memberId", userId);
		// 获取公司id
		String companyId = m.getCompanyId();
		// 添加条件 （根据公司id查询）
		conditions.add(ConditionUtils.getCondition("companyId", Condition.EQUALS, companyId));
		PagerRecords pagerRecords = memberInformationDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}

	/**
	 * 个人中心-个人资料（修改）
	 * 
	 * @param o
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping(pubConditions = { @PubCondition(property = "updateUser", pubProperty = "userId") })
	public MemberInformation updateMemberInformation(MemberInformation o) throws BusException {

		// 根据现有的用户ID，查出该用户的基本信息，进行其他信息的修改
		String memberId = o.getMemberId();
		MemberInformation mi = this.getMemberInformation(memberId);
		// 头像
		mi.setMemberHeadPortrait(o.getMemberHeadPortrait());
		// 昵称
		mi.setMemberNickname(o.getMemberNickname());
		// 真实姓名
		mi.setMemberName(o.getMemberName());
		// 出生日期
		mi.setMemberBirthdate(o.getMemberBirthdate());
		// 介绍
		mi.setMemberDescribe2(o.getMemberDescribe2());
		// 更新时间
		mi.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		// 开始进行更新操作
		MemberInformation reMemberInformation = memberInformationDao.save(mi);
		return reMemberInformation;
	}

	// 根据手机号码获取用户
	@Override
	public MemberInformation getUserByPhone(String phone) {
		MemberInformation mem = memberInformationDao.getObjectByUniqueProperty("memberPhoneNumber", phone);
		return mem;
	}

	@Override
	public List<MemberInformation> getMembersByRole(String role) throws BusException {
		return memberInformationDao.getMembersByRole(role);
	}

	@EsbServiceMapping
	public String getEncryptStringForEnterpriseMall(
			@ServiceParam(name = "userId", pubProperty = "userId") String userId) throws BusException {
		String retString = this.inininSsoUrl+"?";
		MemberInformation noEncypt = memberInformationDao.get(userId);
		String user_id = EncryptUtil.encrypt(noEncypt.getMemberId());
		String user_name = EncryptUtil.encrypt(noEncypt.getMemberPhoneNumber());
		String tel = EncryptUtil.encrypt(noEncypt.getMemberPhoneNumber());
		String name = EncryptUtil.encrypt(noEncypt.getMemberName());
		String ent_address = EncryptUtil.encrypt("");
		String ent_name = EncryptUtil.encrypt(this.companyName);

		// checkcode MD5
		String checkCodeString = EncryptUtil.getMD5Str(user_id + user_name + name + tel + ent_address + ent_name);

		retString = retString + "user_id=" + user_id + "&username=" + user_name + "&name=" + name + "&tel=" + tel
				+ "&ent_address=" + ent_address + "&ent_name=" + ent_name + "&checkcode=" + checkCodeString;
		return retString;
	}
	/**
	 *前台 根据当前用户分页查询
	 * @return 分页对象
	 */

	 /**
	* 获取已完成订单的totalCount    陈烨
	* @param conditions
	* @return
	* @throws BusException
	*/
    @EsbServiceMapping
	public List<Record> getTotalCount(
	   			@ConditionCollection(domainClazz=MemberInformation.class) Collection<Condition> conditions,
	   			@ServiceParam(name = "userId", pubProperty = "userId") String userId)  throws BusException{
	   	List<Record> recordList=new ArrayList<Record>();
	   	MemberInformation m=memberInformationDao.get(userId);
	   	String companyId=m.getCompanyId();
	   	conditions.add(ConditionUtils.getCondition("companyId", Condition.EQUALS, companyId));
	   	List<MemberInformation> List = this.getMemberInformations(conditions, null);
	   	Record record = new Record();
	   	record.put("totalCount", List.size());
	   	recordList.add(record);
	   	return recordList;
	}   	 
    /**
     * 前台个人中心    安全中心，chenye
     * @param userId  
     * @return
     * @throws BusException
     */
	@EsbServiceMapping
	public MemberInformation getMember(@ServiceParam(name = "userId", pubProperty = "userId") String userId) throws BusException {
		MemberInformation member = memberInformationDao.get(userId);		
		return member;
	} 
}
