package com.gsoft.framework.security.fuc.web.attr;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import com.common.EnterpriceTypeManager.entity.EtypeEnterprisetype;
import com.common.EnterpriceTypeManager.service.EtypeEnterprisetypeManager;
import com.gsoft.framework.core.dataobj.tree.EnterprisetypeTreeNode;
import com.gsoft.framework.core.dataobj.tree.ParkTreeUtils;
import com.gsoft.framework.core.web.AbstractPageModel;
import com.gsoft.framework.core.web.IPageModel;
import com.gsoft.framework.core.web.controller.DataIn;
@Component("manageCenter.EnterBusinessManager.enterbusinessmanagerRz")
public class EnterBusRzPageModel extends AbstractPageModel implements
		IPageModel {
	@Autowired
	private EtypeEnterprisetypeManager etypeEnterprisetypeManager;

	public ModelMap enterbusinessmanagerRz(HttpServletRequest request,
			DataIn<EtypeEnterprisetype> dataIn) {
		ModelMap modelMap = new ModelMap();
		List<EtypeEnterprisetype> enter = this.etypeEnterprisetypeManager.getEtypeEnterprisetypes();
		EnterprisetypeTreeNode enetrTree = ParkTreeUtils.listToEnterTree(enter, null, "企业类型");
		enetrTree.setId("tree_enter_root");
		modelMap.addAttribute("enetrTree", enetrTree);
		return modelMap;
	}
}