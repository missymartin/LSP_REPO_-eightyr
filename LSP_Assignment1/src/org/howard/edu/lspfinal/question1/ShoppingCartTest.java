package org.howard.edu.lspfinal.question1;

import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;

class ShoppingCartTest {
	ShoppingCart cart1;
	ShoppingCart cart2;
	Map<String, Double> items;
	
	@BeforeEach
	void setUp(){
		cart1.addItem("Bannana", 2.0);
		cart1.addItem("Apple", 1.0);
		
	}

	@Test
	@DisplayName("Test total cost.")
	public void testTotalCost() {
		//full cart
		assertEquals(cart1.getTotalCost(),3.0);
		//empty cart
		assertEquals(cart2.getTotalCost(),3.0);
		//discount cart
		cart1.applyDiscountCode("SAVE10");
		assertEquals(cart1.getTotalCost(),3.0);
	}
	
	@Test
	@DisplayName("Test remove items.")
	public void testRemoveItem() {
		//full cart
		cart1.removeItem("Apple");
		assertEquals(cart1.getTotalCost(),2.0);
		//empty cart
		Throwable exception = assertThrows( IllegalArgumentException.class, ()->cart2.removeItem("Apple"));
		assertEquals("Item does not exist.", exception.getMessage());
		//not in cart
		
		Throwable exception2 = assertThrows( IllegalArgumentException.class, ()->cart1.removeItem("Avacado"));
		assertEquals("Item does not exist.", exception2.getMessage());;
	}
	
	@Test
	@DisplayName("Test applying discount codes.")
	public void testDiscountCode() {
		//SAVE10
		cart1.applyDiscountCode("SAVE10");
		cart1.getDiscountPercentage();
		assertEquals(cart1.getDiscountPercentage(),10.0);
		//SAVE20
		cart1.applyDiscountCode("SAVE20");
		assertEquals(cart1.getDiscountPercentage(),20.0);
		//SAVE50
		Throwable exception = assertThrows( IllegalArgumentException.class, ()->cart1.applyDiscountCode("SAVE50"));
		assertEquals("Invalid discount code.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test adding Items.")
	public void testAddItem() {
		//Valid item, since the add Item is private we are using the total cost method to check the new item was added
		//orginal cost of cart 3.0
		cart1.addItem("Avacado", 4.0);
		assertEquals(cart1.getTotalCost(),7.0);
		//negative item
		Throwable exception = assertThrows( IllegalArgumentException.class, ()->cart1.addItem("Air", -34.0));
		assertEquals("Price cannot be negative.", exception.getMessage());
	}

}
