package asgn2Tests;

import java.nio.file.Paths;

import org.junit.Test;

import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Pizza objects in
 * the asgn2Restaurant.LogHander class.
 * 
 * @author Khar Jun Shum
 * 
 */
public class LogHandlerPizzaTests {
	final static String FILE_1 = Paths.get("logs/20170101.txt").toString();
	final static String FILE_2 = Paths.get("logs/20170102.txt").toString();
	final static String FILE_3 = Paths.get("logs/20170103.txt").toString();
	final static String FILE_4 = Paths.get("logs/unit-test-logs/pizza/wrong-file-format.png").toString();
	final static String FILE_5 = Paths.get("logs/unit-test-logs/pizza/wrong-quantity-format.txt").toString();
	final static String FILE_6 = Paths.get("logs/unit-test-logs/pizza/quantity-overflow-positive.txt").toString();
	final static String FILE_7 = Paths.get("logs/unit-test-logs/pizza/quantity-overflow-negative.txt").toString();
	final static String FILE_8 = Paths.get("logs/unit-test-logs/pizza/double-format-quantity.txt").toString();
	final static String FILE_9 = Paths.get("logs/unit-test-logs/pizza/exceed-hour-limit-order-time.txt").toString();
	final static String FILE_10 = Paths.get("logs/unit-test-logs/pizza/exceed-minute-limit-order-time.txt").toString();
	final static String FILE_11 = Paths.get("logs/unit-test-logs/pizza/invalid-format-order-time.txt").toString();
	final static String FILE_12 = Paths.get("logs/unit-test-logs/pizza/negative-order-time.txt").toString();
	final static String FILE_13 = Paths.get("logs/unit-test-logs/pizza/exceed-hour-limit-delivery-time.txt").toString();
	final static String FILE_14 = Paths.get("logs/unit-test-logs/pizza/exceed-minute-limit-delivery-time.txt")
			.toString();
	final static String FILE_15 = Paths.get("logs/unit-test-logs/pizza/invalid-format-delivery-time.txt").toString();
	final static String FILE_16 = Paths.get("logs/unit-test-logs/pizza/negative-delivery-time.txt").toString();

	@Test(expected = LogHandlerException.class)
	public void testNoFileGivenWillThrowException() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset("");
	}

	@Test(expected = LogHandlerException.class)
	public void testFileNotFoundWillThrowException() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset("unknown-file.txt");
	}

	@Test(expected = LogHandlerException.class)
	public void testWrongFileFormatWillThrowException() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset(FILE_4);
	}

	@Test(expected = LogHandlerException.class)
	public void testWrongQuantityFormatWillThrowException() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset(FILE_5);
	}

	@Test(expected = LogHandlerException.class)
	public void testQuantityLimitOverflowPositiveValueWillThrowException() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset(FILE_6);
	}

	@Test(expected = LogHandlerException.class)
	public void testQuantityLimitOverflowNegativeValueWillThrowException() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset(FILE_7);
	}

	@Test(expected = LogHandlerException.class)
	public void testDoubleFormatQuantityWillThrowException() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset(FILE_8);
	}

	@Test(expected = LogHandlerException.class)
	public void testExceedsHourLimitAtOrderTimeWillThrowException() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset(FILE_9);
	}

	@Test(expected = LogHandlerException.class)
	public void testExceedsMinuteLimitAtOrderTimeWillThrowException() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset(FILE_10);
	}

	@Test(expected = LogHandlerException.class)
	public void testInvalidFormatAtOrderTimeWillThrowException() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset(FILE_11);
	}

	@Test(expected = LogHandlerException.class)
	public void testNegativeValueForOrderTimeWillThrowException() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset(FILE_12);
	}

	@Test(expected = LogHandlerException.class)
	public void testExceedsHourLimitAtDeliveryTimeWillThrowException() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset(FILE_13);
	}

	@Test(expected = LogHandlerException.class)
	public void testExceedsMinuteLimitAtDeliveryTimeWillThrowException() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset(FILE_14);
	}

	@Test(expected = LogHandlerException.class)
	public void testInvalidFormatAtDeliveryTimeWillThrowException() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset(FILE_15);
	}

	@Test(expected = LogHandlerException.class)
	public void testNegativeValueForDeliveryTimeWillThrowException() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset(FILE_16);
	}

	@Test(expected = LogHandlerException.class)
	public void testWrongQuantityFormatWillThrowExceptionForCreatePizza() throws PizzaException, LogHandlerException {
		LogHandler.createPizza("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,a");
	}

	@Test(expected = LogHandlerException.class)
	public void testQuantityLimitOverflowPositiveValueWillThrowExceptionForCreatePizza()
			throws PizzaException, LogHandlerException {
		LogHandler.createPizza("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2147483648");
	}

	@Test(expected = LogHandlerException.class)
	public void testQuantityLimitOverflowNegativeValueWillThrowExceptionForCreatePizza()
			throws PizzaException, LogHandlerException {
		LogHandler.createPizza("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,-2147483649");
	}

	@Test(expected = LogHandlerException.class)
	public void testDoubleFormatQuantityWillThrowExceptionForCreatePizza() throws PizzaException, LogHandlerException {
		LogHandler.createPizza("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2.0");
	}

	@Test(expected = LogHandlerException.class)
	public void testExceedsHourLimitAtOrderTimeWillThrowExceptionForCreatePizza()
			throws PizzaException, LogHandlerException {
		LogHandler.createPizza("25:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
	}

	@Test(expected = LogHandlerException.class)
	public void testExceedsMinuteLimitAtOrderTimeWillThrowExceptionForCreatePizza()
			throws PizzaException, LogHandlerException {
		LogHandler.createPizza("19:70:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
	}

	@Test(expected = LogHandlerException.class)
	public void testInvalidFormatAtOrderTimeWillThrowExceptionForCreatePizza()
			throws PizzaException, LogHandlerException {
		LogHandler.createPizza("ikuzo,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
	}

	@Test(expected = LogHandlerException.class)
	public void testNegativeValueForOrderTimeWillThrowExceptionForCreatePizza()
			throws PizzaException, LogHandlerException {
		LogHandler.createPizza("-19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
	}

	@Test(expected = LogHandlerException.class)
	public void testExceedsHourLimitAtDeliveryTimeWillThrowExceptionForCreatePizza()
			throws PizzaException, LogHandlerException {
		LogHandler.createPizza("19:00:00,25:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
	}

	@Test(expected = LogHandlerException.class)
	public void testExceedsMinuteLimitAtDeliveryTimeWillThrowExceptionForCreatePizza()
			throws PizzaException, LogHandlerException {
		LogHandler.createPizza("19:00:00,19:80:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
	}

	@Test(expected = LogHandlerException.class)
	public void testInvalidFormatAtDeliveryTimeWillThrowExceptionForCreatePizza()
			throws PizzaException, LogHandlerException {
		LogHandler.createPizza("19:00:00,ikuzo,Casey Jones,0123456789,DVC,5,5,PZV,2");
	}

	@Test(expected = LogHandlerException.class)
	public void testNegativeValueForDeliveryTimeWillThrowExceptionForCreatePizza()
			throws PizzaException, LogHandlerException {
		LogHandler.createPizza("19:00:00,-19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
	}
}
