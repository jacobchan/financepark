package com.common.EnterpriceTypeManager.dao;
import java.util.List;
import com.gsoft.framework.core.dao.Dao;
import com.common.EnterpriceTypeManager.entity.EtypeEnterprisetype;
public interface EtypeEnterprisetypeDao extends Dao<EtypeEnterprisetype, String>  {
	/**
	 * 获取所有的pId为空的企业类型
	 * @return
	 */
	public List<EtypeEnterprisetype> getEtypeEnterprisetypeList();
	/**
	 * 获取子级企业类型
	 * @return
	 */
	public List<EtypeEnterprisetype> getSubEnterpriseTypeList();
}