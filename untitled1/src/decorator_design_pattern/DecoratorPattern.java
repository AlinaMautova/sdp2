package decorator_design_pattern;

// The Dress interface defines the basic functionality for a dress
interface Dress {
    void assemble();
}

// A concrete class representing basic dress features
class BasicDress implements Dress {
    @Override
    public void assemble() {
        System.out.println("Basic Dress Features");
    }
}

// A base decorator class that other decorators inherit from
class DressDecorator implements Dress {
    protected Dress dress;

    public DressDecorator(Dress dress) {
        this.dress = dress;
    }

    @Override
    public void assemble() {
        dress.assemble();
    }
}

// Concrete decorator adding casual dress features
class CasualDress extends DressDecorator {
    public CasualDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Casual Dress Features");
    }
}

// Concrete decorator adding sporty dress features
class SportyDress extends DressDecorator {
    public SportyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Sporty Dress Features");
    }
}

// Concrete decorator adding fancy dress features
class FancyDress extends DressDecorator {
    public FancyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Fancy Dress Features");
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        // Create and decorate dresses with different features
        Dress sportyDress = new SportyDress(new BasicDress());
        sportyDress.assemble();
        System.out.println();

        Dress fancyDress = new FancyDress(new BasicDress());
        fancyDress.assemble();
        System.out.println();

        Dress casualDress = new CasualDress(new BasicDress());
        casualDress.assemble();
        System.out.println();

        Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
        sportyFancyDress.assemble();
        System.out.println();

        Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
        casualFancyDress.assemble();
    }
}
