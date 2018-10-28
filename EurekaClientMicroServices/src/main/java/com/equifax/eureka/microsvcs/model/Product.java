package com.equifax.eureka.microsvcs.model;

import org.springframework.stereotype.Component;

@Component
public class Product {

	private String prodId;
	private String prodName;
	private String prodDesc;
	private String prodCategory;
	private double prodCost;
	/**
	 * @return the prodId
	 */
	public String getProdId() {
		return prodId;
	}
	/**
	 * @param prodId the prodId to set
	 */
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	/**
	 * @return the prodName
	 */
	public String getProdName() {
		return prodName;
	}
	/**
	 * @param prodName the prodName to set
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	/**
	 * @return the prodDesc
	 */
	public String getProdDesc() {
		return prodDesc;
	}
	/**
	 * @param prodDesc the prodDesc to set
	 */
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	/**
	 * @return the prodCategory
	 */
	public String getProdCategory() {
		return prodCategory;
	}
	/**
	 * @param prodCategory the prodCategory to set
	 */
	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}
	/**
	 * @return the prodCost
	 */
	public double getProdCost() {
		return prodCost;
	}
	/**
	 * @param prodCost the prodCost to set
	 */
	public void setProdCost(double prodCost) {
		this.prodCost = prodCost;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [prodId=");
		builder.append(prodId);
		builder.append(", prodName=");
		builder.append(prodName);
		builder.append(", prodDesc=");
		builder.append(prodDesc);
		builder.append(", prodCategory=");
		builder.append(prodCategory);
		builder.append(", prodCost=");
		builder.append(prodCost);
		builder.append("]");
		return builder.toString();
	}
	
	
}
