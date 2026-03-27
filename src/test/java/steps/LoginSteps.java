package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.DriverManager;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user membuka halaman login")
    public void openLoginPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        DriverManager.setDriver(driver);
        loginPage = new LoginPage(driver);
    }

    @When("user login dengan username {string} dan password {string}")
    public void login(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("user berhasil login")
    public void verifySuccess() {
        Assert.assertTrue(loginPage.getMessage()
                .contains("You logged into a secure area!"));
    }

    @Then("user melihat hasil {string}")
    public void verifyResult(String expected) {
        String message = loginPage.getMessage();
        if (expected.equals("success")) {
            Assert.assertTrue(message.contains("You logged into a secure area!"));
        } else {
            Assert.assertTrue(message.contains("Your username is invalid!"));
        }
    }
}