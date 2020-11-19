package sample;

/**
 * author: Brown oichoe
 *
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application  {




    @Override
    public void start(Stage primaryStage) throws Exception{
        Inventory inv = new Inventory();
        /*Parent root = FXMLLoader.load(getClass().getResource("Inventory_main.fxml"));
        primaryStage.setTitle("Inventory");
        primaryStage.setScene(new Scene(root, 940, 600));
        */
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("Inventory_main.fxml"));
        Parent parent;
        parent = loader.load();
        primaryStage.setTitle("Inventory");
        primaryStage.setScene(new Scene(parent, 940, 600));
        Inventory_mainController controller = loader.getController();
        controller.setInventory(inv);
        primaryStage.show();
    }





}
