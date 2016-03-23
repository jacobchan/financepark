package com.gsoft.framework.core.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/enterprise")
public class EnterpriseInfoController {
	@RequestMapping(value = "/info.html")
	public ModelAndView enterpriseInfo(HttpServletRequest request,
			HttpServletResponse response){
		return new ModelAndView("enterpriseCenter/enterpriseInfo");
	}
}