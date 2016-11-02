package model.bean;

import java.util.Date;

public class TimePacket {
	private int idPacket=0;
	private Date date;
	private String nameOfField = "";
	private int isRegister = 0;
	private int isConfirm = 0;
	private int price = 0;
	private String phonenumberofcustomer = "";

	public TimePacket(int idPacket, Date date, String nameOfField, int isRegister, int isConfirm, int price,
			String phonenumberofcustomer) {
		this.idPacket=idPacket;
		this.date = date;
		this.nameOfField = nameOfField;
		this.isRegister = isRegister;
		this.isConfirm = isConfirm;
		this.price = price;
		this.phonenumberofcustomer = phonenumberofcustomer;
	}

	public int getIdPacket() {
		return idPacket;
	}

	public void setIdPacket(int idPacket) {
		this.idPacket = idPacket;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getnameOfField() {
		return nameOfField;
	}

	public void setnameOfField(String nameOfField) {
		this.nameOfField = nameOfField;
	}

	public int getIsRegister() {
		return isRegister;
	}

	public void setIsRegister(int isRegister) {
		this.isRegister = isRegister;
	}

	public int getIsConfirm() {
		return isConfirm;
	}

	public void setIsConfirm(int isConfirm) {
		this.isConfirm = isConfirm;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPhonenumberofcustomer() {
		return phonenumberofcustomer;
	}

	public void setPhonenumberofcustomer(String phonenumberofcustomer) {
		this.phonenumberofcustomer = phonenumberofcustomer;
	}

}
