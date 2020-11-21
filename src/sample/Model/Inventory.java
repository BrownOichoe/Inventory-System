




package sample.Model;

/**
  @author: Brown oichoe
  The Inventory class is a class that holds data for both parts  and products.
 */


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class Inventory {

    //Fields
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();


    /**
     addPart method.
     This adds a new part
     */

    public static void addPart(Part newPart) {
        if (newPart != null) {
            allParts.add(newPart);
        }
    }

    /**
      addProduct method.
      This adds a new Product
     */

    public static void addProduct(Product newProduct) {
        if( newProduct != null)
             allProducts.add(newProduct);
    }

    /**
      lookupPart-id method.
      This looks up part using id
     */


    public static Part lookupPart(int partId) {


        for (Part p : allParts)
        {
            if (p.getId() == partId)
                return p;
        }
        return null;

    }

    /**
     lookupProduct-id method.
      This looks up product using id
     */

    public static Product lookupProduct(int productId) {
        for (Product p : allProducts)
        {
            if (p.getId() == productId)
                return p;
        }
        return null;
    }

    /**
      lookupPart-name method.
      This looks up part using name
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

    /**
     lookupProduct-name method.
     This looks up product using name
     */

    public static ObservableList<Product> lookupProduct(String productName) {
        ObservableList<Product> filteredParts = FXCollections.observableArrayList();
        FilteredList<Product> filteredData = new FilteredList<>(allProducts, p -> true);
        filteredData.setPredicate(filteredPart -> {
            if (productName == null || productName.isEmpty()) {


                return true;
            }

            if (filteredPart.getName().contains(productName)) {

                return true;
            } else {

                return false;

            }

        });

        filteredParts.setAll(filteredData);
        return filteredParts;
    }

    /**
      updatePart method.
      This updates a part
     */

    public static void updatePart(int index,Part selectedPart) {

        allParts.set(index,selectedPart);

    }

    /**
     updateProduct method.
     This updates a product
     */

    public static void updateProduct(int index,Product newProduct) {

        allProducts.set(index, newProduct);
    }

    /**
      deletePart method.
      This deletes a part.
      @return boolean
     */

     public static boolean deletePart(Part selectedPart) {

         allParts.remove(selectedPart);
         return true;
     }

    /**
      deleteProduct method.
      This deletes a product.
      @return boolean
     */

    public static boolean deleteProduct(Product selectedProduct) {
        allProducts.remove(selectedProduct);
        return true;
    }

    /**
       getAllParts method.
       @returns ObservableList with Part.s
     */

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    /**
      getAllProducts method.
      @returns ObservableList with Products.
     */

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }




}
