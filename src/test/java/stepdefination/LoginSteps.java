package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.testng.Assert;

public class LoginSteps {

    WebDriver driver;

    @Given("user is on the login page")
    public void user_is_on_login_page() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/logins");
    }

    @When("user enters valid username")
    public void user_enters_username() {

        driver.findElement(By.id("username"))
              .sendKeys("tomsmith");
    }

    @When("user enters valid password")
    public void user_enters_password() {

        driver.findElement(By.id("password"))
              .sendKeys("SuperSecretPassword!");
    }

    @When("user clicks on login button")
    public void user_clicks_login_button() {

        driver.findElement(By.cssSelector("button[type='submit']"))
              .click();
    }

    @Then("user should successfully login")
    public void user_should_successfully_login() {

        String message = driver.findElement(By.id("flash"))
                               .getText();

        Assert.assertTrue(
            message.contains("You logged into a secure area!")
        );

        driver.quit();
    }
}