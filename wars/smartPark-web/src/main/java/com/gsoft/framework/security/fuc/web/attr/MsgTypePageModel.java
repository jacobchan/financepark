package com.gsoft.framework.security.fuc.web.attr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.common.MessageCenter.entity.McMsgtype;
import com.common.MessageCenter.service.McMsgtypeManager;
import com.gsoft.framework.core.dataobj.tree.MsgTypeHtmlTreeNode;
import com.gsoft.framework.core.dataobj.tree.ParkTreeUtils;
import com.gsoft.framework.core.web.AbstractPageModel;
import com.gsoft.framework.core.web.IPageModel;
import com.gsoft.framework.core.web.controller.DataIn;

@Component("commonCenter.MessageCenter.mcMsgtype")
public class MsgTypePageModel extends AbstractPageModel implements IPageModel{
	
	@Autowired
	private McMsgtypeManager msgtypeManager;
	
	
	/**
	 * 消息类型页面
	 * @param request
	 * @param dataIn
	 * @return
	 */
	public ModelMap mcMsgtype(
			HttpServletRequest request,
			DataIn<McMsgtype> dataIn){
		ModelMap modelMap = new ModelMap();
		List<McMsgtype> types = this.msgtypeManager.getMcMsgtypes();
		MsgTypeHtmlTreeNode typeTree = ParkTreeUtils.listToMsgType(types, null, "消息类型");
		typeTree.setId("tree_type_root");
		modelMap.addAttribute("typeTree", typeTree);
		return modelMap;
	}
}	
