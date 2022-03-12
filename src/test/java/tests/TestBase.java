package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.HashMap;

public class TestBase {
    public static WebDriver driver;
    SoftAssert softAssert;
    String currentPageURL;


    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return options;
    }


    @BeforeMethod
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver(chromeOption());
        } else if (browserName.equalsIgnoreCase("edge")) {
            String edgePath = System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe";
            System.setProperty("webdriver.edge.driver", edgePath);
            driver = new EdgeDriver();
        }

       // driver.manage().window().maximize();
         driver.manage().window().setSize(new Dimension(1024, 768));
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    public String getCurrentPageURL() {
        currentPageURL = driver.getCurrentUrl();
        return currentPageURL;
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

}






