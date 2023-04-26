package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductDetailPage extends BasePage {
    By addToCardLocator=By.className("add-to-cart-container");
    By productSizeLocator= By.xpath("//div[@class='product-detail']//a[@data-stock > 0 and @data-tracking-label='BedenSecenekleri']");
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCardLocator);

    }
    public void addToCard() {
        click(addToCardLocator);
    }
    public void selectProductSizes(int i, List<WebElement> allSizesOfProduct) {
        allSizesOfProduct.get(i).click();
    }
    public List<WebElement> getAllProductSizes(){
        return findAll(productSizeLocator);
    }
}
