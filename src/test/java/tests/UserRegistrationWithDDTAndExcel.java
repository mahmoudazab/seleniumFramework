package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndExcel extends TestBase{
	HomePage homeObj ;
	UserRegistrationPage registerObj;
	LoginPage loginObj;
	
	
	
	
	
	@DataProvider(name="ExcelData")
	public Object [] [] userRegistrationData () throws IOException
	{
		ExcelReader ER = new ExcelReader();
		
		
			return ER.getExcelData();
	
	}
	@Test (priority = 1 ,alwaysRun = true ,dataProvider = "ExcelData" )
	public void UserCanRegisterSuccessfully(String firstname , String lastname ,String email ,String password)
	{
		homeObj = new HomePage(driver);
		homeObj.openRegistrationPage();
		registerObj = new UserRegistrationPage(driver);
		registerObj.userRegistration(firstname,lastname,email,password,password);
		
		assertTrue(registerObj.successMessage.getText().contains("Your registration completed"));
		registerObj.userLogout();
		homeObj.openLoginPage();
		loginObj = new LoginPage(driver);
		loginObj.userCanLogin(email, password);
		//assertTrue(registerObj.logout_btn.getText().contains("Log out"));

	}

	
	
}
