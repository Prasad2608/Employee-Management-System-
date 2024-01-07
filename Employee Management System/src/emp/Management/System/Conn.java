package emp.Management.System;

import java.sql.*;

public class Conn {
	
	Connection c;
	Statement s;
	
	public Conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_management_system","root", "root");
			s = c.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String []args) {
		
	}
}
