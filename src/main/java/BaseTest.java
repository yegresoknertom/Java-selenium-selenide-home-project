import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

public class BaseTest {

    private static ChromeDriverService service;
    private WebDriver driver;
    private final static String PATH_TO_CHROMEDRIVER = "chromedriver";


    @BeforeClass
    public void setUp() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(PATH_TO_CHROMEDRIVER))
                .usingAnyFreePort()
                .build();
        service.start();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(service, options);
        WebDriverRunner.setWebDriver(driver);
        Configuration.screenshots = false;
    }

    @AfterClass
    public void shutDown() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null ){
            service.stop();
        }
    }

}
