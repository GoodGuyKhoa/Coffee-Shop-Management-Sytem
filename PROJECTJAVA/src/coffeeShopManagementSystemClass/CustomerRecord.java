package coffeeShopManagementSystemClass;

public class CustomerRecord extends Record implements PopUp{
	public String name;
	public String phone;
	public double total;
	
	//Constructor
	public CustomerRecord(String id, String name, String phone, double total) {
		super(id);
		this.name = name;
		this.phone = phone;
	}
	
	//Override
	public String popUp() {
		String pu = "Thank you for your money!";
		return pu;
		}
}