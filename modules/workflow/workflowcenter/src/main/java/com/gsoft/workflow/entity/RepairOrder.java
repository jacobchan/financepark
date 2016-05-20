/**
 *
 */
package com.gsoft.workflow.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;

@Entity
@Table(name = "sp_workflow_repair_")
public class RepairOrder implements Domain{
	/**
	 * 物业报修流程
	 */
	private static final long serialVersionUID = -5645863182806921082L;

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "flow_id_")
	@Length(max=36)
	private String flowId;//流程ID
	
	@Column(name = "flow_person_id_")
	@Length(max=36)
	private String flowPersonId;//流程人员id
	
	@Column(name = "flow_process_id_")
	@Length(max=36)
	private String flowProcessId;//工作流ID
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PropertyservicemanagerBxId_")
	private PropertyservicemanagerBx propertyservicemanagerBx;//物业报修
	
	@Column(name = "flow_type_")
	@Length(max=2)
	private String flowType;//流程类型
	
	@Column(name = "flow_result_pg_")
	@Length(max=2)
	private String flowResultPg;//派工流程结果
	
	@Column(name = "flow_suggest_pg_")
	@Length(max=500)
	private String flowSuggestPg;//派工流程意见
	
	@Column(name = "flow_result_jg_")
	@Length(max=2)
	private String flowResultJg;//接单流程结果
	
	@Column(name = "flow_suggest_jg_")
	@Length(max=500)
	private String flowSuggestJg;//接单流程意见
	
	@Column(name = "create_user_")
	@Length(max=36)
	private String createUser;//创建用户ID
	
	@Column(name = "update_user_caption_")
	@Length(max=20)
	private String updateUsercaption;//最后操作人用户名
	
	@Column(name = "create_user_caption_")
	@Length(max=20)
	private String createUsercaption;//创建用户名
	
	@Column(name = "update_user_")
	@Length(max=36)
	private String updateUser;//最后操作人
	
	@Column(name = "create_time_")
	@Length(max=20)
	private String createTime;//创建时间
	
	@Column(name = "update_time_")
	@Length(max=20)
	private String updateTime;//最后修改时间
	
	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getFlowPersonId() {
		return flowPersonId;
	}

	public void setFlowPersonId(String flowPersonId) {
		this.flowPersonId = flowPersonId;
	}

	public PropertyservicemanagerBx getPropertyservicemanagerBx() {
		return propertyservicemanagerBx;
	}

	public void setPropertyservicemanagerBx(
			PropertyservicemanagerBx propertyservicemanagerBx) {
		this.propertyservicemanagerBx = propertyservicemanagerBx;
	}

	public String getFlowProcessId() {
		return flowProcessId;
	}

	public void setFlowProcessId(String flowProcessId) {
		this.flowProcessId = flowProcessId;
	}

	public String getFlowType() {
		return flowType;
	}

	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}

	public String getFlowResultPg() {
		return flowResultPg;
	}

	public void setFlowResultPg(String flowResultPg) {
		this.flowResultPg = flowResultPg;
	}

	public String getFlowSuggestPg() {
		return flowSuggestPg;
	}

	public void setFlowSuggestPg(String flowSuggestPg) {
		this.flowSuggestPg = flowSuggestPg;
	}

	public String getFlowResultJg() {
		return flowResultJg;
	}

	public void setFlowResultJg(String flowResultJg) {
		this.flowResultJg = flowResultJg;
	}

	public String getFlowSuggestJg() {
		return flowSuggestJg;
	}

	public void setFlowSuggestJg(String flowSuggestJg) {
		this.flowSuggestJg = flowSuggestJg;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUsercaption() {
		return updateUsercaption;
	}

	public void setUpdateUsercaption(String updateUsercaption) {
		this.updateUsercaption = updateUsercaption;
	}

	public String getCreateUsercaption() {
		return createUsercaption;
	}

	public void setCreateUsercaption(String createUsercaption) {
		this.createUsercaption = createUsercaption;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}