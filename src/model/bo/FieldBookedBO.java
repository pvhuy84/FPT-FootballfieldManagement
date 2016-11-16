/**
 * 
 */
package model.bo;

import java.util.ArrayList;

import model.bean.FieldBooked;
import model.bean.User;
import model.dao.FieldBookedDAO;

/**
 * @author pvhuy84
 *
 */
public class FieldBookedBO {

	public ArrayList<FieldBooked> getListFieldBooked(User user) {
		// TODO Auto-generated method stub
		return new FieldBookedDAO().getListFieldBooked(user);
	}

}
