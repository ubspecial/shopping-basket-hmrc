/**
 * 
 */
package com.codingtest.basket.domain;

/**
 * This class holds the information for a single product in the shop.
 * @author umberto
 * 
 */
public class Product {
	
	/**
	 * Product productId.
	 */
	private String productId;

	/**
	 * Product description.
	 */
	private String description;
	
	/**
	 * Product price.
	 */
	private float price;
	
	
	/**
	 * @return
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}	

	/**
	 * @return
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}
}
