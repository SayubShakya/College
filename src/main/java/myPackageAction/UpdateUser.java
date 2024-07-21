package myPackageAction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import myPackageServlet.LoginManager;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("txtUid"));
		String fullname = request.getParameter("txtName");
		String email = request.getParameter("txtEmail");
		String phone = request.getParameter("txtPhone");
		String loginName = request.getParameter("txtLoginName");
		String loginPassword = request.getParameter("txtLoginPassword");
		String userRole = request.getParameter("txtUserRole");
		boolean result = new LoginManager().update(uid, fullname, email, phone, loginName, loginPassword, userRole);

		PrintWriter out = response.getWriter();

		HttpSession sessions = request.getSession(false);
		String currentUser = (String) sessions.getAttribute("currentUser");
		out.println("<p>Current User: " + currentUser + "<p>");

		out.println("<p>User update successfully</p>");
		out.println("<p><a href='TempIndex.jsp'>Index</a></p>");
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