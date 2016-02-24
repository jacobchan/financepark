package com.gsoft.framework.core.dataobj.tree;

import org.springframework.util.Assert;
import com.common.BuildingBaseManager.entity.BbmBuilding;
import com.common.BuildingBaseManager.entity.BbmFloor;
import com.common.BuildingBaseManager.entity.BbmPark;
import com.common.BuildingBaseManager.entity.BbmRoom;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 园区、楼栋、楼层、单元树
 * @author maogf
 *
 */
public class BbmRoomHtmlTreeNode extends HtmlTreeNode{
	private static final long serialVersionUID = 1L;
	
	public BbmRoomHtmlTreeNode(String id, String text){
		super(id, text);
	}
	
	public BbmRoomHtmlTreeNode(Domain domain) {
		super(domain);
		Assert.notNull(domain, "domain对象不能为空！");
		if(domain instanceof BbmPark){
			injectBbmParkFromDomain((BbmPark)domain); 
		}else if(domain instanceof BbmBuilding){
			injectBbmBuildingFromDomain((BbmBuilding)domain);
		}else if(domain instanceof BbmFloor){
			injectBbmFloorFromDomain((BbmFloor)domain);
		}else if(domain instanceof BbmRoom){
			injectBbmRoomFromDomain((BbmRoom)domain);
		}
		setDomain(domain);
	}
	//单元属性赋值到树节点
	private void injectBbmRoomFromDomain(BbmRoom bbmRoom) {
		setId(bbmRoom.getRoomId());
		setText(bbmRoom.getRoomNo());
		setParentId(bbmRoom.getBbmFloor().getFloorId());
	}
	//楼层属性赋值到树节点
	private void injectBbmFloorFromDomain(BbmFloor bbmFloor) {
		setId(bbmFloor.getFloorId());
		setText(bbmFloor.getFloorNo());
		setParentId(bbmFloor.getBbmBuilding().getBuildingId());
	}
	//楼栋属性赋值到树节点
	private void injectBbmBuildingFromDomain(BbmBuilding bbmBuilding) {
		setId(bbmBuilding.getBuildingId());
		setText(bbmBuilding.getBuildingNo());
		setParentId(bbmBuilding.getBbmPark().getParkId());
	}
	//园区属性赋值到树节点
	private void injectBbmParkFromDomain(BbmPark bbmPark){
		setId(bbmPark.getParkId());
		setText(bbmPark.getParkName());
	}
}

