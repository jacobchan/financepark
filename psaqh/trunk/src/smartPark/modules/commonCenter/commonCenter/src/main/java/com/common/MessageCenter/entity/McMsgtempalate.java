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
	
	private static final long serialVersionUID = 6557568774729050165L;
	

	@Column(name = "MSG_TEMPALATE_CONTENT_")
	@Length(max=56)
	private String msgTempalateContent;//模板内容

	@Column(name = "MSG_TEMPALATE_CAPTION_")
	@Length(max=32)
	private String msgTempalateCaption;//消息模板标题
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "MSG_TEMPALATE_ID_")
	@Length(max=36)
	private String msgTempalateId;//消息模板ID

	@Column(name = "MSG_TEMPUSE_")
	@Length(max=2)
	private String msgTempuse;//模板使用状态

	@Column(name = "MSG_RECEIVETYPE_")
	@Length(max=2)
	private String msgReceivetype;//接收人类型

	@Column(name = "MSG_TEMPALATE_PARAMS_")
	@Length(max=256)
	private String msgTempalateParams;//模板参数

	@Column(name = "MSG_RECEIVER_")
	@Length(max=36)
	private String msgReceiver;//接收人
	
	@ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name="MSG_TYPE_ID_")
	private com.common.MessageCenter.entity.McMsgtype mcMsgtype;//消息类型ID
	
	@Column(name="unique_code_")
	private String uniqueCode;
	
	public String getMsgTempalateContent(){
		return this.msgTempalateContent;
	}
	
	public void setMsgTempalateContent(String msgTempalateContent){
		this.msgTempalateContent = msgTempalateContent;
	}
	public String getMsgTempalateCaption(){
		return this.msgTempalateCaption;
	}
	
	public void setMsgTempalateCaption(String msgTempalateCaption){
		this.msgTempalateCaption = msgTempalateCaption;
	}
	public String getMsgTempalateId(){
		return this.msgTempalateId;
	}
	
	public void setMsgTempalateId(String msgTempalateId){
		this.msgTempalateId = msgTempalateId;
	}
	public String getMsgTempuse(){
		return this.msgTempuse;
	}
	
	public void setMsgTempuse(String msgTempuse){
		this.msgTempuse = msgTempuse;
	}
	public String getMsgReceivetype(){
		return this.msgReceivetype;
	}
	
	public void setMsgReceivetype(String msgReceivetype){
		this.msgReceivetype = msgReceivetype;
	}
	public String getMsgTempalateParams(){
		return this.msgTempalateParams;
	}
	
	public void setMsgTempalateParams(String msgTempalateParams){
		this.msgTempalateParams = msgTempalateParams;
	}
	public String getMsgReceiver(){
		return this.msgReceiver;
	}
	
	public void setMsgReceiver(String msgReceiver){
		this.msgReceiver = msgReceiver;
	}
	
	public void setMcMsgtype(com.common.MessageCenter.entity.McMsgtype mcMsgtype){
		this.mcMsgtype = mcMsgtype;
	}
	
	public com.common.MessageCenter.entity.McMsgtype getMcMsgtype(){
		return this.mcMsgtype;
	}
	
	public String getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msgTempalateContent == null) ? 0 : msgTempalateContent.hashCode());
		result = prime * result + ((msgTempalateCaption == null) ? 0 : msgTempalateCaption.hashCode());
		result = prime * result + ((msgTempalateId == null) ? 0 : msgTempalateId.hashCode());
		result = prime * result + ((msgTempuse == null) ? 0 : msgTempuse.hashCode());
		result = prime * result + ((msgReceivetype == null) ? 0 : msgReceivetype.hashCode());
		result = prime * result + ((msgTempalateParams == null) ? 0 : msgTempalateParams.hashCode());
		result = prime * result + ((msgReceiver == null) ? 0 : msgReceiver.hashCode());
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
		if (msgTempalateContent == null) {
			if (other.msgTempalateContent != null)
				return false;
		} else if (!msgTempalateContent.equals(other.msgTempalateContent))
			return false;
		if (msgTempalateCaption == null) {
			if (other.msgTempalateCaption != null)
				return false;
		} else if (!msgTempalateCaption.equals(other.msgTempalateCaption))
			return false;
		if (msgTempalateId == null) {
			if (other.msgTempalateId != null)
				return false;
		} else if (!msgTempalateId.equals(other.msgTempalateId))
			return false;
		if (msgTempuse == null) {
			if (other.msgTempuse != null)
				return false;
		} else if (!msgTempuse.equals(other.msgTempuse))
			return false;
		if (msgReceivetype == null) {
			if (other.msgReceivetype != null)
				return false;
		} else if (!msgReceivetype.equals(other.msgReceivetype))
			return false;
		if (msgTempalateParams == null) {
			if (other.msgTempalateParams != null)
				return false;
		} else if (!msgTempalateParams.equals(other.msgTempalateParams))
			return false;
		if (msgReceiver == null) {
			if (other.msgReceiver != null)
				return false;
		} else if (!msgReceiver.equals(other.msgReceiver))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}