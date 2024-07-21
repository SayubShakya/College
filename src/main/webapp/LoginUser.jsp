<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Login</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body>

	<div class="container" id="container">
		<div class="form-container sign-up">
			<form>
			<h1 class="signup">Sign Up</h1>				
			<div class="social-icons">
					<a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
					<a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
					<a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
					 <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
				</div>
 					<input type='text' placeholder="Name" name='txtName'>
					<input type='text' placeholder="Email" name='txtEmail'>
					<input type='text' placeholder="Phone" name='txtPhone'>
	 				<input type='text' placeholder="Login Name" name='txtLoginName'>
					<input type='password' placeholder="Login Password" name='txtLoginPassword'>			
				<button>Register</button>
			</form>
		</div>

		<div class="form-container sign-in">
			<h1 class="signin">Sign In</h1>
			<div class="up">
				<form action="LoginServlet" method="post">
					<%
					Cookie[] cookies = request.getCookies();
					String user = "";
					String pass = "";
					if (cookies != null) {
						for (Cookie cookie : cookies) {
							if (cookie.getName().equals("user")) {
						user = cookie.getValue();
							}
							if (cookie.getName().equals("pass")) {
						pass = cookie.getValue();
							}
						}
					}
					%>

					<div class="social-icons">
						<a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
						<a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
						<a href="#" class="icon"><i class="fa-brands fa-github"></i></a> <a
							href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
					</div>

					<input type="text" placeholder="Name" name="txtUser"
						value="<%=user%>"> <input type="password"
						placeholder="Password" name="txtPassword" value="<%=pass%>">

					<div class="Same">
						<label for="chkSave" class="checkbox-label"> <input
							type="checkbox" id="chkSave" name="chkSave" value="yes">
							Remember user
						</label>
					</div>

					<button type="submit">Login</button>
				</form>
			</div>
		</div>

		<div class="toggle-container">
			<div class="toggle">
				<div class="toggle-panel toggle-left">
					<h1>Welcome Back!</h1>
					<p>Enter your credentials to access your account.</p>
					<button class="hidden" id="login">Sign In</button>
				</div>
				<div class="toggle-panel toggle-right">
					<h1>Hello, Friend!</h1>
					<p>Don't have an account yet? Register now!</p>
					<button class="hidden" id="register">Sign Up</button>
				</div>
			</div>
		</div>
	</div>

	<script src="script.js"></script>
</body>
</html>
