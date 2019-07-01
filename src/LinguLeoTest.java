import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinguLeoTest {

  public static void main(String[] args) {

    // Fix for - The path to the driver executable must be set by the webdriver.chrome.driver system property
    System.setProperty("webdriver.chrome.driver", "/Users/apiliuk/Downloads/polymorphismSample/chromedriver");
    // Create a new instance of the Firefox driver
    WebDriver driver = new ChromeDriver();

    driver.get("https://lingualeo.com/ru");
    driver.findElement(By.xpath("//div[contains(text(), 'У МЕНЯ УЖЕ ЕСТЬ АККАУНТ')]")).click();
    driver.findElement(By.xpath("//input[@name='email']")).sendKeys("a.a.piluck@gmail.com");
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("a.a.piluck@gmail.com");
    driver.findElement(By.xpath("//span[contains(text(), 'ВОЙТИ')]")).click();

    //Wait for 5 Sec
    try {
      Thread.sleep(50000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Close the driver
    driver.quit();
  }
}