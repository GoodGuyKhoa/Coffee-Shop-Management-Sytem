package coffeeShopManagementSystemClass;

public class EmployeeRecord extends Record implements PopUp {
	public String name;
	public String age;
	public String position;
	
	//Constructor
	public EmployeeRecord(String id, String name, String age, String position) {
		super(id);
		this.name = name;
		this.age = age;
		this.position = position;
	}
	
	//Override
	public String popUp() {
		String pu = "New employee! Welcome!";
		return pu;
	}
}