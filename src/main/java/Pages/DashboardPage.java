package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends Base{
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    private final By AdminTabLocator = By.xpath("//span[text()='Admin']");

    public void ClickOnAdminTab(){
        click(AdminTabLocator);
    }


}
