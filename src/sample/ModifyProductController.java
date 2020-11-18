/**
 *
 * author: Brown oichoe
 *
 *
 * The Modify Product form
 * •  The text fields populate with the data from the chosen product, and the bottom TableView populates with the associated parts.
 * •  The user can search for parts (top table) by ID or name (partial or full name). If the part or parts are found, the application highlights a single part or filters multiple parts. If the part is not found, the application displays an error message in the UI or a dialog box.
 * •  If the search text field is set to empty, the table should be repopulated with all available parts.
 * •  The top table should be identical to the Parts TableView in the Main form.
 * •  The user may modify or change data values.
 * -  The product ID text field must be disabled and cannot be edited or changed.
 * •  The user can select a part from the top table. The user then clicks the Add button, and the part is copied to the bottom table. (This associates one or more parts with a product.)
 * •  The user may associate zero, one, or more parts with a product.
 * •  The user may remove or disassociate a part from a product.
 * •  After saving modifications to the product, the user is automatically redirected to the Main form.
 * •  Canceling or exiting this form redirects users to the Main form.
 *
 * Note: The Remove Associated Part button removes a selected part from the bottom table. (This dissociates or removes a part from a product.)
 *
 *
 * -----------------------------------**********************--------------------------------------------------------------------------
 * •  Min should be less than Max; and Inv should be between those two values.
 * •  The user should not delete a product that has a part associated with it.
 * •  The application confirms the “Delete” and “Remove” actions.
 * •  The application will not crash when inappropriate user data is entered in the forms; instead, error messages should be generated.
 */

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifyProductController {

    @FXML
    private Button cancel_part;


    public void HideModifyProductsForm() {
        Stage stage = (Stage) cancel_part.getScene().getWindow();
        stage.close();
    }
}
