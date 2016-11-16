/**
 * 
 */
package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.bean.BookfieldState;
import model.bean.FieldBooked;
import model.bean.User;

/**
 * @author pvhuy84
 *
 */
public class FieldBookedDAO extends connectDB {

	public ArrayList<FieldBooked> getListFieldBooked(User user) {
		ArrayList<FieldBooked> listFieldBooked = new ArrayList<>();
		try {
			String sql = "SELECT bookfield.field_id, bookfield.timepacket_id, timepacket.description, bookfield.day, bookfield.status FROM bookfield JOIN timepacket ON  bookfield.timepacket_id=timepacket.timepacket_id WHERE bookfield.phonenumber=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getPhonenumber());
			System.out.println("List Field booked: " + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				listFieldBooked.add(new FieldBooked(rs.getString("field_id"), rs.getInt("timepacket_id"), rs.getString("description"), rs.getDate("day"), rs.getString("status")));
			}
			preparedStatement.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listFieldBooked;
	}

}
