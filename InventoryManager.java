package app;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager<E extends SalableProduct> {
	    private ArrayList<E> products;

	    public InventoryManager() {
	        products = new ArrayList<>();
	    }
	    //uses loop set to the size of the product list to return the list of products
	    public SalableProduct[] getInventory()
		{
			SalableProduct[] temp = new SalableProduct[this.products.size()];
			for(int i = 0; i < this.products.size(); i++)
			{
				temp[i] = this.products.get(i);
			}
			return temp;
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
