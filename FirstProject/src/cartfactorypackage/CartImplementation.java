package cartfactorypackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import cartfactorypackage.ConnectionFactory;

public class CartImplementation implements ShoppingCartDAO{
	
	@Override
	public String assignCartToCustomer(Customer c) {
		 Connection connection = ConnectionFactory.getConnection();
		    try {
		    	boolean userPresent = false;
		    	Statement stmt = connection.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT Cart_UID from cart");
		        while(rs.next())
		        {
		            if(rs.getString("Cart_UID").equals(c.getCustomerId())) {
		            	userPresent = true;	
		            	break;
		            }	            	
		        }
		        if(!userPresent) {
		        	PreparedStatement ps = connection.prepareStatement("INSERT INTO cart VALUES (NULL,?)");
			        ps.setString(1,c.getCustomerId());
			        int i = ps.executeUpdate();
			        if(i > 0) {
				        return " Shopping Cart Added for the Customer " + c.getCustomerId();
				      }else {
				    	return " Shopping Cart Not Added "; 
				      }
		        }
		        else
		        	return "User Already Exists";
		    } catch (SQLException ex) {
		        
		    }
			return "Cart Already Assigned to the user";
		
	}

	@Override
	public List<Order> getAllOrdersOfCustomer(Customer c) throws ParseException {
		Connection connection = ConnectionFactory.getConnection();
		
		try {
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM `orders` WHERE `Order_UID` =" + c.getCustomerId());
	        //System.out.println(rs.next());
	        List<Order> orders = new ArrayList<>();
	        while(rs.next())
	        {
	            Order or = extractOrdersFromResultSet(rs);
	            orders.add(or);	            
	        }
	        return orders;
	    } catch (SQLException ex) {
	        System.out.println("Exception occured");
	    }
		return null;
	}

	private Order extractOrdersFromResultSet(ResultSet rs) throws ParseException {
		Order order = new Order();
	    try {
			order.setOrderID( rs.getInt("OrderID") );
			order.setOrder_UID( rs.getString("Order_UID") );
			java.sql.Date date = rs.getDate("OrderDate");
			LocalDate dt= date.toLocalDate();
		    order.setOrderDate(dt);
		    order.setOrderStatus( rs.getString("OrderStatus") );
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    
	    return order;
	}

	@Override
	public String deleteCartOfTheCustomer(Customer c) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			boolean userPresent = false;
	    	Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT Cart_UID from cart");
	        while(rs.next())
	        {
	            if(rs.getString("Cart_UID").equals(c.getCustomerId())) {
	            	userPresent = true;	
	            	break;
	            }	            	
	        }
	        if(userPresent) {
	        PreparedStatement ps = connection.prepareStatement("DELETE FROM cart where Cart_UID = ?");
	        ps.setString(1,c.getCustomerId());
	        int i = ps.executeUpdate();
	        if(i>0) {

	        	System.out.println(" Customer " + c.getCustomerId() + " Cart Deleted ");
	        	return c.getCustomerId();
	        }
	        else
	        	System.out.println(" Customer Cart Not Deleted ");
	        } 
	        else
	        	System.out.println(" User Does Not Exists ");
		}
	        catch (SQLException ex) {
	        ex.printStackTrace();
	    }
		return null;
}
}
