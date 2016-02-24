 package com.gsoft.framework.core.dataobj.tree;

import org.springframework.util.Assert;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 商品类别树
 * @author maogf
 *
 */
public class GenreHtmlTreeNode extends HtmlTreeNode{
	private static final long serialVersionUID = 1L;
	
	public GenreHtmlTreeNode(String id, String text){
     super(id, text);
	}
	
	public GenreHtmlTreeNode(Domain domain) {
		super(domain);
		Assert.notNull(domain, "domain对象不能为空！");
		if(domain instanceof PurchasingmanagerGenre){
			injectGenreFromDomain((PurchasingmanagerGenre)domain); 
		}
		setDomain(domain);
	}
	//商品类别属性赋值到树节点
	private void injectGenreFromDomain(PurchasingmanagerGenre genre){
		setId(genre.getGenreId());
		setText(genre.getGenreName());
		if(genre.getPurchasingmanagerGenre() != null){
			setParentId(genre.getPurchasingmanagerGenre().getGenreId());
		}
	}
 }

