package app;
public class StoreFront {
	 private InventoryManager<SalableProduct> inventoryManager;
	 private ShoppingCart<SalableProduct> shoppingCart;

	 public StoreFront() {
	     inventoryManager = new InventoryManager<SalableProduct>();
	     shoppingCart = new ShoppingCart<SalableProduct>();
	 }

	 public void initializeStore() {
	    }

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

	 public InventoryManager<SalableProduct> getInventoryManager() {
	     return inventoryManager;
	 }

	 public ShoppingCart<SalableProduct> getShoppingCart() {
	     return shoppingCart;
	 }
}