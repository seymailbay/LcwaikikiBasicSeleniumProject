package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    By acceptCookiesLocator= By.xpath("//button[text()='Tüm Çerezlere İzin Ver']");
    By shoeCategoryLocator=By.cssSelector("a.menu-header-item__title[href*='ayakkabi']");
    By cartCountLocator=By.xpath("//a[span[@class='dropdown-label' and contains(text(), 'Sepetim')]]/span[@class='badge-circle']");
    By goCartLocator=By.cssSelector("div#header__container > header > div > div:nth-of-type(3) > div > div:nth-of-type(2) > a > svg");
    By homepageSliderImagesLocator =By.className("marketplace");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void acceptCookies() {
        click(acceptCookiesLocator);
    }
    public void goToCard() {
        click(goCartLocator);
    }
    public void clickShoeCategory() {
        click(shoeCategoryLocator);

    }
    public boolean isProductCountUp() {
        return getCartCount() >0;
    }
    private int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }
    public boolean isOnHomePage() {
        return isDisplayed(homepageSliderImagesLocator);
    }
}
