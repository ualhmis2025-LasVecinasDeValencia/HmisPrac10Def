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

public class SobreMiguelTest {
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
  public void sobreMiguel() {
    driver.get("https://ualhmis2025-lasvecinasdevalencia.github.io/GallardoMartinez/");
    driver.manage().window().setSize(new Dimension(1148, 696));

    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sobre Miguel")));
    driver.findElement(By.linkText("Sobre Miguel")).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".post-title")));
    assertThat(driver.findElement(By.cssSelector(".post-title")).getText(), is("Sobre Miguel"));
  }
}
