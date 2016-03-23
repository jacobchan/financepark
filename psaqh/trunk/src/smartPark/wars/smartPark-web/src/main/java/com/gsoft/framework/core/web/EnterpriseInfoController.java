package com.gsoft.framework.core.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/enterprise")
public class EnterpriseInfoController {
	/**
	 * 企业信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/info.html")
	public ModelAndView enterpriseInfo(HttpServletRequest request,
			HttpServletResponse response){
		return new ModelAndView("enterpriseCenter/enterpriseInfo");
	}
	
	/**
	 * 企业融资
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/financing.html")
	public ModelAndView enterpriseFinancing(HttpServletRequest request,
			HttpServletResponse response){
		return new ModelAndView("enterpriseCenter/enterpriseFinancing");
	}
	
	/**
	 * 专利，知识产权
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/knowledge.html")
	public ModelAndView enterpriseKnowledge(HttpServletRequest request,
			HttpServletResponse response){
		return new ModelAndView("enterpriseCenter/enterpriseKnowledge");
	}
	
	/**
	 * 法定代表人
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/legal.html")
	public ModelAndView enterpriseLegal(HttpServletRequest request,
			HttpServletResponse response){
		return new ModelAndView("enterpriseCenter/enterpriseLegal");
	}
	
	/**
	 * 媒体报道
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/media.html")
	public ModelAndView enterpriseMedia(HttpServletRequest request,
			HttpServletResponse response){
		return new ModelAndView("enterpriseCenter/enterpriseMedia");
	}
}