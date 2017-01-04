/**
 * 
 */
package com.codingtest.basket.service.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.codingtest.basket.domain.Basket;
import com.codingtest.basket.domain.Product;
import com.codingtest.basket.service.IBasketService;

/**
 * This is the implementation class for the basket service.
 * @author umberto
 * 
 */
public class BasketService implements IBasketService {

	private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.UK);
	
	/**
	 * The basket containing the products.
	 */	
	private Basket basket;
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public float calculateFinalPrice(List<String> productIds) {
		float totalPrice = 0;
		if (validProductsInBasket(productIds)) {
			// Create a list of products in the basket.			
			List<Product> products = new ArrayList<>();
			for (String productId : productIds) {
				if (basket.getProducts().containsKey(productId) ) {
					products.add(basket.getProducts().get(productId));
				}
			}
			
			// Calculate the subtotal.
			float subTotalPrice = getSubtotalPrice(products);
			
			totalPrice = subTotalPrice;
		}		
		
		System.out.println("Total Price: " + currencyFormat.format(totalPrice));
		return totalPrice;
	}
	
	/**
	 * Validate the products in the basket.
	 * @param productIds The productIds of the products.	 
	 */
	private boolean validProductsInBasket(List<String> productIds) {
		List<String> invalidProductIds = productIds.stream()
				.filter(idItem -> !basket.getProducts().containsKey(idItem))
				.collect(Collectors.toList());

		if (!invalidProductIds.isEmpty()) {
			return false;
		}
		
		return true;
	}

	/**
	 * Returns the subtotal price without any discounts.
	 * @param products List of products in the basket.
	 * @return Subtotal price.
	 */
	private float getSubtotalPrice(List<Product> products) {
		float subTotalPrice = 0;
		for (Product product : products) {
			System.out.println(product.getDescription() + ": " + product.getProductId() + ": " + currencyFormat.format(product.getPrice()));
			subTotalPrice = subTotalPrice + product.getPrice();
		}
		
		System.out.println("Subtotal: " + currencyFormat.format(subTotalPrice));
		return subTotalPrice;
	}
	
	/**
	 * @return
	 */
	public Basket getBasket() {
		return basket;
	}

	/**
	 * @param basket
	 */
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	
}
