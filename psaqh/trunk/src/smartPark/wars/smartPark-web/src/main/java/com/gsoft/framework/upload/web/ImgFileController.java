/**
 * 
 */
package com.gsoft.framework.upload.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.web.view.DataModelAndView;
import com.gsoft.framework.core.web.view.Message;
import com.gsoft.framework.security.EsbSecurityManager;
import com.gsoft.framework.upload.service.FileStoreManager;
//import com.gsoft.framework.upload.util.ImgUtils;

/**
 * @author zhyi_12
 *
 */

@Controller
@RequestMapping("/img")
public class ImgFileController {
//	@Value("#{configProperties['file.root.path']}")
//	private String root;
//	@Autowired
//	private FileStoreManager fileStoreManager;
//	@Autowired
//	private EsbSecurityManager esbSecurityManager;
//	
//	@RequestMapping(value = "/{width}/{height}/showImg.html")
//	public DataModelAndView downloadFile(HttpServletRequest request,
//			HttpServletResponse response,
//			@PathVariable("width") String width,
//			@PathVariable("height") String height) {
//		String path = request.getParameter("path");
//		File file = new File(root+path);
//		if(!file.exists()){
//			throw new BusException("文件不存在");
//		}
//		String aa = esbSecurityManager.encryptSecurityInfo(null);
//		System.out.println(aa);
//		
//		String errorMessage = "";
//		if (file.exists()) {
//			response.setContentType("application/x-download");
//			try {
//				path = URLEncoder.encode(path, "UTF-8");
//			} catch (UnsupportedEncodingException e) {
//				// e.printStackTrace();
//			}
//			
//			response.setContentType("image/png");
//			
//			try {
//				ImgUtils.compress(file, response.getOutputStream(), 
//						Integer.parseInt(width), Integer.parseInt(height));
//				return null;
//			} catch (NumberFormatException e) {
//				errorMessage = e.getMessage();
//			} catch (IOException e) {
//				errorMessage = e.getMessage();
//			}
//		}
//		
//		if(StringUtils.isEmpty(errorMessage)){
//			errorMessage = "文件" + path+"下载错误";
//		}
//
//		return new DataModelAndView(new Message("99999", errorMessage+"!"));
//	}
}
