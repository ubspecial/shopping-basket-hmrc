package com.codingtest.basket.offer;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codingtest.basket.domain.Basket;
import com.codingtest.basket.domain.Product;

/**
 * @author umberto
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContextTest.xml"})
public class OfferTest {

	@Autowired
	private Offer offer;

	@Autowired
	private Basket basket;

	/**
     * Test Getters / Setters and Constructor.
     */
    @Test
    public void testBean() {
        assertThat(Offer.class, allOf(hasValidGettersAndSetters(), hasValidBeanConstructor()));
    }
    	
	@Test
	public void testNoDiscountAsNotEnoughItemsSelected() {
		List<Product> items = Arrays.asList("Apples", "Oranges").stream()
				.map(idItem -> basket.getProducts().get(idItem))
				.collect(Collectors.toList());
		
		assertEquals("No discount given", 0.0, (double)offer.getFinalPrice(items), 0.000001);
	}		

	@Test
	public void testDiscountApplesQuarterPriceOfferSelected() {
		List<Product> items = Arrays.asList("Oranges", "Oranges", "Apples").stream()
				.map(idItem -> basket.getProducts().get(idItem))
				.collect(Collectors.toList());
		
		assertEquals("Discount given", 0.45, (double)offer.getFinalPrice(items), 0.000001);
	}
}
