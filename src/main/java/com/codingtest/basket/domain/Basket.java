/**
 * 
 */
package com.codingtest.basket.domain;

import java.util.Map;

/**
 * This class holds the information about the basket.
 * @author umberto
 * 
 */
public class Basket {
	
	/**
	 * Product list.
	 */
	private Map<String, Product> products;

	/**
	 * Currency code.
	 */
	private String currencyCode;
	
	/**
	 * Currency symbol.
	 */
	private String currencySymbol;
	
	/**
	 * Currency local.
	 */
	private String currencyLocal;
	
	/**
	 * @return
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @param currencyCode
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * @return
	 */
	public String getCurrencySymbol() {
		return currencySymbol;
	}

	/**
	 * @param currencySymbol
	 */
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
			
	/**
	 * @return
	 */
	public String getCurrencyLocal() {
		return currencyLocal;
	}
	
	/**
	 * @param currencyLocal
	 */
	public void setCurrencyLocal(String currencyLocal) {
		this.currencyLocal = currencyLocal;
	}

	/**
	 * @return
	 */
	public Map<String, Product> getProducts() {
		return products;
	}

	/**
	 * @param products
	 */
	public void setProducts(Map<String, Product> products) {
		this.products = products;
	}
}
