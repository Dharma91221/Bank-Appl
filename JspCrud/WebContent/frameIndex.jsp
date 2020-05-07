<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>

<div class="left">
<a href="create.jsp" target="create"><button>CREATE</button></a>
</div>

<div class="right">
<h1>Display</h1>

<%

try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","scott","tiger");
	Statement stmt=conn.createStatement();

	/*
	 * stmt.execute("insert into emp1 values(101,'Ram',26,1234,'Tester')");
	 * stmt.execute("insert into emp1 values(102,'Ramesh',29,1435,'Program')");
	 */
	ResultSet rs=stmt.executeQuery("select * from jspaccount");

	ResultSetMetaData rsmd=rs.getMetaData();
	int count=rsmd.getColumnCount();
		int c=0; 
		out.println("<html><body><table><tr><th>Id</th><th>Name</th><th>Age</th><th>Desig</th><th>Salary</th><th>Edit</th><th>Delete</th></tr>");
		while(rs.next())
		{
			c++;
			out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td><a href='edit.jsp?id="+rs.getString(1)+"' target='create'>Edit</a></td><td><a href='delete.jsp?id="+rs.getString(1)+"' target='create'>Delete</a></td></tr>");
		/*
		 * for(int i=1;i<=count;i++) {
		 * out.println(rsmd.getColumnName(i)+"    :  "+rs.getString(i));
		 * out.println("<br>"); } out.println("<br>");
		 */
		}
		out.println("</table></body></html>");
		/* if(c==0) {
			out.println("<h1>Details not available</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("ServletDemo.html");
			rd.include(request,response ); 
		}
		else {
			out.println("<h1>Displayed successfully</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("ServletDemo.html");
			rd.include(request,response );
		} */
		
		//out.print("<a href='ServletDemo.html'>Click to CRUD operations</a>");
			//or
		/*
		 * System.out.println(rs.getInt(1)); System.out.println(rs.getString(2));
		 * System.out.println(rs.getInt(3)); System.out.println(rs.getInt(4));
		 * System.out.println(rs.getString(5));
		 */
   
		
		
	/*
	 * rs.absolute(3); System.out.println(rs.getInt(1));
	 */

}
catch(Exception e){
System.out.println(e);
}
%>

</div>
</body>
</html>