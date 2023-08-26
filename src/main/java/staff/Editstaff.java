package staff;

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

@WebServlet("/Editstaff")
public class Editstaff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pt = response.getWriter(); 
		String id = request.getParameter("id");
	  
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","divya");
				PreparedStatement ps = con.prepareStatement("select * from staff where id=?");
				ps.setString(1, id);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					pt.println("<html>");
					pt.println("<head><link href='doctorreg.css' rel='stylesheet' type='text/css'></head>");
					pt.println("<body>");
				    pt.println("<div class='h'>");
					pt.println("<h3><center>Update</h3>");
				    pt.println("</div>");
					pt.println("<div class='f'>");
					pt.println("<form action = 'Updatestaff' method='post'");
					pt.println("<label>id</label><br>");
					pt.println("<input type='text' name='sid'  value='"+rs.getString(1)+"'/><br><br>");
					pt.println("<label>Name</label><br>");
					pt.println("<input type='text' name='sname'  value='"+rs.getString(2)+"'/><br><br>");
					pt.println("<label>Designation</label><br>");
					pt.println("<input type='text' name='design' value='"+rs.getString(3)+"'/><br><br>");
					pt.println("<label>Email id</label><br>");
					pt.println("<input type='text' name='smail'  value='"+rs.getString(4)+"'/><br><br>");
					pt.println("<label>Join date</label><br>");
					pt.println("<input type='text' name='sjd' value='"+rs.getString(5)+"'/><br><br>");
					pt.println("<label>Shift</label><br>");
					pt.println("<input type='text' name='sshift' value='"+rs.getString(6)+"'/><br><br>");
					pt.println("<label>Qualification</label><br>");
					pt.println("<input type='text' name='quali' value='"+rs.getString(7)+"'/><br><br>");
					pt.println("<label>Salary</label><br>");
					pt.println("<input type='number' name='sal' value='"+rs.getString(8)+"'/><br><br>");
					pt.println("<button onclick='Updatestaff.java'>Update</button>");
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
