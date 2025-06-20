package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//This page is created for elements and methods which can be shared between pages
public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
//Below I've created methods which we can use across all pages, because these kind of elements occur/can occur on few pages
    public void inputToFieldWithPlaceholder(String placeholder, String value){
        WebElement input = driver.findElement(By.xpath("//*[contains(@placeholder, '" + placeholder + "')]"));
        input.click();
        input.clear();
        input.sendKeys(value);
    }
    public void selectDropdownByLabel(String labelText, String optionText){
        String xpath = "//label[text()='" + labelText + "']/following::select[1]";
        WebElement dropdown = driver.findElement(By.xpath(xpath));
        Select select = new Select(dropdown);
        select.selectByVisibleText(optionText);
    }

}
