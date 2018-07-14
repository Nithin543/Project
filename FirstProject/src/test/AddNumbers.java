package test;
import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddNumbers extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int num_one = Integer.parseInt(req.getParameter("num1"));
		int num_two = Integer.parseInt(req.getParameter("num2"));
		
		int sum = 0;
		sum = num_one + num_two;
		
		/*req.setAttribute("num3",sum);
		RequestDispatcher rd = req.getRequestDispatcher("square");
		rd.forward(req, resp);*/
		
		/*HttpSession s = req.getSession();
		
		System.out.println((String)s.getAttribute("Book1"));*/
		
		// resp.sendRedirect("square?num3="+sum);
		
		resp.setContentType("text/html");
		PrintWriter p = resp.getWriter();
		StringBuffer s = new StringBuffer();
		s.append("<html> <body style =\"Color.BLUE;\">");
		s.append("<h1>" + sum + "</h1>");
		s.append("</body></html>");
		p.println(s.toString());
}
}
