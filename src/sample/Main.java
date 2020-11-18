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
        Parent root = FXMLLoader.load(getClass().getResource("Inventory_main.fxml"));
        primaryStage.setTitle("Inventory");
        primaryStage.setScene(new Scene(root, 940, 600));



        primaryStage.show();
    }





}
