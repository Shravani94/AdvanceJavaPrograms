<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="background-color:pink;text-align:center;height:100% ">
<h1>Login page</h1>
<form style="text-align:center;" action="Login" method="get">
<b>Enter mailId&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp<input type="text" name="mailId" required></b><br><br>
<b>Enter password&nbsp&nbsp:&nbsp&nbsp<input type="password" name="password" required></b><br><br>
<b><input type="submit" value="Login" ></b><br><br>
<b>(or)</b><br><br>
<b><a href="Register.jsp"><input style="background-color:white;color:blue" type="button" value="new to thisSite ? create an account"></a></b>
 
</form>
</div>
</header>
<footer style="background-color:transarent; text-align:left"><a href="Register.jsp">click here for moving to registration</a></footer>

</body>
</html>