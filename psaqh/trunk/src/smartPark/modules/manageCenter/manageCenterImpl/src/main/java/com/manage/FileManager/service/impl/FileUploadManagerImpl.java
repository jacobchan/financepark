/**
 * 代码声明
 */
package com.manage.FileManager.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.gsoft.framework.upload.entity.FileStore;
import com.gsoft.framework.upload.service.FileStoreManager;
import com.gsoft.utils.DocConverter;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.manage.FileManager.dao.FileUploadDao;
import com.manage.FileManager.entity.FileUpload;
import com.manage.FileManager.service.FileUploadManager;

@Service("fileUploadManager")
@Transactional
public class FileUploadManagerImpl extends BaseManagerImpl implements FileUploadManager{
	@Autowired
	private FileUploadDao fileUploadDao;
	@Autowired
	private FileStoreManager fileStoreManager;
	@Value("#{configProperties['file.root.path']}")
	private String root;

     
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<FileUpload> getFileUploads() throws BusException{
    	return fileUploadDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<FileUpload> getFileUploads(
    	@ConditionCollection(domainClazz=FileUpload.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return fileUploadDao.commonQuery(conditions, orders);
    }
    
    /**
     * 根据申请类型查询文档列表
     */
    @EsbServiceMapping
    public List<FileUpload> getFileUploadsByEnteringType(
    	@ConditionCollection(domainClazz=FileUpload.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders,@ServiceParam(name="enteringType") String enteringType) throws BusException{
    	conditions.add(ConditionUtils.getCondition("fileType", Condition.EQUALS, enteringType));
    	return fileUploadDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public FileUpload getFileUpload(@ServiceParam(name="documentId") String id)  throws BusException{
    	return fileUploadDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerFileUploads(Pager pager,//分页条件
			@ConditionCollection(domainClazz=FileUpload.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = fileUploadDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public FileUpload saveFileUpload(FileUpload o) throws BusException{
    	String fileId = o.getFileId();
    	boolean isUpdate = StringUtils.isNotEmpty(fileId);
    	if(isUpdate){//修改
    		FileUpload f=fileUploadDao.get(fileId);
    		f.setFileName(o.getFileName());
    		f.setFileType(o.getFileType());
    		f.setUpdateUser(o.getUpdateUser());
			f.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	}else{//新增
    		o.setDownNum(0);
			o.setCreateUser(o.getUpdateUser());
			o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
			o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	}
    	return fileUploadDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeFileUpload(@ServiceParam(name="documentId") String id) throws BusException{
    	fileUploadDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeFileUploads(@ServiceParam(name="documentId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeFileUpload(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitFileUpload(@ServiceParam(name="documentId") String id)  throws BusException{
		return fileUploadDao.exists(id);
	}
    
    public boolean exsitFileUpload(String propertyName,Object value) throws BusException{
		return fileUploadDao.exists(propertyName,value);
	}

    /**
     *前台页面文件下载,保存下载次数
     */
    @EsbServiceMapping
    public void saveFileUploadForDownNum(@ServiceParam(name="fileId") String fileId) throws BusException{
    	if(fileId!=null){
    		FileUpload f=fileUploadDao.get(fileId);
    		f.setDownNum(f.getDownNum()+1);
    		fileUploadDao.save(f);
    	}
    	
    }
}
