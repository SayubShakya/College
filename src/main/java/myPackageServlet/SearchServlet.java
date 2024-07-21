package myPackageServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myPackageUsers.User;

import java.io.IOException;
import java.util.List;


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Receive
		String strSearch = request.getParameter("txtSearch");
		//boolean result = new Utilities().isNumeric(strSearch);
		List<User> users = new LoginManager().search(strSearch);
		
		//forward to display all users on Display.jsp file
		request.setAttribute("users", users);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Display.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}