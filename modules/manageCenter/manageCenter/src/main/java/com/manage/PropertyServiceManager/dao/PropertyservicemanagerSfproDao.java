/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao;

import java.math.BigDecimal;

import com.gsoft.framework.core.dao.Dao;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerCharge;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerSfpro;

public interface PropertyservicemanagerSfproDao extends Dao<PropertyservicemanagerSfpro, String>  {
	/**
     * 根据收费登记获取收费登记项目金额总和
     */
	public BigDecimal getChargeAmountByCharge(PropertyservicemanagerCharge pc);
	
}