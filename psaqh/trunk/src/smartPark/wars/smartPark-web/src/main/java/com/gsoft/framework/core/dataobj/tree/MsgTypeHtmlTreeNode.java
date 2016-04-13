 package com.gsoft.framework.core.dataobj.tree;

import org.springframework.util.Assert;

import com.common.MessageCenter.entity.McMsgtype;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 商品类别树
 * @author maogf
 *
 */
public class MsgTypeHtmlTreeNode extends HtmlTreeNode{
	private static final long serialVersionUID = 1L;
	
	public MsgTypeHtmlTreeNode(String id, String text){
     super(id, text);
	}
	
	public MsgTypeHtmlTreeNode(Domain domain) {
		super(domain);
		Assert.notNull(domain, "domain对象不能为空！");
		if(domain instanceof McMsgtype){
			injectMcMsgtypeFromDomain((McMsgtype)domain); 
		}
		setDomain(domain);
	}
	//消息类型属性赋值到树节点
	private void injectMcMsgtypeFromDomain(McMsgtype mcMsgtype){
		setId(mcMsgtype.getMsgTypeId());
		setText(mcMsgtype.getMsgTypeCaption());
		if(mcMsgtype.getMsgTypeParent() != null){
			setParentId(mcMsgtype.getMsgTypeParent());
		}
	}
 }

