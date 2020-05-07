package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class display
 */
public class display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","scott","tiger");
			Statement stmt=conn.createStatement();
	
			/*
			 * stmt.execute("insert into emp1 values(101,'Ram',26,1234,'Tester')");
			 * stmt.execute("insert into emp1 values(102,'Ramesh',29,1435,'Program')");
			 */
			ResultSet rs=stmt.executeQuery("select * from account");
	
			ResultSetMetaData rsmd=rs.getMetaData();
			int count=rsmd.getColumnCount();
				int c=0; 
				out.println("<html><body><table border='1'><tr><th>Id</th><th>Name</th><th>Age</th><th>Salary</th><th>Desig</th></tr>");
				while(rs.next())
				{
					c++;
					out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td></tr>");
				/*
				 * for(int i=1;i<=count;i++) {
				 * out.println(rsmd.getColumnName(i)+"    :  "+rs.getString(i));
				 * out.println("<br>"); } out.println("<br>");
				 */
				}
				out.println("</table></body></html>");
				if(c==0) {
					out.println("<h1>Details not available</h1>");
					RequestDispatcher rd=request.getRequestDispatcher("ServletDemo.jsp");
					rd.include(request,response );
				}
				else {
					out.println("<h1>Displayed successfully</h1>");
					RequestDispatcher rd=request.getRequestDispatcher("ServletDemo.jsp");
					rd.include(request,response );
				}
				
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
