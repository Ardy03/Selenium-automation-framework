package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user membuka halaman login")
    public void openLoginPage(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        loginPage = new LoginPage(driver);

    }

    @When("user login dengan username {string} dan password {string}")
    public void login(String username, String password){

        loginPage.login(username,password);

    }

    @Then("user berhasil login")
    public void verifySuccess(){

        Assert.assertTrue(loginPage.getMessage()
                .contains("You logged into a secure area!"));

        driver.quit();

    }

    @Then("muncul pesan {string}")
    public void verifyError(String expected){

        Assert.assertTrue(loginPage.getMessage().contains(expected));

        driver.quit();

    }

}