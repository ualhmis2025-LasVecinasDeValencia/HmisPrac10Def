package org.ual.hmis.GallardoMartinez;

import org.junit.*;
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

public class LoginIncorrectoContraseaIncorrectaTest {

  private WebDriver driver;
  private WebDriverWait wait;
  private Map<String, Object> vars;

  @Before
  public void setUp() {
    System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe"); 
    FirefoxOptions options = new FirefoxOptions();
    options.setAcceptInsecureCerts(true);
    
    
    
//    FirefoxOptions firefoxOptions = new FirefoxOptions(); 
//    firefoxOptions.addArguments("-headless");
//    driver = new FirefoxDriver(firefoxOptions);

    
    

    ChromeOptions chromeOptions = new ChromeOptions(); 
    chromeOptions.addArguments("-headless");
    driver = new ChromeDriver(chromeOptions);
    // WebDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX, true);

    
    driver.manage().window().setSize(new Dimension(1670, 697));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    vars = new HashMap<>();
  }

  @After
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Test
  public void loginIncorrectoContraseaIncorrecta() {
    try {
      driver.get("https://my-app-1748620076153.azurewebsites.net/login");

      wait.until(ExpectedConditions.elementToBeClickable(By.id("input-vaadin-text-field-7")));
      driver.findElement(By.id("input-vaadin-text-field-7")).click();
      driver.findElement(By.id("input-vaadin-text-field-7")).sendKeys("Antonio");

      wait.until(ExpectedConditions.elementToBeClickable(By.id("input-vaadin-password-field-8")));
      driver.findElement(By.id("input-vaadin-password-field-8")).click();
      driver.findElement(By.id("input-vaadin-password-field-8")).sendKeys("ContrasenaNoExistente");

      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("vaadin-button:nth-child(2)")));
      driver.findElement(By.cssSelector("vaadin-button:nth-child(2)")).click();

      // Esperar visibilidad de la notificaciÃ³n de error
      WebElement notificacion = wait.until(ExpectedConditions.visibilityOfElementLocated(
          By.cssSelector("vaadin-notification-card")));

      assertThat(notificacion.getText(), is("Usuario no encontrado o contrase\u00F1a incorrecta"));

    } catch (Exception e) {
      System.out.println("âš ï¸� Error durante la prueba de login incorrecto:");
      e.printStackTrace();
      System.out.println("URL actual: " + driver.getCurrentUrl());
      System.out.println("HTML de la pÃ¡gina:");
      System.out.println(driver.getPageSource());
      fail("Test fallido: " + e.getMessage());
    }
  }
}

