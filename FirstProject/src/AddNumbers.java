import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNumbers extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
		int num_one = Integer.parseInt(request.getParameter("num1"));
		int num_two = Integer.parseInt(request.getParameter("num2"));
		int sum = 0;
		sum = num_one + num_two;
		
	}

}
