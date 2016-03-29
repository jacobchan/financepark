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
@Component("commonCenter.purchasingManager.purchasingmanagerMerchant")
 public class MerchantPageModel extends AbstractPageModel
   implements IPageModel{
 
	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	/**
	 * 商户查询页面
	 * @param request
	 * @param dataIn
	 * @return
	 */
	public ModelMap purchasingmanagerMerchant(
			HttpServletRequest request,
			DataIn<PurchasingmanagerGenre> dataIn){
		ModelMap modelMap = new ModelMap();
		List<PurchasingmanagerGenre> genres = purchasingmanagerGenreManager.getOrderTypes();
		GenreHtmlTreeNode genreTree = ParkTreeUtils.listToGenreTree(genres, null, "商品类别");
		genreTree.setId("tree_genre_root");
		modelMap.addAttribute("genreTree", genreTree);
		return modelMap;
	}
	
 }

