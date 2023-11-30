
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CRUDservlet
 */
@WebServlet("/CRUDservlet")
public class CRUDservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    /**
     * @see HttpServlet#HttpServlet()
     */ 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rollno=request.getParameter("rollno");
		try {
		Connection con=JDBCconnection.getConnection();
		PreparedStatement st=con.prepareStatement("select * from student where rollno=?");
		st.setString(1, rollno);
		ResultSet rs=st.executeQuery();
		if(!rs.next()) {
			response.sendRedirect("Validate.html");
		}
		PreparedStatement st1=con.prepareStatement("select * from studentdetails where rollno=?");
		st1.setString(1, rollno);
		ResultSet rs1=st1.executeQuery();
		if(!rs1.next()) {
			response.sendRedirect("Validate.html");
		}
		PrintWriter out=response.getWriter();
		out.println("<table border="+2+">");
		out.println("<tr> <td>Name</td><td>"+rs.getString(1)+"</td></tr>");
		out.println("<tr> <td>RollNo</td><td>"+rs.getString(2)+"</td></tr>");
		out.println("<tr> <td>Date Of Birth</td><td>"+rs.getString(3)+"</td></tr>");
		out.println("<tr> <td>Year</td><td>"+rs1.getInt(2)+"</td></tr>");
		out.println("<tr> <td>Department</td><td>"+rs1.getString(3)+"</td></tr>");
		out.println("<tr> <td>Attendance</td><td>"+rs1.getInt(4)+"</td></tr>");
		out.println("<tr> <td>Grade</td><td>"+rs1.getString(5)+"</td></tr>");
		out.println("<tr> <td>Phone Number</td><td>"+rs.getString(4)+"</td></tr>");
		out.print("</table>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
