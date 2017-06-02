package asgn2Tests;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;
import asgn2Pizzas.VegetarianPizza;

/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Person B 
 * 
 */
public class PizzaFactoryTests {
	
	LocalTime orderTime = LocalTime.parse("19:00:00");
	LocalTime deliveryTime = LocalTime.parse("19:15:00");
	Pizza pizza;
	
	@Test (expected = PizzaException.class)
	public void testGetPizzaUsingEmptyPizzaCode() throws PizzaException {
		pizza = PizzaFactory.getPizza("", 1, orderTime, deliveryTime);
	}
	
	@Test (expected = PizzaException.class)
	public void testGetPizzaUsingBlankSpacesCode() throws PizzaException {
		pizza = PizzaFactory.getPizza(" ", 1, orderTime, deliveryTime);
	}
	
	@Test (expected = PizzaException.class)
	public void testGetPizzaUsingWrongPizzaCodeInUpperCase() throws PizzaException {
		pizza = PizzaFactory.getPizza("LFC", 1, orderTime, deliveryTime);
	}
	
	@Test (expected = PizzaException.class)
	public void testGetPizzaUsingWrongPizzaCodeInLowerCase() throws PizzaException {
		pizza = PizzaFactory.getPizza("lfc", 1, orderTime, deliveryTime);
	}
	
	@Test
	public void testGetPizzaUsingCorrectMargheritaPizzaCodeInLowerCase() throws PizzaException {
		pizza = PizzaFactory.getPizza("pzm", 1, orderTime, deliveryTime);
		assertEquals(MargheritaPizza.class, pizza.getClass());
	}
	
	@Test
	public void testGetPizzaUsingCorrectVegetarianPizzaCodeInLowerCase() throws PizzaException {
		pizza = PizzaFactory.getPizza("pzv", 1, orderTime, deliveryTime);
		assertEquals(VegetarianPizza.class, pizza.getClass());
	}
	
	@Test
	public void testGetPizzaUsingCorrectMeatLoversPizzaCodeInLowerCase() throws PizzaException {
		pizza = PizzaFactory.getPizza("pzl", 1, orderTime, deliveryTime);
		assertEquals(MeatLoversPizza.class, pizza.getClass());
	}
	
	@Test
	public void testGetPizzaUsingCorrectMargheritaPizzaCodeInUpperCase() throws PizzaException {
		pizza = PizzaFactory.getPizza("PZM", 1, orderTime, deliveryTime);
		assertEquals(MargheritaPizza.class, pizza.getClass());
	}
	
	@Test
	public void testGetPizzaUsingCorrectVegetarianPizzaCodeInUpperCase() throws PizzaException {
		pizza = PizzaFactory.getPizza("PZV", 1, orderTime, deliveryTime);
		assertEquals(VegetarianPizza.class, pizza.getClass());
	}
	
	@Test
	public void testGetPizzaUsingCorrectMeatLoversPizzaCodeInUpperCase() throws PizzaException {
		pizza = PizzaFactory.getPizza("PZL", 1, orderTime, deliveryTime);
		assertEquals(MeatLoversPizza.class, pizza.getClass());
	}
	
	@Test
	public void testGetPizzaUsingPizzaCodesFollowByBlankSpaces() throws PizzaException {
		pizza = PizzaFactory.getPizza("PZL ", 1, orderTime, deliveryTime);
	}
	
	@Test (expected = PizzaException.class)
	public void testGetPizzaUsingPizzaCodesWithBlankSpacesInBetween() throws PizzaException {
		PizzaFactory.getPizza("PZ L", 1, orderTime, deliveryTime);
	}
}
