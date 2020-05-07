<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="Header.css" type="text/css" rel="stylesheet">
<style>
#home{
	float:left;
	padding-top: 10px;
}
.space{
display:inline-block;
align-content:center;
padding: 10px;
}
h2{

padding-top:20px;
padding-left:20px;
display:inline;
}
h1{
padding-top:4px;
color:blue;
}
a{
text-decoration: none;
}
</style>	
</head>
<body>
	

	<img id="logo" src="download.png" alt="blank" width="45" height="45"/>
	<h1 width="50">JP Morgan & Chase</h1>
	
	<a href="Main.jsp" id="phnpe" target="index"><img src="images/pelogo.png" alt="blank" height="50" width="50" /></a>
	
	<a href="https://www.instagram.com" target="_blank"><img src="insta.jpeg" alt="blank"  width="40" height="40"/></a>
	<a href="https://www.linkedin.com" target="_blank"><img src="linkdn.png" alt="blank" width="40" height="40"/></a>
	<a href="https://www.facebook.com" target="_blank"><img src="Facebook.png" alt="blank" width="40" height="40"/></a>
	<a href="https://www.twitter.com" target="_blank"><img src="twiter.png" alt="blank" width="40" height="40"/></a>
 	<br><br>
 	
	<a href="Display.jsp" id="home" target="index"><img src="images/home.png" alt="blank" height="40" width="40" /></a>
	<h2>Welcome ${sessionScope.name}</h2>
	<a href="login.jsp" id="signOut" target="_top"><img src="images/signOut.png" alt="blank" height="40" width="40" /></a>
</body>
</html>