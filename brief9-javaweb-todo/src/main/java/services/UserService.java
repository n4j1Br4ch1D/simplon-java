package services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.UserDao;
import model.User;

public class UserService {
	private UserDao userDao = new UserDao();

	private User user;
	

	String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
	Pattern pattern = Pattern.compile(regex);

	public String deleteUserService(int id) {
		
		
		if(userDao.delete(id)) {
			return "{\"response\":\"true\"}";
		}
		return "{\"response\":\"Error Plz ttry again later!\"}";
		
		
	}
	
	
	public String updateUserService(int id, String email, String password, String rePassword, String fname, String lname) {

        Matcher matcher = pattern.matcher(email);
        
        if(fname == null || fname.isBlank()) {
			return "{\"response\":\"Please enter a First Name!\"}";

        }
        
        if(lname == null || lname.isBlank()) {
			return "{\"response\":\"Please enter a Last Name!\"}";
        }
        
        if(email == null || email.isBlank()) {
			return "{\"response\":\"Please enter a Email!\"}";
        }
        
        if(!matcher.matches()) {
			return "{\"response\":\"Please enter a Valid Email!\"}";
        }
        
        if(userDao.checkEmail(email)) {
			return "{\"response\":\"Email Already Exist!\"}";

        }
        
          
        if(password == null || password.isBlank()) {
			return "{\"response\":\"Please enter a Password!\"}";
        }
        
       if(password.length() < 8 ) {
			return "{\"response\":\"Password can't be less then 8 chars!\"}";
      }

        
        user = new User(email, password, fname, lname, false);

     	if(userDao.update(id, user)) {
			return "{\"response\":\"true\"}";

     	}
     	
		return "{\"response\":\"error, try again later!\"}";


	}
}
