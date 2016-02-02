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

import com.common.purchasingManager.entity.PurchasingmanagerMerchantAddress;
import com.common.purchasingManager.service.PurchasingmanagerMerchantAddressManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/purchasingManager/purchasingmanagerMerchantAddress")
public class PurchasingmanagerMerchantAddressData extends BaseDataController{

	@Autowired
	private PurchasingmanagerMerchantAddressManager purchasingmanagerMerchantAddressManager;
	
	
	/**
	 * 主键查询商户地址库
	 */
	@RequestMapping(value="/getPurchasingmanagerMerchantAddress.json")
	@DataInfo(functionId="32030801",text="主键查询商户地址库")
	public DataModelAndView getPurchasingmanagerMerchantAddress(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("purchasingmanagerMerchantAddressId") String purchasingmanagerMerchantAddressId){
		return new DataModelAndView(purchasingmanagerMerchantAddressManager.getPurchasingmanagerMerchantAddress(purchasingmanagerMerchantAddressId));
	}
	
	/**
	 * 通用商户地址库查询
	 */
	@RequestMapping(value="/getPurchasingmanagerMerchantAddresss.json")
	@DataInfo(functionId="32030802",text="通用商户地址库查询")
	public DataModelAndView getPurchasingmanagerMerchantAddresss(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerMerchantAddress> dataIn,
    		@ModelAttribute PurchasingmanagerMerchantAddress purchasingmanagerMerchantAddress,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(purchasingmanagerMerchantAddressManager.getPurchasingmanagerMerchantAddresss(
				dataIn.getConditions(purchasingmanagerMerchantAddress, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询商户地址库
	 */
	@RequestMapping(value="/getPagerPurchasingmanagerMerchantAddresss.json")
	@DataInfo(functionId="32030803",text="分页查询商户地址库")
	public DataModelAndView getPagerPurchasingmanagerMerchantAddresss(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerMerchantAddress> dataIn,
    		@ModelAttribute PurchasingmanagerMerchantAddress purchasingmanagerMerchantAddress,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(purchasingmanagerMerchantAddressManager.getPagerPurchasingmanagerMerchantAddresss(
				dataIn.getPager(),
				dataIn.getConditions(purchasingmanagerMerchantAddress, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存商户地址库
	 */
	@RequestMapping(value="/savePurchasingmanagerMerchantAddress.json")
	@DataInfo(functionId="32030804",text="保存商户地址库",log=true)
	public DataModelAndView savePurchasingmanagerMerchantAddress(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerMerchantAddress> dataIn,
    		@ModelAttribute PurchasingmanagerMerchantAddress purchasingmanagerMerchantAddress,
    		BindingResult result){
		PurchasingmanagerMerchantAddress webPurchasingmanagerMerchantAddress =dataIn.getDomain(purchasingmanagerMerchantAddress, result);//TODO 使用泛型
		PurchasingmanagerMerchantAddress savePurchasingmanagerMerchantAddress = null;
		if(webPurchasingmanagerMerchantAddress!=null){
			savePurchasingmanagerMerchantAddress = purchasingmanagerMerchantAddressManager.savePurchasingmanagerMerchantAddress((PurchasingmanagerMerchantAddress)webPurchasingmanagerMerchantAddress);
		}
		return new DataModelAndView(savePurchasingmanagerMerchantAddress);
	}
	
	/**
	 * 主键删除商户地址库
	 */
	@RequestMapping(value="/removePurchasingmanagerMerchantAddress.json")
	@DataInfo(functionId="32030805",text="主键删除商户地址库",log=true)
	public DataModelAndView removePurchasingmanagerMerchantAddress(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("purchasingmanagerMerchantAddressId") String purchasingmanagerMerchantAddressId){
		purchasingmanagerMerchantAddressManager.removePurchasingmanagerMerchantAddress(purchasingmanagerMerchantAddressId);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除商户地址库
	 */
	@RequestMapping(value="/removePurchasingmanagerMerchantAddresss.json")
	@DataInfo(functionId="32030806",text="主键集合删除商户地址库",log=true)
	public DataModelAndView removePurchasingmanagerMerchantAddresss(
    		HttpServletRequest request,
    		HttpServletResponse response){
		purchasingmanagerMerchantAddressManager.removePurchasingmanagerMerchantAddresss(request.getParameterValues("purchasingmanagerMerchantAddressId"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
