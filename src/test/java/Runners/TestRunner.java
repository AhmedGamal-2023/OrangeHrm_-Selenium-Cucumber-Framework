package Runners;

import Listeners.Listener_Implement;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

//@RunWith(Cucumber.class) // Add the JUnit @RunWith annotation for Cucumber
@Listeners(Listener_Implement.class) // Add the TestNG listener here
@CucumberOptions(
        features ={"src/test/java/Features"},
        glue = {"StepDefinitions"},
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
        ,
        tags = "@SmokeTesting"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @DataProvider
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}