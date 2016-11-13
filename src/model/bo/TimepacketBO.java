/**
 * 
 */
package model.bo;

import java.util.ArrayList;

import model.bean.Timepacket;
import model.dao.TimepacketDAO;

/**
 * @author pvhuy84
 *
 */
public class TimepacketBO {
	TimepacketDAO timepacketDAO  =new TimepacketDAO();
	public ArrayList<Timepacket> getListTimepacket() {
		return  timepacketDAO.getListTimepacket();
	}

}
