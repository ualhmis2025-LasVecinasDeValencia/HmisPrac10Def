package org.ual.hmis.GallardoMartinez;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.*;

public class EliminarUsuarioIncorrectoNoExisteTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  private WebDriverWait wait;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe"); 
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//    FirefoxOptions firefoxOptions = new FirefoxOptions(); 
//    firefoxOptions.addArguments("-headless");
//    driver = new FirefoxDriver(firefoxOptions);

    

    ChromeOptions chromeOptions = new ChromeOptions(); 
    chromeOptions.addArguments("-headless");
    driver = new ChromeDriver(chromeOptions);
    // WebDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX, true);

    
    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    js = (JavascriptExecutor) driver;
    vars = new HashMap<>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void eliminarUsuarioIncorrectoNoExiste() {
    driver.get("https://my-app-1748620076153.azurewebsites.net/login");
    driver.manage().window().setSize(new Dimension(1670, 982));

    wait.until(ExpectedConditions.elementToBeClickable(By.id("input-vaadin-text-field-7")));
    driver.findElement(By.id("input-vaadin-text-field-7")).click();
    driver.findElement(By.id("input-vaadin-text-field-7")).sendKeys("Antonio");

    wait.until(ExpectedConditions.elementToBeClickable(By.id("input-vaadin-password-field-8")));
    driver.findElement(By.id("input-vaadin-password-field-8")).click();
    driver.findElement(By.id("input-vaadin-password-field-8")).sendKeys("Gallardo");

    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("vaadin-button:nth-child(2)")));
    driver.findElement(By.cssSelector("vaadin-button:nth-child(2)")).click();

    wait.until(ExpectedConditions.elementToBeClickable(By.id("input-vaadin-text-field-25")));
    driver.findElement(By.id("input-vaadin-text-field-25")).click();
    driver.findElement(By.id("input-vaadin-text-field-25")).sendKeys("UsuarioQueNoExiste");

    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("vaadin-button:nth-child(3)")));
    driver.findElement(By.cssSelector("vaadin-button:nth-child(3)")).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("vaadin-notification-card")));
    assertThat(driver.findElement(By.cssSelector("vaadin-notification-card")).getText(), is("No hay usuario seleccionado para eliminar"));
  }
}
