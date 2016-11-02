package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.FootballField;
import model.dao.getDataDAO;

public class getDataBO {

	public static ArrayList<FootballField> getFootballField() {
		// TODO Auto-generated method stub
		ArrayList<FootballField> footballFieldArrayList = new ArrayList<FootballField>();
		ResultSet rs = getDataDAO.getFootballField();
		try {
			while(rs.next()){
				FootballField footballField = new FootballField(rs.getString(1));
				footballFieldArrayList.add(footballField);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return footballFieldArrayList;
	}

}
