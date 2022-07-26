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
		User User = userDao.findById(id);
		return User;
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	public List<User> findAll() {
		List<User> Users = userDao.findAll();
		return Users;
	}

	public Long tasksCount() {
		return userDao.tasksCount();
	}

}
