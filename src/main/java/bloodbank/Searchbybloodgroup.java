package bloodbank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

@WebServlet("/Searchbybloodgroup")
public class Searchbybloodgroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pt = response.getWriter(); 
		String bg = request.getParameter("sbg");
	  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","divya");
			PreparedStatement ps = con.prepareStatement("select * from bloodbank where bloodgroup=?");
			ps.setString(1, bg);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsm =  (ResultSetMetaData) rs.getMetaData();
			ps.clearBatch();
			
			
			pt.println("<html>");
			pt.println("<head><link href='getpatient.css' rel='stylesheet' type='text/css'></head>");
			pt.println("<body><center>");
			pt.println("<table border=1 cellpadding=0 cellspacing=0 width=70% height=50%>");
			pt.println("<td>");
		    pt.println("<th>"+rsm.getColumnName(1)+"</th>");
		    pt.println("<th>"+rsm.getColumnName(2)+"</th>");
		    pt.println("<th>"+rsm.getColumnName(3)+"</th>");
		    pt.println("<th>"+rsm.getColumnName(4)+"</th>");
		    pt.println("<th>"+rsm.getColumnName(5)+"</th>");
		    pt.println("<th>"+rsm.getColumnName(6)+"</th>");
		    pt.println("<th>"+rsm.getColumnName(7)+"</th>");
		    pt.println("<th>"+rsm.getColumnName(8)+"</th>");
		    pt.println("<th>Edit</th>");
		    pt.println("<th>Delete</th>");
		    pt.println("</td>");
		
		    while(rs.next()){
		    	pt.println("<tr>");
		    	pt.println("<td></td>");
		    	pt.println("<td><center>"+rs.getString(1)+"</td>");
		    	pt.println("<td><center>"+rs.getString(2)+"</td>");
		    	pt.println("<td><center>"+rs.getString(3)+"</td>");
		    	pt.println("<td><center>"+rs.getString(4)+"</td>");
		    	pt.println("<td><center>"+rs.getString(5)+"</td>");
		    	pt.println("<td><center>"+rs.getString(6)+"</td>");
		    	pt.println("<td><center>"+rs.getString(7)+"</td>");
		    	pt.println("<td><center>"+rs.getString(8)+"</td>");
		    	pt.println("<td><center><a href='Editdonor?donorid="+rs.getString(1)+"'>Edit</a></td>");
		    	pt.println("<td><center><a href='Deletepreviewdonor?donorid="+rs.getString(1)+"'>Delete</a></td>");
		    	pt.println("</tr>");
		    	
		    }
		    pt.println("</table><br><br><br><br><br>");
		    pt.println("<form action='RetriveDonor' method='post'>");
		    pt.println("<button type='submit' >BACK</button><br><br>");
		    pt.println("</button>");
	    	pt.println("<html>");
		} catch (ClassNotFoundException | SQLException e) {
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
