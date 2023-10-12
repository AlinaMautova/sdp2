package singleton_design_pattern;

// Eager Initialization Singleton
class SingletonEager {
    private static SingletonEager instance = new SingletonEager();

    // Private constructor to prevent external instantiation
    private SingletonEager() {
    }

    public static SingletonEager getInstance() {
        return instance;
    }
}

// Lazy Initialization Singleton
class Singleton {
    private static Singleton instance;

    // Private constructor to prevent external instantiation
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

// Synchronized Method Singleton (Thread-Safe)
class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod instance;

    // Private constructor to prevent external instantiation
    private SingletonSynchronizedMethod() {
    }

    // Use synchronized method to ensure thread-safety
    public static synchronized SingletonSynchronizedMethod getInstance() {
        if (instance == null) {
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }
}

// Double-Checked Locking Singleton (Thread-Safe)
class SingletonSynchronized {
    private static SingletonSynchronized instance;

    // Private constructor to prevent external instantiation
    private SingletonSynchronized() {
    }

    public static SingletonSynchronized getInstance() {
        if (instance == null) {
            synchronized (SingletonSynchronized.class) {
                if (instance == null) {
                    instance = new SingletonSynchronized();
                }
            }
        }
        return instance;
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        // Demonstrate the Singleton pattern with the SingletonSynchronized class.
        SingletonSynchronized instance = SingletonSynchronized.getInstance();
        System.out.println(instance);
        SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
        System.out.println(instance1);
    }
}
