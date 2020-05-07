<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<style>

</style>
</head>
<body>
<div class="left">
<a href="create.jsp" target="create"><button>CREATE</button></a>
</div>

<div class="right">

<center>
<table cellspacing="5" cellpadding="5">
<tr bgcolor="black">
<th class="color">ID</th>
<th class="color">Name</th>
<th class="color">Age</th>
<th class="color">Desig</th>
<th class="color">Salary</th>
<th class="color">Edit</th>
<th class="color">Delete</th>
<th class="color">DOJ</th>
<th class="color">Last Seen</th>
</tr>
<%
try
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","scott","tiger");
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery("select * from jspaccount");
	while(rs.next())
	{
		%>
		<tr>
		<td>
		<%= rs.getString(1)%>
		</td>
		<td>
		<%= rs.getString(2)%>
		</td>
		<td>
		<%= rs.getString(3)%>
		</td>
		<td>
		<%= rs.getString(4)%>
		</td>
		<td>
		<%= rs.getString(5)%>
		</td>
		<td>
		<a href="edit.jsp?id=<%=rs.getString(1) %>" target="create"><button>Edit</button></a>
		</td>
		<td>
		<a href="delete.jsp?id=<%=rs.getString(1) %>" target="create"><button>Delete</button></a>
		</td>
		<td>
		<%= rs.getString(6)%>
		</td>
		<td>
		<%= rs.getString(7)%>
		</td>
		</tr>
	<%}
}
catch(Exception e)
{
	System.out.println(e);
}
%>
</table>
</center>
</div>
</body>
</html>