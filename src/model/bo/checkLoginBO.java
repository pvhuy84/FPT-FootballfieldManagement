package model.bo;

import model.dao.checkLoginDAO;

public class checkLoginBO {

	public static int checkAccount(String username, String password) {
		// TODO Auto-generated method stub
		return checkLoginDAO.checkAccount(username, password);
	}

}
