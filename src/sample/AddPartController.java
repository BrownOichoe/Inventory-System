/**
 *
 *  author: Brown oichoe
 *  The Add Part form
 * •  The In-House and Outsourced radio buttons switch the bottom label to the correct value (Machine ID or Company Name).
 * •  The application auto-generates a unique part ID. The part IDs can be, but do not need to be, contiguous.
 * -  The part ID text field must be disabled.
 * •  The user should be able to enter a part name, inventory level or stock, a price, maximum and minimum values, and company name or machine ID values into active text fields.
 * •  After saving the data, users are automatically redirected to the Main form.
 * •  Canceling or exiting this form redirects users to the Main form.
 *
 * ------------------------------------****************---------------------------------
 * •  The application will not crash when inappropriate user data is entered in the forms; instead, error messages should be generated.
 * •  Min should be less than Max; and Inv should be between those two values.
 *
 */


package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


public class AddPartController implements Initializable {

    @FXML
    private Pane anchor_pane;

    @FXML
    private RadioButton radio_in_house;

    @FXML
    private RadioButton radio_outsourced;

    @FXML
    private TextField part_machineId;

    @FXML
    private TextField part_Name;


    @FXML
    private TextField part_Inv;


    @FXML
    private TextField part_price;


    @FXML
    private TextField part_Max;


    @FXML
    private TextField part_Min;

    @FXML
    private Label radio_option;

    @FXML
    private TextField part_id;

    @FXML
    private Button cancel_part;


    @FXML
    private Button save_part;






    Inventory inventory;



    public void setInventory(Inventory v) {
        this.inventory = v;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {}


    @FXML
    private void In_houseListener() {
        if(radio_in_house.isSelected())
            radio_option.setText("Machine ID");
            part_machineId.promptTextProperty().setValue("Machine ID");

            radio_outsourced.setSelected(false);
    }

    @FXML
    private void outSourcedListener(){
        if(radio_outsourced.isSelected())
            radio_option.setText("Company Name");
            part_machineId.clear();
            part_machineId.promptTextProperty().setValue("Company Name");
            radio_in_house.setSelected(false);

    }





    private void AddPart(Inventory inv) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource(
                "Inventory_main.fxml"));
        Parent root;
        root = loader.load();
        Inventory_mainController controller = loader.getController();
        controller.setInventory(inv);

    }



    public void HideAddPartsForm() {
        Stage stage = (Stage) save_part.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void addedPart(ActionEvent event) throws IOException {

        List<TextField> textFields = Arrays.asList(part_Name,part_price,part_Inv,part_Min,part_Max,part_machineId);

             Part p;
             if(!checkIfEmpty(textFields)) {


                 if(radio_in_house.isSelected() && validationPassed(textFields)) {
                     if (checkMinMAxInv(Integer.parseInt(part_Min.getText()), Integer.parseInt(part_Max.getText()),Integer.parseInt(part_Inv.getText()))) {
                         //System.out.println(inhouse.toString());

                         p = new InHouse(1, part_Name.getText(), Double.valueOf(part_price.getText()), Integer.parseInt(part_Inv.getText()), Integer.parseInt(part_Max.getText()), Integer.parseInt(part_Min.getText()), Integer.parseInt(part_machineId.getText())) ;

                         inventory.addPart(p);
                         AddPart(inventory);
                         //System.out.println(inventory.getAllParts().toString());
                         HideAddPartsForm();

                     } else {
                         System.out.println("Min should be less than Max; and Inv should be between those two values");
                         DialogBox();
                     }


                 }else if (radio_outsourced.isSelected() && validationPassed(textFields)) {
                     if (checkMinMAxInv(Integer.parseInt(part_Min.getText()), Integer.parseInt(part_Max.getText()),Integer.parseInt(part_Inv.getText()))) {
                         //System.out.println(outsourced.toString());
                         p = new Outsourced(1,
                                 part_Name.getText(),
                                 Double.valueOf(part_price.getText()),
                                 Integer.parseInt(part_Inv.getText()),
                                 Integer.parseInt(part_Max.getText()),
                                 Integer.parseInt(part_Min.getText()),
                                 part_machineId.getText());
                         inventory.addPart(p);
                         AddPart(inventory);
                         //System.out.println(inventory.getAllParts().toString());
                         HideAddPartsForm();

                     } else {
                         System.out.println("Min should be less than Max; and Inv should be between those two values");
                         DialogBox();
                     }

                 } else {
                     DialogBox();
                 }
             }else {
                 System.out.println("Fields Cannot be empty");
                 DialogBox();
             }




    }





    @FXML
    private boolean checkIfEmpty(List<TextField> ts) {

        boolean isEmpty = false;

        //add part id
        for (TextField textField: ts) {
            if(textField.getText().trim().length() == 0)
                isEmpty = true;
        }

        return isEmpty;
    }


    @FXML
    private boolean validationPassed(List<TextField> ts) throws IOException {

           boolean isValid = true;

           for (TextField textField: ts) {
               String Id = textField.getId();
               try {
                   if (Id.equals(part_Inv.getId()) || Id.equals(part_Max.getId()) || Id.equals(part_Min.getId())) {
                       Integer.valueOf(textField.getText());


                   } else  if(Id.equals(part_price.getId())){

                       Double.valueOf(textField.getText());

                   } else  if(Id.equals(part_machineId.getId())){

                       if(radio_in_house.isSelected()) {
                           Integer.valueOf(textField.getText());
                       }else {
                           System.out.println("This is the company Name");
                       }

                   }else {
                       Id =textField.getText();


                       if(Character.isDigit(Id.charAt(0))) {
                           System.out.println("This is " + Id + " not  a String");
                           isValid = false;

                       } else  if (Id.length() > 1){
                           for(int i = 0 ; i < Id.length() ; i++) {
                                if(Character.isDigit(Id.charAt(i))) {
                                    System.out.println("This is " + Id.charAt(i) + " not  a String");
                                    isValid = false;
                                    return isValid;
                                } else {
                                    isValid = true;
                                }

                           }
                       }else {
                           isValid = true;
                           System.out.println("This is " + Id + "  a String");
                       }



                   }


               } catch (NumberFormatException e) {
                   System.out.println("The value :  " + Id + " is not a number");
                   isValid = false;

               }

           }

            return  isValid;
    }

    @FXML
    private void generateUniqueNumber() {

    }

    @FXML
    private boolean checkMinMAxInv(int min, int max, int inv) {

        if (inv > min) {
            return max > inv;
        } else {
            return false;
        }

    }


    @FXML
    private void DialogBox() throws IOException {
        Parent Form = FXMLLoader.load(getClass().getResource("DialogBox.fxml"));
        Scene scene = new Scene(Form);
        Stage  stage = new Stage();
        stage.setTitle("Error Message");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }



}
