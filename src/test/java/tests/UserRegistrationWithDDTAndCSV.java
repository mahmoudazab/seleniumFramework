package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndCSV extends TestBase {
	HomePage homeObj ;
	UserRegistrationPage registerObj;
	LoginPage loginObj;
	
	CSVReader reader ;
	
	
	
	
	@Test (priority = 1 ,alwaysRun = true  )
	public void UserCanRegisterSuccessfully() throws IOException
	{
		String CSV_file = System.getProperty("user.dir")+"\\src\\test\\java\\data\\Book1.csv";
		reader = new CSVReader(new FileReader(CSV_file));
		
		String [] csvCell ;
		
		while ((csvCell = reader.readNext()) != null)
		{
			String firstname = csvCell[0];
			String lastname = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];
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

}
