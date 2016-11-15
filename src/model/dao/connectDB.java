package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class connectDB {
	protected static Connection connection = null;
	protected Statement statement = null;
	protected PreparedStatement preparedStatement = null;
	protected final String userTableName="[footballfield_management].[dbo].[user]";

	public connectDB() {
		try {
//			Connect mysql database
//			Class.forName("com.mysql.jdbc.Driver");
//			String address = "jdbc:mysql://127.0.0.1:3306/footballfield_management?useUnicode=true&characterEncoding=utf-8";
//			connection = DriverManager.getConnection(address, "root", "");
			
			
//			Connect sqlserver database
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String address="jdbc:sqlserver://127.0.0.1:1433;databaseName=footballfield_management";
			connection = DriverManager.getConnection(address, "sa", "12345");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() throws SQLException{
		if(statement!=null){
			statement.close();
		}
		if(preparedStatement!=null){
			preparedStatement.close();
		}
		if(connection!=null){
			connection.close();
		}
	}

}
