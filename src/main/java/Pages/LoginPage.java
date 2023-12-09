package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base {

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    private final By UserNameFieldLocator = By.cssSelector("input[name='username']");
    private final By PasswordFieldLocator = By.cssSelector("input[name='password']");
    private final By LoginButtonLocator = By.cssSelector("button[type='submit']");

    public void EnterValidData(String username,String password){
        sendKeys(username,UserNameFieldLocator);
        sendKeys(password,PasswordFieldLocator);
        click(LoginButtonLocator);
    }


}

