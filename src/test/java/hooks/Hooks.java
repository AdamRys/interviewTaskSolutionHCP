package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.BasePage;
import pages.LoginPage;
import pages.MainPage;
import tests.BaseTest;
import utils.ConfigReader;

//In this class I placed actions that can occur before or after Tests/Scenarios etc.
public class Hooks {
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected MainPage mainPage;

    //Test is started using BaseTest class, additionally pages are initialized, to have possibility to use its elements for Hook actions
    @Before(order=0)
    public void setUp() {
        BaseTest.setUp();

        basePage = new BasePage(BaseTest.getDriver());
        loginPage = new LoginPage(BaseTest.getDriver());
        mainPage = new MainPage(BaseTest.getDriver());
    }
    //User login - hook that would be reused many times since login is crucial to access app features
    @Before(value = "@LoginRequired", order = 1)
    public void loginRequired(){
        loginPage.open();
        basePage.inputToFieldWithPlaceholder("username", ConfigReader.get("login"));
        basePage.inputToFieldWithPlaceholder("Password", ConfigReader.get("password"));
        loginPage.clickLoginButton();
    }

    //Add new test item - hook that provides test data for defining up activity status (update_activity_status.feature)
    @Before(value = "@AddTestItem", order = 2)
    public void addTestItem(){
        mainPage.clickNavigationActionButton();
        mainPage.clickAddButton();
        basePage.inputToFieldWithPlaceholder("title", "test title");
        basePage.inputToFieldWithPlaceholder("description", "test description");
        basePage.inputToFieldWithPlaceholder("estimate", "5");
        basePage.selectDropdownByLabel("Priority", "High");
        basePage.inputToFieldWithPlaceholder("image URL", "/activity1.jpeg");
        mainPage.clickSubmitButton();
    }

    //Clean up after test
    @After
    public void tearDown() {
        BaseTest.tearDown();
    }
}
