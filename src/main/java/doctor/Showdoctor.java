package doctor;

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

@WebServlet("/Showdoctor")
public class Showdoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pt = response.getWriter();
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","divya");
			PreparedStatement ps =con.prepareStatement("select * from doctor");
			ps.addBatch();
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsm =  (ResultSetMetaData) rs.getMetaData();
			ps.clearBatch();
			pt.println("<html>");
			pt.println("<head><link href='getpatient.css' rel='stylesheet' type='text/css'></head>");
			//pt.println("<html><head><style='text/css'>{ table.th,td{border:1px solid;}</style></head>");
			pt.println("<body><center>");
			pt.println("<table border=1 cellpadding=0 cellspacing=0 width=70% height=50%>");
		    pt.println("<td>");
		    pt.println("<th>"+rsm.getColumnName(1)+"</th>");
		    pt.println("<th>"+rsm.getColumnName(2)+"</th>");
		    pt.println("<th>"+rsm.getColumnName(3)+"</th>");
		    pt.println("<th>Patients Under</th>");
		    pt.println("</td>");
			
		    while(rs.next()){
		    	pt.println("<tr>");
		    	pt.println("<td></td>");
		    	pt.println("<td><center>"+rs.getInt(1)+"</td>");
		    	pt.println("<td><center>"+rs.getString(2)+"</td>");
		    	pt.println("<td><center>"+rs.getString(3)+"</td>");
		    	pt.println("<td><center><a href='Getpatient?doctorid="+rs.getString("doctorid")+"'>patients</a></td>");
                pt.println("</tr>");
		    	
		    }
		   
		    pt.println("</table><br><br>");
		    pt.println("<a href='receptionpage.html' font-size=10% >BACK</a>");
		    pt.println("</body>");
		    pt.println("</html>");
		    con.close();
		   
	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
