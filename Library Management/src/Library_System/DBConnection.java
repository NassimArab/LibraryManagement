package Library_System;

import java.sql.*;

public class DBConnection   {
	
	
	public static Connection getconnection() throws SQLException
	{
		
		return DriverManager.getConnection("jdbc:mysql://localhost/librarydatabases", "root", "");
		
		
	}

}
