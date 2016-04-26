package com.gsoft.framework.core.web;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gsoft.framework.core.web.controller.BaseDataController;

@Controller
@RequestMapping("/web/pay")
public class PayData extends BaseDataController {
	
	/**
	 * 充值同步返回
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/payReturn.json")
	public void payReturn(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
         //得到回传参数，并重新构建，解决乱码问题
         Map<String, String> paramMapStr = new HashMap<String, String>();
         Map<String, String[]> paramMap = new HashMap<String, String[]>(req.getParameterMap());
         for(Entry<String,String[]> entry:paramMap.entrySet()){
        	 System.out.println("*********************************");
        	 System.out.println(entry.getValue()[0]);
        	 System.out.println(new String(entry.getValue()[0].getBytes("iso-8859-1"),"UTF-8"));
        	 System.out.println("*********************************");
			 paramMapStr.put(entry.getKey(), (new String(entry.getValue()[0].getBytes("iso-8859-1"),"UTF-8")));
		 }
	}

}
