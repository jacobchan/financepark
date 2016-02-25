/**
 * 代码声明
 */
package com.common.NewsManager.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.NewsManager.dao.NmIssuetempalateDao;
import com.common.NewsManager.entity.NmIssuetempalate;
import com.common.NewsManager.service.NmIssuetempalateManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.security.AccountPrincipal;
import com.gsoft.framework.util.SecurityUtils;
import com.gsoft.framework.util.StringUtils;

@Service("nmIssuetempalateManager")
@Transactional
public class NmIssuetempalateManagerImpl extends BaseManagerImpl implements
		NmIssuetempalateManager {
	@Autowired
	private NmIssuetempalateDao nmIssuetempalateDao;

	/**
	 * 查询列表
	 */
	// @EsbServiceMapping
	public List<NmIssuetempalate> getNmIssuetempalates() throws BusException {
		return nmIssuetempalateDao.getAll();
	}

	/**
	 * 条件查询列表
	 */
	@EsbServiceMapping
	public List<NmIssuetempalate> getNmIssuetempalates(
			@ConditionCollection(domainClazz = NmIssuetempalate.class) Collection<Condition> conditions,
			@OrderCollection Collection<Order> orders) throws BusException {
		return nmIssuetempalateDao.commonQuery(conditions, orders);
	}

	/**
	 * 根据主键查询
	 */
	@EsbServiceMapping
	public NmIssuetempalate getNmIssuetempalate(
			@ServiceParam(name = "issueTempalateId") String id)
			throws BusException {
		return nmIssuetempalateDao.get(id);
	}

	@EsbServiceMapping
	public PagerRecords getPagerNmIssuetempalates(
			Pager pager,// 分页条件
			@ConditionCollection(domainClazz = NmIssuetempalate.class) Collection<Condition> conditions,// 查询条件
			@OrderCollection Collection<Order> orders) throws BusException {
		AccountPrincipal account = SecurityUtils.getAccount();
		System.out.println("-------------:"
				+ (account instanceof AccountPrincipal));
		PagerRecords pagerRecords = nmIssuetempalateDao.findByPager(pager,
				conditions, orders);
		return pagerRecords;
	}

	/**
	 * 保存对象
	 */
	@EsbServiceMapping
	public NmIssuetempalate saveNmIssuetempalate(NmIssuetempalate o)
			throws BusException {
		// String nmIssuetempalateId = o.getNmIssuetempalateId();
		// boolean isUpdate = StringUtils.isNotEmpty(nmIssuetempalateId);
		// if(isUpdate){//修改
		//
		// }else{//新增
		//
		// }
		return nmIssuetempalateDao.save(o);
	}

	/**
	 * 删除对象
	 */
	@EsbServiceMapping
	public void removeNmIssuetempalate(
			@ServiceParam(name = "issueTempalateId") String id)
			throws BusException {
		nmIssuetempalateDao.remove(id);
	}

	/**
	 * 根据主键集合删除对象
	 * 
	 * @param ids
	 */
	public void removeNmIssuetempalates(
			@ServiceParam(name = "issueTempalateId") String[] ids)
			throws BusException {
		for (String id : ids) {
			removeNmIssuetempalate(id);
		}
	}

	@EsbServiceMapping
	public boolean exsitNmIssuetempalate(
			@ServiceParam(name = "issueTempalateId") String id)
			throws BusException {
		return nmIssuetempalateDao.exists(id);
	}

	public boolean exsitNmIssuetempalate(String propertyName, Object value)
			throws BusException {
		return nmIssuetempalateDao.exists(propertyName, value);
	}

	@Override
	public String genPolicyContent(NmIssuetempalate nmIssuetempalate,
			String... params) throws BusException {
		String tempalateContent = nmIssuetempalate.getIssueTempalateContent();

		return replaceChar(tempalateContent, '#', params);
	}
	
	@EsbServiceMapping
	public String genPolicyContent(@ServiceParam(name="nmIssuetempalateId") String nmIssuetempalateId,
			@ServiceParam(name="paramStr") String paramStr) throws BusException {
		String[] paramArry = null;
		NmIssuetempalate nmIssuetempalate = nmIssuetempalateDao.get(nmIssuetempalateId);
		if(StringUtils.isNotEmpty(paramStr)){
			paramArry = paramStr.split(",|，");
		}else{
			paramArry = new String[]{};
		}
		return genPolicyContent(nmIssuetempalate,paramArry);
	}

	public static String replaceChar(String str, char c, String... params) {
		if (str != null && !"".equals(str)) {
			String[] tempArray = (str+"_").split("" + c + "");
			int countC = tempArray.length - 1;
			if (countC == params.length) {
				Pattern pattern = Pattern.compile("" + c + "");
				Matcher matcher = pattern.matcher(str);
				int i = 0;
				boolean result = matcher.find();
				StringBuffer sb = new StringBuffer();
				while (result) {
					matcher.appendReplacement(sb, params[i]);
					i++;
					result = matcher.find();
				}
				matcher.appendTail(sb);
				return sb.toString();
			} else {
		//		throw new BusException("参数个数不一致");
			}
		}
		return null;
	}

}
