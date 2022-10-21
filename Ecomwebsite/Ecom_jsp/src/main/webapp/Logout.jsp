<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%session.invalidate(); %>
<h1>you are Successfully logged out</h1>
<a href="HomePage.jsp"><input style="background-color:green;color:white;" type="button" value="ok"></a>


</body>
</html>