<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/login.css" type="text/css" rel="stylesheet">
<style type="text/css">
#passcheck{
	color:red;
}
</style>
<script src="Js/validate.js" type="text/javascript">
</script>
</head>
<body>

<center>
<form action="Register" name="form1" onsubmit="return validate()">

<div>
<h2>Registration</h2>
<table>
<tr><th>First Name </th><td>		<input type="text" name="fn" class="round" pattern=".[A-Za-z]{2,15}" required title="2 characters min, max 15,no's not allowed"></td></tr>
<tr><th>Last Name  </th><td>	   <input type="text" name="ln" class="round" pattern=".[A-za-z]{2,10}" required title="2 characters min, max 10,no's not allowed"></td></tr>
<tr><th>password </th><td> 	<input type="password" name="pw"  class="round"><br>
<span id="passcheck"></span></td></tr>
<tr><th>Email </th><td>		 	<input type="email" name="email" class="round" onfocus="dofocus() "required="required"></td></tr>
<tr><th>DOB   </th><td> 		   	<input type="date" name="date" class="round" required="required"></td></tr>
<tr><th>Gender </th> <td>Male <input type="radio" name="gen" value="Male"> Female <input type="radio" name="gen" value="Female"></td></tr>  

</table>
<br>
<input type="submit" class="round" value="Register">  <input type="reset" class="round" value="Reset">
</div>
 
<!-- pattern=".[A-Za-z0-9@&_]{6,12}"-->

</form>
</center>
</body>
</html>