package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Admin_ViewSystemUsersPage extends Base{
    public Admin_ViewSystemUsersPage(WebDriver driver) {
        super(driver);
    }
    private final By AdminTabLocator = By.xpath("//span[text()='Admin']");
    private final By RecordNumbersLocator = By.xpath("//span[contains(normalize-space(),'Records')]");
    private final By AddUserButtonLocator = By.xpath("//button[text()=' Add ']");
    private final By UserNameLocator = By.xpath("//label[text()='Username']/following::input[contains(@class, 'oxd-input oxd-input--active')][1]");
    private final By SearchButtonLocator = By.xpath("//button[text()=' Search ']");
    private final By DeleteButtonLocator = By.xpath("//button[contains(@class, 'oxd-icon-button') and contains(@class, 'oxd-table-cell-action-space')]//i[contains(@class, 'oxd-icon') and contains(@class, 'bi-trash')]");
    private final By YesDeleteButtonLocator = By.xpath("//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--medium oxd-button--label-danger orangehrm-button-margin')]");

    public int GetTheNumberOfRecord() {
        // Get the text content of the element
        String TextOfFirstCheckRecords = getText(RecordNumbersLocator);
        int NumberOfFirstCheckRecords = -1; // Default value if extraction fails
        // Use regular expression to extract the number within parentheses
        Pattern pattern = Pattern.compile("\\((\\d+)\\)\\s*Records\\s*Found");
        Matcher matcher = pattern.matcher(TextOfFirstCheckRecords);
        if (matcher.find()) {
            NumberOfFirstCheckRecords = Integer.parseInt(matcher.group(1));
        }
        return NumberOfFirstCheckRecords;
    }
   public void ClickOnAddButton(){
        click(AddUserButtonLocator);
   }
   public int ValidateTheNumberIsIncreased(){
       String TextOfFirstCheckRecords = getText(RecordNumbersLocator);
       int NumberForAfterAddUser= -1; // Default value if extraction fails
       // Use regular expression to extract the number within parentheses
       Pattern pattern = Pattern.compile("\\((\\d+)\\)\\s*Records\\s*Found");
       Matcher matcher = pattern.matcher(TextOfFirstCheckRecords);
       if (matcher.find()) {
           NumberForAfterAddUser = Integer.parseInt(matcher.group(1));
       }
       return NumberForAfterAddUser;
   }
   public void SearchByUserName(String userName){
     sendKeys(userName,UserNameLocator);
     click(SearchButtonLocator);
   }
   public void DeleteNewUser(){
        click(DeleteButtonLocator);
        click(YesDeleteButtonLocator);
   }
   public void ClearSearch(){
      wait.until(ExpectedConditions.visibilityOfElementLocated(RecordNumbersLocator));
      click(AdminTabLocator);
   }
   public int ValidateTheNumberIsDecreased(){
       String TextOfFirstCheckRecords = getText(RecordNumbersLocator);
       int NumberForAfterDeleteUser= -1; // Default value if extraction fails
       // Use regular expression to extract the number within parentheses
       Pattern pattern = Pattern.compile("\\((\\d+)\\)\\s*Records\\s*Found");
       Matcher matcher = pattern.matcher(TextOfFirstCheckRecords);
       if (matcher.find()) {
           NumberForAfterDeleteUser = Integer.parseInt(matcher.group(1));
       }
       return NumberForAfterDeleteUser;
   }

}
