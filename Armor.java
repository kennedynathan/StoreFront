package app;

public class Armor extends SalableProduct {
	private int armorValue;
	private String material;
	//Constructor
	public Armor()
	{
		super();
		armorValue = 0;
		material = "";
	}
	//Argument constructor
	public Armor(String name, String description, double price, int quantity, int armorValue, String material) {
		super(name, description, price, quantity);
		this.armorValue = armorValue;
		this.material = material;
	}
	//creates copy of armor
	public Armor(Armor other)
	{
		super(other);
		this.armorValue = other.armorValue;
		this.material = other.material;
	}
	//return armor value
	public int getArmorValue()
	{
		return this.armorValue;
	}
	public String material()
	{
		return this.material;
	}
	//Override toStrig() to display 
	public String toString()
	{
		String output = "Name: " + this.getName() + "\nDescription: " + this.getDescription() + "\nPrice: " + this.getPrice() + "\nQuantity: " + this.getQuantity() + "\nArmorValue: " + this.armorValue + "\nMaterial: " + this.material;
		return output;
	}

}
