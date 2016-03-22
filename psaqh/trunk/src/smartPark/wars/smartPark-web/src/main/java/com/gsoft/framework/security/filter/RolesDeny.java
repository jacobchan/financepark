package com.gsoft.framework.security.filter;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import com.common.MemberManager.entity.MemberInformation;

public class RolesDeny extends AuthorizationFilter {

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
        List<String> roleIds = mem.roleIds();
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
