package model.bo;

import model.bean.User;
import model.dao.UserDAO;

public class UserBO {
	UserDAO userDAO = new UserDAO();
	public User checkUser(String phonenumber, String password) {
		return userDAO.checkUser(phonenumber, password);
	}
	
	public String addUser(User user) {
		return userDAO.addUser(user);
	}
}
