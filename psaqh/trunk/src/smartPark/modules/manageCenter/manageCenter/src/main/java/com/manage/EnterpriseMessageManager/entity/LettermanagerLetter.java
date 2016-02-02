/**
 *
 */
package com.manage.EnterpriseMessageManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 私信
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_lettermanager_letter")
public class LettermanagerLetter implements Domain{
	
	private static final long serialVersionUID = -3949501152058406923L;
	

	@Column(name = "LETTER_RECIPIENT_ID")
	@Length(max=32)
	private String letterRecipientId;//接收人ID

	@Column(name = "LETTER_ENTERPRISE_ID")
	@Length(max=32)
	private String letterEnterpriseId;//企业信息ID

	@Column(name = "LETTER_CONTENT")
	@Length(max=1024)
	private String letterContent;//私信内容
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "LETTER_ID")
	@Length(max=36)
	private String letterId;//私信ID

	@Column(name = "LETTER_TIME")
	@Length(max=32)
	private String letterTime;//私信发送时间

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID
	
	public String getLetterRecipientId(){
		return this.letterRecipientId;
	}
	
	public void setLetterRecipientId(String letterRecipientId){
		this.letterRecipientId = letterRecipientId;
	}
	public String getLetterEnterpriseId(){
		return this.letterEnterpriseId;
	}
	
	public void setLetterEnterpriseId(String letterEnterpriseId){
		this.letterEnterpriseId = letterEnterpriseId;
	}
	public String getLetterContent(){
		return this.letterContent;
	}
	
	public void setLetterContent(String letterContent){
		this.letterContent = letterContent;
	}
	public String getLetterId(){
		return this.letterId;
	}
	
	public void setLetterId(String letterId){
		this.letterId = letterId;
	}
	public String getLetterTime(){
		return this.letterTime;
	}
	
	public void setLetterTime(String letterTime){
		this.letterTime = letterTime;
	}
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((letterRecipientId == null) ? 0 : letterRecipientId.hashCode());
		result = prime * result + ((letterEnterpriseId == null) ? 0 : letterEnterpriseId.hashCode());
		result = prime * result + ((letterContent == null) ? 0 : letterContent.hashCode());
		result = prime * result + ((letterId == null) ? 0 : letterId.hashCode());
		result = prime * result + ((letterTime == null) ? 0 : letterTime.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
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
		final LettermanagerLetter other = (LettermanagerLetter) obj;
		if (letterRecipientId == null) {
			if (other.letterRecipientId != null)
				return false;
		} else if (!letterRecipientId.equals(other.letterRecipientId))
			return false;
		if (letterEnterpriseId == null) {
			if (other.letterEnterpriseId != null)
				return false;
		} else if (!letterEnterpriseId.equals(other.letterEnterpriseId))
			return false;
		if (letterContent == null) {
			if (other.letterContent != null)
				return false;
		} else if (!letterContent.equals(other.letterContent))
			return false;
		if (letterId == null) {
			if (other.letterId != null)
				return false;
		} else if (!letterId.equals(other.letterId))
			return false;
		if (letterTime == null) {
			if (other.letterTime != null)
				return false;
		} else if (!letterTime.equals(other.letterTime))
			return false;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}