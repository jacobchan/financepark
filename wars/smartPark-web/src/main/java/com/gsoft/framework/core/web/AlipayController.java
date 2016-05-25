/**
 * 
 */
package com.gsoft.framework.core.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.service.OrdermanagerUserorderManager;
import com.common.alipay.common.AlipayNotify;
import com.common.alipay.service.AliPayManager;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.workflow.service.FlowRunManager;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerBxManager;

/**
 * 支付宝支付
 * @author Aaron Tan
 *
 */
@Controller
@RequestMapping("/alipay")
public class AlipayController {
	@Autowired
	private AliPayManager aliPayManager;
	@Autowired
	private OrdermanagerUserorderManager ordermanagerUserorderManager;
	@Autowired
	private PropertyservicemanagerBxManager propertyservicemanagerBxManager;
	@Autowired
	private FlowRunManager flowRunManager;
	/**
	 * 登录页面
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/alipayapi.html")
	public ModelAndView alipayapi(@RequestParam("userorderCode") String userorderCode){
		//获取订单编号
		String submitHtml = aliPayManager.getAlipayapiHtml(userorderCode);
		return new ModelAndView("alipayapi","submitHtml",submitHtml);
	}
	
	/**
	 * 支付宝支付异步返回
	 * @throws IOException 
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/notify.html")
	@ResponseBody
	public void payReturn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("---------------支付宝回调----------------");
		PrintWriter out = response.getWriter();
		 Map<String,String> params = new HashMap<String,String>();  
		    Map requestParams = request.getParameterMap();  
		    for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {  
		        String name = (String) iter.next();  
		        String[] values = (String[]) requestParams.get(name);  
		        String valueStr = "";  
		        for (int i = 0; i < values.length; i++) {  
		            valueStr = (i == values.length - 1) ? valueStr + values[i]  
		                    : valueStr + values[i] + ",";  
		        }  
		        //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化  
		        //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");  
		        params.put(name, valueStr);  
		    }  
		  
		  
		      
		    //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//  
		  
		    String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "utf-8");              //支付宝交易号  
		    String order_no = new String(request.getParameter("order_no").getBytes("ISO-8859-1"), "utf-8");       //获取订单号  
		    String total_fee = new String(request.getParameter("total_fee").getBytes("ISO-8859-1"), "utf-8");           //获取总金额  
		    String subject = new String(request.getParameter("subject").getBytes("ISO-8859-1"),"utf-8");//商品名称、订单名称  
		    String body = "";  
		    if(request.getParameter("body") != null){  
		        body = new String(request.getParameter("body").getBytes("ISO-8859-1"), "utf-8");//商品描述、订单备注、描述  
		    }  
		    String buyer_email =  new String(request.getParameter("buyer_email").getBytes("ISO-8859-1"), "utf-8");     //买家支付宝账号  
		    String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "utf-8");     //交易状态  
		      
		    //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//  
		  
		    if(AlipayNotify.verify(params)){//验证成功  
		        //////////////////////////////////////////////////////////////////////////////////////////  
		        //请在这里加上商户的业务逻辑程序代码  
		  
		        //——请根据您的业务逻辑来编写程序（以下代码仅作参考）——  
		    	// TRADE_FINISHED(表示交易已经成功结束，为普通即时到帐的交易状态成功标识); 
		    	// TRADE_SUCCESS(表示交易已经成功结束，为高级即时到帐的交易状态成功标识);  
		        if(trade_status.equals("TRADE_SUCCESS")||trade_status.equals("TRADE_FINISHED")){  
		            //判断该笔订单是否在商户网站中已经做过处理（可参考“集成教程”中“3.4返回数据处理”）  
		                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序  
		                //如果有做过处理，不执行商户的业务程序  
		        	OrdermanagerUserorder order = ordermanagerUserorderManager.getOrderByCode(trade_no);
					if(!"01".equals(order.getPayStatus())){
						order.setUserorderStatus("02");//02-已支付
						order.setPayStatus("01");//01-已支付
						order.setPayReturnCode(order_no);
						order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
						ordermanagerUserorderManager.saveUserOrder(order);
						if(StringUtils.isNotEmpty(order.getBxId())){
							Pager pager = new Pager("10", "1", String.valueOf(Pager.QUERY_TYPE_ALL)); 
							Collection<Condition> conditions = new ArrayList<Condition>();
							conditions.add(ConditionUtils.getCondition("params.flowProcessId", Condition.EQUALS, "propertyrepair"));
							conditions.add(ConditionUtils.getCondition("params.bxStatus", Condition.EQUALS, "04"));
							PropertyservicemanagerBx psbx = propertyservicemanagerBxManager.getPropertyservicemanagerBx(order.getBxId());
							conditions.add(ConditionUtils.getCondition("params.bxCode", Condition.EQUALS, psbx.getBxCode()));
							PagerRecords pagerRecords = flowRunManager.getPagerTasks(pager, conditions, null);
							@SuppressWarnings("unchecked")
							List<Task> list = pagerRecords.getRecords();
							if(list.size()>0){
								String taskId = list.get(0).getId();
								Map<String, Object> paramMap = new HashMap<String, Object>();
								paramMap.put("bxStatus", "05");
								paramMap.put("repair", "1");
								flowRunManager.completeTask(taskId, paramMap);
							}
						}
						
					}
					out.write("success"); //请不要修改或删除  
		        } else {  
		        	out.write("success"); //请不要修改或删除  
		        }  
		  
		        //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——  
		  
		        //////////////////////////////////////////////////////////////////////////////////////////  
		    }else{//验证失败  
		    	out.write("fail");  
		    }  
	}
}
