package main;

import java.time.LocalDateTime;
import java.util.List;

//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;
//import org.thymeleaf.templatemode.TemplateMode;
//import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import entity.User;
import repository.UserRepository;
import service.AuthService;
import service.UserService;
import org.hibernate.SessionFactory;

public class App {

	public static void main(String[] args) {
		
		        
		UserService userService = new UserService();
		UserRepository userRepository = new UserRepository();
		AuthService authService = new AuthService();
//        User newUser = new User("Latifa Amougay", "trainer", false, "latifa8@anmoon.ma", "password", 0);

		
//		 System.out.println("### Number of Taks is: "+userService.tasksCount());

		
		 System.out.println("### Sign-in - start:");
		 User admin = new User();
         admin.setEmail("leila@anmoon.ma");
         admin.setPassword("password");
		 User adminSignedIn = authService.signIn(admin);
		 System.out.println(adminSignedIn);
		 System.out.println("### Sign-in - end:");
		 
		 

			


        
//		System.out.println("### List Users- start:");
//		List<User> users = userService.findAll();
//		System.out.println("Users found are :");
//		for (User user : users) {
//			System.out.println("-" + user.toString());
//		}
//		System.out.println("### List Users - end:");
		
	
//		System.out.println("### List Trainers - start:");
//		List<User> trainers = userRepository.listTrainers();
//		System.out.println("Trainers found are :");
//		for (User trainer : trainers) {
//			System.out.println("-" + trainer.toString());
//		}
//		System.out.println("### List Trainers - end:");
		
		

//		 System.out.println("### Create - start:");
//		 userService.persist(newUser);
//		 System.out.println("### Create - end:");
		
//		System.out.println("### Read - start:");
//		int id1 = newUser.getId();
//		User viewUser = userService.findById(id1);
//		System.out.println("User found with id " + id1 + " is =>" + viewUser.toString());
//		System.out.println("### Read - end:");

		
//		System.out.println("### Update - start:");
//		newUser.setPassword("Tifa");
//		userService.update(newUser);
//		System.out.println("### Update - end:");
	
		
		
//		System.out.println("### Remove - start:");
//		int id1 = newUser.getId();
//	    userService.delete(id1);
//		System.out.println("Removed user with id " + id1 + ".");
//		System.out.println("### Remove - end:");
		
		
	}
}
