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

@WebServlet("/Getpatient")
public class Getpatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pt = response.getWriter();
		response.setContentType("text/html");
		String id = request.getParameter("doctorid");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","divya");
			PreparedStatement ps = con.prepareStatement("select * from patient where doctorid=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsm =  (ResultSetMetaData) rs.getMetaData();
			
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
			pt.println("<th>"+rsm.getColumnName(9)+"</th>");
			pt.println("<th>"+rsm.getColumnName(10)+"</th>");
			pt.println("</td>");
			
			while(rs.next()) {
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
				pt.println("<td><center>"+rs.getString(9)+"</td>");
				pt.println("<td><center>"+rs.getString(10)+"</td>");
		    	pt.println("</tr>");
			}
			
			pt.println("</table><br><br>");
			//pt.println("<a href='Getpatient?doctorid="+rs.getString("doctorid")+"' font-size=10%>BACK</a>");
			pt.println("</body>");
		    con.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
