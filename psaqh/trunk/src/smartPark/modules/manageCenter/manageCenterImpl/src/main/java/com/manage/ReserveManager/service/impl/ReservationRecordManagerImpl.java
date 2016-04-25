/**
 * 代码声明
 */
package com.manage.ReserveManager.service.impl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.BuildingBaseManager.entity.BbmRoom;
import com.common.BuildingBaseManager.service.BbmRoomManager;
import com.common.ExtentionAtrManager.service.ExtentionAtrManager;
import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.MessageCenter.service.McMsgdatasManager;
import com.common.MessageCenter.service.McMsgtempalateManager;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityDao;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.service.PurchasingmanagerCommodityManager;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;
import com.gsoft.framework.codemap.entity.Codeitem;
import com.gsoft.framework.codemap.service.CodeitemManager;
import com.gsoft.framework.core.dataobj.Record;
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
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.utils.BizCodeUtil;
import com.manage.ReserveManager.dao.ReservationRecordDao;
import com.manage.ReserveManager.entity.ReservationRecord;
import com.manage.ReserveManager.service.ReservationRecordManager;

@Service("reservationRecordManager")
@Transactional
public class ReservationRecordManagerImpl extends BaseManagerImpl implements ReservationRecordManager{
	@Autowired
	private ReservationRecordDao reservationRecordDao;
	
	@Autowired
	private PurchasingmanagerCommodityDao purchasingmanagerCommodityDao;

	
	@Autowired
	private PurchasingmanagerCommodityManager purchasingmanagerCommodityManager;
	
	
	
	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	
	@Autowired
	private ExtentionAtrManager extentionAtrManager;
	
	@Autowired
	private MemberInformationManager memberInformationManager;
	
	@Autowired 
	private CodeitemManager codeitemManager;
	
	@Autowired
	private McMsgtempalateManager mcMsgtempalateManager;
	
	@Autowired
	private McMsgdatasManager mcMsgdatasManager;
	
