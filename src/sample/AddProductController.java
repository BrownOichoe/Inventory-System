/**
 *
 *  author: Brown oichoe
 *
 *  The Add Product form
 * •  The application auto-generates a unique product ID. The product IDs can be, but do not need to be, contiguous. - The product ID text field must be disabled and cannot be edited or changed.
 * •  The user should be able to enter a product name, inventory level or stock, a price, and maximum and minimum values.
 * •  The user can search for parts (top table) by ID or name (partial or full name). If the part or parts are found, the application highlights a single part or filters multiple parts. If the part or parts are not found, the application displays an error message in the UI or in a dialog box.
 * •  If the search field is set to empty, the table should be repopulated with all available parts.
 * •  The top table should be identical to the Parts TableView in the Main form.
 * •  The user can select a part from the top table. The user then clicks the Add button, and the part is copied to the bottom table. (This associates one or more parts with a product.)
 * •  The Remove Associated Part button removes a selected part from the bottom table. (This dissociates or removes a part from a product.
 * •  After saving the data, the user is automatically redirected to the Main form.
 * •  Canceling or exiting this form redirects users to the Main form.
 *
 * Note: When a product is deleted, so can its associated parts without affecting the part inventory. The Remove Associated Part button removes a selected part from the bottom table. (This dissociates or removes a part from a product.)
 *
 *
 * --------------------------------------*****************************---------------------------------------------------------------
 * •  Min should be less than Max; and Inv should be between those two values.
 * •  The user should not delete a product that has a part associated with it.
 * •  The application confirms the “Delete” and “Remove” actions.
 * •  The application will not crash when inappropriate user data is entered in the forms; instead, error messages should be generated.
 */


package sample;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddProductController {

    @FXML
    private Button cancel_part;


    public void HideAddProductsForm() {
        Stage stage = (Stage) cancel_part.getScene().getWindow();
        stage.close();
    }
}
