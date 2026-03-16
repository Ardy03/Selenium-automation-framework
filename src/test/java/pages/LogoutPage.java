package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WaitHelper;

public class LogoutPage {
    WebDriver driver;

    public LogoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "a.button.secondary.radius")
    WebElement logoutButton;

    @FindBy(id="flash")
    WebElement messageText;

    public void clickLogout(){
        logoutButton.click();
    }

    public String getMessage(){
        return messageText.getText();
    }
}
