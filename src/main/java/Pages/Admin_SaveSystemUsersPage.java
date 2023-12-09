package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Admin_SaveSystemUsersPage extends Base{
    public Admin_SaveSystemUsersPage(WebDriver driver) {
        super(driver);
    }
    private final By UserRoleLocator = By.xpath("//label[text()='User Role']/following::div[contains(@class, 'oxd-select-text--active')][1]");
    private final By StatusLocator = By.xpath("//label[text()='Status']/following::div[contains(@class, 'oxd-select-text--active')]");
    private final By UserNameLocator = By.xpath("//label[text()='Username']/following::input[contains(@class, 'oxd-input oxd-input--active')][1]");
    private final By PassWordLocator = By.xpath("//label[text()='Password']/following::input[contains(@type, 'password')][1]");
    private final By ConfirmPassWordLocator = By.xpath("//label[text()='Password']/following::input[contains(@type, 'password')][2]");


    private final By EmployeeNameLocator = By.cssSelector("input[placeholder='Type for hints...']");
    private final By NameSelectFromAutoDropDownLocator = By.cssSelector("div[role='listbox']");
    private final By SaveButtonLocator = By.cssSelector("button[type='submit']");



    public void FillRequiredData(String userName,String Password,String employeeName) throws InterruptedException {
        click(UserRoleLocator);
        for (int i=1; i<=2;i++)
            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();

      click(StatusLocator);

            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();

      sendKeys(userName,UserNameLocator);
      sendKeys(Password,PassWordLocator);
      sendKeys(Password,ConfirmPassWordLocator);


        Thread.sleep(2500);
        sendKeys(employeeName,EmployeeNameLocator);
        Thread.sleep(2500);

        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();

    }
    public void ClickOnSaveButton(){
        click(SaveButtonLocator);
    }
}
