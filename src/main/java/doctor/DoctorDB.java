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

@WebServlet("/DoctorDB")
public class DoctorDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pt = response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","divya");
			PreparedStatement ps = con.prepareStatement("insert into doctor values(?,?,?,?,?,?)");
			
			String id = request.getParameter("did");
			String name = request.getParameter("dname");
			String dspec = request.getParameter("spec");
			String mail = request.getParameter("demail");
			String joindate = request.getParameter("date");
			String sal = request.getParameter("dsalary");
			
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, dspec);
			ps.setString(4, mail);
			ps.setString(5, joindate);
			ps.setString(6, sal);
			
			ps.executeUpdate();
	        con.close();
	        
	        pt.println("<html>");
		    pt.println("<head><link href='servlet.css' rel='stylesheet' type='text/css'></head>");
			pt.println("<body>");
			pt.println("<div class='f'>");
			pt.println("<form action='Doctor.html' method='post'>");
			pt.println("<p>Sucessfully Updated!!</p>");
			pt.println("<button>BACK</button>");
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
