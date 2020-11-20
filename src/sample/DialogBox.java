package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogBox  implements Initializable {
    @FXML
    private Button ok_button;

    @FXML
    private Label message_label;

    String err;

    public void setErr(String error){
        this.err = error;
    }


    public void HideAddProductsForm() {
        Stage stage = (Stage) ok_button.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        message_label.setText(err);
    }
}
