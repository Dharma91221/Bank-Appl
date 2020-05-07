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
 * Servlet implementation class update
 */
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		int salary=Integer.parseInt(request.getParameter("sal"));
		String status=request.getParameter("update");
		System.out.println("status is "+status);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","scott","tiger");
			conn.setAutoCommit(true);
			Statement stmt=conn.createStatement();
			PreparedStatement pstmt=conn.prepareStatement("update account set salary=? where id=?");
			ResultSet rs=stmt.executeQuery("select id,salary from account");
			
			if(status.equalsIgnoreCase("yes")) 
			{
				int c=0;
				
				 
				while(rs.next())
				{
					
					if(rs.getString("id").equals(id)) {
						
						int i=Integer.parseInt(rs.getString("salary"));
						
						 salary=salary+i;
						String amt=String.valueOf(salary);
						System.out.println(amt);
						pstmt.setString(1,amt);
						pstmt.setString(2,id);
						pstmt.execute();
						c++;
						
					}
				}
				if(c==1) {
					out.println("<h1>updated successfully</h1>");
					RequestDispatcher rd=request.getRequestDispatcher("ServletDemo.jsp");
					rd.include(request,response );
				}
				else {
					out.println("<h1>Id details not Existed</h1>");
					RequestDispatcher rd=request.getRequestDispatcher("ServletDemo.jsp");
					rd.include(request,response );
				}
			
			}
			else {
				out.println("<h1>Data not updated</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("ServletDemo.jsp");
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
		catch(Exception e) {
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
