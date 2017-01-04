/**
 * 
 */
package com.codingtest.basket.service.impl;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codingtest.basket.domain.Basket;

/**
 * @author umberto
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContextTest.xml"})
public class BasketServiceTest {

	static final Logger logger = Logger.getLogger(BasketServiceTest.class);

	/**
	 * Service to test
	 */
	@Autowired
	private BasketService basketService;

	/**
	 * Basket
	 */
	@Autowired
	private Basket basket;
	
	/**
	 * Check basketService is autowired correctly.
	 */
	@Before
	public void setup() {
		assertNotNull("basketService not initialised", basketService);
	}
	
	/**
     * Test Getters / Setters and Constructor.
     */
    @Test
    public void testBean() {
        assertThat(BasketService.class, allOf(hasValidGettersAndSetters(), hasValidBeanConstructor()));
    }
    
	/**
	 * @throws Exception
	 */
	@Test
	public void testFinalPrice5Products() {
		basketService.setBasket(basket);
		
		List<String> productIds = new LinkedList<>();
		productIds.add("Apples");
		productIds.add("Oranges");
		productIds.add("Apples");
		productIds.add("Oranges");
		productIds.add("Apples");
		
		float finalPrice = basketService.calculateFinalPrice(productIds);
		
		if (logger.isDebugEnabled()) {
			logger.debug("The final price : " + finalPrice);
		}
		assertEquals("Final Price", 2.30, (double)finalPrice, 0.000001);
	}
		
	/**
	 * @throws Exception
	 */
	@Test
	public void testFinalPrice3Products() {
		basketService.setBasket(basket);
		
		List<String> productIds = new LinkedList<>();
		productIds.add("Apples");
		productIds.add("Oranges");
		productIds.add("Apples");
		
		float finalPrice = basketService.calculateFinalPrice(productIds);
		
		if (logger.isDebugEnabled()) {
			logger.debug("The price is " + finalPrice);
		}
		assertEquals("Final Price", 1.45, (double)finalPrice, 0.000001);
	}
	
	/**
	 * @throws Exception
	 */
	@Test
	public void testInValidAsUsedUnknownProducts() {
		basketService.setBasket(basket);
		
		List<String> productIds = new LinkedList<>();
		productIds.add("Pears");
		
		float finalPrice = basketService.calculateFinalPrice(productIds);
		
		if (logger.isDebugEnabled()) {
			logger.debug("The price is " + finalPrice);
		}
		assertEquals("No Final Price", 0.0, (double)finalPrice, 0.000001);
	}
	
}
