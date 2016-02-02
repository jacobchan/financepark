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

import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.service.PurchasingmanagerCommodityManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/purchasingManager/purchasingmanagerCommodity")
public class PurchasingmanagerCommodityData extends BaseDataController{

	@Autowired
	private PurchasingmanagerCommodityManager purchasingmanagerCommodityManager;
	
	
	/**
	 * 主键查询商品信息
	 */
	@RequestMapping(value="/getPurchasingmanagerCommodity.json")
	@DataInfo(functionId="32030101",text="主键查询商品信息")
	public DataModelAndView getPurchasingmanagerCommodity(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("purchasingmanagerCommodityId") String purchasingmanagerCommodityId){
		return new DataModelAndView(purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(purchasingmanagerCommodityId));
	}
	
	/**
	 * 通用商品信息查询
	 */
	@RequestMapping(value="/getPurchasingmanagerCommoditys.json")
	@DataInfo(functionId="32030102",text="通用商品信息查询")
	public DataModelAndView getPurchasingmanagerCommoditys(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerCommodity> dataIn,
    		@ModelAttribute PurchasingmanagerCommodity purchasingmanagerCommodity,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(purchasingmanagerCommodityManager.getPurchasingmanagerCommoditys(
				dataIn.getConditions(purchasingmanagerCommodity, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询商品信息
	 */
	@RequestMapping(value="/getPagerPurchasingmanagerCommoditys.json")
	@DataInfo(functionId="32030103",text="分页查询商品信息")
	public DataModelAndView getPagerPurchasingmanagerCommoditys(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerCommodity> dataIn,
    		@ModelAttribute PurchasingmanagerCommodity purchasingmanagerCommodity,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(purchasingmanagerCommodityManager.getPagerPurchasingmanagerCommoditys(
				dataIn.getPager(),
				dataIn.getConditions(purchasingmanagerCommodity, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存商品信息
	 */
	@RequestMapping(value="/savePurchasingmanagerCommodity.json")
	@DataInfo(functionId="32030104",text="保存商品信息",log=true)
	public DataModelAndView savePurchasingmanagerCommodity(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerCommodity> dataIn,
    		@ModelAttribute PurchasingmanagerCommodity purchasingmanagerCommodity,
    		BindingResult result){
		PurchasingmanagerCommodity webPurchasingmanagerCommodity =dataIn.getDomain(purchasingmanagerCommodity, result);//TODO 使用泛型
		PurchasingmanagerCommodity savePurchasingmanagerCommodity = null;
		if(webPurchasingmanagerCommodity!=null){
			savePurchasingmanagerCommodity = purchasingmanagerCommodityManager.savePurchasingmanagerCommodity((PurchasingmanagerCommodity)webPurchasingmanagerCommodity);
		}
		return new DataModelAndView(savePurchasingmanagerCommodity);
	}
	
	/**
	 * 主键删除商品信息
	 */
	@RequestMapping(value="/removePurchasingmanagerCommodity.json")
	@DataInfo(functionId="32030105",text="主键删除商品信息",log=true)
	public DataModelAndView removePurchasingmanagerCommodity(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("purchasingmanagerCommodityId") String purchasingmanagerCommodityId){
		purchasingmanagerCommodityManager.removePurchasingmanagerCommodity(purchasingmanagerCommodityId);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除商品信息
	 */
	@RequestMapping(value="/removePurchasingmanagerCommoditys.json")
	@DataInfo(functionId="32030106",text="主键集合删除商品信息",log=true)
	public DataModelAndView removePurchasingmanagerCommoditys(
    		HttpServletRequest request,
    		HttpServletResponse response){
		purchasingmanagerCommodityManager.removePurchasingmanagerCommoditys(request.getParameterValues("purchasingmanagerCommodityId"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
