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
 * Servlet implementation class Balance
 */
public class Balance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Balance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String acc_phn=request.getParameter("acc/phn");
		
		//System.out.println(amount);
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","scott","tiger");
			Statement stmt=conn.createStatement();
			//PreparedStatement pstmt=conn.prepareStatement("update phonepeAppl set balance=? where account=?");
			ResultSet rs=stmt.executeQuery("select name,phn,account,balance from phonepeAppl");
			int c=0;
			int amount=0;;
			String name="";
			
				 
				while(rs.next())
				{
					
					if(rs.getString("account").equals(acc_phn) || rs.getString("phn").equals(acc_phn)) {
						
						amount=Integer.parseInt(rs.getString("balance"));
						
						name=rs.getString("name");
						c++;
						
					}
				}
				if(c==1) {
					out.println("Name : "+name);
					out.println("<br>");
					out.println("Balance : "+amount);	out.println("<br>");
					RequestDispatcher rd=request.getRequestDispatcher("Main.jsp");
					rd.include(request,response );
				}
				else {
					out.println("<h1>No details found</h1>");
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
