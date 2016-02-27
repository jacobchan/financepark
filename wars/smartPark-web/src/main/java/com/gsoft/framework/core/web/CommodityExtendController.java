/**
 * 
 */
package com.gsoft.framework.core.web;


import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.service.PurchasingmanagerCommodityManager;
import com.gsoft.entity.TempDemo;
import com.gsoft.framework.core.web.view.DataModelAndView;

/**
 * 商品扩展属性
 * @author maogf
 *
 */
@Controller
@RequestMapping("/web/commodityExtend")
public class CommodityExtendController {
	@Autowired
	private PurchasingmanagerCommodityManager purchasingmanagerCommodityManager;
//	@Autowired
//	private PurchasingmanagerCommodityExtendValueManager purchasingmanagerCommodityExtendValueManager;
	
	//商品扩展属性保存
	@RequestMapping("/saveCommodityExtend.json")
	public DataModelAndView saveCommodityExtend(HttpServletRequest request){
		Map<String, String[]> map =  request.getParameterMap();
		Set<String> keyset = map.keySet();
		String commodityId = map.get("commodityId")[0];
		PurchasingmanagerCommodity pc = purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(commodityId);
		for(String s:keyset){
//			if(!s.equals("operant")&&!s.equals("commodityId")){
//				String value = map.get(s)[0];
//				PurchasingmanagerCommodityExtendValue pcv = purchasingmanagerCommodityExtendValueManager.
//						getPurchasingmanagerCommodityExtendValue(commodityId,s);
//				pcv.setPurchasingmanagerCommodity(pc);
//				pcv.setCommodityExtendValueFieldName(s);
//				pcv.setCommodityExtendValueDisplayContent(value);
//				purchasingmanagerCommodityExtendValueManager.savePurchasingmanagerCommodityExtendValue(pcv);
//			}
		}
		return new DataModelAndView("true");
	}
	
	//根据商品ID和扩展属性名获取扩展属性值
	@RequestMapping("/getValue.json")
	public DataModelAndView getValue(HttpServletRequest request){
		String commodityId = request.getParameter("commodityId");
		String commodityExtendValueFieldName = request.getParameter("commodityExtendValueFieldName");
//		PurchasingmanagerCommodityExtendValue pc = purchasingmanagerCommodityExtendValueManager.getPurchasingmanagerCommodityExtendValue(commodityId,commodityExtendValueFieldName);
//		String value = pc.getCommodityExtendValueDisplayContent();
		TempDemo temp = new TempDemo();
//		temp.setBuff(value);
		return new DataModelAndView(temp);
	}
}
