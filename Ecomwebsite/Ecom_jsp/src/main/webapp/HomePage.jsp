<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
text-align:right;
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 25px 80px;
  text-decoration: none;
  font-size: 25px;
}
.img{
float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 25px 80px;
  text-decoration: none;
margin-right:20px;
marging-left:20px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #04AA6D;
  color: white;
}

.div1{
width:100%;
height:auto;
color:#2874f0;

}



</Style>

</head>
<body>
<header>
<div class="topnav">
<%
String name=(String)session.getAttribute("username");

out.println("<a href='#'><img src='https://1000logos.net/wp-content/uploads/2021/02/Flipkart-logo.png' style='width:100px;height:100px'></a>");
if(name!=null){
 out.println("<a href='#'>"+name+"</a>");
}else{
out.println("<a href='Login.jsp'>login</a>");
}
if(name!=null){
  out.println("<a href='Logout.jsp'>logout</a>");
}
%>
  <a href="#orders">orders</a>
  <a href="cart">cart</a>
</div>
</header>
<div>
<div class="img">
  <a href="fashionplp" ><img src="https://rukminim1.flixcart.com/fk-p-flap/128/128/image/a28598a782b6b4cf.png?q=100" style="padding-left:80px;padding-right:180px"></a>
  <a href="beautyplp"><img src="https://rukminim1.flixcart.com/fk-p-flap/128/128/image/a84e58e11c8b10b6.png?q=100"style="padding-left:80px;padding-right:180px"></a>
  <a href="mobiles"><img src="https://rukminim1.flixcart.com/fk-p-flap/128/128/image/9bb3499c8248d2ba.png?q=100"style="padding-left:80px;padding-right:180px"></a>
  <a href="homeFurnitureplp"><img src="https://rukminim1.flixcart.com/fk-p-flap/128/128/image/47874cd4acbfaf20.png?q=100"style="padding-left:80px;padding-right:180px"></a>
</div>
<div><img src="https://rukminim1.flixcart.com/fk-p-flap/50/50/image/f3cd497b800f50c9.jpg?q=50"></div>

</div>

</div>
<footer>
<div class="img" style="padding-right:20px;background-color:lime;width:100%">
<a href="Register.jsp">click here for registration</a>
<a href="Login.jsp"> click here for login</a>
<a href="Logout.jsp">click here to logout</a>
</footer>
</div>
</body>
</html>