package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.time.Duration;

public class LoginPage {
    
	WebDriver driver;

    private By usernameLocator = By.name("username");
    private By passwordLocator =  By.cssSelector("input[type='password']");
    private By loginButtonLocator = By.className("orangehrm-login-button");
    private By errorMessageLocator = By.cssSelector(".oxd-alert-content-text");
    private By forgotPasswordLocator = By.xpath("//p[normalize-space(.)='Forgot your password?']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    
    public void AssertPageLoaded()
	{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Login']")));
        Assert.assertNotNull(loginTitle, "Login Page did not loaded.");
    }

    public void EnterUsername(String username){
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void EnterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void Login(){
        driver.findElement(loginButtonLocator).click();
    }

    private String GetErrorMessage() 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        return errorElement.getText();
    }

    public void AssertErrorMessage(String expectedMessage) {
        String actualMessage = GetErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message did not match!");
    }


    public void ForgotPassword(){
        driver.findElement(forgotPasswordLocator).click();
    }
}
