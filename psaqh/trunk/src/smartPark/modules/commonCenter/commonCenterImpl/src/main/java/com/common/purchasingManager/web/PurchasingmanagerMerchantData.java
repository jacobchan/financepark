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

import com.common.purchasingManager.entity.PurchasingmanagerMerchant;
import com.common.purchasingManager.service.PurchasingmanagerMerchantManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/purchasingManager/purchasingmanagerMerchant")
public class PurchasingmanagerMerchantData extends BaseDataController{

	@Autowired
	private PurchasingmanagerMerchantManager purchasingmanagerMerchantManager;
	
	
	/**
	 * 主键查询商户信息表
	 */
	@RequestMapping(value="/getPurchasingmanagerMerchant.json")
	@DataInfo(functionId="32030701",text="主键查询商户信息表")
	public DataModelAndView getPurchasingmanagerMerchant(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("purchasingmanagerMerchantId") String purchasingmanagerMerchantId){
		return new DataModelAndView(purchasingmanagerMerchantManager.getPurchasingmanagerMerchant(purchasingmanagerMerchantId));
	}
	
	/**
	 * 通用商户信息表查询
	 */
	@RequestMapping(value="/getPurchasingmanagerMerchants.json")
	@DataInfo(functionId="32030702",text="通用商户信息表查询")
	public DataModelAndView getPurchasingmanagerMerchants(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerMerchant> dataIn,
    		@ModelAttribute PurchasingmanagerMerchant purchasingmanagerMerchant,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(purchasingmanagerMerchantManager.getPurchasingmanagerMerchants(
				dataIn.getConditions(purchasingmanagerMerchant, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询商户信息表
	 */
	@RequestMapping(value="/getPagerPurchasingmanagerMerchants.json")
	@DataInfo(functionId="32030703",text="分页查询商户信息表")
	public DataModelAndView getPagerPurchasingmanagerMerchants(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerMerchant> dataIn,
    		@ModelAttribute PurchasingmanagerMerchant purchasingmanagerMerchant,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(purchasingmanagerMerchantManager.getPagerPurchasingmanagerMerchants(
				dataIn.getPager(),
				dataIn.getConditions(purchasingmanagerMerchant, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存商户信息表
	 */
	@RequestMapping(value="/savePurchasingmanagerMerchant.json")
	@DataInfo(functionId="32030704",text="保存商户信息表",log=true)
	public DataModelAndView savePurchasingmanagerMerchant(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerMerchant> dataIn,
    		@ModelAttribute PurchasingmanagerMerchant purchasingmanagerMerchant,
    		BindingResult result){
		PurchasingmanagerMerchant webPurchasingmanagerMerchant =dataIn.getDomain(purchasingmanagerMerchant, result);//TODO 使用泛型
		PurchasingmanagerMerchant savePurchasingmanagerMerchant = null;
		if(webPurchasingmanagerMerchant!=null){
			savePurchasingmanagerMerchant = purchasingmanagerMerchantManager.savePurchasingmanagerMerchant((PurchasingmanagerMerchant)webPurchasingmanagerMerchant);
		}
		return new DataModelAndView(savePurchasingmanagerMerchant);
	}
	
	/**
	 * 主键删除商户信息表
	 */
	@RequestMapping(value="/removePurchasingmanagerMerchant.json")
	@DataInfo(functionId="32030705",text="主键删除商户信息表",log=true)
	public DataModelAndView removePurchasingmanagerMerchant(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("purchasingmanagerMerchantId") String purchasingmanagerMerchantId){
		purchasingmanagerMerchantManager.removePurchasingmanagerMerchant(purchasingmanagerMerchantId);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除商户信息表
	 */
	@RequestMapping(value="/removePurchasingmanagerMerchants.json")
	@DataInfo(functionId="32030706",text="主键集合删除商户信息表",log=true)
	public DataModelAndView removePurchasingmanagerMerchants(
    		HttpServletRequest request,
    		HttpServletResponse response){
		purchasingmanagerMerchantManager.removePurchasingmanagerMerchants(request.getParameterValues("purchasingmanagerMerchantId"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
