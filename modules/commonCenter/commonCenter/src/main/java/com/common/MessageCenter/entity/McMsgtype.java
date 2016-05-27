/**
 *
 */
package com.common.MessageCenter.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
import com.gsoft.framework.core.dataobj.tree.TreeAttribute;
/**
 * 实体: 消息类型
 * @author
 * @version
 * 
 */
/**
 * @author ASUS
 *
 */
@Entity
@Table(name = "sp_mc_msgType_")
public class McMsgtype implements Domain{
	
	private static final long serialVersionUID = 4963290134330395478L;
	

	@Column(name = "MSG_TYPE_CAPTION_")
	@Length(max=36)
	private String msgTypeCaption;//消息类型名称

	@Column(name = "MSG_TYPE_STATUS_")
	@Length(max=2)
	private String msgTypeStatus;//消息类型状态

	@Column(name = "MSG_TYPE_PARENT_")
	@Length(max=36)
	private String msgTypeParent;//消息类型上级
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "MSG_TYPE_ID_")
	@Length(max=36)
	private String msgTypeId;//消息类型ID

	@Column(name = "IS_LEAF_")
	@Length(max=1)
	private String isLeaf;//是否子节点
	
	@Transient
	private String parentTypeCaption;
    /**新增园区字段   start**/
	@Column(name = "PARK_NAME_")
	@Length(max=256)
	private String parkName;//园区名称
	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区id
	/**新增园区字段   end**/ 

	/**新增园区字段   start**/
	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getParkId() {
		return parkId;
	}

	public void setParkId(String parkId) {
		this.parkId = parkId;
	}
	/**新增园区字段   end**/
	public String getParentTypeCaption() {
		return parentTypeCaption;
	}
	public void setParentTypeCaption(String parentTypeCaption) {
		this.parentTypeCaption = parentTypeCaption;
	}
	@TreeAttribute("text")
	public String getMsgTypeCaption(){
		return this.msgTypeCaption;
	}
	
	public void setMsgTypeCaption(String msgTypeCaption){
		this.msgTypeCaption = msgTypeCaption;
	}
	public String getMsgTypeStatus(){
		return this.msgTypeStatus;
	}
	
	public void setMsgTypeStatus(String msgTypeStatus){
		this.msgTypeStatus = msgTypeStatus;
	}
	@TreeAttribute("parentId")
	public String getMsgTypeParent(){
		return this.msgTypeParent;
	}
	
	public void setMsgTypeParent(String msgTypeParent){
		this.msgTypeParent = msgTypeParent;
	}
	@TreeAttribute("id")
	public String getMsgTypeId(){
		return this.msgTypeId;
	}
	
	public void setMsgTypeId(String msgTypeId){
		this.msgTypeId = msgTypeId;
	}
	public String getIsLeaf(){
		return this.isLeaf;
	}
	
	public void setIsLeaf(String isLeaf){
		this.isLeaf = isLeaf;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msgTypeCaption == null) ? 0 : msgTypeCaption.hashCode());
		result = prime * result + ((msgTypeStatus == null) ? 0 : msgTypeStatus.hashCode());
		result = prime * result + ((msgTypeParent == null) ? 0 : msgTypeParent.hashCode());
		result = prime * result + ((msgTypeId == null) ? 0 : msgTypeId.hashCode());
		result = prime * result + ((isLeaf == null) ? 0 : isLeaf.hashCode());

		/**新增园区字段   start**/
		result = prime * result + ((parkName == null) ? 0 : parkName.hashCode());
		result = prime * result + ((parkId == null) ? 0 : parkId.hashCode());
		/**新增园区字段   end**/
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final McMsgtype other = (McMsgtype) obj;
		if (msgTypeCaption == null) {
			if (other.msgTypeCaption != null)
				return false;
		} else if (!msgTypeCaption.equals(other.msgTypeCaption))
			return false;
		if (msgTypeStatus == null) {
			if (other.msgTypeStatus != null)
				return false;
		} else if (!msgTypeStatus.equals(other.msgTypeStatus))
			return false;
		if (msgTypeParent == null) {
			if (other.msgTypeParent != null)
				return false;
		} else if (!msgTypeParent.equals(other.msgTypeParent))
			return false;
		if (msgTypeId == null) {
			if (other.msgTypeId != null)
				return false;
		} else if (!msgTypeId.equals(other.msgTypeId))
			return false;
		if (isLeaf == null) {
			if (other.isLeaf != null)
				return false;
		} else if (!isLeaf.equals(other.isLeaf))
			return false;
		/**新增园区字段   start**/
		if (parkId == null) {
			if (other.parkId != null)
				return false;
		} else if (!parkId.equals(other.parkId))
			return false;
		if (parkName == null) {
			if (other.parkName != null)
				return false;
		} else if (!parkName.equals(other.parkName))
			return false;
		/**新增园区字段   end**/
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}