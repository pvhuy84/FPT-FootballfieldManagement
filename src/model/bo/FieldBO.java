/**
 * 
 */
package model.bo;

import java.util.ArrayList;

import model.bean.Field;
import model.bean.Timepacket;
import model.dao.FieldDAO;

/**
 * @author pvhuy84
 *
 */
public class FieldBO {
	FieldDAO fieldDAO = new FieldDAO();
	public ArrayList<Field> getListField() {
		return fieldDAO.getListField();
	}
	
}
