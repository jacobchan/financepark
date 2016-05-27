/**
 *
 */
package com.common.NewsManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 新闻顶或踩记录表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_nm_issuenews_d_or_c_")
public class NmIssuenewsDorC implements Domain{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ISSUE_NEWS_ID_")
	@Length(max=36)
	private String issueNewsId;//新闻id

	@Column(name = "USER_IP_")
	@Length(max=16)
	private String userIp;//用户ip地址

	@Column(name = "STATUS_")
	@Length(max=2)
	private String status;//顶或踩的状态，00为顶，01为踩
	
	@Column(name = "CURRENT_DING_COUNT_")
	private String currentDingCount;//当前顶的次数
	
	@Column(name = "CURRENT_CAI_COUNT_")
	private String currentCaiCount;//当前踩的次数
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "D_OR_C_ID_")
	@Length(max=36)
	private String id;//主键id
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
	public String getIssueNewsId() {
		return issueNewsId;
	}

	public void setIssueNewsId(String issueNewsId) {
		this.issueNewsId = issueNewsId;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrentDingCount() {
		return currentDingCount;
	}

	public void setCurrentDingCount(String currentDingCount) {
		this.currentDingCount = currentDingCount;
	}

	public String getCurrentCaiCount() {
		return currentCaiCount;
	}

	public void setCurrentCaiCount(String currentCaiCount) {
		this.currentCaiCount = currentCaiCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "NmIssuenewsDorC [issueNewsId=" + issueNewsId + ", userIp="
				+ userIp + ", status=" + status + ", currentDingCount="
				+ currentDingCount + ", currentCaiCount=" + currentCaiCount
				+ ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currentCaiCount == null) ? 0 : currentCaiCount.hashCode());
		result = prime
				* result
				+ ((currentDingCount == null) ? 0 : currentDingCount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((issueNewsId == null) ? 0 : issueNewsId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userIp == null) ? 0 : userIp.hashCode());
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
		NmIssuenewsDorC other = (NmIssuenewsDorC) obj;
		if (currentCaiCount == null) {
			if (other.currentCaiCount != null)
				return false;
		} else if (!currentCaiCount.equals(other.currentCaiCount))
			return false;
		if (currentDingCount == null) {
			if (other.currentDingCount != null)
				return false;
		} else if (!currentDingCount.equals(other.currentDingCount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (issueNewsId == null) {
			if (other.issueNewsId != null)
				return false;
		} else if (!issueNewsId.equals(other.issueNewsId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userIp == null) {
			if (other.userIp != null)
				return false;
		} else if (!userIp.equals(other.userIp))
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

	
}