package main;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;


/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private UserDao userDao =  new UserDao();
    
    private User user;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//        if(emailField.getText().isEmpty()) {
//            errorLabel.setText("Please enter a Email!");
//            return;
//        }
//        
//
//        if(emailField.getText().isEmpty()) {
//            errorLabel.setText("Please enter a Email!");
//            return;
//        }
//        if(!matcher.matches()) {
//            errorLabel.setText("Please enter a Valid Email!");
//            return;
//        }
//        
//          
//        if(passwordField.getText().isEmpty()) {
//            errorLabel.setText("Please enter a Password!");
//            return;
//        }
        
        
//        user = new User(emailField.getText(), passwordField.getText(), , false);

     	if(1==2) {
//     		userDao.signIn(request.getParameter("email"), request.getParameter("password"))
//            errorLabel.setText("Sign-in Successfull!");
//            errorLabel.setStyle("-fx-text-fill: #1cfd6c;");  
//            loadSceneAndSendMessage();
    		response.getWriter().append("Served at: ").append(request.getContextPath());


     	}else {

    		response.getWriter().append("Wrong Email or Password! " + userDao.signIn("email", "password")).append(request.getContextPath());

     	}
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
