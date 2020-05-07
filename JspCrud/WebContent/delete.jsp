<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<%

String id= request.getParameter("id");
%>

<%
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","scott","tiger");
	conn.setAutoCommit(true);
	PreparedStatement pstmt=conn.prepareStatement("delete from jspaccount where id=?");
	
	
	pstmt.setString(1,id);
	
	pstmt.execute();
	
	out.println("<h1>Deleted successfully</h1>");
	
	
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
%>

</body>
</html>