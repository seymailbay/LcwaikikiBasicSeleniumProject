package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/***
 * The BasePage class represents a basic page object that provides common functionality for other page objects.
 It contains methods for finding elements, clicking on elements, and checking if elements are displayed on the page.
 */
public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver=driver;
    }
    public WebElement find(By locator){
        return driver.findElement(locator);
    }
    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }
    public void click(By locator){
        find(locator).click();
    }

    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

}
