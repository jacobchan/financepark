package com.gsoft.framework.core.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.MessageCenter.service.McMsgdatasManager;
import com.gsoft.entity.MessageService;
import com.gsoft.framework.core.web.controller.BaseDataController;
import com.gsoft.framework.core.web.view.DataModelAndView;
import com.gsoft.framework.security.DefaultLoginFormToken;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.PasswordUtils;

@Controller
@RequestMapping("/web/loginUser")
public class LoginUserData extends BaseDataController {
	@Autowired
	private McMsgdatasManager mcMsgdatasManager;
	@Autowired
	private MemberInformationManager memberInformationManager;
	/*
	 * 获取注册手机验证码
	 */
	@RequestMapping("/registerCaptcha.json")
	public DataModelAndView getMobileCaptcha(@RequestParam("phone") String phone,
			@RequestParam("imageCode") String imageCode,HttpServletRequest request) {
		String kaptchaExpected = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(!imageCode.equals(kaptchaExpected)){
			return new DataModelAndView("验证码不正确");
		}
		Random random = new Random(new Date().getTime());
		Long code = Math.abs(random.nextLong() % 999999);
		String captcha = org.apache.commons.lang.StringUtils.leftPad(code.toString(), 6, '0');
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put(MessageService.CODE, captcha);
		
		//根据手机号码获取用户
		MemberInformation mb = memberInformationManager.getUserByPhone(phone);
		if(mb != null){
			return new DataModelAndView("该用户已存在");
		}
				
		Boolean success = mcMsgdatasManager.smsSend("1010", map, null, phone);
		if(success){
			request.getSession().setAttribute("phone_captcha",
					phone + "_" + captcha);
			request.getSession().setAttribute("captcha_getTime_",
					System.currentTimeMillis());
		}else{
			return new DataModelAndView("发送失败");
		}
		return new DataModelAndView("000000");
	}
	/*
	 * APP获取注册手机验证码
	 */
	@RequestMapping("/appRegisterCaptcha.json")
	public DataModelAndView getAppMobileCaptcha(@RequestParam("phone") String phone,HttpServletRequest request) {
		Random random = new Random(new Date().getTime());
		Long code = Math.abs(random.nextLong() % 999999);
		String captcha = org.apache.commons.lang.StringUtils.leftPad(code.toString(), 6, '0');
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put(MessageService.CODE, captcha);
		
		//根据手机号码获取用户
		MemberInformation mb = memberInformationManager.getUserByPhone(phone);
		if(mb != null){
			return new DataModelAndView("该用户已存在");
		}
		
		Boolean success = mcMsgdatasManager.smsSend("1010", map, null, phone);
		if(success){
			return new DataModelAndView("000000");
		}else{
			return new DataModelAndView("发送失败");
		}
	}
	
	/**
	 * 用户注册
	 * @return
	 */
	@RequestMapping("/registerUser.json")
	public DataModelAndView registerNew(HttpServletRequest request,
			@RequestParam("memberPassword") String passwd,@RequestParam("repasswd") String repasswd,
			@RequestParam("memberPhoneNumber") String phone,@RequestParam("captcha")String captcha){
		String sessionCaptcha = (String) request.getSession().getAttribute("phone_captcha");
		if(StringUtils.isEmpty(sessionCaptcha)){ 
			return new DataModelAndView("请先获取短信验证码");
		}
		Long captcha_getTime = (Long)request.getSession().getAttribute("captcha_getTime_");//获取短信的时间 5分钟有效
		if(System.currentTimeMillis()-captcha_getTime > 5*60*1000) {
			return new DataModelAndView("请先获取短信验证码");
		}
		if(!StringUtils.equals(sessionCaptcha,phone+"_"+captcha)){
			return new DataModelAndView("手机验证码不正确");
		}
		memberInformationManager.saveReister(passwd, repasswd, phone);
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
		String sessionCaptcha = (String) request.getSession().getAttribute("phone_captcha");
		if(StringUtils.isEmpty(sessionCaptcha)){ 
			return new DataModelAndView("请先获取短信验证码");
		}
		Long captcha_getTime = (Long)request.getSession().getAttribute("captcha_getTime_");//获取短信的时间 5分钟有效
		if(System.currentTimeMillis()-captcha_getTime > 5*60*1000) {
			return new DataModelAndView("请先获取短信验证码");
		}
		String phone = (String) request.getSession().getAttribute("phone");
		if(!StringUtils.equals(sessionCaptcha,phone+"_"+phoneCode)){
			return new DataModelAndView("手机验证码不正确");
		}
		//根据手机号码获取用户
		MemberInformation mb = memberInformationManager.getUserByPhone(phone);
		if(mb == null){
			return new DataModelAndView("手机号不存在");
		}else{
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
		Random random = new Random(new Date().getTime());
		Long code = Math.abs(random.nextLong() % 999999);
		String captcha = org.apache.commons.lang.StringUtils.leftPad(code.toString(), 6, '0');
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put(MessageService.CODE, captcha);
		String phone = (String) request.getSession().getAttribute("phone");
		Boolean success = mcMsgdatasManager.smsSend("1011", map, null, phone);
		if(success){
			request.getSession().setAttribute("phone_captcha",
					phone + "_" + captcha);
			request.getSession().setAttribute("captcha_getTime_",
					System.currentTimeMillis());
		}else{
			return new DataModelAndView("发送失败");
		}
		return new DataModelAndView("000000");
	}
	/*
	 * APP找回密码获取手机验证码
	 */
	@RequestMapping("/appFindPhoneCaptcha.json")
	public DataModelAndView appFindPhoneCaptcha(@RequestParam("phone") String phone,HttpServletRequest request) {
		Random random = new Random(new Date().getTime());
		Long code = Math.abs(random.nextLong() % 999999);
		String captcha = org.apache.commons.lang.StringUtils.leftPad(code.toString(), 6, '0');
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put(MessageService.CODE, captcha);
		Boolean success = mcMsgdatasManager.smsSend("1011", map, null, phone);
		if(success){
			return new DataModelAndView("000000");
		}else{
			return new DataModelAndView("发送失败");
		}
	}
}
