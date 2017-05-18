package asgn2Tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Customers.Customer;
import asgn2Customers.PickUpCustomer; 
import asgn2Customers.DriverDeliveryCustomer; 
import asgn2Customers.DroneDeliveryCustomer; 




/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Person A
 * 
 *
 */
public class CustomerTests {
	// TO DO
	Customer DVC; 
	Customer DNC; 
	Customer PUC; 
	
	@Before 
	public void Initialize() throws CustomerException {
		DVC = new DriverDeliveryCustomer ("Sean", "0402024300", 5, 6);
		DNC = new DroneDeliveryCustomer ("Gary", "0472774229", 4, -4);
		PUC = new PickUpCustomer ("Kelok", "0423241145", 0, 0);
		
	}
	
	@Test (expected = CustomerException.class)
	public void testConstructorNameMoreThan20Digits() throws CustomerException {
		DVC = new DriverDeliveryCustomer ("Uvuvwevwevwe Onyetenyevwe Ossas", "0214252252", 5, 6); 
		
	}
	
	@Test (expected = CustomerException.class)
	public void testConstructorNameForBlankSpace() throws CustomerException {
		DVC = new DriverDeliveryCustomer (" ", "0898989898", 5, 6);
		
	}
	
	@Test (expected = CustomerException.class)
	public void testConstructorNameForEmptyString() throws CustomerException {
		DVC = new DriverDeliveryCustomer ("", "0898989898", 5, 6);
		
	}
	
	@Test (expected = CustomerException.class)
	public void testConstructorMobileNumberStartWithDigit1() throws CustomerException {
		DVC = new DriverDeliveryCustomer ("Sean", "1234567890", 5, 6);
		
	}
		
	@Test (expected = CustomerException.class)
	public void testConstructorMobileNumberLessThan10Digits() throws CustomerException {
		DVC = new DriverDeliveryCustomer ("Sean", "023456789", 5, 6);
			
	}
	
	@Test (expected = CustomerException.class)
	public void testConstructorMobileNumberMoreThan10Digits() throws CustomerException {
		DVC = new DriverDeliveryCustomer ("Sean", "02345678910", 5, 6);
			
	}
	
	
		
		
		
	
		
		

}

