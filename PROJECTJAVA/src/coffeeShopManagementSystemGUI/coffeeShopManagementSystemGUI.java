package coffeeShopManagementSystemGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class coffeeShopManagementSystemGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputNameEmployee;
	private JTextField inputAge;
	private JTextField inputJob;
	private JTextField inputIDEmployee;
	private JTextField inputIDFood;
	private JTextField inputFood;
	private JTable tableEmployee;
	private JTextField inputDrink;
	private JTextField inputIDDrink;
	private JTable tableFood;
	private JTable tableDrink;
	private JTextField inputNameCustomer;
	private JTextField inputPhone;
	private JTable tableCustomer;
	private JTextField inputIDOrderOM;
	private JTextField inputItem;
	private JTextField inputAmount;
	private JTable tableOrder;
	private JTextField inputPriceFood;
	private JTextField inputDrinkPrice;
	private JTextField inputIDCustomer;

	//Launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					coffeeShopManagementSystemGUI frame = new coffeeShopManagementSystemGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the frame.
	public coffeeShopManagementSystemGUI() {
		//Configure database connection
		String host = "jdbc:mysql://localhost:3306/sys";
		String hostID = "root";
		String hostPassword = "112233";
		
		setResizable(false);
		setTitle("Coffee Shop Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 61, 710, 289);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelEmployeeManagement = new JPanel();
		layeredPane.add(panelEmployeeManagement, "name_97029229759000");
		panelEmployeeManagement.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE MANAGEMENT");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(269, 5, 167, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelEmployeeManagement.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 56, 50, 14);
		panelEmployeeManagement.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 80, 50, 14);
		panelEmployeeManagement.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Position");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 105, 50, 14);
		panelEmployeeManagement.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 32, 50, 14);
		panelEmployeeManagement.add(lblNewLabel_4);
		
		inputNameEmployee = new JTextField();
		inputNameEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		inputNameEmployee.setBounds(66, 54, 150, 20);
		panelEmployeeManagement.add(inputNameEmployee);
		inputNameEmployee.setColumns(10);
		
		inputAge = new JTextField();
		inputAge.setBounds(66, 79, 150, 20);
		panelEmployeeManagement.add(inputAge);
		inputAge.setColumns(10);
		
		inputJob = new JTextField();
		inputJob.setBounds(66, 104, 150, 20);
		panelEmployeeManagement.add(inputJob);
		inputJob.setColumns(10);
		
		inputIDEmployee = new JTextField();
		inputIDEmployee.setBounds(66, 29, 150, 20);
		panelEmployeeManagement.add(inputIDEmployee);
		inputIDEmployee.setColumns(10);
		
		tableEmployee = new JTable();
		tableEmployee.setSelectionBackground(new Color(255, 255, 255));
		tableEmployee.setBackground(new Color(255, 255, 255));
		//My code starts
		String[] columnEmployee = new String[] {"ID", "Name", "Age", "Position"};
		DefaultTableModel tableModelEmployee = new DefaultTableModel();
		tableModelEmployee.setColumnIdentifiers(columnEmployee);
		tableEmployee.setModel(tableModelEmployee);
		//My code ends
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.resetTable(tableModelEmployee);
				GUIMethod.addEmployee(inputIDEmployee.getText(), inputNameEmployee.getText(), inputAge.getText(), inputJob.getText(), host ,hostID, hostPassword);
				GUIMethod.showEmployee(tableModelEmployee, host, hostID, hostPassword);
				inputIDEmployee.setText("");
				inputNameEmployee.setText("");
				inputAge.setText("");
				inputJob.setText("");
			}

			
		});
		btnAddEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddEmployee.setBounds(66, 134, 150, 23);
		panelEmployeeManagement.add(btnAddEmployee);
		
		JButton btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.deleteRecord(inputIDEmployee.getText(), "employee", host ,hostID, hostPassword);
				GUIMethod.resetTable(tableModelEmployee);
				GUIMethod.showEmployee(tableModelEmployee, host, hostID, hostPassword);
			}
		}
		);
		btnDeleteEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDeleteEmployee.setBounds(66, 168, 150, 23);
		panelEmployeeManagement.add(btnDeleteEmployee);
		
		JButton btnShowEmployeeInfo = new JButton("Show Employee Info");
		btnShowEmployeeInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnShowEmployeeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.resetTable(tableModelEmployee);
				GUIMethod.showEmployee(tableModelEmployee, host, hostID, hostPassword);
			}
		});
		btnShowEmployeeInfo.setBounds(226, 168, 474, 23);
		panelEmployeeManagement.add(btnShowEmployeeInfo);
		
		
		
		JScrollPane scrollPaneE = new JScrollPane(tableEmployee);
		scrollPaneE.setBackground(new Color(255, 255, 255));
		scrollPaneE.setBounds(226, 28, 474, 129);
		panelEmployeeManagement.add(scrollPaneE);
		
		JPanel panelOrderManagement = new JPanel();
		layeredPane.add(panelOrderManagement, "name_97047366296200");
		panelOrderManagement.setLayout(null);
		
		JLabel lblOrderManagement = new JLabel("ORDER MANAGEMENT");
		lblOrderManagement.setVerticalAlignment(SwingConstants.TOP);
		lblOrderManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderManagement.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrderManagement.setBounds(274, 5, 162, 17);
		panelOrderManagement.add(lblOrderManagement);
		
		JLabel lblNewLabel_1_4 = new JLabel("ID");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(10, 30, 50, 14);
		panelOrderManagement.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Item");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4_1.setBounds(10, 55, 50, 14);
		panelOrderManagement.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Amount");
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4_1_1.setBounds(10, 80, 50, 14);
		panelOrderManagement.add(lblNewLabel_1_4_1_1);
		
		inputIDOrderOM = new JTextField();
		inputIDOrderOM.setColumns(10);
		inputIDOrderOM.setBounds(66, 28, 150, 20);
		panelOrderManagement.add(inputIDOrderOM);
		
		inputItem = new JTextField();
		inputItem.setColumns(10);
		inputItem.setBounds(66, 53, 150, 20);
		panelOrderManagement.add(inputItem);
		
		inputAmount = new JTextField();
		inputAmount.setColumns(10);
		inputAmount.setBounds(66, 78, 150, 20);
		panelOrderManagement.add(inputAmount);

		tableOrder = new JTable();
		//My code starts
		String[] columnOrder = new String[] {"ID", "Item", "Amount"};
		DefaultTableModel tableModelOrder = new DefaultTableModel();
		tableModelOrder.setColumnIdentifiers(columnOrder);
		tableOrder.setModel(tableModelOrder);
		//My code ends
		
		JButton btnAddOrder = new JButton("Add Order");
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.resetTable(tableModelOrder);
				GUIMethod.addOrder(inputIDOrderOM.getText(), inputItem.getText(), Double.parseDouble(inputAmount.getText()), host, hostID, hostPassword);
				GUIMethod.showOrder(tableModelOrder, "ordermn", host, hostID, hostPassword);
				inputIDOrderOM.setText("");
				inputItem.setText("");
				inputAmount.setText("");
			}
		});
		btnAddOrder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddOrder.setBounds(66, 109, 150, 23);
		panelOrderManagement.add(btnAddOrder);
		
		JButton btnDeleteOrder = new JButton("Delete Order");
		btnDeleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.resetTable(tableModelOrder);
				GUIMethod.deleteRecord(inputIDOrderOM.getText(), "ordermn", host, hostID, hostPassword);
				GUIMethod.showOrder(tableModelOrder, "ordermn", host, hostID, hostPassword);
			}
		});
		btnDeleteOrder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDeleteOrder.setBounds(66, 143, 150, 23);
		panelOrderManagement.add(btnDeleteOrder);
		
		JScrollPane scrollPaneO = new JScrollPane(tableOrder);
		scrollPaneO.setBackground(new Color(255, 255, 255));
		scrollPaneO.setBounds(226, 28, 474, 104);
		panelOrderManagement.add(scrollPaneO);
		
		JButton btnShowOrderInfo = new JButton("Show Order Info");
		btnShowOrderInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.resetTable(tableModelOrder); 
				GUIMethod.showOrder(tableModelOrder, "ordermn", host, hostID, hostPassword);
			}
		});
		btnShowOrderInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnShowOrderInfo.setBounds(226, 143, 474, 23);
		panelOrderManagement.add(btnShowOrderInfo);
		
		JPanel panelCustomerManagement = new JPanel();
		layeredPane.add(panelCustomerManagement, "name_97049769130400");
		panelCustomerManagement.setLayout(null);
		
		JLabel lblNewLabel_5_1 = new JLabel("CUSTOMER MANAGEMENT");
		lblNewLabel_5_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_5_1.setBounds(264, 5, 172, 17);
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCustomerManagement.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Phone");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(10, 90, 50, 14);
		panelCustomerManagement.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Name");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3_1_1.setBounds(10, 60, 50, 14);
		panelCustomerManagement.add(lblNewLabel_1_3_1_1);
		
		inputNameCustomer = new JTextField();
		inputNameCustomer.setColumns(10);
		inputNameCustomer.setBounds(66, 60, 150, 20);
		panelCustomerManagement.add(inputNameCustomer);
		
		inputPhone = new JTextField();
		inputPhone.setColumns(10);
		inputPhone.setBounds(66, 90, 150, 20);
		panelCustomerManagement.add(inputPhone);
		
		tableCustomer = new JTable();
		//My code starts
		String[] columnCustomer = new String[] {"ID","Name", "Phone", "Total"};
		DefaultTableModel tableModelCustomer = new DefaultTableModel();
		tableModelCustomer.setColumnIdentifiers(columnCustomer);
		tableCustomer.setModel(tableModelCustomer);
		//My code ends
		
		JScrollPane scrollPaneC = new JScrollPane(tableCustomer);
		scrollPaneC.setBackground(Color.RED);
		scrollPaneC.setBounds(226, 28, 474, 142);
		panelCustomerManagement.add(scrollPaneC);
		
		
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.resetTable(tableModelCustomer);
				GUIMethod.addCustomer(inputIDCustomer.getText(), inputNameCustomer.getText(), inputPhone.getText(), 0, host, hostID, hostPassword);
				GUIMethod.showCustomer(tableModelCustomer, "customer", host, hostID, hostPassword);
			}
		});
		btnAddCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddCustomer.setBounds(10, 120, 206, 23);
		panelCustomerManagement.add(btnAddCustomer);
		
		JButton btnDeleteCustomer = new JButton("Delete Customer");
		btnDeleteCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.resetTable(tableModelCustomer);
				GUIMethod.deleteRecord(inputIDCustomer.getText(), "customer", host, hostID, hostPassword);
				GUIMethod.showCustomer(tableModelCustomer, "customer", host, hostID, hostPassword);
			}
		});
		btnDeleteCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDeleteCustomer.setBounds(10, 150, 206, 23);
		panelCustomerManagement.add(btnDeleteCustomer);
		
		JButton btnShowCustomerInfo = new JButton("Show Customer Info");
		btnShowCustomerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.resetTable(tableModelCustomer);
				GUIMethod.showCustomer(tableModelCustomer, "customer", host, hostID, hostPassword);
			}
		});
		btnShowCustomerInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnShowCustomerInfo.setBounds(226, 180, 474, 23);
		panelCustomerManagement.add(btnShowCustomerInfo);
		
		JLabel lblNewLabel_1_3_1_1_1 = new JLabel("ID");
		lblNewLabel_1_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3_1_1_1.setBounds(10, 30, 50, 14);
		panelCustomerManagement.add(lblNewLabel_1_3_1_1_1);
		
		inputIDCustomer = new JTextField();
		inputIDCustomer.setColumns(10);
		inputIDCustomer.setBounds(66, 30, 150, 20);
		panelCustomerManagement.add(inputIDCustomer);
		
		JPanel panelMenuManagement = new JPanel();
		layeredPane.add(panelMenuManagement, "name_105359883788500");
		panelMenuManagement.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("MENU MANAGEMENT");
		lblNewLabel_5.setBounds(274, 5, 162, 17);
		lblNewLabel_5.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelMenuManagement.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 30, 46, 14);
		panelMenuManagement.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Food");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(10, 60, 46, 14);
		panelMenuManagement.add(lblNewLabel_2_1);
		
		inputIDFood = new JTextField();
		inputIDFood.setColumns(10);
		inputIDFood.setBounds(66, 30, 150, 20);
		panelMenuManagement.add(inputIDFood);
		
		inputFood = new JTextField();
		inputFood.setColumns(10);
		inputFood.setBounds(66, 60, 150, 20);
		panelMenuManagement.add(inputFood);
		
		tableFood = new JTable();
		//My code starts
		String[] columnFood = new String[] {"ID", "Name", "Price"};
		DefaultTableModel tableModelFood = new DefaultTableModel();
		tableModelFood.setColumnIdentifiers(columnFood);
		tableFood.setModel(tableModelFood);
		//My code ends
		
		JButton btnAddFood = new JButton("Add");
		btnAddFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.resetTable(tableModelFood);
				GUIMethod.addMenu("food", inputIDFood.getText(), inputFood.getText(), Double.parseDouble(inputPriceFood.getText()), host, hostID, hostPassword);
				GUIMethod.showMenu(tableModelFood, "food", host, hostID, hostPassword);
			}
		});
		btnAddFood.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddFood.setBounds(66, 120, 75, 23);
		panelMenuManagement.add(btnAddFood);
		
		JButton btnShowFood = new JButton("Show Food");
		btnShowFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.resetTable( tableModelFood); 
				GUIMethod.showMenu(tableModelFood, "food" , host, hostID, hostPassword);
			}
		});
		btnShowFood.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnShowFood.setBounds(226, 260, 235, 23);
		panelMenuManagement.add(btnShowFood);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(10, 170, 46, 14);
		panelMenuManagement.add(lblNewLabel_1_1_1);

		tableDrink = new JTable();
		//My code starts
		String[] columnDrink = new String[] {"ID", "Name", "Price"};
		DefaultTableModel tableModelDrink = new DefaultTableModel();
		tableModelDrink.setColumnIdentifiers(columnDrink);
		tableDrink.setModel(tableModelDrink);
		//My code ends
		
		JButton btnAddDrink = new JButton("Add");
		btnAddDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.resetTable(tableModelDrink); 
				GUIMethod.addMenu("drink", inputIDDrink.getText(), inputDrink.getText(), Double.parseDouble(inputDrinkPrice.getText()), host, hostID, hostPassword);
				GUIMethod.showMenu(tableModelDrink, "drink", host, hostID, hostPassword);
			}
		});
		btnAddDrink.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddDrink.setBounds(66, 260, 75, 23);
		panelMenuManagement.add(btnAddDrink);
		
		inputDrink = new JTextField();
		inputDrink.setColumns(10);
		inputDrink.setBounds(66, 200, 150, 20);
		panelMenuManagement.add(inputDrink);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Drink");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1.setBounds(10, 200, 46, 14);
		panelMenuManagement.add(lblNewLabel_2_1_1);
		
		inputIDDrink = new JTextField();
		inputIDDrink.setColumns(10);
		inputIDDrink.setBounds(66, 170, 150, 20);
		panelMenuManagement.add(inputIDDrink);
		
		JScrollPane scrollPaneF = new JScrollPane(tableFood);
		scrollPaneF.setBounds(226, 30, 235, 220);
		panelMenuManagement.add(scrollPaneF);
		
		JScrollPane scrollPaneD = new JScrollPane(tableDrink);
		scrollPaneD.setBounds(465, 30, 235, 220);
		panelMenuManagement.add(scrollPaneD);
		
		JButton btnDeleteFood = new JButton("Delete");
		btnDeleteFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.resetTable(tableModelFood);
				GUIMethod.deleteRecord(inputIDFood.getText(), "food", host, hostID, hostPassword);
				GUIMethod.showMenu(tableModelFood, "food", host, hostID, hostPassword);
			}
		});
		btnDeleteFood.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDeleteFood.setBounds(141, 120, 75, 23);
		panelMenuManagement.add(btnDeleteFood);
		
		JButton btnDeleteDrink = new JButton("Delete");
		btnDeleteDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.resetTable(tableModelDrink);
				GUIMethod.deleteRecord(inputIDDrink.getText(), "drink", host, hostID, hostPassword);
				GUIMethod.showMenu(tableModelDrink, "drink", host, hostID, hostPassword);
			}
		});
		btnDeleteDrink.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDeleteDrink.setBounds(141, 260, 75, 23);
		panelMenuManagement.add(btnDeleteDrink);
		
		JButton btnShowDrink = new JButton("Show Drink");
		btnShowDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.resetTable(tableModelDrink); 
				GUIMethod.showMenu(tableModelDrink, "drink", host, hostID, hostPassword);
			}
		});
		btnShowDrink.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnShowDrink.setBounds(465, 260, 235, 23);
		panelMenuManagement.add(btnShowDrink);
		
		inputPriceFood = new JTextField();
		inputPriceFood.setColumns(10);
		inputPriceFood.setBounds(66, 90, 150, 20);
		panelMenuManagement.add(inputPriceFood);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Price");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_2.setBounds(10, 90, 46, 14);
		panelMenuManagement.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Price");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1.setBounds(10, 230, 46, 14);
		panelMenuManagement.add(lblNewLabel_2_1_1_1);
		
		inputDrinkPrice = new JTextField();
		inputDrinkPrice.setColumns(10);
		inputDrinkPrice.setBounds(66, 230, 150, 20);
		panelMenuManagement.add(inputDrinkPrice);
		
		JButton btnEmployeeManagement = new JButton("Employee Management");
		btnEmployeeManagement.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEmployeeManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.switchPanel(layeredPane, panelEmployeeManagement);
			}
		});
		btnEmployeeManagement.setBounds(10, 10, 170, 40);
		contentPane.add(btnEmployeeManagement);
		
		JButton btnMenuManagement = new JButton("Menu Management");
		btnMenuManagement.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMenuManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.switchPanel(layeredPane, panelMenuManagement);
			}
		});
		btnMenuManagement.setBounds(190, 10, 170, 40);
		contentPane.add(btnMenuManagement);
		
		JButton btnOrderManagement = new JButton("Order Management");
		btnOrderManagement.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOrderManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.switchPanel(layeredPane, panelOrderManagement);
			}
		});
		btnOrderManagement.setBounds(550, 10, 170, 40);
		contentPane.add(btnOrderManagement);
		
		JButton btnCustomerManagement = new JButton("Customer Management");
		btnCustomerManagement.setBounds(370, 10, 170, 40);
		contentPane.add(btnCustomerManagement);
		btnCustomerManagement.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCustomerManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMethod.switchPanel(layeredPane, panelCustomerManagement);
			}
		});
	}
}
