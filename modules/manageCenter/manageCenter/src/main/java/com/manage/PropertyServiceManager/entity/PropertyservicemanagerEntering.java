/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 可办理预约记录
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_entering")
public class PropertyservicemanagerEntering implements Domain{
	
	private static final long serialVersionUID = 4700018745936906638L;
	

	@Column(name = "ENTERING_STATUS_")
	@Length(max=2)
	private String enteringStatus;//预约数量状态

	@Column(name = "ENTERING_REMAIN_")
	private String enteringRemain;//剩余数量

	@Column(name = "ENTERING_TIME_")
	@Length(max=20)
	private String enteringTime;//预约时间段
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ENTERING_ID_")
	@Length(max=36)
	private String enteringId;//预约记录ID

	@Column(name = "ENTERING_ALRE_")
	private String enteringAlre;//已预约数

	@Column(name = "ENTERING_SUM_")
	private String enteringSum;//预约总量

	@Column(name = "ENTERING_DATE_")
	@Length(max=20)
	private String enteringDate;//预约时间日期
	
	public String getEnteringStatus(){
		return this.enteringStatus;
	}
	
	public void setEnteringStatus(String enteringStatus){
		this.enteringStatus = enteringStatus;
	}
	public String getEnteringRemain(){
		return this.enteringRemain;
	}
	
	public void setEnteringRemain(String enteringRemain){
		this.enteringRemain = enteringRemain;
	}
	public String getEnteringTime(){
		return this.enteringTime;
	}
	
	public void setEnteringTime(String enteringTime){
		this.enteringTime = enteringTime;
	}
	public String getEnteringId(){
		return this.enteringId;
	}
	
	public void setEnteringId(String enteringId){
		this.enteringId = enteringId;
	}
	public String getEnteringAlre(){
		return this.enteringAlre;
	}
	
	public void setEnteringAlre(String enteringAlre){
		this.enteringAlre = enteringAlre;
	}
	public String getEnteringSum(){
		return this.enteringSum;
	}
	
	public void setEnteringSum(String enteringSum){
		this.enteringSum = enteringSum;
	}
	public String getEnteringDate(){
		return this.enteringDate;
	}
	
	public void setEnteringDate(String enteringDate){
		this.enteringDate = enteringDate;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enteringStatus == null) ? 0 : enteringStatus.hashCode());
		result = prime * result + ((enteringRemain == null) ? 0 : enteringRemain.hashCode());
		result = prime * result + ((enteringTime == null) ? 0 : enteringTime.hashCode());
		result = prime * result + ((enteringId == null) ? 0 : enteringId.hashCode());
		result = prime * result + ((enteringAlre == null) ? 0 : enteringAlre.hashCode());
		result = prime * result + ((enteringSum == null) ? 0 : enteringSum.hashCode());
		result = prime * result + ((enteringDate == null) ? 0 : enteringDate.hashCode());
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
		final PropertyservicemanagerEntering other = (PropertyservicemanagerEntering) obj;
		if (enteringStatus == null) {
			if (other.enteringStatus != null)
				return false;
		} else if (!enteringStatus.equals(other.enteringStatus))
			return false;
		if (enteringRemain == null) {
			if (other.enteringRemain != null)
				return false;
		} else if (!enteringRemain.equals(other.enteringRemain))
			return false;
		if (enteringTime == null) {
			if (other.enteringTime != null)
				return false;
		} else if (!enteringTime.equals(other.enteringTime))
			return false;
		if (enteringId == null) {
			if (other.enteringId != null)
				return false;
		} else if (!enteringId.equals(other.enteringId))
			return false;
		if (enteringAlre == null) {
			if (other.enteringAlre != null)
				return false;
		} else if (!enteringAlre.equals(other.enteringAlre))
			return false;
		if (enteringSum == null) {
			if (other.enteringSum != null)
				return false;
		} else if (!enteringSum.equals(other.enteringSum))
			return false;
		if (enteringDate == null) {
			if (other.enteringDate != null)
				return false;
		} else if (!enteringDate.equals(other.enteringDate))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}