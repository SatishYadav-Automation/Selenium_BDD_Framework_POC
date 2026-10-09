package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver driver;

	public void SetUp() 
	{
		if (driver == null)
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		}
	}

	public void TearDown()
	{
		if (driver != null) 
		{
			driver.quit();
			driver = null;
		}
	}

	public WebDriver getDriver() {
		return driver;
	}
}