package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndJSON extends TestBase {
	HomePage homeObj ;

	UserRegistrationPage registerObj;
	LoginPage loginObj;
	
	JsonDataReader json = new JsonDataReader();
	
	@Test (priority = 1 ,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws FileNotFoundException, IOException, ParseException
	{
		json.jsonReader();
		homeObj = new HomePage(driver);
		homeObj.openRegistrationPage();
		registerObj = new  UserRegistrationPage(driver);
		registerObj.userRegistration(json.firstname, json.lastname, json.email, json.password, json.password);
		
		assertTrue(registerObj.successMessage.getText().contains("Your registration completed"));
		registerObj.userLogout();
		homeObj.openLoginPage();
		loginObj = new LoginPage(driver);
		loginObj.userCanLogin(json.email, json.password);
		//assertTrue(registerObj.logout_btn.getText().contains("Log out"));
	}


}
