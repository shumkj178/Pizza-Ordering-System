package asgn2Tests;

import static org.junit.Assert.*;

import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that tests the methods relating to the handling of Pizza objects in
 * the asgn2Restaurant.PizzaRestaurant class as well as processLog and
 * resetDetails.
 * 
 * @author Khar Jun Shum
 *
 */
public class RestaurantPizzaTests {

	final static String FILE_1 = Paths.get("logs/20170101.txt").toString();
	final static String FILE_2 = Paths.get("logs/20170102.txt").toString();
	final static String FILE_3 = Paths.get("logs/20170103.txt").toString();
	final static String INVALID_FILE = Paths.get("logs/unit-test-logs/pizza/file-with-invalid-pizza-code.txt")
			.toString();

	private PizzaRestaurant pizzaRestaurant;

	@Before
	public void setUp() throws Exception {
		pizzaRestaurant = new PizzaRestaurant();
		pizzaRestaurant.processLog(FILE_1);
	}

	@Test
	public void testProcessLogReturnsTrueIfProcessesSuccessfully()
			throws CustomerException, PizzaException, LogHandlerException {
		assertTrue(pizzaRestaurant.processLog(FILE_1));
	}

	@Test(expected = LogHandlerException.class)
	public void testProcessLogWithEmptyFilename() throws CustomerException, PizzaException, LogHandlerException {
		assertTrue(pizzaRestaurant.processLog(""));
	}

	@Test(expected = PizzaException.class)
	public void testProcessLogWithInvalidPizzaCode() throws CustomerException, PizzaException, LogHandlerException {
		assertTrue(pizzaRestaurant.processLog(INVALID_FILE));
	}

	@Test(expected = PizzaException.class)
	public void testGetPizzaIndexLessThanZero() throws PizzaException {
		pizzaRestaurant.getPizzaByIndex(-1);
	}

	@Test(expected = PizzaException.class)
	public void testGetPizzaMoreThanSize() throws PizzaException {
		pizzaRestaurant.getPizzaByIndex(5);
	}

	@Test
	public void testGetPizzaByIndexReturnPizzaClass() throws PizzaException {
		assertNotNull(pizzaRestaurant.getPizzaByIndex(1).getClass());
	}

	@Test
	public void testGetNumPizzaOrdersReturnOrdersSize() {
		assertEquals(3, pizzaRestaurant.getNumPizzaOrders());
	}

	@Test
	public void testGetTotalProfitReturnTotalProfitForOrders() {
		assertEquals(36.5, pizzaRestaurant.getTotalProfit(), 0.000);
	}

	@Test
	public void testResetDetail() {
		pizzaRestaurant.resetDetails();
		assertEquals(0, pizzaRestaurant.getNumPizzaOrders());
	}
}
