package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","scott","tiger");
			conn.setAutoCommit(true);
			PreparedStatement pstmt=conn.prepareStatement("insert into RegisterWeb values(?,?,?,?,?,?)");
			String fname=request.getParameter("fn");
			String lname=request.getParameter("ln");
			String pass=request.getParameter("pw");
			String email=request.getParameter("email");
			String DOB=request.getParameter("date");
			String gender=request.getParameter("gen");
			
			
		
			pstmt.setString(1,fname);
			pstmt.setString(2,lname);
			pstmt.setString(3,pass);
			pstmt.setString(4,email);
			pstmt.setString(5,DOB);
			pstmt.setString(6,gender);
			
			
			pstmt.execute();
			out.println("<h1>Registered successful</h1");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request,response );
			//out.print("<a href='login.html'>Click to login</a>");
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
