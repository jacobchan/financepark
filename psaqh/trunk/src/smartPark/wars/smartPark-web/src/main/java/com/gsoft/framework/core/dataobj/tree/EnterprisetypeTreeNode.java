package com.gsoft.framework.core.dataobj.tree;
import org.springframework.util.Assert;
import com.common.EnterpriceTypeManager.entity.EtypeEnterprisetype;
import com.gsoft.framework.core.dataobj.Domain;
@SuppressWarnings("serial")
public class EnterprisetypeTreeNode extends HtmlTreeNode {
	public EnterprisetypeTreeNode(String id, String text) {
		super(id, text);
	}

	public EnterprisetypeTreeNode(Domain domain) {
		super(domain);
		Assert.notNull(domain, "domain对象不能为空！");
		if (domain instanceof EtypeEnterprisetype) {
			injectEtypeEnterpriseFromDomain((EtypeEnterprisetype) domain);
		}
		setDomain(domain);
	}

	// 商品类别属性赋值到树节点
	private void injectEtypeEnterpriseFromDomain(EtypeEnterprisetype enter) {
		setId(enter.getEnTypeId());
		setText(enter.getEnTypeName());
		if (enter.getEtypeEnterprisetype() != null) {
			setParentId(enter.getEtypeEnterprisetype().getEnTypeId());
		}
	}
}