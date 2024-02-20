package coffeeShopManagementSystemGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

class GUIMethod{
	//Switching between panels (Employee Management, Menu Management, Order Management, Customer Management)
	public static void switchPanel(JLayeredPane lpanel, JPanel panel) {
			lpanel.removeAll();
			lpanel.add(panel);
			lpanel.repaint();
			lpanel.revalidate();
			
		}
		
	//Reset table
	public static void resetTable(DefaultTableModel model) {
		model.setRowCount(0);
	}
	
	//Add employee
	public static void addEmployee(String id, String name, String age, String position, String host, String hostID, String hostPassword) {
		coffeeShopManagementSystemClass.EmployeeRecord er = new coffeeShopManagementSystemClass.EmployeeRecord(id, name, age, position);
		JOptionPane.showMessageDialog(null, er.popUp());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(host, hostID, hostPassword);
			PreparedStatement ps = con.prepareStatement("insert into employee(ID, Name, Age,Position) values(?,?,?,?)");
			ps.setString(1, er.id);
			ps.setString(2, er.name);
			ps.setString(3, er.age);
			ps.setString(4, er.position);
			ps.executeUpdate();
			ps.close();
			con.close();
		}catch(ClassNotFoundException | SQLException  e1){}
	}
	
	//Add menu
		public static void addMenu(String table,String id, String name, double price, String host, String hostID, String hostPassword) {
			coffeeShopManagementSystemClass.MenuRecord mr = new coffeeShopManagementSystemClass.MenuRecord(id, name, price);
			JOptionPane.showMessageDialog(null, mr.popUp());
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(host, hostID, hostPassword);
				PreparedStatement ps = con.prepareStatement("insert into " + table + "(ID, Name, Price) values(?,?,?)");
				ps.setString(1, mr.id);
				ps.setString(2, mr.name);
				ps.setDouble(3, mr.price);
				ps.executeUpdate();
				ps.close();
				con.close();
			}catch(ClassNotFoundException | SQLException  e1){}
		}
		
	//Add customer
		public static void addCustomer(String id, String name, String phone, double total, String host, String hostID, String hostPassword) {
			coffeeShopManagementSystemClass.CustomerRecord cr = new coffeeShopManagementSystemClass.CustomerRecord(id, name, phone, total);
			JOptionPane.showMessageDialog(null, cr.popUp());
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(host, hostID, hostPassword);
				PreparedStatement ps = con.prepareStatement("insert into customer(ID, Name, Phone, Total) values(?,?,?,?)");
				ps.setString(1, cr.id);
				ps.setString(2, cr.name);
				ps.setString(3, cr.phone);
				ps.setDouble(4, cr.total);
				ps.executeUpdate();
				ps.close();
				con.close();
			}catch(ClassNotFoundException | SQLException  e1){}
		}
	//Add order
		public static void addOrder(String id, String item, double amount, String host, String hostID, String hostPassword) {
			coffeeShopManagementSystemClass.OrderRecord or = new coffeeShopManagementSystemClass.OrderRecord(id, item, amount);
			JOptionPane.showMessageDialog(null, or.popUp());
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(host, hostID, hostPassword);
				PreparedStatement ps = con.prepareStatement("insert into ordermn(ID, Item, Amount) values(?,?,?)");
				ps.setString(1, or.id);
				ps.setString(2, or.item);
				ps.setDouble(3, or.amount);
				ps.executeUpdate();
				ps.close();
				con.close();
			}catch(ClassNotFoundException | SQLException  e1){}
		}
	//Show employee
		public static void showEmployee(DefaultTableModel model, String host, String hostID, String hostPassword) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(host, hostID, hostPassword);
				PreparedStatement ps = con.prepareStatement("select * from employee");
				ResultSet rs = ps.executeQuery();
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
				
				int cols = rsmd.getColumnCount();
				String[] colName = new String [cols];
				for(int i=0; i<cols; i++)
					colName[i] = rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
				String ID, NAME, AGE , POSITION;
				while(rs.next()){
					ID = rs.getString(1);
					NAME = rs.getString(2);
					AGE= rs.getString(3);
					POSITION= rs.getString(4);
					String[] row = {ID, NAME, AGE, POSITION};
					model.addRow(row);
				}
				ps.close();
				con.close();
			} catch (ClassNotFoundException | SQLException e1) {}
		}
		
	//Show menu
	public static void showMenu(DefaultTableModel model, String table, String host, String hostID, String hostPassword) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(host, hostID, hostPassword);
			PreparedStatement ps = con.prepareStatement("select * from " + table);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			
			int cols = rsmd.getColumnCount();
			String[] colName = new String [cols];
			for(int i=0; i<cols; i++)
				colName[i] = rsmd.getColumnName(i+1);
			model.setColumnIdentifiers(colName);
			String ID, NAME, stringPRICE;
			Double PRICE;
			while(rs.next()){
				ID = rs.getString(1);
				NAME = rs.getString(2);
				PRICE = rs.getDouble(3);
				stringPRICE = PRICE.toString();
				String[] row = {ID, NAME, stringPRICE};
				model.addRow(row);
			}
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e1) {}
	}
	
	//Show customer
		public static void showCustomer(DefaultTableModel model, String table, String host, String hostID, String hostPassword) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(host, hostID, hostPassword);
				PreparedStatement ps = con.prepareStatement("select * from " + table);
				ResultSet rs = ps.executeQuery();
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
				
				int cols = rsmd.getColumnCount();
				String[] colName = new String [cols];
				for(int i=0; i<cols; i++)
					colName[i] = rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
				String ID, NAME, PHONE, stringTOTAL;
				Double TOTAL;
				while(rs.next()){
					ID = rs.getString(1);
					NAME = rs.getString(2);
					PHONE = rs.getString(3);
					TOTAL = rs.getDouble(4);
					stringTOTAL = TOTAL.toString();
					String[] row = {ID, NAME, PHONE, stringTOTAL};
					model.addRow(row);
				}
				ps.close();
				con.close();
			} catch (ClassNotFoundException | SQLException e1) {}
		}
		//Show order
				public static void showOrder(DefaultTableModel model, String table, String host, String hostID, String hostPassword) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection(host, hostID, hostPassword);
						PreparedStatement ps = con.prepareStatement("select * from " + table);
						ResultSet rs = ps.executeQuery();
						ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
						
						int cols = rsmd.getColumnCount();
						String[] colName = new String [cols];
						for(int i=0; i<cols; i++)
							colName[i] = rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colName);
						String ID, ITEM, stringAMOUNT;
						Double AMOUNT;
						while(rs.next()){
							ID = rs.getString(1);
							ITEM = rs.getString(2);
							AMOUNT = rs.getDouble(3);
							stringAMOUNT = AMOUNT.toString();
							String[] row = {ID, ITEM, stringAMOUNT};
							model.addRow(row);
						}
						ps.close();
						con.close();
					} catch (ClassNotFoundException | SQLException e1) {}
				}
	//Delete record
	public static void deleteRecord(String ID, String table, String host, String hostID, String hostPassword) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(host, hostID, hostPassword);
			PreparedStatement ps = con.prepareStatement("delete from " + table + " where ID = ?");
			ps.setString(1, ID);
			ps.executeUpdate();
			ps.close();
			con.close();
	} catch(ClassNotFoundException | SQLException e1) {}
	}
}
