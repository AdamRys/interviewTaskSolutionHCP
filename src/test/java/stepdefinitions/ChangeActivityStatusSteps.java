package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ActivityPage;
import pages.MainPage;
import tests.BaseTest;

//Step definition class for update_activity.feature
public class ChangeActivityStatusSteps {
    private MainPage mainPage = new MainPage(BaseTest.getDriver());
    private ActivityPage activityPage = new ActivityPage(BaseTest.getDriver());

    @When("Click done button of {string} item")
    public void clickDoneButtonOfTestTitleItem(String title) {
        mainPage.clickDoneButtonOfItemWithTitle(title);
    }
    @And("Navigate to activity page")
    public void navigateToActivityPage() {
        mainPage.goToActivityPage();
    }
    @Then("Verify if task {string} is on table with {string} status")
    public void verifyIfTaskIsOnTableWithMovedToDoneStatus(String title, String status) {
        activityPage.verifyIfTaskTitleIsVisibleWithCorrectStatus(title, status);
    }
}
