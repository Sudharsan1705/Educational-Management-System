	import java.sql.*;
	public class JDBCconnection {
		private static Connection con;
	public static Connection getConnection()  {
		con=null;
		try {
			if(con==null) {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sudharsan","admin");
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return con;
		
	}
	
	}
