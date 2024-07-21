<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="myPackageUsers.User"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>
</head>
<body>

	<%
	HttpSession sessions = request.getSession(false);
	String currentUser = (String) sessions.getAttribute("currentUser");
	%>
	<p>
		Current User:
		<%
	out.println(currentUser);
	%>
	
	<p>
	<p>
		<a href='LogoutServlet'>Logout</a>
	<p>
	<h1>Display User</h1>
	<table width='95%' border=1>
		<tr>
			<td>UID</td>
			<td>NAME</td>
			<td>EMAIL</td>
			<td>PHONE</td>
			<td>USERNAME</td>
			<td>PASSWORD</td>
			<td>USER ROLE</td>
			<td>CONTROL</td>
		</tr>
		<%
		List<User> users = (List) request.getAttribute("users");
		for (User user : users) {
			if(!currentUser.equals(user.getLoginName()));
			out.println("<tr><td>" + 1000 + user.getUid() + "</td><td>" + user.getFullname() + "</td><td>" + user.getEmail()
			+ "</td><td>" + user.getPhone() + "</td><td>" + user.getLoginName() + "</td><td>" + user.getLoginPassword()
			+ "</td><td>" + user.getuserRole() + "</td><td><a href='EditForm.jsp?uid=" + user.getUid()
			+ "'>EDIT</a> | <a href='DeleteForm.jsp?uid=" + user.getUid()
			+ "'>DELETE</a> | <a href='ExportIndividual?uid=" + user.getUid() + "'>EXPORT</a></td></tr>");
		}
		%>
</table>
<p><a href='ExportAll'>Export All</a></p>
<p><a href='TempIndex.jsp'>Index</a></p>
</body>
</html>