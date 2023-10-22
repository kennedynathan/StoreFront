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
	       items.add(product);
	    }
	    //remove item from cart
	    public void removeItem(E product) {
	        items.remove(product);
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


