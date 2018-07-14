package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SquareOfANumber extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int num = Integer.parseInt(req.getParameter("num1"));
		
		int square = num * num;
		
		resp.setContentType("text/html");
		
		PrintWriter p = resp.getWriter();
		StringBuffer s = new StringBuffer();
		s.append("<html> <body bgcolor =\"Color.CYAN;\">");
		s.append("<h1>" + square + "</h1>");
		s.append("</body></html>");
		
		p.println(s.toString());
	}
}
