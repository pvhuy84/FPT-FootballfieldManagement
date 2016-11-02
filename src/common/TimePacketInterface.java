package common;

import model.bean.TimePacket;

public class TimePacketInterface {
	private String time = "";
	private String isRegister = "";
	private String isConfirm = "";
	private String phonenumberOfCustomer = "";
	private String price = "";

	public TimePacketInterface(TimePacket timePacket) {
		switch (timePacket.getIdPacket()) {
		case 1:
			time = "7h-8h";
			break;
		case 2:
			time = "8h-9h";
			break;
		case 3:
			time = "10h-11h";
			break;
		case 4:
			time = "11h-12h";
			break;
		case 5:
			time = "13h-14h";
			break;
		case 6:
			time = "14h-15h";
			break;
		case 7:
			time = "15h-16h";
			break;
		case 8:
			time = "16h-17h";
			break;
		case 9:
			time = "17h-18h";
			break;
		case 10:
			time = "18h-19h";
			break;
		case 11:
			time = "19h-20h";
			break;
		case 12:
			time = "20h-21h";
			break;
		case 13:
			time = "21h-22h";
			break;
		}
		
	}

}
