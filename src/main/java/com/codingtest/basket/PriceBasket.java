/**
 * 
 */
package com.codingtest.basket;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codingtest.basket.service.impl.BasketService;

/**
 * This is the main method of the application.
 * @author umberto
 * 
 */
public class PriceBasket {

	private static final Logger logger = Logger.getLogger(BasketService.class);

	private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] {"ApplicationContext.xml"});

	private static final String USAGE_INFORMATION = "Usage: java -jar shoppingbasket-1.0.0-SNAPSHOT.jar [items]\n : e.g. java -jar shoppingbasket-1.0.0-SNAPSHOT.jar Apples Apples Oranges Apples";
	
	/**
	 * The program calculates the final price of the products in the basket.
	 * @param args The args are the actual product IDs of the products in the basket.
	 */
	public static void main(String[] args) {				
		if (args == null || args.length == 0) {
			logger.error(USAGE_INFORMATION);
			System.err.println(USAGE_INFORMATION);			
			System.exit(0);
		} 
		
		BasketService basketService = appContext.getBean("basketService", BasketService.class);
		
		List<String> productIds = Arrays.asList(args);
		try {
			basketService.calculateFinalPrice(productIds);
		} catch (Exception e) {
			logger.error("Error: " + e);
			System.err.println(e);
		}
	}
}
