




package sample;

/**
 * author: Brown oichoe
 * The Inventory class is a class that holds rows for parts  and products.
 */


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Inventory {

    //Fields
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();


    /**
     addPart method
     This adds a new part
     */

    public static void addPart(Part newPart) {
        if (newPart != null) {
            allParts.add(newPart);
        }
    }

    /**
     * addProduct method
     * This adds a new Product
     */

    public static void addProduct(Product newProduct) {
           allProducts.add(newProduct);
    }

    /**
     * lookupPart-id method
     * This looks up part using id
     */


    public static Part lookupPart(int partId) {


        ObservableList<Part> filteredParts = FXCollections.observableArrayList();
        FilteredList<Part> filteredData = new FilteredList<>(allParts, p -> true);
        filteredData.setPredicate(filteredPart -> {
            Integer Id = Integer.valueOf(partId);
            if (Id == null || Id.toString().isEmpty()){

            }
            if (filteredPart.getId() == Id ) {

                return true;
            } else {

                return false;

            }

        });



        System.out.println(filteredData.get(0));
        filteredParts.setAll(filteredData);
       return filteredParts.get(0);
    }

    /**
     * lookupProduct-id method
     * This looks up product using id
     */

    public static Product lookupProduct(int productId) {
        return null;
    }

    /**
     * lookupPart-name method
     * This looks up part using name
     */


    public static ObservableList<Part> lookupPart(String partName) {

        ObservableList<Part> filteredParts = FXCollections.observableArrayList();
        FilteredList<Part> filteredData = new FilteredList<>(allParts, p -> true);
        filteredData.setPredicate(filteredPart -> {
            if (partName == null || partName.isEmpty()) {


                return true;
            }

            if (filteredPart.getName().contains(partName)) {

                return true;
            } else {

                return false;

            }

        });

        filteredParts.setAll(filteredData);
        return filteredParts;
    }



    public static ObservableList<Product> lookupProduct(String productName) {
        return null;
    }

    /**
     * updatePart method
     * This updates a part
     */

    public static void updatePart(int index,Part selectedPart) {

        allParts.set(index,selectedPart);

    }

    /**
     * updateProduct method
     * This updates a product
     */

    public static void updateProduct(int index,Product newProduct) {

    }

    /**
     * deletePart method
     * This deletes a part
     */

     public static boolean deletePart(Part selectedPart) {

         allParts.remove(selectedPart);
         return true;
     }

    /**
     * deleteProduct method
     * This deletes a product
     */

    public static boolean deleteProduct(Product selectedProduct) {
        return true;
    }

    /**
     * getAllParts method
     * @returns ObservableList with Parts
     */

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    /**
     * getAllProducts method
     * @returns ObservableList with Products
     */

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }




}
