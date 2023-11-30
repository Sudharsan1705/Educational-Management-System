
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServletTeacher
 */
@WebServlet("/LoginServletTeacher")
public class LoginServletTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		int id=Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("password");
		try {
		Connection con=JDBCconnection.getConnection();
		PreparedStatement st=con.prepareStatement("select * from teacher where id=?");
		st.setInt(1,id);
		ResultSet rs=st.executeQuery();
		if(rs.next()) {
			if(rs.getString(1).equals(name)&&rs.getString(3).equals(password)) {
				response.sendRedirect("Update.html");
			}
			else {
				response.sendRedirect("Validate.html");
			}
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
