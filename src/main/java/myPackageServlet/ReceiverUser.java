package myPackageServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class ReceiverUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Receive
		String fullname = request.getParameter("txtName");
		String email = request.getParameter("txtEmail");
		String phone = request.getParameter("txtPhone");
		String loginName = request.getParameter("txtLoginName");
		String loginPassword = request.getParameter("txtLoginPassword");
		String userRole = request.getParameter("txtUserRole");

		// Validate - Range ok
		// Process - ok
		// Send value to database table
		boolean result = new LoginManager().save(fullname, email, phone, loginName, loginPassword, userRole);

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		String currentUser = (String) session.getAttribute("currentUser");
		out.println("<p>Current User: " + currentUser + "<p>");

		out.println("<p>User save successfully</p>");
		out.println("<p><a href='TempIndex.jsp'>Index</a></p>\r\n" + "");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}