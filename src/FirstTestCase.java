import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTestCase {

  public static void main(String[] args) {

    // Fix for - The path to the driver executable must be set by the webdriver.chrome.driver system property
    System.setProperty("webdriver.chrome.driver", "/Users/apiliuk/Downloads/polymorphismSample/geckodriver");
    // Create a new instance of the Firefox driver
    WebDriver driver = new ChromeDriver();

    //Launch the Online Store Website
    driver.get("http://www.store.demoqa.com");

    // Print a Log In message to the screen
    System.out.println("Successfully opened the website www.Store.Demoqa.com");

    //Wait for 5 Sec
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Close the driver
    driver.quit();
  }
}