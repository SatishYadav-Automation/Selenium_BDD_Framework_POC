package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;
import Base.BaseTest;

@CucumberOptions(
    features = "src/test/resources/Features/",
    glue = {"Steps"},
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
    //dryRun = true
   // tags = "@Smoke or @Sanity"
)
public class LoginRunner extends AbstractTestNGCucumberTests {
    private static ThreadLocal<BaseTest> base = new ThreadLocal<>();

    @BeforeMethod
    public void beforeTest() {
        BaseTest baseTest = new BaseTest();
        baseTest.SetUp();
        base.set(baseTest);
    }

    @AfterMethod
    public void afterTest() {
        base.get().TearDown();
    }

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }

    public static BaseTest getBaseTest() {
        return base.get();
    }
}
