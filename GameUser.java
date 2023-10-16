package app;

import java.util.Scanner;

public class GameUser {
public static void main(String[] args) {
	Scanner scnr = new Scanner(System.in);
	
    StoreFront store = new StoreFront();
    Weapon w1 = new Weapon("w1","small weapon",5.00,3,2,"wood");
    store.getInventoryManager().addProduct(w1);
    Weapon w2 = new Weapon("w2","big weapon",10.00,2,5,"metal");
    store.getInventoryManager().addProduct(w2);
    Armor a1 = new Armor("a1","small armor",5.00,3,4,"cloth");
    store.getInventoryManager().addProduct(a1);
    Armor a2 = new Armor("a2","big armor",10.00,2,8,"metal");
    store.getInventoryManager().addProduct(a2);
    Health h1 = new Health("h1","small health",5,3,5);
    store.getInventoryManager().addProduct(h1);
    Health h2 = new Health("h2","big health",10.00,2,10);
    store.getInventoryManager().addProduct(h2);

    // Purchase a product called "w1"
    //store.purchaseProduct("w1");

    // Display shopping cart total
    //System.out.println("Total Price: $" + store.getShoppingCart().getTotalPrice());
    
    System.out.println("Hello Welcome to the Greatest Store.");
    System.out.println("Chose from the actions below:");
    System.out.println("Enter '1' to purchase a product." + "\nEnter '2' to cancel the purchase of a prodcut" + "\nEnter '3' to exit.");
    int act1 = scnr.nextInt();
    if(act1 == 1) {
    	System.out.println("Choose a product to purchase:  (enter products name to purchase)");
    	System.out.println(w1.toString() + "\n");
    	System.out.println(w2.toString() + "\n");
    	System.out.println(a1.toString() + "\n");
    	System.out.println(a2.toString() + "\n");
    	System.out.println(h1.toString() + "\n");
    	System.out.println(h2.toString() + "\n");
    	String prodpurch = scnr.next();
    	if (store.getInventoryManager().findProduct(prodpurch) != null) {
    		store.getShoppingCart().addItem(store.getInventoryManager().findProduct(prodpurch));
    		System.out.println("Product purchased.");
    	}
    	else{
    		System.out.println("Product not found.");
    	}
    }
    else if(act1 == 2) {
    	System.out.println("Choose a product to cancel:  (enter products name to cancel)");
    	System.out.println(w1.toString() + "\n");
    	System.out.println(w2.toString() + "\n");
    	System.out.println(a1.toString() + "\n");
    	System.out.println(a2.toString() + "\n");
    	System.out.println(h1.toString() + "\n");
    	System.out.println(h2.toString() + "\n");
    	String prodcanc = scnr.next();
    	if (store.getInventoryManager().findProduct(prodcanc) != null) {
    		store.getShoppingCart().addItem(store.getInventoryManager().findProduct(prodcanc));
    		System.out.println("Product cancelled.");
    	}
    	else{
    		System.out.println("Product not found.");
    	}
    }
    else {
    	System.out.println("Goodbye.");
    }
}
}