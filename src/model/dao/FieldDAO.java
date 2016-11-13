package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.bean.Field;

public class FieldDAO extends connectDB {

	public ArrayList<Field> getListField() {
		ArrayList<Field> listField = new ArrayList<>();
		try {
			String sql="select * from field";
			preparedStatement=connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				listField.add(new Field(rs.getString(1), rs.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listField;
	}

}
