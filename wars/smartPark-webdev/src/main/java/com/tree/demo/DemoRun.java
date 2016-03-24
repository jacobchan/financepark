package com.tree.demo;

import java.util.List;

public class DemoRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		treeManager manager = new treeManager();
		
		List<treeEntity> list = manager.getSubTree("01");
		for(treeEntity tree : list){
			System.out.println(tree.getName());
		}
	}

}
