package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.time.Duration;


public class BaseTest {

    WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    public void Setup(@Optional("Chrome") String browser, ITestContext testContext) {
        switch (browser) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "FireFox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "Explorer":
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions capabilities = new InternetExplorerOptions();
                capabilities.ignoreZoomSettings();
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException("no such browser " + browser);
        }
        driver.manage().window().maximize();
        testContext.setAttribute("WebDriver", this.driver);
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.involve.me/");

    }

    @AfterClass
    public void tearDown() throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
        driver.quit();
    }
}
