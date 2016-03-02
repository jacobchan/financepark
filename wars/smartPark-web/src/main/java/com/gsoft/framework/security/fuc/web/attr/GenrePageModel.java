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
  * 商品类别页面属性传值
  * @author maogf
  *
  */
@Component("commonCenter.purchasingManager.purchasingmanagerGenre")
 public class GenrePageModel extends AbstractPageModel
   implements IPageModel{
 
	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	/**
	 * 商品类别查询页面
	 * @param request
	 * @param dataIn
	 * @return
	 */
	public ModelMap purchasingmanagerGenre(
			HttpServletRequest request,
			DataIn<PurchasingmanagerGenre> dataIn){
		ModelMap modelMap = new ModelMap();
		GenreHtmlTreeNode genreTree = getGenreHtmlTreeNode();
		modelMap.addAttribute("genreTree", genreTree);
		return modelMap;
	}
	
	/**
	 * 商品类别新增页面
	 * @param request
	 * @param dataIn
	 * @return
	 */
	public ModelMap addPurchasingmanagerGenre(
			HttpServletRequest request,
			DataIn<PurchasingmanagerGenre> dataIn){
		ModelMap modelMap = new ModelMap();
		GenreHtmlTreeNode genreTree = getGenreHtmlTreeNode();
		modelMap.addAttribute("genreTree", genreTree);
		return modelMap;
	}
	/**
	 * 获取采购、餐饮、IT服务类别树对象
	 * @return
	 */
	private GenreHtmlTreeNode getGenreHtmlTreeNode() {
		//获取所有的采购、餐饮、IT服务类别列表
		List<PurchasingmanagerGenre> genres = purchasingmanagerGenreManager.getPurFoodGenres();
		GenreHtmlTreeNode genreTree = ParkTreeUtils.listToGenreTree(genres, null, "商品类别");
		genreTree.setId("tree_genre_root");
		return genreTree;
	}
 }

