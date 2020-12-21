<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>


<%
if((session.getAttribute("userLogin") != null)&&((Boolean)session.getAttribute("userLogin"))){
%>	
	<h1>Witaj <%= session.getAttribute("userName") %>!</h1>
	<form action="/Logout" method="post"><input type="submit" value="Wyloguj"></form>
<%
}else{
%>
	<a href="login.jsp"><button>Zaloguj sie</button></a>
	<br>
	<a href="register.jsp"><button>Zarejstruj sie</button></a>
<%
}
%>


</body>
</html>