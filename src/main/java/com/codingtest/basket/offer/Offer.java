/**
 * 
 */
package com.codingtest.basket.offer;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.codingtest.basket.domain.Product;

/**
 * This class holds all the information about a particular offer in store including
 * things like how much discount to apply to the normal price.
 * @author umberto
 * 
 */
public class Offer implements IOffer {
	
	private static final Logger logger = Logger.getLogger(Offer.class);

	/**
	 * The product on offer.
	 */
	private Product productOnOffer;

	/**
	 * The discount to apply.
	 */
	private double discount;

	/**
	 * The offer description.
	 */
	private String description;
	
	/**
	 * The required product as part of the offer.
	 */
	private Product requiredProduct;

	/**
	 * The minimum number of products required before offer becomes valid.
	 */
	private int minNumberProductsRequired;
	
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return description;
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public float getFinalPrice(List<Product> basket) {
		long numRequiredProductsFound = validateQuantityCheck(basket);

		List<Product> products = basket.stream()
				.filter(item -> item.equals(productOnOffer))
				.limit(numRequiredProductsFound)
				.collect(Collectors.toList());

		float totalDiscount = (float) products.stream()
				.mapToDouble(item -> item.getPrice() * discount / 100)
				.sum();

		if (logger.isDebugEnabled()) {
			logger.debug("Product on offer " + productOnOffer.getProductId() + " is " + totalDiscount);
		}
		return totalDiscount;
	}
	
	/**
	 * Make sure we meet the criteria of the minimum number of products 
	 * required before offer becomes valid. 
	 * @param basket
	 * @return
	 */
	private long validateQuantityCheck(List<Product> basket) {
		long numRequiredProductsFound = basket.stream()
				.filter(item -> item.equals(requiredProduct))
				.count();
		
		return numRequiredProductsFound / minNumberProductsRequired;
	}
	
	/**
	 * @param discount
	 */
	public void setDiscount(double discount) {
		this.discount = discount;		
	}
			
	/**
	 * @return
	 */
	public Product getRequiredProduct() {
		return requiredProduct;
	}

	/**
	 * @param itemRequired
	 */
	public void setRequiredProduct(Product itemRequired) {
		this.requiredProduct = itemRequired;
	}

	/**
	 * @return
	 */
	public int getMinNumberProductsRequired() {
		return minNumberProductsRequired;
	}

	/**
	 * @param minNumberProductsRequired
	 */
	public void setMinNumberProductsRequired(int minNumberProductsRequired) {
		this.minNumberProductsRequired = minNumberProductsRequired;
	}

	/**
	 * @return
	 */
	public Product getProductOnOffer() {
		return productOnOffer;
	}

	/**
	 * @param productOnOffer
	 */
	public void setProductOnOffer(Product productOnOffer) {
		this.productOnOffer = productOnOffer;
	}

	/**
	 * @return
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
