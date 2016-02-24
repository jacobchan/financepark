/**
 * 代码声明
 */
package com.manage.ActivityManager.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;

import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.upload.entity.FileStore;
import com.gsoft.framework.upload.service.FileStoreManager;

import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.utils.DocConverter;

import com.manage.ActivityManager.entity.ActivityDocument;
import com.manage.ActivityManager.dao.ActivityDocumentDao;
import com.manage.ActivityManager.service.ActivityDocumentManager;

@Service("activityDocumentManager")
@Transactional
public class ActivityDocumentManagerImpl extends BaseManagerImpl implements ActivityDocumentManager{
	@Autowired
	private ActivityDocumentDao activityDocumentDao;
	@Autowired
	private FileStoreManager fileStoreManager;

     
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
    @EsbServiceMapping
    public ActivityDocument saveActivityDocument(ActivityDocument o) throws BusException{
//    	String activityDocumentId = o.getActivityDocumentId();
//    	boolean isUpdate = StringUtils.isNotEmpty(activityDocumentId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	FileStore fs=fileStoreManager.getFileStoreByPath(o.getDocumentPath());
    	o.setDocumentName(fs.getUploadFileName());
    	return activityDocumentDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeActivityDocument(@ServiceParam(name="documentId") String id) throws BusException{
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
    	File file = new File(filePath); 
    	String getFilename = file.getName();
    	String parent=file.getParent();
    	String fileName = getFilename .substring(0,getFilename .lastIndexOf("."));
    	DocConverter.getSwfPath("src/main/webapp/upload/"+filePath);
    	String swfPath="upload/"+parent+"/"+fileName+".swf";
    	return swfPath;
	
    }

}
