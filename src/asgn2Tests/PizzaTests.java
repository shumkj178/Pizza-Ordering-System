package asgn2Tests;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.PizzaTopping;
import asgn2Pizzas.VegetarianPizza;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Person B
 *
 */
public class PizzaTests {

	MeatLoversPizza meatLoversPizza;
	VegetarianPizza vegetarianPizza;
	MargheritaPizza margheritaPizza;
	MeatLoversPizza meatLoversPizzaTest;
	LocalTime openTime = LocalTime.parse("19:00:00");
	LocalTime closeTime = LocalTime.parse("23:00:00");
	LocalTime orderTime = LocalTime.parse("20:00:00");;
	LocalTime deliveryTime = LocalTime.parse("20:15:00");
	
	@Before
	public void setUp() throws PizzaException {
		
		//these instances are declared for testing Pizza class functions
		meatLoversPizza = new MeatLoversPizza(2, orderTime, deliveryTime);
		vegetarianPizza = new VegetarianPizza(4, orderTime, deliveryTime);
		margheritaPizza = new MargheritaPizza(3, orderTime, deliveryTime);
	}
	
	@Test (expected = PizzaException.class)
	public void testCreatePizzaInstanceWhenQuantityIsZero() throws PizzaException {
		meatLoversPizzaTest = new MeatLoversPizza(0, orderTime, deliveryTime);
	}
	
