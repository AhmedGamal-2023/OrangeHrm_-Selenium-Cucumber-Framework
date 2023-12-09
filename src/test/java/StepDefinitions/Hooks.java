package StepDefinitions;

import DataDriven.Implementation_JsonDataReader;
import Pages.Admin_SaveSystemUsersPage;
import Pages.Admin_ViewSystemUsersPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Hooks {
    static WebDriver driver;
    private final String Url="https://opensource-demo.orangehrmlive.com/";
    SoftAssert soft;
    Implementation_JsonDataReader reader;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    Admin_ViewSystemUsersPage adminViewPage;
    Admin_SaveSystemUsersPage adminSavePage;
    public Hooks() {
        try {
            // Initialize objects
            reader = new Implementation_JsonDataReader();
            reader.jsonReader();
            soft = new SoftAssert();
            driver = getDriver("edge"); // Modify browser type as needed
            loginPage = new LoginPage(driver);
            dashboardPage = new DashboardPage(driver);
            adminViewPage = new Admin_ViewSystemUsersPage(driver);
            adminSavePage = new Admin_SaveSystemUsersPage(driver);
        } catch (IOException | org.json.simple.parser.ParseException e) {
            // Handle exception appropriately
            e.printStackTrace();
        }
    }
    public static WebDriver getDriver(String browserType) {
        if (driver == null) {
            if (browserType.equalsIgnoreCase("chrome")) {
                //Create prefs map to store all preferences
                Map<String, Object> prefs = new HashMap<String, Object>();
                //Put this into prefs map to switch off browser notification
                prefs.put("profile.default_content_setting_values.notifications", 1);
                prefs.put("excludeSwitches","disable-popup-blocking");
                //Create chrome options to set this prefs
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-popup-blocking");
                driver = new ChromeDriver(options);
            } else if (browserType.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserType.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
        }
        return driver;
    }

    @Before
    public void Setup() {
        // Specify the browser type here: "chrome", "firefox", or "edge"
        driver = getDriver("edge");
        driver.manage().window().maximize();
        driver.get(Url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            driver.quit(); // Use quit() to close the entire browser session.

        }
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed ScreenShot", new ByteArrayInputStream(screenshot));
        }
    }
}
