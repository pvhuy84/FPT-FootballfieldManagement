/**
 * 
 */
package model.bean;

/**
 * @author pvhuy84
 *
 */
public class User {
	private String phonenumber;
	private String password;
	private String name;
	private int role;
	public User() {
	}
	public User(String phonenumber, String password, String name, int role) {
		this.phonenumber = phonenumber;
		this.password = password;
		this.name = name;
		this.role = role;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
}
