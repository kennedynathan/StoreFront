package adminApp;

public class Armor extends SalableProduct{

	private int armorValue;
	private String material;
	
	// Generic constructor.
	public Armor()
	{
		super();
		armorValue = 0;
		material = "";
	}
	
	// Constructor with class variables.
	Armor(String name, String description, double price, int quantity, int armorValue, String material) {
		super(name, description, price, quantity);
		this.armorValue = armorValue;
		this.material = material;
	}
	
	// Copy constructor from another piece of armor.
	
	public Armor(Armor another)
	{
		super(another);
		this.armorValue = another.armorValue;
		this.material = another.material;
	}
	
	// Get the armorValue from armor.
	public int getArmorValue()
	{
		return this.armorValue;
	}
	
	// Get the material of the armor.
	public String material()
	{
		return this.material;
	}
	
	// Override the toString operator to ease display.
	public String toString()
	{
		String display = "Name: " + this.getName() + "\nDescription: " + this.getDescription() + "\nPrice: " + this.getPrice() + "\nQuantity: " + this.getQuantity() + "\nArmorValue: " + this.armorValue + "\nMaterial: " + this.material;
		return display;
	}

}