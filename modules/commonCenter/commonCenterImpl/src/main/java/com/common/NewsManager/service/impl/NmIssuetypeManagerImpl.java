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
import com.gsoft.framework.util.ConditionUtils;
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
	
	@EsbServiceMapping
	public PagerRecords getPagerNmIssuetypesByCode(Pager pager,
			@ConditionCollection(domainClazz=NmIssuetype.class) Collection<Condition> conditions, 
			@OrderCollection Collection<Order> orders,
			@ServiceParam(name="code") String code) throws BusException {
		List<NmIssuetype> list = this.getNewsType(code);
		String str[] = new String[list.size()+1] ;
		str[0] = code ;
		for(int i=0;i<list.size();i++){
			str[i+1] = list.get(i).getIssueTypeCode() ;
		}
		conditions.add(ConditionUtils.getCondition("issueTypeCode", Condition.IN,str));
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
        
        //编码唯一判断
        boolean hasCode = nmIssuetypeDao.exists("issueTypeCode", o.getIssueTypeCode());
        if(hasCode){
        	NmIssuetype IssueType = nmIssuetypeDao.getObjectByUniqueProperty("issueTypeCode", o.getIssueTypeCode());
        	if(!isUpdate){
        		throw new BusException("类型编码已经存在");
        	}
        	if(!issueTypeId.equals(IssueType.getIssueTypeId())){
        		throw new BusException("类型编码已经存在");
        	}
        }

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
	public List<NmIssuetype> getChildren(@ServiceParam(name="issueTypeId") String parentId)
			throws BusException {
	    List<NmIssuetype> children ;
	    if (StringUtils.isEmpty(parentId)) {
	      Collection<Condition> conditions = new ArrayList<Condition>();
	      conditions.add(ConditionFactory.getInstance().getCondition("parentIssueTypeId", "IS_NULL", null));
	      children = this.nmIssuetypeDao.commonQuery(conditions, null);
	    } else {
	      children = this.nmIssuetypeDao.getList("parentIssueTypeId", parentId);
	    }
		return children;
	}
    
    @EsbServiceMapping
	public String codeExist(@ServiceParam(name="issueTypeCode") String code) throws BusException {
		boolean exist = nmIssuetypeDao.exists("issueTypeCode", code);
		if(exist){
	//		return "编码已经存在";
			throw new BusException("编码已经存在");
		}else{
			return null;
		}
	}
    /**
     * 得到政策新闻的所有的子类型通过issueTypeCode
     * 若没有子类型，则返回当前类型
     * @return
     */
    @EsbServiceMapping
    public List<NmIssuetype> getNewsType(@ServiceParam(name="issueTypeCode") String issueTypeCode) {
    	NmIssuetype type = nmIssuetypeDao.getObjectByUniqueProperty("issueTypeCode", issueTypeCode) ;//01为新闻公告类型,02为优惠政策
		String typeId = type.getIssueTypeId() ;//得到新闻公告ID
		Collection<Condition> condition =  new ArrayList<Condition>();
		condition.add(ConditionUtils.getCondition("parentIssueTypeId", Condition.EQUALS,typeId));
		List<NmIssuetype> list = this.getNmIssuetypes(condition, null) ;//得到上级发布类型ID为typeId的所有发布类型
		if(list.size()>0){
			return list;
		}else{
			list.add(type) ;
			return list ;
		}
    }
    
    /**
     * 通过政策发布类型code得到当前政策
     * @param issueTypeCode 政策发布类型code
     * @return
     */
    @EsbServiceMapping
    public NmIssuetype getIssueTypeByIssueTypeCode(String issueTypeCode) {
    	NmIssuetype type = nmIssuetypeDao.getObjectByUniqueProperty("issueTypeCode", issueTypeCode) ;//得到政策发布类型
    	return type;
    }
}
