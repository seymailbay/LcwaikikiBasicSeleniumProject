import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;
import java.util.List;
import java.util.Random;

/**
 This class contains tests to verify the functionality of adding a product to the cart in an e-commerce website.
 The tests include navigating to the shoe category page,
 selecting a women's shoe product,
 adding the product to the cart,
 and verifying that the product count is updated and the product is added to the cart.
 The tests are performed using the JUnit 5 testing framework
 and the Selenium WebDriver for web automation.
 */


public class AddProductToCardTest extends Driver {
    HomePage homePage;
    CategoryPage categoryPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    WomenShoesPage womenShoesPage;

    @Test
    @Order(1)
    // Go to the shoe category page and verify that it is loaded
    public void goToShoeCategory() throws InterruptedException {
        homePage =new HomePage(driver);
        categoryPage=new CategoryPage(driver);
        WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.urlContains("/tr-TR/TR"));
        Thread.sleep(1000);
        homePage.acceptCookies();
        homePage.clickShoeCategory();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("ayakkabi"));
        Assertions.assertTrue(categoryPage.isOnShoeCategoryPage(),"Not on shoe category page!");
    }
    @Test
    @Order(2)
    // Go to the women's shoe category page and verify that it is loaded
    public void goToWomenShoeCategory() throws InterruptedException {
        womenShoesPage=new WomenShoesPage(driver);
        Thread.sleep(4000);
        categoryPage.selectWomenShoeCategory();
        Assertions.assertTrue(womenShoesPage.isOnWomenShoeCategoryPage(),"Not on women shoe category page!");
    }
    @Test
    @Order(3)
    // Select a product and verify that its detail page is loaded
    public void selectProduct()  {
        productDetailPage=new ProductDetailPage(driver);
        womenShoesPage=new WomenShoesPage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        womenShoesPage.selectProduct(randomNumberGenerator(womenShoesPage.getAllProducts().size()));
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage()," Not on product page!");
    }
    @Test
    @Order(4)
    // Add the selected product to the cart and verify that the product count is updated
    public void addProductToCard() {
        Actions actions = new Actions(driver);
        actions.moveByOffset(1, 1).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> allSizesOfProduct=productDetailPage.getAllProductSizes();
        productDetailPage.selectProductSizes(randomNumberGenerator(allSizesOfProduct.size()),allSizesOfProduct);
        productDetailPage.addToCard();

        Assertions.assertTrue(homePage.isProductCountUp(), "Product count did not increase !");

    }
    @Test
    @Order(5)
    // Go to cart page and verify that product added
    public void goToCartPage() {
        cartPage=new CartPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homePage.goToCard();
        Assertions.assertTrue(cartPage.checkIfProductAdded(),"Product was not added to the card! ");
    }
    @Test
    @Order(6)
    // Navigate back to homepage and verify that is loaded.
    public void backToHomePage()  {
        cartPage.goToHomePage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assertions.assertTrue(homePage.isOnHomePage(),"Not on home page!");
    }

    // Using for monkey test
    public int randomNumberGenerator(int size){
        Random random = new Random();
        return random.nextInt(size);
    }
}
