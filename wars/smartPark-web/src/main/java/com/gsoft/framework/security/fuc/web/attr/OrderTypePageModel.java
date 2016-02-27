package com.gsoft.framework.security.fuc.web.attr;
 
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;
import com.gsoft.framework.core.dataobj.tree.GenreHtmlTreeNode;
import com.gsoft.framework.core.dataobj.tree.ParkTreeUtils;
import com.gsoft.framework.core.web.AbstractPageModel;
import com.gsoft.framework.core.web.IPageModel;
import com.gsoft.framework.core.web.controller.DataIn;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
 /**
  * 订单类型页面属性传值
  * @author maogf
  *
  */
@Component("commonCenter.OrderManager.ordermanagerUserorder")
 public class OrderTypePageModel extends AbstractPageModel
   implements IPageModel{
 
	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	/**
	 * 订单类型查询页面
	 * @param request
	 * @param dataIn
	 * @return
	 */
	public ModelMap orderType(
			HttpServletRequest request,
			DataIn<PurchasingmanagerGenre> dataIn){
		ModelMap modelMap = new ModelMap();
		GenreHtmlTreeNode orderTypeTree = getOrderTypeHtmlTreeNode();
		modelMap.addAttribute("orderTypeTree", orderTypeTree);
		return modelMap;
	}
	
	/**
	 * 订单类型新增页面
	 * @param request
	 * @param dataIn
	 * @return
	 */
	public ModelMap orderTypeAdd(
			HttpServletRequest request,
			DataIn<PurchasingmanagerGenre> dataIn){
		ModelMap modelMap = new ModelMap();
		GenreHtmlTreeNode orderTypeTree = getOrderTypeHtmlTreeNode();
		modelMap.addAttribute("orderTypeTree", orderTypeTree);
		return modelMap;
	}
	/**
	 * 获取订单类型树对象
	 * @return
	 */
	private GenreHtmlTreeNode getOrderTypeHtmlTreeNode() {
		//获取所有的订单类型列表
		List<PurchasingmanagerGenre> genres = purchasingmanagerGenreManager.getOrderTypes();
		GenreHtmlTreeNode orderTypeTree = ParkTreeUtils.listToGenreTree(genres, null, "订单类型");
		orderTypeTree.setId("tree_orderType_root");
		return orderTypeTree;
	}
 }

