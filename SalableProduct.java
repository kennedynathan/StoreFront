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
}
