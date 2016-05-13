package com.gsoft.framework.upload.web;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.regexp.recompile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.gsoft.framework.security.AccountPrincipal;
import com.gsoft.framework.upload.dao.FileStoreDao;
import com.gsoft.framework.upload.entity.FileStore;
import com.gsoft.framework.upload.service.FileStoreManager;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.SecurityUtils;
import com.manage.FileManager.service.FileUploadManager;

/**
 * 文件上传处理（文件和图片）
 * @author 刘嘉毅
 *
 */
@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {
	@Value("#{configProperties['file.root.path']}")
	private String root;
	@Autowired
	private FileStoreManager fileStoreManager;
	@Autowired
	private FileStoreDao fileStoreDao;	
	
	/**
	 * 上传页面的跳转
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/test.html")
	public ModelAndView goTestPage(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView model = new ModelAndView("test/upload");
		AccountPrincipal account = SecurityUtils.getAccount();
		model.addObject("user", account);
		return model;
	}
	
	/**
	 * 执行上传操作
	 * @param request
	 * @param response
	 * @return
	 * @throws FileUploadException 
	 * @throws IllegalStateException 
	 * @throws IOException 
	 */
	@RequestMapping(value = "/goUpload.html")
	public void goUpload(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException, FileUploadException{
		
		List<String> urlList = new ArrayList<String>();
		try {
			//获取上传的类型的标识 0:图片类型 ;1:文件类型 
			//TODO 后续完善
			String fileFlg = request.getParameter("fileFlg");
			//执行上传操作，返回带有文件URL的集合
			if(fileFlg.equals("0")){
				urlList = this.uploadImage(request, response);
			}else{
				urlList = this.uploadFile(request, response);
			}
		} catch (IOException e) {
			urlList.clear();
		}
		
		try {
			 JSONObject jsObject = new JSONObject();
			 if(urlList.size()>0){
				 //返回回调的文件url集合
				 jsObject.put( "status", "0" );
				 jsObject.put( "fileUrl", urlList);
			 }else{
				 jsObject.put( "status", "1" );
			 }
			 String reString = jsObject.toString();
             response.getWriter().write(reString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 开始上传图片的操作
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public  List<String> uploadFile( HttpServletRequest request, HttpServletResponse response   ) throws IOException {
        //返回处理标识
        List<String> urlList = new ArrayList<String>();
        //数据库保存的图片路径
        String imagePathDB = "";
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)){
            //转换成多部分request  
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            if(iter.hasNext()){
                while(iter.hasNext()){
                    int i = 0;
                    //取得上传文件
                    MultipartFile file = multiRequest.getFile(iter.next());
                    if(file != null){
                        //取得当前上传文件的文件名称
                        String myFileName = file.getOriginalFilename();
                        //如果名称不为"",说明该文件存在，否则说明该文件不存在
                        if(myFileName.trim() !=""){
                            //myFileName = myFileName.substring(0, myFileName.indexOf("."));
                            //文件名
                            String filename= getName(myFileName);
                            //图片保存路径
                            SimpleDateFormat formater = new SimpleDateFormat("yyyyMM");
                            String urlPathString = "upload/"+formater.format(new Date())+"/"+filename;
                            File path = new File(root+"upload/"+formater.format(new Date()));
                            FileStore Store = new FileStore();
                            Store.setFilePath(urlPathString);
                            Store.setStatus("0");
                            Long a = file.getSize();
                            Store.setFileSize(Integer.valueOf(a.toString()));
                            Store.setUploadFileName(myFileName);
                            Store.setTimestamp(DateUtils.getToday("yyyyMMddHHmmss"));
                            fileStoreDao.save(Store);
                            if(!path.exists()){
      						  path.mkdirs();
      					  }
                            File localFile = new File(root+urlPathString);
                            //获取图片内容下载到本地服务器的路径
                            //String basePath = request.getContextPath();
                            //网页显示路径
                            imagePathDB = urlPathString;
                            try {
                                file.transferTo(localFile);
                                urlList.add(i,imagePathDB);
                            } catch (IllegalStateException e) {
                                break;
                            } catch (IOException e) {
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
        return urlList;
    }
	
	public List<String> uploadImage(HttpServletRequest  request,HttpServletResponse response) throws IllegalStateException, IOException, FileUploadException{
		List<String> urlList = new ArrayList<String>();
//		String ret = "";
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
		    	urlList.add(fileName);
		    }
		  }else{
			  FileItemFactory factory = new DiskFileItemFactory();
			  ServletFileUpload upload = new ServletFileUpload(factory);
			  List<FileItem> items = upload.parseRequest(request);
			  for (FileItem item : items) {
				  if(!(item.isFormField())){
					  String fileName =  "uploadImages/"+DateUtils.getToday("yyyyMM")+"/"+UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(item.getName());
					  File path = new File(root+"uploadImages/"+DateUtils.getToday("yyyyMM"));
					  if(!path.exists()){
						  path.mkdirs();
					  }
					  File file = new File(root+fileName);
					  FileUtils.copyInputStreamToFile(item.getInputStream(),file);
					  urlList.add(fileName);
				  }
			  }
		   }
		
		return urlList;
	}
	
	/**
	 * 依据原始文件名生成新文件名
	 * 
	 * @return
	 */
	public String getName(String fileName) {
		//Random random = new Random();
		return "" + UUID.randomUUID().toString()+ getFileExt(fileName);
	}
	
	/**
	 * 获取文件扩展名
	 * 
	 * @return string
	 */
	private String getFileExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}
	

	/**
	 * 检查文件夹是否存在，不存在创建文件夹
	 * @param path
	 * @return
	 */
	public String getFolder(String path,HttpServletRequest request) {
		File dir = new File(this.getPhysicalPath(path,request));
		if (!dir.exists()) {
			try {
				dir.mkdirs();
			} catch (Exception e) {
				//this.state = this.errorInfo.get("DIR");
				return "";
			}
		}
		return dir.toString();
	}
	
	/**
	 * 根据传入的虚拟路径获取物理路径
	 * 
	 * @param path
	 * @return
	 */
	public String getPhysicalPath(String path,HttpServletRequest request) {
		String realPath = request.getSession().getServletContext()
				.getRealPath(root);

		return new File(realPath).getParent() + root + path;
	}
}
