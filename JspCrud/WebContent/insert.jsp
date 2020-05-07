<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="org.apache.tomcat.jni.Local"%>
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
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","scott","tiger");
	PreparedStatement pstmt=conn.prepareStatement("insert into JspAccount values(?,?,?,?,?,?,?)");
	
	LocalTime t= LocalTime.now();
	LocalDate d= LocalDate.now();
	String dt=d.toString();
	String tm=t.toString();
	System.out.println(tm);
	request.getSession();
	/*Long tm=session.getCreationTime();
	String time=String.valueOf(tm);
	out.print(time); */
	
	String id=request.getParameter("id");
	String name1=request.getParameter("fn");
	String age=request.getParameter("age");
	String sal=request.getParameter("salary");
	String desig=request.getParameter("desig");
	pstmt.setString(1, id);
	pstmt.setString(2,name1);
	pstmt.setString(3,age);
	pstmt.setString(4,desig);
	pstmt.setString(5,sal);
	pstmt.setString(6,dt);
	pstmt.setString(7,tm);
	pstmt.execute();
	
	out.println("<h1>Created successfully</h1>");
	
	
	/* RequestDispatcher rd=request.getRequestDispatcher("IndexFrameset.html");
	rd.include(request,response ); 
 */
}
catch(Exception e)
{
System.out.println(e);
}



%>
</body>
</html>