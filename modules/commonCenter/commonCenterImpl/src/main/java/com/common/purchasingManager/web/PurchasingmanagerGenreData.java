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

import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/purchasingManager/purchasingmanagerGenre")
public class PurchasingmanagerGenreData extends BaseDataController{

	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	
	
	/**
	 * 主键查询商品类别表
	 */
	@RequestMapping(value="/getPurchasingmanagerGenre.json")
	@DataInfo(functionId="32030501",text="主键查询商品类别表")
	public DataModelAndView getPurchasingmanagerGenre(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("purchasingmanagerGenreId") String purchasingmanagerGenreId){
		return new DataModelAndView(purchasingmanagerGenreManager.getPurchasingmanagerGenre(purchasingmanagerGenreId));
	}
	
	/**
	 * 通用商品类别表查询
	 */
	@RequestMapping(value="/getPurchasingmanagerGenres.json")
	@DataInfo(functionId="32030502",text="通用商品类别表查询")
	public DataModelAndView getPurchasingmanagerGenres(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerGenre> dataIn,
    		@ModelAttribute PurchasingmanagerGenre purchasingmanagerGenre,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(purchasingmanagerGenreManager.getPurchasingmanagerGenres(
				dataIn.getConditions(purchasingmanagerGenre, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询商品类别表
	 */
	@RequestMapping(value="/getPagerPurchasingmanagerGenres.json")
	@DataInfo(functionId="32030503",text="分页查询商品类别表")
	public DataModelAndView getPagerPurchasingmanagerGenres(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerGenre> dataIn,
    		@ModelAttribute PurchasingmanagerGenre purchasingmanagerGenre,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(purchasingmanagerGenreManager.getPagerPurchasingmanagerGenres(
				dataIn.getPager(),
				dataIn.getConditions(purchasingmanagerGenre, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存商品类别表
	 */
	@RequestMapping(value="/savePurchasingmanagerGenre.json")
	@DataInfo(functionId="32030504",text="保存商品类别表",log=true)
	public DataModelAndView savePurchasingmanagerGenre(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<PurchasingmanagerGenre> dataIn,
    		@ModelAttribute PurchasingmanagerGenre purchasingmanagerGenre,
    		BindingResult result){
		PurchasingmanagerGenre webPurchasingmanagerGenre =dataIn.getDomain(purchasingmanagerGenre, result);//TODO 使用泛型
		PurchasingmanagerGenre savePurchasingmanagerGenre = null;
		if(webPurchasingmanagerGenre!=null){
			savePurchasingmanagerGenre = purchasingmanagerGenreManager.savePurchasingmanagerGenre((PurchasingmanagerGenre)webPurchasingmanagerGenre);
		}
		return new DataModelAndView(savePurchasingmanagerGenre);
	}
	
	/**
	 * 主键删除商品类别表
	 */
	@RequestMapping(value="/removePurchasingmanagerGenre.json")
	@DataInfo(functionId="32030505",text="主键删除商品类别表",log=true)
	public DataModelAndView removePurchasingmanagerGenre(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("purchasingmanagerGenreId") String purchasingmanagerGenreId){
		purchasingmanagerGenreManager.removePurchasingmanagerGenre(purchasingmanagerGenreId);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除商品类别表
	 */
	@RequestMapping(value="/removePurchasingmanagerGenres.json")
	@DataInfo(functionId="32030506",text="主键集合删除商品类别表",log=true)
	public DataModelAndView removePurchasingmanagerGenres(
    		HttpServletRequest request,
    		HttpServletResponse response){
		purchasingmanagerGenreManager.removePurchasingmanagerGenres(request.getParameterValues("purchasingmanagerGenreId"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
