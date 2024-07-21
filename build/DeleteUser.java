package myPackageAction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myPackageServlet.LoginManager;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("txtUid"));
		boolean result = new LoginManager().delete(uid);
		PrintWriter out = response.getWriter();
		if (result) {
			out.println("<p>User deleted successfully</p>");
		} else {
			out.println("<p>Failed to delete user</p>");
		}
		out.println("<p><a href='TempIndex.jsp'>Index</a></p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}