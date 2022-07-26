package service;

import dao.UserDao;
import entity.User;

public class AuthService {

	private static UserDao userDao;

	public AuthService() {
		// TODO Auto-generated constructor stub
	    userDao = new UserDao();
	}
	
	public User signIn(User user) {
		User admin = userDao.signIn(user);
		return admin;
	}
	
	public void signOut(User user) {
		//
	}

}
