/**
 * 
 */
package com.codingtest.basket.service;

import java.util.List;

@FunctionalInterface
public interface IBasketService {
		
	/**
	 * This method calculates the final price of the products in the basket.
	 * @param productIds The productIds are the actual product IDs of the products in the basket.
	 */
	public float calculateFinalPrice(List<String> productIds);

}
