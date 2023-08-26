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


@WebServlet("/Apponitmentpreview")
public class Apponitmentpreview extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			response.setContentType("text/html");
			PrintWriter pt = response.getWriter();
			String name = request.getParameter("uname");
			String pass = request.getParameter("pass");
			String mail = request.getParameter("email");
			String phno = request.getParameter("phone");
			String blood = request.getParameter("blood");
			String age = request.getParameter("age");
			String ad = request.getParameter("ad");
			String disease = request.getParameter("dis");
			String  num = request.getParameter("no");
			String satus = request.getParameter("sat");
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","divya");
				PreparedStatement ps = con.prepareStatement("update patient set appointmentdate=?,disease=?,doctorid=?,status=? where password=?");
			
				
		        ps.setString(1, ad);
		        ps.setString(2, disease);
                ps.setString(3, num);
                ps.setString(4, satus);
			    ps.setString(5, pass);
				ps.executeUpdate();
		            
			        //con.close();
					
					pt.println("<html>");
					pt.println("<body>");
					pt.println("<form action='patient.html' method='get'>");
					pt.println("<p>Sucessfully Update!!</p>");
					pt.println("<button type='submit'>BACK</button>");
					pt.println("</form>");
					pt.println("</body>");
					pt.println("</html>");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}

}
