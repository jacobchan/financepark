/**
 *
 */
package com.manage.ActivityManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: -报名名单
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_activity_applyList")
public class ActivityApplylist implements Domain{
	
	private static final long serialVersionUID = -802450537961537686L;
	

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "APPLYLIST_ID_")
	@Length(max=36)
	private String applylistId;//报名名单ID

	@Column(name = "APPLYLIST_TIME_")
	private String applylistTime;//报名时间

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "APPLY_MEMBER_")
	@Length(max=32)
	private String applyMember;//报名人

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="APPLY_ID_")
	private com.manage.ActivityManager.entity.ActivityApply activityApply;//活动申请ID
	
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getApplylistId(){
		return this.applylistId;
	}
	
	public void setApplylistId(String applylistId){
		this.applylistId = applylistId;
	}
	public String getApplylistTime(){
		return this.applylistTime;
	}
	
	public void setApplylistTime(String applylistTime){
		this.applylistTime = applylistTime;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getApplyMember(){
		return this.applyMember;
	}
	
	public void setApplyMember(String applyMember){
		this.applyMember = applyMember;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	
	public void setActivityApply(com.manage.ActivityManager.entity.ActivityApply activityApply){
		this.activityApply = activityApply;
	}
	
	public com.manage.ActivityManager.entity.ActivityApply getActivityApply(){
		return this.activityApply;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((applylistId == null) ? 0 : applylistId.hashCode());
		result = prime * result + ((applylistTime == null) ? 0 : applylistTime.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((applyMember == null) ? 0 : applyMember.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
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
		final ActivityApplylist other = (ActivityApplylist) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (applylistId == null) {
			if (other.applylistId != null)
				return false;
		} else if (!applylistId.equals(other.applylistId))
			return false;
		if (applylistTime == null) {
			if (other.applylistTime != null)
				return false;
		} else if (!applylistTime.equals(other.applylistTime))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (applyMember == null) {
			if (other.applyMember != null)
				return false;
		} else if (!applyMember.equals(other.applyMember))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}