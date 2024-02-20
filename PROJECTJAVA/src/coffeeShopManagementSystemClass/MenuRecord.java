package coffeeShopManagementSystemClass;

public class MenuRecord extends Record implements PopUp{
	public String name;
	public double price;
	
	//Constructor
	public MenuRecord(String id, String name, double price) {
		super(id);
		this.name = name;
		this.price = price;
	}
	
	//Override
	public String popUp() {
		String pu = "Happy meal!";
		return pu;
	}
}