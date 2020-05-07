package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class create
 */
public class create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public create() {
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
			PreparedStatement pstmt=conn.prepareStatement("insert into account values(accid.nextval,?,?,?,?)");
			
			//String id=request.getParameter("id");
			String name=request.getParameter("name");
			String age=request.getParameter("age");
			String sal=request.getParameter("salary");
			String desig=request.getParameter("desig");
			//pstmt.setString(1, id);
			pstmt.setString(1,name);
			pstmt.setString(2,age);
			pstmt.setString(3,sal);
			pstmt.setString(4,desig);
			pstmt.execute();
			out.println("<h1>Created successfully</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("ServletDemo.jsp");
			rd.include(request,response );
	
	}
	catch(Exception e)
		{
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
