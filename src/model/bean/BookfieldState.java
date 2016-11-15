/**
 * 
 */
package model.bean;

/**
 * @author pvhuy84
 *
 */
public class BookfieldState {
	String field;
	String status;
	String bookerPhonenumber;
	String booker;
	
	
	public BookfieldState() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BookfieldState(String field, String status, String bookerPhonenumber,String booker) {
		super();
		this.field = field;
		this.status = status;
		this.bookerPhonenumber=bookerPhonenumber;
		this.booker = booker;
	}


	public String getBookerPhonenumber() {
		return bookerPhonenumber;
	}


	public void setBookerPhonenumber(String bookerPhonenumber) {
		this.bookerPhonenumber = bookerPhonenumber;
	}


	public String getField() {
		return field;
	}


	public void setField(String field) {
		this.field = field;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getBooker() {
		return booker;
	}


	public void setBooker(String booker) {
		this.booker = booker;
	}
	
	
	
}
