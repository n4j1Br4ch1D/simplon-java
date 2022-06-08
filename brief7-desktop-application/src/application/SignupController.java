package application;

import java.io.IOException;

import dao.UserDao;
import entity.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;

public class SignupController {
	
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
	
	   public SignupController() {
	    }
	  
	   
	   public void userSignUp(ActionEvent event) throws IOException {
		   signUp(event);

	   }

       
    private void signUp(ActionEvent event) throws IOException {

        Main m = new Main();

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
        if(passwordField.getText().isEmpty()) {
            errorLabel.setText("Please enter a Password!");
            return;
        }
        UserDao userDao =  new UserDao();
        User user = new User(emailField.getText(), passwordField.getText(), fnameField.getText(), lnameField.getText(), false);

     	if(userDao.insert(user)) {
            errorLabel.setText("Sign-up Successfull!");
            errorLabel.setStyle("-fx-text-fill: #1cfd6c;");  
            m.changeScene("Dashboard.fxml");
     	}
}


}
