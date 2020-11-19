/**
 *
 *  author: Brown oichoe
 *
 *  Add the following functionalities to the Main form:
 * 1.  The Parts pane
 * •  The Add button under the Parts TableView opens the Add Part form.
 * •  The Modify button under the Parts TableView opens the Modify Part form.
 * •  The Delete button under the Parts TableView deletes the selected part from the Parts TableView or displays a descriptive error message in the UI or in a dialog box if a part is not deleted.
 * •  When the user searches for parts by ID or name (partial or full name) using the text field, the application displays matching results in the Parts TableView. (Including a search button is optional.) If the part or parts are found, the application highlights a single part or filters multiple parts. If the part is not found, the application displays an error message in the UI or in a dialog box.
 * •  If the search field is set to empty, the table should be repopulated with all available parts.
 * 2.  The Products pane
 * •  The Add button under the Products TableView opens the Add Product form.
 * •  The Modify button under the Products TableView opens the Modify Product form.
 * •  The Delete button under the Products TableView deletes the selected product (if appropriate) from the Products TableView or displays a descriptive error message in the UI or in a dialog box if a product is not deleted.
 * •  When the user searches for products by ID or name (partial or full name) using the text field, the application displays matching results in the Products TableView. (Including a search button is optional.) If a product or products are found, the application highlights a single product or products or filters multiple products. If a product or products are not found, the application displays an error message in the UI or in a dialog box.
 * •  If the search field is set to empty, the table should be repopulated with all available products.
 *
 * Note: A product’s associated parts can exist independent of current inventory of parts. You are not required to display sample data upon launching your application. You do not need to save your data to a database or a file; data for this application is nonpersistent and will reside in computer memory while in use.
 *
 * 3.  Exit button
 * •  The Exit button closes the application.
 */

package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Inventory_mainController  implements Initializable  {






    @FXML
    private TableView<Part> parts_table;


    @FXML
    private TableColumn<Part, Integer> part_id;


    @FXML
    private TableColumn<Part, String> part_Name;

    @FXML
    private TableColumn<Part, Integer> part_level;

    @FXML
    private TableColumn<Part, Double> part_cost;




    @FXML
    private Button exit_main;


    @FXML
    private Button add_part;

    @FXML
    private Button modify_part;



    Inventory inventory;
    Part selectedPart;
    int index;


    public void setInventory(Inventory v) {
        this.inventory = v;
    }

    public void setSelectedPart(Part p) {
        System.out.println("The index is: " + index + " and the Part is : " +  p);
        inventory.updatePart(index,p);
    }

    /*public Part modifyPart() {


        for (Part Row : this.inventory.getAllParts()) {
            int index = parts_table.getItems().indexOf(Row);
            if (parts_table.getSelectionModel().isSelected(index))
                selectedPart = Row;
        };

        selectedPart = parts_table.getSelectionModel().getSelectedItem();
        System.out.println(selectedPart.toString());
        return selectedPart;
    }*/





    @Override
    public void initialize(URL url, ResourceBundle rb) {
        parts_table.refresh();
        parts_table.setItems(this.inventory.getAllParts());
        part_id.setCellValueFactory(new PropertyValueFactory<Part,Integer>("id"));
        part_cost.setCellValueFactory(new PropertyValueFactory<Part , Double>("price"));
        part_level.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
        part_Name.setCellValueFactory(new PropertyValueFactory<Part,String>("name"));



    }


    @FXML
    private void pushToAddPartsForm(ActionEvent event) throws IOException {


        Parent parent;
        Stage stage;
        stage = (Stage) modify_part.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPart.fxml"));
        parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Add Part");
        AddPartController controller = loader.getController();
        controller.setInventory(this.inventory);

    }

    @FXML
    private void pushToModifyPartsForm(ActionEvent event) throws IOException {

        if(parts_table.getSelectionModel().getSelectedItem() != null) {
            Part selectedPart = parts_table.getSelectionModel().getSelectedItem();
            index = parts_table.getSelectionModel().getSelectedIndex();
            //System.out.println("The selected Part is " + selectedPart.toString());

            Parent parent;
            Stage stage;
            stage = (Stage) modify_part.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyPart.fxml"));
            parent = loader.load();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Modify Part");
            ModifyPartController controller = loader.getController();
            controller.setPart(selectedPart);
            controller.getInventory(inventory);
        }



       System.out.println("Please select Item to Continue");



    }



    @FXML
    private void pushToAddProductsForm() throws IOException {
        Parent Form = FXMLLoader.load(getClass().getResource("AddProduct.fxml"));
        Scene  scene = new Scene(Form);
        Stage  stage = new Stage();
        stage.setTitle("Add Products");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    @FXML
    private void pushToModifyProductsForm() throws IOException {
        Parent Form = FXMLLoader.load(getClass().getResource("ModifyProduct.fxml"));
        Scene  scene = new Scene(Form);
        Stage  stage = new Stage();
        stage.setTitle("Modify Products");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }


    @FXML
    private void deletePart(ActionEvent event) {

    }

    @FXML
    private void exitInventory() {
        Stage stage = (Stage) exit_main.getScene().getWindow();
        stage.close();
    }






}
