<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.round{
border-radius:10px;
padding:5px;

}
h2{
color:green;
}
th{
color:black;
}
div{
background-color:#add8e6;
border:2px solid black;
border-radius:15px;
width:40%;
padding-bottom: 10px;
}
</style>
</head>
<body>
<form action="contact">
<center>
<div>
<h2>Transfer Money</h2>
<table>
<tr><th>Phone </th><td> <input type="number" name="phone" class="round" required="required" maxlength="10"></td></tr>
<tr><th>Amount </th> <td><input type="number" name="amount" class="round" required="required" placeholder="Enter the Amount"></td></tr>
<tr><td><input type="submit" class="round" value="Send"></td><td><input type="reset" class="round" value="Reset"></td></tr>

</table>
</div>
</center>
</form>
</body>
</html>