import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class MainTest {

  WebDriver driver = Browser.launch();

  @Test
  public void googleForCheese() {
    driver.get("https://www.google.com");
    WebElement element = driver.findElement(By.name("q"));
    element.sendKeys("Cheese!");

    element.submit();

    driver.findElement(By.id("res"));
    assertThat(driver.findElement(By.tagName("body")).getText(), containsString("grits"));
  }

  @After
  public void quitBrowser() {
    driver.quit();
  }
}