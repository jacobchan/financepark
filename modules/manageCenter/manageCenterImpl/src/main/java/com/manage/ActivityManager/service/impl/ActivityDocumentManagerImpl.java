/**
 * 代码声明
 */
package com.manage.ActivityManager.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.upload.entity.FileStore;
import com.gsoft.framework.upload.service.FileStoreManager;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.utils.DocConverter;
import com.manage.ActivityManager.entity.ActivityApply;
import com.manage.ActivityManager.entity.ActivityDocument;
import com.manage.ActivityManager.dao.ActivityDocumentDao;
import com.manage.ActivityManager.service.ActivityApplyManager;
import com.manage.ActivityManager.service.ActivityDocumentManager;

@Service("activityDocumentManager")
@Transactional
public class ActivityDocumentManagerImpl extends BaseManagerImpl implements ActivityDocumentManager{
	@Autowired
	private ActivityDocumentDao activityDocumentDao;
	@Autowired
	private FileStoreManager fileStoreManager;
	@Value("#{configProperties['file.root.path']}")
	private String root;
	@Autowired
	private ActivityApplyManager activityApplyManager;
    @Value("#{configProperties['openPathwin']}")
	private String openPathwin;
    @Value("#{configProperties['openPathlnx']}")
	private String openPathlnx;
    @Value("#{configProperties['swfPathwin']}")
	private String swfPathwin;
    @Value("#{configProperties['swfPathlnx']}")
	private String swfPathlnx;
     
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<ActivityDocument> getActivityDocuments() throws BusException{
    	return activityDocumentDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<ActivityDocument> getActivityDocuments(
    	@ConditionCollection(domainClazz=ActivityDocument.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return activityDocumentDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public ActivityDocument getActivityDocument(@ServiceParam(name="documentId") String id)  throws BusException{
    	return activityDocumentDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerActivityDocuments(Pager pager,//分页条件
			@ConditionCollection(domainClazz=ActivityDocument.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = activityDocumentDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public ActivityDocument saveActivityDocument(ActivityDocument o) throws BusException{
    	String activityDocumentId = o.getDocumentId();
    	boolean isUpdate = StringUtils.isNotEmpty(activityDocumentId);
    	if(o.getDocumentPath()!=null){
        	FileStore fs=fileStoreManager.getFileStoreByPath(o.getDocumentPath());
        	o.setDocumentName(fs.getUploadFileName());	
    	}
    	if(isUpdate){//修改
    		o.setUpdateUser(o.getUpdateUser());
        	o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	}else{//新增
    		o.setCreateUser(o.getUpdateUser());
        	o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
        	o.setUpdateUser(o.getUpdateUser());
        	o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	}
    	return activityDocumentDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeActivityDocument(@ServiceParam(name="documentId") String id) throws BusException{
    	//同时文档数减一
    	ActivityDocument document = activityDocumentDao.get(id);
    	ActivityApply apply = document.getActivityApply();
    	int count = apply.getDocumentCount();
    	if(count>0){
    		apply.setDocumentCount(count-1);
    		activityApplyManager.saveActivityApply(apply);
    	}
    	activityDocumentDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeActivityDocuments(@ServiceParam(name="documentId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeActivityDocument(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitActivityDocument(@ServiceParam(name="documentId") String id)  throws BusException{
		return activityDocumentDao.exists(id);
	}
    
    public boolean exsitActivityDocument(String propertyName,Object value) throws BusException{
		return activityDocumentDao.exists(propertyName,value);
	}
    
    @EsbServiceMapping
	public String getViewDocument(@ServiceParam(name="documentId") String id) throws BusException {
		// TODO Auto-generated method stub
    	ActivityDocument ad=activityDocumentDao.get(id);
    	FileStore fs=fileStoreManager.getFileStoreByPath(ad.getDocumentPath());
    	String filePath=fs.getFilePath();
    	String fileName = filePath .substring(0,filePath .lastIndexOf("."));
    	DocConverter.getSwfPath(root+filePath,openPathwin,openPathlnx,swfPathwin,swfPathlnx);
    	String swfPath=fileName+".swf";
    	return swfPath;
	
    }
    
    /**
     * 保存活动文档列表
     * @param o
     */
	@EsbServiceMapping
	public void saveActivityDocumentList(ActivityDocument o) {
		String applyId =  o.getActivityApply().getApplyId();
		ActivityApply apply = activityApplyManager.getActivityApply(applyId);
    	int count = apply.getDocumentCount();
    	if(count<=0){//未添加过文档
			String path = o.getDocumentPath() ;
				if(StringUtils.isNotEmpty(path)){
					String[] paths = path.split(",") ;
					count = paths.length;
					for(String tPath : paths){
						ActivityDocument document = new ActivityDocument() ;
						document.setActivityApply(apply);
						document.setDocumentPath(tPath);
						this.saveActivityDocument(document) ;
					}
				}
    	}else{
    		String edpath = o.getDocumentPath() ;
    		if(StringUtils.isNotEmpty(edpath)){
    			String[] edpaths = edpath.split(",") ;
	    		if(StringUtils.isNotEmpty(o.getDocumentId())){//编辑已编辑文档
	    			this.removeActivityDocument(o.getDocumentId());
	    			count = count -1;
	    		}//再次添加文档
				count = count+edpaths.length;
				for(String tPath : edpaths){
					ActivityDocument document = new ActivityDocument() ;	
					document.setActivityApply(apply);
					document.setDocumentPath(tPath);
					this.saveActivityDocument(document) ;
				}
    		}
    	}
    	apply.setDocumentCount(count);
    	activityApplyManager.saveActivityApply(apply);
	}

}
