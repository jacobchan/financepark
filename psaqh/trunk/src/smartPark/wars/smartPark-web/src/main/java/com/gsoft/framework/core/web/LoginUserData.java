package com.gsoft.framework.core.web;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.MemberManager.dao.MemberInformationDao;
import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.MessageCenter.service.McMsgdatasManager;
import com.gsoft.entity.MessageService;
import com.gsoft.entity.TempDemo;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.web.controller.BaseDataController;
import com.gsoft.framework.core.web.view.DataModelAndView;
import com.gsoft.framework.security.DefaultLoginFormToken;
import com.gsoft.framework.security.agt.dao.UserDao;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.security.agt.service.impl.UserPasswordService;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.PasswordUtils;
import com.manage.EnterBusinessManager.service.EnterbusinessmanagerRzManager;

@Controller
@RequestMapping("/web/loginUser")
public class LoginUserData extends BaseDataController {
	@Autowired
	private McMsgdatasManager mcMsgdatasManager;
	@Autowired
	private MemberInformationManager memberInformationManager;
	@Autowired
	private EnterbusinessmanagerRzManager enterbusinessmanagerRzManager;
	@Autowired
	private MemberInformationDao memberInformationDao;
	@Autowired
	private UserDao userDao;
	@Autowired(required=false)
	private UserPasswordService passwordService;
	/*
	 * 获取注册手机验证码
	 */
	@RequestMapping("/registerCaptcha.json")
	public DataModelAndView getMobileCaptcha(@RequestParam("phone") String phone,
			@RequestParam("imageCode") String imageCode,HttpServletRequest request) {
		TempDemo temp = new TempDemo();
		String kaptchaExpected = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(!imageCode.equals(kaptchaExpected)){
			temp.setFlag(false);
			temp.setBuff("验证码不正确");
		}else{
			temp =  mcMsgdatasManager.getMobileCaptcha(phone);
		}
		return new DataModelAndView(temp);
	}
	
