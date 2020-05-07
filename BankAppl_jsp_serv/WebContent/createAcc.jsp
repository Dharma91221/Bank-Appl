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
<form action="createAcc" >
<center>
<div>
<h2>Registration</h2>
<table>
<tr><th>Id 	 </th><td> <input type="number" name="id" id="id" class="round" required="required"></td></tr>
<tr><th>Name </th> <td><input type="text" name="name" class="round"  required="required"></td></tr>
<tr><th>DOB </th>	<td> <input type="date" name="dob" class="round" required="required"></td></tr>
<tr><th>Gmail 	</th> <td><input type="email" name="email" class="round" required="required" required title="must be include @,.com"></td></tr>
<tr><th>Account  </th><td><input type="number" name="acc"  class="round" placeholder="enter the A/c num" required="required"></td></tr>
<tr><th>IFSC 	 </th><td><input type="text" name="ifsc" class="round" placeholder="enter the ifsc" required="required"></td></tr>
<tr><th>Phone	 </th><td><input type="text" name="phone" class="round" pattern="[0-9]{10}"  required="required" required title="only 10 digits allowed"></td></tr>
<tr><th>Balance  </th><td><input type="number" name="balance" class="round" required="required" min="500"></td></tr><br>
<tr><td><input type="submit" class="round" value="createAccnt"></td> <td><input type="reset" class="round" value="Reset"></td></tr>

</table>
</center>
</div>
</form>
</body>
</html>