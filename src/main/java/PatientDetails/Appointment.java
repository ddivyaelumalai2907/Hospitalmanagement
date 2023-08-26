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

@WebServlet("/Appointment")
public class Appointment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
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
				pt.println("<div class='f'>");
				pt.println("<h3>Fix Appointment</h3><br><br>");
				pt.println("<form action='Apponitmentpreview' method='post'");
				pt.println("<label>Username</label><br>");
				pt.println("<input type='text' name='name'  value='"+rs.getString(1)+"'/><br><br>");
				pt.println("<label>Password</label><br>");
				pt.println("<input type='text' name='pass'  value='"+rs.getString(2)+"'/><br><br>");
				pt.println("<label>Email id</label><br>");
				pt.println("<input type='text' name='mail'  value='"+rs.getString(3)+"'/><br><br>");
				pt.println("<label>Phone</label><br>");
				pt.println("<input type='text' name='phno' value='"+rs.getString(4)+"'/><br><br>");
				pt.println("<label>BloodGroup</label><br>");
				pt.println("<input type='text' name='bg' value='"+rs.getString(5)+"'/><br><br>");
				pt.println("<label>Age</label><br>");
				pt.println("<input type='text' name='age' value='"+rs.getString(6)+"'/><br><br>");
				pt.println("<label>Apponitment date</label><br>");
				pt.println("<input type='date' name='ad'/><br><br>");
				pt.println("<label>Disease</label><br>");
				pt.println("<input type='text' name='dis'/><br><br>");
				pt.println("<label>Doctorid</label><br>");
				pt.println("<input type='number' name='no'/><br><br>");
				pt.println("<textarea rows=\"5\" cols=\"25\">101-general medicine&#13;&#10;102-cardiologist&#13;&#10;103-neurologist&#13;&#10;104-gynaecologist&#13;&#10;105-oncologist</textarea> <br><br>");
				pt.println("<label>Status</label><br>");
				pt.println("<input type='text' name='sat'/><br>");
				pt.println("<button type='submit' onclick='Apponitmentpreview'>Update</button>");
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
