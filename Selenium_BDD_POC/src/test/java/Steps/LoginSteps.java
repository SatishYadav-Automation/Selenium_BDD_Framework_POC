package Steps;

import io.cucumber.java.en.*;
import Pages.LoginPage;
import Pages.PasswordResetPage;
import Runners.LoginRunner;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import Base.BaseTest;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    public LoginSteps() {
        BaseTest baseTest = LoginRunner.getBaseTest();
        driver = baseTest.getDriver();
    }

	@Given("user is on the login page")
	public void NavigateToLoginPage() 
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");
		loginPage = new LoginPage(driver);
		loginPage.AssertPageLoaded();
	}

	@When("user enters username {string} and password {string}")
	public void EnterCredentials(String username, String password) 
	{
		loginPage.EnterUsername(username);
		loginPage.EnterPassword(password);
	}

	@When("clicks the login button")
	public void Login()
	{
		loginPage.Login();
	}

	@Then("home page should load")
	public void VerifyHomePageLoaded()
	{
		homePage = new HomePage(driver);
		homePage.AssertPageLoaded("Dashboard");
	}

	@Then("user should see an correct error message")
	public void VerifyErrorMessage()
	{
		loginPage.AssertErrorMessage("Invalid credentials");
	}

	@When("user clicks on Forgot your password link")
	public void ForgotPassword() 
	{
		loginPage.ForgotPassword();
	}

	@Then("user should see the password reset page")
	public void VerifyPasswordRestPageLoaded() 
	{
		new PasswordResetPage(driver).AssertPageLoaded();		
	}
}
