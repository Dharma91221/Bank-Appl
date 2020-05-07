package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String status=request.getParameter("delete");
		System.out.println("status is "+status);
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","scott","tiger");
			conn.setAutoCommit(true);
			Statement stmt=conn.createStatement();
			PreparedStatement pstmt=conn.prepareStatement("delete from account where id=?");
			ResultSet rs=stmt.executeQuery("select id from account");
			
			if(status.equalsIgnoreCase("yes")) 
			{
				int c=0;
				 
				while(rs.next())
				{
					
					if(rs.getString("id").equals(id)) {
						c++;
					}
				}
				
				if(c==1) {
					 pstmt.setString(1,id);
					 pstmt.execute();
					out.println("<h1>deleted successfully</h1>");
					RequestDispatcher rd=request.getRequestDispatcher("ServletDemo.html");
					rd.include(request,response );
				}
				else {
					out.println("<h1>Id details not Existed</h1>");
					RequestDispatcher rd=request.getRequestDispatcher("ServletDemo.html");
					rd.include(request,response );
				}
			
			}
			else {
				out.println("<h1>Data not deleted</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("ServletDemo.html");
				rd.include(request,response );
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
			
			
			
			
			
			
			
	/*
	 * int c=0; out.
	 * println("<html><body><table border='1'><tr><th>Id</th><th>Name</th><th>Age</th><th>Salary</th><th>Desig</th></tr>"
	 * );
	 * 
	 * 
	 * while(rs.next()) {
	 * 
	 * if(rs.getString("id").equals(id)) { c++;
	 * out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+
	 * "</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.
	 * getString(5)+"</td></tr>"); } } out.println("</table></body></html>");
	 * //out.println("do you want to delte Y or N");
	 * 
	 * if(c==0) { out.println("<h1>Id details not Existed</h1>"); } else {
	 * RequestDispatcher rd=request.getRequestDispatcher("delete1.html");
	 * rd.include(request,response ); }
	 */
			
			/*
			 * pstmt.setString(1,id);
			 * 
			 * pstmt.execute();
			 * 
			 * out.println("<h1>Deleted successfully</h1>"); RequestDispatcher
			 * rd=request.getRequestDispatcher("ServletDemo.html");
			 * rd.include(request,response );
			 */
			
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
