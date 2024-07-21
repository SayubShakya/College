<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
<link rel="stylesheet" type="text/css" href="NewUserStyle.css">
</head>
<body>


	<div class="container">
		
		<h2>New User</h2>
		
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
		
		<form action='ReceiverUser'>

			<p>
				UID : <input type='text' name='txtUid'>
			</p>
			<p>
				NAME : <input type='text' name='txtName'>
			</p>
			<p>
				EMAIL : <input type='text' name='txtEmail'>
			</p>
			<p>
				PHONE : <input type='text' name='txtPhone'>
			</p>
			<p>
				LOGIN NAME : <input type='text' name='txtLoginName'>
			</p>
			<p>
				LOGIN PASSWORD: <input type='password' name='txtLoginPassword'>
			</p>


			<p>
				USER TYPE: <select name='txtUserRole'>
					<option value='admin'>Admin
					<option value='manager'>Manager
					<option value='user'>User
				</select>

			</p>





			<p class="links">
				<input type='submit' value='SEND'>
			</p>
		</form>
	</div>
</body>
</html>
