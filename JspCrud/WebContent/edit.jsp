<%@page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
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

<%

String id1= request.getParameter("id");%>


<%!
String id;
String name;
String age;
String desig;
String sal;
%>
<% 
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","scott","tiger");
	conn.setAutoCommit(true);
	Statement stmt=conn.createStatement();
	PreparedStatement pstmt=conn.prepareStatement("select * from jspaccount where id=?");
	
	pstmt.setString(1, id1);
	
	
	pstmt.execute();

	ResultSet rs=pstmt.executeQuery();
	
	
		 
		while(rs.next())
		{
			id=rs.getString(1);
			name=rs.getString(2);
			age=rs.getString(3);
			desig=rs.getString(4);
			sal=rs.getString(5);
		}
		
		
		
	} 

	catch(Exception e) {
	System.out.println(e);
	}
%>
<form action="insert.jsp" name="form1" onsubmit="return validate1()">

<div>
<h2>Insertion</h2>
<table>
<tr><th>Id </th><td><input type="text" name="id" value="<%= id%>" class="round" pattern=".[0-9]{2,15}" required title="enter only numbers min 3"><br>

<tr><th>Name </th><td><input type="text" name="fn" value="<%= name%>" class="round" pattern=".[A-Za-z]{2,15}" required title="enter only alphabets min 3"><br>
<span id="nameCheck"></span></td></tr>
<tr><th>Age  </th><td>	   <input type="number" name="age" value="<%= age%>" class="round"  min="18" max="60" required title="age must be >=18 and <=60"><br>
<span id="passcheck"></span></td></tr>

<tr><th  id="pad" >Designation  </th>  <td><select  class="round" id="space" name="desig" value="<%= desig%>">
		<option name="desig" id="clerk">Clerk</option>
		<option name="desig" id="prog">Programmer</option>
		<option name="desig" id="tester">Tester</option>
		<option name="desig" id="mngr">Manager</option>
		</select>
	</td>
	
</tr>
<tr><th>Salary </th><td> <input type="number" name="salary" value="<%= sal%>" onfocus="sal()" class="round" min="15000"></td></tr>

</table>
<br>

 <%
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","scott","tiger");
conn.setAutoCommit(true);
PreparedStatement pstmt1=conn.prepareStatement("update jspaccount set t_time=? where id=?");

LocalTime t= LocalTime.now();
String tm=t.toString();
pstmt1.setString(1,tm );
pstmt1.setString(2,id1);
pstmt1.execute();
%> 

<input type="submit" class="round" value="Insert">  <input type="reset" class="round" value="Reset">
</div>


</form>

</body>
</html>