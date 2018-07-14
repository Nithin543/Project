package cartfactorypackage;

import java.text.ParseException;
import java.util.List;

public class CartFactoryPattern {
	public static void main(String[] args) throws ParseException {
		ShoppingCartDAO scd = CartFactory.getShoppingCart();
		
		/*******************************************************************/
		//System.out.println(scd.assignCartToCustomer(new Customer("2")));
		
		/*******************************************************************/
		
		List<Order> o = scd.getAllOrdersOfCustomer(new Customer("fghj"));
		if(o!=null && !o.isEmpty()) {
			for (Order order : o) {
				System.out.println(order.getOrderID() + "-----" + order.getOrder_UID() + "-----" + 
								   order.getOrderDate() + "-----" + order.getOrderStatus());
			}
		}
		else
			System.out.println(o);
		
		
		/*******************************************************************/
		//scd.deleteCartOfTheCustomer(new Customer("3"));		
	}
}
