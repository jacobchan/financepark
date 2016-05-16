/**
 * 代码声明
 */
package com.common.purchasingManager.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.BuildingBaseManager.entity.BbmRoom;
import com.common.BuildingBaseManager.service.BbmRoomManager;
import com.common.ExtentionAtrManager.entity.Billboard;
import com.common.ExtentionAtrManager.entity.CarEntity;
import com.common.ExtentionAtrManager.entity.ClfEntity;
import com.common.ExtentionAtrManager.entity.GwEntity;
import com.common.ExtentionAtrManager.entity.MeetingEntity;
import com.common.ExtentionAtrManager.service.impl.ExtentionAtrManagerImpl;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityDao;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityExtendDao;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerCommodityExtend;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.entity.PurchasingmanagerGenreProperty;
import com.common.purchasingManager.service.PurchasingmanagerCommodityExtendManager;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;
import com.common.purchasingManager.service.PurchasingmanagerGenrePropertyManager;
import com.common.purchasingManager.service.PurchasingmanagerPublicManager;
import com.gsoft.framework.codemap.entity.Codeitem;
import com.gsoft.framework.codemap.service.CodeitemManager;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.PubCondition;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.SecurityUtils;
import com.gsoft.framework.util.StringUtils;

@Service("purchasingmanagerPublicManager")
@Transactional
public class PurchasingmanagerPublicManagerImpl extends BaseManagerImpl implements PurchasingmanagerPublicManager{
	@Autowired
	private PurchasingmanagerCommodityDao purchasingmanagerCommodityDao;
	
	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	
	@Autowired
	private PurchasingmanagerGenrePropertyManager purchasingmanagerGenrePropertyManager;
	
	@Autowired
	private BbmRoomManager bbmRoomManager;
	
	@Autowired
	private PurchasingmanagerCommodityExtendManager purchasingmanagerCommodityExtendManager;
	
	@Autowired
	private PurchasingmanagerCommodityExtendDao purchasingmanagerCommodityExtendDao;
	
	@Autowired 
	private CodeitemManager codeitemManager;
	
