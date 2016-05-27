/**
 *
 */
package com.member.applications.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 340702融资申请
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_finace")
public class Finace implements Domain{
	
	private static final long serialVersionUID = -4715906731738379757L;
	

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "AMOUNT_END_")
	@Length(max=10)
	private String amountEnd;//融资额度止

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "BUSINESS_DIS_")
	@Length(max=1024)
	private String businessDis;//业务简介

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "COMPANY_NAME_")
	@Length(max=256)
	private String companyName;//公司名称

	@Column(name = "SHARE_RATE_")
	private String shareRate;//股份占比

	@Column(name = "COMPANY_URL_")
	@Length(max=256)
	private String companyUrl;//主页地址

	@Column(name = "APPLAY_STATUS_")
	@Length(max=2)
	private String applayStatus;//申请状态

	@Column(name = "COMPANY_MERITE_")
	@Length(max=1024)
	private String companyMerite;//公司优势

	@Column(name = "BP_URL_")
	@Length(max=256)
	private String bpUrl;//BPURL
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ID_")
	@Length(max=36)
	private String id;//ID_

	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区ID

	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//申请人

	@Column(name = "AMOUNT_START_")
	@Length(max=10)
	private String amountStart;//融资额度起

	@Column(name = "COR_TEAM_")
	@Length(max=256)
	private String corTeam;//核心成员

	@Column(name = "APPLAY_NO_")
	@Length(max=20)
	private String applayNo;//申请编号
	
	@Transient
	private MemberInformation member;
    /**新增园区字段   start**/
	@Column(name = "PARK_NAME_")
	@Length(max=256)
	private String parkName;//园区名称

	/**新增园区字段   end**/ 

	/**新增园区字段   start**/
	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	/**新增园区字段   end**/

	public MemberInformation getMember() {
		return member;
	}

	public void setMember(MemberInformation member) {
		this.member = member;
	}
	
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getAmountEnd(){
		return this.amountEnd;
	}
	
	public void setAmountEnd(String amountEnd){
		this.amountEnd = amountEnd;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getBusinessDis(){
		return this.businessDis;
	}
	
	public void setBusinessDis(String businessDis){
		this.businessDis = businessDis;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getCompanyName(){
		return this.companyName;
	}
	
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	public String getShareRate(){
		return this.shareRate;
	}
	
	public void setShareRate(String shareRate){
		this.shareRate = shareRate;
	}
	public String getCompanyUrl(){
		return this.companyUrl;
	}
	
	public void setCompanyUrl(String companyUrl){
		this.companyUrl = companyUrl;
	}
	public String getApplayStatus(){
		return this.applayStatus;
	}
	
	public void setApplayStatus(String applayStatus){
		this.applayStatus = applayStatus;
	}
	public String getCompanyMerite(){
		return this.companyMerite;
	}
	
	public void setCompanyMerite(String companyMerite){
		this.companyMerite = companyMerite;
	}
	public String getBpUrl(){
		return this.bpUrl;
	}
	
	public void setBpUrl(String bpUrl){
		this.bpUrl = bpUrl;
	}
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public String getParkId(){
		return this.parkId;
	}
	
	public void setParkId(String parkId){
		this.parkId = parkId;
	}
	public String getMemberId(){
		return this.memberId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public String getAmountStart(){
		return this.amountStart;
	}
	
	public void setAmountStart(String amountStart){
		this.amountStart = amountStart;
	}
	public String getCorTeam(){
		return this.corTeam;
	}
	
	public void setCorTeam(String corTeam){
		this.corTeam = corTeam;
	}
	public String getApplayNo(){
		return this.applayNo;
	}
	
	public void setApplayNo(String applayNo){
		this.applayNo = applayNo;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((amountEnd == null) ? 0 : amountEnd.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((businessDis == null) ? 0 : businessDis.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((shareRate == null) ? 0 : shareRate.hashCode());
		result = prime * result + ((companyUrl == null) ? 0 : companyUrl.hashCode());
		result = prime * result + ((applayStatus == null) ? 0 : applayStatus.hashCode());
		result = prime * result + ((companyMerite == null) ? 0 : companyMerite.hashCode());
		result = prime * result + ((bpUrl == null) ? 0 : bpUrl.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((parkId == null) ? 0 : parkId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((amountStart == null) ? 0 : amountStart.hashCode());
		result = prime * result + ((corTeam == null) ? 0 : corTeam.hashCode());
		result = prime * result + ((applayNo == null) ? 0 : applayNo.hashCode());
		/**新增园区字段   start**/
		result = prime * result + ((parkName == null) ? 0 : parkName.hashCode());
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
		final Finace other = (Finace) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (amountEnd == null) {
			if (other.amountEnd != null)
				return false;
		} else if (!amountEnd.equals(other.amountEnd))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (businessDis == null) {
			if (other.businessDis != null)
				return false;
		} else if (!businessDis.equals(other.businessDis))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (shareRate == null) {
			if (other.shareRate != null)
				return false;
		} else if (!shareRate.equals(other.shareRate))
			return false;
		if (companyUrl == null) {
			if (other.companyUrl != null)
				return false;
		} else if (!companyUrl.equals(other.companyUrl))
			return false;
		if (applayStatus == null) {
			if (other.applayStatus != null)
				return false;
		} else if (!applayStatus.equals(other.applayStatus))
			return false;
		if (companyMerite == null) {
			if (other.companyMerite != null)
				return false;
		} else if (!companyMerite.equals(other.companyMerite))
			return false;
		if (bpUrl == null) {
			if (other.bpUrl != null)
				return false;
		} else if (!bpUrl.equals(other.bpUrl))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (parkId == null) {
			if (other.parkId != null)
				return false;
		} else if (!parkId.equals(other.parkId))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (amountStart == null) {
			if (other.amountStart != null)
				return false;
		} else if (!amountStart.equals(other.amountStart))
			return false;
		if (corTeam == null) {
			if (other.corTeam != null)
				return false;
		} else if (!corTeam.equals(other.corTeam))
			return false;
		if (applayNo == null) {
			if (other.applayNo != null)
				return false;
		} else if (!applayNo.equals(other.applayNo))
			return false;
		/**新增园区字段   start**/
		
		if (parkName == null) {
			if (other.parkName != null)
				return false;
		} else if (!parkName.equals(other.parkName))
			return false;
		/**新增园区字段   end**/
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}