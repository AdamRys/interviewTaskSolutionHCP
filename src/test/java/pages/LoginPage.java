package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

//This page is created for Login Page with all elements located on page
//and whole logic that is behind automation of tests
public class LoginPage extends BasePage {

    //Here I get two variables, which I defined in config.properties -
    //I made this just for security to not hardcode username and password
    String username = ConfigReader.get("login");
    String password = ConfigReader.get("password");

    //Below I placed section with located elements from this page

    @FindBy(css = "button.btn.btn-primary[type='submit']")
    WebElement loginButton;

    @FindBy(css = "div.alert.alert-danger")
    WebElement errorMessage;

    //Below I've created methods which covers whole logic of automation which run on login page
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("http://localhost:3000");
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void verifyUnsuccessfulLoginErrorMessageDisplayed() {
        Assert.assertTrue("Error is not displayed", errorMessage.isDisplayed());
        Assert.assertEquals("Invalid username or password", errorMessage.getText().trim());
    }
}
