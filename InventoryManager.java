package app;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import java.util.List;

public class InventoryManager<E extends SalableProduct> {
	    private ArrayList<E> products;

	    public InventoryManager() {
	        products = new ArrayList<E>();
	    }
	    public void pullInventoryJson() throws IOException
		{
			FileService<SalableProduct> fileService = new FileService<SalableProduct>();
			this.products = (ArrayList<E>) fileService.readInventoryJson("inventory.json");
		}
	    //sorts products in ascending order
	    public void sortAscending()
		{
			this.products.sort(null); 
		}
	    //shows the inventory in ascending order
	    public void showStock()
		{
			this.sortAscending();
			System.out.println("----------STOCK----------");
			for(int i = 0; i < this.products.size(); i++)
			{
				System.out.println(this.products.get(i).toString());
				System.out.println("-----------------------------------------------------");
			}
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
	    // Send inventroy to JSON file to save and write over old file
	    public void saveInventory() throws IOException
		{
			FileService<SalableProduct> fileService = new FileService<SalableProduct>();
			fileService.saveToFile("inventory.json", getInventory());
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
	    public E getProduct(String name, int num) throws IllegalArgumentException
		{
			for(int i = 0; i < this.products.size(); i++)
			{
				if( name.toLowerCase().equals(this.products.get(i).getName().toLowerCase()) && num <= this.products.get(i).getQuantity() )
				{
					SalableProduct temp = null;
					if(this.products.get(i).getClass() == Health.class)
					{
						temp = new Health((Health) this.products.get(i));
					}
					else if(this.products.get(i).getClass() == Armor.class)
					{
						temp = new Armor((Armor) this.products.get(i));
					}
					else if(this.products.get(i).getClass() == Weapon.class)
					{
						temp = new Weapon((Weapon) this.products.get(i));
					}
					
					this.products.get(i).removeQuantity(num);
					temp.setQuantity(num);
					return (E) temp;
				}
				else if( (name.toLowerCase().equals(this.products.get(i).getName().toLowerCase())) && (num > this.products.get(i).getQuantity() || num < 1))
				{
					System.out.println("Choose a number that is between 1 and the quantity of item");
					return null;
				}
			}
				System.out.println("This product does not exist. Check spelling.");
				return null;
		}
	    //Takes product and quantity to object list
		public void returnProducts(E product)
		{
			for(int i = 0; i < this.products.size(); i++)
			{
				if (product.getName().toLowerCase().equals(this.products.get(i).getName().toLowerCase()) )
				{
					this.products.get(i).addQuantity(product.getQuantity());
					return;
				}
			}
			System.out.println("Item does not exist.");
		}
		public void restockReturnedCart(ArrayList<E> returned)
		{
			for (int i = 0; i < returned.size(); i++)
			{
				for (int j = 0; j < this.products.size(); i++)
				{
					if(returned.get(i).getName() == this.products.get(j).getName())
					{
						this.products.get(j).addQuantity(returned.get(i).getQuantity());
					}
				}
			}
		}
	}
