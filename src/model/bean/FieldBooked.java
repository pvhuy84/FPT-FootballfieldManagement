/**
 * 
 */
package model.bean;

import java.sql.Date;

/**
 * @author pvhuy84
 *
 */
public class FieldBooked {
	private String field_id;
	private int timepacket_id;
	private String timepacketDescription;
	private Date day;
	private String status;
	public FieldBooked() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FieldBooked(String field_id, int timepacket_id, String timepacketDescription, Date day, String status) {
		super();
		this.field_id = field_id;
		this.timepacket_id = timepacket_id;
		this.timepacketDescription = timepacketDescription;
		this.day = day;
		this.status = status;
	}
	public String getField_id() {
		return field_id;
	}
	public void setField_id(String field_id) {
		this.field_id = field_id;
	}
	public String getTimepacketDescription() {
		return timepacketDescription;
	}
	public void setTimepacketDescription(String timepacketDescription) {
		this.timepacketDescription = timepacketDescription;
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
	public int getTimepacket_id() {
		return timepacket_id;
	}
	public void setTimepacket_id(int timepacket_id) {
		this.timepacket_id = timepacket_id;
	}
	
	
}
