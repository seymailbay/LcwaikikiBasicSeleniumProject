package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CartPage extends BasePage{

    By productAreaLocator=By.cssSelector("div#ShoppingCartContent > div > div > div:nth-of-type(2) > div:nth-of-type(2) > div > div > div");

    By homePageLocator=By.xpath("//a[@class='main-header-logo']");
    public CartPage(WebDriver driver) {
        super(driver);
}

    public boolean checkIfProductAdded() {
        return isDisplayed(productAreaLocator);
    }

    public void goToHomePage() {
        click(homePageLocator);
    }
}
