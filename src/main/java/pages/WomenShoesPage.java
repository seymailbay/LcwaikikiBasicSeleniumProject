package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WomenShoesPage extends BasePage{
    By productLocator=By.xpath("//h5[@class='product-card__title']");
    By womenShoeCategoryPageCheck =By.className("product-list-heading__heading");
    public WomenShoesPage(WebDriver driver) {
        super(driver);
    }
    public void selectProduct(int i) {
        getAllProducts().get(i).click();
    }
    public List<WebElement> getAllProducts(){
        return findAll(productLocator);
    }
    public boolean isOnWomenShoeCategoryPage() {
        return isDisplayed(womenShoeCategoryPageCheck);
    }
}
