/**
 *
 */
package com.manage.EnterpriseMessageManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.MemberManager.entity.MemberInformation;
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
	
	private static final long serialVersionUID = 6711792973698178137L;
	

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "LETTER_ENTERPRISE_ID")
	@Length(max=32)
	private String letterEnterpriseId;//企业信息ID
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "LETTER_ID")
	@Length(max=36)
	private String letterId;//私信ID

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID

	@Column(name = "LETTER_TIME")
	@Length(max=32)
	private String letterTime;//私信发送时间

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "LETTER_CONTENT")
	@Length(max=1024)
	private String letterContent;//私信内容

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "LETTER_RECIPIENT_ID")
	@Length(max=36)
	private String letterRecipientId;//接收人ID
	
	@Transient
	private MemberInformation member;
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

	public MemberInformation getMember() {
		return member;
	}

	public void setMember(MemberInformation member) {
		this.member = member;
	}

	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getLetterEnterpriseId(){
		return this.letterEnterpriseId;
	}
	
	public void setLetterEnterpriseId(String letterEnterpriseId){
		this.letterEnterpriseId = letterEnterpriseId;
	}
	public String getLetterId(){
		return this.letterId;
	}
	
	public void setLetterId(String letterId){
		this.letterId = letterId;
	}
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	public String getLetterTime(){
		return this.letterTime;
	}
	
	public void setLetterTime(String letterTime){
		this.letterTime = letterTime;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getLetterContent(){
		return this.letterContent;
	}
	
	public void setLetterContent(String letterContent){
		this.letterContent = letterContent;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getLetterRecipientId(){
		return this.letterRecipientId;
	}
	
	public void setLetterRecipientId(String letterRecipientId){
		this.letterRecipientId = letterRecipientId;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((letterEnterpriseId == null) ? 0 : letterEnterpriseId.hashCode());
		result = prime * result + ((letterId == null) ? 0 : letterId.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result + ((letterTime == null) ? 0 : letterTime.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((letterContent == null) ? 0 : letterContent.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((letterRecipientId == null) ? 0 : letterRecipientId.hashCode());
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
		final LettermanagerLetter other = (LettermanagerLetter) obj;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (letterEnterpriseId == null) {
			if (other.letterEnterpriseId != null)
				return false;
		} else if (!letterEnterpriseId.equals(other.letterEnterpriseId))
			return false;
		if (letterId == null) {
			if (other.letterId != null)
				return false;
		} else if (!letterId.equals(other.letterId))
			return false;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		if (letterTime == null) {
			if (other.letterTime != null)
				return false;
		} else if (!letterTime.equals(other.letterTime))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (letterContent == null) {
			if (other.letterContent != null)
				return false;
		} else if (!letterContent.equals(other.letterContent))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (letterRecipientId == null) {
			if (other.letterRecipientId != null)
				return false;
		} else if (!letterRecipientId.equals(other.letterRecipientId))
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