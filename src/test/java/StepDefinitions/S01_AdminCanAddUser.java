package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S01_AdminCanAddUser {
    Hooks hooks;
    public S01_AdminCanAddUser() {
        hooks = new Hooks();
    }
    @Given("in login page, Enter Username and Enter Password then click on login button")
    public void EnterValidData(){
        hooks.Setup();
        hooks.loginPage.EnterValidData(hooks.reader.UserName,hooks.reader.PassWord);
    }
    @When("in Home page, Click on Admin tab on the left side menu")
    public void ClickOnAdminTab() {
        hooks.dashboardPage.ClickOnAdminTab();
    }

    @And("Get the number of records found")
    public int GetTheNumberOfRecordBeforeAdd() {
        return hooks.adminViewPage.GetTheNumberOfRecord();

    }
    @And("Click on add button")
    public void ClickOnAddButton() {
        System.out.println("The number Before Add User: > "+GetTheNumberOfRecordBeforeAdd());
        hooks.adminViewPage.ClickOnAddButton();
    }
    @And("Fill the required data")
    public void FillRequiredData() throws InterruptedException {
        hooks.adminSavePage.FillRequiredData(hooks.reader.UserNameForAddUser, hooks.reader.PassWord, hooks.reader.employeeName);
    }
    @And("Click on save button")
    public void ClickOnSaveButton(){
      hooks.adminSavePage.ClickOnSaveButton();
    }
    @Then("Verify that the number of records increased by 1")
    public int ValidateTheNumberIsIncreased(){
       int numberBeforeAddUser =GetTheNumberOfRecordBeforeAdd();
       int numberAfterAddUser = hooks.adminViewPage.ValidateTheNumberIsIncreased();

// Assert if the number after adding a user is greater by 1 than the number before
        hooks.soft.assertTrue(numberAfterAddUser == numberBeforeAddUser + 1,
                "Number after adding user is not greater by 1 than the number before");
        return hooks.adminViewPage.ValidateTheNumberIsIncreased();
    }
    @And("Search with the username for the new user")
    public void SearchByUserName(){
        System.out.println("The number After Add User: > "+ValidateTheNumberIsIncreased());
       hooks.adminViewPage.SearchByUserName(hooks.reader.UserNameForAddUser);
    }
    @And("Delete the new user")
    public void DeleteNewUser(){
      hooks.adminViewPage.DeleteNewUser();
      hooks.adminViewPage.ClearSearch();
    }
    @Then("Verify that the number of records decreased by 1")
    public void ValidateTheNumberIsDecreased(){
        int numberAfterAddUser = ValidateTheNumberIsIncreased();
        int numberAfterDeleteUser =hooks.adminViewPage.ValidateTheNumberIsDecreased();

        hooks.soft.assertTrue(numberAfterDeleteUser == numberAfterAddUser - 1,
                "Number after delete user is not less by 1 ");
        System.out.println("The number After Delete User: > "+hooks.adminViewPage.ValidateTheNumberIsDecreased());
    }































//    HomePage homePage =new HomePage(driver);
//    @Given("user open LoginPage to Fills his data")
//    public void OpenedLoginPage (){
//
//    }
//    @When("user Enter Username , password")
//    public void EnterUserNameAndPassword () throws IOException, ParseException {
//        Reader.jsonReader();
//        loginPage.EnterUserNameAndPassword(Reader.userName_مدير_عام_الوحدة_المركزية_للمخاطر, Reader.password);
//    }
//    @And("user click on تسجيل الدخول")
//    public void ClickOnSubmit(){
//   loginPage.ClickOnSubmit();
//    }
//    @Then("Assert that user logged successfully and display {string} and {string}")
//    public void AssertLoggedSuccessfully(String Header_welcome_message,String yourEmployees){
//        String expectedResult1 = Header_welcome_message;
//        String expectedResult2 = yourEmployees;
//        String actualResult1 = homePage.HeaderMessageLocator();
//        String actualResult2 = homePage.yourEmployees();
//        soft.assertTrue(actualResult1.contains(expectedResult1));
//        soft.assertTrue(actualResult2.contains(expectedResult2));
//    }
}
