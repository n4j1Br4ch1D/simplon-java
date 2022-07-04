package services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.UserDao;
import model.User;

public class AuthService {
	private UserDao userDao = new UserDao();

	private User user;

	String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
	Pattern pattern = Pattern.compile(regex);

	public String signInService(String email, String password) {
		Matcher matcher = pattern.matcher(email);

		if (email == null || email.isBlank()) {
			return "{\"response\":\"Please enter a Email!\"}";
		}

		if (!matcher.matches()) {
			return "{\"response\":\"Please enter a Valid Email!\"}";
		}

		if (password == null || password.isEmpty()) {
			return "{\"response\":\"Please enter a Password!\"}";
		}

		if (userDao.signIn(email, password)) {

			return "{\"response\":\"true\"}";

		} else {
			return "{\"response\":\"Wrong Email or Password!\"}";
		}

	}
	
	public String signUpService(String email, String password, String rePassword, String fname, String lname) {

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

     	if(userDao.insert(user) != null) {
			return "{\"response\":\"true\"}";

     	}
		return "{\"response\":\"error, try again later!\"}";

	}
	
	public Boolean signOutService() {
		return true;
	}


}
