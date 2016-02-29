package com.gsoft.framework.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/memberCenter")
public class MemberCenterController {
	
	
	@RequestMapping("/memberInformation.html")
	public ModelAndView ctrwin(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("memberCenter/memberInformation");
	}
}