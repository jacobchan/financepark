/**
 * 代码声明
 */
package com.distribution.contacts.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.distribution.contacts.dao.RecommendMemberDao;
import com.distribution.contacts.entity.RecommendMember;
import com.distribution.contacts.service.RecommendMemberManager;
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
import com.gsoft.framework.esb.annotation.PubCondition;
import com.gsoft.framework.esb.annotation.ServiceParam;

@Service("recommendMemberManager")
@Transactional
public class RecommendMemberManagerImpl extends BaseManagerImpl implements RecommendMemberManager{
	@Autowired
	private RecommendMemberDao recommendMemberDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<RecommendMember> getRecommendMembers() throws BusException{
    	return recommendMemberDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<RecommendMember> getRecommendMembers(
    	@ConditionCollection(domainClazz=RecommendMember.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return recommendMemberDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public RecommendMember getRecommendMember(@ServiceParam(name="recId") String id)  throws BusException{
    	return recommendMemberDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerRecommendMembers(Pager pager,//分页条件
			@ConditionCollection(domainClazz=RecommendMember.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = recommendMemberDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "memberId", pubProperty = "userId")})
    public RecommendMember saveRecommendMember(RecommendMember o) throws BusException{
    	//生成推荐码10位数推荐码
		int CODE_NUM = 10;
		char[] charSequence = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();  
		StringBuilder sRand = new StringBuilder(CODE_NUM);   
		Random random = new Random();
        for (int i = 0; i < CODE_NUM; i++) {    
            // 取得一个随机字符    
            int index = random.nextInt(charSequence.length);  
            String tmp = String.valueOf(charSequence[index]);  
            sRand.append(tmp);  
        }
        o.setRecCode(sRand.toString());
    	return recommendMemberDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeRecommendMember(@ServiceParam(name="recId") String id) throws BusException{
    	recommendMemberDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeRecommendMembers(@ServiceParam(name="recId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeRecommendMember(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitRecommendMember(@ServiceParam(name="recId") String id)  throws BusException{
		return recommendMemberDao.exists(id);
	}
    
    public boolean exsitRecommendMember(String propertyName,Object value) throws BusException{
		return recommendMemberDao.exists(propertyName,value);
	}

}
