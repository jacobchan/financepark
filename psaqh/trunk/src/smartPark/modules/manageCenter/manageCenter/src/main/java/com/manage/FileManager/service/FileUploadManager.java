/**
 * 代码声明
 */
package com.manage.FileManager.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.manage.FileManager.entity.FileUpload;


public interface FileUploadManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<FileUpload> getFileUploads() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<FileUpload> getFileUploads(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public FileUpload getFileUpload(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerFileUploads(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public FileUpload saveFileUpload(FileUpload o) throws BusException;

    /**
     * 删除对象
     */
    public void removeFileUpload(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeFileUploads(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitFileUpload(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitFileUpload(String propertyName,Object value) throws BusException;
	
	/**
     *前台页面文件下载,保存下载次数
     * @param fileId:文件Id
     */
    public void saveFileUploadForDownNum(String fileId) throws BusException;
    
    /**
     * 根据申请类型查询文档列表
     */
    public List<FileUpload> getFileUploadsByEnteringType(
    	@ConditionCollection Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders,String enteringType) throws BusException;
	
}
