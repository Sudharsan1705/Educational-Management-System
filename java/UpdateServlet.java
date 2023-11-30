
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
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
		else {
			response.sendRedirect("Insert.html");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
