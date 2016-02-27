package com.common.MessageCenter.web.attr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.common.MessageCenter.entity.McMsgtype;
import com.common.MessageCenter.service.McMsgtypeManager;
import com.gsoft.framework.core.dataobj.tree.HtmlTreeNode;
import com.gsoft.framework.core.dataobj.tree.TreeUtils;
import com.gsoft.framework.core.web.AbstractPageModel;
import com.gsoft.framework.core.web.IPageModel;
import com.gsoft.framework.core.web.controller.DataIn;

@Component("commonCenter.MessageCenter.mcMsgdatas")
public class MsgDataPage extends AbstractPageModel implements IPageModel{
	
	@Autowired
	private McMsgtypeManager msgtypeManager;

	  public ModelMap mcMsgdatas(HttpServletRequest request, DataIn<McMsgtype> dataIn)	  {
	    return buildTreeModel();
	  }

	private ModelMap buildTreeModel() {
	    ModelMap modelMap = new ModelMap();

	    List<McMsgtype> types = this.msgtypeManager.getMcMsgtypes();
	    HtmlTreeNode typeTree = TreeUtils.listToHtmlTree(types, null, "消息类型");

	    typeTree.setId("tree_type_root");
	    modelMap.addAttribute("typeTree", typeTree);
		return modelMap;
	}
}	
