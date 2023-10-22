package app;

public class SalableProduct {
	private String name;
	private String description;
	private double price;
	
    public int quantity;
    
    public SalableProduct() {
    	name = "empty";
    	description = "empty";
    	price = 0;
    	quantity = 0;	
    }
    //Argument constructor
    public SalableProduct(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
  //Creates copy of input salable product
    public SalableProduct(SalableProduct other){
    	this.name = other.name;
    	this.description = other.description;
    	this.price = other.price;
    	this.quantity = other.quantity;
    }
    //returns name
    public String getName() {
        return name;
    }
    //returns description
    public String getDescription() {
        return description;
    }
    //returns price
    public double getPrice() {
        return price;
    }
    //returns quantity
    public int getQuantity() {
        return quantity;
    }
    //adds one to the quantity of a product
    public void addQuantity(int quantity){
		this.quantity += quantity;
	}
    //removes one to quantity of the product
	public void removeQuantity(int quantity){
		this.quantity -= quantity;
	}
	//sets quantity to specified number
	public void setQuantity(int num)
	{
		this.quantity = num;
	}
	//compares products alphabetically unless same name then by price.
	public int compareTo(SalableProduct o){
		// if they are not the same return the difference, if they are then check the price
		if (this.name.compareTo(o.getName()) != 0){
			return this.name.compareTo(o.getName());
		}
		else if ((this.price - o.getPrice()) != 0){
			if (this.price > o.getPrice()){
				return 1;
			}
			else{
				return -1;
			}
		}
		else{
			return 0;
		}
		
	}
}
