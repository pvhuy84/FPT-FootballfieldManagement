/**
 * 
 */
package model.bean;

import java.sql.Date;

/**
 * @author pvhuy84
 *
 */
public class Bookfield {
	private String phonenumber;
	private String field_id;
	private int timepacket_id;
	private Date day;
	private String status;
	public Bookfield() {
	}
	public Bookfield(String phonenumber, String field_id, int timepacket_id, Date day, String status) {
		this.phonenumber = phonenumber;
		this.field_id = field_id;
		this.timepacket_id = timepacket_id;
		this.day = day;
		this.status = status;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getField_id() {
		return field_id;
	}
	public void setField_id(String field_id) {
		this.field_id = field_id;
	}
	public int getTimepacket_id() {
		return timepacket_id;
	}
	public void setTimepacket_id(int timepacket_id) {
		this.timepacket_id = timepacket_id;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
