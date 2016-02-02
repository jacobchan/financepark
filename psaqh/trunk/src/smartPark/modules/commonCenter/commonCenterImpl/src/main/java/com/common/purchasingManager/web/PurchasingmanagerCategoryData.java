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

import com.common.purchasingManager.entity.PurchasingmanagerCategory;
import com.common.purchasingManager.service.PurchasingmanagerCategoryManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/purchasingManager/purchasingmanagerCategory")
public class PurchasingmanagerCategoryData extends BaseDataController{

	@Autowired
	private PurchasingmanagerCategoryManager purchasingmanagerCategoryManager;
	
	
	/**
	 * 主键查询商品类目表
	 */
	@RequestMapping(value="/getPurchasingmanagerCategory.json")
	@DataInfo(functionId="32030401",text="主键查询商品类目表")
	public DataModelAndView getPurchasingmanagerCategory(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("purchasingmanagerCategoryId") String purchasingmanagerCategoryId){
		return new DataModelAndView(purchasingmanagerCategoryManager.getPurchasingmanagerCategory(purchasingmanagerCategoryId));
	}
	
	/**
	 * 通用商品类目表查询
	 */
	@RequestMapping(value="/getPurchasingmanagerCategorys.json")
	@DataInfo(functionId="32030402",text="通用商品类目表查询")
	public DataModelAndView getPurchasingmanagerCategorys(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerCategory> dataIn,
    		@ModelAttribute PurchasingmanagerCategory purchasingmanagerCategory,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(purchasingmanagerCategoryManager.getPurchasingmanagerCategorys(
				dataIn.getConditions(purchasingmanagerCategory, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询商品类目表
	 */
	@RequestMapping(value="/getPagerPurchasingmanagerCategorys.json")
	@DataInfo(functionId="32030403",text="分页查询商品类目表")
	public DataModelAndView getPagerPurchasingmanagerCategorys(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerCategory> dataIn,
    		@ModelAttribute PurchasingmanagerCategory purchasingmanagerCategory,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(purchasingmanagerCategoryManager.getPagerPurchasingmanagerCategorys(
				dataIn.getPager(),
				dataIn.getConditions(purchasingmanagerCategory, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存商品类目表
	 */
	@RequestMapping(value="/savePurchasingmanagerCategory.json")
	@DataInfo(functionId="32030404",text="保存商品类目表",log=true)
	public DataModelAndView savePurchasingmanagerCategory(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerCategory> dataIn,
    		@ModelAttribute PurchasingmanagerCategory purchasingmanagerCategory,
    		BindingResult result){
		PurchasingmanagerCategory webPurchasingmanagerCategory =dataIn.getDomain(purchasingmanagerCategory, result);//TODO 使用泛型
		PurchasingmanagerCategory savePurchasingmanagerCategory = null;
		if(webPurchasingmanagerCategory!=null){
			savePurchasingmanagerCategory = purchasingmanagerCategoryManager.savePurchasingmanagerCategory((PurchasingmanagerCategory)webPurchasingmanagerCategory);
		}
		return new DataModelAndView(savePurchasingmanagerCategory);
	}
	
	/**
	 * 主键删除商品类目表
	 */
	@RequestMapping(value="/removePurchasingmanagerCategory.json")
	@DataInfo(functionId="32030405",text="主键删除商品类目表",log=true)
	public DataModelAndView removePurchasingmanagerCategory(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("purchasingmanagerCategoryId") String purchasingmanagerCategoryId){
		purchasingmanagerCategoryManager.removePurchasingmanagerCategory(purchasingmanagerCategoryId);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除商品类目表
	 */
	@RequestMapping(value="/removePurchasingmanagerCategorys.json")
	@DataInfo(functionId="32030406",text="主键集合删除商品类目表",log=true)
	public DataModelAndView removePurchasingmanagerCategorys(
    		HttpServletRequest request,
    		HttpServletResponse response){
		purchasingmanagerCategoryManager.removePurchasingmanagerCategorys(request.getParameterValues("purchasingmanagerCategoryId"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
