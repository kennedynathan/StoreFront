package app;
public class StoreFront {
	 private InventoryManager<SalableProduct> inventoryManager;
	 private ShoppingCart<SalableProduct> shoppingCart;

	 public StoreFront() {
	     inventoryManager = new InventoryManager<SalableProduct>();
	     shoppingCart = new ShoppingCart<SalableProduct>();
	 }
	 //sets store with initial set of products 2 of each weapon, health, and armor
	 public void initializeStore() {
		 Weapon sweapon = new Weapon("sweapon","small weapon",5.00,3,2,"wood");
		    getInventoryManager().addProduct(sweapon);
		    Weapon bweapon = new Weapon("bweapon","big weapon",10.00,2,5,"metal");
		    getInventoryManager().addProduct(bweapon);
		    Armor sarmor = new Armor("sarmor","small armor",5.00,3,4,"cloth");
		    getInventoryManager().addProduct(sarmor);
		    Armor barmor = new Armor("barmor","big armor",10.00,2,8,"metal");
		    getInventoryManager().addProduct(barmor);
		    Health shealth = new Health("shealth","small health",5,3,5);
		    getInventoryManager().addProduct(shealth);
		    Health bhealth = new Health("bhealth","big health",10.00,2,10);
		    getInventoryManager().addProduct(bhealth);
	    }
	 //purchase product and add it to the shopping cart
	 public void purchaseProduct(String productName) {
	     SalableProduct product = inventoryManager.findProduct(productName);

	     if (product != null && product.getQuantity() > 0) {
	         shoppingCart.addItem(product);
	         product.quantity--;
	         System.out.println("Purchased " + product.getName());
	     } else {
	         System.out.println("Product not available.");
	     }
	 }
	 //cancel product and remove it from the shopping cart
	 public void cancelPurchase(String productName) {
	     SalableProduct product = inventoryManager.findProduct(productName);

	     if (product != null && shoppingCart.getTotalPrice() > 0) {
	         shoppingCart.removeItem(product);           
	         product.quantity++;
	         System.out.println("Cancelled purchase of " + product.getName());
	     } else {
	         System.out.println("Nothing to cancel.");
	     }
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