package adminApp;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

// Jackson Type Info for all Super Classes of a Car
//  Maps the type field to the Super Class types
@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME, 
		  include = JsonTypeInfo.As.PROPERTY, 
		  property = "type")
		@JsonSubTypes({ 
		  @Type(value = Armor.class, name = "armor"), 
		  @Type(value = Weapon.class, name = "weapon"),
		  @Type(value = Health.class, name = "health")})
public class SalableProduct implements Comparable<SalableProduct>
{

	private String name;
	private String description;
	private double price;
	private int quantity;
	
	// Constructor for base initialization of the SalablePRoduct
	public SalableProduct()
	{
		name = "";
		description = "";
		price = 0;
		quantity = 0;
	}
	
	// Constructor with parameters for all the class variables.
	SalableProduct(String name, String description, double price, int quantity)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	// Copy constructor taking in a salable product and creating one just like it.
	public SalableProduct(SalableProduct another)
	{
		this.name = another.name;
		this.description = another.description;
		this.price = another.price;
		this.quantity = another.quantity;
	}
	
	// Return the name of SalableProduct.
	public String getName()
	{
		return this.name;
	}
	
	// Return description of SalableProduct.
	public String getDescription()
	{
		return this.description;
	}
	
	 // Return price of SalableProduct.
	public double getPrice()
	{
		return this.price;
	}
	
	
	// Return quantity of SalableProduct.
	 
	public int getQuantity()
	{
		return this.quantity;
	}
	
	// Add a quantity to an item.
	
	public void addQuantity(int quantity)
	{
		this.quantity += quantity;
	}
	
	// Remove quantity from the SalableProduct.
	public void removeQuantity(int quantity)
	{
		this.quantity -= quantity;
	}
	
	// Take in a number and replace the quantity with that number.
	public void setQuantity(int num)
	{
		this.quantity = num;
	}

	@Override
	// Take in a Salable and compare it with the current one by name, and if they are the same, then by price.
	public int compareTo(SalableProduct o)
	{
		// if they are not the same return the difference, if they are then check the price
		if (this.name.compareTo(o.getName()) != 0)
		{
			return this.name.compareTo(o.getName());
		}
		else if ((this.price - o.getPrice()) != 0)
		{
			if (this.price > o.getPrice())
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
		else
		{
			return 0;
		}
		
	}
}