package bloodbank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adddonor
 */
@WebServlet("/Adddonor")
public class Adddonor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       PrintWriter pt = response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","divya");
			PreparedStatement ps = con.prepareStatement("insert into bloodbank values(?,?,?,?,?,?,?,?)");
			
			String id = request.getParameter("bbid");
			String name = request.getParameter("bname");
			String blood = request.getParameter("bg");
			String age = request.getParameter("bage");
			String mob = request.getParameter("mn");
			String mail = request.getParameter("bmail");
			String gender = request.getParameter("gender");
			String address = request.getParameter("address");

			
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, blood);
			ps.setString(4, age);
			ps.setString(5, mob);
			ps.setString(6, mail);
			ps.setString(7, gender);
			ps.setString(8, address);
			
			ps.executeUpdate();
	        con.close();
	        
	        pt.println("<html>");
		    pt.println("<head><link href='servlet.css' rel='stylesheet' type='text/css'></head>");
			pt.println("<body>");
			pt.println("<div class='f'>");
			pt.println("<form action='RetriveDonor' method='post'>");
			pt.println("<p>Sucessfully Added!!</p>");
			pt.println("<button onclick='RetriveDonor.java'>BACK</button>");
			pt.println("</form>");
			pt.println("</div>");
			pt.println("</body>");
			pt.println("</html>");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
