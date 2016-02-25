package com.gsoft.framework.security.fuc.web.attr;
 
import com.common.BuildingBaseManager.dao.BbmBuildingDao;
import com.common.BuildingBaseManager.dao.BbmFloorDao;
import com.common.BuildingBaseManager.dao.BbmRoomDao;
import com.common.BuildingBaseManager.entity.BbmBuilding;
import com.common.BuildingBaseManager.entity.BbmFloor;
import com.common.BuildingBaseManager.entity.BbmPark;
import com.common.BuildingBaseManager.entity.BbmRoom;
import com.common.BuildingBaseManager.service.BbmParkManager;
import com.gsoft.framework.core.dataobj.tree.BbmRoomHtmlTreeNode;
import com.gsoft.framework.core.dataobj.tree.ParkTreeUtils;
import com.gsoft.framework.core.dataobj.tree.TreeNode;
import com.gsoft.framework.core.web.AbstractPageModel;
import com.gsoft.framework.core.web.IPageModel;
import com.gsoft.framework.core.web.controller.DataIn;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerCharge;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
 /**
  * 物业缴费登记
  * @author maogf
  *
  */
@Component("manageCenter.PropertyServiceManager.propertyservicemanagerCharge")
 public class ChargePageModel extends AbstractPageModel
   implements IPageModel{
	@Autowired
	private BbmParkManager bbmParkManager;
	@Autowired
	private BbmBuildingDao bbmBuildingDao;
	@Autowired
	private BbmFloorDao bbmFloorDao;
	@Autowired
	private BbmRoomDao bbmRoomDao;
	/**
	 * 物业缴费登记查询
	 * @param request
	 * @param dataIn
	 * @return
	 */
	
	public ModelMap propertyservicemanagerCharge(
			HttpServletRequest request,
			DataIn<PropertyservicemanagerCharge> dataIn){
		ModelMap modelMap = new ModelMap();
		BbmRoomHtmlTreeNode bbmRoomTree = getBbmRoomTree();
		modelMap.addAttribute("bbmRoomTree", bbmRoomTree);
		return modelMap;
	}
	/**
	 * 增加物业缴费登记
	 * @param request
	 * @param dataIn
	 * @return
	 */
	public ModelMap addSFproManage(
			HttpServletRequest request,
			DataIn<PropertyservicemanagerCharge> dataIn){
		ModelMap modelMap = new ModelMap();
		BbmRoomHtmlTreeNode bbmRoomTree = getBbmRoomTree();
		modelMap.addAttribute("bbmRoomTree", bbmRoomTree);
		return modelMap;
	}
	/**
	 * 修改物业缴费登记
	 * @param request
	 * @param dataIn
	 * @return
	 */
	public ModelMap updateSFproManage(
			HttpServletRequest request,
			DataIn<PropertyservicemanagerCharge> dataIn){
		ModelMap modelMap = new ModelMap();
		BbmRoomHtmlTreeNode bbmRoomTree = getBbmRoomTree();
		modelMap.addAttribute("bbmRoomTree", bbmRoomTree);
		return modelMap;
	}
	/**
	 * 获取所有的园区、楼栋、楼层、单元组织成的树对象
	 * @return
	 */
	private BbmRoomHtmlTreeNode getBbmRoomTree() {
		List<BbmPark> bbmParks = bbmParkManager.getBbmParks();
		List<TreeNode> treeList = new ArrayList<TreeNode>();
		for (BbmPark bbmPark : bbmParks) {
		   //把所有的园区、楼栋、楼层、单元根据上下级组织成树节点list
		   List<BbmBuilding> bbmBuildingList =  bbmBuildingDao.getList("bbmPark.parkId", bbmPark.getParkId());
		   for(BbmBuilding bbmBuilding:bbmBuildingList){
			   List<BbmFloor> bbmFloorList = bbmFloorDao.getList("bbmBuilding.buildingId", bbmBuilding.getBuildingId());
			   for(BbmFloor bbmFloor:bbmFloorList){
				   List<BbmRoom> bbmRoomList = bbmRoomDao.getList("bbmFloor.floorId", bbmFloor.getFloorId());
				   for(BbmRoom bbmRoom:bbmRoomList){
					   treeList.add(new BbmRoomHtmlTreeNode(bbmRoom));
				   }
				   treeList.add(new BbmRoomHtmlTreeNode(bbmFloor));
			   }
			   treeList.add(new BbmRoomHtmlTreeNode(bbmBuilding));
		   }
		   treeList.add(new BbmRoomHtmlTreeNode(bbmPark.getParkId(),bbmPark.getParkName()));
		}
		BbmRoomHtmlTreeNode bbmRoomTree = ParkTreeUtils.listToBbmRoomTree(treeList, null, "单元");
		bbmRoomTree.setId("tree_bbmRoom_root");
		return bbmRoomTree;
	}
	
 }

