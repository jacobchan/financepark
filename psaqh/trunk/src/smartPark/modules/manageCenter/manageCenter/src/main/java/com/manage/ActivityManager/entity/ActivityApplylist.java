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
	
	private static final long serialVersionUID = 4210102477496255197L;
	

	@Column(name = "APPLYLIST_TIME_")
	private String applylistTime;//报名时间
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "APPLYLIST_ID_")
	@Length(max=36)
	private String applylistId;//报名名单ID
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="APPLY_ID_")
	private com.manage.ActivityManager.entity.ActivityApply activityApply;//活动申请ID
	
	public String getApplylistTime(){
		return this.applylistTime;
	}
	
	public void setApplylistTime(String applylistTime){
		this.applylistTime = applylistTime;
	}
	public String getApplylistId(){
		return this.applylistId;
	}
	
	public void setApplylistId(String applylistId){
		this.applylistId = applylistId;
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
		result = prime * result + ((applylistTime == null) ? 0 : applylistTime.hashCode());
		result = prime * result + ((applylistId == null) ? 0 : applylistId.hashCode());
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
		if (applylistTime == null) {
			if (other.applylistTime != null)
				return false;
		} else if (!applylistTime.equals(other.applylistTime))
			return false;
		if (applylistId == null) {
			if (other.applylistId != null)
				return false;
		} else if (!applylistId.equals(other.applylistId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}