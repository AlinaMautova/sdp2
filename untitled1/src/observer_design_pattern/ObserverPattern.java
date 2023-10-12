package observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

// The Subject interface defines methods to register, unregister, and notify observers.
interface Subject {
    void register(Observer obj);
    void unregister(Observer obj);
    void notifyObservers();
}

// Concrete subject class, DeliveryData, implements the Subject interface.
class DeliveryData implements Subject {
    private List<Observer> observers;
    private String location;

    public DeliveryData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.update(location);
        }
    }

    public void locationChanged() {
        this.location = getLocation();
        notifyObservers();
    }

    public String getLocation() {
        return "YPlace";
    }
}

// The Observer interface defines the update method that concrete observers implement.
interface Observer {
    void update(String location);
}

// Concrete observer classes: Seller, User, and DeliveryWarehouseCenter.
class Seller implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}

class User implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

class DeliveryWarehouseCenter implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        DeliveryData topic = new DeliveryData();

        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();

        // Register observers with the subject.
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        // Trigger a location change and notify observers.
        topic.locationChanged();

        // Unregister one of the observers (obj3).
        topic.unregister(obj3);

        System.out.println();

        // Trigger another location change and notify remaining observers.
        topic.locationChanged();
    }
}