	@Autowired 
	private ExtentionAtrManagerImpl extentionAtrManagerImpl;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PurchasingmanagerCommodity> getPurchasingmanagerCommoditys() throws BusException{
    	return purchasingmanagerCommodityDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PurchasingmanagerCommodity> getPurchasingmanagerCommoditys(
    	@ConditionCollection(domainClazz=PurchasingmanagerCommodity.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return purchasingmanagerCommodityDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PurchasingmanagerCommodity getPurchasingmanagerCommodity(@ServiceParam(name="genreCode") String genreCode,@ServiceParam(name="commodityId") String id)  throws BusException{
    	PurchasingmanagerCommodity o=purchasingmanagerCommodityDao.get(id);
    	if(genreCode !=null &&genreCode.equals("0301")){//会议室
    		extentionAtrManagerImpl.setMeetingRoomExtendValue(o);
    	}else if(genreCode !=null &&genreCode.equals("0302")){//车辆
    		extentionAtrManagerImpl.setCarExtendValue(o);
    	}else if(genreCode !=null &&genreCode.equals("0401")){//创立方
    		extentionAtrManagerImpl.setClfExtendValue(o);
    	}else if(genreCode !=null &&genreCode.equals("040101")){//工位
    		extentionAtrManagerImpl.setGwExtendValue(o);;
    	}
    	
    	return o;
    }
	
    /**
     * 查询商品代码集:roomType：会议室类型 ；roomProjector投影仪；roomGm:会议室规模人数
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
    		Record record1 = new Record();
    		if(recordType.equals("roomType") || recordType.equals("stalls")){
    			record1.put("itemValue", "00");
    			record1.put("itemName", "全部");
    		}else{
    			record1.put("itemValue", "00");
    			record1.put("itemName", "不限");
    		}
			recordList.add(record1);
    		for(int i=0;i<list.size();i++){
    			Record record = new Record();
    			record.put("itemValue", list.get(i).getItemValue());
    			record.put("itemName", list.get(i).getItemCaption());
    			recordList.add(record);
    		}
    	}
    	return recordList;
    }

    /**
     * 公共资源修改页面获取初始数据
     */
    @EsbServiceMapping
    public PurchasingmanagerCommodity getPurchasingmanagerCommodityForPublic(@ServiceParam(name="genreCode") String genreCode,@ServiceParam(name="commodityId") String id)  throws BusException{
    	PurchasingmanagerCommodity o=purchasingmanagerCommodityDao.get(id);
    	if(genreCode !=null &&genreCode.equals("0301")){//会议室
    		extentionAtrManagerImpl.setMeetingRoomExtendValue(o);
    		String lx=o.getMeetingRoom().getLx();
    		if(lx !=null){//会议室类型：01--视频会议室，02---普通会议室
    			Collection<Condition> condition =  new ArrayList<Condition>();
    			condition.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS,"roomType"));
    			condition.add(ConditionUtils.getCondition("itemCaption", Condition.EQUALS,lx));
    			List<Codeitem> list = codeitemManager.getCodeitems(condition, null);
    			if(list.size()>0){
    				lx=list.get(0).getItemValue();
    				o.getMeetingRoom().setLx(lx);
    			}
    		}
    		
    		String tyy=o.getMeetingRoom().getTyy();
    		if(tyy !=null){//投影仪有无：01--有，02---无
    			Collection<Condition> condition =  new ArrayList<Condition>();
    			condition.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS,"roomProjector"));
    			condition.add(ConditionUtils.getCondition("itemCaption", Condition.EQUALS,tyy));
    			List<Codeitem> list = codeitemManager.getCodeitems(condition, null);
    			if(list.size()>0){
    				tyy=list.get(0).getItemValue();
    				o.getMeetingRoom().setTyy(tyy);
    			}
    		}
    		
    		String gm=o.getMeetingRoom().getGm();
    		if(gm !=null){//会议室规模
    			Collection<Condition> condition =  new ArrayList<Condition>();
    			condition.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS,"roomGm"));
    			condition.add(ConditionUtils.getCondition("itemCaption", Condition.EQUALS,gm));
    			List<Codeitem> list = codeitemManager.getCodeitems(condition, null);
    			if(list.size()>0){
    				gm=list.get(0).getItemValue();
    				o.getMeetingRoom().setGm(gm);
    			}
    		}
    	}else if(genreCode !=null &&genreCode.equals("0302")){//车辆
    		extentionAtrManagerImpl.setCarExtendValue(o);
    		String dw=o.getCar().getDw();
    		if(dw !=null){//车辆档位
    			Collection<Condition> condition =  new ArrayList<Condition>();
    			condition.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS,"stalls"));
    			condition.add(ConditionUtils.getCondition("itemCaption", Condition.EQUALS,dw));
    			List<Codeitem> list = codeitemManager.getCodeitems(condition, null);
    			if(list.size()>0){
    				dw=list.get(0).getItemValue();
    				o.getCar().setDw(dw);
    			}
    		}
    		String zw=o.getCar().getZw();
    		if(zw !=null){//车辆座位
    			Collection<Condition> condition =  new ArrayList<Condition>();
    			condition.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS,"seat"));
    			condition.add(ConditionUtils.getCondition("itemCaption", Condition.EQUALS,zw));
    			List<Codeitem> list = codeitemManager.getCodeitems(condition, null);
    			if(list.size()>0){
    				zw=list.get(0).getItemValue();
    				o.getCar().setZw(zw);;
    			}
    		}
    	}else if(genreCode !=null &&genreCode.equals("0401")){//创立方
    		extentionAtrManagerImpl.setClfExtendValue(o);
    	}else if(genreCode !=null &&genreCode.equals("040101")){//工位
    		extentionAtrManagerImpl.setGwExtendValue(o);
    	}
    	
    	return o;
    }
    
    
    /**
     * 根据主键查询广告位
     */
    @EsbServiceMapping
    public PurchasingmanagerCommodity getPurchasingmanagerCommodityLed(@ServiceParam(name="commodityId") String id)  throws BusException{
    	PurchasingmanagerCommodity o=purchasingmanagerCommodityDao.get(id);
    	extentionAtrManagerImpl.setMeetingLedExtendValue(o);
    	return o;
    }
	
    
    
	@EsbServiceMapping
	public PagerRecords getPagerPurchasingmanagerCommoditys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerCommodity.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,@ServiceParam(name="genreCode") String genreCode)  throws BusException{
		//查询公共资源中的的商品:会议室genreCode= 0301;车辆：genreCode=0302;广告：genreCode=0303
		Collection<Condition> condition = new ArrayList<Condition>();
		condition.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS,genreCode));
		List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(condition, null);
		String genreId="";
		if(purchasingmanagerGenreList.size()>0){
			genreId = purchasingmanagerGenreList.get(0).getGenreId();
		}
		conditions.add(ConditionUtils.getCondition("genreId",Condition.EQUALS,genreId));
		PagerRecords pagerRecords = purchasingmanagerCommodityDao.findByPager(pager, conditions, orders);
		@SuppressWarnings("unchecked")
		List<PurchasingmanagerCommodity> list=pagerRecords.getRecords();
		List<PurchasingmanagerCommodity> list1=new ArrayList<PurchasingmanagerCommodity>();
		PurchasingmanagerGenre pg=purchasingmanagerGenreManager.getPurchasingmanagerGenre(genreId);
		for(PurchasingmanagerCommodity pc:list){
			pc.setPurchasingmanagerGenre(pg);
			list1.add(pc);
		}
		pagerRecords.setRecords(list1);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PurchasingmanagerCommodity savePurchasingmanagerCommodity(PurchasingmanagerCommodity o) throws BusException{
    	String commodityId = o.getCommodityId();
		boolean isUpdate = StringUtils.isNotEmpty(commodityId);
    	if(isUpdate){//修改
    		PurchasingmanagerCommodity pc = purchasingmanagerCommodityDao.get(commodityId); 
    		pc.setCommodityTitle(o.getCommodityTitle());
    		pc.setCommodityPrice(o.getCommodityPrice());
    		pc.setGenreId(o.getGenreId());
    		pc.setPurchasingmanagerMerchant(o.getPurchasingmanagerMerchant());
    		pc.setCommodityStock(o.getCommodityStock());
    		pc.setCommodityIsnotDisplayStock(o.getCommodityIsnotDisplayStock());
    		pc.setCommodityUpTime(o.getCommodityUpTime());
    		pc.setCommodityDownTime(o.getCommodityDownTime());
    		pc.setCommodityImage(o.getCommodityImage());
    		pc.setCommodityCoverImage(o.getCommodityCoverImage());
    		pc.setCommodityDescribe(o.getCommodityDescribe());
    		pc.setUpdateUser(o.getUpdateUser());
    		pc.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerCommodityDao.save(pc);
    	}else{//新增
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerCommodityDao.save(o);
    	}
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePurchasingmanagerCommodity(@ServiceParam(name="commodityId") String id) throws BusException{
    	purchasingmanagerCommodityDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePurchasingmanagerCommoditys(@ServiceParam(name="commodityId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePurchasingmanagerCommodity(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPurchasingmanagerCommodity(@ServiceParam(name="commodityId") String id)  throws BusException{
		return purchasingmanagerCommodityDao.exists(id);
	}
    
    public boolean exsitPurchasingmanagerCommodity(String propertyName,Object value) throws BusException{
		return purchasingmanagerCommodityDao.exists(propertyName,value);
	}
    
    /**
     * 根据商品类型获取相应的商品信息
     */
	@EsbServiceMapping
    public List<PurchasingmanagerCommodity> getCommodityRecordsByRecordType(
       @ServiceParam(name="commodityId.purchasingmanagerGenre.genreId") String genreId) throws BusException{
		List<PurchasingmanagerCommodity> list=new ArrayList<PurchasingmanagerCommodity>();
		if(StringUtils.isNotEmpty(genreId)){
			list = purchasingmanagerCommodityDao.getList("purchasingmanagerGenre.genreId", genreId);
		}
		return list;
	}
	
	
	 /**
     * 根据商品类别获取商品扩展属性
     */
	@Override
	@EsbServiceMapping
	public List<PurchasingmanagerCommodityExtend> getPagerCommodityExtsByGenreId(@ServiceParam(name="genreCode") String genreCode) 
			throws BusException {
		List<PurchasingmanagerCommodityExtend> commodityExtList = new ArrayList<PurchasingmanagerCommodityExtend>();
		
		Collection<Condition> condition = new ArrayList<Condition>();
		//获得商品类别 genreCode=0301:会议室 ；genreCode=0302:车辆 ；genreCode=0303:广告
		condition.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS,genreCode));
		List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(condition, null);
		String genreId="";
		if(purchasingmanagerGenreList.size()>0){
			genreId = purchasingmanagerGenreList.get(0).getGenreId();
		}
		//根据类别ID获得商品类属性列表
		Collection<Condition> conditions = new ArrayList<Condition>();
		conditions.add(ConditionUtils.getCondition("purchasingmanagerGenre.genreId", Condition.EQUALS, genreId));
		List<PurchasingmanagerGenreProperty> pgpList = purchasingmanagerGenrePropertyManager.getPurchasingmanagerGenrePropertys(conditions, null);
		for(PurchasingmanagerGenreProperty pgp:pgpList){
			PurchasingmanagerCommodityExtend pce = new PurchasingmanagerCommodityExtend();
			//根据商品ID和商品类属性字段名获取商品扩展属性值列表
			pce.setPurchasingmanagerGenreProperty(pgp);
			commodityExtList.add(pce);
		}
		return commodityExtList;
	}
	
	
	//保存会议室商品及其扩展属性
	@Override
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
	public void saveCommodityAndPropertyForRoom(PurchasingmanagerCommodity o) {
		List<Record> listForRoom=this.getRecordsByGenreCode("0301");//所属商户
		o.setGenreId(listForRoom.size()>0?listForRoom.get(0).get("genreId").toString():null);
		MeetingEntity meetingRoom=o.getMeetingRoom();
		String adr=meetingRoom.getAdr();//获取会议室地址
		bbmRoomManager.setMeetingRoomStatus(adr);//会议室占用单元时，设置单元状态
//		BbmRoom bbmRoom=bbmRoomManager.getBbmRoom(adr);
//		if(bbmRoom != null){
//			//获取单元默认地址
//			adr=bbmRoom.getRoomAddress();
//		}
		
		String lx=meetingRoom.getLx();//会议室类型
		if(lx !=null){//会议室类型：01--视频会议室，02---普通会议室
			Collection<Condition> condition =  new ArrayList<Condition>();
			condition.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS,"roomType"));
			condition.add(ConditionUtils.getCondition("itemValue", Condition.EQUALS,lx));
			List<Codeitem> list = codeitemManager.getCodeitems(condition, null);
			if(list.size()>0){
				lx=list.get(0).getItemCaption();
			}
		}
		
		String gm=meetingRoom.getGm();//会议室规模
		if(gm !=null){//
			Collection<Condition> condition =  new ArrayList<Condition>();
			condition.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS,"roomGm"));
			condition.add(ConditionUtils.getCondition("itemValue", Condition.EQUALS,gm));
			List<Codeitem> list = codeitemManager.getCodeitems(condition, null);
			if(list.size()>0){
				gm=list.get(0).getItemCaption();
			}
		}
		
		String tyy=meetingRoom.getTyy();//投影仪有无
		if(tyy !=null){//投影仪有无：01--有，02---无
			Collection<Condition> condition =  new ArrayList<Condition>();
			condition.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS,"roomProjector"));
			condition.add(ConditionUtils.getCondition("itemValue", Condition.EQUALS,tyy));
			List<Codeitem> list = codeitemManager.getCodeitems(condition, null);
			if(list.size()>0){
				tyy=list.get(0).getItemCaption();
			}
		}
		
		String commodityId = o.getCommodityId();
		boolean isUpdate = StringUtils.isNotEmpty(commodityId);
		
		boolean dzFlag=true;
		boolean gmFlag=true;
		boolean lxFlag=true;
		boolean tyyFlag=true;
		List<PurchasingmanagerCommodityExtend> peList=new ArrayList<PurchasingmanagerCommodityExtend>();
		
		
    	if(isUpdate){//修改
    		PurchasingmanagerCommodity pc = purchasingmanagerCommodityDao.get(commodityId); 
    		pc.setCommodityTitle(o.getCommodityTitle());
    		pc.setCommodityPrice(o.getCommodityPrice());
    		pc.setGenreId(o.getGenreId());
    		pc.setPurchasingmanagerMerchant(o.getPurchasingmanagerMerchant());
    		pc.setCommodityImage(StringUtils.isNotEmpty(o.getCommodityImage())?o.getCommodityImage():null);
    		pc.setCommodityCoverImage(StringUtils.isNotEmpty(o.getCommodityCoverImage())?o.getCommodityCoverImage():null);
    		pc.setCommodityDescribe(o.getCommodityDescribe());
    		pc.setUpdateUser(o.getUpdateUser());
    		pc.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o=purchasingmanagerCommodityDao.save(pc);
    		
    		// 根据商品ID获取商品扩展属性
    		List<PurchasingmanagerCommodityExtend> purExList = purchasingmanagerCommodityExtendManager.getCommodityExtList(commodityId);
    		
    		if(purExList.size()>0){
    			for(PurchasingmanagerCommodityExtend pce:purExList){
    				if(meetingRoom.getAdrfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(adr);//保存会议室地址属性
    					dzFlag=false;
    				}else if(meetingRoom.getGmfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(gm);//保存会议室规模
    					gmFlag=false;
    				}else if(meetingRoom.getLxfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(lx);//保存会议室类型
    					lxFlag=false;
    				}else if(meetingRoom.getTyyfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(tyy);//保存会议室投影仪
    					tyyFlag=false;
    				}
    				pce.setUpdateUser(o.getUpdateUser());
    				pce.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    				peList.add(pce);
    			}
    			if(dzFlag){
	    			throw new BusException("请先添加会议室的地址属性");
	    		}else if(gmFlag){
	    			throw new BusException("请先添加会议室的规模人数属性");
	    		}else if(lxFlag){
	    			throw new BusException("请先添加会议室的类型属性");
	    		}else if(tyyFlag){
	    			throw new BusException("请先添加会议室的投影仪属性");
	    		}else{
	    			purchasingmanagerCommodityExtendDao.save(peList);//保存会议室扩展属性列表
	    		}
    		}else{
    			throw new BusException("请先添加会议室的全部扩展属性：会议室地址、规模人数、类型、投影仪");
    		}
    		
    		
    	}else{//新增
    		o=purchasingmanagerCommodityDao.save(o);
    		//获取会议室扩展属性
    		String genreCode="0301";//会议室类别编号
    		List<PurchasingmanagerCommodityExtend> pceList=this.getPagerCommodityExtsByGenreId(genreCode);
    		if(pceList.size()>0){
    			for(PurchasingmanagerCommodityExtend pce:pceList){
    				if(meetingRoom.getAdrfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(adr);//保存会议室地址属性
    					dzFlag=false;
    				}else if(meetingRoom.getGmfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(gm);//保存会议室规模
    					gmFlag=false;
    				}else if(meetingRoom.getLxfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(lx);//保存会议室类型
    					lxFlag=false;
    				}else if(meetingRoom.getTyyfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(tyy);//保存会议室投影仪
    					tyyFlag=false;
    				}
    				/*PurchasingmanagerCommodity pc = new PurchasingmanagerCommodity();
    				pc.setCommodityId(o.getCommodityId());*/
    				pce.setCommodityId(o.getCommodityId());
    				pce.setCreateUser(o.getUpdateUser());
    				pce.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    				pce.setUpdateUser(o.getUpdateUser());
    				pce.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    				peList.add(pce);
    			}
    			if(dzFlag){
	    			throw new BusException("请先添加会议室的地址属性");
	    		}else if(gmFlag){
	    			throw new BusException("请先添加会议室的规模人数属性");
	    		}else if(lxFlag){
	    			throw new BusException("请先添加会议室的类型属性");
	    		}else if(tyyFlag){
	    			throw new BusException("请先添加会议室的投影仪属性");
	    		}else{
	    			purchasingmanagerCommodityExtendDao.save(peList);//保存会议室扩展属性列表
	    		}
    			
    		}else{
    			throw new BusException("请先添加会议室的全部扩展属性：会议室地址、规模人数、类型、投影仪");
    		}
    	}
		
			
			
		
	}
	
	 /**
     * 保存工位及其扩展属性对象
     */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public void saveCommodityAndPropertyForGw(PurchasingmanagerCommodity o) throws BusException{
		List<Record> listForGw=this.getRecordsByGenreCode("040101");//所属商户
		o.setGenreId(listForGw.size()>0?listForGw.get(0).get("genreId").toString():null);
		//获取工位所属创立方Id
		GwEntity gw=o.getGw();
		/*String commodityName="";
		if(gw.getCommodityId() !=null){
			PurchasingmanagerCommodity c=purchasingmanagerCommodityDao.get(gw.getCommodityId()); 
			commodityName=c.getCommodityTitle();
		}*/
		
		boolean gwFlag=true;
		List<PurchasingmanagerCommodityExtend> peList=new ArrayList<PurchasingmanagerCommodityExtend>();
		
		String commodityId = o.getCommodityId();
		boolean isUpdate = StringUtils.isNotEmpty(commodityId);
    	if(isUpdate){//修改
    		PurchasingmanagerCommodity pc = purchasingmanagerCommodityDao.get(commodityId); 
    		pc.setCommodityTitle(o.getCommodityTitle());
    		pc.setCommodityPrice(o.getCommodityPrice());
    		pc.setGenreId(o.getGenreId());
    		pc.setPurchasingmanagerMerchant(o.getPurchasingmanagerMerchant());
    		pc.setCommodityImage(StringUtils.isNotEmpty(o.getCommodityImage())?o.getCommodityImage():null);
    		pc.setCommodityCoverImage(StringUtils.isNotEmpty(o.getCommodityCoverImage())?o.getCommodityCoverImage():null);
    		pc.setCommodityDescribe(o.getCommodityDescribe());
    		pc.setUpdateUser(o.getUpdateUser());
    		pc.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o=purchasingmanagerCommodityDao.save(pc);
    		
    		// 根据商品ID获取商品扩展属性
    		List<PurchasingmanagerCommodityExtend> purExList = purchasingmanagerCommodityExtendManager.getCommodityExtList(commodityId);
    		
    		if(purExList.size()>0){
    			for(PurchasingmanagerCommodityExtend pce:purExList){
    				if(gw.getCommodityIdfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(gw.getCommodityId());//保存工位创立方Id属性
    					gwFlag=false;
    				}
    				pce.setCommodityId(o.getCommodityId());
    				pce.setUpdateUser(o.getUpdateUser());
    				pce.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    				peList.add(pce);
    			}
    			if(gwFlag){
	    			throw new BusException("请先添加工位所属创立方属性");
	    		}else{
	    			purchasingmanagerCommodityExtendDao.save(peList);//保存工位扩展属性列表
	    		}
    		}else{
    			throw new BusException("请先添加工位的扩展属性：所属创立方");
    		}
    		
    		
    	}else{//新增
    		o=purchasingmanagerCommodityDao.save(o);
    		//获取工位扩展属性
    		String genreCode="040101";//工位类别编号
    		List<PurchasingmanagerCommodityExtend> pceList=this.getPagerCommodityExtsByGenreId(genreCode);
    		if(pceList.size()>0){
    			for(PurchasingmanagerCommodityExtend pce:pceList){
    				if(gw.getCommodityIdfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(gw.getCommodityId());//保存工位创立方Id属性
    					gwFlag=false;
    				}
    				pce.setCommodityId(o.getCommodityId());
    				pce.setCreateUser(o.getUpdateUser());
    				pce.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    				pce.setUpdateUser(o.getUpdateUser());
    				pce.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    				peList.add(pce);
    			}
    			if(gwFlag){
	    			throw new BusException("请先添加工位所属创立方属性");
	    		}else{
	    			purchasingmanagerCommodityExtendDao.save(peList);//保存工位扩展属性列表
	    		}
    		}else{
    			throw new BusException("请先添加工位的扩展属性：所属创立方");
    		}
    	}
		
    }
	
	
	 /**
     * 保存创立方及其扩展属性对象
     */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public void saveCommodityAndPropertyForClf(PurchasingmanagerCommodity o) throws BusException{
		List<Record> list=this.getRecordsByGenreCode("0401");//所属商户
		o.setGenreId(list.size()>0?list.get(0).get("genreId").toString():null);
		//获取创立方地址
		ClfEntity clf=o.getClf();
		String adr=clf.getAdr();//获取创立方地址
		bbmRoomManager.setChuangRoomStatus(adr);//创立方占用单元时，设置单元状态
//		BbmRoom bbmRoom=bbmRoomManager.getBbmRoom(adr);
//		if(bbmRoom != null){
//			//获取单元默认地址
//			adr=bbmRoom.getRoomAddress();
//		}
		boolean gwFlag=true;
		List<PurchasingmanagerCommodityExtend> peList=new ArrayList<PurchasingmanagerCommodityExtend>();
		
		String commodityId = o.getCommodityId();
		boolean isUpdate = StringUtils.isNotEmpty(commodityId);
    	if(isUpdate){//修改
    		PurchasingmanagerCommodity pc = purchasingmanagerCommodityDao.get(commodityId); 
    		pc.setCommodityTitle(o.getCommodityTitle());
    		pc.setCommodityPrice(o.getCommodityPrice());
    		pc.setGenreId(o.getGenreId());
    		pc.setPurchasingmanagerMerchant(o.getPurchasingmanagerMerchant());
    		pc.setCommodityImage(StringUtils.isNotEmpty(o.getCommodityImage())?o.getCommodityImage():null);
    		pc.setCommodityCoverImage(StringUtils.isNotEmpty(o.getCommodityCoverImage())?o.getCommodityCoverImage():null);
    		pc.setCommodityDescribe(o.getCommodityDescribe());
    		pc.setUpdateUser(o.getUpdateUser());
    		pc.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o=purchasingmanagerCommodityDao.save(pc);
    		
    		// 根据商品ID获取商品扩展属性
    		List<PurchasingmanagerCommodityExtend> purExList = purchasingmanagerCommodityExtendManager.getCommodityExtList(commodityId);
    		
    		if(purExList.size()>0){
    			for(PurchasingmanagerCommodityExtend pce:purExList){
    				if(clf.getAdrfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(adr);//保存创立方地址属性
    					gwFlag=false;
    				}
    				pce.setUpdateUser(o.getUpdateUser());
    				pce.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    				peList.add(pce);
    			}
    			if(gwFlag){
	    			throw new BusException("请先添加创立方地址属性");
	    		}else{
	    			purchasingmanagerCommodityExtendDao.save(peList);//保存创立方扩展属性列表
	    		}
    		}else{
    			throw new BusException("请先添加创立方的扩展属性：创立方地址");
    		}
    		
    		
    	}else{//新增
    		o=purchasingmanagerCommodityDao.save(o);
    		//获取创立方扩展属性
    		String genreCode="0401";//创立方类别编号
    		List<PurchasingmanagerCommodityExtend> pceList=this.getPagerCommodityExtsByGenreId(genreCode);
    		if(pceList.size()>0){
    			for(PurchasingmanagerCommodityExtend pce:pceList){
    				if(clf.getAdrfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(adr);//保存工位创立方Id属性
    					gwFlag=false;
    				}
    				pce.setCommodityId(o.getCommodityId());
    				pce.setCreateUser(o.getUpdateUser());
    				pce.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    				pce.setUpdateUser(o.getUpdateUser());
    				pce.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    				peList.add(pce);
    			}
    			if(gwFlag){
	    			throw new BusException("请先添加创立方地址属性");
	    		}else{
	    			purchasingmanagerCommodityExtendDao.save(peList);//保存工位扩展属性列表
	    		}
    		}else{
    			throw new BusException("请先添加创立方的扩展属性：创立方地址");
    		}
    	}
		
    }

	//保存车辆商品及其扩展属性
	@Override
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
	public void saveCommodityAndPropertyForCar(PurchasingmanagerCommodity o) {
		List<Record> listForCar=this.getRecordsByGenreCode("0302");//所属商户
		o.setGenreId(listForCar.size()>0?listForCar.get(0).get("genreId").toString():null);
		//获取当前登录用户
		Object object = SecurityUtils.getPrincipal();
		User user = new User();
		if(object != null && object instanceof User){
			user = (User) object;
		}
		CarEntity car=o.getCar();
		String dw=car.getDw();//档位名称
		if(dw !=null){//档位
			Collection<Condition> condition =  new ArrayList<Condition>();
			condition.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS,"stalls"));
			condition.add(ConditionUtils.getCondition("itemValue", Condition.EQUALS,dw));
			List<Codeitem> list = codeitemManager.getCodeitems(condition, null);
			if(list.size()>0){
				dw=list.get(0).getItemCaption();
			}
		}
		String zw=car.getZw();//座位名称
		if(zw !=null){//座位
			Collection<Condition> condition =  new ArrayList<Condition>();
			condition.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS,"seat"));
			condition.add(ConditionUtils.getCondition("itemValue", Condition.EQUALS,zw));
			List<Codeitem> list = codeitemManager.getCodeitems(condition, null);
			if(list.size()>0){
				zw=list.get(0).getItemCaption();
			}
		}
		
		String commodityId = o.getCommodityId();
		boolean isUpdate = StringUtils.isNotEmpty(commodityId);
		
		boolean dwFlag=true;
		boolean zwFlag=true;
		boolean chepaiFlag=true;
		List<PurchasingmanagerCommodityExtend> peList=new ArrayList<PurchasingmanagerCommodityExtend>();
		
    	if(isUpdate){//修改
    		PurchasingmanagerCommodity pc = purchasingmanagerCommodityDao.get(commodityId); 
    		pc.setCommodityTitle(o.getCommodityTitle());
    		pc.setCommodityPrice(o.getCommodityPrice());
    		pc.setGenreId(o.getGenreId());
    		pc.setPurchasingmanagerMerchant(o.getPurchasingmanagerMerchant());
    		pc.setCommodityImage(o.getCommodityImage());
    		pc.setCommodityCoverImage(o.getCommodityCoverImage());
    		pc.setCommodityDescribe(o.getCommodityDescribe());
    		pc.setUpdateUser(o.getUpdateUser());
    		pc.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o=purchasingmanagerCommodityDao.save(pc);
    		
    		// 根据商品ID获取商品扩展属性
    		List<PurchasingmanagerCommodityExtend> purExList = purchasingmanagerCommodityExtendManager.getCommodityExtList(commodityId);
    		if(purExList.size()>0){
    			for(PurchasingmanagerCommodityExtend pce:purExList){
    				if(car.getDwfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(dw);//保存车辆档位属性
    					dwFlag=false;
    				}else if(car.getZwfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(zw);//保存车辆座位属性
    					zwFlag=false;
    				}else if(car.getCpfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(car.getChepai());//保存车辆车牌属性
    					chepaiFlag=false;
    				}
    				pce.setUpdateUser(o.getUpdateUser());
    				pce.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    				peList.add(pce);
    			}
    			if(dwFlag){
	    			throw new BusException("请先添加车辆的档位属性");
	    		}else if(zwFlag){
	    			throw new BusException("请先添加车辆的座位属性");
	    		}else if(chepaiFlag){
	    			throw new BusException("请先添加车辆的车牌属性");
	    		}else{
	    			purchasingmanagerCommodityExtendDao.save(peList);//保存车辆扩展属性列表
	    		}
    		}else{
    			throw new BusException("请先添加车辆的全部扩展属性：档位、座位和车牌");
    		}
    	}else{//增加
    		
    		o=purchasingmanagerCommodityDao.save(o);
    		//获取车辆室扩展属性
    		String genreCode="0302";//车辆类别编号
    		List<PurchasingmanagerCommodityExtend> pceList=this.getPagerCommodityExtsByGenreId(genreCode);
    		if(pceList.size()>0){
    			for(PurchasingmanagerCommodityExtend pce:pceList){
    				if(car.getDwfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(dw);//保存车辆档位属性
    					dwFlag=false;
    				}else if(car.getZwfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(zw);//保存车辆座位属性
    					zwFlag=false;
    				}else if(car.getCpfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(car.getChepai());//保存车辆车牌属性
    					chepaiFlag=false;
    				}
    				/*PurchasingmanagerCommodity pc = new PurchasingmanagerCommodity();
    				pc.setCommodityId(o.getCommodityId());*/
    				pce.setCommodityId(o.getCommodityId());
    				pce.setCreateUser(user.getUserId());
    				pce.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    				pce.setUpdateUser(user.getUserId());
    				pce.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    				peList.add(pce);
    			}
    			if(dwFlag){
	    			throw new BusException("请先添加车辆的档位属性");
	    		}else if(zwFlag){
	    			throw new BusException("请先添加车辆的座位属性");
	    		}else if(chepaiFlag){
	    			throw new BusException("请先添加车辆的车牌属性");
	    		}else{
	    			purchasingmanagerCommodityExtendDao.save(peList);//保存车辆扩展属性列表
	    		}
    			
    		}else{
    			throw new BusException("请先添加车辆的全部扩展属性：档位、座位和车牌");
    		}
    	}
		
	}
	
	/**
     * 保存广告位及其车辆商品扩展属性
     * @param size 尺寸
     * @param unit 单位
     * @param loopType 轮播方式
     * @param o 商品实体
     * @throws BusException
     */
	@Override
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
	public void saveCommodityAndPropertyForLed(PurchasingmanagerCommodity o) {
		List<Record> listForCar=this.getRecordsByGenreCode("0303");//所属商户
		o.setGenreId(listForCar.size()>0?listForCar.get(0).get("genreId").toString():null);
		Billboard billboard = o.getBillboard();
		String commodityId = o.getCommodityId();
		boolean isUpdate = StringUtils.isNotEmpty(commodityId);
		
		boolean sizeFlag = true;
		boolean unitFlag = true;
		boolean loopTypeFlag = true;
		boolean adrFlag = true;
		List<PurchasingmanagerCommodityExtend> peList=new ArrayList<PurchasingmanagerCommodityExtend>();
		
    	if(isUpdate){//修改
    		PurchasingmanagerCommodity pc = purchasingmanagerCommodityDao.get(commodityId); 
    		pc.setCommodityTitle(o.getCommodityTitle());
    		pc.setCommodityPrice(o.getCommodityPrice());
    		pc.setGenreId(o.getGenreId());
    		pc.setPurchasingmanagerMerchant(o.getPurchasingmanagerMerchant());
    		pc.setCommodityImage(o.getCommodityImage());
    		pc.setCommodityCoverImage(o.getCommodityCoverImage());
    		pc.setCommodityDescribe(o.getCommodityDescribe());
    		pc.setUpdateUser(o.getUpdateUser());
    		pc.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o=purchasingmanagerCommodityDao.save(pc);
    		
    		
    		// 根据商品ID获取商品扩展属性
    		List<PurchasingmanagerCommodityExtend> purExList = purchasingmanagerCommodityExtendManager.getCommodityExtList(commodityId);
    		if(purExList.size()>0){
    			for(PurchasingmanagerCommodityExtend pce:purExList){
    				if(billboard.getSizefieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(billboard.getSize());//保存会议室地址属性
    					sizeFlag=false;
    				}else if(billboard.getUnitfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(billboard.getUnit());//保存会议室规模
    					unitFlag=false;
    				}else if(billboard.getLoopTypefieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(billboard.getLoopType());//保存会议室类型
    					loopTypeFlag=false;
    				}else if(billboard.getAdrfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(billboard.getAdr());//保存广告地址
    					adrFlag=false;
    				}
    				pce.setCommodityId(o.getCommodityId());
    				pce.setUpdateUser(o.getUpdateUser());
    				pce.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    				peList.add(pce);
    			}
    			if(sizeFlag){
	    			throw new BusException("请先添加广告位尺寸属性");
	    		}else if(unitFlag){
	    			throw new BusException("请先添加广告位单位属性");
	    		}else if(loopTypeFlag){
	    			throw new BusException("请先添加广告位轮播方式属性");
	    		}else if(adrFlag){
	    			throw new BusException("请先添加广告位地址属性");
	    		}else{
	    			purchasingmanagerCommodityExtendDao.save(peList);//保存广告位扩展属性列表
	    		}
    		}else{
    			throw new BusException("请先添加广告位的全部扩展属性：尺寸、单位、轮播方式和地址等");
    		}
    	}else{//新增
    		o=purchasingmanagerCommodityDao.save(o);
    		//获取会议室扩展属性
    		String genreCode="0303";//广告位类别编号
    		List<PurchasingmanagerCommodityExtend> pceList=this.getPagerCommodityExtsByGenreId(genreCode);
    		if(pceList.size()>0){
    			for(PurchasingmanagerCommodityExtend pce:pceList){
    				if(billboard.getSizefieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(billboard.getSize());//保存会议室地址属性
    					sizeFlag=false;
    				}else if(billboard.getUnitfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(billboard.getUnit());//保存会议室规模
    					unitFlag=false;
    				}else if(billboard.getLoopTypefieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(billboard.getLoopType());//保存会议室类型
    					loopTypeFlag=false;
    				}else if(billboard.getAdrfieldName().equals(pce.getPurchasingmanagerGenreProperty().getGenrePropertyFieldName())){
    					pce.setCommodityExtendContent(billboard.getAdr());//保存广告地址
    					adrFlag=false;
    				}
    				
    				PurchasingmanagerCommodity pc = new PurchasingmanagerCommodity();
    				pc.setCommodityId(o.getCommodityId());
    				pce.setCommodityId(o.getCommodityId());
    				pce.setCreateUser(o.getUpdateUser());
    				pce.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    				pce.setUpdateUser(o.getUpdateUser());
    				pce.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    				peList.add(pce);
    			}
    			if(sizeFlag){
	    			throw new BusException("请先添加广告位尺寸属性");
	    		}else if(unitFlag){
	    			throw new BusException("请先添加广告位单位属性");
	    		}else if(loopTypeFlag){
	    			throw new BusException("请先添加广告位轮播方式属性");
	    		}else if(adrFlag){
	    			throw new BusException("请先添加广告位地址属性");
	    		}else{
	    			purchasingmanagerCommodityExtendDao.save(peList);//保存广告位扩展属性列表
	    		}
    		}else{
    			throw new BusException("请先添加广告位的全部扩展属性：尺寸、单位、轮播方式和地址等");
    		}
    		
    	}
	}

	/**
	 * 根据商品类别ID获取相应的商品信息
	 */
	@EsbServiceMapping
	public List<PurchasingmanagerCommodity> getCommodityRecordsByGenreId(@ServiceParam(name="genreId") String genreId) throws BusException{
		List<PurchasingmanagerCommodity> list= purchasingmanagerCommodityDao.getList("purchasingmanagerGenre.genreId", genreId);
		return list;
	}

	/**
     * 获取工商变更类别的所有商品列表
     */
	@EsbServiceMapping
    public List<PurchasingmanagerCommodity> getComChangeCommodityList(@ServiceParam(name="userId",pubProperty="userId") String userId) throws BusException{
		List<PurchasingmanagerCommodity> list= purchasingmanagerCommodityDao.getList("purchasingmanagerGenre.genreCode", "0502");
		return list;
	}
	/**
     * 获取公司注册类别的所有商品列表
     */
	@EsbServiceMapping
    public List<PurchasingmanagerCommodity> getComReisterCommodityList(@ServiceParam(name="userId",pubProperty="userId") String userId) throws BusException{
		List<PurchasingmanagerCommodity> list= purchasingmanagerCommodityDao.getList("purchasingmanagerGenre.genreCode", "0501");
		return list;
	}
	/**
     * 获取代理记账类别的所有商品列表
     */
	@EsbServiceMapping
    public List<PurchasingmanagerCommodity> getAgencyCommodityList(@ServiceParam(name="userId",pubProperty="userId") String userId) throws BusException{
		List<PurchasingmanagerCommodity> list = purchasingmanagerCommodityDao.getList("purchasingmanagerGenre.genreCode", "0504");
		return list;
	}
	/**
     * 获取法律服务类别的所有商品列表
     */
	@EsbServiceMapping
    public List<PurchasingmanagerCommodity> getLawSerCommodityList(@ServiceParam(name="userId",pubProperty="userId") String userId) throws BusException{
		List<PurchasingmanagerCommodity> list= purchasingmanagerCommodityDao.getList("purchasingmanagerGenre.genreCode", "0505");
		return list;
	}
	/**
     * 获取商标专利类别的所有商品列表
     */
	@EsbServiceMapping
    public List<PurchasingmanagerCommodity> getChopPatentCommodityList(@ServiceParam(name="userId",pubProperty="userId") String userId) throws BusException{
		List<PurchasingmanagerCommodity> list= purchasingmanagerCommodityDao.getList("purchasingmanagerGenre.genreCode", "0506");
		return list;
	}
	
	 /**
     * 根据商品genreCode来获取商品类别
     */
	@EsbServiceMapping
	public List<Record> getRecordsByGenreCode(@ServiceParam(name="genreCode") String genreCode) throws BusException{
		List<Record> recordList=new ArrayList<Record>();
		Collection<Condition> conditions = new ArrayList<Condition>();
		conditions.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS, genreCode));
		// 查询属于会议室的商品：genreCode=0301
		List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(conditions, null);
		for(PurchasingmanagerGenre pg:purchasingmanagerGenreList){
			Record record = new Record();
			record.put("genreId", pg.getGenreId());
			record.put("genreName", pg.getGenreName());
			recordList.add(record);
		}
