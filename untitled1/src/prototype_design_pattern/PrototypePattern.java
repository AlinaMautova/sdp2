package prototype_design_pattern;

import java.util.ArrayList;
import java.util.List;

// The Vehicle class implements the Cloneable interface to support cloning.
class Vehicle implements Cloneable {
    private List<String> vehicleList;

    public Vehicle() {
        this.vehicleList = new ArrayList<String>();
    }

    public Vehicle(List<String> list) {
        this.vehicleList = list;
    }

    public void insertData() {
        vehicleList.add("Honda Amaze");
        vehicleList.add("Audi A4");
        vehicleList.add("Hyundai Creta");
        vehicleList.add("Maruti Baleno");
        vehicleList.add("Renault Duster");
    }

    public List<String> getVehicleList() {
        return this.vehicleList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> tempList = new ArrayList<String>();

        for (String s : this.getVehicleList()) {
            tempList.add(s);
        }

        return new Vehicle(tempList);
    }
}

public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Create a prototype (a) and insert data.
        Vehicle a = new Vehicle();
        a.insertData();

        // Clone the prototype (b) to create a new instance.
        Vehicle b = (Vehicle) a.clone();

        List<String> list = b.getVehicleList();

        // Modify the cloned list.
        list.add("Honda new Amaze");

        System.out.println("Original Vehicle List: " + a.getVehicleList());
        System.out.println("Cloned Vehicle List: " + list);

        // Modify the cloned list again.
        list.remove("Audi A4");

        System.out.println("Modified Cloned List: " + list);
        System.out.println("Original Vehicle List (unchanged): " + a.getVehicleList());
    }
}
