package coffeeShopManagementSystemClass;

public class OrderRecord extends Record implements PopUp{
	public String item;
	public double amount;
	
	//Constructor
	public OrderRecord(String id, String item, double amount) {
		super(id);
		this.item = item;
		this.amount = amount;
	}
	
	//Override
	public String popUp() {
		String pu =("Order Received!");
		return pu;
	}
}