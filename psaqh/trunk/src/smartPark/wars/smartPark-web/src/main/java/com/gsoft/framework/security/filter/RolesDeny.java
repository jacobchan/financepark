package com.gsoft.framework.security.filter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberRoleManager;
import com.gsoft.framework.util.StringUtils;
import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EmployeeManager.entity.EnterpriseRole;
import com.manage.EmployeeManager.service.EnterpriseEmployeesManager;
import com.manage.EmployeeManager.service.EnterpriseRoleManager;
import com.manage.EnterBusinessManager.service.EnterbusinessmanagerRzManager;

public class RolesDeny extends AuthorizationFilter {
	@Autowired
	private EnterbusinessmanagerRzManager enterbusinessmanagerRzManager;
	@Autowired
	private MemberRoleManager memberRoleManager;
	@Autowired
	private EnterpriseEmployeesManager enterpriseEmployeesManager;
	@Autowired
	private EnterpriseRoleManager enterpriseRoleManager; 
	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        String[] rolesArray = (String[]) mappedValue;

        if (rolesArray == null || rolesArray.length == 0) {
            //no roles specified, so nothing to check - deny access.
            return false;
        }

        List<String> roles = CollectionUtils.asList(rolesArray);
        MemberInformation mem = (MemberInformation) subject.getPrincipal();
        List<String> roleIdList = new ArrayList<String>();
	      List<String> memRoleList = memberRoleManager.getRolesByMemberId(mem.getMemberId());
	      for(String roleId:memRoleList){
	    	  roleIdList.add(roleId);
	      }
        
        if(StringUtils.isEmpty(mem.getCompanyId())){
	      }else{
	    	  EnterpriseEmployees ems = enterpriseEmployeesManager.getEnterpriseEmployeesByMember(mem);
	    	  List<EnterpriseRole> enRoleList = enterpriseRoleManager.getEnterpriseRoleByEmployees(ems.getEmployeesId());
	    	  for(EnterpriseRole er:enRoleList){
	    		  roleIdList.add(er.getRole().getRoleId());
	    	  }
	      }
	    mem.setRoleIds(roleIdList);
        List<String> roleIds = roleIdList;
        for(String str:roleIds){
        	for(String role:roles){
        		if(str.equals(role)){
        			return true;
        		}
        	}
        }
        return false;
	}
}
