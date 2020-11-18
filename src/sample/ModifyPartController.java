/**
 *
 *
 *  author: Brown oichoe
 *
 *
 *  The Modify Part form
 *  * •  The text fields populate with the data from the chosen part.
 *  * •  The In-House and Outsourced radio buttons switch the bottom label to the correct value (Machine ID or Company Name) and swap In-House parts and Outsourced parts. When new objects need to be created after the Save button is clicked, the part ID should be retained.
 *  * •  The user can modify data values in the text fields sent from the Main form except the part ID.
 *  * •  After saving modifications to the part, the user is automatically redirected to the Main form.
 *  * •  Canceling or exiting this form redirects users to the Main form.
 *  ----------------------------------************-----------------------------------------------
 *  • Min should be less than Max; and Inv should be between those two values.
 *  • The application will not crash when inappropriate user data is entered in the forms; instead, error messages should be generated.
 */

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifyPartController {

    @FXML
    private RadioButton radio_in_house;

    @FXML
    private RadioButton radio_outsourced;

    @FXML
    private Label radio_option;

    @FXML
    private TextField part_machineId;


    @FXML
    private Button cancel_part;



    public void In_houseListener() {
        if(radio_in_house.isSelected())
            radio_option.setText("Machine ID");
        part_machineId.promptTextProperty().setValue("Machine ID");
        radio_outsourced.setSelected(false);
    }

    public void outSourcedListener(){
        if(radio_outsourced.isSelected())
            radio_option.setText("Company Name");
            part_machineId.promptTextProperty().setValue("Company Name");
        radio_in_house.setSelected(false);

    }

    public void HideModifyPartsForm() {
        Stage stage = (Stage) cancel_part.getScene().getWindow();
        stage.close();
    }
}
