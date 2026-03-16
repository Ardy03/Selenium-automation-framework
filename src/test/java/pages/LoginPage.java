package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WaitHelper;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id="username")
    WebElement usernameField;

    @FindBy(id="password")
    WebElement passwordField;

    @FindBy(className="radius")
    WebElement loginButton;

    @FindBy(id="flash")
    WebElement messageText;

    public void enterUsername(String username){

        usernameField.sendKeys(username);

    }

    public void enterPassword(String password){

        passwordField.sendKeys(password);

    }

    public void clickLogin(){

        loginButton.click();

    }

    public String getMessage(){
        WaitHelper.getWait(driver).until(ExpectedConditions.visibilityOf(messageText));
        return messageText.getText();
    }

    public LogoutPage login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new LogoutPage(driver);

    }

}