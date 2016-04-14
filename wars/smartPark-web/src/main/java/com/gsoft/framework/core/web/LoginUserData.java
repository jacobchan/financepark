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

import com.common.MemberManager.service.MemberInformationManager;
import com.common.MessageCenter.service.McMsgdatasManager;
import com.gsoft.entity.MessageService;
import com.gsoft.framework.core.web.controller.BaseDataController;
import com.gsoft.framework.core.web.view.DataModelAndView;
import com.gsoft.framework.esb.annotation.ServiceParam;

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
	public DataModelAndView getMobileCaptcha(@RequestParam("phone")String phone,HttpServletRequest request) {
		Random random = new Random(new Date().getTime());
		Long code = Math.abs(random.nextLong() % 999999);
		String captcha = org.apache.commons.lang.StringUtils.leftPad(code.toString(), 6, '0');
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put(MessageService.CODE, captcha);
		
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
		return new DataModelAndView("000000");
	}
}
