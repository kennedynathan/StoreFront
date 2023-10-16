package app;

public class Weapon extends SalableProduct{
	private int damage;
	private String material;
	//no arg constructor
	public Weapon()
	{
		super();
		damage = 0;
		material = "";
	}
	//argument constructor with name description and price
	public Weapon(String name, String description, double price, int quantity, int damage, String material) {
		super(name, description, price, quantity);
		this.damage = damage;
		this.material = material;
	}
	//copies weapon and makes another
	public Weapon(Weapon other)
	{
		super(other);
		this.damage = other.damage;
		this.material = other.material;
	}
	//returns damage
	public int getDamage()
	{
		return this.damage;
	}
	//returns material
	public String getMaterial()
	{
		return this.material;
	}
	//overrides toString to format display
	public String toString()
	{
		String output = "Name: " + this.getName() + "\nDescription: " + this.getDescription() + "\nPrice: " + this.getPrice() + "\nQuantity: " + this.getQuantity() + "\nDamage: " + this.damage + "\nMaterial: " + this.material;
		return output;
	}
}
