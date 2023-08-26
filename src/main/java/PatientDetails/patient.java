package PatientDetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

import com.mysql.cj.protocol.Resultset;

@WebServlet("/patient")
public class patient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pt  = response.getWriter();
		

		String name = request.getParameter("uname");
		String pass = request.getParameter("psw");
		String mail = request.getParameter("email");
		String phno = request.getParameter("phone");
		String blood = request.getParameter("blood");
		String age = request.getParameter("age");
		String ad = request.getParameter("ad");
		String disease = request.getParameter("disease");
		String did = request.getParameter("did");
		String status = request.getParameter("sat");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","divya");
			PreparedStatement ps = con.prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?)");
			
		
			ps.setString(1, name);
	        ps.setString(2, pass);
	        ps.setString(3, mail);
	        ps.setString(4, phno);
	        ps.setString(5, blood);
	        ps.setString(6, age);
	        ps.setString(7, ad);
	        ps.setString(8, disease);
	        ps.setString(9, did);
	        ps.setString(10, status);
	        ps.addBatch();
	        ps.executeBatch();
	        ps.clearBatch();
	        con.close();
	        
	    	pt.println("<html>");
			pt.println("<body>");
			pt.println("<head><link href='servlet.css' rel='stylesheet' type='text/css'></head>");
			pt.println("<form action='patient.html's>");
			pt.println("<p>Sucesss!! for further update/information you can Login else exit</p>");
			pt.println("<button class='bp1'>Login</button>");
			pt.println("</form>");
			pt.println("<form action='welcome.html's>");
			pt.println("<button class='bp2'>Exit</button>");
			pt.println("</form>");
			pt.println("</body>");
			pt.println("</html>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
