package asgn2GUIs;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;

/**
 * This class is the graphical user interface for the rest of the system.
 * Currently it is a 'dummy' class which extends JFrame and implements Runnable
 * and ActionLister. It should contain an instance of an
 * asgn2Restaurant.PizzaRestaurant object which you can use to interact with the
 * rest of the system. You may choose to implement this class as you like,
 * including changing its class signature as long as it maintains its core
 * responsibility of acting as a GUI for the rest of the system. You can also
 * use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Person A and Person B
 *
 */
public class PizzaGUI extends JFrame implements Runnable, ActionListener {

	private static final long serialVersionUID = 1L;

	private PizzaRestaurant restaurant;

	/**
	 * Main UI Elements
	 */
	private JPanel mainPanel, tabPanel, tab2Panel;
	private JButton chooseFileBtn, resetBtn, calDistanceBtn, calProfitBtn, displayTablesBtn;
	private JTextField distanceField, profitField;
	private JTabbedPane tabPane;

	private JFileChooser fileChooser;

	String[] customerColumnHeaders = new String[] { "Customer Name", "Mobile Number", "Customer Type", "Location-X",
			"Location-Y", "Delivery Distance" };
	String[] orderColumnHeaders = new String[] { "Pizza Type", "Quantity", "Order Price", "Order Cost",
			"Order Profit" };

	private DefaultTableModel orderModel;
	private JTable orderTable;
	private DefaultTableModel customerModel;
	private JTable customerTable;
	private JScrollPane customerScrollPane, orderScrollPane;
	private File file = null;

