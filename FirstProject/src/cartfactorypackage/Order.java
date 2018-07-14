package cartfactorypackage;

import java.time.LocalDate;
import java.util.Date;

public class Order {
	private int OrderID;
	private String Order_UID;
	private LocalDate OrderDate;
	private String OrderStatus;
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public String getOrder_UID() {
		return Order_UID;
	}
	public void setOrder_UID(String order_UID) {
		Order_UID = order_UID;
	}
	public LocalDate getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		OrderDate = orderDate;
	}
	public String getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}
	

}
