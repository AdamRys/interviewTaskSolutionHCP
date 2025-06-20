package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//This page is created for Activity Page with all elements located on page
public class ActivityPage {
    private WebDriver driver;

    public ActivityPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void verifyIfTaskTitleIsVisibleWithCorrectStatus(String activityName, String expectedStatus){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpathTaskName = "//table[contains(@class, 'table')]/tbody/tr[td[2][text()='" + activityName + "']]";
        WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathTaskName)));
        WebElement statusCell = row.findElement(By.xpath("./td[3]"));

        String actualStatus = statusCell.getText();
        Assert.assertEquals("Unexpected status of activity", expectedStatus, actualStatus);

    }
}
