package com.manage.EnterpriseMessageManager.service.impl;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.EnterBusinessManager.dao.EnterbusinessmanagerRzDao;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
import com.manage.EnterpriseMessageManager.entity.LettermanagerLetter;
import com.manage.EnterpriseMessageManager.dao.LettermanagerLetterDao;
import com.manage.EnterpriseMessageManager.service.LettermanagerLetterManager;
@Service("lettermanagerLetterManager")
@Transactional
public class LettermanagerLetterManagerImpl extends BaseManagerImpl implements LettermanagerLetterManager{
	@Autowired
	private LettermanagerLetterDao lettermanagerLetterDao;
	@Autowired
	private EnterbusinessmanagerRzDao enterbusinessmanagerRzDao;
	@Autowired
	private MemberInformationManager memberInformationManager;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<LettermanagerLetter> getLettermanagerLetters() throws BusException{
    	return lettermanagerLetterDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<LettermanagerLetter> getLettermanagerLetters(
    	@ConditionCollection(domainClazz=LettermanagerLetter.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return lettermanagerLetterDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public LettermanagerLetter getLettermanagerLetter(@ServiceParam(name="letterId") String id)  throws BusException{
    	return lettermanagerLetterDao.get(id);
    }
	
	@SuppressWarnings("unchecked")
	@EsbServiceMapping
	public PagerRecords getPagerLettermanagerLetters(Pager pager,//分页条件
			@ConditionCollection(domainClazz=LettermanagerLetter.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = lettermanagerLetterDao.findByPager(pager, conditions, orders);
		List<LettermanagerLetter>letterlist = pagerRecords.getRecords();
		for(LettermanagerLetter letter : letterlist )
		if(StringUtils.isNotEmpty(letter.getCreateUser())){
			String memberId = letter.getCreateUser();
			MemberInformation memberInformation = memberInformationManager.getMemberInformation(memberId);
			letter.setMember(memberInformation);
		}
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "createUser", pubProperty = "userId")})
    public LettermanagerLetter saveLettermanagerLetter(LettermanagerLetter o) throws BusException{
//    	String lettermanagerLetterId = o.getLettermanagerLetterId();
//    	boolean isUpdate = StringUtils.isNotEmpty(lettermanagerLetterId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	EnterbusinessmanagerRz enter = enterbusinessmanagerRzDao.get(o.getLetterEnterpriseId());
    	o.setLetterRecipientId(enter.getRzManager().getMemberId());
    	o.setLetterTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
    	return lettermanagerLetterDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeLettermanagerLetter(@ServiceParam(name="letterId") String id) throws BusException{
    	lettermanagerLetterDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeLettermanagerLetters(@ServiceParam(name="letterId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeLettermanagerLetter(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitLettermanagerLetter(@ServiceParam(name="letterId") String id)  throws BusException{
		return lettermanagerLetterDao.exists(id);
	}
    
    public boolean exsitLettermanagerLetter(String propertyName,Object value) throws BusException{
		return lettermanagerLetterDao.exists(propertyName,value);
	}

}
