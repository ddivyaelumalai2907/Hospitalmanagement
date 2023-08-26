package doctor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Doctorvalidation")
public class Doctorvalidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pt = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","divya");
			String id = request.getParameter("did");
			String mail = request.getParameter("mail");
			
			PreparedStatement ps = con.prepareStatement("select doctorid from doctor where doctorid=? and email= ?");
			ps.setString(1, id);
			ps.setString(2, mail);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				response.sendRedirect("Getdoctorbyid?id="+rs.getString(1));
				
			}
			else {
				pt.println("<font color=red>Login failed");
				RequestDispatcher rd = request.getRequestDispatcher("appointment.html");
				rd.forward(request, response);
			}
		    
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
