package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.bean.TimePacket;
import model.dao.getTimePacketForAdminDAO;

public class getTimePacketForAdminBO {

	public static ArrayList<TimePacket> getTimePacket(String field, String date, String condition) {
		ArrayList<TimePacket> timePacketArrayList = new ArrayList<TimePacket>();
		ResultSet rs = null;
		rs = getTimePacketForAdminDAO.getTimePacket(field, date, condition);
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		Date dateDate=null;
		int  i =0;
		try {
			
			while (rs.next()) {
				dateDate=df.parse(rs.getString(2));
				TimePacket timePacket = new TimePacket(rs.getInt(1), dateDate, rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7));
				timePacketArrayList.add(timePacket);
				i++;
			}
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return timePacketArrayList;
	}

}
