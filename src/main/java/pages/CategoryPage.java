package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends BasePage{
    By menShoeCategoryLocatorForCheck = By.cssSelector("div#header__container > header > div:nth-of-type(2) > nav > ul > li:nth-of-type(2) > a");
    By womenShoeCategoryLocator = By.xpath("//a[starts-with(@href,'https://www.lcwaikiki.com/tr-TR/TR/etiket/yeni-sezon-ayakkabi-kadin')]");

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnShoeCategoryPage() {
        return isDisplayed(menShoeCategoryLocatorForCheck);
    }

    public void selectWomenShoeCategory(){
        click(womenShoeCategoryLocator);
    }
}
