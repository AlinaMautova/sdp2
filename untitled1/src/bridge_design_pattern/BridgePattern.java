package bridge_design_pattern;

// Abstract TV class represents different TV brands
abstract class TV {
    Remote remote;

    TV(Remote r) {
        this.remote = r;
    }

    // Abstract methods for turning the TV on and off
    abstract void on();

    abstract void off();
}

// Sony class extends TV, representing Sony brand TVs
class Sony extends TV {
    Remote remoteType;

    Sony(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }

    public void off() {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}

// Philips class extends TV, representing Philips brand TVs
class Philips extends TV {
    Remote remoteType;

    Philips(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }

    public void off() {
        System.out.print("Philips TV OFF: ");
        remoteType.off();
    }
}

// Remote interface defines the methods for controlling the TV
interface Remote {
    public void on();

    public void off();
}

// OldRemote class implements the Remote interface for older remote controls
class OldRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with Old Remote");
    }
}

// NewRemote class implements the Remote interface for newer remote controls
class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with New Remote");
    }
}

// The main class demonstrates the Bridge Pattern
public class BridgePattern {
    public static void main(String[] args) {
        // Create a Sony TV with an Old Remote
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        // Create a Sony TV with a New Remote
        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        // Create a Philips TV with an Old Remote
        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        // Create a Philips TV with a New Remote
        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
    }
}
