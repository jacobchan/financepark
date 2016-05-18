/**
 * 代码声明
 */
package com.distribution.income.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.BuildingBaseManager.entity.BbmRoom;
import com.common.BuildingBaseManager.service.BbmRoomManager;
import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.distribution.income.dao.SalesRecDao;
import com.distribution.income.entity.SalesRec;
import com.distribution.income.entity.SettleRec;
import com.distribution.income.service.SalesRecManager;
import com.distribution.income.service.SettleRecManager;
import com.distribution.rule.entity.BuildingRate;
import com.distribution.rule.entity.DisRateConfig;
import com.distribution.rule.service.BuildingRateManager;
import com.distribution.rule.service.DisRateConfigManager;
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
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.StringUtils;


@Service("salesRecManager")
@Transactional
public class SalesRecManagerImpl extends BaseManagerImpl implements SalesRecManager{
	@Autowired
	private SalesRecDao salesRecDao;
	@Autowired
	private MemberInformationManager memberInformationManager;
	@Autowired
	private DisRateConfigManager disRateConfigManager;
	@Autowired
	private BuildingRateManager buildingRateManager;
	@Autowired
	private BbmRoomManager bbmRoomManager;
	@Autowired
	private SettleRecManager settleRecManager;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<SalesRec> getSalesRecs() throws BusException{
    	return salesRecDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<SalesRec> getSalesRecs(
    	@ConditionCollection(domainClazz=SalesRec.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return salesRecDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public SalesRec getSalesRec(@ServiceParam(name="saleRecId") String id)  throws BusException{

    	return salesRecDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerSalesRecs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=SalesRec.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = salesRecDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public SalesRec saveSalesRec(SalesRec o,@ServiceParam(name="memPhone") String memPhone) throws BusException{
    	
    	String salesRecId = o.getSaleRecId();
    	boolean isUpdate = StringUtils.isNotEmpty(salesRecId);
    	if(isUpdate){//修改
    		
    	}else{//新增
    		java.text.DecimalFormat myformat=new java.text.DecimalFormat("0.00");
    		//通过单元id,获取单元提佣系数
    		String roomId = o.getRoomId();
    		String dicRate = getRate(roomId);
    		String saleAmount = o.getSaleAmount();
    		//分佣金额 = 总金额算/分佣比例 
    		BigDecimal dicMoney = getDicMoney(dicRate,saleAmount);
    		String disLevel = saveRrec(memPhone,dicMoney);
    		//生成楼宇售卖记录
    		o.setDisLevelCount(disLevel);
    		o.setFactDisRate(dicRate);
    		o.setFactDisAmount(myformat.format(dicMoney));
    		if(!disLevel.equals("0")){
    			o.setIsExtract("0");
    		}else{
    			o.setIsExtract("1");
    		}
    	}
    	return salesRecDao.save(o);
    }
    
    /**
     * 通过购买人手机查询分销链路,生成佣金结算记录
     * @param memPhone 购买人手机
     * @param dicMoney 分佣金额
     */
    private String saveRrec(String memPhone,BigDecimal dicMoney){
    	//查找购买人会员
    	int disLevel = 0;
    	Collection<Condition> conditions =  new ArrayList<Condition>();
		conditions.add(ConditionUtils.getCondition("memberPhoneNumber", Condition.EQUALS,memPhone));
		List<MemberInformation> merberList = memberInformationManager.getMemberInformations(conditions, null);
		if(merberList.size()>0){
			String lev1Id = merberList.get(0).getParentMemberId();
			//一级
			if(StringUtils.isNotEmpty(lev1Id)){
				disLevel = 1+disLevel;
				String lev2Id = saveSettleRec(lev1Id,"1",dicMoney);
				//二级
				if(StringUtils.isNotEmpty(lev2Id)){
					disLevel = 1+disLevel;
					String lev3Id = saveSettleRec(lev2Id,"2",dicMoney);
					//三级
					if(StringUtils.isNotEmpty(lev3Id)){
						disLevel = 1+disLevel;
						saveSettleRec(lev3Id,"3",dicMoney);
					}
				}
			}
			
		}
		return String.valueOf(disLevel);
    }
    
    
    /**
     * 生成佣金结算记录
     * @param levId
     * @param lev
     * @param dicMoney
     * @return nextLevId 下级会员id
     */
    private String saveSettleRec(String levId,String lev,BigDecimal dicMoney){
    	java.text.DecimalFormat myformat=new java.text.DecimalFormat("0.00");
    	MemberInformation levMember = memberInformationManager.getMemberInformation(levId);
		//分佣比例
		String disRate = getLevRate(levMember,lev);
		BigDecimal dicRates = new BigDecimal(disRate);
		String money = myformat.format(dicRates.multiply(dicMoney));
		//生成佣金结算记录
		SettleRec settleRec = new SettleRec();
		settleRec.setDisLevel(lev);
		settleRec.setMemId(levId);
		if(StringUtils.isNotEmpty(levMember.getLevel())){
			settleRec.setMemLevel(levMember.getLevel());
		}
		settleRec.setDisAmount(money);
		settleRec.setDisRate(disRate);
		settleRecManager.saveSettleRec(settleRec);
		
		//上级id
		String nextLevId = "";
    	if(StringUtils.isNotEmpty(levMember.getParentMemberId())){
    		nextLevId = levMember.getParentMemberId();
    	}
    	return nextLevId;
    }
    
    
    /**
     * 通过会员等级查询分佣比例规则
     * @param levMember
     * @param disLevel
     * @return
     */
    private String getLevRate(MemberInformation levMember,String disLevel){
		String lev = levMember.getLevel();
		//查询分佣比率配置
		Collection<Condition> levconditions =  new ArrayList<Condition>();
		levconditions.add(ConditionUtils.getCondition("disLevel", Condition.EQUALS,disLevel));
		if(StringUtils.isNotEmpty(lev)){
			levconditions.add(ConditionUtils.getCondition("memLevel", Condition.EQUALS,lev));
		}else{
			levconditions.add(ConditionUtils.getCondition("memLevel", Condition.EQUALS,disLevel));
		}
		List<DisRateConfig> disRates = disRateConfigManager.getDisRateConfigs(levconditions, null);
		//分佣比例
		String disRate = "0";
		if(disRates.size()>0){
			java.text.DecimalFormat myformat=new java.text.DecimalFormat("0.00");
			disRate = disRates.get(0).getDisRate();
			BigDecimal dicRates = new BigDecimal(disRate);
			disRate = myformat.format(dicRates.divide(new BigDecimal("100")));
		}
    	return disRate;
    }
    
	/**
     * 
     * @param roomId
     * @return
     */
    private  String getRate(String roomId){
    	//楼宇提佣系数
    	String dicRate = "0";
    	//通过单元id查找分佣规则
    	Collection<Condition> condition =  new ArrayList<Condition>();
		condition.add(ConditionUtils.getCondition("itemId", Condition.EQUALS,roomId));
		List<BuildingRate> ruleList = buildingRateManager.getBuildingRates(condition, null);
		if(ruleList.size()>0){
			dicRate = ruleList.get(0).getDicRate();
		}else{
			//通过楼宇id查找分佣规则
			BbmRoom bbmRoom = bbmRoomManager.getBbmRoom(roomId);
			if(bbmRoom!=null){
				String buildingId = bbmRoom.getBbmBuilding().getBuildingId();
				Collection<Condition> conditions =  new ArrayList<Condition>();
				conditions.add(ConditionUtils.getCondition("itemId", Condition.EQUALS,buildingId));
				List<BuildingRate> buildingRuleList = buildingRateManager.getBuildingRates(conditions, null);
				if(buildingRuleList.size()>0){
					dicRate = buildingRuleList.get(0).getDicRate();
				}
			}
		}
    	return dicRate;
    }
    
    
    /**
     * 根据总金额算/分佣比例=分佣金额
     * @param dicRate
     * @param saleAmount
     * @return
     */
    private BigDecimal getDicMoney(String dicRate,String saleAmount){
		BigDecimal dicRates = new BigDecimal(dicRate);
		BigDecimal dic = dicRates.divide(new BigDecimal("100"));
		BigDecimal money = dic.multiply(new BigDecimal(saleAmount));
		return money;
    }
    
    /**
	 * 查询个人会员下线
	 * @return
	 */
    @EsbServiceMapping
	public List<MemberInformation> findNextMember(@ServiceParam(name="parentMemberId")String memberId,@ServiceParam(name="lev")String lev){
		Collection<Condition> conditions =  new ArrayList<Condition>();
		conditions.add(ConditionUtils.getCondition("parentMemberId", Condition.EQUALS,memberId));
		List<MemberInformation> lev1Members = memberInformationManager.getMemberInformations(conditions, null);
		//一级下线
		if(lev.equals("1")){
			return lev1Members;
		}else{
			//二级下线
			List<MemberInformation> lev2Members = new ArrayList<MemberInformation>();
			for(MemberInformation m:lev1Members){
				if(StringUtils.isNotEmpty(m.getParentMemberId())){
					MemberInformation member = memberInformationManager.getMember(m.getParentMemberId());
					lev2Members.add(member);
				}
			}
			if(lev.equals("2")){
				return lev2Members;
			}else if(lev.equals("3")){
				//三级下线
				List<MemberInformation> lev3Members = new ArrayList<MemberInformation>();
				for(MemberInformation m:lev2Members){
					if(StringUtils.isNotEmpty(m.getParentMemberId())){
						MemberInformation member = memberInformationManager.getMember(m.getParentMemberId());
						lev3Members.add(member);
					}
				}
				return lev3Members;
			}
		}
		return lev1Members;
	}
    
    
    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeSalesRec(@ServiceParam(name="saleRecId") String id) throws BusException{
    	salesRecDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeSalesRecs(@ServiceParam(name="saleRecId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeSalesRec(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitSalesRec(@ServiceParam(name="saleRecId") String id)  throws BusException{
		return salesRecDao.exists(id);
	}
    
    public boolean exsitSalesRec(String propertyName,Object value) throws BusException{
		return salesRecDao.exists(propertyName,value);
	}

}
