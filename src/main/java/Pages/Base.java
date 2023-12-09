package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
public class Base {
    protected  WebDriver driver;
    protected  WebDriverWait wait;
    protected final Wait<WebDriver> fluentWait;
    protected final JavascriptExecutor js;
    protected final Actions actions;
    public Base(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(12))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
    }
    private Base waitForElementToAppear(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return this;
    }
    protected Base click(By by){
        waitForElementToAppear(by);
        driver.findElement(by).click();
        return this;
    }
    protected Base sendKeys(String string, By by){
        waitForElementToAppear(by);
        driver.findElement(by).sendKeys(string);
        return this;
    }
    protected Base hoverOver(By by){
        waitForElementToAppear(by);
        actions.moveToElement(driver.findElement(by)).perform();
        return this;
    }
    protected Base selectFromList(By by, String keyword){
        waitForElementToAppear(by);
        Select select = new Select(driver.findElement(by));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        select.selectByVisibleText(keyword);
        return this;
    }
    protected Base waitForElementsToAppear(By by){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        return this;
    }
    protected String getText(By by){
            waitForElementToAppear(by);
        return driver.findElement(by).getText();
    }
}
