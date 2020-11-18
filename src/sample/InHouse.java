package sample;


/**
 * This InHouse class hold's info whether a Part is in house
 * author: Brown Oichoe
 */
public class InHouse extends Part {
    //Fields
    private int machineId;

    /**
     * Constructor
     * @param machineId The InHouse part machine id
     */

    public InHouse(int id, String name,Double price,int stock,int min, int max,int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }

    /**
     * The setMachineId sets the part's machine id
     * @param machineId The InHouse part machine id
     */

    public void setMachineId(int machineId ) {
       this.machineId = machineId;
    }

    /**
     * getMachineId method
     * @return The part's machineId
     */

    public int getMachineId() {
        return machineId;
    }


    //Debugging
    public String toString() {
        return "Part: " + this.getName() + ", Id:"
                + this.getId()+ ", Inv: " + this.getStock()
                + ", Price: " + this.getPrice() + ", Max: " + this.getMax()
                + ", Min: " + this.getMin()  + ", Machine Id: " + this.getMachineId();
    }


}