	@Test (expected = PizzaException.class)
	public void testCreatePizzaInstanceWhenQuantityIsNegativeValue() throws PizzaException {
		meatLoversPizzaTest = new MeatLoversPizza(-1, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void testCreatePizzaInstanceWhenQuantityIsLargerThan10() throws PizzaException {
		meatLoversPizzaTest = new MeatLoversPizza(11, orderTime, deliveryTime);
	}
	
	@Test
	public void testCreatePizzaInstanceWithAcceptableQuantity() throws PizzaException {
		meatLoversPizzaTest = new MeatLoversPizza(8, orderTime, deliveryTime);
	}
	
	@Test (expected = PizzaException.class)
	public void testCreatePizzaInstanceWhenOrderTimeIsBeforeOpenTime() throws PizzaException {
		meatLoversPizzaTest = new MeatLoversPizza(1, openTime.minusMinutes(5), deliveryTime);
	}
	
	@Test (expected = PizzaException.class)
	public void testCreatePizzaInstanceWhenOrderTimeIsAfterOpenTime() throws PizzaException {
		meatLoversPizzaTest = new MeatLoversPizza(1, closeTime.minusMinutes(5), deliveryTime);
	}
	
	@Test
	public void testCreatePizzaInstanceWhenOrderInTheRightTime() throws PizzaException {
		meatLoversPizza = new MeatLoversPizza(8, orderTime, deliveryTime);
	}
	
	@Test (expected = PizzaException.class)
	public void testCreatePizzaInstanceWhenDeliveryTimeIsOneHourAfterOrderTime() throws PizzaException {
		meatLoversPizzaTest = new MeatLoversPizza(1, orderTime, orderTime.plusMinutes(61));
	}
	
	@Test (expected = PizzaException.class)
	public void testCreatePizzaInstanceWhenDeliveryTimeIsBeforeOrderTime() throws PizzaException {
		meatLoversPizzaTest = new MeatLoversPizza(1, orderTime, orderTime.minusSeconds(5));
	}
	
	@Test (expected = PizzaException.class)
	public void testCreatePizzaInstanceWhenDeliveryTimeIsWithin10MinutesOfOrderTime() throws PizzaException {
		meatLoversPizzaTest = new MeatLoversPizza(1, orderTime, orderTime.plusMinutes(9));
	}
	
	@Test
	public void testCreatePizzaInstanceWhenDeliveryTimeIsCorrect() throws PizzaException {
		meatLoversPizzaTest = new MeatLoversPizza(2, orderTime, deliveryTime);
	}
	
	@Test
	public void testCalculateCostPerPizzaForAllPizzaTypes() throws PizzaException {
		assertEquals(5.0, meatLoversPizza.getCostPerPizza(), 0.0);
		assertEquals(5.5, vegetarianPizza.getCostPerPizza(), 0.0);
		assertEquals(1.5, margheritaPizza.getCostPerPizza(), 0.0);
	}
	
	@Test
	public void testGetCostPerPizzaForAllPizzaTypes() throws PizzaException {
		assertEquals(5.0, meatLoversPizza.getCostPerPizza(), 0.0);
		assertEquals(5.5, vegetarianPizza.getCostPerPizza(), 0.0);
		assertEquals(1.5, margheritaPizza.getCostPerPizza(), 0.0);
	}
	
	@Test
	public void testGetPrizePerPizzaForAllPizzaTypes() {
		assertEquals(12.0, meatLoversPizza.getPricePerPizza(), 0.0);
		assertEquals(10.0, vegetarianPizza.getPricePerPizza(), 0.0);
		assertEquals(8.0, margheritaPizza.getPricePerPizza(), 0.0);
	}
	
	@Test
	public void testGetOrderCostForAllPizzaTypes() {
		assertEquals(10.0, meatLoversPizza.getOrderCost(), 0.0);
		assertEquals(22.0, vegetarianPizza.getOrderCost(), 0.0);
		assertEquals(4.5, margheritaPizza.getOrderCost(), 0.0);
	}
	
	@Test
	public void testGetOrderPriceForAllPizzaTypes() {
		assertEquals(24.0, meatLoversPizza.getOrderPrice(), 0.0);
		assertEquals(40.0, vegetarianPizza.getOrderPrice(), 0.0);
		assertEquals(24.0, margheritaPizza.getOrderPrice(), 0.0);
	}
	
	@Test
	public void testGetOrderProfitForAllPizzaTypes() {
		assertEquals(14.0, meatLoversPizza.getOrderProfit(), 0.0);
		assertEquals(18.0, vegetarianPizza.getOrderProfit(), 0.0);
		assertEquals(19.5, margheritaPizza.getOrderProfit(), 0.0);
	}
	
	@Test
	public void testAllToppingsForMeatLoversPizza() {
		assertTrue(meatLoversPizza.containsTopping(PizzaTopping.CHEESE));
		assertTrue(meatLoversPizza.containsTopping(PizzaTopping.BACON));
		assertTrue(meatLoversPizza.containsTopping(PizzaTopping.SALAMI));
		assertTrue(meatLoversPizza.containsTopping(PizzaTopping.PEPPERONI));
		assertTrue(meatLoversPizza.containsTopping(PizzaTopping.TOMATO));
	}
	
	@Test
	public void testAllToppingsForVegetarianPizza() {
		assertTrue(vegetarianPizza.containsTopping(PizzaTopping.EGGPLANT));
		assertTrue(vegetarianPizza.containsTopping(PizzaTopping.CAPSICUM));
		assertTrue(vegetarianPizza.containsTopping(PizzaTopping.TOMATO));
		assertTrue(vegetarianPizza.containsTopping(PizzaTopping.CHEESE));
		assertTrue(vegetarianPizza.containsTopping(PizzaTopping.MUSHROOM));
	}
	
	@Test
	public void testAllToppingsForMargheritaPizza() {
		assertTrue(margheritaPizza.containsTopping(PizzaTopping.TOMATO));
		assertTrue(margheritaPizza.containsTopping(PizzaTopping.CHEESE));
	}
	
	@Test
	public void testNonToppingsForMeatLoversPizza() {
		assertFalse(meatLoversPizza.containsTopping(PizzaTopping.CAPSICUM));
		assertFalse(meatLoversPizza.containsTopping(PizzaTopping.MUSHROOM));
		assertFalse(meatLoversPizza.containsTopping(PizzaTopping.EGGPLANT));
	}
	
	@Test
	public void testNonToppingsForVegetarianPizza() {
		assertFalse(vegetarianPizza.containsTopping(PizzaTopping.BACON));
		assertFalse(vegetarianPizza.containsTopping(PizzaTopping.PEPPERONI));
		assertFalse(vegetarianPizza.containsTopping(PizzaTopping.SALAMI));
	}
	
	@Test
	public void testNonToppingsForMargheritaPizza() {
		assertFalse(margheritaPizza.containsTopping(PizzaTopping.BACON));
		assertFalse(margheritaPizza.containsTopping(PizzaTopping.PEPPERONI));
		assertFalse(margheritaPizza.containsTopping(PizzaTopping.SALAMI));
		assertFalse(margheritaPizza.containsTopping(PizzaTopping.CAPSICUM));
		assertFalse(margheritaPizza.containsTopping(PizzaTopping.MUSHROOM));
		assertFalse(margheritaPizza.containsTopping(PizzaTopping.EGGPLANT));
	}
	
	@Test
	public void testGetQuantity() {
		assertEquals(2, meatLoversPizza.getQuantity());
	}
	
	@Test
	public void testGetPizzaTypeForAllPizzaTypes() {
		assertEquals("Margherita", margheritaPizza.getPizzaType());
		assertEquals("Vegetarian", vegetarianPizza.getPizzaType());
		assertEquals("Meat Lovers", meatLoversPizza.getPizzaType());
	}
}