//		if(genreCode.equals("0301")){//0301:会议室
//			conditions.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS, genreCode));
//			// 查询属于会议室的商品：genreCode=0301
//			List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(conditions, null);
//			for(PurchasingmanagerGenre pg:purchasingmanagerGenreList){
//				Record record = new Record();
//				record.put("genreId", pg.getGenreId());
//				record.put("genreName", pg.getGenreName());
//				recordList.add(record);
//			}
//		}else if(genreCode.equals("0302")){//0302:车辆
//			conditions.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS, genreCode));
//			// 查询属于车辆的商品：genreCode=0302
//			List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(conditions, null);
//			for(PurchasingmanagerGenre pg:purchasingmanagerGenreList){
//				Record record = new Record();
//				record.put("genreId", pg.getGenreId());
//				record.put("genreName", pg.getGenreName());
//				recordList.add(record);
//			}
//		}else if(genreCode.equals("0303")){//0303:广告位
//			conditions.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS, genreCode));
//			// 查询属于广告的商品：genreCode=0303
//			List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(conditions, null);
//			for(PurchasingmanagerGenre pg:purchasingmanagerGenreList){
//				Record record = new Record();
//				record.put("genreId", pg.getGenreId());
//				record.put("genreName", pg.getGenreName());
//				recordList.add(record);
//			}
//		}else if(genreCode.equals("040101")){//040101:工位
//			conditions.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS, genreCode));
//			// 查询属于工位的商品：genreCode=0303
//			List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(conditions, null);
//			for(PurchasingmanagerGenre pg:purchasingmanagerGenreList){
//				Record record = new Record();
//				record.put("genreId", pg.getGenreId());
//				record.put("genreName", pg.getGenreName());
//				recordList.add(record);
//			}
//		}
		return recordList;
		
	}
}
