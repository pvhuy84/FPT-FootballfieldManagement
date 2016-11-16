package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.User;

public class UserDAO extends connectDB {

	// Check exist user in database
	public User checkUser(String phonenumber, String password) {
		User user = null;
		ResultSet rs = null;
		try {
			statement = connection.createStatement();
			System.out.println("input: " + phonenumber + ", " + password);
			String sql = "select * from "+ userTableName +" where phonenumber = '" + phonenumber + "' and password = '" + password
					+ "'";
			rs = statement.executeQuery(sql);
			if (rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	// Add user
	public String addUser(User user) {
		String status = "";
		String sql = "";
		try {
			// Check phone number exist or not
			sql = "select * from "+ userTableName +"  where phonenumber=? and password=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getPhonenumber());
			preparedStatement.setString(2, user.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				status = "Phone number was existed!";
			}

			// Add user to database
			sql = "insert into "+ userTableName +"  values(?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getPhonenumber());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setInt(4, user.getRole());
			if (!preparedStatement.execute()) {
				status = "success";
			} else {
				status = "Database error";
			}
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
			status = "Database error";
		}
		return status;
	}

	public ArrayList<User> getListCustomer() {
		ArrayList<User> listCustomer = new ArrayList<>();
		try {
			String sql = "select * from "+ userTableName +" where role = 0";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				listCustomer.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			preparedStatement.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listCustomer;
	}

	public String deleteUser(String userphonenumber) {
		String deleteReport="Delete not success";
		try {
			statement = connection.createStatement();
			String sql = "DELETE FROM bookfield WHERE phonenumber='"+userphonenumber+"'";
			if(!statement.execute(sql)) {
				sql = "DELETE FROM "+userTableName+" WHERE phonenumber='"+userphonenumber+"'";
				if(!statement.execute(sql)) {
					deleteReport="Delete success";
				}
			} 			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteReport;
	}
}
