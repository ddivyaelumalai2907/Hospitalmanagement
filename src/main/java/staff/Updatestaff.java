package staff;

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


@WebServlet("/Updatestaff")
public class Updatestaff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pt = response.getWriter(); 
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","divya");
			PreparedStatement ps = con.prepareStatement("update staff set name=?,designation=?,email=?,joindate=?,shift=?,qualification=?,salary=? where id=?");
			
					
			
			
			String name = request.getParameter("sname");
			String dsign = request.getParameter("design");
			String mail = request.getParameter("smail");
			String joindate = request.getParameter("sjd");
			String sh = request.getParameter("sshift");
			String q = request.getParameter("quali");
			String s = request.getParameter("sal");
			String id = request.getParameter("sid");
			
			ps.setString(1, name);
			ps.setString(2, dsign);
			ps.setString(3, mail);
			ps.setString(4, joindate);
			ps.setString(5, sh);
			ps.setString(6, q);
			ps.setString(7, s);
			ps.setString(8, id);
			
            ps.executeUpdate();
            
	        //con.close();
			
            pt.println("<html>");
		    pt.println("<head><link href='servlet.css' rel='stylesheet' type='text/css'></head>");
			pt.println("<body>");
			pt.println("<div class='f'>");
			pt.println("<form action='Adminpage.html' method='post'>");
			pt.println("<p>Sucessfully Updated!!</p><br><br><br>");
			pt.println("<button onclick='Adminpage.html'>BACK</button>");
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
