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

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ModifyPartController implements Initializable {

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

    @FXML
    private TextField part_Id;

    @FXML
    private TextField part_Name;

    @FXML
    private TextField  part_Max;

    @FXML
    private TextField  part_Min;

    @FXML
    private TextField  part_Price;

    @FXML
    private TextField  part_Inv;

    @FXML
    private Button save_part;




    Part part;

    Inventory inventory;

    public void setPart(Part p) {


        this.part = p;
       // System.out.println("The Selected Part is " + this.part.toString());
        part_Id.setText(Integer.toString(part.getId()));
        part_Name.setText(part.getName());
        part_Price.setText(Double.toString(part.getPrice()));
        part_Max.setText(Integer.toString(part.getMax()));
        part_Min.setText(Integer.toString(part.getMin()));
        part_Inv.setText(Integer.toString(part.getStock()));



        if(part instanceof InHouse) {

            radio_in_house.setSelected(true);
            radio_outsourced.setSelected(false);
            InHouse inHouse = (InHouse) part;
            radio_option.setText("Machine ID");
            part_machineId.setText(Integer.toString(inHouse.getMachineId()));
            part_machineId.promptTextProperty().setValue("Machine ID");

        }else {
            radio_in_house.setSelected(false);
            radio_outsourced.setSelected(true);
            Outsourced outsourced = (Outsourced) part;
            radio_option.setText("Company Name");
            part_machineId.setText(outsourced.getCompanyName());
            part_machineId.promptTextProperty().setValue("Company Name");
        }

    }


    public void getInventory(Inventory inv) {

        this.inventory = inv;

    }

    private Part getPart() {
        return part;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        List<TextField> textFields = Arrays.asList(part_Name,part_Price,part_Inv,part_Min,part_Max,part_machineId);
        textFields.forEach(textField -> {
            textField.textProperty().addListener((obs,old,newWord)->{
                // TODO here

                try {
                    textField.setText(newWord);
                    textField.setText(newWord);
                    setValues(textField);
                }catch (NumberFormatException e){
                    System.out.println("I got you error");
                }



            });
        });


    }

    public void setValues(TextField ts) {
        if(ts.getId().equals(part_Id.getId())) {
              part.setId(Integer.parseInt(ts.getText()));
        }
        else if(ts.getId().equals(part_Name.getId())) {
            part.setName(ts.getText());
        }else if(ts.getId().equals(part_Inv.getId())) {
            part.setStock(Integer.parseInt(ts.getText()));
        }else if(ts.getId().equals(part_Price.getId())) {
            part.setPrice(Double.parseDouble(ts.getText()));
        }else if(ts.getId().equals(part_Max.getId())){
            part.setMax(Integer.parseInt(ts.getText()));
        }else if(ts.getId().equals(part_Min.getId())){
            part.setMin(Integer.parseInt(ts.getText()));
        }else if( ts.getId().equals(part_machineId.getId())){

               if(part instanceof InHouse && radio_in_house.isSelected()) {

                   InHouse inHouse = (InHouse) part;
                   inHouse.setMachineId(Integer.parseInt(ts.getText()));

               }else if(part instanceof  Outsourced && radio_outsourced.isSelected()){
                   Outsourced outsourced = (Outsourced) part;
                   outsourced.setCompanyName(ts.getText());
               }else if(part instanceof InHouse && !radio_in_house.isSelected()) {

                   inventory.deletePart(part);
                   part = new Outsourced(Integer.parseInt(part_Id.getText()),
                           part_Name.getText(),
                           Double.parseDouble(part_Price.getText()),
                           Integer.parseInt(part_Inv.getText()),
                           Integer.parseInt(part_Max.getText()),
                           Integer.parseInt(part_Min.getText()),
                           part_machineId.getText());



               }else {
                   inventory.deletePart(part);
                   part = new InHouse(Integer.parseInt(part_Id.getText()),
                           part_Name.getText(),
                           Double.parseDouble(part_Price.getText()),
                           Integer.parseInt(part_Inv.getText()),
                           Integer.parseInt(part_Min.getText()),
                           Integer.parseInt(part_Max.getText()),
                           Integer.parseInt(part_machineId.getText()));
               }


        }


    }


    @FXML
    private void In_houseListener() {



        if(radio_in_house.isSelected())
            radio_option.setText("Machine ID");
        part_Id.setText(Integer.toString(part.getId()));
        part_machineId.promptTextProperty().setValue("Machine ID");
        radio_outsourced.setSelected(false);

    }


    @FXML
    private void outSourcedListener(){
        if(radio_outsourced.isSelected())
            radio_option.setText("Company Name");
            part_machineId.promptTextProperty().setValue("Company Name");
        radio_in_house.setSelected(false);

    }

    @FXML
    private void HideModifyPartsForm() throws IOException {
        Stage stage;
        Parent root;
        stage=(Stage) cancel_part.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader=new FXMLLoader();
        root = loader.load(getClass().getResource("Inventory_main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void modifyPart() {



    }




    @FXML
    private void SaveModifiedPart() throws IOException {

        Parent parent;
        Stage stage;
        stage = (Stage) save_part.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Inventory_main.fxml"));
        parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Inventory");
        Inventory_mainController controller = loader.getController();
        controller.setSelectedPart(part);
    }
}
