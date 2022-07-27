package service;

import java.util.List;


import dao.UserDao;
import entity.User;

public class UserService {

	private static UserDao userDao;

	public UserService() {
		userDao = new UserDao();
	}

	public void persist(User entity) {
		userDao.persist(entity);
	}

	public void update(User entity) {
		userDao.update(entity);
	}

	public User findById(int id) {
		User user = userDao.findById(id);
		return user;
	}

	public void delete(int id) {
		User user = userDao.findById(id);
		if(!user.getRole().equals("admin")) {
			userDao.delete(id);
		}
	}

	public List<User> findAll() {
		List<User> users = userDao.findAll();
		return users;
	}

	public Long tasksCount() {
		return userDao.tasksCount();
	}

}
