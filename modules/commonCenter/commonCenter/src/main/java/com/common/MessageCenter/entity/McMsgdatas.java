/**
 *
 */
package com.common.MessageCenter.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 消息列表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_mc_msgDatas_")
public class McMsgdatas implements Domain{
	
	private static final long serialVersionUID = -2287077772220002933L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "MSG_ID_")
	@Length(max=36)
	private String msgId;//消息ID

	@Column(name = "MSG_TYPE_")
	@Length(max=36)
	private String msgType;//消息类型

	@Column(name = "SEND_STATUS_")
	@Length(max=2)
	private String sendStatus;//发送状态

	@Column(name = "RECEIVE_")
	@Length(max=36)
	private String receive;//接收人

	@Column(name = "MSG_CONTENT_")
	@Length(max=256)
	private String msgContent;//消息内容

	@Column(name = "SEND_DATE_")
	@Length(max=20)
	private String sendDate;//发送时间

	@Column(name = "MSG_CAPTION_")
	@Length(max=36)
	private String msgCaption;//消息主题
	
	@ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name="MSG_TEMPALATE_ID_")
	private com.common.MessageCenter.entity.McMsgtempalate mcMsgtempalate;//消息模板ID
	
	public String getMsgId(){
		return this.msgId;
	}
	
	public void setMsgId(String msgId){
		this.msgId = msgId;
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
	public String getReceive(){
		return this.receive;
	}
	
	public void setReceive(String receive){
		this.receive = receive;
	}
	public String getMsgContent(){
		return this.msgContent;
	}
	
	public void setMsgContent(String msgContent){
		this.msgContent = msgContent;
	}
	public String getSendDate(){
		return this.sendDate;
	}
	
	public void setSendDate(String sendDate){
		this.sendDate = sendDate;
	}
	public String getMsgCaption(){
		return this.msgCaption;
	}
	
	public void setMsgCaption(String msgCaption){
		this.msgCaption = msgCaption;
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
		result = prime * result + ((msgId == null) ? 0 : msgId.hashCode());
		result = prime * result + ((msgType == null) ? 0 : msgType.hashCode());
		result = prime * result + ((sendStatus == null) ? 0 : sendStatus.hashCode());
		result = prime * result + ((receive == null) ? 0 : receive.hashCode());
		result = prime * result + ((msgContent == null) ? 0 : msgContent.hashCode());
		result = prime * result + ((sendDate == null) ? 0 : sendDate.hashCode());
		result = prime * result + ((msgCaption == null) ? 0 : msgCaption.hashCode());
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
		if (msgId == null) {
			if (other.msgId != null)
				return false;
		} else if (!msgId.equals(other.msgId))
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
		if (receive == null) {
			if (other.receive != null)
				return false;
		} else if (!receive.equals(other.receive))
			return false;
		if (msgContent == null) {
			if (other.msgContent != null)
				return false;
		} else if (!msgContent.equals(other.msgContent))
			return false;
		if (sendDate == null) {
			if (other.sendDate != null)
				return false;
		} else if (!sendDate.equals(other.sendDate))
			return false;
		if (msgCaption == null) {
			if (other.msgCaption != null)
				return false;
		} else if (!msgCaption.equals(other.msgCaption))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}