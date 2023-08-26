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

@WebServlet("/Updatedoctor")
public class Updatedoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pt = response.getWriter(); 
		String id = request.getParameter("doctorid");
	  
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","divya");
				PreparedStatement ps = con.prepareStatement("select * from doctor where doctorid=?");
				ps.setString(1, id);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					pt.println("<html>");
					pt.println("<head><link href='doctorreg.css' rel='stylesheet' type='text/css'></head>");
					pt.println("<body>");
					pt.println("<div class='f'>");
					pt.println("<h3>Update</h3>");
					pt.println("<form action='Editdoctor' method='post'");
					pt.println("<label>Doctor id</label><br>");
					pt.println("<input type='text' name='docid'  value='"+rs.getString(1)+"'/><br><br>");
					pt.println("<label>Name</label><br>");
					pt.println("<input type='text' name='dname'  value='"+rs.getString(2)+"'/><br><br>");
					pt.println("<label>Specialist</label><br>");
					pt.println("<input type='text' name='spec'  value='"+rs.getString(3)+"'/><br><br>");
					pt.println("<label>Email id</label><br>");
					pt.println("<input type='text' name='mail' value='"+rs.getString(4)+"'/><br><br>");
					pt.println("<label>Join Date</label><br>");
					pt.println("<input type='text' name='jd' value='"+rs.getString(5)+"'/><br><br>");
					pt.println("<label>Salary</label><br>");
					pt.println("<input type='text' name='sal' value='"+rs.getString(6)+"'/><br><br>");
					pt.println("<button onclick='Editdoctor.java'>Update</button>");
					pt.println("</form>");
					pt.println("</div>");
					pt.println("</body>");
					pt.println("</html>");
			} }
				catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}



}
