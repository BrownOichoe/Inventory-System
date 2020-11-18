package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DialogBox {
    @FXML
    private Button ok_button;

    @FXML
    private Label message_label;




    public void HideAddProductsForm() {
        Stage stage = (Stage) ok_button.getScene().getWindow();
        stage.close();
    }

}
