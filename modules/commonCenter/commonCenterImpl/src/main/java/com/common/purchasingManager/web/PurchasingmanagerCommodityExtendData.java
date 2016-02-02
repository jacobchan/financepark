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

import com.common.purchasingManager.entity.PurchasingmanagerCommodityExtend;
import com.common.purchasingManager.service.PurchasingmanagerCommodityExtendManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/purchasingManager/purchasingmanagerCommodityExtend")
public class PurchasingmanagerCommodityExtendData extends BaseDataController{

	@Autowired
	private PurchasingmanagerCommodityExtendManager purchasingmanagerCommodityExtendManager;
	
	
	/**
	 * 主键查询采购商品信息扩展
	 */
	@RequestMapping(value="/getPurchasingmanagerCommodityExtend.json")
	@DataInfo(functionId="32030201",text="主键查询采购商品信息扩展")
	public DataModelAndView getPurchasingmanagerCommodityExtend(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("purchasingmanagerCommodityExtendId") String purchasingmanagerCommodityExtendId){
		return new DataModelAndView(purchasingmanagerCommodityExtendManager.getPurchasingmanagerCommodityExtend(purchasingmanagerCommodityExtendId));
	}
	
	/**
	 * 通用采购商品信息扩展查询
	 */
	@RequestMapping(value="/getPurchasingmanagerCommodityExtends.json")
	@DataInfo(functionId="32030202",text="通用采购商品信息扩展查询")
	public DataModelAndView getPurchasingmanagerCommodityExtends(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerCommodityExtend> dataIn,
    		@ModelAttribute PurchasingmanagerCommodityExtend purchasingmanagerCommodityExtend,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(purchasingmanagerCommodityExtendManager.getPurchasingmanagerCommodityExtends(
				dataIn.getConditions(purchasingmanagerCommodityExtend, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询采购商品信息扩展
	 */
	@RequestMapping(value="/getPagerPurchasingmanagerCommodityExtends.json")
	@DataInfo(functionId="32030203",text="分页查询采购商品信息扩展")
	public DataModelAndView getPagerPurchasingmanagerCommodityExtends(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerCommodityExtend> dataIn,
    		@ModelAttribute PurchasingmanagerCommodityExtend purchasingmanagerCommodityExtend,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(purchasingmanagerCommodityExtendManager.getPagerPurchasingmanagerCommodityExtends(
				dataIn.getPager(),
				dataIn.getConditions(purchasingmanagerCommodityExtend, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存采购商品信息扩展
	 */
	@RequestMapping(value="/savePurchasingmanagerCommodityExtend.json")
	@DataInfo(functionId="32030204",text="保存采购商品信息扩展",log=true)
	public DataModelAndView savePurchasingmanagerCommodityExtend(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerCommodityExtend> dataIn,
    		@ModelAttribute PurchasingmanagerCommodityExtend purchasingmanagerCommodityExtend,
    		BindingResult result){
		PurchasingmanagerCommodityExtend webPurchasingmanagerCommodityExtend =dataIn.getDomain(purchasingmanagerCommodityExtend, result);//TODO 使用泛型
		PurchasingmanagerCommodityExtend savePurchasingmanagerCommodityExtend = null;
		if(webPurchasingmanagerCommodityExtend!=null){
			savePurchasingmanagerCommodityExtend = purchasingmanagerCommodityExtendManager.savePurchasingmanagerCommodityExtend((PurchasingmanagerCommodityExtend)webPurchasingmanagerCommodityExtend);
		}
		return new DataModelAndView(savePurchasingmanagerCommodityExtend);
	}
	
	/**
	 * 主键删除采购商品信息扩展
	 */
	@RequestMapping(value="/removePurchasingmanagerCommodityExtend.json")
	@DataInfo(functionId="32030205",text="主键删除采购商品信息扩展",log=true)
	public DataModelAndView removePurchasingmanagerCommodityExtend(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("purchasingmanagerCommodityExtendId") String purchasingmanagerCommodityExtendId){
		purchasingmanagerCommodityExtendManager.removePurchasingmanagerCommodityExtend(purchasingmanagerCommodityExtendId);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除采购商品信息扩展
	 */
	@RequestMapping(value="/removePurchasingmanagerCommodityExtends.json")
	@DataInfo(functionId="32030206",text="主键集合删除采购商品信息扩展",log=true)
	public DataModelAndView removePurchasingmanagerCommodityExtends(
    		HttpServletRequest request,
    		HttpServletResponse response){
		purchasingmanagerCommodityExtendManager.removePurchasingmanagerCommodityExtends(request.getParameterValues("purchasingmanagerCommodityExtendId"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
