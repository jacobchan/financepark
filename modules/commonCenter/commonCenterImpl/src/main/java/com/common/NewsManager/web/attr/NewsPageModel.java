package com.common.NewsManager.web.attr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.common.NewsManager.entity.NmIssuetype;
import com.common.NewsManager.service.NmIssuetypeManager;
import com.gsoft.framework.core.dataobj.tree.HtmlTreeNode;
import com.gsoft.framework.core.dataobj.tree.TreeUtils;
import com.gsoft.framework.core.web.AbstractPageModel;
import com.gsoft.framework.core.web.IPageModel;
import com.gsoft.framework.core.web.controller.DataIn;

@Component("cms.commonCenter.NewsManager.nmIssuetype")
public class NewsPageModel extends AbstractPageModel implements IPageModel{
	
	@Autowired
	private NmIssuetypeManager nmIssuetypeManager;

	  public ModelMap nmIssuetype(HttpServletRequest request, DataIn<NmIssuetype> dataIn)	  {
	    return buildTreeModel();
	  }

	private ModelMap buildTreeModel() {
	    ModelMap modelMap = new ModelMap();

	    List<NmIssuetype> types = this.nmIssuetypeManager.getNmIssuetypes();
	    HtmlTreeNode typeTree = TreeUtils.listToHtmlTree(types, null, "发布类型");

	    typeTree.setId("tree_type_root");
	    modelMap.addAttribute("typeTree", typeTree);
		return modelMap;
	}
}
