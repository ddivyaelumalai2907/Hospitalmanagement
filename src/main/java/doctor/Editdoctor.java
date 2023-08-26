package doctor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Editdoctor")
public class Editdoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pt = response.getWriter(); 
		
		String doctorid = request.getParameter("docid");
	    String name = request.getParameter("dname");
		String specialist = request.getParameter("spec");
		String email = request.getParameter("mail");
		String joindate = request.getParameter("jd");
		String salary = request.getParameter("sal");
		
		//String p = request.getParameter("patient");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","divya");
			PreparedStatement ps = con.prepareStatement("update doctor set name=?,specialist=?,email=?,joindate=?,salary=? where doctorid=?");
			
					
			
			ps.setString(1,name);
			ps.setString(2,specialist);
			ps.setString(3,email);
			ps.setString(4,joindate);
			ps.setString(5,salary);
			ps.setString(6,doctorid);
			
            ps.executeUpdate();
            
	        //con.close();
            pt.println("<html>");
		    pt.println("<head><link href='servlet.css' rel='stylesheet' type='text/css'></head>");
			pt.println("<body>");
			pt.println("<div class='f'>");
			pt.println("<form action='RetriveDoctor' method='post'>");
			pt.println("<p>Sucessfully Update!!</p>");
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
