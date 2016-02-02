/**
 * 代码声明
 */
package com.manage.ReserveManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.ReserveManager.entity.ReservationRecord;
import com.manage.ReserveManager.dao.ReservationRecordDao;

@Repository("ReservationRecordDao")
public class ReservationRecordDaoHibernate extends 
		BaseDaoHibernate<ReservationRecord, String> implements ReservationRecordDao{
	public Class<ReservationRecord> getModelClazz(){
		return ReservationRecord.class;
	}
}