package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithJavaFaker extends TestBase{
	
	HomePage homeObj ;
	UserRegistrationPage registerObj;
	LoginPage loginObj;
	Faker faker = new Faker();
	String firstname = faker.name().firstName();
	String lastname = faker.name().lastName();
	String email = faker.internet().emailAddress();
	String password = faker.internet().password();
	
	@Test (priority = 1 ,alwaysRun = true)
	public void UserCanRegisterSuccessfully()
	{
		homeObj = new HomePage(driver);
		homeObj.openRegistrationPage();
		registerObj = new UserRegistrationPage(driver);
		registerObj.userRegistration(firstname	,lastname, email, password, password);
		
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
		loginObj.userCanLogin(email	, password);
		//assertTrue(registerObj.logout_btn.getText().contains("Log out"));
	}
	
	

}
