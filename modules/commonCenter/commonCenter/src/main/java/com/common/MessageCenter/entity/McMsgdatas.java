/**
 *
 */
package com.common.MessageCenter.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.MessageCenter.service.IMessage;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 消息列表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_mc_msgDatas_")
public class McMsgdatas implements Domain,IMessage{
	
	private static final long serialVersionUID = -56665491399218572L;
	

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "MSG_CONTENT_")
	@Length(max=256)
	private String msgContent;//消息内容

	@Column(name = "RECEIVE_")
	@Length(max=36)
	private String receive;//接收人

	@Column(name = "SEND_DATE_")
	@Length(max=20)
	private String sendDate;//发送时间
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "MSG_ID_")
	@Length(max=36)
	private String msgId;//消息ID

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "MSG_CAPTION_")
	@Length(max=36)
	private String msgCaption;//消息主题

	/**
	 * 0：注册 1：后台用户 2：企业管理员 3：会员
	 */
	@Column(name = "MSG_TYPE_")
	@Length(max=36)
	private String msgType;//消息类型

	/**
	 * 00-待发送，01-发送成功，02-发送失败
	 */
	@Column(name = "SEND_STATUS_")
	@Length(max=2)
	private String sendStatus;//发送状态
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MSG_TEMPALATE_ID_")
	private com.common.MessageCenter.entity.McMsgtempalate mcMsgtempalate;//消息模板ID
	
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getMsgContent(){
		return this.msgContent;
	}
	
	public void setMsgContent(String msgContent){
		this.msgContent = msgContent;
	}
	public String getReceive(){
		return this.receive;
	}
	
	public void setReceive(String receive){
		this.receive = receive;
	}
	public String getSendDate(){
		return this.sendDate;
	}
	
	public void setSendDate(String sendDate){
		this.sendDate = sendDate;
	}
	public String getMsgId(){
		return this.msgId;
	}
	
	public void setMsgId(String msgId){
		this.msgId = msgId;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getMsgCaption(){
		return this.msgCaption;
	}
	
	public void setMsgCaption(String msgCaption){
		this.msgCaption = msgCaption;
	}
	public String getMsgType(){
		return this.msgType;
	}
	
	public void setMsgType(String msgType){
		this.msgType = msgType;
	}
	public String getSendStatus(){
		return this.sendStatus;
	}
	
	public void setSendStatus(String sendStatus){
		this.sendStatus = sendStatus;
	}
	
	public void setMcMsgtempalate(com.common.MessageCenter.entity.McMsgtempalate mcMsgtempalate){
		this.mcMsgtempalate = mcMsgtempalate;
	}
	
	public com.common.MessageCenter.entity.McMsgtempalate getMcMsgtempalate(){
		return this.mcMsgtempalate;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((msgContent == null) ? 0 : msgContent.hashCode());
		result = prime * result + ((receive == null) ? 0 : receive.hashCode());
		result = prime * result + ((sendDate == null) ? 0 : sendDate.hashCode());
		result = prime * result + ((msgId == null) ? 0 : msgId.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((msgCaption == null) ? 0 : msgCaption.hashCode());
		result = prime * result + ((msgType == null) ? 0 : msgType.hashCode());
		result = prime * result + ((sendStatus == null) ? 0 : sendStatus.hashCode());
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
		final McMsgdatas other = (McMsgdatas) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (msgContent == null) {
			if (other.msgContent != null)
				return false;
		} else if (!msgContent.equals(other.msgContent))
			return false;
		if (receive == null) {
			if (other.receive != null)
				return false;
		} else if (!receive.equals(other.receive))
			return false;
		if (sendDate == null) {
			if (other.sendDate != null)
				return false;
		} else if (!sendDate.equals(other.sendDate))
			return false;
		if (msgId == null) {
			if (other.msgId != null)
				return false;
		} else if (!msgId.equals(other.msgId))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (msgCaption == null) {
			if (other.msgCaption != null)
				return false;
		} else if (!msgCaption.equals(other.msgCaption))
			return false;
		if (msgType == null) {
			if (other.msgType != null)
				return false;
		} else if (!msgType.equals(other.msgType))
			return false;
		if (sendStatus == null) {
			if (other.sendStatus != null)
				return false;
		} else if (!sendStatus.equals(other.sendStatus))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}