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
String status=request.getParameter("delete");
request.getSession();
String id=(String)request.getAttribute("id");
if(status.equalsIgnoreCase("yes")){
	

try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","scott","tiger");
	conn.setAutoCommit(true);
	PreparedStatement pstmt=conn.prepareStatement("delete id from jspaccount where id=?");
	pstmt.setString(1,id);
	
	pstmt.execute();
	
	out.println("<h1>Deleted successfully</h1>");
	/* RequestDispatcher rd=request.getRequestDispatcher("ServletDemo.jsp");
	rd.include(request,response ); */
	
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	System.out.println(e);
	e.printStackTrace();
} 
}
else{
	out.println("<h1>not Deleted </h1>");
}
%>
</body>
</html>