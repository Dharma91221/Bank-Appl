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
<form action="update">
<div>
<h2>Update</h2>
<table>
<tr><th>Id 	</th><td> <input type="number" name="id"  class="round" placeholder="enter the id" required="required"></td></tr>
<tr><th>Salary </th><td> <input type="number" name="sal"  class="round"  placeholder="enter the salary" required="required"></td></tr>
<tr><th>Update </th><td> <input type="radio" name="update" value="yes"> Yes <input type="radio" name="update" value="no"> No</td></tr>
</table><br>
 <input type="submit"  class="round"  value="submit"> <input type="reset"  class="round" value="Reset">
 
</div>
</form>
</center>
</body>
</html>