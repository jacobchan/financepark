/**
 *
 */
package com.manage.ReserveManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.ExtentionAtrManager.entity.CarEntity;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 预约记录
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_reservation_record")
public class ReservationRecord implements Domain{
	
	private static final long serialVersionUID = 7795969662685750349L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "RECORD_ID")
	@Length(max=36)
	private String recordId;//预约记录ID
	
	@Column(name = "RECORD_CODE_")
	@Length(max=32)
	private String recordCode;//预约单号
	
	@Column(name = "RECORD_COMMDITY_ID_")
	@Length(max=36)
	private String recordCommdityId;//预约商品ID
	
	@Column(name = "COMPANY_NAME_")
	@Length(max=256)
	private String companyName;//公司名称
	
	@Column(name = "COMPANY_SCALE_")
	@Length(max=2)
	private String companyScale;//公司规模
	
	@Column(name = "INCOMING_DATE_")
	@Length(max=20)
	private String incomingDate;//期望入驻日期
	
	@Column(name = "COMPANY_DISCRPTION_")
	@Length(max=1024)
	private String companyDiscrption;//公司简介

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "RECORD_SERVICE_TEL")
	@Length(max=32)
	private String recordServiceTel;//客服电话
	
	@Column(name = "VISITE_NAME_")
	@Length(max=32)
	private String visiteName;//来访姓名

	
	@Column(name = "VISITE_TEL_")
	@Length(max=32)
	private String visiteTel;//联系电话


	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "RECORD_TYPE")
	@Length(max=2)
	private String recordType;//预约类型

	@Column(name = "RECORD_CUSTOMER")
	@Length(max=32)
	private String recordCustomer;//客服代表
	
	@Transient
	private String recordCustomerName;//客服代表姓名

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "VISITE_DATE_")
	@Length(max=20)
	private String visiteDate;//到访日期

	@Column(name = "RECORD_MEMBER_ID")
	@Length(max=32)
	private String recordMemberId;//预约对象ID

	@Column(name = "RECORD_VISITE_STATUS")
	@Length(max=2)
	private String recordVisiteStatus;//是否到访

	@Column(name = "RECORD_STATUS")
	@Length(max=2)
	private String recordStatus;//预约记录状态

	@Column(name = "VISITE_TIME_")
	@Length(max=20)
	private String visiteTime;//到访时间
	
	@Transient
	private String recordCommdityName;//预约商品名称

    /**新增园区字段   start**/
	@Column(name = "PARK_NAME_")
	@Length(max=256)
	private String parkName;//园区名称
	
	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区id
	/**新增园区字段   end**/ 

	/**新增园区字段   start**/
	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getParkId() {
		return parkId;
	}

	public void setParkId(String parkId) {
		this.parkId = parkId;
	}
	/**新增园区字段   end**/



	public String getRecordCommdityName() {
		return recordCommdityName;
	}



	public void setRecordCommdityName(String recordCommdityName) {
		this.recordCommdityName = recordCommdityName;
	}



	public String getRecordCustomerName() {
		return recordCustomerName;
	}



	public void setRecordCustomerName(String recordCustomerName) {
		this.recordCustomerName = recordCustomerName;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((companyDiscrption == null) ? 0 : companyDiscrption
						.hashCode());
		result = prime * result
				+ ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result
				+ ((companyScale == null) ? 0 : companyScale.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result
				+ ((incomingDate == null) ? 0 : incomingDate.hashCode());
		result = prime * result
				+ ((recordCode == null) ? 0 : recordCode.hashCode());
		result = prime
				* result
				+ ((recordCommdityId == null) ? 0 : recordCommdityId.hashCode());
		result = prime * result
				+ ((recordCustomer == null) ? 0 : recordCustomer.hashCode());
		result = prime * result
				+ ((recordId == null) ? 0 : recordId.hashCode());
		result = prime * result
				+ ((recordMemberId == null) ? 0 : recordMemberId.hashCode());
		result = prime
				* result
				+ ((recordServiceTel == null) ? 0 : recordServiceTel.hashCode());
		result = prime * result
				+ ((recordStatus == null) ? 0 : recordStatus.hashCode());
		result = prime * result
				+ ((recordType == null) ? 0 : recordType.hashCode());
		result = prime
				* result
				+ ((recordVisiteStatus == null) ? 0 : recordVisiteStatus
						.hashCode());
		result = prime * result
				+ ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result
				+ ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result
				+ ((visiteDate == null) ? 0 : visiteDate.hashCode());
		result = prime * result
				+ ((visiteName == null) ? 0 : visiteName.hashCode());
		result = prime * result
				+ ((visiteTel == null) ? 0 : visiteTel.hashCode());
		result = prime * result
				+ ((visiteTime == null) ? 0 : visiteTime.hashCode());
		/**新增园区字段   start**/
		result = prime * result + ((parkName == null) ? 0 : parkName.hashCode());
		result = prime * result + ((parkId == null) ? 0 : parkId.hashCode());
		/**新增园区字段   end**/
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
		ReservationRecord other = (ReservationRecord) obj;
		if (companyDiscrption == null) {
			if (other.companyDiscrption != null)
				return false;
		} else if (!companyDiscrption.equals(other.companyDiscrption))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (companyScale == null) {
			if (other.companyScale != null)
				return false;
		} else if (!companyScale.equals(other.companyScale))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (incomingDate == null) {
			if (other.incomingDate != null)
				return false;
		} else if (!incomingDate.equals(other.incomingDate))
			return false;
		if (recordCode == null) {
			if (other.recordCode != null)
				return false;
		} else if (!recordCode.equals(other.recordCode))
			return false;
		if (recordCommdityId == null) {
			if (other.recordCommdityId != null)
				return false;
		} else if (!recordCommdityId.equals(other.recordCommdityId))
			return false;
		if (recordCustomer == null) {
			if (other.recordCustomer != null)
				return false;
		} else if (!recordCustomer.equals(other.recordCustomer))
			return false;
		if (recordId == null) {
			if (other.recordId != null)
				return false;
		} else if (!recordId.equals(other.recordId))
			return false;
		if (recordMemberId == null) {
			if (other.recordMemberId != null)
				return false;
		} else if (!recordMemberId.equals(other.recordMemberId))
			return false;
		if (recordServiceTel == null) {
			if (other.recordServiceTel != null)
				return false;
		} else if (!recordServiceTel.equals(other.recordServiceTel))
			return false;
		if (recordStatus == null) {
			if (other.recordStatus != null)
				return false;
		} else if (!recordStatus.equals(other.recordStatus))
			return false;
		if (recordType == null) {
			if (other.recordType != null)
				return false;
		} else if (!recordType.equals(other.recordType))
			return false;
		if (recordVisiteStatus == null) {
			if (other.recordVisiteStatus != null)
				return false;
		} else if (!recordVisiteStatus.equals(other.recordVisiteStatus))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (visiteDate == null) {
			if (other.visiteDate != null)
				return false;
		} else if (!visiteDate.equals(other.visiteDate))
			return false;
		if (visiteName == null) {
			if (other.visiteName != null)
				return false;
		} else if (!visiteName.equals(other.visiteName))
			return false;
		if (visiteTel == null) {
			if (other.visiteTel != null)
				return false;
		} else if (!visiteTel.equals(other.visiteTel))
			return false;
		if (visiteTime == null) {
			if (other.visiteTime != null)
				return false;
		} else if (!visiteTime.equals(other.visiteTime))
			return false;
		/**新增园区字段   start**/
		if (parkId == null) {
			if (other.parkId != null)
				return false;
		} else if (!parkId.equals(other.parkId))
			return false;
		if (parkName == null) {
			if (other.parkName != null)
				return false;
		} else if (!parkName.equals(other.parkName))
			return false;
		/**新增园区字段   end**/
		return true;
	}



	public String getRecordCommdityId() {
		return recordCommdityId;
	}



	public void setRecordCommdityId(String recordCommdityId) {
		this.recordCommdityId = recordCommdityId;
	}



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public String getCompanyScale() {
		return companyScale;
	}



	public void setCompanyScale(String companyScale) {
		this.companyScale = companyScale;
	}



	public String getIncomingDate() {
		return incomingDate;
	}



	public void setIncomingDate(String incomingDate) {
		this.incomingDate = incomingDate;
	}



	public String getCompanyDiscrption() {
		return companyDiscrption;
	}



	public void setCompanyDiscrption(String companyDiscrption) {
		this.companyDiscrption = companyDiscrption;
	}



	public String getRecordId() {
		return recordId;
	}



	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}



	public String getRecordCode() {
		return recordCode;
	}



	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
	}



	public String getCreateUser() {
		return createUser;
	}



	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}



	public String getCreateTime() {
		return createTime;
	}



	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}



	public String getRecordServiceTel() {
		return recordServiceTel;
	}



	public void setRecordServiceTel(String recordServiceTel) {
		this.recordServiceTel = recordServiceTel;
	}



	public String getVisiteName() {
		return visiteName;
	}



	public void setVisiteName(String visiteName) {
		this.visiteName = visiteName;
	}



	public String getVisiteTel() {
		return visiteTel;
	}



	public void setVisiteTel(String visiteTel) {
		this.visiteTel = visiteTel;
	}



	public String getUpdateUser() {
		return updateUser;
	}



	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}



	public String getRecordType() {
		return recordType;
	}



	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}



	public String getRecordCustomer() {
		return recordCustomer;
	}



	public void setRecordCustomer(String recordCustomer) {
		this.recordCustomer = recordCustomer;
	}



	public String getUpdateTime() {
		return updateTime;
	}



	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}



	public String getVisiteDate() {
		return visiteDate;
	}



	public void setVisiteDate(String visiteDate) {
		this.visiteDate = visiteDate;
	}



	public String getRecordMemberId() {
		return recordMemberId;
	}



	public void setRecordMemberId(String recordMemberId) {
		this.recordMemberId = recordMemberId;
	}



	public String getRecordVisiteStatus() {
		return recordVisiteStatus;
	}



	public void setRecordVisiteStatus(String recordVisiteStatus) {
		this.recordVisiteStatus = recordVisiteStatus;
	}



	public String getRecordStatus() {
		return recordStatus;
	}



	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}



	public String getVisiteTime() {
		return visiteTime;
	}



	public void setVisiteTime(String visiteTime) {
		this.visiteTime = visiteTime;
	}



	public String toString(){
		return super.toString();
	}
}