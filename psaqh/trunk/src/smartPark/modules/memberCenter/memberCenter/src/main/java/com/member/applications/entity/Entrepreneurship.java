/**
 *
 */
package com.member.applications.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 340703创业加速申请
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_entrepreneurship")
public class Entrepreneurship implements Domain{
	
	private static final long serialVersionUID = -1608736902719649972L;
	

	@Column(name = "APPLAY_STATUS_")
	@Length(max=2)
	private String applayStatus;//申请状态

	@Column(name = "APPLAY_NO_")
	@Length(max=20)
	private String applayNo;//申请编号

	@Column(name = "PROJECT_TYPE_")
	@Length(max=2)
	private String projectType;//项目类型

	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区ID

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "TEACHER_TYPE_")
	@Length(max=128)
	private String teacherType;//导师类型

	@Column(name = "PROJECT_DIS_")
	@Length(max=1024)
	private String projectDis;//项目简介

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//申请人

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ID_")
	@Length(max=36)
	private String id;//ID_

	@Column(name = "IS_FINACE_")
	@Length(max=1)
	private String isFinace;//是否融资
	
	public String getApplayStatus(){
		return this.applayStatus;
	}
	
	public void setApplayStatus(String applayStatus){
		this.applayStatus = applayStatus;
	}
	public String getApplayNo(){
		return this.applayNo;
	}
	
	public void setApplayNo(String applayNo){
		this.applayNo = applayNo;
	}
	public String getProjectType(){
		return this.projectType;
	}
	
	public void setProjectType(String projectType){
		this.projectType = projectType;
	}
	public String getParkId(){
		return this.parkId;
	}
	
	public void setParkId(String parkId){
		this.parkId = parkId;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getTeacherType(){
		return this.teacherType;
	}
	
	public void setTeacherType(String teacherType){
		this.teacherType = teacherType;
	}
	public String getProjectDis(){
		return this.projectDis;
	}
	
	public void setProjectDis(String projectDis){
		this.projectDis = projectDis;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getMemberId(){
		return this.memberId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public String getIsFinace(){
		return this.isFinace;
	}
	
	public void setIsFinace(String isFinace){
		this.isFinace = isFinace;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applayStatus == null) ? 0 : applayStatus.hashCode());
		result = prime * result + ((applayNo == null) ? 0 : applayNo.hashCode());
		result = prime * result + ((projectType == null) ? 0 : projectType.hashCode());
		result = prime * result + ((parkId == null) ? 0 : parkId.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((teacherType == null) ? 0 : teacherType.hashCode());
		result = prime * result + ((projectDis == null) ? 0 : projectDis.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isFinace == null) ? 0 : isFinace.hashCode());
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
		final Entrepreneurship other = (Entrepreneurship) obj;
		if (applayStatus == null) {
			if (other.applayStatus != null)
				return false;
		} else if (!applayStatus.equals(other.applayStatus))
			return false;
		if (applayNo == null) {
			if (other.applayNo != null)
				return false;
		} else if (!applayNo.equals(other.applayNo))
			return false;
		if (projectType == null) {
			if (other.projectType != null)
				return false;
		} else if (!projectType.equals(other.projectType))
			return false;
		if (parkId == null) {
			if (other.parkId != null)
				return false;
		} else if (!parkId.equals(other.parkId))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (teacherType == null) {
			if (other.teacherType != null)
				return false;
		} else if (!teacherType.equals(other.teacherType))
			return false;
		if (projectDis == null) {
			if (other.projectDis != null)
				return false;
		} else if (!projectDis.equals(other.projectDis))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isFinace == null) {
			if (other.isFinace != null)
				return false;
		} else if (!isFinace.equals(other.isFinace))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}