<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container1" style="background-color:silver">
<form style="text-align:center" action="Registration.java" method="post">
<h1>Registration Page</h1>
<p>Fill the below details.</p>
<b>FirstName &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp   : &nbsp<input type="text" name="firstName" required/></b><br><br>
<b>LastName&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp    :&nbsp <input type="text" name="lastName" required/></b><br><br>
<b>MailId &nbsp  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp &nbsp&nbsp   : &nbsp<input type="email" name="mailId" pattern=".+@gmail\.com" required/></b><br><br>
<b>MobileNumber&nbsp&nbsp&nbsp&nbsp :&nbsp <input type="tel" pattern="[0-9]{10}" name="number" required/></b><br><br>
<b>Password &nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp   :&nbsp <input type="password" name="password" required></b><br><br>
<b>Confirm-password:&nbsp<input type="password" name="confirm" required></b><br><br>
<b><input type="submit" value="Register" /></b><br><br>
<b>(or)</b><br><br>
<b><a href="Login.java"><input type="button" style="background-color:white;color:blue;" value="Existing User?Login"></a></b>
</form>
</div>

</body>
</html>