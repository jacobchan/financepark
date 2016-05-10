/**
 *
 */
package com.gsoft.workflow.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;

@Entity
@Table(name = "flow_order")
public class FlowOrder implements Domain{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1071554351588998958L;

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "id")
	@Length(max=36)
	private String id;
	
	@Transient
	private String processDefinitionId;
	@Column(name="order_name")
	private String orderName;
	@Column(name="order_status")
	private String status;
	@Column(name="order_content")
	private String orderContent;
	@Column(name="create_user")
	private String createUser;
	@Column(name="create_date")
	private String createDate;
	
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}
	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderContent() {
		return orderContent;
	}
	public void setOrderContent(String orderContent) {
		this.orderContent = orderContent;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}