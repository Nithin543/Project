package test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LifeCycle extends HttpServlet{

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println(" In Service ");
		HttpSession s = arg0.getSession();
		s.setAttribute("Book1", "Java");
	}

	@Override
	public void destroy() {
		System.out.println(" In Destroy ");
	}

	@Override
	public void init() throws ServletException {		
		ServletConfig sc = this.getServletConfig();
		String fname = sc.getInitParameter("FileName");
		System.out.println(fname);
		System.out.println(" In Init ");
	}

	

}
