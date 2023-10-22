package app;

import java.util.Scanner;
import java.util.ArrayList;

public class GameUser {
public static void main(String[] args) {
	Scanner scnr = new Scanner(System.in);
	//create and initialize store
    StoreFront store = new StoreFront();
    store.initializeStore();
    //Welcome prompt and action menu
    System.out.println("Hello Welcome to the Greatest Store.");
    System.out.println("Chose from the actions below:");
    System.out.println("Enter '1' to purchase a product." + "\nEnter '2' to cancel the purchase of a prodcut" + "\nEnter '3' to show inventory" + "\nEnter '4' to show cart.");
    System.out.println("Enter a different number to exit.");
    //input desired action response
    int act1 = scnr.nextInt();
    //loop action response until user decides to exit
    while (act1 <= 4) {
    //action 1 purchase
    if(act1 == 1) {
    	System.out.println("Choose a product to purchase:  (enter products name to purchase)");
    	System.out.println(store.getInventoryManager().findProduct("sweapon") + "\n");
    	System.out.println(store.getInventoryManager().findProduct("bweapon") + "\n");
    	System.out.println(store.getInventoryManager().findProduct("sarmor") + "\n");
    	System.out.println(store.getInventoryManager().findProduct("barmor") + "\n");
    	System.out.println(store.getInventoryManager().findProduct("shealth") + "\n");
    	System.out.println(store.getInventoryManager().findProduct("bhealth") + "\n");
    	String prodpurch = scnr.next();
    	if (store.getInventoryManager().findProduct(prodpurch) != null) {
    		store.getShoppingCart().addItem(store.getInventoryManager().findProduct(prodpurch));
    		System.out.println("Product purchased. " + prodpurch);
    	}
    	else{
    		System.out.println("Product not found.");
    	}
    }
    //action 2 remove
    else if(act1 == 2) {
    	System.out.println("Choose a product to cancel:  (enter products name to cancel)");
    	System.out.println(store.getInventoryManager().findProduct("sweapon") + "\n");
    	System.out.println(store.getInventoryManager().findProduct("bweapon") + "\n");
    	System.out.println(store.getInventoryManager().findProduct("sarmor") + "\n");
    	System.out.println(store.getInventoryManager().findProduct("barmor") + "\n");
    	System.out.println(store.getInventoryManager().findProduct("shealth") + "\n");
    	System.out.println(store.getInventoryManager().findProduct("bhealth") + "\n");
    	String prodcanc = scnr.next();
    	if (store.getInventoryManager().findProduct(prodcanc) != null) {
    		store.getShoppingCart().removeItem(store.getInventoryManager().findProduct(prodcanc));
    		System.out.println("Product cancelled. " + prodcanc);
    	}
    	else{
    		System.out.println("Product not found.");
    	}
    }
    //action 3 show store inventory
    else if(act1 == 3) {
    	System.out.println("--Inventory--" + "\n");
    	for(int i = 0; i < (store.getInventoryManager().getInventory().length); i++) {
    		System.out.println(store.getInventoryManager().getInventory()[i] + "\n");
    	}
    }
    //action 4 get the contents of the shopping cart
    else if(act1 == 4){
    	store.getShoppingCart().listItems();
    }
    System.out.println("Chose from the actions below:");
    System.out.println("Enter '1' to purchase a product." + "\nEnter '2' to cancel the purchase of a prodcut" + "\nEnter '3' to show inventory" + "\nEnter '4' to show cart.");
    System.out.println("Enter a different number to exit.");
    act1 = scnr.nextInt();
}
    //close scanner and exit loop, close program
    System.out.println("Goodbye.");
    scnr.close();
}
}