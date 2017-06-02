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
 * A class that that tests the methods relating to the handling of Customer
 * objects in the asgn2Restaurant.PizzaRestaurant class as well as processLog
 * and resetDetails.
 * 
 * @author Veng Sie Choy
 */
public class RestaurantCustomerTests {
	final static String FILE_1 = Paths.get("logs/20170101.txt").toString();
	final static String INVALID_FILE = Paths.get("logs/unit-test-logs/customer/invalid-customer-code.txt").toString();

	private PizzaRestaurant customerRestaurant;

	@Before
	public void setUp() throws Exception {
		customerRestaurant = new PizzaRestaurant();
		customerRestaurant.processLog(FILE_1);

	}

	@Test
	public void testForSucessfullyProcessLog() throws CustomerException, PizzaException, LogHandlerException {
		assertTrue(customerRestaurant.processLog(FILE_1));

	}

	@Test(expected = LogHandlerException.class)
	public void testForProcessLogWithEmptyFileName() throws CustomerException, PizzaException, LogHandlerException {
		assertTrue(customerRestaurant.processLog(""));

	}

	@Test(expected = CustomerException.class)
	public void testForProcessLogWithInvalidCustomerCodeInFile()
			throws CustomerException, PizzaException, LogHandlerException {
		assertTrue(customerRestaurant.processLog(INVALID_FILE));

	}

	@Test
	public void testGetTotalDeliveryDistanceByReturnTotalDistance() {
		assertEquals(15.0, customerRestaurant.getTotalDeliveryDistance(), 0.0);

	}

	@Test
	public void testGetCustomerByIndexByReturnCustomerClass() throws CustomerException {
		assertNotNull(customerRestaurant.getCustomerByIndex(1));

	}

	@Test
	public void testGetNumberOfCustomerOrdersByReturnOrdersSize() {
		assertEquals(3, customerRestaurant.getNumCustomerOrders());

	}

	@Test(expected = CustomerException.class)
	public void testForGetCustomerIndexWithNegativeValue() throws CustomerException {
		customerRestaurant.getCustomerByIndex(-2);

	}

	@Test(expected = CustomerException.class)
	public void testForGetCustomerIndexThatExceedTheSizeInLogFile() throws CustomerException {
		customerRestaurant.getCustomerByIndex(105);

	}

	@Test
	public void testForResetDetailsOfCustomer() {
		customerRestaurant.resetDetails();
		assertEquals(0, customerRestaurant.getNumCustomerOrders());

	}

}
