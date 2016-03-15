/**
 * 代码声明
 */
package com.common.MemberAdrManager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MemberAdrManager.dao.MemberadrAddressDao;
import com.common.MemberAdrManager.entity.MemberadrAddress;
import com.common.MemberAdrManager.service.MemberadrAddressManager;
import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;

@Service("memberadrAddressManager")
@Transactional
public class MemberadrAddressManagerImpl extends BaseManagerImpl implements MemberadrAddressManager{
	@Autowired
	private MemberadrAddressDao memberadrAddressDao;
	@Autowired
	private MemberInformationManager memberInformationManager;
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<MemberadrAddress> getMemberadrAddresss() throws BusException{
    	return memberadrAddressDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<MemberadrAddress> getMemberadrAddresss(
    	@ConditionCollection(domainClazz=MemberadrAddress.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return memberadrAddressDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public MemberadrAddress getMemberadrAddress(@ServiceParam(name="addressId") String id)  throws BusException{
    	return memberadrAddressDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerMemberadrAddresss(Pager pager,//分页条件
			@ConditionCollection(domainClazz=MemberadrAddress.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = memberadrAddressDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
	@EsbServiceMapping(pubConditions={@PubCondition(property="memberId.memberId",pubProperty="userId")})
    public MemberadrAddress saveMemberadrAddress(MemberadrAddress o) throws BusException{
    	String memberadrAddressId = o.getAddressId();
    	boolean isUpdate = StringUtils.isNotEmpty(memberadrAddressId);
    	
		List<MemberadrAddress> memberadrAddresss=memberadrAddressDao.getList(new String[]{"memberId.memberId","addressStatus"},new String[]{ o.getMemberId().getMemberId(),"0"});
		if(o.getAddressStatus().equals("0")){
    		for(MemberadrAddress ma:memberadrAddresss){
    			ma.setAddressStatus("1");//设置所有状态为非默认状态
    			memberadrAddressDao.save(ma);
    		}
		}
    	if(isUpdate){//修改
    		MemberadrAddress ma=memberadrAddressDao.get(memberadrAddressId);
    		ma.setAddressStatus(o.getAddressStatus());
    		o=ma;
    	}else{//新增
    		
    	}
    	return memberadrAddressDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeMemberadrAddress(@ServiceParam(name="addressId") String id) throws BusException{
    	memberadrAddressDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeMemberadrAddresss(@ServiceParam(name="addressId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeMemberadrAddress(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitMemberadrAddress(@ServiceParam(name="addressId") String id)  throws BusException{
		return memberadrAddressDao.exists(id);
	}
    
    public boolean exsitMemberadrAddress(String propertyName,Object value) throws BusException{
		return memberadrAddressDao.exists(propertyName,value);
	}
    
	/**
     * 根据用户名获取地址信息
     * @param memberName 用户名
     */
    @EsbServiceMapping
	public MemberadrAddress getAddressByname(@ServiceParam(name="memberName") String memberName)
			throws BusException {
    	MemberadrAddress add = null;
    	if(memberName!=null){
    		Collection<Condition> condition =  new ArrayList<Condition>();
    		condition.add(ConditionUtils.getCondition("memberId.memberName", Condition.EQUALS,memberName));
    		condition.add(ConditionUtils.getCondition("addressStatus", Condition.EQUALS,"0"));
    		List<MemberadrAddress> listMem = memberadrAddressDao.commonQuery(condition, null);
    		if(listMem.size()>0){
    			add = listMem.get(0);
    		}
    	}
		return add;
	}
    /**
     * 根据当前用户查询列表
     */
    @EsbServiceMapping
	public List<MemberadrAddress> getMemberadrAddresssByUser(@ServiceParam(name="userId", pubProperty = "userId") String userId)
			throws BusException {
		// TODO Auto-generated method stub
       	//先模拟一个登陆用户，之后会修改
    	MemberInformation member=memberInformationManager.getMemberInformation(userId);
    	List<MemberadrAddress> list=memberadrAddressDao.getList("memberId.memberId", member.getMemberId());
		return list;
	}
    
    /**
     * 根据当前登录用户查询列表
     * @param o
     * @return
     * @throws BusException
     */
    @EsbServiceMapping(pubConditions={@PubCondition(property="memberId.memberId",pubProperty="userId")})
	public List<MemberadrAddress> getMemAddforpage(MemberadrAddress o)
			throws BusException {
    	List<MemberadrAddress> list = null;
		String id = o.getMemberId().getMemberId();
		if(id!=null){
			 list=memberadrAddressDao.getList("memberId.memberId", id);
		}
			return list;	
		}
    
}
