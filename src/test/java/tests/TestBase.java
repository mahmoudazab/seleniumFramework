package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
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
		//Headless browser testing
		else if (browserName.equalsIgnoreCase("headless"))
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY
					,System.setProperty("phantomjs.binary.path"
							, System.getProperty("user.dir") + "\\drivers\\phantomjs.exe")) ;
			String [] phantomJsArgs = {"--web-security=no" , "--ignore-ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,phantomJsArgs);
 			driver = new PhantomJSDriver();
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
