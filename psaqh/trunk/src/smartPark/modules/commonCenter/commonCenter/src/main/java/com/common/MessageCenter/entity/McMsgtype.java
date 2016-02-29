/**
 *
 */
package com.common.MessageCenter.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 消息类型
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_mc_msgType_")
public class McMsgtype implements Domain{
	
	private static final long serialVersionUID = 1570515022574340017L;
	

	@Column(name = "MSG_TYPE_PARENT_")
	@Length(max=36)
	private String msgTypeParent;//消息类型上级

	@Column(name = "MSG_TYPE_STATUS_")
	@Length(max=2)
	private String msgTypeStatus;//消息类型状态

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "MSG_TYPE_ID_")
	@Length(max=36)
	private String msgTypeId;//消息类型ID

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "IS_LEAF_")
	@Length(max=1)
	private String isLeaf;//是否子节点

	@Column(name = "MSG_TYPE_CAPTION_")
	@Length(max=36)
	private String msgTypeCaption;//消息类型名称
	
	public String getMsgTypeParent(){
		return this.msgTypeParent;
	}
	
	public void setMsgTypeParent(String msgTypeParent){
		this.msgTypeParent = msgTypeParent;
	}
	public String getMsgTypeStatus(){
		return this.msgTypeStatus;
	}
	
	public void setMsgTypeStatus(String msgTypeStatus){
		this.msgTypeStatus = msgTypeStatus;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getMsgTypeId(){
		return this.msgTypeId;
	}
	
	public void setMsgTypeId(String msgTypeId){
		this.msgTypeId = msgTypeId;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getIsLeaf(){
		return this.isLeaf;
	}
	
	public void setIsLeaf(String isLeaf){
		this.isLeaf = isLeaf;
	}
	public String getMsgTypeCaption(){
		return this.msgTypeCaption;
	}
	
	public void setMsgTypeCaption(String msgTypeCaption){
		this.msgTypeCaption = msgTypeCaption;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msgTypeParent == null) ? 0 : msgTypeParent.hashCode());
		result = prime * result + ((msgTypeStatus == null) ? 0 : msgTypeStatus.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((msgTypeId == null) ? 0 : msgTypeId.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((isLeaf == null) ? 0 : isLeaf.hashCode());
		result = prime * result + ((msgTypeCaption == null) ? 0 : msgTypeCaption.hashCode());
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
		if (msgTypeParent == null) {
			if (other.msgTypeParent != null)
				return false;
		} else if (!msgTypeParent.equals(other.msgTypeParent))
			return false;
		if (msgTypeStatus == null) {
			if (other.msgTypeStatus != null)
				return false;
		} else if (!msgTypeStatus.equals(other.msgTypeStatus))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (msgTypeId == null) {
			if (other.msgTypeId != null)
				return false;
		} else if (!msgTypeId.equals(other.msgTypeId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (isLeaf == null) {
			if (other.isLeaf != null)
				return false;
		} else if (!isLeaf.equals(other.isLeaf))
			return false;
		if (msgTypeCaption == null) {
			if (other.msgTypeCaption != null)
				return false;
		} else if (!msgTypeCaption.equals(other.msgTypeCaption))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}