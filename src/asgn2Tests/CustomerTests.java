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
	Customer DVC; 
	Customer DNC; 
	Customer PUC; 
	
	@Before 
	public void Initialize() throws CustomerException {
		DVC = new DriverDeliveryCustomer ("Sean", "0402024300", 4, 3);
		DNC = new DroneDeliveryCustomer ("Gary", "0472774229", 4, 3);
		PUC = new PickUpCustomer ("Kelok", "0423241145", 0, 0);
		
	}
	
	@Test (expected = CustomerException.class)
	public void testConstructorNameMoreThan20Digits() throws CustomerException {
		DVC = new DriverDeliveryCustomer ("Uvuvwevwevwe Onyetenyevwe Ossas", "0214252252", 4, 3); 
		
	}
	
	@Test (expected = CustomerException.class)
	public void testConstructorNameForBlankSpace() throws CustomerException {
		DVC = new DriverDeliveryCustomer (" ", "0898989898", 4, 3);
		
	}
	
	@Test (expected = CustomerException.class)
	public void testConstructorNameForEmptyString() throws CustomerException {
		DVC = new DriverDeliveryCustomer ("", "0898989898", 4, 3);
		
	}
	
	@Test (expected = CustomerException.class)
	public void testConstructorMobileNumberStartWithDigit1() throws CustomerException {
		DVC = new DriverDeliveryCustomer ("Sean", "1234567890", 4, 3);
		
	}
		
	@Test (expected = CustomerException.class)
	public void testConstructorMobileNumberLessThan10Digits() throws CustomerException {
		DVC = new DriverDeliveryCustomer ("Sean", "023456789", 4, 3);
			
	}
	
	@Test (expected = CustomerException.class)
	public void testConstructorMobileNumberMoreThan10Digits() throws CustomerException {
		DVC = new DriverDeliveryCustomer ("Sean", "02345678910", 4, 3);
			
	}
	
	@Test (expected = CustomerException.class)
	public void testConstructorMobileNumberWithSymbol() throws CustomerException {
		DVC = new DriverDeliveryCustomer ("Sean", "0563832@4^", 4, 3);
			
	}
	
	
	@Test (expected = CustomerException.class) 
	public void testConstructorForLocationXMoreThan10() throws CustomerException {
		DVC = new DriverDeliveryCustomer ("Sean", "0898989898", 11, 3);
		
	}
	
	@Test (expected = CustomerException.class) 
	public void testConstructorForLocationYMoreThan10() throws CustomerException {
		DVC = new DriverDeliveryCustomer ("Sean", "0898989898", 4, 11);
		
	}
	
	@Test 
	public void testLocationXForPickUpCustomerShouldBeZero() throws CustomerException {
		PUC = new PickUpCustomer("Kelok", "0423241145", 2, 0); 
		assertEquals(0, PUC.getLocationX());
		
	}
	
	@Test 
	public void testLocationYForPickUpCustomerShouldBeZero() throws CustomerException {
		PUC = new PickUpCustomer("Kelok", "0423241145", 0, 2); 
		assertEquals(0, PUC.getLocationY());
		
	}
	
	@Test 
	public void testGetMobileNumber() throws CustomerException {
		assertEquals("0402024300", DVC.getMobileNumber()); 
		
	}
	
	@Test 
	public void testGetCustomerType() throws CustomerException {
		assertEquals("Pick Up", PUC.getCustomerType()); 
		assertEquals("Driver Delivery", DVC.getCustomerType()); 
		assertEquals("Drone Delivery", DNC.getCustomerType()); 
		
	}
	
	@Test 
	public void testGetLocationX() throws CustomerException {
		assertEquals(4, DVC.getLocationX()); 
		
	}
	
	@Test 
	public void testGetLocationY() throws CustomerException {
		assertEquals(3, DVC.getLocationY()); 
		
	}
		
	@Test 
	public void testGetCustomerNameForDifferentTypeOfCustomer() throws CustomerException {
		assertEquals("Sean", DVC.getName()); 
		assertEquals("Gary", DNC.getName()); 
		assertEquals("Kelok", PUC.getName()); 
		
	}

	@Test 
	public void testGetDeliveryDistanceForDroneDeliveryCustomer() throws CustomerException {
		assertEquals(5.0, DNC.getDeliveryDistance(), 0.0); 
		
	}
	
	@Test 
	public void testGetDeliveryDistanceForDriverDeliveryCustomer() throws CustomerException {
		assertEquals(7.0, DVC.getDeliveryDistance(), 0.0); 
		
	}
	
	@Test
	public void testGetDeliveryDistanceForPickUpCustomer() throws CustomerException {
		assertEquals(0, PUC.getDeliveryDistance(), 0);
		
	}

	
}

