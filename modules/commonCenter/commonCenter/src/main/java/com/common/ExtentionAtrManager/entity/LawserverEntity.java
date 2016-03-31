package com.common.ExtentionAtrManager.entity;

/**
 * 法律服务扩展属性
 * @author jack
 *
 */
public class LawserverEntity {
	
	private String serTerm;//服务期限
	
	public String getSerTermfieldName() {
		return "serTerm";
	}

	public String getSerTerm() {
		return serTerm;
	}

	public void setSerTerm(String serTerm) {
		this.serTerm = serTerm;
	}
	
}
