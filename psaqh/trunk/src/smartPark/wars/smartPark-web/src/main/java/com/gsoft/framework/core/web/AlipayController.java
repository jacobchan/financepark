/**
 * 
 */
package com.gsoft.framework.core.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.common.alipay.service.AliPayManager;

/**
 * 支付宝支付
 * @author Aaron Tan
 *
 */
@Controller
public class AlipayController {
	@Autowired
	private AliPayManager aliPayManager;
	
	/**
	 * 登录页面
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/alipayapi.html")
	public ModelAndView alipayapi(@RequestParam("userorderCode") String userorderCode){
		//获取订单编号
		String submitHtml = aliPayManager.getAlipayapiHtml(userorderCode);
		return new ModelAndView("alipayapi","submitHtml",submitHtml);
	}
	
	
}
