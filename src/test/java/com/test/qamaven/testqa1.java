package com.test.qamaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testqa1 {
	WebDriver driver;
  @Test
  @BeforeMethod
  public void setup() {

      driver = new ChromeDriver();

      driver.manage().window().maximize();

      driver.get("https://the-internet.herokuapp.com/login");
      System.out.println("Before method executed");
  }

  @Test
  public void verifyPageTitle() {

      String actualTitle = driver.getTitle();

      Assert.assertTrue(
          actualTitle.contains("The Internet"),
          "Page title is incorrect"
      );
      
  }

  @Test
  public void verifyLogin() {

      driver.findElement(By.id("username"))
            .sendKeys("tomsmith");

      driver.findElement(By.id("password"))
            .sendKeys("SuperSecretPassword!");

      driver.findElement(By.cssSelector("button[type='submit']"))
            .click();

      String message = driver.findElement(By.id("flash"))
                             .getText();

      Assert.assertTrue(
          message.contains("You logged into a secure area!"),
          "Login failed"
      );
  }

  @AfterMethod
  public void tearDown() {

      if (driver != null) {
          driver.quit();
      }
      System.out.println("After method executed");
  }
}
