/**
 * 
 */
package com.gsoft.framework.core.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.security.AccountPrincipal;
import com.gsoft.framework.security.UserService;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.SecurityUtils;
import com.gsoft.framework.util.StringUtils;
import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EmployeeManager.entity.EnterpriseRole;
import com.manage.EmployeeManager.service.EnterpriseEmployeesManager;
import com.manage.EmployeeManager.service.EnterpriseRoleManager;

/**
 * 会员页面控制器
 * @author zhyi_12
 */

@Controller
@RequestMapping("/member")
public class MemberPageController {
	
	@Autowired
	private UserService userService;//用户服务
	@Autowired
	private MemberInformationManager memberInformationManager;
	@Autowired
	private EnterpriseEmployeesManager enterpriseEmployeesManager;
	@Autowired
	private EnterpriseRoleManager enterpriseRoleManager;
	
	@RequestMapping(value = "/{pageModule}/{pagePath}.html")
	public ModelAndView index(HttpServletRequest request, 
			HttpServletResponse response,
			@PathVariable("pageModule") String pageModule,
			@PathVariable("pagePath") String pagePath){
		return buildModelAndView(request,pageModule,StringUtils.arrayToDelimitedString(new String[]{pageModule,pagePath}, "/"),null);
	}
	
	@RequestMapping(value = "/{pageModule}/{pageFile}/{pagePath}.html")
	public ModelAndView index(HttpServletRequest request, 
			HttpServletResponse response,
			@PathVariable("pageModule") String pageModule,
			@PathVariable("pageFile") String pageFile,
			@PathVariable("pagePath") String pagePath){
		return buildModelAndView(request,pageModule,StringUtils.arrayToDelimitedString(new String[]{pageModule,pageFile,pagePath}, "/"),null);
	}
	
/*	//@PathVariable("subfolder") String subfolder
	@RequestMapping(value = "/{pageModule}/{pagePath}/{loginName}.html")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("pageModule") String pageModule,
			@PathVariable("pagePath") String pagePath,
			@PathVariable("loginName") String loginName){
		
		return buildModelAndView(request,pageModule,StringUtils.arrayToDelimitedString(new String[]{pageModule,pagePath}, "/"),loginName);
	}
	
	@RequestMapping(value = "/{pageModule}/{pagePath}/{subPath}/{loginName}.html")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("pageModule") String pageModule,
			@PathVariable("pagePath") String pagePath,
			@PathVariable("subPath") String subPath,
			@PathVariable("loginName") String loginName){
		
		return buildModelAndView(request,pageModule,StringUtils.arrayToDelimitedString(new String[]{pageModule,pagePath,subPath}, "/"),loginName);
	}
*/	
	private ModelAndView buildModelAndView(HttpServletRequest request,String pageModule,String pagePath,String loginName){
		AccountPrincipal account = SecurityUtils.getAccount();
/*		if(account==null||!loginName.equals(account.getLoginName())){
			//输出权限错误异常
			throw new BusException("010101","权限不足!");
		}*/
		ModelAndView model = new ModelAndView();
		model.setViewName(/*pageModule+"/"+*/pagePath);
		model.addObject("user", account);
		Collection<Condition> condition =  new ArrayList<Condition>();
		condition.add(ConditionUtils.getCondition("member.memberName", Condition.EQUALS,account.getLoginName()));
		List<EnterpriseEmployees> employes =  enterpriseEmployeesManager.getEnterpriseEmployeess(condition, null);
		if(employes.size()>0){
			EnterpriseEmployees emp = employes.get(0);
			Collection<Condition> conditions =  new ArrayList<Condition>();
			conditions.add(ConditionUtils.getCondition("employees.employeesId", Condition.EQUALS,emp.getEmployeesId()));
			List<EnterpriseRole> role=  enterpriseRoleManager.getEnterpriseRoles(conditions, null);
			if(role.size()>0){
				model.addObject("member", role.get(0).getRole());
			}
		}
		model.addObject("pagePath", pagePath);
		return model;
	}

}
