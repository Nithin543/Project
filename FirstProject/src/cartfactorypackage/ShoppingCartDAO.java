package cartfactorypackage;

import java.text.ParseException;
import java.util.List;

public interface ShoppingCartDAO {
	String assignCartToCustomer(Customer c);
	List<Order> getAllOrdersOfCustomer(Customer c) throws ParseException;
	String deleteCartOfTheCustomer(Customer c);
}
