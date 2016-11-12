/**
 * 
 */
package model.bean;

/**
 * @author pvhuy84
 *
 */
public class Type {
	private int type;
	private int price;
	public Type() {
	}
	public Type(int type, int price) {
		this.type = type;
		this.price = price;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
