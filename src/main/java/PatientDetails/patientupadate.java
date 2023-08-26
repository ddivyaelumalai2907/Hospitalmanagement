package PatientDetails;

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

@WebServlet("/patientupadate")
public class patientupadate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pt = response.getWriter(); 
		
		String n = request.getParameter("name");
	    String p = request.getParameter("pass");
		String m = request.getParameter("mail");
		String ph = request.getParameter("phno");
		String b = request.getParameter("bg");
		String a = request.getParameter("age");
		String app = request.getParameter("ad");
		String dis = request.getParameter("dis");
		String num = request.getParameter("no");
		String satus = request.getParameter("sat");
		
		//String p = request.getParameter("patient");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","divya");
			PreparedStatement ps = con.prepareStatement("update patient set patientname=?,email=?,phone=?,bloodgroup=?,age=?,appointmentdate=?,disease=? ,doctorid=?,status=? where password=?");
			
					
			
			ps.setString(1,n);
			ps.setString(2,m);
			ps.setString(3,ph);
			ps.setString(4,b);
			ps.setString(5,a);
			ps.setString(6, app);
			ps.setString(7,dis);
			ps.setString(8, num);
			ps.setString(9, satus);
			ps.setString(10, p);
            ps.executeUpdate();
            
	        //con.close();
            
			
			pt.println("<html>");
			pt.println("<body>");
			pt.println("<head><link href='servlet.css' rel='stylesheet' type='text/css'></head>");
			pt.println("<form action='patient.html' method='post'>");
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
