package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndDataProvider extends TestBase {
	HomePage homeObj ;
	UserRegistrationPage registerObj;
	LoginPage loginObj;
	
	
	@DataProvider(name ="testData")
	public static Object [] [] userData()
	{
		
		return new Object [] [] 
				{
				{"Mahmoud" , "Azab" ,"Azab9@Azab.com","123456"},
				{"Mhmd" ,"Azab","Mhmd9@Mhmd.com","123456"}
				};
	}

	
	
	@Test (priority = 1 ,alwaysRun = true ,dataProvider = "testData")
	public void UserCanRegisterSuccessfully(String fName , String lName,String email,String password)
	{
		homeObj = new HomePage(driver);
		homeObj.openRegistrationPage();
		registerObj = new UserRegistrationPage(driver);
		registerObj.userRegistration(fName,lName,email,password,password);
		
		assertTrue(registerObj.successMessage.getText().contains("Your registration completed"));
		assertTrue(registerObj.logout_btn.getText().contains("Log out"));
		registerObj.userLogout();
	}
	

	

}
