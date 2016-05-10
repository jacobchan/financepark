package com.common.NewsManager.service;

import java.util.Collection;
import java.util.List;

import com.common.NewsManager.entity.NmIssuenewsDorC;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.service.BaseManager;

public interface NmIssuenewsDorCManager extends BaseManager{
	
	 /**
     * 保存对象
     */
	 public NmIssuenewsDorC saveNmIssuenewsDorC(NmIssuenewsDorC o) throws BusException ;
	    	
	  /**
	   * 根据ip地址和新闻id得到顶或踩的对象
	   * @param userIp ip地址
	   * @param issueNewsId 新闻id
	   * @return
	   */
		public NmIssuenewsDorC getNmIssuenewsDorCByNewsIdAndIp(String userIp,
				String issueNewsId) throws BusException;
		
		 /**
	     * 条件查询列表
	     */
	    public List<NmIssuenewsDorC> getNmIssuenewsDorC(Collection<Condition> conditions,
	    		Collection<Order> orders) throws BusException;

}
