/**
 * 
 */
package model.bean;

/**
 * @author pvhuy84
 *
 */
public class Field {
	private String field_id;
	private String status;
	public Field() {
	}
	public Field(String field_id, String status) {
		this.field_id = field_id;
		this.status = status;
	}
	public String getField_id() {
		return field_id;
	}
	public void setField_id(String field_id) {
		this.field_id = field_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
