package com.codingtest.basket.domain;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests the Basket bean
 *
 * @author umberto
 */
public class BasketTest {
	/**
     * Test Getters / Setters and Constructor.
     */
    @Test
    public void testBean() {
        assertThat(Basket.class, allOf(hasValidGettersAndSetters(), hasValidBeanConstructor()));
        
        final String currencyCode = "GBP";
        final String currencySymbol = "£";
        final String currencyLocal = "UK";
        
        final Basket basket = new Basket();
        basket.setCurrencyCode(currencyCode);
        basket.setCurrencySymbol(currencySymbol);
        basket.setCurrencyLocal(currencyLocal);
        
        assertEquals(currencyCode, basket.getCurrencyCode());
        assertEquals(currencyLocal, basket.getCurrencyLocal());
        assertEquals(currencySymbol, basket.getCurrencySymbol());        
    }
}
