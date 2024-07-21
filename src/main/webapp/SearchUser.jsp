<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search User</title>
<link rel="stylesheet" type="text/css" href="SearchStyle.css">

</head>
<body>

<div class="container">
<h1>Search User</h1>
<% 
	HttpSession sessions=request.getSession(false);
   	String currentUser=(String)sessions.getAttribute("currentUser");
%>
<p>Current User: <% out.println(currentUser); %><p>

<form action='SearchServlet'>
<p>SEARCH : <input type='text' name='txtSearch'>
<input type='submit' value='SEARCH'></p>
</form>

</div>
</body>
</html>