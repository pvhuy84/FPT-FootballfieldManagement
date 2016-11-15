/**
 * 
 */
package model.bo;

import model.dao.BookfieldDAO;

/**
 * @author pvhuy84
 *
 */
public class BookfieldBO {
	BookfieldDAO bookfieldDAO = new BookfieldDAO();
	
	public String book( String bookerPhonenumber, String field_id, int timepacket_id,String day) {
		return bookfieldDAO.book(bookerPhonenumber, field_id, timepacket_id, day);
	}
	
	public String confirm(String field_id, int timepacket_id, String day) {
		return bookfieldDAO.confirm(field_id, timepacket_id, day);
	}
	
	public String cancel(String field_id, int timepacket_id, String day) {
		return bookfieldDAO.cancel(field_id, timepacket_id, day);
	}
	
	public String delete(String field_id, int timepacket_id, String day) {
		return bookfieldDAO.delete(field_id, timepacket_id, day);
	}

}
