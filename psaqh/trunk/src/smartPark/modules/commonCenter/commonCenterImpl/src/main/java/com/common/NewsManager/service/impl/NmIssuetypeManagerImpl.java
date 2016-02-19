/**
 * 代码声明
 */
package com.common.NewsManager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.ConditionFactory;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.common.NewsManager.entity.NmIssuetype;
import com.common.NewsManager.dao.NmIssuetypeDao;
import com.common.NewsManager.service.NmIssuetypeManager;

@Service("nmIssuetypeManager")
@Transactional
public class NmIssuetypeManagerImpl extends BaseManagerImpl implements NmIssuetypeManager{
	@Autowired
	private NmIssuetypeDao nmIssuetypeDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<NmIssuetype> getNmIssuetypes() throws BusException{
    	return nmIssuetypeDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<NmIssuetype> getNmIssuetypes(
    	@ConditionCollection(domainClazz=NmIssuetype.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return nmIssuetypeDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public NmIssuetype getNmIssuetype(@ServiceParam(name="issueTypeId") String id)  throws BusException{
    	return nmIssuetypeDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerNmIssuetypes(Pager pager,//分页条件
			@ConditionCollection(domainClazz=NmIssuetype.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = nmIssuetypeDao.findByPager(pager, conditions, orders);
		List<NmIssuetype> nmIssuetypes = pagerRecords.getRecords();
		for(NmIssuetype nmIssuetype:nmIssuetypes){
			String issueTypeParentCaption = null;
			if(StringUtils.isNotEmpty(nmIssuetype.getParentIssueTypeId())){
				NmIssuetype issueType = nmIssuetypeDao.get(nmIssuetype.getParentIssueTypeId());
				issueTypeParentCaption = issueType.getIssueTypeCaption();
			}
			nmIssuetype.setIssueTypeParentCaption(issueTypeParentCaption);
		}
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public NmIssuetype saveNmIssuetype(NmIssuetype o) throws BusException{
        String issueTypeId = o.getIssueTypeId();
        boolean isUpdate = StringUtils.isNotEmpty(issueTypeId);

        if (!isUpdate)
        {
          o.setLeaf("1");

          String parentIssueTypeId = o.getParentIssueTypeId();
          String pIssueTypePath = "";
          if (StringUtils.isNotEmpty(parentIssueTypeId)) {
        	NmIssuetype parentAgency = getNmIssuetype(parentIssueTypeId);
        	pIssueTypePath = parentAgency.getIssueTypePath();

            if ("1".equals(parentAgency.getLeaf())) {
              parentAgency.setLeaf("0");
              this.nmIssuetypeDao.save(parentAgency);
            }
          }

          String issueType = "/" + o.getIssueTypeCode();
          if (StringUtils.isNotEmpty(pIssueTypePath)) {
            issueType = pIssueTypePath = issueType;
          }
          o.setIssueTypePath(issueType);
        }

    	return nmIssuetypeDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeNmIssuetype(@ServiceParam(name="issueTypeId") String id) throws BusException{
    	List<NmIssuetype> nmIssuetypes = nmIssuetypeDao.getList("parentIssueTypeId", id);
    	if(nmIssuetypes!=null&&nmIssuetypes.size()>0){//当前类型是其他类型的父类，即被引用了 不能删除
    		throw new BusException("该类型被引用");
    	}
    	nmIssuetypeDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeNmIssuetypes(@ServiceParam(name="issueTypeId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeNmIssuetype(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitNmIssuetype(@ServiceParam(name="issueTypeId") String id)  throws BusException{
		return nmIssuetypeDao.exists(id);
	}
    
    public boolean exsitNmIssuetype(String propertyName,Object value) throws BusException{
		return nmIssuetypeDao.exists(propertyName,value);
	}
    @EsbServiceMapping
	@Override
	public List<NmIssuetype> getChildren(@ServiceParam(name="issueTypeId") String parentId)
			throws BusException {
	    List<NmIssuetype> children ;
	    if (StringUtils.isEmpty(parentId)) {
	      Collection<Condition> conditions = new ArrayList<Condition>();
	      conditions.add(ConditionFactory.getInstance().getCondition("parentIssueTypeId", "IS_NULL", null));
	      children = this.nmIssuetypeDao.commonQuery(conditions, null);
	    } else {
	      children = this.nmIssuetypeDao.getList("parentAgencyId", parentId);
	    }
		return children;
	}

}
