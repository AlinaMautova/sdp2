package adapter_design_pattern;

// Define an interface for the WebDriver
interface WebDriver {
    public void getElement();      // Method to get an element
    public void selectElement();   // Method to select an element
}

// Implement the WebDriver interface for ChromeDriver
class ChromeDriver implements WebDriver {
    @Override
    public void getElement() {
        System.out.println("Get element from ChromeDriver");
    }

    @Override
    public void selectElement() {
        System.out.println("Select element from ChromeDriver");
    }
}

// IEDriver class does not implement the WebDriver interface but has similar functionality
class IEDriver {
    public void findElement() {
        System.out.println("Find element from IEDriver");
    }

    public void clickElement() {
        System.out.println("Click element from IEDriver");
    }
}

// Create an adapter to make IEDriver compatible with the WebDriver interface
class WebDriverAdapter implements WebDriver {
    IEDriver ieDriver;

    public WebDriverAdapter(IEDriver ieDriver) {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement() {
        ieDriver.findElement(); // Adapt IEDriver's findElement to WebDriver's getElement
    }

    @Override
    public void selectElement() {
        ieDriver.clickElement(); // Adapt IEDriver's clickElement to WebDriver's selectElement
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        // Create a ChromeDriver instance
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.getElement();
        chromeDriver.selectElement();

        // Create an IEDriver instance
        IEDriver ieDriver = new IEDriver();
        ieDriver.findElement();
        ieDriver.clickElement();

        // Create a WebDriverAdapter instance to adapt IEDriver to the WebDriver interface
        WebDriver wID = new WebDriverAdapter(ieDriver);
        wID.getElement();
        wID.selectElement();
    }
}