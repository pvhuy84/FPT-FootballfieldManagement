/**
 * 
 */
package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;


import model.bean.Timepacket;

/**
 * @author pvhuy84
 *
 */
public class TimepacketDAO extends connectDB {

	public ArrayList<Timepacket> getListTimepacket() {
		ArrayList<Timepacket> listTimepacket = new ArrayList<>();
		try {
			String sql="SELECT * FROM timepacket ORDER BY timepacket_id ASC";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				listTimepacket.add(new Timepacket(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTimepacket;
	}

}
