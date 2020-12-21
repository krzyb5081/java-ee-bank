<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="formRegister" class="model.FormRegister" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="formRegister"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("accountCreated") != null){
	if((Boolean)session.getAttribute("accountCreated")){
%>	
		<H1>Zarejstrowano konto</H1>
		<a href="index.jsp"><button>zaloguj sie</button></a>
<%
	}else{
%>
		<H1>Nie udalo sie zarejstrowac konta</H1>
		<form method="post" action="/Register">
			Nazwa uzytkownika:<br>
			<input name="userName" type="text"><br>
			haslo:<br>
			<input name="password" type="password"><br>
			Imie:<br>
			<input name="name" type="text" value="imie"><br>
			Nazwisko:<br>
			<input name="surname" type="text" value="nazwisko"><br>
			Data urodzenia:<br>
			<input name="birthDate" type="date" value="2000-10-10"><br>
			ile chcesz szmalcu $$$:<br>
			<input name=currentMoney type="number" value="7000"><br>
			<input type="submit" value="zarejstruj">
		</form>
		<a href="index.jsp"><button>Powrot</button></a>
<%
	}
	
}else{
%>
	<H1>Zarejstruj sie</H1>
	<form method="post" action="/Register">
		Nazwa uzytkownika:<br>
		<input name="userName" type="text"><br>
		haslo:<br>
		<input name="password" type="password"><br>
		Imie:<br>
		<input name="name" type="text" value="imie"><br>
		Nazwisko:<br>
		<input name="surname" type="text" value="nazwisko"><br>
		Data urodzenia:<br>
		<input name="birthDate" type="date" value="2000-10-10"><br>
		ile chcesz szmalcu $$$:<br>
		<input name=currentMoney type="number" value="7000"><br>
		<input type="submit" value="zarejstruj">
	</form>
	<a href="index.jsp"><button>Powrot</button></a>
	
<%
}
session.removeAttribute("accountCreated");
%>



</body>
</html>