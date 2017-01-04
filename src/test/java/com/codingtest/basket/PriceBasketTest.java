package com.codingtest.basket;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author umberto
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContextTest.xml"})
public class PriceBasketTest {
	
	/**
     * Test Getters / Setters and Constructor.
     */
    @Test
    public void testBean() {
        assertThat(PriceBasket.class, allOf(hasValidGettersAndSetters(), hasValidBeanConstructor()));
    }
    
    @Test
    public void testValidInputMain() {                
        PriceBasket.main(new String[] {"Oranges", "Apples", "Oranges"});        
    }
    
    @Ignore
    public void testZZEmptyInputMain() {        
        PriceBasket.main(new String[] {});        
    }
}
