/**
 * 代码声明
 */
package com.common.NewsManager.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.NewsManager.dao.NmIssueflowDao;
import com.common.NewsManager.dao.NmIssuetypeDao;
import com.common.NewsManager.entity.NmIssueflow;
import com.common.NewsManager.entity.NmIssuetype;
import com.common.NewsManager.service.NmIssueflowManager;
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

@Service("nmIssueflowManager")
@Transactional
public class NmIssueflowManagerImpl extends BaseManagerImpl implements NmIssueflowManager{
	@Autowired
	private NmIssueflowDao nmIssueflowDao;
	@Autowired
	private NmIssuetypeDao nmIssuetypeDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<NmIssueflow> getNmIssueflows() throws BusException{
    	return nmIssueflowDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<NmIssueflow> getNmIssueflows(
    	@ConditionCollection(domainClazz=NmIssueflow.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return nmIssueflowDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public NmIssueflow getNmIssueflow(@ServiceParam(name="issueFlowId") String id)  throws BusException{
    	return nmIssueflowDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerNmIssueflows(Pager pager,//分页条件
			@ConditionCollection(domainClazz=NmIssueflow.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = nmIssueflowDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public NmIssueflow saveNmIssueflow(NmIssueflow o) throws BusException{
    	String nmIssueflowId = o.getIssueFlowId();
    	boolean isUpdate = StringUtils.isNotEmpty(nmIssueflowId);
    	
    	NmIssuetype issueType = o.getNmIssuetype();//发布类型
    	if(isUpdate){//修改
    		//当前状态不能重复
    		List<NmIssueflow> issueflows = nmIssueflowDao.getList(new String[]{"issueFlowCStatus","nmIssuetype.issueTypeId"}, new String[]{o.getIssueFlowCStatus(),issueType.getIssueTypeId()});
    		if(issueflows!=null&&issueflows.size()==1){
    			NmIssueflow issueflow = issueflows.get(0);
    			if(!nmIssueflowId.equals(issueflow.getIssueFlowId())){
    				throw new BusException("该状态已经使用");
    			}
    		}
    	}else{//新增
    		String currentStatus = o.getIssueFlowCStatus();
    		List<NmIssueflow> issueflows = nmIssueflowDao.getList(new String[]{"issueFlowCStatus","nmIssuetype.issueTypeId"}, new String[]{currentStatus,issueType.getIssueTypeId()});
    		if(issueflows!=null&&issueflows.size()>0){
    			throw new BusException("当前状态已存在");
    		}
    	}
    	//每一个当前状态只能是某一个状态的上步状态
		String lastStatus = o.getIssueFlowNStatus();//上步状态
		if(StringUtils.isEmpty(lastStatus)){
    		Collection<Condition> conditions = new ArrayList<Condition>();
    		conditions.add(ConditionUtils.getCondition("issueFlowNStatus", Condition.IS_NULL, null));
    		conditions.add(ConditionUtils.getCondition("nmIssuetype.issueTypeId", Condition.EQUALS, issueType.getIssueTypeId()));
    		conditions.add(ConditionUtils.getCondition("nmIssueflowId", Condition.NOT_EQUALS, nmIssueflowId));//
    		List<NmIssueflow> nmIssueflows = nmIssueflowDao.commonQuery(conditions, null);
    		if(nmIssueflows!=null&&nmIssueflows.size()>0){//只能有一个上步状态为空
    			throw new BusException("上步状态不能为空");
    		}
		}else{
			Collection<Condition> conditions = new ArrayList<Condition>();
			conditions.add(ConditionUtils.getCondition("nmIssuetype.issueTypeId", Condition.EQUALS, issueType.getIssueTypeId()));
    		conditions.add(ConditionUtils.getCondition("issueFlowNStatus", Condition.EQUALS, lastStatus));
    		conditions.add(ConditionUtils.getCondition("nmIssueflowId", Condition.NOT_EQUALS, nmIssueflowId));//
    		List<NmIssueflow> nmIssueflows = nmIssueflowDao.commonQuery(conditions, null);
    		if(nmIssueflows!=null&&nmIssueflows.size()>0){//只能有一个上步状态为空
    			throw new BusException("所选上步状态已被使用");
    		}
		}
    	return nmIssueflowDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeNmIssueflow(@ServiceParam(name="issueFlowId") String id) throws BusException{
    	nmIssueflowDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeNmIssueflows(@ServiceParam(name="issueFlowId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeNmIssueflow(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitNmIssueflow(@ServiceParam(name="issueFlowId") String id)  throws BusException{
		return nmIssueflowDao.exists(id);
	}
    
    public boolean exsitNmIssueflow(String propertyName,Object value) throws BusException{
		return nmIssueflowDao.exists(propertyName,value);
	}
	
    @EsbServiceMapping
	public void saveNmIssueflows(List<NmIssueflow> nmIssueflows)
			throws BusException {
			if(nmIssueflows!=null){
				for(NmIssueflow nmIssueflow:nmIssueflows ){
					saveNmIssueflow(nmIssueflow);
				}
			}
	}
    
    @EsbServiceMapping
	public PagerRecords getPagerNmIssueflowByType(Pager pager,
			NmIssuetype nmIssuetype, @OrderCollection Collection<Order> orders) throws BusException {
      Collection<Condition> conditions = new ArrayList<Condition>();
      conditions.add(ConditionUtils.getCondition("nmIssuetype.issueTypeId", Condition.EQUALS, nmIssuetype.getIssueTypeId()));

      return this.nmIssueflowDao.findByPager(pager, conditions, orders);
	}
    
    @EsbServiceMapping
	public String getStartStatus(@ServiceParam(name="nmIssuetypeId") String  nmIssuetypeId) throws BusException {
		List<NmIssueflow> nmIssueflows = getNmIssueflows(nmIssuetypeId);
		if(nmIssueflows!=null){
			for(NmIssueflow nmIssueflow:nmIssueflows){
				if(StringUtils.isEmpty(nmIssueflow.getIssueFlowNStatus())){
					return nmIssueflow.getIssueFlowCStatus();
				}
			}
		}
		return null;
	}
    
    @EsbServiceMapping
	public String getNextStatus(@ServiceParam(name="nmIssuetypeId") String  nmIssuetypeId,@ServiceParam(name="status") String currentStatus)
			throws BusException {
		List<NmIssueflow> nmIssueflows = getNmIssueflows(nmIssuetypeId);
		if(nmIssueflows!=null){
			for(NmIssueflow nmIssueflow:nmIssueflows){
				if(currentStatus.equals(nmIssueflow.getIssueFlowCStatus())){
					return nmIssueflow.getIssueFlowCStatus();
				}
			}
		}
		return null;
	}

    private List<NmIssueflow> getNmIssueflows(String  nmIssuetypeId){
    	if(StringUtils.isNotEmpty(nmIssuetypeId)){
			NmIssuetype issueType = nmIssuetypeDao.get(nmIssuetypeId);
			List<NmIssueflow> nmIssueflows = nmIssueflowDao.getList("nmIssuetype.issueTypeId", issueType.getIssueTypeId());
			return nmIssueflows;
    	}
    	return null;
    }
    
	@Override
	public String getOperateByStatus(String nmIssuetypeId,String status) throws BusException {
			List<NmIssueflow> nmIssueflows = nmIssueflowDao.getList("nmIssuetype.issueTypeId", nmIssuetypeId);
			if(nmIssueflows!=null&&nmIssueflows.size()>0){
				for(NmIssueflow nmIssueflow:nmIssueflows){
					if(status.equals(nmIssueflow.getIssueFlowCStatus())){
						return nmIssueflow.getIssueOperate();//当前操作
					}
				}
			}
		return null;
	}
	
	@Override
	public boolean isFinally(String nmIssuetypeId, String currentStatus)
			throws BusException {
		Collection<Condition> condition = new ArrayList<Condition>();
		condition.add(ConditionUtils.getCondition("nmIssuetype.issueTypeId", Condition.EQUALS, nmIssuetypeId));
		condition.add(ConditionUtils.getCondition("issueFlowNStatus", Condition.EQUALS, currentStatus));
		List<NmIssueflow> nmIssueflows =  nmIssueflowDao.commonQuery(condition, null);
		if(nmIssueflows!=null&&nmIssueflows.size()>0){
			return false;
		}else
			return true;
	}
	
	@Override
	public List<NmIssueflow> getNmIssueflowsWithTypeid(String issueTypeId,String[] properties,String[] values) throws BusException {
		Collection<Condition> conditions = new ArrayList<Condition>();
		conditions.add(ConditionUtils.getCondition("nmIssuetype.issueTypeId", Condition.EQUALS, issueTypeId));
		if(properties!=null&&values!=null){//length必须相等,且对应关系不能错
			int i = 0;
			for(String property:properties){
				conditions.add(ConditionUtils.getCondition(property, Condition.EQUALS, values[i]));
				i++;
			}
			return nmIssueflowDao.commonQuery(conditions, null);
		}
		return null;
	}
    
}
