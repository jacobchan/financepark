 package com.gsoft.framework.core.dataobj.tree;
 
 import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.gsoft.framework.core.dataobj.Domain;
import com.gsoft.framework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
 public class TreeUtils
 {
   private static final Log logger = LogFactory.getLog(TreeUtils.class);
 
   public static Map<String, Object> getValueMapFromDomain(Domain domain)
   {
     Map values = new HashMap();
 
     values.put("group", domain.getClass().getSimpleName().toLowerCase());
 
     List<Method> methods = ReflectionUtils.annotationedGetterMethod(domain.getClass(), TreeAttribute.class);
     for (Method method : methods) {
       TreeAttribute treeAttribute = (TreeAttribute)method.getAnnotation(TreeAttribute.class);
       if (treeAttribute != null) {
         Object value = getTreeAttributeMethodValue(domain, method);
         if (value != null) {
           values.put(treeAttribute.value(), value);
         }
       }
     }
     return values;
   }
   
   public static Map<String, Object> getGenreValueMapFromDomain(PurchasingmanagerGenre genre){
     Map values = new HashMap();
     values.put("genreId", genre.getGenreId());
     values.put("genreName", genre.getGenreName());
     values.put("purchasingmanagerGenre", genre.getPurchasingmanagerGenre());
     return values;
   }
 
   public static HtmlTreeNode listToHtmlTree(List list, String rootId, String rootText, int maxLevel)
   {
     return listToHtmlTree(list, rootId, rootText, maxLevel, null);
   }
 
   public static HtmlTreeNode listToHtmlTree(List list, String rootId, String rootText)
   {
     return listToHtmlTree(list, rootId, rootText, 0, null);
   }
 
   public static List<TreeNode> listToTreeNodes(List<? extends Domain> list, TreeNodeConfig treeNodeConfig)
   {
     List treeNodes = new ArrayList();
     for (Domain domain : list) {
       treeNodes.add(new HtmlTreeNode(domain, treeNodeConfig));
     }
     return treeNodes;
   }
 
   public static HtmlTreeNode listToHtmlTree(List<? extends Domain> list, String rootId, String rootText, TreeNodeConfig treeNodeConfig)
   {
     return listToHtmlTree(list, rootId, rootText, 0, treeNodeConfig);
   }
 
   public static HtmlTreeNode listToHtmlTree(List<? extends Domain> list, String rootId, String rootText, int maxLevel, TreeNodeConfig treeNodeConfig)
   {
     HtmlTreeNode root = new HtmlTreeNode(rootId, rootText, treeNodeConfig);
     root.setGroup("root");
 
     makeHtmlTree(root, listToTreeNodes(list, treeNodeConfig), 0, maxLevel);
 
     return root;
   }
 
   private static void makeHtmlTree(TreeNode root, List<TreeNode> treeNodes, int level, int maxLevel)
   {
     String parentId = root.getId();
     List newTreeNodesList;
     if (treeNodes.size() > 0) {
       treeNodes.remove(root);
       newTreeNodesList = new ArrayList(treeNodes);
       if ((maxLevel > 0) && (level >= maxLevel)) return;
       for (TreeNode treeNode : treeNodes)
         if (isCurrentRootChild(parentId, treeNode)) {
           root.addChild(treeNode);
           makeHtmlTree(treeNode, newTreeNodesList, level + 1, maxLevel);
         }
     }
   }
 
   private static boolean isCurrentRootChild(String parentId, TreeNode treeNode)
   {
     String nodeParentId = treeNode.getParentId();
     if ("".equals(parentId)) parentId = null;
     return ((parentId == null) && (nodeParentId == null)) || ((parentId != null) && (parentId.equals(nodeParentId)));
   }
 
   private static Object getTreeAttributeMethodValue(Domain domain, Method method)
   {
     String methodName = method.getName();
     if (methodName.startsWith("get"))
       try {
         return method.invoke(domain, new Object[0]);
       } catch (IllegalArgumentException e) {
         logger.error("IllegalArgumentException:" + e.getMessage());
       } catch (IllegalAccessException e) {
         logger.error("IllegalAccessException:" + e.getMessage());
       } catch (InvocationTargetException e) {
         logger.error("InvocationTargetException:" + e.getMessage());
       }
     else {
       logger.warn("请在get方法上使用TreeAttribute注释！");
     }
     return null;
   }
 }

