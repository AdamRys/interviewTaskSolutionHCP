package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.MainPage;
import tests.BaseTest;

//Step definition class for login.feature
public class LoginSteps {
    private LoginPage loginPage;
    private MainPage mainPage;

    @Before
    public void setUpPages() {
        loginPage = new LoginPage(BaseTest.getDriver());
        mainPage = new MainPage(BaseTest.getDriver());
    }
    @Given("User has opened the login page")
    public void userHasOpenedTheLoginPage(){
        loginPage.open();
    }
    @And("Click login button")
    public void clickLoginButtonStep() {
        loginPage.clickLoginButton();
    }
    @Then("User is logged in and see dashboard")
    public void userIsLoggedInAndSeeDashboard() {
        mainPage.isLogoDisplayed();
    }
    @Then("User should not be logged in")
    public void userShouldNotBeLoggedIn() {
        loginPage.verifyUnsuccessfulLoginErrorMessageDisplayed();
    }
}
