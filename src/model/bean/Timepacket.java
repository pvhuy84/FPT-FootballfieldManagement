/**
 * 
 */
package model.bean;

/**
 * @author pvhuy84
 *
 */
public class Timepacket {
	private int timepacket_id;
	private String description;
	private int type;
	public Timepacket() {
	}
	
	public Timepacket(int timepacket_id, String description, int type) {
		super();
		this.timepacket_id = timepacket_id;
		this.description = description;
		this.type = type;
	}

	public int getTimepacket_id() {
		return timepacket_id;
	}
	public void setTimepacket_id(int timepacket_id) {
		this.timepacket_id = timepacket_id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
