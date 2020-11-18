package sample;

/**
 * This Outsourced class hold's info whether a Part is outsourced
 * author: Brown Oichoe
 */

public class Outsourced extends Part {
    //Fields
    private String companyName;

    /**
     * Constructor
     * @param companyName The InHouse part machine id
     */

    public Outsourced(int id,String name,Double price,int stock, int min, int max, String companyName) {

        super(id,name,price,stock,min,max);
        this.companyName = companyName;
    }

    /**
     * The setCompanyName sets the part's company name
     * @param companyName The InHouse part machine id
     */

    public void setCompanyName(String companyName ) {
       this.companyName = companyName;
    }

    /**
     * getCompanyName method
     * @return The part's company name
     */

    public String getCompanyName() {
        return companyName;
    }

    //Debugging
    public String toString() {
        return "Part: " + this.getName() + ", Id:"
                + this.getId()+ ", Inv: " + this.getStock()
                + ", Price: " + this.getPrice() + ", Max: " + this.getMax()
                + ", Min: " + this.getMin()  + ", Company Name: " + this.getCompanyName();
    }
}
