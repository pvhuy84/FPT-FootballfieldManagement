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
	
//	Get list BookfieldSate
	public ArrayList<BookfieldState> getListBookFieldState(Date day, int timepacket_id) {
		ArrayList<BookfieldState> listBookFieldState = new ArrayList<>();
		try {
			String sql = "SELECT  field.field_id, bookfield.status, " + userTableName + ".phonenumber, " 
					+ userTableName + ".name  FROM field LEFT JOIN bookfield ON field.field_id = bookfield.field_id LEFT JOIN "
					+ userTableName + " ON bookfield.phonenumber = " + userTableName + ".phonenumber";
			preparedStatement = connection.prepareStatement(sql);
			System.out.println("Get list BookfieldSate: " + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				listBookFieldState.add(
						new BookfieldState(rs.getString("field_id"), rs.getString("status"), rs.getString("phonenumber"), rs.getString("name")));
			}
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBookFieldState;
	}
}
