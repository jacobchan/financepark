/**
 *
 */
package com.gsoft.workflow.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;

@Entity
@Table(name = "flow_data")
public class Flowdata implements Domain{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8269806717004408208L;

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "id")
	@Length(max=36)
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private String status;
	
	@Transient
	private String processDefinitionId;
	
	public String toString(){
		return super.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}
	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}
	
}