/**
 *
 */
package com.manage.PublicUtilitiesManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 资源状态
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_publicutilitiesmanager_reso")
public class PublicutilitiesmanagerReso implements Domain{
	
	private static final long serialVersionUID = 2966395045638017429L;
	

	@Column(name = "COMMODITY_ID_")
	@Length(max=36)
	private String commodityId;//商品ID
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "RESO_ID_")
	@Length(max=36)
	private String resoId;//资源状态序列

	@Column(name = "RESO_STATUS_")
	@Length(max=2)
	private String resoStatus;//资源状态

	@Column(name = "RESO_DATE_")
	@Length(max=20)
	private String resoDate;//可用日期

	@Column(name = "RESO_TIME_")
	@Length(max=20)
	private String resoTime;//可用时段
	
	public String getCommodityId(){
		return this.commodityId;
	}
	
	public void setCommodityId(String commodityId){
		this.commodityId = commodityId;
	}
	public String getResoId(){
		return this.resoId;
	}
	
	public void setResoId(String resoId){
		this.resoId = resoId;
	}
	public String getResoStatus(){
		return this.resoStatus;
	}
	
	public void setResoStatus(String resoStatus){
		this.resoStatus = resoStatus;
	}
	public String getResoDate(){
		return this.resoDate;
	}
	
	public void setResoDate(String resoDate){
		this.resoDate = resoDate;
	}
	public String getResoTime(){
		return this.resoTime;
	}
	
	public void setResoTime(String resoTime){
		this.resoTime = resoTime;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commodityId == null) ? 0 : commodityId.hashCode());
		result = prime * result + ((resoId == null) ? 0 : resoId.hashCode());
		result = prime * result + ((resoStatus == null) ? 0 : resoStatus.hashCode());
		result = prime * result + ((resoDate == null) ? 0 : resoDate.hashCode());
		result = prime * result + ((resoTime == null) ? 0 : resoTime.hashCode());
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
		final PublicutilitiesmanagerReso other = (PublicutilitiesmanagerReso) obj;
		if (commodityId == null) {
			if (other.commodityId != null)
				return false;
		} else if (!commodityId.equals(other.commodityId))
			return false;
		if (resoId == null) {
			if (other.resoId != null)
				return false;
		} else if (!resoId.equals(other.resoId))
			return false;
		if (resoStatus == null) {
			if (other.resoStatus != null)
				return false;
		} else if (!resoStatus.equals(other.resoStatus))
			return false;
		if (resoDate == null) {
			if (other.resoDate != null)
				return false;
		} else if (!resoDate.equals(other.resoDate))
			return false;
		if (resoTime == null) {
			if (other.resoTime != null)
				return false;
		} else if (!resoTime.equals(other.resoTime))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}