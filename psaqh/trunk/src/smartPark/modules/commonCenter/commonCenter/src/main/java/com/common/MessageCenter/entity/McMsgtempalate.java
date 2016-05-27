/**
 *
 */
package com.common.MessageCenter.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 消息模板
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_mc_msgTempalate_")
public class McMsgtempalate implements Domain{
	
	private static final long serialVersionUID = -4543177201732447798L;
	

	@Column(name = "MSG_TEMPALATE_PARAMS_")
	@Length(max=256)
	private String msgTempalateParams;//模板参数

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "MSG_TEMPALATE_CONTENT_")
//	@Length(max=56)
	private String msgTempalateContent;//模板内容

	@Column(name = "MSG_RECEIVETYPE_")
	@Length(max=2)
	private String msgReceivetype;//接收人类型
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "MSG_TEMPALATE_ID_")
	@Length(max=36)
	private String msgTempalateId;//消息模板ID

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "MSG_RECEIVER_")
	@Length(max=36)
	private String msgReceiver;//接收人

	@Column(name = "unique_code_")
	@Length(max=12)
	private String uniqueCode;//模板唯一码

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "MSG_TEMPUSE_")
	@Length(max=2)
	private String msgTempuse;//模板使用状态

	@Column(name = "MSG_TEMPALATE_CAPTION_")
	@Length(max=32)
	private String msgTempalateCaption;//消息模板标题
	
	@ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name="MSG_TYPE_ID_")
	private com.common.MessageCenter.entity.McMsgtype mcMsgtype;//消息类型ID
    /**新增园区字段   start**/
	@Column(name = "PARK_NAME_")
	@Length(max=256)
	private String parkName;//园区名称
	
	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区id
	/**新增园区字段   end**/
	public String getMsgTempalateParams(){
		return this.msgTempalateParams;
	}
	
	public void setMsgTempalateParams(String msgTempalateParams){
		this.msgTempalateParams = msgTempalateParams;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getMsgTempalateContent(){
		return this.msgTempalateContent;
	}
	
	public void setMsgTempalateContent(String msgTempalateContent){
		this.msgTempalateContent = msgTempalateContent;
	}
	public String getMsgReceivetype(){
		return this.msgReceivetype;
	}
	
	public void setMsgReceivetype(String msgReceivetype){
		this.msgReceivetype = msgReceivetype;
	}
	public String getMsgTempalateId(){
		return this.msgTempalateId;
	}
	
	public void setMsgTempalateId(String msgTempalateId){
		this.msgTempalateId = msgTempalateId;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getMsgReceiver(){
		return this.msgReceiver;
	}
	
	public void setMsgReceiver(String msgReceiver){
		this.msgReceiver = msgReceiver;
	}
	public String getUniqueCode(){
		return this.uniqueCode;
	}
	
	public void setUniqueCode(String uniqueCode){
		this.uniqueCode = uniqueCode;
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
	public String getMsgTempuse(){
		return this.msgTempuse;
	}
	
	public void setMsgTempuse(String msgTempuse){
		this.msgTempuse = msgTempuse;
	}
	public String getMsgTempalateCaption(){
		return this.msgTempalateCaption;
	}
	
	public void setMsgTempalateCaption(String msgTempalateCaption){
		this.msgTempalateCaption = msgTempalateCaption;
	}
	
	public void setMcMsgtype(com.common.MessageCenter.entity.McMsgtype mcMsgtype){
		this.mcMsgtype = mcMsgtype;
	}
	
	public com.common.MessageCenter.entity.McMsgtype getMcMsgtype(){
		return this.mcMsgtype;
	}
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msgTempalateParams == null) ? 0 : msgTempalateParams.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((msgTempalateContent == null) ? 0 : msgTempalateContent.hashCode());
		result = prime * result + ((msgReceivetype == null) ? 0 : msgReceivetype.hashCode());
		result = prime * result + ((msgTempalateId == null) ? 0 : msgTempalateId.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((msgReceiver == null) ? 0 : msgReceiver.hashCode());
		result = prime * result + ((uniqueCode == null) ? 0 : uniqueCode.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((msgTempuse == null) ? 0 : msgTempuse.hashCode());
		result = prime * result + ((msgTempalateCaption == null) ? 0 : msgTempalateCaption.hashCode());
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
		final McMsgtempalate other = (McMsgtempalate) obj;
		if (msgTempalateParams == null) {
			if (other.msgTempalateParams != null)
				return false;
		} else if (!msgTempalateParams.equals(other.msgTempalateParams))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (msgTempalateContent == null) {
			if (other.msgTempalateContent != null)
				return false;
		} else if (!msgTempalateContent.equals(other.msgTempalateContent))
			return false;
		if (msgReceivetype == null) {
			if (other.msgReceivetype != null)
				return false;
		} else if (!msgReceivetype.equals(other.msgReceivetype))
			return false;
		if (msgTempalateId == null) {
			if (other.msgTempalateId != null)
				return false;
		} else if (!msgTempalateId.equals(other.msgTempalateId))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (msgReceiver == null) {
			if (other.msgReceiver != null)
				return false;
		} else if (!msgReceiver.equals(other.msgReceiver))
			return false;
		if (uniqueCode == null) {
			if (other.uniqueCode != null)
				return false;
		} else if (!uniqueCode.equals(other.uniqueCode))
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
		if (msgTempuse == null) {
			if (other.msgTempuse != null)
				return false;
		} else if (!msgTempuse.equals(other.msgTempuse))
			return false;
		if (msgTempalateCaption == null) {
			if (other.msgTempalateCaption != null)
				return false;
		} else if (!msgTempalateCaption.equals(other.msgTempalateCaption))
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