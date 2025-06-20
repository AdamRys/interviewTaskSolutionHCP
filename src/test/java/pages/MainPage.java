package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//This page is created for Main Page (page after successful login) with all elements located on page
//and whole logic that is behind automation of tests
public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "img[src='/logoplannister.png']")
    WebElement logoImage;

    @FindBy(id = "basic-nav-dropdown")
    WebElement actionButton;

    @FindBy(css = "a.dropdown-item[role='button']")
    WebElement addButton;

    @FindBy(css = "button.btn.btn-primary[type='submit']")
    WebElement submitButton;

    @FindBy(css = "a.nav-link-custom.nav-link[href='/activity']")
    WebElement activityLink;

    public boolean isLogoDisplayed(){
        return logoImage.isDisplayed();
    }

    public void clickNavigationActionButton(){
        actionButton.click();
    }

    public void clickAddButton(){
        addButton.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

//Below I've created set of assertion for created item - it is possible to make it more reusable by making class - parameter
    public void verifyIfNewItemHasTitle(String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'card-body') and .//span[@class='me-2' and text()='" + title + "']]")));
        Assert.assertTrue(element.isDisplayed());
    }

    public void verifyIfNewItemHasDescription(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='small-font' and text()='" + text + "']")));
        Assert.assertTrue(description.isDisplayed());
    }

    public void verifyIfNewItemHasTime(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement progressBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'progress-bar') and contains(text(), '" + text + "')]")));
        Assert.assertTrue(progressBar.isDisplayed());
    }

    public void verifyIfNewItemHasPriority(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement priorityBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(@class, 'badge') and contains(@class, 'bg-warning') and text()='" +text + "']")));
        Assert.assertTrue(priorityBadge.isDisplayed());
    }
    public void verifyIfNewItemHasURL(String title, String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement card = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='mb-3 custom-card  card'][.//span[@class='me-2' and text()='" + title + "']]")));
        WebElement image = card.findElement(By.cssSelector("img.card-img-top"));
        String actualUrl = image.getAttribute("src");

        Assert.assertTrue("Wrong URL in new added item", actualUrl.contains(url));
    }

    //Method which click "Done" button on newly added item
    public void clickDoneButtonOfItemWithTitle(String title){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement doneButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[@class='me-2' and text()='" + title + "']/ancestor::div[contains(@class, 'custom-card')]//button[text()='Done']")));
//since I wanted to create test data for this test, "Done" button was not reachable, that's why I had to scroll to this element using js script
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", doneButton);
        js.executeScript("window.scrollBy(0, -100);");
        wait.until(ExpectedConditions.elementToBeClickable(doneButton));
//For some reason, when I tried to use Selenium clicking method, it throwed me "ElementClickInterceptedException" - thats why I've implemented here js script
        js.executeScript("arguments[0].click();", doneButton);

    }

    public void goToActivityPage() {
        activityLink.click();
    }
}
