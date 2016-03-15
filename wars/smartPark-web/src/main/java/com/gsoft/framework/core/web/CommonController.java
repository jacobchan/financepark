package com.gsoft.framework.core.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.web.view.DataModelAndView;
import com.gsoft.framework.core.web.view.Message;
import com.gsoft.framework.upload.entity.FileStore;
import com.gsoft.framework.upload.service.FileStoreManager;
import com.gsoft.framework.util.DateUtils;

@Controller
@RequestMapping("/common")
public class CommonController {
	@Value("#{configProperties['file.root.path']}")
	private String root;
	@Autowired
	private FileStoreManager fileStoreManager;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/upload.html")
	@ResponseBody
	public String upload(HttpServletRequest  request,HttpServletResponse response) throws IllegalStateException, IOException, FileUploadException{
		if("show".equals(request.getParameter("method"))){
			this.down(request, response);
			return null;
		}
		String ret = "";
		String key;
		List fileStores = new ArrayList();
		if (request instanceof MultipartHttpServletRequest) {
		    MultiValueMap<String, MultipartFile> multipartFiles = ((MultipartHttpServletRequest)request).getMultiFileMap();
		    for (Entry entry : multipartFiles.entrySet()) {
		    	key = (String)entry.getKey();
		        MultipartFile multipartFile = (MultipartFile)multipartFiles.getFirst(key);
		        //原文件名存到平台fileStore表里
		        fileStoreManager.storeFile(multipartFile.getOriginalFilename(), multipartFile.getInputStream());
 
		    	String fileName =  "upload/"+DateUtils.getToday("yyyyMM")+"/"+UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
		    	File path = new File(root+"upload/"+DateUtils.getToday("yyyyMM"));
		    	if(!path.exists()){
				  path.mkdirs();
		    	}
		    	File file = new File(root+fileName);
		    	FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),file);
		    	if(ret.length() > 0) ret += ",";
		    	ret += fileName;
		    }
		  }else{
			  FileItemFactory factory = new DiskFileItemFactory();
			  ServletFileUpload upload = new ServletFileUpload(factory);
			  @SuppressWarnings("unchecked")
			  List<DiskFileItem> items = upload.parseRequest(request);
			  for (DiskFileItem item : items) {
				  if(!(item.isFormField())){
					  //原文件名存到平台fileStore表里
					 fileStoreManager.storeFile(((DiskFileItem)item).getName(), ((DiskFileItem)item).getInputStream());

					  String fileName =  "upload/"+DateUtils.getToday("yyyyMM")+"/"+UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(item.getName());
					  File path = new File(root+"upload/"+DateUtils.getToday("yyyyMM"));
					  if(!path.exists()){
						  path.mkdirs();
					  }
					  File file = new File(root+fileName);
					  FileUtils.copyInputStreamToFile(item.getInputStream(),file);
					  if(ret.length() > 0) ret += ",";
					  ret += fileName;
				  }
			  }
		   }
		
		return ret.substring(0,ret.length());
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/uploadImage.html")
	@ResponseBody
	public String uploadImage(HttpServletRequest  request,HttpServletResponse response) throws IllegalStateException, IOException, FileUploadException{
		if("show".equals(request.getParameter("method"))){
			this.down(request, response);
			return null;
		}
		String ret = "";
		String key;
		if (request instanceof MultipartHttpServletRequest) {
		    MultiValueMap<String, MultipartFile> multipartFiles = ((MultipartHttpServletRequest)request).getMultiFileMap();
		    for (Entry entry : multipartFiles.entrySet()) {
		    	key = (String)entry.getKey();
		        MultipartFile multipartFile = (MultipartFile)multipartFiles.getFirst(key);
		    	String fileName =  "uploadImages/"+DateUtils.getToday("yyyyMM")+"/"+UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
		    	File path = new File(root+"uploadImages/"+DateUtils.getToday("yyyyMM"));
		    	if(!path.exists()){
				  path.mkdirs();
		    	}
		    	File file = new File(root+fileName);
		    	FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),file);
		    	if(ret.length() > 0) ret += ",";
		    	ret += fileName;
		    }
		  }else{
			  FileItemFactory factory = new DiskFileItemFactory();
			  ServletFileUpload upload = new ServletFileUpload(factory);
			  @SuppressWarnings("unchecked")
			  List<DiskFileItem> items = upload.parseRequest(request);
			  for (DiskFileItem item : items) {
				  if(!(item.isFormField())){
					  String fileName =  "uploadImages/"+DateUtils.getToday("yyyyMM")+"/"+UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(item.getName());
					  File path = new File(root+"uploadImages/"+DateUtils.getToday("yyyyMM"));
					  if(!path.exists()){
						  path.mkdirs();
					  }
					  File file = new File(root+fileName);
					  FileUtils.copyInputStreamToFile(item.getInputStream(),file);
					  if(ret.length() > 0) ret += ",";
					  ret += fileName;
				  }
			  }
		   }
		
		return ret.substring(0,ret.length());
	}
	
	
	@RequestMapping("/remove.html")
	@ResponseBody
	public DataModelAndView remove(HttpServletRequest  request) throws IllegalStateException, IOException, FileUploadException{
		
		String path = request.getParameter("path");
		if(path!=null&&!"".equals(path)){
			File file = new File(path);
			if(file.exists()){
				file.delete();
			}
		}
		return new DataModelAndView("");
	}
	
	@RequestMapping("/bc_down.html")
	@ResponseBody
	public ModelAndView bc_down(HttpServletRequest  request,HttpServletResponse response) throws IllegalStateException, IOException, FileUploadException{
		String path = request.getParameter("path");
		File file = new File(root+path);
		if(!file.exists()){
			throw new BusException("文件不存在");
		}
		String fileName = "";
		if(path.indexOf(String.valueOf('/')) == -1){
			fileName = path;
		}else{
			fileName = path.split("/")[1];
		}
		
		response.addHeader("Content-Disposition","attachment; filename=" + fileName);
		response.setContentType("application/unknow");
		FileInputStream fis = new FileInputStream(file);
		byte[] buff = new byte[1024*10];
		ServletOutputStream sos = response.getOutputStream();
		int len = 0;
		while((len = fis.read(buff)) > 0){
			sos.write(buff, 0, len);
		}
		fis.close();
		sos.flush();
		sos.close();
		
		return null;
	}
	
	@RequestMapping("/down.html")
	@ResponseBody
	public ModelAndView down(HttpServletRequest  request,HttpServletResponse response) throws IllegalStateException, IOException, FileUploadException{
		String path = request.getParameter("path");
		if(path.indexOf("..")<0){//过滤非法访问
			File file = new File(new File(root),path);
			if(!file.exists()){
				throw new BusException("文件不存在");
			}
			String fileName = FilenameUtils.getName(file.getName());
			response.addHeader("Content-Disposition","attachment; filename=" + fileName);
			response.setContentType("application/unknow");
			FileInputStream fis = new FileInputStream(file);
			byte[] buff = new byte[1024*10];
			ServletOutputStream sos = response.getOutputStream();
			int len = 0;
			while((len = fis.read(buff)) > 0){
				sos.write(buff, 0, len);
			}
			fis.close();
			sos.flush();
			sos.close();
		}
		return null;
	}
	
	@RequestMapping("/html/{decorator}.html")
	public ModelAndView navHtml(@PathVariable("decorator") String decorator, @RequestParam("path") String path){
		String reg = "want_invest-want_loan-news-news_hy-trad_guide-security_center-about_yjs-help_center-notice";
		ModelAndView view = new ModelAndView("common/html");
		view.addObject("decorator", decorator);
		if(reg.contains(path)&&path.indexOf("/")<0){
			view.addObject("path", "/html/" + path + ".jsp");
		}else{
			view.setViewName("/errorpage/pageNotFound.jsp");
		}
		return view;
	}
	
	/**
	 * 
	 */
	public DataModelAndView accessDenied(){
		return new DataModelAndView(new Message("111111", "登录已过期，请重新登录"));
	}
}
