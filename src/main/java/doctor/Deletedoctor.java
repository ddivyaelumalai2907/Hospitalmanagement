package doctor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Deletedoctor")
public class Deletedoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pt = response.getWriter();
	
		String d = request.getParameter("docid");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","divya");
			PreparedStatement ps = con.prepareStatement("delete from doctor where doctorid=?");
			ps.setString(1, d);
		    ps.executeUpdate();
			
		    pt.println("<html>");
		    pt.println("<head><link href='servlet.css' rel='stylesheet' type='text/css'></head>");
			pt.println("<body>");
			pt.println("<div class='f'>");
			pt.println("<form action='RetriveDoctor' method='post'>");
			pt.println("<p>Sucessfully Deleted!!</p>");
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
