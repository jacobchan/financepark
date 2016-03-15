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

import com.common.BuildingBaseManager.dao.BbmRoomDao;
import com.common.BuildingBaseManager.service.BbmRoomManager;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityDao;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.service.PurchasingmanagerCommodityManager;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;
import com.gsoft.framework.codemap.dao.CodeitemDao;
import com.gsoft.framework.codemap.entity.Codeitem;
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
	
//	@Autowired
//	private PurchasingmanagerCommodityExtendValueDao purchasingmanagerCommodityExtendValueDao;
	
	@Autowired
	private CodeitemDao<Codeitem, String> codeItemDao;
	
	@Autowired
	private BbmRoomDao bbmRoomDao;
	
	@Autowired
	private PurchasingmanagerCommodityManager purchasingmanagerCommodityManager;
	
	@Autowired
	private BbmRoomManager bbmRoomManager;
	
	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	
	
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
	
	@EsbServiceMapping
	public PagerRecords getPagerReservationRecords(Pager pager,//分页条件
			@ConditionCollection(domainClazz=ReservationRecord.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = reservationRecordDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public ReservationRecord saveReservationRecord(ReservationRecord o) throws BusException{
    	String recordId = o.getRecordId();
    	boolean isUpdate = StringUtils.isNotEmpty(recordId);
    	if(isUpdate){//修改
    		ReservationRecord r=reservationRecordDao.get(recordId);
    		r.setRecordMemberId(o.getRecordMemberId());
    		r.setRecordType(o.getRecordType());
    		r.setVisiteDate(o.getVisiteDate());
    		r.setUpdateUser(o.getUpdateUser());
    		r.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return reservationRecordDao.save(r);
    	}else{//新增
    		o.setRecordStatus("01");//待受理
        	o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return reservationRecordDao.save(o);
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
     * 根据众创空间下的商品类别下所有的商品 genreCode=04:众创空间
     */
	@EsbServiceMapping
	public List<PurchasingmanagerCommodity> getCommodityByGenreType(@ServiceParam(name="genreCode") String genreCode) throws BusException{
		List<PurchasingmanagerCommodity> recordList=new ArrayList<PurchasingmanagerCommodity>();
		Collection<Condition> conditions = new ArrayList<Condition>();
		Collection<Condition> condition = new ArrayList<Condition>();
		Collection<Condition> conditionC = new ArrayList<Condition>();
		
		if(genreCode.equals("04")){//04:众创空间，查询商品表基础信息
			conditions.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS, "04"));
			// 查询属于众创空间的商品：genreCode=04
			List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(conditions, null);
			String genreId="";
			if(purchasingmanagerGenreList.size()>0){
				genreId = purchasingmanagerGenreList.get(0).getGenreId();
			}
			if(StringUtils.isNotEmpty(genreId)){
				// 查询众创空间下包含的商品类别
				condition.add(ConditionUtils.getCondition("purchasingmanagerGenre.genreId",Condition.EQUALS,genreId));
				List<PurchasingmanagerGenre> pgList = purchasingmanagerGenreManager.getPurchasingmanagerGenres(condition, null);
				for(PurchasingmanagerGenre pg:pgList){
					String grId=pg.getGenreId();
					conditionC.add(ConditionUtils.getCondition("purchasingmanagerGenre.genreId",Condition.EQUALS,grId));
					List<PurchasingmanagerCommodity> pcList = purchasingmanagerCommodityManager.getPurchasingmanagerCommoditys(conditionC, null);
					for(PurchasingmanagerCommodity pc:pcList){
						recordList.add(pc);
					}
				}
			}
		}
		return recordList;
	}
    
    /**
     * 根据众创空间下的商品类别 genreCode=04:众创空间
     */
	@EsbServiceMapping
	public List<Record> getRecordsByRecordType(@ServiceParam(name="recordType") String recordType) throws BusException{
		List<Record> recordList=new ArrayList<Record>();
		Collection<Condition> conditions = new ArrayList<Condition>();
		Collection<Condition> condition = new ArrayList<Condition>();
		
		if(recordType.equals("04")){//04:众创空间，查询商品表基础信息
			conditions.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS, "04"));
			// 查询属于众创空间的商品：genreCode=04
			List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(conditions, null);
			String genreId="";
			if(purchasingmanagerGenreList.size()>0){
				genreId = purchasingmanagerGenreList.get(0).getGenreId();
			}
			if(StringUtils.isNotEmpty(genreId)){
				// 查询众创空间下包含的商品类别
				condition.add(ConditionUtils.getCondition("purchasingmanagerGenre.genreId",Condition.EQUALS,genreId));
				List<PurchasingmanagerGenre> pgList = purchasingmanagerGenreManager.getPurchasingmanagerGenres(condition, null);
				for(PurchasingmanagerGenre pg:pgList){
					Record record = new Record();
					record.put("itemValue", pg.getGenreId());
					record.put("itemName", pg.getGenreName());
					recordList.add(record);
				}
			}
		}
		return recordList;
	}
	
	
	/**
	 * 取消预约申请，将待受理状态变更为已取消
	 * @param ReservationRecord
	 */
    @EsbServiceMapping
	 public void cancelReservation(ReservationRecord o) throws BusException{
    	ReservationRecord p=new ReservationRecord();
		String recordId=o.getRecordId();
		if(StringUtils.isNotEmpty(recordId)){
			p=reservationRecordDao.get(recordId);//根据主键查询预约记录基础数据
		}
		p.setRecordStatus("04");//已取消
		p.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		reservationRecordDao.save(p);
    }
    
    /**
     * 根据当前登录用户预约
     */
    @EsbServiceMapping
	public List<ReservationRecord> getReservationRecordsforpage(
			@ServiceParam(name="userId",pubProperty = "userId") String userId) throws BusException {
		// TODO Auto-generated method stub
    	//获取当前用户预约
    	Collection<Condition> condition = new ArrayList<Condition>();
    	condition.add(ConditionUtils.getCondition("createUser", Condition.EQUALS, userId));
    	List<ReservationRecord> list =reservationRecordDao.commonQuery(condition, null);
		return list;
	}

}
