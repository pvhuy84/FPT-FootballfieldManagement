package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class getTimePacketForAdminDAO {

	public static ResultSet getTimePacket(String field, String date, String condition) {
		ResultSet rs = null;
		Connection conn = null;
		String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=FootballfieldManagement";
		String user = "sa";
		String pass = "12345";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			String sql="";
			switch(condition){
				case "1": 
					sql="select * from timepacket where nameoffield='"+field+"' and date = '"+date+"'";
					break;
				case "2": 
					sql="select * from timepacket where nameoffield='"+field+"' and date = '"+date+"' and isregister='0'";
					break;
				case "3": 
					sql="select * from timepacket where nameoffield='"+field+"' and date = '"+date+"' and isregister='1' and isconfirm='0'";
					break;
				case "4": 
					sql="select * from timepacket where nameoffield='"+field+"' and date = '"+date+"' and isregister='1' and isconfirm='1'";
					break;
			}
			rs = stmt.executeQuery(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
