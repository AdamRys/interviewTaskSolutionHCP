package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import tests.BaseTest;
import utils.ConfigReader;
import java.time.Duration;

//Common step definition class - it contains step definition for features which can share same steps
public class CommonSteps {

    private BasePage basePage = new BasePage(BaseTest.getDriver());

    @When("Input {string} data to field with placeholder {string}")
    public void inputDataToFloatingInput(String valueOrKey, String placeholder){
        String data;
        if (valueOrKey.startsWith("key:")){
            String key = valueOrKey.substring(4);
            data = ConfigReader.get(key);
        }else{
            data = valueOrKey;
        }
        basePage.inputToFieldWithPlaceholder(placeholder,data);
    }
    @And("Select {string} option from {string} dropdown list")
    public void selectHighOptionFromPriorityDropdownList(String dropdownLabel, String option) {
        basePage.selectDropdownByLabel(option, dropdownLabel);
    }
    @Given("User has opened the main page")
    public void userIsOnMainPage() {
        WebDriver driver = BaseTest.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("basic-nav-dropdown")));
    }
}
