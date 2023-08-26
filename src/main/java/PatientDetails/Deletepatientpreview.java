package PatientDetails;

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

@WebServlet("/Deletepatientpreview")
public class Deletepatientpreview extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pt = response.getWriter();
		String p = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","divya");
			PreparedStatement ps = con.prepareStatement("select * from patient where password=?");
			ps.setString(1, p);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pt.println("<html>");
				pt.println("<head><link href='doctorreg.css' rel='stylesheet' type='text/css'></head>");
				pt.println("<body>");
				pt.println("<h3><center>Update</h3>");
				pt.println("<div class='f'>");
				pt.println("<form action='Deletepatient' method='post'");
				pt.println("<label>Username</label><br>");
				pt.println("<input type='text' name='name'  value='"+rs.getString(1)+"'/><br><br>");
				pt.println("<label>Password</label><br>");
				pt.println("<input type='text' name='pass'  value='"+rs.getString(2)+"'/><br><br>");
				pt.println("<label>Email id</label><br>");
				pt.println("<input type='text' name='spec'  value='"+rs.getString(3)+"'/><br><br>");
				pt.println("<label>Phone</label><br>");
				pt.println("<input type='text' name='phno' value='"+rs.getString(4)+"'/><br><br>");
				pt.println("<label>BloodGroup</label><br>");
				pt.println("<input type='text' name='bg' value='"+rs.getString(5)+"'/><br><br>");
				pt.println("<label>Age</label><br>");
				pt.println("<input type='text' name='age' value='"+rs.getString(6)+"'/><br><br>");
				pt.println("<label>Disease</label><br>");
				pt.println("<input type='text' name='dis' value='"+rs.getString(7)+"'/><br><br>");
				pt.println("<button type='submit'>Delete</button>");
				pt.println("</form>");
				pt.println("</div>");
				pt.println("</body>");
				pt.println("</html>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
