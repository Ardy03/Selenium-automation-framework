package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.LogoutPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"tomsmith","SuperSecretPassword!","You logged into a secure area!"},
                {"tomsmith","wrongpass","Your password is invalid!"},
                {"","","Your username is invalid!"},
                {"salah", "uperSecretPassword!", "Your username is invalid!"}
        };
    }

    @BeforeMethod
    public void pagesetup() {
        loginPage = new LoginPage(driver);
    }

    //profesional
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String expectedMessage){
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.getMessage().contains(expectedMessage));
    }
    // logout after login
    @Test
    public void logoutTest(){
        LoginPage loginPage = new LoginPage(driver);
        LogoutPage logoutPage = loginPage.login("tomsmith","SuperSecretPassword!");
        logoutPage.clickLogout();
        Assert.assertTrue(logoutPage.getMessage().contains("You logged out of the secure area!"));
    }


    //basic
    @Test
    public void loginInvalidPassword() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("kosong");
        driver.findElement(By.className("radius")).click();
        String message = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(message.contains("Your password is invalid!"));
    }

    @Test
    public void loginEmpty() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.getMessage()
                .contains("Your username is invalid!"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}