package app;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StoreFront {
	 private InventoryManager<SalableProduct> inventoryManager;
	 private ShoppingCart<SalableProduct> shoppingCart;
	 private ServerThread server;

	 public StoreFront() {
	     
	 }
	 public void startServer() {
		 System.out.println("Starting Server...");
		 server = new ServerThread(this.inventoryManager);
		 server.start();
	 }
	 //sets store with initial set of products 2 of each weapon, health, and armor
	 public void initializeStore() {
		// initialize cart and manager
		 try
			{
				inventoryManager = new InventoryManager<SalableProduct>();
				inventoryManager.pullInventoryJson();
			} catch (IOException e)
			{
				System.out.println("There was an issue creating the inventory manager.");
				e.printStackTrace();
			}
			shoppingCart = new ShoppingCart<SalableProduct>();
			this.startServer();
			// Display the name of shop and the welcome message
			System.out.println("-----------Greatest Store------------");
			System.out.println("Hello Welcome to the Greatest Store");
			
			// Open a reader for user input
			Scanner read = new Scanner(System.in);
			
			// display inventory then ask user what they want, open loop
			while(true)
			{
				try
				{
					System.out.println("Chose from the actions below:");
				    System.out.println("Enter '1' to add to cart." + "\nEnter '2' to remove from cart" + "\nEnter '3' to complete purchase" + "\nEnter '4' to cancel purchase.");
				    System.out.println("Enter '5' to show store inventory" +"\nEnter a different number to exit.");
				    
					int num1 = read.nextInt();
					read.nextLine();
					if(num1 == 1)
					{
						// show available stock from inventory and ask them what they want and how much, if valid, put items into cart
						inventoryManager.getInventory();
						System.out.println("--Inventory--" + "\n");
				    	for(int i = 0; i < (getInventoryManager().getInventory().length); i++) {
				    		System.out.println(getInventoryManager().getInventory()[i] + "\n");
				    	}
						System.out.println("Enter the name of item you would like to add to cart.");
						String input = read.nextLine();
						
						System.out.println("How many?");
						int num = read.nextInt();
						
						try
						{
							shoppingCart.addItem(inventoryManager.getProduct(input, num));
						} catch(Exception IllegalArgumentException)
						{
							System.out.println("Please enter a valid name and number.\n");
						}
					}
					else if(num1 == 2)
					{
						// show the items in their cart and ask them what they want to get rid of, if valid, take item out of cart
						shoppingCart.listItems();
						System.out.println("Enter the name of item you would like to remove from cart.");
						String input = read.nextLine();
						try
						{
							inventoryManager.returnProducts(shoppingCart.removeItem(input));
						}
						catch(Exception IllegalArgumentException)
						{
							System.out.println("Please enter a valid name of an item in the cart.\n");
						}
					}
					else if(num1 == 3) {
						// Show them their items and send message saying completed message
						this.purchaseProducts();
					}
					else if(num1 == 4) {
						// Clear the cart and add all items back to inventory
						this.cancelPurchase();
					}
					else if(num1 == 5) {
						System.out.println("--Inventory--" + "\n");
				    	for(int i = 0; i < (getInventoryManager().getInventory().length); i++) {
				    		System.out.println(getInventoryManager().getInventory()[i] + "\n");
				    	}
					}
					else {
						break;
					}
				}
				catch(Exception InputMismatchException)
				{
					System.out.println("Enter a valid number or name when prompted.\n");
					read = new Scanner(System.in);
				}
			}
			
			read.close();
		 //Weapon sweapon = new Weapon("sweapon","small weapon",5.00,3,2,"wood");
		   // getInventoryManager().addProduct(sweapon);
		   // Weapon bweapon = new Weapon("bweapon","big weapon",10.00,2,5,"metal");
		   // getInventoryManager().addProduct(bweapon);
		   // Armor sarmor = new Armor("sarmor","small armor",5.00,3,4,"cloth");
		   // getInventoryManager().addProduct(sarmor);
		   // Armor barmor = new Armor("barmor","big armor",10.00,2,8,"metal");
		   // getInventoryManager().addProduct(barmor);
		    //Health shealth = new Health("shealth","small health",5,3,5);
		    //getInventoryManager().addProduct(shealth);
		    //Health bhealth = new Health("bhealth","big health",10.00,2,10);
		    //getInventoryManager().addProduct(bhealth);
	    }
	 //purchase product and add it to the shopping cart
	 public void purchaseProducts() throws IOException {
		 System.out.println("Thank you for completing your purchase, here is your ordered items:\n");
			shoppingCart.listItems();
			shoppingCart.clearCart();
			inventoryManager.saveInventory();
	 }
	 //cancel product and remove it from the shopping cart
	 public void cancelPurchase() {
		 System.out.println("Your cart is cleared.");
			inventoryManager.restockReturnedCart(shoppingCart.clearCart());
	 }
	 //return the class inventory manager for this store
	 public InventoryManager<SalableProduct> getInventoryManager() {
	     return inventoryManager;
	 }
	 //returns the class shopping cart for this store
	 public ShoppingCart<SalableProduct> getShoppingCart() {
	     return shoppingCart;
	 }
}