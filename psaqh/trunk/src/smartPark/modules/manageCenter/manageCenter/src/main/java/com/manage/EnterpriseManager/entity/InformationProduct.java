/**
 *
 */
package com.manage.EnterpriseManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 产品信息
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_information_product")
public class InformationProduct implements Domain{
	
	private static final long serialVersionUID = 7659995940064928319L;
	

	@Column(name = "PRODUCT_NAME_")
	@Length(max=64)
	private String productName;//产品名称

	@Column(name = "PRODUCT_RE_")
	@Length(max=32)
	private String productRe;//企业ID

	@Column(name = "PRODUCT_TYPE_")
	@Length(max=2)
	private String productType;//产品类别
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "PRODUCT_ID_")
	@Length(max=36)
	private String productId;//ID

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID2

	@Column(name = "PRODUCT_CONTENT_")
	@Length(max=256)
	private String productContent;//产品描述
	
	public String getProductName(){
		return this.productName;
	}
	
	public void setProductName(String productName){
		this.productName = productName;
	}
	public String getProductRe(){
		return this.productRe;
	}
	
	public void setProductRe(String productRe){
		this.productRe = productRe;
	}
	public String getProductType(){
		return this.productType;
	}
	
	public void setProductType(String productType){
		this.productType = productType;
	}
	public String getProductId(){
		return this.productId;
	}
	
	public void setProductId(String productId){
		this.productId = productId;
	}
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	public String getProductContent(){
		return this.productContent;
	}
	
	public void setProductContent(String productContent){
		this.productContent = productContent;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productRe == null) ? 0 : productRe.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result + ((productContent == null) ? 0 : productContent.hashCode());
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
		final InformationProduct other = (InformationProduct) obj;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productRe == null) {
			if (other.productRe != null)
				return false;
		} else if (!productRe.equals(other.productRe))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		if (productContent == null) {
			if (other.productContent != null)
				return false;
		} else if (!productContent.equals(other.productContent))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}