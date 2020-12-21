<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<jsp:useBean id="formLogin" class="model.FormLogin" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="formLogin"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
if(session.getAttribute("userLogin") != null){
	if((Boolean)session.getAttribute("userLogin")){
%>	
		<H1>Zalogowano uzytkownika <%= (String)session.getAttribute("userName") %></H1>
		<a href="index.jsp"><button>Powrot</button></a>
<%
	}else{
		session.removeAttribute("userLogin");
		session.removeAttribute("userName");
%>
		<H1>Nie poprawne dane</H1>
		<form method="post" action="/Login">
			login:<br>
			<input name="userName" type="text"><br>
			password:<br>
			<input name="password" type="password"><br>
			<input type="submit" value="zaloguj">
		</form>
		<a href="register.jsp"><button>Zarejstruj sie</button></a>
<%
	}
}else{
%>
	<H1>Zaloguj sie</H1>
	<form method="post" action="/Login">
		login:<br>
		<input name="userName" type="text"><br>
		password:<br>
		<input name="password" type="password"><br>
		<input type="submit" value="zaloguj">
	</form>
	<a href="index.jsp"><button>Powrot</button></a>
	
<%
}
%>

</body>
</html>



