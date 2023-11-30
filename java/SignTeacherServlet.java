

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignTeacherServlet
 */
@WebServlet("/signTeacher")
public class SignTeacherServlet extends HttpServlet {
	Connection con;
	PreparedStatement st;
    ResultSet rs;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		int id=Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("password");
		try {
			con=JDBCconnection.getConnection();
			st=con.prepareStatement("insert into teacher values(?,?,?)");
			st.setString(1,name);
			st.setInt(2, id);
			st.setString(3, password);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("Success.html");
	}

}
