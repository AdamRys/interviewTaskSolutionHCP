package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;
import tests.BaseTest;

//Step definition class for add_new_item.feature
public class AddNewItemSteps {
    private MainPage mainPage = new MainPage(BaseTest.getDriver());

    @When("Click navigation button")
    public void clickNavigationButton() {
        mainPage.clickNavigationActionButton();
    }
    @When("Click add button")
    public void clickAddButton() {
        mainPage.clickAddButton();
    }
    @And("Click submit button")
    public void clickSubmitButton() {
        mainPage.clickSubmitButton();
    }
    @Then("New item is added with {string} title")
    public void newItemIsAddedWithNewTitleTitle(String title) {
        mainPage.verifyIfNewItemHasTitle(title);
    }
    @And("New item is added with {string} progressbar")
    public void newItemIsAddedWithHoursProgressbar(String text) {
        mainPage.verifyIfNewItemHasTime(text);
    }
    @And("New item is added with {string} description")
    public void newItemIsAddedWithNewDescription(String text) {
        mainPage.verifyIfNewItemHasDescription(text);
    }
    @And("New item is added with {string} priority label")
    public void newItemIsAddedWithHighPriorityLabel(String text) {
        mainPage.verifyIfNewItemHasPriority(text);
    }
    @And("New item with title {string} is added with {string} URL")
    public void newItemIsAddedWithActivityJpegURL(String title, String url) {
        mainPage.verifyIfNewItemHasURL(title, url);
    }
}
