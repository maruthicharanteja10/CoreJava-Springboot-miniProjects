package com.employeeApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static Connection con;
	public static Connection createDBConnection() {
		String url = "jdbc:mysql://localhost:3306/employee_db";
		String user = "root";
		String psswd = "charantej@@18";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, psswd);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return con;
	}
}
