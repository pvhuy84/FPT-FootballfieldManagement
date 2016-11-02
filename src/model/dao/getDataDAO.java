package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class getDataDAO {

	public static ResultSet getFootballField() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Connection conn = null;
		try {
			String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=FootballfieldManagement";
			String user="sa";
			String pass="12345";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection(url,user,pass);
			Statement stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from footballfield");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}

}