	@Autowired
	private BbmRoomManager bbmRoomManager ;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<ReservationRecord> getReservationRecords() throws BusException{
    	return reservationRecordDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<ReservationRecord> getReservationRecords(
    	@ConditionCollection(domainClazz=ReservationRecord.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return reservationRecordDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public ReservationRecord getReservationRecord(@ServiceParam(name="recordId") String id)  throws BusException{
    	return reservationRecordDao.get(id);
    }
    
    /**
     * 查询企业规模代码集:companyScale
     */
    @EsbServiceMapping
	public List<Record> getRecordsByExtendValue(@ServiceParam(name="recordType") String recordType) throws BusException{
    	List<Record> recordList=new ArrayList<Record>();
    	if(recordType !=null){
    		Collection<Condition> condition =  new ArrayList<Condition>();
    		Collection<Order> order = new ArrayList<Order>();
    		order.add(ConditionUtils.getOrder("itemValue", true));
    		condition.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS,recordType));
    		List<Codeitem> list = codeitemManager.getCodeitems(condition, null);
    		for(int i=0;i<list.size();i++){
    			Record record = new Record();
    			record.put("itemValue", list.get(i).getItemValue());
    			record.put("itemName", list.get(i).getItemCaption());
    			recordList.add(record);
    		}
    	}
    	return recordList;
    }

	
	@EsbServiceMapping
	public PagerRecords getPagerReservationRecords(Pager pager,//分页条件
			@ConditionCollection(domainClazz=ReservationRecord.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = reservationRecordDao.findByPager(pager, conditions, orders);
		@SuppressWarnings("unchecked")
		List<ReservationRecord> list=pagerRecords.getRecords();
		for(ReservationRecord r:list){
			String recordType=r.getRecordType();
			String commodityId=r.getRecordCommdityId();
			//01：众创空间 02：工位
			if(recordType.equals("01") || recordType.equals("02")){
				//获取预约商品名称
				if(commodityId !=null){
					PurchasingmanagerCommodity p=purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(commodityId);
					r.setRecordCommdityName(p.getCommodityTitle());;
				}
			}else if(recordType.equals("03")){//03:单元
				if(commodityId !=null){
					BbmRoom room = bbmRoomManager.getBbmRoom(commodityId) ;
					r.setRecordCommdityName(room.getRoomNo());
				}
			}
		}
		return pagerRecords;
	}
    /**
     * 保存对象
     */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "recordMemberId", pubProperty = "userId")})
    public ReservationRecord saveReservationRecord(ReservationRecord o) throws BusException{
		MemberInformation mem=new MemberInformation();
		//获取当前登录用户信息
		if(o.getRecordMemberId() != null){
	    	mem=memberInformationManager.getMemberInformation(o.getRecordMemberId());
	    	//非匿名预约：保存当前用户ID作为预约对象
	    	o.setRecordMemberId(mem.getMemberId());
	    	
	    	if(StringUtils.isEmpty(o.getVisiteTel())){
	    		o.setVisiteTel(mem.getMemberPhoneNumber());//工位预约时
	    	}
	    	if(StringUtils.isEmpty(o.getVisiteName())){
	    		o.setVisiteName(mem.getMemberName());//工位预约时
	    	}
		}
		
    	String recordId = o.getRecordId();
    	boolean isUpdate = StringUtils.isNotEmpty(recordId);
    	if(isUpdate){//修改
    		ReservationRecord r=reservationRecordDao.get(recordId);
    		r.setRecordMemberId(o.getRecordMemberId());
    		r.setRecordType(o.getRecordType());
    		r.setVisiteDate(o.getVisiteDate());
    		r.setUpdateUser(o.getRecordMemberId());
    		r.setVisiteName(o.getVisiteName());
    		r.setVisiteTel(o.getVisiteTel());
    		r.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return reservationRecordDao.save(r);
    	}else{//新增
    		o.setRecordStatus("01");//待受理
    		o.setRecordCode(BizCodeUtil.getInstance().getBizCodeDate("YYDH"));//生成预约单号
    		if(StringUtils.isEmpty(o.getVisiteDate())){
    			o.setVisiteDate(o.getIncomingDate());
    		}
        	o.setCreateUser(o.getRecordMemberId());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o=reservationRecordDao.save(o);
//    		//发送短信给联系人
//    		try {
//    			//构建替换模板参数对应的map
//    			Map<String, String> replaceMap = new ReferenceMap();
//    			replaceMap.put("#user", mem!=null?mem.getMemberName():o.getVisiteName());
//    			replaceMap.put("#appointmentNo", o.getRecordCode());
//    			//构建消息内容数据
//    			McMsgdatas msgData = mcMsgdatasManager.buildMsgData(MessageTempCode.MSG_USER_1, replaceMap);
//    			//发送消息,给会员
//    			//mcMsgdatasManager.sendMessage(msgData, mem!=null?mem.getMemberId():null, 1);
//    			mcMsgdatasManager.sendMessage(msgData, mem!=null?mem.getMemberPhoneNumber():o.getVisiteTel(), 5);
//    			
//    			
//    			//获取关联项目
//    			String commodityId=o.getRecordCommdityId();
//    			PurchasingmanagerCommodity p =new PurchasingmanagerCommodity();
//				if(commodityId !=null){
//					p=purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(commodityId);
//				}
//				Map<String, String> replaceMap1 = new ReferenceMap();
//    			replaceMap.put("#appointmentNo", o.getRecordCode());
//    			replaceMap.put("#relateProject", p!=null?p.getCommodityTitle():null);
//    			//构建消息内容数据
//    			McMsgdatas msgData1 = mcMsgdatasManager.buildMsgData(MessageTempCode.MSG_BACKGROUND_4, replaceMap1);
//    			//发送消息,给招商管理员:ROLE_SALE_ADMIN
//    			mcMsgdatasManager.sendMessage(msgData1,"ROLE_SALE_ADMIN",2);
//    		} catch (Exception e) {
//    			e.printStackTrace();
//    		}
    		return o;
    	}
    	
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeReservationRecord(@ServiceParam(name="recordId") String id) throws BusException{
    	reservationRecordDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeReservationRecords(@ServiceParam(name="recordId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeReservationRecord(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitReservationRecord(@ServiceParam(name="recordId") String id)  throws BusException{
		return reservationRecordDao.exists(id);
	}
    
    public boolean exsitReservationRecord(String propertyName,Object value) throws BusException{
		return reservationRecordDao.exists(propertyName,value);
	}
    
    
    /**
     * 新增回访记录，预约由已授理状态变更为已到访或未到访状态
     */
    @EsbServiceMapping
    public ReservationRecord saveReternRecords(ReservationRecord o) throws BusException{
    	if(o.getRecordVisiteStatus().equals("01")){//是否回访 01：是
    		o.setRecordStatus("03");//已到访
    	}else{
    		o.setRecordStatus("05");//未到访
    	}
    	o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	return reservationRecordDao.save(o);
    }
    
	/**
	 * 变更状态:已预约-->已授理
	 * */
	@EsbServiceMapping
	public void changeReservationRecordByStatus(ReservationRecord o) throws BusException {
		o.setRecordStatus("02");//已授理
		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		reservationRecordDao.save(o);
	}
	
    /**
     * 根据隶属于工位的所有的商品 genreCode=040101:工位
     */
	@EsbServiceMapping
	public List<PurchasingmanagerCommodity> getCommodityByGenreType(@ServiceParam(name="genreCode") String genreCode) throws BusException{
		List<PurchasingmanagerCommodity> recordList=new ArrayList<PurchasingmanagerCommodity>();
		Collection<Condition> conditions = new ArrayList<Condition>();
		Collection<Condition> condition = new ArrayList<Condition>();
		
		if(genreCode.equals("040101")){//040101:工位，查询商品表基础信息
			conditions.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS,genreCode));
			List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(conditions, null);
			String genreId="";
			if(purchasingmanagerGenreList.size()>0){
				genreId = purchasingmanagerGenreList.get(0).getGenreId();
			}
			if(StringUtils.isNotEmpty(genreId)){
				// 查询隶属于工位的商品
				condition.add(ConditionUtils.getCondition("genreId",Condition.EQUALS,genreId));
				List<PurchasingmanagerCommodity> pcList = purchasingmanagerCommodityManager.getPurchasingmanagerCommoditys(condition, null);
				for(PurchasingmanagerCommodity pc:pcList){
//					extentionAtrManager.setGwExtendValue(pc);
//					String commodityName=pc.getGw().getCommodityId();
//		    		if(commodityName !=null){
//		    			PurchasingmanagerCommodity c=purchasingmanagerCommodityDao.get(commodityName); 
//		    			commodityName=c.getCommodityTitle();
//		    			pc.getGw().setCommodityId(commodityName);
//		    		}
					recordList.add(pc);
				}
			}
		}
		return recordList;
	}
	
    /**
     * 根据隶属于创立方的所有的商品 genreCode=0401:创立方
     */
	@EsbServiceMapping
	public List<Record> getRecordsByRecordType(@ServiceParam(name="recordType") String recordType) throws BusException{
		List<Record> recordList=new ArrayList<Record>();
		Collection<Condition> conditions = new ArrayList<Condition>();
		Collection<Condition> condition = new ArrayList<Condition>();
		String genreCode="0401";
		if(StringUtils.isEmpty(recordType) || recordType ==null){
			recordType=genreCode;
		}
		
		if(recordType.equals("0401")){//0401:创立方，查询商品表基础信息
			conditions.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS, recordType));
			List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(conditions, null);
			String genreId="";
			if(purchasingmanagerGenreList.size()>0){
				genreId = purchasingmanagerGenreList.get(0).getGenreId();
			}
			if(StringUtils.isNotEmpty(genreId)){
				// 查询隶属于创立方的商品
				condition.add(ConditionUtils.getCondition("genreId",Condition.EQUALS,genreId));
				List<PurchasingmanagerCommodity> pcList = purchasingmanagerCommodityManager.getPurchasingmanagerCommoditys(condition, null);
				for(PurchasingmanagerCommodity pg:pcList){
					Record record = new Record();
					record.put("itemValue", pg.getCommodityId());
					record.put("itemName", pg.getCommodityTitle());
					recordList.add(record);
				}
			}
		}
		return recordList;
	}
	
	
	/**
	 * 前台个人中心    取消预约申请，将待受理状态变更为已取消
	 * @param ReservationRecord
	 */
     @EsbServiceMapping
      public ReservationRecord cancelReservation(ReservationRecord o) throws BusException{
    	ReservationRecord p=new ReservationRecord();
		String recordId=o.getRecordId();
		if(StringUtils.isNotEmpty(recordId)){
			p=reservationRecordDao.get(recordId);//根据主键查询预约记录基础数据
			String recordStatus = p.getRecordStatus();
			if("01".equals(recordStatus))
		    {
				p.setRecordStatus("04");//04为已取消
				p.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
				return reservationRecordDao.save(p);
			}else{
				throw new BusException("当前状态不能取消");				
			}
		}else{
			//return null;
			throw new BusException("对象id为空，取消失败");
		}    
    }
    /**
     * 根据当前登录用户预约
     */
    @EsbServiceMapping
	public PagerRecords getReservationRecordsforpage(Pager pager,//分页条件
			@ConditionCollection(domainClazz=ReservationRecord.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,
			@ServiceParam(name="userId",pubProperty = "userId") String userId) throws BusException {
    	//获取当前用户预约
    	conditions.add(ConditionUtils.getCondition("recordMemberId", Condition.EQUALS, userId));
    	PagerRecords pagerRecords = reservationRecordDao.findByPager(pager, conditions, orders);
    	@SuppressWarnings("unchecked")
		List<ReservationRecord> list=pagerRecords.getRecords();
		for(ReservationRecord r:list){
			String recordType=r.getRecordType();
			String commodityId=r.getRecordCommdityId();
			//01：众创空间 02：工位
			if(recordType.equals("01") || recordType.equals("02")){
				//获取预约商品名称
				if(commodityId !=null){
					PurchasingmanagerCommodity p=purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(commodityId);
					r.setRecordCommdityName(p.getCommodityTitle());;
				}
			}else if(recordType.equals("03")){//03:单元
				if(commodityId !=null){
					BbmRoom room = bbmRoomManager.getBbmRoom(commodityId) ;
					r.setRecordCommdityName(room.getRoomNo());
				}
			}
			
		}
		return pagerRecords;
	} 
}
