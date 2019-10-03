import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginToJira {

  WebDriver driver;

  @BeforeTest
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "/Users/User/IdeaProjects/LoginToJira/polymorphismSample/chromedriver.exe");
    // Create a new instance of the Chrome driver
    this.driver = new ChromeDriver();
  }

  By userNameInput = By.xpath("//*[@id='login-form-username']");
  By passwordInput = By.xpath("//*[@id='login-form-password']");
  By enterButton = By.xpath("//*[@id='login-form-submit']");
  String userName = "Ekaterina_Voronkova";
  String password = "Ekaterina_Voronkova";

  @Test
  public void firstTest() throws InterruptedException {
    this.driver.get("https://jira.hillel.it/login.jsp");
    this.driver.findElement(userNameInput).sendKeys(userName);
    this.driver.findElement(passwordInput).sendKeys(password);

    clickOnElementWithRetry(enterButton);

    //Thread.sleep(2000); // ждем пока появится сообщение об ошибке
    //assertTrue(this.driver.findElement(wrongPasswordLabel).isDisplayed());
  }

  @AfterTest
  public void tearDown() {
    // Close the driver
    this.driver.quit();
  }

  void clickOnElementWithRetry(By locator) {
    try {
      WebElement element = this.driver.findElement(locator);
      element.click();
    } catch (NoSuchElementException | StaleElementReferenceException exception) {
      // NoSuchElementException - элемент не был найден
      WebElement element = this.driver.findElement(locator);
      element.click();
    }
  }
}