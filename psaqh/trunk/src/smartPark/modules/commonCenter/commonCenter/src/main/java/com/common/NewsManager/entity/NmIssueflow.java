/**
 *
 */
package com.common.NewsManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 流程定义
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_nm_issueFlow_")
public class NmIssueflow implements Domain{
	
	private static final long serialVersionUID = 3044863183621707351L;
	

	@Column(name = "ISSUE_FLOW_N_STATUS_")
	@Length(max=36)
	private String issueFlowNStatus;//下步状态

	@Column(name = "ISSUE_FLOW_CAPTION_")
	@Length(max=36)
	private String issueFlowCaption;//发布流程描述

	@Column(name = "FLOW_INSTANCE_")
	@Length(max=36)
	private String flowInstance;//对应实例

	@Column(name = "ISSUE_FLOW_C_STATUS_")
	@Length(max=36)
	private String issueFlowCStatus;//当前状态
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ISSUE_FLOW_ID_")
	@Length(max=36)
	private String issueFlowId;//发布流程ID

	@Column(name = "ISSUE_OPERATE_")
	@Length(max=36)
	private String issueOperate;//操作详细

	@Column(name = "FLOW_USE_")
	@Length(max=36)
	private String flowUse;//使用情况
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ISSUE_TYPE_ID_")
	private com.common.NewsManager.entity.NmIssuetype nmIssuetype;//发布类型ID
	
	public String getIssueFlowNStatus(){
		return this.issueFlowNStatus;
	}
	
	public void setIssueFlowNStatus(String issueFlowNStatus){
		this.issueFlowNStatus = issueFlowNStatus;
	}
	public String getIssueFlowCaption(){
		return this.issueFlowCaption;
	}
	
	public void setIssueFlowCaption(String issueFlowCaption){
		this.issueFlowCaption = issueFlowCaption;
	}
	public String getFlowInstance(){
		return this.flowInstance;
	}
	
	public void setFlowInstance(String flowInstance){
		this.flowInstance = flowInstance;
	}
	public String getIssueFlowCStatus(){
		return this.issueFlowCStatus;
	}
	
	public void setIssueFlowCStatus(String issueFlowCStatus){
		this.issueFlowCStatus = issueFlowCStatus;
	}
	public String getIssueFlowId(){
		return this.issueFlowId;
	}
	
	public void setIssueFlowId(String issueFlowId){
		this.issueFlowId = issueFlowId;
	}
	public String getIssueOperate(){
		return this.issueOperate;
	}
	
	public void setIssueOperate(String issueOperate){
		this.issueOperate = issueOperate;
	}
	public String getFlowUse(){
		return this.flowUse;
	}
	
	public void setFlowUse(String flowUse){
		this.flowUse = flowUse;
	}
	
	public void setNmIssuetype(com.common.NewsManager.entity.NmIssuetype nmIssuetype){
		this.nmIssuetype = nmIssuetype;
	}
	
	public com.common.NewsManager.entity.NmIssuetype getNmIssuetype(){
		return this.nmIssuetype;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((issueFlowNStatus == null) ? 0 : issueFlowNStatus.hashCode());
		result = prime * result + ((issueFlowCaption == null) ? 0 : issueFlowCaption.hashCode());
		result = prime * result + ((flowInstance == null) ? 0 : flowInstance.hashCode());
		result = prime * result + ((issueFlowCStatus == null) ? 0 : issueFlowCStatus.hashCode());
		result = prime * result + ((issueFlowId == null) ? 0 : issueFlowId.hashCode());
		result = prime * result + ((issueOperate == null) ? 0 : issueOperate.hashCode());
		result = prime * result + ((flowUse == null) ? 0 : flowUse.hashCode());
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
		final NmIssueflow other = (NmIssueflow) obj;
		if (issueFlowNStatus == null) {
			if (other.issueFlowNStatus != null)
				return false;
		} else if (!issueFlowNStatus.equals(other.issueFlowNStatus))
			return false;
		if (issueFlowCaption == null) {
			if (other.issueFlowCaption != null)
				return false;
		} else if (!issueFlowCaption.equals(other.issueFlowCaption))
			return false;
		if (flowInstance == null) {
			if (other.flowInstance != null)
				return false;
		} else if (!flowInstance.equals(other.flowInstance))
			return false;
		if (issueFlowCStatus == null) {
			if (other.issueFlowCStatus != null)
				return false;
		} else if (!issueFlowCStatus.equals(other.issueFlowCStatus))
			return false;
		if (issueFlowId == null) {
			if (other.issueFlowId != null)
				return false;
		} else if (!issueFlowId.equals(other.issueFlowId))
			return false;
		if (issueOperate == null) {
			if (other.issueOperate != null)
				return false;
		} else if (!issueOperate.equals(other.issueOperate))
			return false;
		if (flowUse == null) {
			if (other.flowUse != null)
				return false;
		} else if (!flowUse.equals(other.flowUse))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}