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
 
@Component("commonCenter.purchasingManager.purchasingmanagerGenre")
 public class GenrePageModel extends AbstractPageModel
   implements IPageModel{
 
	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	
	public ModelMap purchasingmanagerGenre(
			HttpServletRequest request,
			DataIn<PurchasingmanagerGenre> dataIn){
		ModelMap modelMap = new ModelMap();
		List<PurchasingmanagerGenre> genres = this.purchasingmanagerGenreManager.getPurchasingmanagerGenres();
		GenreHtmlTreeNode genreTree = ParkTreeUtils.listToGenreTree(genres, null, "商品类别");
		genreTree.setId("tree_genre_root");
		modelMap.addAttribute("genreTree", genreTree);
		return modelMap;
	}
	
	public ModelMap addPurchasingmanagerGenre(
			HttpServletRequest request,
			DataIn<PurchasingmanagerGenre> dataIn){
		ModelMap modelMap = new ModelMap();
		List<PurchasingmanagerGenre> genres = this.purchasingmanagerGenreManager.getPurchasingmanagerGenres();
		GenreHtmlTreeNode genreTree = ParkTreeUtils.listToGenreTree(genres, null, "商品类别");
		genreTree.setId("tree_genre_root");
		modelMap.addAttribute("genreTree", genreTree);
		return modelMap;
	}
 }

