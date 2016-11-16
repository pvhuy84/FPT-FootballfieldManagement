/**
 * 
 */
package model.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.bean.BookfieldState;

/**
 * @author pvhuy84
 *
 */
public class BookfieldStateDAO extends connectDB {

	// Get list BookfieldSate
	public ArrayList<BookfieldState> getListBookFieldState(Date day, int timepacket_id) {
		ArrayList<BookfieldState> listBookFieldState = new ArrayList<>();
		try {
			String sql = "SELECT  bookfield.field_id, bookfield.status, [USER].phonenumber, [user].name "
						+ " INTO #fieldbooked" + " FROM  bookfield" + " LEFT JOIN [user]"
						+ " ON bookfield.phonenumber = [user].phonenumber"
						+ " WHERE bookfield.day=? AND bookfield.timepacket_id=?;"
						+ " SELECT  field.field_id, #fieldbooked.status, [USER].phonenumber, [user].name" + " FROM field"
						+ " LEFT JOIN #fieldbooked" + " ON field.field_id = #fieldbooked.field_id" + " LEFT JOIN [user]"
						+ " ON #fieldbooked.phonenumber = [user].phonenumber;";
			preparedStatement = connection.prepareStatement(sql);
			System.out.println("Get list BookfieldSate: " + preparedStatement.toString());
			preparedStatement.setString(1, day.toString());
			preparedStatement.setInt(2, timepacket_id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				listBookFieldState.add(new BookfieldState(rs.getString("field_id"), rs.getString("status"),
						rs.getString("phonenumber"), rs.getString("name")));
			}
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBookFieldState;
	}

	public ArrayList<BookfieldState> getListBookFieldEmpty(Date day, int timepacket_id) {
		ArrayList<BookfieldState> listBookFieldEmpty = new ArrayList<>();
		try {
			String sql = "SELECT field.field_id FROM field WHERE field.field_id NOT IN ( SELECT bookfield.field_id FROM bookfield JOIN timepacket ON  bookfield.timepacket_id=timepacket.timepacket_id WHERE bookfield.day=? AND bookfield.timepacket_id=?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, day.toString());
			preparedStatement.setInt(2, timepacket_id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				listBookFieldEmpty.add(new BookfieldState(rs.getString("field_id"), "", "", ""));
			}
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBookFieldEmpty;
	}
}
