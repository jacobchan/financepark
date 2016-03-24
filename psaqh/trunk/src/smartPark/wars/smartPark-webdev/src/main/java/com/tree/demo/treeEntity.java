package com.tree.demo;

public class treeEntity {
	private String Id;
	private String parendId;
	private String name;
	private int level;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getParendId() {
		return parendId;
	}
	public void setParendId(String parendId) {
		this.parendId = parendId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
