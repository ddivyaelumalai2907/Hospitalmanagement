package admin;

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
import javax.servlet.http.HttpSession;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pt = response.getWriter();
		response.setContentType("text/html");
		String m = "admin@gmail.com";
		String p = "admin1";
		String mail = request.getParameter("amail");
		String pass = request.getParameter("apsw");
		if(m.equals(mail) && p.equals(pass)) {
			response.sendRedirect("Adminpage.html");
		}
		else {
			pt.println("<html>");
			pt.println("<body>");
			pt.println("<form action='adminlogin.html' method='post'>");
			pt.println("<p>Incorrect Entery please try again!!</p>");
			pt.println("<button>BACK</button>");
			pt.println("</form>");
			pt.println("</body>");
			pt.println("</html>");
		}
	}

}
