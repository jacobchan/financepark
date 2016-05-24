/**
 *
 */
package com.distribution.rule.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 分佣比率配置
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_dis_rate_config")
public class DisRateConfig implements Domain{
	
	private static final long serialVersionUID = 2870512926281587650L;
	

	@Column(name = "MEM_LEVEL_")
	@Length(max=2)
	private String memLevel;//会员等级
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "REC_ID_")
	@Length(max=36)
	private String recId;//记录ID

	@Column(name = "DIS_RATE_")
	@Length(max=10)
	private String disRate;//分佣比率
	@Transient
	private String disRateShow;//分佣比率百分比显示

	@Column(name = "DIS_LEVEL_")
	@Length(max=2)
	private String disLevel;//分销等级
	
	public String getMemLevel(){
		return this.memLevel;
	}
	
	public void setMemLevel(String memLevel){
		this.memLevel = memLevel;
	}
	public String getRecId(){
		return this.recId;
	}
	
	public String getDisRateShow() {
		return disRateShow;
	}

	public void setDisRateShow(String disRateShow) {
		this.disRateShow = disRateShow;
	}

	public void setRecId(String recId){
		this.recId = recId;
	}
	public String getDisRate(){
		return this.disRate;
	}
	
	public void setDisRate(String disRate){
		this.disRate = disRate;
	}
	public String getDisLevel(){
		return this.disLevel;
	}
	
	public void setDisLevel(String disLevel){
		this.disLevel = disLevel;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memLevel == null) ? 0 : memLevel.hashCode());
		result = prime * result + ((recId == null) ? 0 : recId.hashCode());
		result = prime * result + ((disRate == null) ? 0 : disRate.hashCode());
		result = prime * result + ((disLevel == null) ? 0 : disLevel.hashCode());
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
		final DisRateConfig other = (DisRateConfig) obj;
		if (memLevel == null) {
			if (other.memLevel != null)
				return false;
		} else if (!memLevel.equals(other.memLevel))
			return false;
		if (recId == null) {
			if (other.recId != null)
				return false;
		} else if (!recId.equals(other.recId))
			return false;
		if (disRate == null) {
			if (other.disRate != null)
				return false;
		} else if (!disRate.equals(other.disRate))
			return false;
		if (disLevel == null) {
			if (other.disLevel != null)
				return false;
		} else if (!disLevel.equals(other.disLevel))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}