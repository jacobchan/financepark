/**
 * 代码声明
 */
package com.common.NewsManager.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.NewsManager.dao.NmIssuenewsDorCDao;
import com.common.NewsManager.entity.NmIssuenews;
import com.common.NewsManager.entity.NmIssuenewsDorC;
import com.common.NewsManager.service.NmIssuenewsDorCManager;
import com.common.NewsManager.service.NmIssuenewsManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.StringUtils;

@Service("nmIssuenewsDorCManager")
@Transactional
public class NmIssuenewsDorCManagerImpl extends BaseManagerImpl implements NmIssuenewsDorCManager{
	@Autowired
	private NmIssuenewsDorCDao nmIssuenewsDorCDao;
	@Autowired
	private NmIssuenewsManager nmIssuenewsManager;
	
	 /**
     * 保存对象
     */
    @EsbServiceMapping
    public NmIssuenewsDorC saveNmIssuenewsDorC(NmIssuenewsDorC o) throws BusException{
    	String dOrCId = o.getId();
    	boolean isUpdate = StringUtils.isNotEmpty(dOrCId);
    	if(isUpdate){//修改
    		return nmIssuenewsDorCDao.save(o);
    	}else{//新增
    		String newsId = o.getIssueNewsId() ;//得到新闻id
    		NmIssuenews news = nmIssuenewsManager.getNmIssuenews(newsId) ;//得到新闻
    		String status = o.getStatus() ;
    		if("00".equals(status)){//00表示顶
    			String dingCount = news.getDingCount() ;
        		int ding = Integer.parseInt(dingCount) ;
        		ding ++ ;//顶的数量加1
        		news.setDingCount(String.valueOf(ding));
        		o.setCurrentDingCount(news.getDingCount());
    		}
    		if("01".equals(status)){//01表示踩
    			String caiCount = news.getCaiCount() ;
        		int cai = Integer.parseInt(caiCount) ;
        		cai ++ ;//踩的数量加1
        		news.setCaiCount(String.valueOf(cai));
        		o.setCurrentCaiCount(news.getCaiCount());
    		}
    		nmIssuenewsManager.saveNmIssuenews(news) ;//保存新闻
    		return nmIssuenewsDorCDao.save(o);
    	}
    }
    
  /**
   * 根据ip地址和新闻id得到顶或踩的对象
   * @param userIp ip地址
   * @param issueNewsId 新闻id
   * @return
   */
	@EsbServiceMapping
	public NmIssuenewsDorC getNmIssuenewsDorCByNewsIdAndIp(@ServiceParam(name="userIp") String userIp,
			@ServiceParam(name="issueNewsId")String issueNewsId) throws BusException{
		Collection<Condition> conditions =  new ArrayList<Condition>();
		conditions.add(ConditionUtils.getCondition("userIp", Condition.EQUALS,userIp));
		conditions.add(ConditionUtils.getCondition("issueNewsId", Condition.EQUALS,issueNewsId));
		List<NmIssuenewsDorC> dOrC = this.getNmIssuenewsDorC(conditions, null);
		if(dOrC.size()>0){
			return dOrC.get(0) ;
		}else{
			return null ;
		}
	}
	
	 /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<NmIssuenewsDorC> getNmIssuenewsDorC(
    	@ConditionCollection(domainClazz=NmIssuenewsDorC.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return nmIssuenewsDorCDao.commonQuery(conditions, orders);
    }
	
}
