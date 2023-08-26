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


@WebServlet("/Deletepreviewdonor")
public class Deletepreviewdonor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pt = response.getWriter(); 
		String id = request.getParameter("donorid");
	  
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","divya");
				PreparedStatement ps = con.prepareStatement("select * from bloodbank where donorid=?");
				ps.setString(1, id);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					pt.println("<html>");
					pt.println("<head><link href='doctorreg.css' rel='stylesheet' type='text/css'></head>");
					pt.println("<body>");
				    pt.println("<div class='h'>");
					pt.println("<h3><center>Delete</h3>");
				    pt.println("</div>");
					pt.println("<div class='f'>");
					pt.println("<form action = 'Deletedonor' method='post'");
					pt.println("<label>id</label><br>");
					pt.println("<input type='text' name='bbid'  value='"+rs.getString(1)+"'/><br><br>");
					pt.println("<label>Name</label><br>");
					pt.println("<input type='text' name='bname'  value='"+rs.getString(2)+"'/><br><br>");
					pt.println("<label>Blood group</label><br>");
					pt.println("<input type='text' name='bg' value='"+rs.getString(3)+"'/><br><br>");
					pt.println("<label>Age</label><br>");
					pt.println("<input type='number' name='bage' value='"+rs.getString(4)+"'/><br><br>");
					pt.println("<label>Mobile no</label><br>");
					pt.println("<input type='number' name='mn' value='"+rs.getString(5)+"'/><br><br>");
					pt.println("<label>Email id</label><br>");
					pt.println("<input type='text' name='bmail'  value='"+rs.getString(6)+"'/><br><br>");
					pt.println("<label>Gender</label><br>");
					pt.println("<input type='text' name='gender' value='"+rs.getString(7)+"'/><br><br>");
					pt.println("<label>Address</label><br>");
					pt.println("<input type='text' name='address' value='"+rs.getString(8)+"'/><br><br>");
					pt.println("<button onclick='Deletedonor.java'>Delete</button>");
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
