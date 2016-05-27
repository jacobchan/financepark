/**
 *
 */
package com.common.purchasingManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 商品分类评价信息表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_purchasingManager_genreEvaluate")
public class PurchasingmanagerGenreevaluate implements Domain{
	
	private static final long serialVersionUID = -1520656756405937881L;
	

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "CREATE_TIME_")
	@Length(max=20)
	private String createTime;//创建时间

	@Column(name = "SERVICE_ATTITUDE_")
	@Length(max=1)
	private String serviceAttitude;//服务态度

	@Column(name = "REACTION_RATE_")
	@Length(max=1)
	private String reactionRate;//反应速度

	@Column(name = "CONTENT_")
	@Length(max=1024)
	private String content;//内容
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PUR_GENRE_")
	private PurchasingmanagerGenre purGenre;//商品类别

	@Column(name = "COST_PERFORMANCE_")
	@Length(max=1)
	private String costPerformance;//性价比

	@Column(name = "UPDATE_TIME_")
	@Length(max=20)
	private String updateTime;//修改时间

	@Column(name = "OVERALL_SATISFACTION_")
	@Length(max=1)
	private String overallSatisfaction;//整体满意度
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "GENREEVALUATE_ID_")
	@Length(max=36)
	private String genreevaluateId;//评价ID

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "TYPE_")
	@Length(max=2)
	private String type;//类型
	
	@Column(name = "MEMBER_")
	@Length(max=36)
	private String member;//会员
	
	@Transient
	private MemberInformation memberInformation;//会员对象
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
	public MemberInformation getMemberInformation() {
		return memberInformation;
	}

	public void setMemberInformation(MemberInformation memberInformation) {
		this.memberInformation = memberInformation;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getServiceAttitude(){
		return this.serviceAttitude;
	}
	
	public void setServiceAttitude(String serviceAttitude){
		this.serviceAttitude = serviceAttitude;
	}
	public String getReactionRate(){
		return this.reactionRate;
	}
	
	public void setReactionRate(String reactionRate){
		this.reactionRate = reactionRate;
	}
	public String getContent(){
		return this.content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public PurchasingmanagerGenre getPurGenre() {
		return purGenre;
	}

	public void setPurGenre(PurchasingmanagerGenre purGenre) {
		this.purGenre = purGenre;
	}

	public String getCostPerformance(){
		return this.costPerformance;
	}
	
	public void setCostPerformance(String costPerformance){
		this.costPerformance = costPerformance;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getOverallSatisfaction(){
		return this.overallSatisfaction;
	}
	
	public void setOverallSatisfaction(String overallSatisfaction){
		this.overallSatisfaction = overallSatisfaction;
	}
	public String getGenreevaluateId(){
		return this.genreevaluateId;
	}
	
	public void setGenreevaluateId(String genreevaluateId){
		this.genreevaluateId = genreevaluateId;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getType(){
		return this.type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((serviceAttitude == null) ? 0 : serviceAttitude.hashCode());
		result = prime * result + ((reactionRate == null) ? 0 : reactionRate.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((purGenre == null) ? 0 : purGenre.hashCode());
		result = prime * result + ((costPerformance == null) ? 0 : costPerformance.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((overallSatisfaction == null) ? 0 : overallSatisfaction.hashCode());
		result = prime * result + ((genreevaluateId == null) ? 0 : genreevaluateId.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		
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
		final PurchasingmanagerGenreevaluate other = (PurchasingmanagerGenreevaluate) obj;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (serviceAttitude == null) {
			if (other.serviceAttitude != null)
				return false;
		} else if (!serviceAttitude.equals(other.serviceAttitude))
			return false;
		if (reactionRate == null) {
			if (other.reactionRate != null)
				return false;
		} else if (!reactionRate.equals(other.reactionRate))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (purGenre == null) {
			if (other.purGenre != null)
				return false;
		} else if (!purGenre.equals(other.purGenre))
			return false;
		if (costPerformance == null) {
			if (other.costPerformance != null)
				return false;
		} else if (!costPerformance.equals(other.costPerformance))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (overallSatisfaction == null) {
			if (other.overallSatisfaction != null)
				return false;
		} else if (!overallSatisfaction.equals(other.overallSatisfaction))
			return false;
		if (genreevaluateId == null) {
			if (other.genreevaluateId != null)
				return false;
		} else if (!genreevaluateId.equals(other.genreevaluateId))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
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
	
	public String toString(){
		return super.toString();
	}
}