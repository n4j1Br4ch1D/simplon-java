package repository;

import java.util.ArrayList;
import java.util.List;
import dao.UserDao;
import entity.User;
import service.UserService;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserRepository {

	
	private static UserDao userDao;
	UserService userService = new UserService();

	public UserRepository() {
		// TODO Auto-generated constructor stub
	    userDao = new UserDao();
	    
	}
	
	public List<User> listEmployees() {
		List<User> users = userService.findAll();
	    List<User> employees = new ArrayList<User>();
//        for (User user: users) {
//            if (user.getRole().equals("employee")) {
//            	employees.add(user);
//            }
//        }
	    

        Predicate<User> byRole = user -> user.getRole().equals("employee");
        employees = users.stream().filter(byRole).collect(Collectors.toList());
        return employees;
	}
}
