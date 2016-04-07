package com.gsoft.framework.upload.web;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.gsoft.framework.security.AccountPrincipal;
import com.gsoft.framework.util.SecurityUtils;

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
	 * @throws IOException 
	 */
	@RequestMapping(value = "/goUpload.html")
	public void goUpload(HttpServletRequest request,
			HttpServletResponse response){
		
		List<String> urlList = null;
		try {
			request.setAttribute("root", root);
			urlList = this.uploadFile(request, response);
			for(int i=0;i<urlList.size();i++){
				System.out.println(urlList.get(i)); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			 JSONObject jsObject = new JSONObject();
			 if(urlList.size()>0){
				 jsObject.put( "status", "0" );
				 jsObject.put( "fileUrl", urlList);
			 }else{
				 jsObject.put( "status", "1" );
			 }
			 String reString = jsObject.toString();
             response.getWriter().write(reString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
							myFileName = myFileName.substring(0, myFileName.indexOf("."));
							//文件名
							String filename= getName("test.jpg");
							//图片保存路径
							SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
							String urlPathString = formater.format(new Date())+"/"+filename;
							String savePath = this.getFolder(urlPathString,request);
							File localFile = new File(savePath);
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
	
	/**
	 * 依据原始文件名生成新文件名
	 * 
	 * @return
	 */
	public String getName(String fileName) {
		Random random = new Random();
		return "" + random.nextInt(10000)
				+ System.currentTimeMillis() + getFileExt(fileName);
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
