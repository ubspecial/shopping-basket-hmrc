package com.codingtest.basket.domain;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests the Product bean
 *
 * @author umberto
 */
public class ProductTest {
	/**
     * Test Getters / Setters and Constructor.
     */
    @Test
    public void testBean() {
    	assertThat(Product.class, allOf(hasValidGettersAndSetters(), hasValidBeanConstructor()));
        
        final String description = "description";
        final float price = 0;
        final String productId = "productId";
        
        final Product product = new Product();
        product.setDescription(description);
        product.setPrice(price);
        product.setProductId(productId);
        
        assertEquals(description, product.getDescription());
        assertEquals(productId, product.getProductId());        
    }
}
