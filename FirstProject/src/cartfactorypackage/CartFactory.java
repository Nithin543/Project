package cartfactorypackage;

public class CartFactory {
	
	public static ShoppingCartDAO getShoppingCart() {
		return new CartImplementation();		
	}

}
