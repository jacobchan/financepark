/**
 * 
 */
package com.common.purchasingManager.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gsoft.framework.core.web.annotation.DataInfo;
import com.gsoft.framework.core.web.controller.BaseDataController;
import com.gsoft.framework.core.web.controller.DataIn;
import com.gsoft.framework.core.web.view.DataModelAndView;
import com.gsoft.framework.core.web.view.Message;

import com.common.purchasingManager.entity.PurchasingmanagerCommodityExtendValue;
import com.common.purchasingManager.service.PurchasingmanagerCommodityExtendValueManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/purchasingManager/purchasingmanagerCommodityExtendValue")
public class PurchasingmanagerCommodityExtendValueData extends BaseDataController{

	@Autowired
	private PurchasingmanagerCommodityExtendValueManager purchasingmanagerCommodityExtendValueManager;
	
	
	/**
	 * 主键查询商品扩展属性值表
	 */
	@RequestMapping(value="/getPurchasingmanagerCommodityExtendValue.json")
	@DataInfo(functionId="32030301",text="主键查询商品扩展属性值表")
	public DataModelAndView getPurchasingmanagerCommodityExtendValue(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("purchasingmanagerCommodityExtendValueId") String purchasingmanagerCommodityExtendValueId){
		return new DataModelAndView(purchasingmanagerCommodityExtendValueManager.getPurchasingmanagerCommodityExtendValue(purchasingmanagerCommodityExtendValueId));
	}
	
	/**
	 * 通用商品扩展属性值表查询
	 */
	@RequestMapping(value="/getPurchasingmanagerCommodityExtendValues.json")
	@DataInfo(functionId="32030302",text="通用商品扩展属性值表查询")
	public DataModelAndView getPurchasingmanagerCommodityExtendValues(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerCommodityExtendValue> dataIn,
    		@ModelAttribute PurchasingmanagerCommodityExtendValue purchasingmanagerCommodityExtendValue,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(purchasingmanagerCommodityExtendValueManager.getPurchasingmanagerCommodityExtendValues(
				dataIn.getConditions(purchasingmanagerCommodityExtendValue, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询商品扩展属性值表
	 */
	@RequestMapping(value="/getPagerPurchasingmanagerCommodityExtendValues.json")
	@DataInfo(functionId="32030303",text="分页查询商品扩展属性值表")
	public DataModelAndView getPagerPurchasingmanagerCommodityExtendValues(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerCommodityExtendValue> dataIn,
    		@ModelAttribute PurchasingmanagerCommodityExtendValue purchasingmanagerCommodityExtendValue,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(purchasingmanagerCommodityExtendValueManager.getPagerPurchasingmanagerCommodityExtendValues(
				dataIn.getPager(),
				dataIn.getConditions(purchasingmanagerCommodityExtendValue, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存商品扩展属性值表
	 */
	@RequestMapping(value="/savePurchasingmanagerCommodityExtendValue.json")
	@DataInfo(functionId="32030304",text="保存商品扩展属性值表",log=true)
	public DataModelAndView savePurchasingmanagerCommodityExtendValue(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerCommodityExtendValue> dataIn,
    		@ModelAttribute PurchasingmanagerCommodityExtendValue purchasingmanagerCommodityExtendValue,
    		BindingResult result){
		PurchasingmanagerCommodityExtendValue webPurchasingmanagerCommodityExtendValue =dataIn.getDomain(purchasingmanagerCommodityExtendValue, result);//TODO 使用泛型
		PurchasingmanagerCommodityExtendValue savePurchasingmanagerCommodityExtendValue = null;
		if(webPurchasingmanagerCommodityExtendValue!=null){
			savePurchasingmanagerCommodityExtendValue = purchasingmanagerCommodityExtendValueManager.savePurchasingmanagerCommodityExtendValue((PurchasingmanagerCommodityExtendValue)webPurchasingmanagerCommodityExtendValue);
		}
		return new DataModelAndView(savePurchasingmanagerCommodityExtendValue);
	}
	
	/**
	 * 主键删除商品扩展属性值表
	 */
	@RequestMapping(value="/removePurchasingmanagerCommodityExtendValue.json")
	@DataInfo(functionId="32030305",text="主键删除商品扩展属性值表",log=true)
	public DataModelAndView removePurchasingmanagerCommodityExtendValue(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("purchasingmanagerCommodityExtendValueId") String purchasingmanagerCommodityExtendValueId){
		purchasingmanagerCommodityExtendValueManager.removePurchasingmanagerCommodityExtendValue(purchasingmanagerCommodityExtendValueId);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除商品扩展属性值表
	 */
	@RequestMapping(value="/removePurchasingmanagerCommodityExtendValues.json")
	@DataInfo(functionId="32030306",text="主键集合删除商品扩展属性值表",log=true)
	public DataModelAndView removePurchasingmanagerCommodityExtendValues(
    		HttpServletRequest request,
    		HttpServletResponse response){
		purchasingmanagerCommodityExtendValueManager.removePurchasingmanagerCommodityExtendValues(request.getParameterValues("purchasingmanagerCommodityExtendValueId"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
