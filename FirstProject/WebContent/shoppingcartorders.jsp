<%@ page import = "java.io.*,java.util.*,java.sql.*,java.time.*,com.mysql.jdbc.Driver" %>
<%@ page import = "cartfactorypackage.*" %>

<html>
   <head>
      <title>ShoppingCartID</title>
   <style>
	#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: SlateBlue;
    color: white;
}
h1{
   		color:SlateBlue;
   }
	</style>
	</head>

   <body>
   <table id="customers">
  	
            <% 
               ShoppingCartDAO scd = CartFactory.getShoppingCart();
               List<Order> orders = scd.getAllOrdersOfCustomer(new Customer(request.getParameter("orders_customerId")));
               if(orders!=null && !orders.isEmpty()){
            	   out.println("<tr>"+
            	    "<th>OrderID</th>"+
            	    "<th>UserID</th>"+
            	    "<th>OrderDate</th>"+
            	    "<th>OrderStatus</th>"+
            	    "</tr>");
            	for(Order o : orders){
            	   out.println("<tr>" + "<td>" + o.getOrderID() + "</td>" 
               						  + "<td>" + o.getOrder_UID() + "</td>"
            			   			  + "<td>" + o.getOrderDate() + "</td>" 
               						  + "<td>" + o.getOrderStatus() + "</td>" + "</tr>");
               }
               }
               else
            	   out.println("<h1>"  + "No User Present"  + "</h1>" ); 
            %> 
   </table>
   </body>
</html>