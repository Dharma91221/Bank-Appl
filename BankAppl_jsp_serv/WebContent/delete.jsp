<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/login.css" type="text/css" rel="stylesheet">

</head>
<body bgcolor="yellow">
<center>
<form action="delete">
<h2>Delete</h2>
Id : <input type="text" name="id" class="round" placeholder="enter the id" required="required"><br><br>
Delete : <input type="radio" name="delete" value="yes"> Yes <input type="radio" name="delete" value="no"> No<br><br>
 <input type="submit" class="round" value="submit">
 <input type="reset" class="round" value="Reset">

</form>
</center>
</body>
</html>