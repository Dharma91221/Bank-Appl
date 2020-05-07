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
 * Servlet implementation class Account
 */
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Account() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String acc=request.getParameter("account");
		String ifsc=request.getParameter("ifsc");
		int amount=Integer.parseInt(request.getParameter("amount"));
		System.out.println(amount);
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","scott","tiger");
			Statement stmt=conn.createStatement();
			PreparedStatement pstmt=conn.prepareStatement("update phonepeAppl set balance=? where account=?");
			ResultSet rs=stmt.executeQuery("select account,ifsc,balance from phonepeAppl");
			int c=0;
			
				 
				while(rs.next())
				{
					
					if(rs.getString("account").equals(acc) && rs.getString("ifsc").equals(ifsc)) {
						
						int i=Integer.parseInt(rs.getString("balance"));
						
						 amount=amount+i;
						String amt=String.valueOf(amount);
						
						pstmt.setString(1,amt);
						pstmt.setString(2,acc);
						pstmt.execute();
						c++;
						
					}
				}
				if(c==1) {
					out.println("<h1>Amount send successfully</h1>");
					RequestDispatcher rd=request.getRequestDispatcher("Main.jsp");
					rd.include(request,response );
				}
				else {
					out.println("<h1>Account number not Existed</h1>");
					RequestDispatcher rd=request.getRequestDispatcher("Main.jsp");
					rd.include(request,response );
				}
				
			
			
			
			
			
			//pstmt.execute();
			
	
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
