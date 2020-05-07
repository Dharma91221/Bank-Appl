package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createAcc
 */
public class createAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createAcc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String dob=request.getParameter("dob");
		String email=request.getParameter("email");	
		String account=request.getParameter("acc");
		String ifsc=request.getParameter("ifsc");
		String pno=request.getParameter("phone");
		String bal=request.getParameter("balance");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","scott","tiger");
			PreparedStatement pstmt=conn.prepareStatement("insert into PhonepeAppl values(?,?,?,?,?,?,?,?)");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select id,phn,account,ifsc from phonepeAppl");
			int c=0;
			
			while(rs.next()) {
				if(id.equals(rs.getString("id")) || pno.equals(rs.getString("phn")) || account.equals(rs.getString("account")) || ifsc.equals(rs.getString("ifsc")))
				{
					c++;
				}
			
			}
			if(c==0) {
			pstmt.setString(1,id);
			pstmt.setString(2,name);
			pstmt.setString(3,dob);
			pstmt.setString(4,email);
			pstmt.setString(5,pno);
			pstmt.setString(6,account);
			pstmt.setString(7,ifsc);
			pstmt.setString(8,bal);
			
			pstmt.execute();
			
			out.println("<h1>Created successfully</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("Main.jsp");
			rd.include(request,response );
			}
			if(c>=1) {
				out.println("<h1>Details already Existed, create the account again</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("Main.jsp");
				rd.include(request,response );
			}
	
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
