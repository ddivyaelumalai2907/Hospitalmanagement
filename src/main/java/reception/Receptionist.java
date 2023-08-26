package reception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Receptionist")
public class Receptionist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pt = response.getWriter();
		response.setContentType("text/html");
		String m = "reception@gmail.com";
		String p = "MNSreception";
		String mail = request.getParameter("rmail");
		String pass = request.getParameter("rpsw");
		if(m.equals(mail) && p.equals(pass)) {
			response.sendRedirect("receptionpage.html");
		}
		else {
			pt.println("<html>");
			pt.println("<body>");
			pt.println("<form action='reception.html' method='post'>");
			pt.println("<p>Incorrect Entery please try again!!</p>");
			pt.println("<button>BACK</button>");
			pt.println("</form>");
			pt.println("</body>");
			pt.println("</html>");
		}
	}

}
