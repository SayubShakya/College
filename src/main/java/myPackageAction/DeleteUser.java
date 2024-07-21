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

public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int uid = Integer.parseInt(request.getParameter("txtUid"));
		boolean result = new LoginManager().delete(uid);
		PrintWriter out = response.getWriter();

		HttpSession sessions = request.getSession(false);
		String currentUser = (String) sessions.getAttribute("currentUser");
		out.println("<p>Current User: " + currentUser + "<p>");

		out.println("<p>User delete successfully</p>");
		out.println("<p><a href='TempIndex.jsp'>Index</a></p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
