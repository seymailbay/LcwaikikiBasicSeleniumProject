import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import testLogger.TestResultLogger;


/**

 This class sets up the ChromeDriver and initializes the WebDriver for the test cases.
 It also maximizes the browser window and loads the URL of the LC Waikiki website.
 The class contains a method to tear down the WebDriver after the test is completed.
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(TestResultLogger.class)
public class Driver {
    public WebDriver driver;
    @BeforeAll
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        driver.manage().window().maximize();
    }
    @AfterAll
    public void tearDown(){
        driver.quit();
    }
}
