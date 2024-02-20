package coffeeShopManagementSystemClass;

abstract class Record{
	public String id;
	
	//Constructor
	public Record(String id){
		this.id = id;
	}
}

interface PopUp{
	String popUp();
}