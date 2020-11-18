package sample;

import javafx.collections.ObservableList;

/**
 *
 * author: Brown Oichoe.
 * The abstract Part class is an abstract class that holds information about parts.
 *
 */

public abstract class Part {

    //Fields
    private int id;
    private String name;
    private Double price;
    private int stock;
    private int min;
    private int max;


    /**
     * Constructor
     * @param id The part's identifier
     * @param name The part's name
     * @param price The part's retail price
     * @param stock The amount available in th inventory
     * @param min The min  for the part
     * @param max The max  for the part
     */


    public Part(int id,String name,Double price,int stock,int min,int max)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;

    }



    /**
     * The setId sets the part's id
     * @param id The part's identifier
     */

    public void setId(int id ) {
        this.id = id;
    }

    /**
     * The setName sets the part's name
     * @param name The part's name
     */

    public void setName(String name ) {
        this.name = name;
    }

    /**
     * The setPrice sets the part's price
     * @param price The part's retail price
     */

    public void setPrice(Double price ) {
        this.price = price;
    }

    /**
     * The setStock sets the part's stock
     * @param stock The amount available in th inventory
     */

    public void setStock(int stock ) {
        this.stock = stock;
    }

    /**
     * The setMin sets the part's min
     * @param min The min  for the part
     */

    public void setMin(int min ) {
        this.min = min;
    }

    /**
     * The setMax sets the part's max
     * @param max The max for the part
     */

    public void setMax(int max ) {
        this.max = max;
    }


    /**
     * getId method
     * @return The part's id
     */

    public int getId() {
        return id;
    }

    /**
     * getName method
     * @return The part's name
     */

    public String getName() {
        return name;
    }

    /**
     * getPrice method
     * @return The part's price
     */

    public Double getPrice() {
        return price;
    }


    /**
     * getStock method
     * @return The part's stock
     */

    public int getStock() {
        return stock;
    }

    /**
     * getMin method
     * @return The part's min
     */

    public int getMin() {
        return min;
    }

    /**
     * getMax method
     * @return The part's Max
     */

    public int getMax() {
        return max;
    }
}
