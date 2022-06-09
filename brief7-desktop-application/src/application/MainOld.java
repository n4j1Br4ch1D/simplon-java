package application;


import dao.UserDao;
import entity.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainOld extends Application {
	

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("AhanouOnline Sign-up Form");
        GridPane gridPane = createRegistrationFormPane();
        addUIControls(gridPane);
        Scene scene = new Scene(gridPane, 800, 800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(15, 15, 15, 15));
        gridPane.setHgap(25);
        gridPane.setVgap(10);
        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
    	
        Image image = new Image("File:src/ahanou.png");  
        
        ImageView pic = new ImageView();
        pic.setFitWidth(100);
        pic.setFitHeight(100);
        pic.setImage(image);
        
      
        gridPane.getChildren().add(pic);

        
        Label headerLabel = new Label("Sign-up Now");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gridPane.add(headerLabel, 0,0,1,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);

        GridPane.setMargin(headerLabel, new Insets(20, 0, 10,0));
         

//(0, 0)	(1, 0)	(2, 0)
//(2, 1)	(1, 1)	(0, 1)
//(2, 2)	(1, 2)	(0, 2)


        TextField fnameField = new TextField();
        fnameField.setPrefHeight(40);
        fnameField.setPromptText("First Name:");
        fnameField.setPrefWidth(400);

        gridPane.add(fnameField, 1, 0);


        TextField lnameField = new TextField();
        lnameField.setPrefHeight(40);    
        lnameField.setPromptText("Last Name:");
        lnameField.setPrefWidth(400);

        gridPane.add(lnameField, 2,0);


        TextField emailField = new TextField();
        emailField.setPrefHeight(40);
        emailField.setPromptText("Email:");
        emailField.setPrefWidth(400);

        gridPane.add(emailField, 1, 2);


        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        passwordField.setPromptText("Password:");
        passwordField.setPrefWidth(400);

        gridPane.add(passwordField, 2, 3);
        gridPane.setStyle("-fx-background-color: #1cfd6c;-fx-alignment: CENTER;"); 

         
        Button submitButton = new Button("Sign Up");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(900);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(fnameField.getText().isEmpty()) {
                    alert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your First Name!");
                    return;
                }
                if(lnameField.getText().isEmpty()) {
                    alert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your Last  Name!");
                    return;
                }
                if(emailField.getText().isEmpty()) {
                    alert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your email!");
                    return;
                }
                if(passwordField.getText().isEmpty()) {
                   alert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a password!");
                    return;
                }
                UserDao userDao =  new UserDao();
                User user = new User(emailField.getText(), passwordField.getText(), fnameField.getText(), lnameField.getText(), false);

	         	if(userDao.insert(user)) {
		            alert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "You Signed up Successfuly!", "Welcome To Ahanou " + fnameField.getText() + " " + lnameField.getText());

		       }
   
            }
        });
    }

    private void alert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

}