package asgn2Customers;

import asgn2Exceptions.CustomerException;

/**
 * A class that represents a customer that has chosen to have their pizza
 * delivered by a driver. This class extends the abstract Customer class and
 * calculates the delivery distance as the Manhattan Distance between the
 * customer and the restaurant. A description of the class's fields and their
 * constraints is provided in Section 5.2 of the Assignment Specification.
 * 
 * @author Khar Jun Shum
 *
 */
public class DriverDeliveryCustomer extends Customer {

	String name;
	String mobileNumber;
	int locationX;
	int locationY;

	/**
	 * This class represents a customer of the Pizza Palace restaurant that has
	 * chosen to have their pizza delivered by a driver. A CustomerException is
	 * thrown if the any of the constraints listed in Section 5.2 of the
	 * Assignment Specification are violated.
	 *
	 * <P>
	 * PRE: TRUE
	 * <P>
	 * POST: All field values are set
	 * 
	 * @param name
	 *            - The Customer's name
	 * @param mobileNumber
	 *            - The customer mobile number
	 * @param locationX
	 *            - The customer x location relative to the Pizza Palace
	 *            Restaurant measured in units of 'blocks'
	 * @param locationY
	 *            - The customer y location relative to the Pizza Palace
	 *            Restaurant measured in units of 'blocks'
	 * @throws CustomerException
	 *             if supplied parameters are invalid Eg: Empty name,
	 *             mobileNumber is not starting with 0, locationX and locationY
	 *             is greater than 10
	 * 
	 */
	public DriverDeliveryCustomer(String name, String mobileNumber, int locationX, int locationY)
			throws CustomerException {
		super(name, mobileNumber, locationX, locationY, "Driver Delivery");
	}

	/**
	 * Returns the Manhattan Distance between the instance of
	 * DriverDeliveryCustomer and the restaurant. Overrides
	 * getDeliveryDistance() in Customer.
	 * 
	 * @return The distance between the restaurant and the customer in Manhattan
	 *         distance.
	 */
	@Override
	public double getDeliveryDistance() {
		double distance = Math.abs(getLocationX() - 0) + Math.abs(getLocationY() - 0);
		return distance;
	}

}
