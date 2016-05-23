package com.gsoft.framework.core.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.task.Task;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.service.OrdermanagerUserorderManager;
import com.common.wxpay.common.Signature;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.web.controller.BaseDataController;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.workflow.service.impl.FlowRunManagerImpl;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerBxManager;

@Controller
@RequestMapping("/wxpay")
public class PayData extends BaseDataController {
	@Autowired
	private OrdermanagerUserorderManager ordermanagerUserorderManager;
	@Autowired
	private FlowRunManagerImpl flowRunManagerImpl;
	@Autowired
	private PropertyservicemanagerBxManager propertyservicemanagerBxManager;
	
	/**
	 * 微信支付异步返回
	 * @throws IOException 
	 */
	@RequestMapping("/notify.json")
	public void payReturn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("---------------微信支付回调----------------");
		//xml请求解析
		try {
			Map<String, Object> requestMap = parseXml(request);
			for(Map.Entry<String, Object> entry:requestMap.entrySet()){
				System.out.println(entry.getKey()+"--->"+entry.getValue());
			}
			String res_sign =  requestMap.get("sign").toString();
			requestMap.remove("sign");
			String sign = Signature.getSign(requestMap);
			if(!sign.equals(res_sign)){
				throw new BusException("签名不正确！");
			}
			String resultCode = requestMap.get("result_code").toString();
			String returnCode = requestMap.get("return_code").toString();
			if("SUCCESS".endsWith(resultCode)&&"SUCCESS".endsWith(returnCode)){
				String orderCode = requestMap.get("out_trade_no").toString();//支付订单号
				String tranId = requestMap.get("transaction_id").toString();//微信返回交易订单号
				OrdermanagerUserorder order = ordermanagerUserorderManager.getOrderByCode(orderCode);
				if(!"01".equals(order.getPayStatus())){
					order.setUserorderStatus("02");//02-已支付
					order.setPayStatus("01");//01-已支付
					order.setPayReturnCode(tranId);
					order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
					ordermanagerUserorderManager.saveUserOrder(order);
					if(StringUtils.isNotEmpty(order.getBxId())){
						Pager pager = new Pager("10", "1", String.valueOf(Pager.QUERY_TYPE_ALL)); 
						Collection<Condition> conditions = new ArrayList<Condition>();
						conditions.add(ConditionUtils.getCondition("params.flowProcessId", Condition.EQUALS, "propertyrepair"));
						conditions.add(ConditionUtils.getCondition("params.bxStatus", Condition.EQUALS, "04"));
						PropertyservicemanagerBx psbx = propertyservicemanagerBxManager.getPropertyservicemanagerBx(order.getBxId());
						conditions.add(ConditionUtils.getCondition("params.bxCode", Condition.EQUALS, psbx.getBxCode()));
						PagerRecords pagerRecords = flowRunManagerImpl.getPagerTasks(pager, conditions, null);
						@SuppressWarnings("unchecked")
						List<Task> list = pagerRecords.getRecords();
						if(list.size()>0){
							String taskId = list.get(0).getId();
							Map<String, Object> paramMap = new HashMap<String, Object>();
							paramMap.put("bxStatus", "05");
							paramMap.put("repair", "1");
							flowRunManagerImpl.completeTask(taskId, paramMap);
						}
					}
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.print("success");
		out.close();
	}
	
	/**
     * 解析微信发来的请求（XML）
     * 
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> parseXml(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, Object> map = new HashMap<String, Object>();

        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        for (Element e : elementList)
                map.put(e.getName(), e.getText());

        // 释放资源
        inputStream.close();
        inputStream = null;
        return map;
    }
}
