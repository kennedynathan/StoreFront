package app;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager<E extends SalableProduct> {
	    private List<E> products;

	    public InventoryManager() {
	        products = new ArrayList<>();
	    }
	    //adds a product
	    public void addProduct(E product) {
	        products.add(product);
	    }
	    //removes a product
	    public void removeProduct(E product) {
	        products.remove(product);
	    }
	    //search for product
	    public E findProduct(String name) {
	        for (E product : products) {
	            if (product.getName().equalsIgnoreCase(name)) {
	                return product;
	            }
	        }
	        return null;
	    }
	}
