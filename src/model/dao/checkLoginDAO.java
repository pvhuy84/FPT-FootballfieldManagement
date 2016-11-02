package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class checkLoginDAO {

	public static int checkAccount(String username, String password) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Connection conn = null;
		try {
			String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=FootballfieldManagement";
			String user = "sa";
			String pass = "12345";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			System.out.println("input: "+username+", "+password);
			String sql = "select * from admin where username = '" + username + "' and password = '" + password + "'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return 2;
			} else {
				sql = "select * from customer where username = '" + username + "' and password = '" + password + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					return 1;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
