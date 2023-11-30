
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String rollno=request.getParameter("rollno");
		String dob=request.getParameter("date");
		int year=Integer.parseInt(request.getParameter("year"));
		String dept=request.getParameter("dept");
		int attend=Integer.parseInt(request.getParameter("attend"));
		String grade=request.getParameter("grade");
		String phoneno=request.getParameter("phoneno");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sudharsan","admin");
		PreparedStatement st=con.prepareStatement("select * from student where rollno=?");
		st.setString(1, rollno);
		ResultSet rs=st.executeQuery();
		if(!rs.next()) {
			PreparedStatement st1=con.prepareStatement("insert into student values(?,?,?,?)");
			st1.setString(1, name);
			st1.setString(2, rollno);
			st1.setString(3, dob);
			st1.setString(4, phoneno);
			PreparedStatement st2=con.prepareStatement("insert into studentdetails values(?,?,?,?,?)");
			st2.setString(1, rollno);
			st2.setInt(2, year);
			st2.setString(3, dept);
			st2.setInt(4, attend);
			st2.setString(5, grade);
			response.sendRedirect("Success.html");
		}
		else {
			response.sendRedirect("Validate.html");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
