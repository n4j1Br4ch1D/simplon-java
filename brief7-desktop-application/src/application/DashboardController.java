package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Button logout;
    @FXML
    private Text displayName;

    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Signup.fxml");

    }
     
    public void transferMessage(String message) {
    	displayName.setText(message);
    }
}