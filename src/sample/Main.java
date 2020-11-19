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

        inv.addPart(new InHouse(1,"Gear",600.00,100,50,200,5));
        inv.addPart(new Outsourced(2,"Nail",300.00,150,50,200,"NailedIt Ltd"));
        inv.addPart(new InHouse(3,"Glue",200.00,200,50,250,23));
        inv.addPart(new InHouse(4,"Hammer",669.00,250,50,300,32));
        inv.addPart(new Outsourced(5,"Spanner",210.00,300,50,350,"Spanner Inc"));
        inv.addPart(new InHouse(6,"Wrench",300.00,350,50,400,76));
        inv.addPart(new Outsourced(7,"Wire",1000.00,400,50,450,"Wire Inc"));
        inv.addPart(new InHouse(8,"Wheel Barrow",10000.00,450,50,500,87));
        inv.addPart(new Outsourced(9,"Tapes",100.00,50,50,440,"tapes Ltd"));
        inv.addPart(new InHouse(10,"Oil Pan",150.00,150,50,590,93));
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
