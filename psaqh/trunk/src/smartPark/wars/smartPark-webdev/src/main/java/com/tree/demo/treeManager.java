package com.tree.demo;

import java.util.*;

public class treeManager {
	
	private List<treeEntity> treeList;
	public List<treeEntity> getTreeList() {
		return treeList;
	}

	public void setTreeList(List<treeEntity> treeList) {
		this.treeList = treeList;
	}

	private static int count = 0;
	
	public treeManager(){
		treeList = new ArrayList<treeEntity>();
		treeEntity tree = new treeEntity();
		tree.setId("01");
		tree.setName("A1");
		tree.setLevel(0);
		treeList.add(tree);
		this.addSubTree(tree, 3);

		treeEntity tree2 = new treeEntity();
		tree.setId("02");
		tree.setName("B1");
		treeList.add(tree2);
		this.addSubTree(tree2, 2);
		treeEntity tree3 = new treeEntity();
		tree.setId("03");
		tree.setName("C1");
		this.addSubTree(tree3, 1);
	}
	
	/**
	 * 构建数结构的子节点
	 * @param parentTree 子节点
	 * @param subCount 子节点的数量
	 */
	private void addSubTree(treeEntity parentTree,int subCount){
		//限制数层级只有三级
		if(parentTree.getLevel() == 3)return;
		//递归构建树数据
		for(int i=1; i<subCount+1;i++){
			treeEntity subtree = new treeEntity();
			subtree.setParendId(parentTree.getId());
			subtree.setName(parentTree.getName() + "-" + String.valueOf(i));
			subtree.setId(parentTree.getId() + "-" + String.valueOf(i));
			subtree.setLevel(parentTree.getLevel() +1);
			this.treeList.add(subtree);
			this.addSubTree(subtree, 2);
		}
	}
	
	private List<treeEntity> subTrees = new ArrayList<treeEntity>();
	
	
	/**
	 * 递归展示数控件,这里还可以定义获取多少层级的子节点
	 * @param parentId 父节点ID
	 * @return 所有父节点下的所有子节点
	 */
	public List<treeEntity> getSubTree(String parentId){
		for(treeEntity tree : this.treeList){
			if(tree.getParendId()!=null && tree.getParendId().equals(parentId)){
				subTrees.add(tree);
				this.getSubTree(tree.getId());
			}
		}
		return subTrees;
	}
}
