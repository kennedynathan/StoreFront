package app;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart<E extends SalableProduct> {
	 private List<E> items;

	    public ShoppingCart() {
	        items = new ArrayList<>() ;
	    }

	    public void addItem(E product) {
	       items.add(product);
	    }

	    public void removeItem(E product) {
	        items.remove(product);
	    }

	    public double getTotalPrice() {
	        double totalPrice = 0.00;
	        for (E product : items) {
	            totalPrice += product.getPrice();
	        }
	        return totalPrice;
	    }
	}


