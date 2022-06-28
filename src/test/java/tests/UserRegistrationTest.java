package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase{
	
	HomePage homeObj ;
	UserRegistrationPage registerObj;
	LoginPage loginObj;
	@Test (priority = 1 ,alwaysRun = true)
	public void UserCanRegisterSuccessfully()
	{
		homeObj = new HomePage(driver);
		homeObj.openRegistrationPage();
		registerObj = new UserRegistrationPage(driver);
		registerObj.userRegistration("Mahmoud", "Azab", "T90@Try.com", "123456", "123456");
		
		assertTrue(registerObj.successMessage.getText().contains("Your registration completed"));
	}
	@Test (dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void UserCanLogout ()
	{
		//registerObj = new UserRegistrationPage (driver);
		registerObj.userLogout();
	}
	
	@Test (dependsOnMethods = { "UserCanLogout"})
	public void UserCanLogin()
	{
	//	loginObj = new LoginPage(driver);
		homeObj.openLoginPage();
		loginObj = new LoginPage(driver);
		loginObj.userCanLogin("T90@Try.com", "123456");
		//assertTrue(registerObj.logout_btn.getText().contains("Log out"));
	}
	
	

}
