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
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


import com.gargoylesoftware.htmlunit.BrowserVersion;

import java.time.Duration;
import java.util.*;

public class AadirUsuarioCorrectoTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  private WebDriverWait wait;
  JavascriptExecutor js;

  @Before
  public void setUp() throws Exception {
	  
	  
    System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
    
    
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
  public void aadirUsuarioCorrecto() throws InterruptedException {
    driver.get("https://my-app-1748620076153.azurewebsites.net/login");
    driver.manage().window().setSize(new Dimension(1670, 697));

    wait.until(ExpectedConditions.elementToBeClickable(By.id("input-vaadin-text-field-7")));
    driver.findElement(By.id("input-vaadin-text-field-7")).click();
    driver.findElement(By.id("input-vaadin-text-field-7")).sendKeys("Antonio");

    wait.until(ExpectedConditions.elementToBeClickable(By.id("input-vaadin-password-field-8")));
    driver.findElement(By.id("input-vaadin-password-field-8")).click();
    driver.findElement(By.id("input-vaadin-password-field-8")).sendKeys("Gallardo");

    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("vaadin-button:nth-child(2)")));
    driver.findElement(By.cssSelector("vaadin-button:nth-child(2)")).click();

    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("vaadin-button:nth-child(1)")));
    driver.findElement(By.cssSelector("vaadin-button:nth-child(1)")).click();

    

    wait.until(ExpectedConditions.elementToBeClickable(By.id("input-vaadin-text-field-25")));
    driver.findElement(By.id("input-vaadin-text-field-25")).click();
    driver.findElement(By.id("input-vaadin-text-field-25")).sendKeys("Miguel");

    wait.until(ExpectedConditions.elementToBeClickable(By.id("input-vaadin-text-field-26")));
    driver.findElement(By.id("input-vaadin-text-field-26")).click();
    driver.findElement(By.id("input-vaadin-text-field-26")).sendKeys("Martinez");

    wait.until(ExpectedConditions.elementToBeClickable(By.id("input-vaadin-text-field-27")));
    driver.findElement(By.id("input-vaadin-text-field-27")).click();
    driver.findElement(By.id("input-vaadin-text-field-27")).sendKeys("mms172@inlumine.ual.es");

    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("vaadin-button:nth-child(2)")));
    driver.findElement(By.cssSelector("vaadin-button:nth-child(2)")).click();

    Thread.sleep(5000); // Esperar 5 segundos antes de continuar

    
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("vaadin-notification-card")));
    assertThat(driver.findElement(By.cssSelector("vaadin-notification-card")).getText(), is("Datos actualizados"));

  }
}
