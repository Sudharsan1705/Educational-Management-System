
import java.sql.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
	Connection con;
	PreparedStatement st;
    ResultSet rs;
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		int id=Integer.parseInt(request.getParameter("id"));
		String pwd=request.getParameter("password");
		
		
		try {
			con=JDBCconnection.getConnection();
			st=con.prepareStatement("select * from admin where id=?");
			st.setInt(1,id);
			rs=st.executeQuery();	
			int count=0;
			while(rs.next()) {
				if(rs.getString(3).equals(pwd)&&rs.getString(1).equals(name)) {
					count=1;
					response.sendRedirect("SignupTeacher.html");
				}
			}
			if(count==0) {
				response.sendRedirect("Validate.html");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		PrintWriter pw=response.getWriter();
		
		
		}

}
