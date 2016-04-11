/**
 * 代码声明
 */
package com.manage.FileManager.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;
import com.manage.FileManager.dao.FileUploadDao;
import com.manage.FileManager.entity.FileUpload;

@Repository("FileUploadDao")
public class FileUploadDaoHibernate extends 
		BaseDaoHibernate<FileUpload, String> implements FileUploadDao{
	public Class<FileUpload> getModelClazz(){
		return FileUpload.class;
	}
}