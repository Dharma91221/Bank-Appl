<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/login.css" type="text/css" rel="stylesheet">
</head>
<body>
<center>
<form action="ServletDemo">
<div>
<h1>Login</h1>
<table>
<tr><th>Name </th><td> <input type="text" name="un" class="round" placeholder="Enter name" required="required"></td></tr>
<tr><th>password </th><td><input type="password" class="round" name="pw" placeholder="Enter password" required="required"></td></tr>

</table>
<br>
<input type="submit" class="round"  value="Login">   <input type="reset"  class="round"  value="Reset"><br>

<a href="Register.jsp">click to Register</a>
</div>
</form>
</center>


</body>
</html>