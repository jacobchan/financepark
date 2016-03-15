/**
 *
 */
package com.common.MemberAdrManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: -我的地址
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_memberAdr_address")
public class MemberadrAddress implements Domain{
	
	private static final long serialVersionUID = -3987836214736171568L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ADDRESS_ID_")
	@Length(max=36)
	private String addressId;//地址ID

	@Column(name = "ADDRESS_STATUS_")
	@Length(max=2)
	private String addressStatus;//默认状态

	@Column(name = "ADDRESS_DETAIL_")
	@Length(max=128)
	private String addressDetail;//详细地址
	
	@Column(name = "ADDRESS_NAME_")
	@Length(max=32)
	private String addressName;//姓名
	
	@Column(name = "ADDRESS_PHONE_")
	@Length(max=128)
	private String addressPhone;//电话

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MEMBER_ID_")
	private MemberInformation memberId;//会员用户ID


	public String getAddressId(){
		return this.addressId;
	}
	
	public void setAddressId(String addressId){
		this.addressId = addressId;
	}
	public String getAddressStatus(){
		return this.addressStatus;
	}
	
	public void setAddressStatus(String addressStatus){
		this.addressStatus = addressStatus;
	}
	public String getAddressDetail(){
		return this.addressDetail;
	}
	
	public void setAddressDetail(String addressDetail){
		this.addressDetail = addressDetail;
	}
	
	
	
	

	


	public MemberInformation getMemberId() {
		return memberId;
	}

	public void setMemberId(MemberInformation memberId) {
		this.memberId = memberId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getAddressPhone() {
		return addressPhone;
	}

	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((addressStatus == null) ? 0 : addressStatus.hashCode());
		result = prime * result + ((addressDetail == null) ? 0 : addressDetail.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
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
		final MemberadrAddress other = (MemberadrAddress) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (addressStatus == null) {
			if (other.addressStatus != null)
				return false;
		} else if (!addressStatus.equals(other.addressStatus))
			return false;
		if (addressDetail == null) {
			if (other.addressDetail != null)
				return false;
		} else if (!addressDetail.equals(other.addressDetail))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}