<%@ page import = "java.io.*,java.util.*,java.sql.*,java.time.*,com.mysql.jdbc.Driver" %>
<%@ page import = "cartfactorypackage.*" %>

<html>
   <head>
      <title>DeleteShoppingCart</title>
   <style>
   h1{
   		color:SlateBlue;
   }
	</style>
	</head>

   <body>
            <% 
               ShoppingCartDAO scd = CartFactory.getShoppingCart();
               String s = scd.deleteCartOfTheCustomer(new Customer(request.getParameter("delete_customerId")));
               if(s!=null){
            	   out.println("<h1>" + "Cart Deleted For the Customer" + s  + "</h1>" );             
               }
               else
            	   out.println("<h1>" + " No Customer Present " + "</h1>" );
            	   
            %>
   </body>
</html>