package myPackageMain;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import myPackageServlet.LoginManager;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strUser = request.getParameter("txtUser");
		String strPassword = request.getParameter("txtPassword");

		String savePass = "no";

		if (request.getParameter("chkSave") != null) {
			savePass = "yes";
		}

		boolean result = new LoginManager().login(strUser, strPassword);
		// System.out.println(result);

		if (result == true) {
			// forward to TmpIndex.jsp
			// Assign current user on Session
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", strUser);

			if (savePass.equals("yes")) {
				// Assign current user and password on cookie
				Cookie cookieUser = new Cookie("user", strUser);
				Cookie cookiePass = new Cookie("pass", strPassword);

				cookieUser.setMaxAge(5); // time in seconds
				cookiePass.setMaxAge(5);

				response.addCookie(cookieUser);
				response.addCookie(cookiePass);
			}

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("TempIndex.jsp");
			requestDispatcher.forward(request, response);
		} else {
			// forward to LoginUser.jsp
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("LoginUser.jsp");
			requestDispatcher.forward(request, response);
		}
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