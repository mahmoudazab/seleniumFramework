package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{
	HomePage homeObj ;
	UserRegistrationPage registerObj;
	MyAccountPage myAccountObj;
	LoginPage loginObj;
	String firstname = "Mahmoud";
	String lastName = "Azab";
	String e_mail= "T80@Test.com";
	String password ="123456";
	
	String newPassword = "654321" ;
	
	@Test (priority = 1 ,alwaysRun = true)
	public void UserCanRegisterSuccessfully()
	{
		homeObj = new HomePage(driver);
		homeObj.openRegistrationPage();
		registerObj = new UserRegistrationPage(driver);
		registerObj.userRegistration(firstname, lastName, e_mail, password, password);
		
		assertTrue(registerObj.successMessage.getText().contains("Your registration completed"));
	}
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void ResgistratedUserCanChangePassword() throws InterruptedException
	{
		registerObj.openMyAccountPage();
		myAccountObj = new MyAccountPage(driver);
		myAccountObj.OpenChangePassword();
		myAccountObj.ChangePassword(password, newPassword);
		//assertTrue(myAccountObj.result.getText().contains("Password was changed"));
		
		//Thread.sleep(2000);
	}
	@Test (dependsOnMethods = {"ResgistratedUserCanChangePassword"})
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
		loginObj.userCanLogin(e_mail, newPassword );
		//assertTrue(registerObj.logout_btn.getText().contains("Log out"));
	}

}
