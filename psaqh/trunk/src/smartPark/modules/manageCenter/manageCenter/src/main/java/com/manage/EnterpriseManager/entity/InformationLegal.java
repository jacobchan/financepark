/**
 *
 */
package com.manage.EnterpriseManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 法人介绍
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_information_legal")
public class InformationLegal implements Domain{
	
	private static final long serialVersionUID = 7339837995201863298L;
	

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID2
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "LEGAL_ID_")
	@Length(max=36)
	private String legalId;//ID

	@Column(name = "LEGAL_TELEPHONE_")
	@Length(max=16)
	private String legalTelephone;//联系方式

	@Column(name = "LEGAL_NAME_")
	@Length(max=64)
	private String legalName;//法人信息

	@Column(name = "LEGAL_RE_")
	@Length(max=32)
	private String legalRe;//企业信息ID
	
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	public String getLegalId(){
		return this.legalId;
	}
	
	public void setLegalId(String legalId){
		this.legalId = legalId;
	}
	public String getLegalTelephone(){
		return this.legalTelephone;
	}
	
	public void setLegalTelephone(String legalTelephone){
		this.legalTelephone = legalTelephone;
	}
	public String getLegalName(){
		return this.legalName;
	}
	
	public void setLegalName(String legalName){
		this.legalName = legalName;
	}
	public String getLegalRe(){
		return this.legalRe;
	}
	
	public void setLegalRe(String legalRe){
		this.legalRe = legalRe;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result + ((legalId == null) ? 0 : legalId.hashCode());
		result = prime * result + ((legalTelephone == null) ? 0 : legalTelephone.hashCode());
		result = prime * result + ((legalName == null) ? 0 : legalName.hashCode());
		result = prime * result + ((legalRe == null) ? 0 : legalRe.hashCode());
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
		final InformationLegal other = (InformationLegal) obj;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		if (legalId == null) {
			if (other.legalId != null)
				return false;
		} else if (!legalId.equals(other.legalId))
			return false;
		if (legalTelephone == null) {
			if (other.legalTelephone != null)
				return false;
		} else if (!legalTelephone.equals(other.legalTelephone))
			return false;
		if (legalName == null) {
			if (other.legalName != null)
				return false;
		} else if (!legalName.equals(other.legalName))
			return false;
		if (legalRe == null) {
			if (other.legalRe != null)
				return false;
		} else if (!legalRe.equals(other.legalRe))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}