	/**
	 * Creates a new Pizza GUI with the specified title
	 * 
	 * @param title
	 *            - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		super(title);
	}

	private void createGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);

		setSize(1100, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(150, 10);
		setLayout(null);

		mainPanel = createPanel(this.getBackground());
		mainPanel.setLocation(5, 0);
		this.getContentPane().add(mainPanel);

		chooseFileBtn = createButton("Choose File");
		chooseFileBtn.setLocation(800, 455);
		this.getContentPane().add(chooseFileBtn);

		calDistanceBtn = createButton("Calculate Total Distance");
		calDistanceBtn.setLocation(80, 500);
		this.getContentPane().add(calDistanceBtn);

		calProfitBtn = createButton("Calculate Total Profit");
		calProfitBtn.setLocation(430, 500);
		this.getContentPane().add(calProfitBtn);

		resetBtn = createButton("Reset");
		resetBtn.setLocation(800, 595);
		resetBtn.setEnabled(false);
		this.getContentPane().add(resetBtn);

		displayTablesBtn = createButton("Display Tables");
		displayTablesBtn.setLocation(800, 525);
		displayTablesBtn.setEnabled(false);
		this.getContentPane().add(displayTablesBtn);

		distanceField = createTextField("Total Distance Travelled");
		distanceField.setLocation(80, 580);
		distanceField.setEditable(false);
		this.getContentPane().add(distanceField);

		profitField = createTextField("Total Profit Made");
		profitField.setLocation(430, 580);
		profitField.setEditable(false);
		this.getContentPane().add(profitField);

		tabPane = new JTabbedPane();
		tabPane.setPreferredSize(mainPanel.getSize());
		tabPanel = createPanelForTabPane(Color.WHITE);
		tabPane.addTab("Order Details", tabPanel);
		tab2Panel = createPanelForTabPane(Color.WHITE);
		tabPane.addTab("Customer Details", tab2Panel);
		tabPane.setEnabled(false);
		mainPanel.add(tabPane);

		customerScrollPane = new JScrollPane(customerTable);
		tabPanel.add(customerScrollPane);

		orderScrollPane = new JScrollPane(orderTable);
		tab2Panel.add(orderScrollPane);

		chooseFileBtn.addActionListener(this);
		displayTablesBtn.addActionListener(this);
		calDistanceBtn.addActionListener(this);
		calProfitBtn.addActionListener(this);
		resetBtn.addActionListener(this);
		this.setVisible(true);
	}

	private JPanel createPanel(Color c) {
		JPanel temp = new JPanel();
		temp.setSize(1070, 450);
		temp.setBackground(c);
		return temp;
	}

	private JPanel createPanelForTabPane(Color c) {
		JPanel temp = new JPanel();
		temp.setPreferredSize(new Dimension(1050, 480));
		temp.setBackground(c);
		return temp;
	}

	private JButton createButton(String btnText) {
		JButton temp = new JButton(btnText);
		temp.setSize(220, 60);
		return temp;
	}

	private JTextField createTextField(String fieldText) {
		JTextField temp = new JTextField(fieldText);
		temp.setHorizontalAlignment(JTextField.CENTER);
		temp.setFont(temp.getFont().deriveFont(15f));
		temp.setSize(220, 60);
		return temp;
	}

	@Override
	public void run() {
		createGUI();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object src = event.getSource();

		if (src == chooseFileBtn) {
			fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

			FileNameExtensionFilter fileFilter = new FileNameExtensionFilter(".txt File", "txt");
			fileChooser.setFileFilter(fileFilter);

			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();

				try {
					file = new File(file.getPath());
					restaurant = new PizzaRestaurant();
					if (restaurant.processLog(file.getPath())) {
						JOptionPane.showMessageDialog(this, "Log file loaded successfully");
						chooseFileBtn.setText("Current File - " + file.getName());
						resetBtn.setEnabled(true);
						displayTablesBtn.setEnabled(true);
						chooseFileBtn.setEnabled(false);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (src == displayTablesBtn) {
			if (file != null) {
				tabPane.setEnabled(true);
				String[][] customerList = new String[restaurant.getNumCustomerOrders()][6];
				for (int i = 0; i < restaurant.getNumCustomerOrders(); i++) {
					try {
						customerList[i][0] = restaurant.getCustomerByIndex(i).getName();
						customerList[i][1] = restaurant.getCustomerByIndex(i).getMobileNumber();
						customerList[i][2] = restaurant.getCustomerByIndex(i).getCustomerType();
						customerList[i][3] = Integer.toString(restaurant.getCustomerByIndex(i).getLocationX());
						customerList[i][4] = Integer.toString(restaurant.getCustomerByIndex(i).getLocationY());
						customerList[i][5] = String.format("%.2f",
								restaurant.getCustomerByIndex(i).getDeliveryDistance());
					} catch (CustomerException e) {
						JOptionPane.showMessageDialog(this, e.getMessage(), "Pizza Place", JOptionPane.ERROR_MESSAGE);
					}
				}

				customerModel = new DefaultTableModel(customerList, customerColumnHeaders) {
					private static final long serialVersionUID = 1L;

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				customerTable = new JTable(customerModel);
				customerScrollPane.setViewportView(customerTable);
				customerTable.setPreferredScrollableViewportSize(tabPanel.getPreferredSize());

				String[][] orderList = new String[restaurant.getNumPizzaOrders()][5];
				for (int i = 0; i < restaurant.getNumCustomerOrders(); i++) {
					try {
						orderList[i][0] = restaurant.getPizzaByIndex(i).getPizzaType();
						orderList[i][1] = Integer.toString(restaurant.getPizzaByIndex(i).getQuantity());
						orderList[i][2] = String.format("%.2f", restaurant.getPizzaByIndex(i).getOrderPrice());
						orderList[i][3] = String.format("%.2f", restaurant.getPizzaByIndex(i).getOrderCost());
						orderList[i][4] = String.format("%.2f", restaurant.getPizzaByIndex(i).getOrderProfit());
					} catch (PizzaException e) {
						JOptionPane.showMessageDialog(this, e.getMessage(), "Pizza Place", JOptionPane.ERROR_MESSAGE);
					}
				}

				orderModel = new DefaultTableModel(orderList, orderColumnHeaders) {
					private static final long serialVersionUID = 1L;

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				orderTable = new JTable(orderModel);
				orderScrollPane.setViewportView(orderTable);
				orderTable.setPreferredScrollableViewportSize(tab2Panel.getPreferredSize());
			} else {
				JOptionPane.showMessageDialog(this, "No File Selected", "Pizza Place", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (src == resetBtn) {
			restaurant.resetDetails();
			file = null;
			customerScrollPane.setViewportView(null);
			orderScrollPane.setViewportView(null);
			chooseFileBtn.setText("Choose File");
			chooseFileBtn.setEnabled(true);
			displayTablesBtn.setEnabled(false);
			tabPane.setEnabled(false);
			distanceField.setText("Total Distance Travelled");
			profitField.setText("Total Profit Made");
			resetBtn.setEnabled(false);
		}
		if (src == calDistanceBtn) {
			if (file != null) {
				distanceField.setText(
						"Total Delivery Distance: " + String.format("%.2f", restaurant.getTotalDeliveryDistance()));
			} else {
				JOptionPane.showMessageDialog(this, "No File Selected", "Pizza Place", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (src == calProfitBtn) {
			if (file != null) {
				profitField.setText("Total Profit Made: $" + String.format("%.2f", restaurant.getTotalProfit()));
			} else {
				JOptionPane.showMessageDialog(this, "No File Selected", "Pizza Place", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
