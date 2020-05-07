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
width:80%;
padding-bottom: 10px;
}
</style>
</head>
<body>
<form action="Account">
<center>
<div>
<h2>Transfer to Account</h2>
<table>
<tr><th>Account </th><td> <input type="number" class="round" name="account" required="required" placeholder="Enter A/c number"></td></tr>
<tr><th>IFSC </th><td><input type="text" class="round" name="ifsc" required="required"></td></tr>
<tr><th>Amount  </th><td><input type="number" class="round" name="amount" required="required" placeholder="Enter Amnt to transfer"></td></tr>
<tr><td><input type="submit" class="round" value="Send"></td><td><input type="reset" class="round" value="Reset"></td></tr>


</table>
</center>
</div>
</form>
</body>
</html>