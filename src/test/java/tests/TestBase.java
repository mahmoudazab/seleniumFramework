package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.cucumber.testng.AbstractTestNGCucumberTests;


public class TestBase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver (@Optional("chrome") String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome"))
		{

			System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver ();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver" , System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver ();
			
		}
		else if (browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver" , System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver ();
		}
	
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.nopcommerce.com/");
		

	}

	@AfterSuite
	public void stopDriver ()
	{
		driver.quit();
	}


}
