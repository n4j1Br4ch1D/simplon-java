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
	
	public List<User> listTrainers() {
		List<User> users = userService.findAll();
	    List<User> trainers = new ArrayList<User>();
//        for (User user: users) {
//            if (user.getRole().equals("trainer")) {
//            	trainers.add(user);
//            }
//        }
	    

        Predicate<User> byRole = user -> user.getRole().equals("trainer");
        trainers = users.stream().filter(byRole).collect(Collectors.toList());
        return trainers;
	}
	
	public List<User> listTalents() {
		List<User> users = userService.findAll();
	    List<User> trainers = new ArrayList<User>();
        Predicate<User> byRole = user -> user.getRole().equals("talent");
        trainers = users.stream().filter(byRole).collect(Collectors.toList());
        return trainers;
	}
}
