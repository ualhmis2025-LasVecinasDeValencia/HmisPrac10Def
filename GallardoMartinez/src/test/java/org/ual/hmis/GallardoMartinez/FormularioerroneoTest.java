package org.ual.hmis.GallardoMartinez;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions; 
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.*;

public class FormularioerroneoTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  private WebDriverWait wait;
  JavascriptExecutor js;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");

    // FirefoxOptions firefoxOptions = new FirefoxOptions(); 
    // firefoxOptions.addArguments("-headless");
    // driver = new FirefoxDriver(firefoxOptions);

    ChromeOptions chromeOptions = new ChromeOptions(); 
    chromeOptions.addArguments("-headless");
    driver = new ChromeDriver(chromeOptions);

    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    js = (JavascriptExecutor) driver;
    vars = new HashMap<>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void formularioerroneo() {
    driver.get("https://ualhmis2025-lasvecinasdevalencia.github.io/GallardoMartinez/");
    driver.manage().window().setSize(new Dimension(1148, 696));

    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Formulario")));
    driver.findElement(By.linkText("Formulario")).click();

    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("fgvhbj");
    driver.findElement(By.id("message")).click();
    driver.findElement(By.id("message")).sendKeys("afs");
    driver.findElement(By.cssSelector("button")).click();
    driver.findElement(By.cssSelector("button")).click();

    vars.put("message", js.executeScript("return document.getElementById(\"email\").validationMessage"));
    assertEquals(vars.get("message").toString(), "Incluye un signo \"@\" en la dirección de correo electrónico. La dirección \"fgvhbj\" no incluye el signo \"@\".");
  }
}
