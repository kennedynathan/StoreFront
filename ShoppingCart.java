package app;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart<E extends SalableProduct> {
	 private ArrayList<E> items;

	    public ShoppingCart() {
	        items = new ArrayList<E>() ;
	    }
	    //generates list of all items currently in the cart
	    public void listItems(){
			System.out.println("-CART ITEMS-" + "\n");
			if(this.items != null)
			{
				for (int i = 0; i < items.size(); i++)
				{
					System.out.println(this.items.get(i).toString());
					System.out.println("\n" + "------------" +"\n");
				}
			}
		}
	    //add item to cart
	    public void addItem(E product) {
	    	if(product == null)
			{
				return;
			}
			for (int i = 0; i < items.size(); i++){
				if(product.getName().equals(this.items.get(i).getName())){
					this.items.get(i).addQuantity(product.getQuantity());
					return;
				}
			}
	    	this.items.add(product);
	    }
	    //remove item from cart
	    public E removeItem(String product) throws IllegalArgumentException {
			for (int i = 0; i < items.size(); i++)
			{
				if(product.toLowerCase().equals(this.items.get(i).getName().toLowerCase())) {
					E temp = this.items.get(i);
					this.items.remove(i);
					return temp;
				}
			}
			System.out.println("Item does not exist. (CART)");
			return null;
	     
	    }
	    //shows carts total price
	    public double getTotalPrice() {
	        double totalPrice = 0.00;
	        for (E product : items) {
	            totalPrice += product.getPrice();
	        }
	        return totalPrice;
	    }
	    //empties cart
	    public ArrayList<E> clearCart(){
			ArrayList<E> temp = this.items;
			this.items.clear();
			return temp;
		}
	    
	}


