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
#size{
width : 100%;
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
width:80%;
padding-bottom: 10px;
}
</style>
</head>
<body>
<form action="Balance">
<center>
<div>
<h2>Check Balance</h2>
<table>
<tr><td> <input type="number" name="acc/phn" required="required" id="size" class="round" placeholder="Enter A/c or Phn number" ></td></tr>
<tr><td><input type="submit" class="round" value="submit">     <input class="round" type="reset" value="Reset"></td></tr>


</table>
</center>
</div>
</form>
</body>
</html>