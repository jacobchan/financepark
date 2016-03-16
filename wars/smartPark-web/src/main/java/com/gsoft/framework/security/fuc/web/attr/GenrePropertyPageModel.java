package com.gsoft.framework.security.fuc.web.attr;
 
import com.common.purchasingManager.entity.PurchasingmanagerCommodityExtend;
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
@Component("commonCenter.purchasingManager.purchasingmanagerGenreProperty")
 public class GenrePropertyPageModel extends AbstractPageModel
   implements IPageModel{
 
	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	/**
	 * 商品扩展属性查询页面
	 * @param request
	 * @param dataIn
	 * @return
	 */
	public ModelMap purchasingmanagerGenreProperty(
			HttpServletRequest request,
			DataIn<PurchasingmanagerCommodityExtend> dataIn){
		ModelMap modelMap = new ModelMap();
		GenreHtmlTreeNode genreTree = getGenreHtmlTreeNode();
		modelMap.addAttribute("genreTree", genreTree);
		return modelMap;
	}
	
	/**
	 * 获取最顶级的商品类型列表
	 * @return
	 */
	private GenreHtmlTreeNode getGenreHtmlTreeNode() {
		//获取所有的订单类型列表
		List<PurchasingmanagerGenre> genreList = purchasingmanagerGenreManager.getPurchasingmanagerGenres();
//		List<PurchasingmanagerGenre> genres = new ArrayList<PurchasingmanagerGenre>();
//		for(PurchasingmanagerGenre pg:genreList){
//			if(pg.getPurchasingmanagerGenre() == null){
//				genres.add(pg);
//			}
//		}
		GenreHtmlTreeNode genreTree = ParkTreeUtils.listToGenreTree(genreList, null, "商品类型");
		genreTree.setId("tree_genreTree_root");
		return genreTree;
	}
 }

