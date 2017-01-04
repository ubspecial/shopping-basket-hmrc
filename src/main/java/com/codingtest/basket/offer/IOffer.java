/**
 * 
 */
package com.codingtest.basket.offer;

import java.util.List;

import com.codingtest.basket.domain.Product;

/**
 * This is the interface class for an offer. 
 * @author umberto
 *
 */
public interface IOffer {
			
	/**
	 * It calculates the final price of the basket.
	 * @param basket List of products in the basket.
	 * @return the final price.
	 */
	public float getFinalPrice(List<Product> basket);
	
	/**
	 * Return the offer description.
	 * @return The offer description.
	 */
	public String getDescription();
}
