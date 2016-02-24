 package com.gsoft.framework.core.dataobj.tree;
 
import com.common.purchasingManager.entity.PurchasingmanagerGenre;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
public class ParkTreeUtils{
   @SuppressWarnings("unused")
   private static final Log logger = LogFactory.getLog(ParkTreeUtils.class);
   //园区、楼栋、楼层、单元树
   public static BbmRoomHtmlTreeNode listToBbmRoomTree(
		   List<TreeNode> treeList, String rootId, String rootText){
	 BbmRoomHtmlTreeNode root = new BbmRoomHtmlTreeNode(rootId, rootText);
     root.setGroup("root");
     makeHtmlTree(root, treeList, 0, 0);
     return root;
   }
   //商品类别树
   public static GenreHtmlTreeNode listToGenreTree(
			List<PurchasingmanagerGenre> list, String rootId, String rootText) {
	   GenreHtmlTreeNode root = new GenreHtmlTreeNode(rootId, rootText);
	   root.setGroup("root");
	   List<TreeNode> treeList = new ArrayList<TreeNode>();
	   for (PurchasingmanagerGenre pg : list) {
		   treeList.add(new GenreHtmlTreeNode(pg));
	   }
	   makeHtmlTree(root, treeList, 0, 0);
	   return root;
	}
   
   private static void makeHtmlTree(TreeNode root, List<TreeNode> treeNodes, int level, int maxLevel){
     String parentId = root.getId();
     List<TreeNode> newTreeNodesList;
     if (treeNodes.size() > 0) {
       treeNodes.remove(root);
       newTreeNodesList = new ArrayList<TreeNode>(treeNodes);
       if ((maxLevel > 0) && (level >= maxLevel)) return;
       for (TreeNode treeNode : treeNodes)
         if (isCurrentRootChild(parentId, treeNode)) {
           root.addChild(treeNode);
           makeHtmlTree(treeNode, newTreeNodesList, level + 1, maxLevel);
         }
     }
   }
   
   private static boolean isCurrentRootChild(String parentId, TreeNode treeNode){
     String nodeParentId = treeNode.getParentId();
     if ("".equals(parentId)) parentId = null;
     return ((parentId == null) && (nodeParentId == null)) || ((parentId != null) && (parentId.equals(nodeParentId)));
   }


   
//   public static Map<String, Object> getGenreValueMapFromDomain(PurchasingmanagerGenre genre){
//     Map values = new HashMap();
//     values.put("genreId", genre.getGenreId());
//     values.put("genreName", genre.getGenreName());
//     values.put("purchasingmanagerGenre", genre.getPurchasingmanagerGenre());
//     return values;
//   }
// 
//   public static HtmlTreeNode listToHtmlTree(List list, String rootId, String rootText, int maxLevel)
//   {
//     return listToHtmlTree(list, rootId, rootText, maxLevel, null);
//   }
// 
//   
// 
//   public static List<TreeNode> listToTreeNodes(List<? extends Domain> list, TreeNodeConfig treeNodeConfig)
//   {
//     List treeNodes = new ArrayList();
//     for (Domain domain : list) {
//       treeNodes.add(new HtmlTreeNode(domain, treeNodeConfig));
//     }
//     return treeNodes;
//   }
// 
//   public static HtmlTreeNode listToHtmlTree(List<? extends Domain> list, String rootId, String rootText, TreeNodeConfig treeNodeConfig)
//   {
//     return listToHtmlTree(list, rootId, rootText, 0, treeNodeConfig);
//   }
// 
//   public static HtmlTreeNode listToHtmlTree(List<? extends Domain> list, String rootId, String rootText, int maxLevel, TreeNodeConfig treeNodeConfig)
//   {
//     HtmlTreeNode root = new HtmlTreeNode(rootId, rootText, treeNodeConfig);
//     root.setGroup("root");
// 
//     makeHtmlTree(root, listToTreeNodes(list, treeNodeConfig), 0, maxLevel);
// 
//     return root;
//   }
// 
//  
// 
   
// 
//   private static Object getTreeAttributeMethodValue(Domain domain, Method method)
//   {
//     String methodName = method.getName();
//     if (methodName.startsWith("get"))
//       try {
//         return method.invoke(domain, new Object[0]);
//       } catch (IllegalArgumentException e) {
//         logger.error("IllegalArgumentException:" + e.getMessage());
//       } catch (IllegalAccessException e) {
//         logger.error("IllegalAccessException:" + e.getMessage());
//       } catch (InvocationTargetException e) {
//         logger.error("InvocationTargetException:" + e.getMessage());
//       }
//     else {
//       logger.warn("请在get方法上使用TreeAttribute注释！");
//     }
//     return null;
//   }
}

