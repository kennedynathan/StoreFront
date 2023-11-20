package adminApp;

public class Weapon extends SalableProduct {

	private int damage;
	private String material;
	
	// Constructor for a basic initialization of class variables.
	public Weapon()
	{
		super();
		damage = 0;
		material = "";
	}
	
	// Constructor for Weapon variables.
	Weapon(String name, String description, double price, int quantity, int damage, String material) {
		super(name, description, price, quantity);
		this.damage = damage;
		this.material = material;
	}
	
	// Copy constructor weapon.
	public Weapon(Weapon another)
	{
		super(another);
		this.damage = another.damage;
		this.material = another.material;
	}
	
	// Get damage of weapon.
	public int getDamage()
	{
		return this.damage;
	}
	
	// Get material weapon.
	public String getMaterial()
	{
		return this.material;
	}
	
	// Override toString operator to display.
	public String toString()
	{
		String display = "Name: " + this.getName() + "\nDescription: " + this.getDescription() + "\nPrice: " + this.getPrice() + "\nQuantity: " + this.getQuantity() + "\nDamage: " + this.damage + "\nMaterial: " + this.material;
		return display;
	}
	

}