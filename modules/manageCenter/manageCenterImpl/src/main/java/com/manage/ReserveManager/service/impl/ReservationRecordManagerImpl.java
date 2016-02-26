/**
 * 代码声明
 */
package com.manage.ReserveManager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.BuildingBaseManager.dao.BbmRoomDao;
import com.common.BuildingBaseManager.entity.BbmRoom;
import com.common.BuildingBaseManager.service.BbmRoomManager;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityDao;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityExtendValueDao;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerCommodityExtendValue;
import com.common.purchasingManager.service.PurchasingmanagerCommodityExtendValueManager;
import com.common.purchasingManager.service.PurchasingmanagerCommodityManager;
import com.gsoft.framework.codemap.dao.CodeitemDao;
import com.gsoft.framework.codemap.entity.Codeitem;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntrec;
import com.manage.ReserveManager.entity.ReservationRecord;
import com.manage.ReserveManager.dao.ReservationRecordDao;
import com.manage.ReserveManager.service.ReservationRecordManager;

@Service("reservationRecordManager")
@Transactional
public class ReservationRecordManagerImpl extends BaseManagerImpl implements ReservationRecordManager{
	@Autowired
	private ReservationRecordDao reservationRecordDao;
	
	@Autowired
	private PurchasingmanagerCommodityDao purchasingmanagerCommodityDao;
	
	@Autowired
	private PurchasingmanagerCommodityExtendValueDao purchasingmanagerCommodityExtendValueDao;
	
	@Autowired
	private CodeitemDao<Codeitem, String> codeItemDao;
	
	@Autowired
	private BbmRoomDao bbmRoomDao;
	
	@Autowired
	private PurchasingmanagerCommodityManager purchasingmanagerCommodityManager;
	
	@Autowired
	private BbmRoomManager bbmRoomManager;
	
	@Autowired
	private PurchasingmanagerCommodityExtendValueManager purchasingmanagerCommodityExtendValueManager;
	
	
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
    @EsbServiceMapping
    public ReservationRecord saveReservationRecord(ReservationRecord o) throws BusException{
//    	String reservationRecordId = o.getReservationRecordId();
//    	boolean isUpdate = StringUtils.isNotEmpty(reservationRecordId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return reservationRecordDao.save(o);
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
     * 根据预约类型不同生成相应的招商预约记录
     */
    @EsbServiceMapping
    public ReservationRecord saveReservationRecordByType(ReservationRecord o,@ServiceParam(name="commodityId") String commodityId,@ServiceParam(name="roomId") String roomId) throws BusException{
//        if(o.getRecordType().equals("01")){//众创空间预约 
//        	//根据商品ID查询商品信息
//        	if(commodityId !=null){
//        		PurchasingmanagerCommodityExtendValue commodityValue=purchasingmanagerCommodityExtendValueDao.get(commodityId);
//        		o.setRecordMemberId(commodityValue.getCommodityExtendValueDisplayName());//预约对象ID
//        	}else{
//        		o.setRecordMemberId(null);//预约对象ID
//        	}
//        	
//        }else if(o.getRecordType().equals("02")){//虚拟空间预约
//        	//根据单元ID查询单元基础信息
//        	if(roomId != null){
//        	    BbmRoom bbmRoom=bbmRoomDao.get(roomId);
//        	    o.setRecordMemberId(bbmRoom.getRoomName());
//        	}else{
//        		o.setRecordMemberId(null);//预约对象ID
//        	}
//        }else{//其他
//        	List<Codeitem> list = codeItemDao.getList(new String[] {"codemap.code", "itemValue" }, new Object[] {
//					"recordType", o.getRecordType()});// 预约类型
//        	o.setRecordMemberId(list.get(0).getItemCaption());
//        }
    	o.setRecordStatus("01");//已预约
    	return reservationRecordDao.save(o);
    }
    
	/**
	 * 变更状态:已预约-->已授理
	 * */
	@EsbServiceMapping
	public void changeReservationRecordByStatus(ReservationRecord o) throws BusException {
		o.setRecordStatus("02");//已授理
		reservationRecordDao.save(o);
	}
    
    /**
     * 根据预约类型不同生成相应的招商预约记录
     */
	@EsbServiceMapping
    public List<Record> getRecordsByRecordType(
       @ServiceParam(name="recordType") String recordType) throws BusException{
    	List<Record> recordList=new ArrayList<Record>();
    	   if(recordType.equals("01")){//01:众创空间，查询商品表基础信息
    		   List<PurchasingmanagerCommodity> purchasingmanagerCommodityList=purchasingmanagerCommodityManager.getPurchasingmanagerCommoditys();
    		   for(PurchasingmanagerCommodity p:purchasingmanagerCommodityList){
    			   //根据商品id实体查询商品扩展属性值表
    			    Collection<Condition> conditions = new ArrayList<Condition>();
    			    Collection<Order> orders = new ArrayList<Order>();
    				conditions.add(ConditionUtils.getCondition("purchasingmanagerCommodity", Condition.EQUALS,
    						p));
    			   List<PurchasingmanagerCommodityExtendValue> commodityExtendValueList=purchasingmanagerCommodityExtendValueManager.getPurchasingmanagerCommodityExtendValues(conditions, orders);
    			   
    			   for(PurchasingmanagerCommodityExtendValue value:commodityExtendValueList){
    				   Record record = new Record();
    				   record.put("commodityId", value.getCommodityExtendValueId());
        			   record.put("commodityName", value.getCommodityExtendValueDisplayContent());
        			   recordList.add(record);
    			   }
    			   
    		   }
    		  
    	   }else if(recordType.equals("02")){//02:虚拟空间，查询单元表基础信息
    		   List<BbmRoom> bbmRoomsList=bbmRoomManager.getBbmRooms();
    		   for(BbmRoom b:bbmRoomsList){
    			   Record record = new Record();
    			   record.put("commodityId", b.getRoomId());
    			   record.put("commodityName", b.getRoomNo());
    			   recordList.add(record);
    		   }
    	   }else{
    		   List<Codeitem> list = codeItemDao.getList(new String[] {"codemap.code", "itemValue" }, new Object[] {
   					"recordType", recordType});// 预约类型
               Record record = new Record();
 			   record.put("commodityId", list.get(0).getItemCaption());
 			   record.put("commodityName", list.get(0).getItemCaption());
 			   recordList.add(record);
    	   }
        	return recordList;
        }

}
