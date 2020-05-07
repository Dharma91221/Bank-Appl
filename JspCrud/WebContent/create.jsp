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
<script src="Js/validate1.js" type="text/javascript">
</script>
</head>
<body>



<form action="insert.jsp" name="form1" onsubmit="return validate1()">

<div>
<h2>Insertion</h2>
<table>
<tr><th>Id </th><td><input type="text" name="id" class="round" pattern=".[0-9]{2,15}" required title="enter only numbers min 3"><br>

<tr><th>Name </th><td><input type="text" name="fn" class="round" pattern=".[A-Za-z]{2,15}" required title="enter only alphabets min 3"><br>
<span id="nameCheck"></span></td></tr>
<tr><th>Age  </th><td>	   <input type="number" name="age" class="round"  min="18" max="60" required title="age must be >=18 and <=60"><br>
<span id="passcheck"></span></td></tr>

<tr><th  id="pad" >Designation  </th>  <td><select  class="round" id="space" name="desig">
		<option name="desig" id="clerk">Clerk</option>
		<option name="desig" id="prog">Programmer</option>
		<option name="desig" id="tester">Tester</option>
		<option name="desig" id="mngr">Manager</option>
		</select>
	</td>
	
</tr>
<tr><th>Salary </th><td> <input type="number" name="salary" onfocus="sal()" class="round" min="15000"></td></tr>

</table>
<br>
<input type="submit" class="round" value="Insert">  <input type="reset" class="round" value="Reset">
</div>
 
</form>

<%-- <jsp:include page="Insert">
	<jsp:param value="raj" name="user"/>
	<jsp:param value="ram" name="user1"/>
</jsp:include> --%>	


</body>
</html>