package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.UserDao;
import entity.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SignupController  implements Initializable {
	
    @FXML
    private Label errorLabel;
    @FXML
    private Button submitButton;
    @FXML
    private TextField emailField;	   
    @FXML
    private TextField fnameField;
    @FXML
    private TextField lnameField;
    @FXML
    private PasswordField passwordField;
    
    private UserDao userDao =  new UserDao();
    
    private User user;
    
    //private  boolean uniqueEmail = false;

	
	   public SignupController() {
	    }
	  
	   
//	   public void userSignUp(ActionEvent event) throws IOException {
//		   signUp(event);
//
//	   }
	   
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			submitButton.setOnAction( event -> {
				try {
					signUp(event);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        });
		}
		
	   
	   
       
    private void signUp(ActionEvent event) throws IOException {

        Main m = new Main();
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailField.getText());
        

        if(fnameField.getText().isEmpty()) {
            errorLabel.setText("Please enter a First Name!");
            return;
        }
        if(lnameField.getText().isEmpty()) {
            errorLabel.setText("Please enter a Last Name!");

            return;
        }
        if(emailField.getText().isEmpty()) {
            errorLabel.setText("Please enter a Email!");
            return;
        }
        

        if(emailField.getText().isEmpty()) {
            errorLabel.setText("Please enter a Email!");
            return;
        }
        if(!matcher.matches()) {
            errorLabel.setText("Please enter a Valid Email!");
            return;
        }
        if(userDao.checkEmail(emailField.getText())) {
            errorLabel.setText("Email Already Exist!");
            return;
        }
        
          
        if(passwordField.getText().isEmpty()) {
            errorLabel.setText("Please enter a Password!");
            return;
        }
        
       if(passwordField.getText().length() < 8 ) {
          errorLabel.setText("Password can't be less then 8 chars.");
          return;
      }

        
        user = new User(emailField.getText(), passwordField.getText(), fnameField.getText(), lnameField.getText(), false);

     	if(userDao.insert(user)) {
            errorLabel.setText("Sign-up Successfull!");
            errorLabel.setStyle("-fx-text-fill: #1cfd6c;");  
            loadSceneAndSendMessage();

     	}
}

     
    private void loadSceneAndSendMessage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent root = loader.load();

            DashboardController dashboardController = loader.getController();
            dashboardController.transferMessage(fnameField.getText()+ " " + lnameField.getText());
 
            
//            Main m = new Main();
//            m.changeScene("Dashboard.fxml");

         //   Stage stage = new Stage();
            Main.stg.setScene(new Scene(root));
            Main.stg.setTitle("AhanouOnline");
            Main.stg.show();
            

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }




}
