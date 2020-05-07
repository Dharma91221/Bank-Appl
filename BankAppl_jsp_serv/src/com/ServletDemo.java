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
 * Servlet implementation class ServletDemo
 */
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletDemo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","scott","tiger");
			conn.setAutoCommit(true);
			Statement stmt=conn.createStatement();
			
			//PreparedStatement pstmt=conn.prepareStatement("select Name,Password from RegisterWeb");
			
			ResultSet rs=stmt.executeQuery("select Name,Password from RegisterWeb");
			String n=request.getParameter("un");
			String p=request.getParameter("pw");
			int count=0;
			//System.out.println(rs.next());
			//if(rs.next()==true) {
				while(rs.next()) {
					String name=rs.getString(1);
					String pass=rs.getString(2);
					
					//System.out.println(name +" "+ pass);
					if(n.equals(name) && p.equals(pass)) {
						count++;
					}
					
				}
				if(count==1) {
					//out.println("login successful");
					RequestDispatcher rd=request.getRequestDispatcher("ServletDemo.jsp");
					rd.forward(request,response );
					//out.println("<a href='crud.html'>CRUD</a>");
					
					
				}
				else {
					out.println("Invalid username and password");
					RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
					rd.include(request,response );
					
				}
				
			
			/*
			 * } else { out.println("invalid login");
			 * out.println("<a href='login.html'>Try again</a>"); }
			 */
			 
			 
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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
