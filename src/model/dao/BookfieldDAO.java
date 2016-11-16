/**
 * 
 */
package model.dao;

/**
 * @author pvhuy84
 *
 */
public class BookfieldDAO extends connectDB {

	public String book(String bookerPhonenumber, String field_id, int timepacket_id,String day) {
		String actionReport="Book not success";
		System.out.println("DATA: " + bookerPhonenumber + ", " + field_id + ", " + timepacket_id + ", " + day);
		try {
			String sqlDay = day.substring(6, day.length()) + "-" + day.substring(3, 5) + "-" + day.substring(0, 2);
			String sql="SELECT * FROM bookfield WHERE field_id=? AND day=? AND timepacket_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, field_id);
			preparedStatement.setString(2, sqlDay);
			preparedStatement.setInt(3, timepacket_id);
			if(preparedStatement.executeQuery().next()) {
				actionReport="Book not success (exist)";
			} else {
				String status="unconfirmed";
				sql="INSERT INTO bookfield(phonenumber, field_id, timepacket_id, day, status) VALUES (?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, bookerPhonenumber);
				preparedStatement.setString(2, field_id);
				preparedStatement.setInt(3, timepacket_id);
				preparedStatement.setString(4, sqlDay);
				preparedStatement.setString(5, status);
				if(!preparedStatement.execute()) {
					actionReport="Book field success";
				} else {
					actionReport="Book not success";
				}
			}
			preparedStatement.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return actionReport;
	}
	
	public String confirm(String field_id, int timepacket_id, String day) {
		String actionReport="Confirm not success";
		String sqlDay = day.substring(6, day.length()) + "-" + day.substring(3, 5) + "-" + day.substring(0, 2);
		System.out.println("cf: "+field_id+", "+timepacket_id+", " +sqlDay);
		String status="confirmed";
		try {
			String sql="UPDATE bookfield SET status=? WHERE field_id=? AND day=? AND timepacket_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, status);
			preparedStatement.setString(2, field_id);
			preparedStatement.setString(3, sqlDay);
			preparedStatement.setInt(4, timepacket_id);
			if(preparedStatement.execute()) {
				actionReport="Confirm not success";
			} else {
				actionReport="Confirm success";
			}
			preparedStatement.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return actionReport;
	}
	
	public String cancel(String field_id, int timepacket_id, String day) {
		String actionReport="Cancel not success";
		String sqlDay = day.substring(6, day.length()) + "-" + day.substring(3, 5) + "-" + day.substring(0, 2);
		String status="unconfirmed";
		try {
			String sql="UPDATE bookfield SET status=? WHERE field_id=? AND day=? AND timepacket_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, status);
			preparedStatement.setString(2, field_id);
			preparedStatement.setString(3, sqlDay);
			preparedStatement.setInt(4, timepacket_id);
			if(preparedStatement.execute()) {
				actionReport="Cancel not success";
			} else {
				actionReport="Cancel success";
			}
			preparedStatement.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return actionReport;
	}
	
	public String delete(String field_id, int timepacket_id, String day) {
		String actionReport="Delete not success";
		String sqlDay = day.substring(6, day.length()) + "-" + day.substring(3, 5) + "-" + day.substring(0, 2);
		try {
			String sql="DELETE FROM bookfield WHERE field_id=? AND day=? AND timepacket_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, field_id);
			preparedStatement.setString(2, sqlDay);
			preparedStatement.setInt(3, timepacket_id);
			if(preparedStatement.execute()) {
				actionReport="Delete not success";
			} else {
				actionReport="Delete success";
			}
			preparedStatement.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return actionReport;
	}

}
