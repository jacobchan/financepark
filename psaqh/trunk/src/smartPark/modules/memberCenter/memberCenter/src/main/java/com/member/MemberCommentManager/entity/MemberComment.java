/**
 *
 */
package com.member.MemberCommentManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.common.MemberManager.entity.MemberInformation;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: -商品评价
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_member_comment")
public class MemberComment implements Domain{
	
	private static final long serialVersionUID = -3732385784891529953L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "GOODS_COMMENT_ID_")
	@Length(max=36)
	private String goodsCommentId;//商品评价ID

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MEMBER_ID_")
	private MemberInformation memberId;//会员用户ID
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COMMODITY_ID_")
	private PurchasingmanagerCommodity commodityId;//商品ID

	@Column(name = "GOODS_COMMENT_REVIEW_")
	@Length(max=1024)
	private String goodsCommentReview;//商品评价追评

	@Column(name = "GOODS_COMMENT_TIME_")
	private String goodsCommentTime;//商品评价时间

	@Column(name = "GOODS_COMMENT_LEVEL_")
	@Length(max=2)
	private String goodsCommentLevel;//商品评价等级

	@Column(name = "GOODS_COMMENT_REVIEWTIME_")
	private String goodsCommentReviewtime;//商品评价追评时间

	@Column(name = "GOODS_COMMENT_CONTENT_")
	@Length(max=1024)
	private String goodsCommentContent;//商品评价内容
	
	public String getGoodsCommentId(){
		return this.goodsCommentId;
	}
	
	public void setGoodsCommentId(String goodsCommentId){
		this.goodsCommentId = goodsCommentId;
	}
	
	public MemberInformation getMemberId() {
		return memberId;
	}

	public void setMemberId(MemberInformation memberId) {
		this.memberId = memberId;
	}

	
	public PurchasingmanagerCommodity getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(PurchasingmanagerCommodity commodityId) {
		this.commodityId = commodityId;
	}

	public String getGoodsCommentReview(){
		return this.goodsCommentReview;
	}
	
	public void setGoodsCommentReview(String goodsCommentReview){
		this.goodsCommentReview = goodsCommentReview;
	}
	public String getGoodsCommentTime(){
		return this.goodsCommentTime;
	}
	
	public void setGoodsCommentTime(String goodsCommentTime){
		this.goodsCommentTime = goodsCommentTime;
	}
	public String getGoodsCommentLevel(){
		return this.goodsCommentLevel;
	}
	
	public void setGoodsCommentLevel(String goodsCommentLevel){
		this.goodsCommentLevel = goodsCommentLevel;
	}
	public String getGoodsCommentReviewtime(){
		return this.goodsCommentReviewtime;
	}
	
	public void setGoodsCommentReviewtime(String goodsCommentReviewtime){
		this.goodsCommentReviewtime = goodsCommentReviewtime;
	}
	public String getGoodsCommentContent(){
		return this.goodsCommentContent;
	}
	
	public void setGoodsCommentContent(String goodsCommentContent){
		this.goodsCommentContent = goodsCommentContent;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsCommentId == null) ? 0 : goodsCommentId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((commodityId == null) ? 0 : commodityId.hashCode());
		result = prime * result + ((goodsCommentReview == null) ? 0 : goodsCommentReview.hashCode());
		result = prime * result + ((goodsCommentTime == null) ? 0 : goodsCommentTime.hashCode());
		result = prime * result + ((goodsCommentLevel == null) ? 0 : goodsCommentLevel.hashCode());
		result = prime * result + ((goodsCommentReviewtime == null) ? 0 : goodsCommentReviewtime.hashCode());
		result = prime * result + ((goodsCommentContent == null) ? 0 : goodsCommentContent.hashCode());
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
		final MemberComment other = (MemberComment) obj;
		if (goodsCommentId == null) {
			if (other.goodsCommentId != null)
				return false;
		} else if (!goodsCommentId.equals(other.goodsCommentId))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (commodityId == null) {
			if (other.commodityId != null)
				return false;
		} else if (!commodityId.equals(other.commodityId))
			return false;
		if (goodsCommentReview == null) {
			if (other.goodsCommentReview != null)
				return false;
		} else if (!goodsCommentReview.equals(other.goodsCommentReview))
			return false;
		if (goodsCommentTime == null) {
			if (other.goodsCommentTime != null)
				return false;
		} else if (!goodsCommentTime.equals(other.goodsCommentTime))
			return false;
		if (goodsCommentLevel == null) {
			if (other.goodsCommentLevel != null)
				return false;
		} else if (!goodsCommentLevel.equals(other.goodsCommentLevel))
			return false;
		if (goodsCommentReviewtime == null) {
			if (other.goodsCommentReviewtime != null)
				return false;
		} else if (!goodsCommentReviewtime.equals(other.goodsCommentReviewtime))
			return false;
		if (goodsCommentContent == null) {
			if (other.goodsCommentContent != null)
				return false;
		} else if (!goodsCommentContent.equals(other.goodsCommentContent))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}