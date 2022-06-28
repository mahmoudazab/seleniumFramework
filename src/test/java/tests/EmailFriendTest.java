package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {
	
	//1-Registration
	HomePage homeObj ;
	UserRegistrationPage registerObj;
	LoginPage loginObj;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchOBJ ;
	ProductDetailsPage detailsObj ;
	EmailPage email ;
	
	@Test (priority = 1 ,alwaysRun = true)
	public void UserCanRegisterSuccessfully()
	{
		homeObj = new HomePage(driver);
		homeObj.openRegistrationPage();
		registerObj = new UserRegistrationPage(driver);
		registerObj.userRegistration("Mahmoud", "Azab", "t9@Try.com", "123456", "123456");
		
		assertTrue(registerObj.successMessage.getText().contains("Your registration completed"));
	}
	//2-Search 
	
	@Test(priority = 2)
	public void UserCanSearchWithAutoSuggest ()
	{
		try {
			
			searchOBJ = new SearchPage(driver);
			searchOBJ.ProductSearchUsingAutoSuggest("MacB");
			detailsObj = new ProductDetailsPage(driver);
			assertEquals(detailsObj.productNameBreadCrumb.getText(), productName);
		} catch (Exception e) {
				System.out.println("Error Happened" + e.getMessage());
		}
	}
	
	//3-E-mail to Friend
	@Test(priority = 3)
	public void RegisteredUserCanSendTOFriend()
	{
		detailsObj.openSendEmail();
		email = new EmailPage(driver);
		email.SendEmailToFriend("aaa@aaa.com", "Hello My Frined");
		 assertTrue(email.messageNotification.getText().contains("Your message has been sent."));
		
	}
	
	
	
	//4-User Logout
	@Test (priority = 4)
	public void UserCanLogout ()
	{
		//registerObj = new UserRegistrationPage (driver);
		registerObj.userLogout();
	}
	
	
	

}