	/**
	 * 用户注册
	 * @return
	 */
	@RequestMapping("/registerUser.json")
	public DataModelAndView registerNew(HttpServletRequest request,
			@RequestParam("memberPassword") String passwd,@RequestParam("repasswd") String repasswd,
			@RequestParam("memberPhoneNumber") String phone,@RequestParam("captcha")String captcha){
		TempDemo temp = memberInformationManager.saveReister(passwd, repasswd, phone,captcha);
		if(!temp.isFlag()){
			return new DataModelAndView(temp.getBuff());
		}
		// 自动登录
		try {
			DefaultLoginFormToken token = new DefaultLoginFormToken(phone,
					passwd, false, request.getHeader("host"));
			token.setLoginType("memberCenter");
			org.apache.shiro.SecurityUtils.getSubject().login(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new DataModelAndView("000000");
	}
	/**
	 * 第三方单点登录
	 * @return
	 */
	@RequestMapping("/singleLogin.json")
	public DataModelAndView singleLogin(HttpServletRequest request,
			@RequestParam("phone") String phone,@RequestParam("password") String password,
			@RequestParam("parkName") String parkName,@RequestParam("companyName")String companyName){
		TempDemo temp = enterbusinessmanagerRzManager.singleLogin(phone, password, parkName,companyName);
		if(!temp.isFlag()){
			return new DataModelAndView(temp.getBuff());
		}
		// 自动登录
		try {
			DefaultLoginFormToken token = new DefaultLoginFormToken(phone,
					password, false, request.getHeader("host"));
			token.setLoginType("memberCenter");
			org.apache.shiro.SecurityUtils.getSubject().login(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new DataModelAndView("000000");
	}
	
	/**
	 * 通过手机找回密码,输入手机号和验证码
	 */
	@RequestMapping("/findpsw.json")
	public DataModelAndView findpsw(HttpServletRequest request,
			@RequestParam("phone")String phone,
			@RequestParam("verificationCodePhone")String code){
		String kaptchaExpected = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(!code.equals(kaptchaExpected)){
			return new DataModelAndView("验证码不正确");
		}
		//根据手机号码获取用户
		MemberInformation mb = memberInformationManager.getUserByPhone(phone);
		if(mb == null){
			return new DataModelAndView("手机号不存在");
		}
		request.getSession().setAttribute("phone", phone);
		
		return new DataModelAndView("000000");
	}
	/**
	 * 通过手机找回密码,输入手机动态验证码
	 */
	@RequestMapping("/findPwdCheckPhone.json")
	public DataModelAndView findPwdCheckPhone(HttpServletRequest request,
			@RequestParam("phoneCode")String phoneCode){
		String phone = (String) request.getSession().getAttribute("phone");
		
//		//根据手机号码获取用户
		MemberInformation mb = memberInformationManager.getUserByPhone(phone);
		if(mb == null){
			return new DataModelAndView("手机号不存在");
		}else{
			TempDemo temp = mcMsgdatasManager.checkPhoneCode(phone, phoneCode);
			if(!temp.isFlag()){
				return new DataModelAndView(temp.getBuff());
			}
			request.getSession().setAttribute("memberName", mb.getMemberName());
			request.getSession().setAttribute("memberId", mb.getMemberId());
		}
		return new DataModelAndView("000000");
	}
	//重新设置密码
	@RequestMapping("/findpswReset.json")
	public DataModelAndView findPwdReset(HttpServletRequest request,
			@RequestParam("memberId") String memberId,
			@RequestParam("passwd") String passwd,
			@RequestParam("repasswd") String repasswd) {

		if(com.gsoft.framework.util.StringUtils.isEmpty(passwd)){
			return new DataModelAndView("密码不能为空！");
		}
		if (!passwd.equals(repasswd)) {
			return new DataModelAndView("两次输入的密码不一致");
		}
		MemberInformation mb = memberInformationManager.getMemberInformation(memberId);
		if(mb == null){
			return new DataModelAndView("用户不存在！");
		}else{
			mb.setMemberPassword(PasswordUtils.md5Password(passwd));
			mb.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
			memberInformationManager.saveMemberInformation(mb);
		}
		return new DataModelAndView("000000");
	}
	/*
	 * 找回密码获取手机验证码
	 */
	@RequestMapping("/findPhoneCaptcha.json")
	public DataModelAndView findPhoneCaptcha(HttpServletRequest request) {
		String phone = (String) request.getSession().getAttribute("phone");
		TempDemo temp = mcMsgdatasManager.findPhoneCaptcha(phone);
		return new DataModelAndView(temp);
	}
	//前台个人中心，安全中心，修改手机号码     给新手机号发送短信验证码
	@RequestMapping("/sendnewcaptcha.json")
	public DataModelAndView sendnewcaptcha(@RequestParam("newPhone") String newPhone,
			@RequestParam("oldPhone") String oldPhone,HttpServletRequest request) {
		if(oldPhone.equals(newPhone)){
			return new DataModelAndView("新手机号与原手机号一致");
		}else{
			Random random = new Random(new Date().getTime());
			Long code = Math.abs(random.nextLong() % 999999);
			String captcha = org.apache.commons.lang.StringUtils.leftPad(code.toString(), 6, '0');		
			Map<String,Object> map = new HashMap<String, Object>();
			map.put(MessageService.CODE, captcha);
			Boolean success = mcMsgdatasManager.smsSend("1010", map, null, newPhone);
			if(success){
				//把手机验证码newcaptcha储存在session中，方便下一个方法调用
				request.getSession().setAttribute("newcaptcha_session",captcha);
				//把手机号newPhone储存在session中，方便下一个方法调用
				request.getSession().setAttribute("newPhone_session",newPhone);
				//把手机号验证码生成时间储存在session中，方便下一个方法调用
				request.getSession().setAttribute("newcaptcha_getTime_session",System.currentTimeMillis());
				return new DataModelAndView("000000");
			}else{
				return new DataModelAndView("发送失败");
			}
		}
	}
	//前台个人中心，安全中心，修改手机号码    验证
	@RequestMapping("/changePhone.json")
	public DataModelAndView changePhone(
			@RequestParam("newPhone") String newPhone,
			@RequestParam("newcaptcha") String newcaptcha,
			@RequestParam("memberId") String memberId,
			HttpServletRequest request){
		//获取session中的手机号短信验证码
		String aptcahsession=(String) request.getSession().getAttribute("newcaptcha_session");
		//获取session中的手机号短信验证码生成时间
		Long captcha_getTime = (Long)request.getSession().getAttribute("newcaptcha_getTime_session");
		//获取session中的手机号
		String newphonesession=(String) request.getSession().getAttribute("newPhone_session");
		//获取短信的时间 5分钟有效
		MemberInformation member=null;
		//获取当前登录用户
		member=memberInformationDao.get(memberId);
		if(System.currentTimeMillis()-captcha_getTime > 5*60*1000) {
			return new DataModelAndView("请重新获取手机号短信验证码,验证码有效时间为5分钟");
		}else{
			if(!aptcahsession.equals(newcaptcha)) {
				return new DataModelAndView("短信验证码输入错误");
			}else{
				if(!newphonesession.equals(newPhone)){
					return new DataModelAndView("两次手机号输入不一致");
				}else{
					//保存号码
					member.setMemberPhoneNumber(newPhone);
					//保存对象
					memberInformationDao.save(member);
					if(member.getMemberPhoneNumber().equals(newPhone)){
						return new DataModelAndView("修改成功");
					}
				}
			}
		}
		return new DataModelAndView("发送失败");		
	}
	
	/**
     * 修改登录用户密码
     * @param password
     * @param confirmPassword
     * @param oldPassword
     * @return
     */
	@RequestMapping("/modifyPassword.json")
    public DataModelAndView modifyPassword(
    		@RequestParam("oldPwd") String oldPwd, 
    		@RequestParam("newPwd") String newPwd, 
    		@RequestParam("newPwdConfirm") String newPwdConfirm){
    	if( StringUtils.isBlank(oldPwd) ){
    		throw new BusException("旧密码不能为空！");
    	}
    	if( StringUtils.isBlank(newPwd) ){
    		throw new BusException("新密码不能为空！");
    	}
    	if( !StringUtils.equals(newPwd, newPwdConfirm) ){
    		throw new BusException("请确认密码是否一致");
    	}
    	if( StringUtils.equals(newPwd, oldPwd) ){
    		throw new BusException("新密码与旧密码重复！");
    	}
    	Object object = SecurityUtils.getSubject().getPrincipal();
		if(object instanceof User){
			User user = (User) object;
			//旧密码不符
			if(!PasswordUtils.md5Password(oldPwd).equals(user.getPassword())){
				throw new BusException("请输入正确的旧密码！");
			}
			user.setPassword(PasswordUtils.md5Password(newPwd));
			user = saveUser(user);
			return new DataModelAndView("000000");
		}
		else{
			throw new BusException("用户不存在或会话已失效！");
		}
    }
	public User saveUser(User o)throws BusException{
	     String userId = o.getUserId();
	     boolean isUpdate = StringUtils.isNotEmpty(userId);
	     if (isUpdate) {
	       User user = (User)this.userDao.get(userId);
	       Assert.notNull(user, "user is null!");
	       o.setPassword(o.getPassword());
	     } else {
	       o.setPassword(this.passwordService.hashPassword("123456").toHex());
	     }
	     return (User)this.userDao.save(o);
	}
}
