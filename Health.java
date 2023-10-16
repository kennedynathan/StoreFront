package app;

public class Health extends SalableProduct{
	private int health;
	// no arg constructor
	public Health()
	{
		super();
		health = 0;
	}
	// argument constructor
	public Health(String name, String description, double price, int quantity, int health) {
		super(name, description, price, quantity);
		this.health = health;
		//this.isPermanent = isPermanent;
	}
	//create copy of health
	public Health(Health other)
	{
		super(other);
		this.health = other.health;
	}
	//returns health
	public int getHealth()
	{
		return this.health;
	}
	//overrides toString to format display
	public String toString()
	{
		String output = "Name: " + this.getName() + "\nDescription: " + this.getDescription() + "\nPrice: " + this.getPrice() + "\nQuantity: " + this.getQuantity() + "\nHealth: " + this.health; 
		return output;
	}
}
