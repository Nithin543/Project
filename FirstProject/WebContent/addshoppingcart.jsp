<%@ page import = "java.io.*,java.util.*,java.sql.*,java.time.*,com.mysql.jdbc.Driver" %>
<%@ page import = "cartfactorypackage.*" %>

<html>
   <head>
      <title>AddShoppingCart</title>
   <style>
   h1{
   		color:SlateBlue;
   }
	</style>
	</head>

   <body>
            <% 
               ShoppingCartDAO scd = CartFactory.getShoppingCart();
               String s = scd.assignCartToCustomer(new Customer(request.getParameter("add_customerId")));
               out.println("<h1>"  + s  + "</h1>" );             
            %>
   </body>
</html>