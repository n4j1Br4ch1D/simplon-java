package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Task;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	
    public static Stage stg;

    @Override
	public void start(Stage primaryStage) {


	    stg = primaryStage;

		try {
	    	primaryStage.getIcons().add(new Image("resources/doer-icon.png"));
	        primaryStage.setTitle("Doer Tasks Manager Sign-in");
	        primaryStage.setResizable(false);
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../view/Dashboard.fxml"));
//			Scene scene = new Scene(root,600,400);
			Scene scene = new Scene(root,950,550);

			scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
    public static void main(String[] args) {
        launch(args);
    }
	
    
    
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
    }
    

}
