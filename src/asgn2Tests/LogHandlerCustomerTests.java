package asgn2Tests;

import java.nio.file.Paths;

import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Customer objects
 * in the asgn2Restaurant.LogHander class.
 *
 * @author Person A
 */
public class LogHandlerCustomerTests {
	// TO DO
	final static String FILE_1 = Paths.get("logs/20170102.txt").toString();
	final static String FILE_2 = Paths.get("logs/unit-test-logs/customer/wrong-file-type.pdf").toString();
	final static String FILE_3 = Paths.get("logs/unit-test-logs/customer/missing-data.txt").toString();
	final static String FILE_4 = Paths.get("logs/unit-test-logs/customer/invalid-locationX-format.txt").toString();
	final static String FILE_5 = Paths.get("logs/unit-test-logs/customer/invalid-locationY-format.txt").toString();
	final static String FILE_6 = Paths.get("logs/unit-test-logs/customer/locationX-overflow-negative.txt").toString();
	final static String FILE_7 = Paths.get("logs/unit-test-logs/customer/locationX-overflow-positive.txt").toString();
	final static String FILE_8 = Paths.get("logs/unit-test-logs/customer/locationY-overflow-negative.txt").toString();
	final static String FILE_9 = Paths.get("logs/unit-test-logs/customer/locationY-overflow-positive.txt").toString();

	@Test(expected = LogHandlerException.class)
	public void testForEmptyFileName() throws CustomerException, LogHandlerException {
		LogHandler.populateCustomerDataset("");

	}

	@Test(expected = LogHandlerException.class)
	public void testForFileNotFoundInLogs() throws CustomerException, LogHandlerException {
		LogHandler.populateCustomerDataset("FILE_0.txt");

	}

	@Test
	public void testForFileThatExistInLogsWithNoError() throws CustomerException, LogHandlerException {
		LogHandler.populateCustomerDataset(FILE_1);

	}

	@Test(expected = LogHandlerException.class)
	public void testForWrongFileType() throws CustomerException, LogHandlerException {
		LogHandler.populateCustomerDataset(FILE_2);

	}

	@Test(expected = LogHandlerException.class)
	public void testForMissingDataInFile() throws CustomerException, LogHandlerException {
		LogHandler.populateCustomerDataset(FILE_3);

	}

	@Test(expected = LogHandlerException.class)
	public void testForInvalidFormatOfLocationXInFile() throws CustomerException, LogHandlerException {
		LogHandler.populateCustomerDataset(FILE_4);

	}

	@Test(expected = LogHandlerException.class)
	public void testForInvalidFormatOfLocationYInFile() throws CustomerException, LogHandlerException {
		LogHandler.populateCustomerDataset(FILE_5);

	}

	@Test(expected = LogHandlerException.class)
	public void testForLocationXLimitInFileOverflowNegativeValue() throws CustomerException, LogHandlerException {
		LogHandler.populateCustomerDataset(FILE_6);

	}

	@Test(expected = LogHandlerException.class)
	public void testForLocationXLimitInFileOverflowPositiveValue() throws CustomerException, LogHandlerException {
		LogHandler.populateCustomerDataset(FILE_7);

	}

	@Test(expected = LogHandlerException.class)
	public void testForLocationYLimitInFileOverflowNegativeValue() throws CustomerException, LogHandlerException {
		LogHandler.populateCustomerDataset(FILE_8);

	}

	@Test(expected = LogHandlerException.class)
	public void testForLocationYLimitInFileOverflowPositiveValue() throws CustomerException, LogHandlerException {
		LogHandler.populateCustomerDataset(FILE_9);

	}

	@Test
	public void testForSuccessfullyCreateCustomer() throws CustomerException, LogHandlerException {
		LogHandler.createCustomer("20:00:00,20:30:00,Gary Voo,0434701493,PUC,6,3,PZM,3");

	}

	@Test(expected = LogHandlerException.class)
	public void testForMissingData() throws CustomerException, LogHandlerException {
		LogHandler.createCustomer("20:00:00,20:30:00,Gary Voo,PUC,6,3,PZM,3");

	}

	@Test(expected = LogHandlerException.class)
	public void testForInvalidFormatOfLocationX() throws CustomerException, LogHandlerException {
		LogHandler.createCustomer("20:00:00,20:30:00,Gary Voo,0434701493,PUC,X,3,PZM,3");

	}

	@Test(expected = LogHandlerException.class)
	public void testForInvalidFormatOfLocationY() throws CustomerException, LogHandlerException {
		LogHandler.createCustomer("20:00:00,20:30:00,Gary Voo,0434701493,PUC,6,Y,PZM,3");

	}

	@Test(expected = LogHandlerException.class)
	public void testForLocationXLimitOverflowNegativeValueForCreateCustomer()
			throws CustomerException, LogHandlerException {
		LogHandler.createCustomer("20:00:00,20:30:00,Gary Voo,0434701493,PUC,-2147483649,3,PZM,3");

	}

	@Test(expected = LogHandlerException.class)
	public void testForLocationXLimitOverflowPosotiveValueForCreateCustomer()
			throws CustomerException, LogHandlerException {
		LogHandler.createCustomer("20:00:00,20:30:00,Gary Voo,0434701493,PUC,2147483648,3,PZM,3");

	}

	@Test(expected = LogHandlerException.class)
	public void testForLocationYLimitOverflowNegativeValueForCreateCustomer()
			throws CustomerException, LogHandlerException {
		LogHandler.createCustomer("20:00:00,20:30:00,Gary Voo,0434701493,PUC,6,-2147483649,PZM,3");

	}

	@Test(expected = LogHandlerException.class)
	public void testForLocationYLimitOverflowPosotiveValueForCreateCustomer()
			throws CustomerException, LogHandlerException {
		LogHandler.createCustomer("20:00:00,20:30:00,Gary Voo,0434701493,PUC,6,2147483648,PZM,3");

	}

}
