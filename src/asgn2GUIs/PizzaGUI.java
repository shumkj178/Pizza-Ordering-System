package asgn2GUIs;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
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
 * including changing its class signature � as long as it maintains its core
 * responsibility of acting as a GUI for the rest of the system. You can also
 * use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Person A and Person B
 *
 */
public class PizzaGUI extends JFrame implements Runnable, ActionListener {

	private static final long serialVersionUID = -7031008862559936404L;
	
	/**
	 * UI Elements
	 */
	private JPanel panel1;
	private JLabel label1;
	
	private PizzaRestaurant restaurant;

	/**
	 * Creates a new Pizza GUI with the specified title
	 * 
	 * @param title
	 *            - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		// TO DO
		super(title);
	}

	private void createGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);

		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300, 100);
		setLayout(null);
		panel1 = createPanel(Color.BLACK);
		panel1.setLocation(45, 40);
		
		label1 = new JLabel("Pizzzzaaa");
		label1.setForeground(Color.WHITE);
		
		panel1.add(label1);
		this.getContentPane().add(panel1);
		this.setVisible(true);
	}

	private JPanel createPanel(Color c) {
		JPanel temp = new JPanel();
		temp.setSize(200, 200);
		temp.setBackground(c);
		return temp;
		//Create a JPanel object and store it in a local var
		//set the background colour to that passed in c
		//Return the JPanel object
	}
	
	@Override
	public void run() {
		// TO DO
		createGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
