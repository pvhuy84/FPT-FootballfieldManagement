/**
 * 
 */
package model.bo;

import java.sql.Date;
import java.util.ArrayList;

import model.bean.BookfieldState;
import model.dao.BookfieldStateDAO;

/**
 * @author pvhuy84
 *
 */
public class BookfieldStateBO {

	public ArrayList<BookfieldState> getListBookFieldState(Date day, int timepacket_id) {
		return new BookfieldStateDAO().getListBookFieldState(day, timepacket_id);
	}

}
